package dal;

import java.util.*;

/** 
 SqlServer数据访问帮助类
*/
public final class SQLHelper
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 私有构造函数和方法
	private SQLHelper()
	{
	}
	/** 
	 将SqlParameter参数数组(参数值)分配给SqlCommand命令.
	 这个方法将给任何一个参数分配DBNull.Value;
	 该操作将阻止默认值的使用.
	 
	 @param command 命令名
	 @param commandParameters SqlParameters数组
	*/
	private static void AttachParameters(SqlCommand command, SqlParameter[] commandParameters)
	{
		if (command == null)
		{
			throw new NullPointerException("command");
		}
		if (commandParameters != null)
		{
			for (SqlParameter p : commandParameters)
			{
				if (p != null)
				{
					// 检查未分配值的输出参数,将其分配以DBNull.Value.
					if ((p.Direction == ParameterDirection.InputOutput || p.Direction == ParameterDirection.Input) && (p.Value == null))
					{
						p.Value = DBNull.Value;
					}
					command.Parameters.Add(p);
				}
			}
		}
	}

	/** 
	 将DataRow类型的列值分配到SqlParameter参数数组.
	 
	 @param commandParameters 要分配值的SqlParameter参数数组
	 @param dataRow 将要分配给存储过程参数的DataRow
	*/
	private static void AssignParameterValues(SqlParameter[] commandParameters, DataRow dataRow)
	{
		if ((commandParameters == null) || (dataRow == null))
		{
			return;
		}
		int i = 0;
		// 设置参数值
		for (SqlParameter commandParameter : commandParameters)
		{
			// 创建参数名称,如果不存在,只抛出一个异常.
			if (commandParameter.ParameterName == null || commandParameter.ParameterName.length() <= 1)
			{
				throw new RuntimeException(String.format("请提供参数%1$s一个有效的名称%2$s.", i, commandParameter.ParameterName));
			}
			// 从dataRow的表中获取为参数数组中数组名称的列的索引.
			// 如果存在和参数名称相同的列,则将列值赋给当前名称的参数.
			if (dataRow.Table.Columns.IndexOf(commandParameter.ParameterName.substring(1)) != -1)
			{
				commandParameter.Value = dataRow.get(commandParameter.ParameterName.substring(1));
			}
			i++;
		}
	}

	/** 
	 将一个对象数组分配给SqlParameter参数数组.
	 
	 @param commandParameters 要分配值的SqlParameter参数数组
	 @param parameterValues 将要分配给存储过程参数的对象数组
	*/
	private static void AssignParameterValues(SqlParameter[] commandParameters, Object[] parameterValues)
	{
		if ((commandParameters == null) || (parameterValues == null))
		{
			return;
		}
		// 确保对象数组个数与参数个数匹配,如果不匹配,抛出一个异常.
		if (commandParameters.length != parameterValues.length)
		{
			throw new IllegalArgumentException("参数值个数与参数不匹配.");
		}
		// 给参数赋值
		for (int i = 0, j = commandParameters.length; i < j; i++)
		{
			// If the current array value derives from IDbDataParameter, then assign its Value property
			if (parameterValues[i] instanceof IDbDataParameter)
			{
				IDbDataParameter paramInstance = (IDbDataParameter)parameterValues[i];
				if (paramInstance.Value == null)
				{
					commandParameters[i].Value = DBNull.Value;
				}
				else
				{
					commandParameters[i].Value = paramInstance.Value;
				}
			}
			else if (parameterValues[i] == null)
			{
				commandParameters[i].Value = DBNull.Value;
			}
			else
			{
				commandParameters[i].Value = parameterValues[i];
			}
		}
	}

	/** 
	 预处理用户提供的命令,数据库连接/事务/命令类型/参数
	 
	 @param command 要处理的SqlCommand
	 @param connection 数据库连接
	 @param transaction 一个有效的事务或者是null值
	 @param commandType 命令类型 (存储过程,命令文本, 其它.)
	 @param commandText 存储过程名或都T-SQL命令文本
	 @param commandParameters 和命令相关联的SqlParameter参数数组,如果没有参数为'null'
	 @param mustCloseConnection <c>true</c> 如果连接是打开的,则为true,其它情况下为false.
	*/
	private static void PrepareCommand(SqlCommand command, SqlConnection connection, SqlTransaction transaction, CommandType commandType, String commandText, SqlParameter[] commandParameters, tangible.OutObject<Boolean> mustCloseConnection)
	{
		if (command == null)
		{
			throw new NullPointerException("command");
		}
		if (commandText == null || commandText.length() == 0)
		{
			throw new NullPointerException("commandText");
		}
		// If the provided connection is not open, we will open it
		if (connection.State != ConnectionState.Open)
		{
			mustCloseConnection.outArgValue = true;
			connection.Open();
		}
		else
		{
			mustCloseConnection.outArgValue = false;
		}
		// 给命令分配一个数据库连接.
		command.Connection = connection;
		// 设置命令文本(存储过程名或SQL语句)
		command.CommandText = commandText;
		// 分配事务
		if (transaction != null)
		{
			if (transaction.Connection == null)
			{
				throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
			}
			command.Transaction = transaction;
		}
		// 设置命令类型.
		command.CommandType = commandType;
		// 分配命令参数
		if (commandParameters != null)
		{
			AttachParameters(command, commandParameters);
		}
		return;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 私有构造函数和方法结束

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteNonQuery命令
	/** 
	 执行指定连接字符串,类型的SqlCommand.
	 
	 
	 示例:  
	  int result = ExecuteNonQuery(connString, CommandType.StoredProcedure, "PublishOrders");
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本, 其它.)
	 @param commandText 存储过程名称或SQL语句
	 @return 返回命令影响的行数
	*/
	public static int ExecuteNonQuery(String connectionString, CommandType commandType, String commandText)
	{
		return ExecuteNonQuery(connectionString, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定连接字符串,类型的SqlCommand.如果没有提供参数,不返回结果.
	 
	 
	 示例:  
	  int result = ExecuteNonQuery(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本, 其它.)
	 @param commandText 存储过程名称或SQL语句
	 @param commandParameters SqlParameter参数数组
	 @return 返回命令影响的行数
	*/
	public static int ExecuteNonQuery(String connectionString, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		try (SqlConnection connection = new SqlConnection(connectionString))
		{
			connection.Open();
			return ExecuteNonQuery(connection, commandType, commandText, commandParameters);
		}
	}

	/** 
	 执行指定连接字符串的存储过程,将对象数组的值赋给存储过程参数,
	 此方法需要在参数缓存方法中探索参数并生成参数.
	 
	 
	 这个方法没有提供访问输出参数和返回值.
	 示例:  
	  int result = ExecuteNonQuery(connString, "PublishOrders", 24, 36);
	 
	 @param connectionString 一个有效的数据库连接字符串/param>
	 @param spName 存储过程名称
	 @param parameterValues 分配到存储过程输入参数的对象数组
	 @return 返回受影响的行数
	*/
	public static int ExecuteNonQuery(String connectionString, String spName, Object... parameterValues)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果存在参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从探索存储过程参数(加载到缓存)并分配给存储过程参数数组.
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteNonQuery(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数情况下
			return ExecuteNonQuery(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定数据库连接对象的命令 
	 
	 
	 示例:  
	  int result = ExecuteNonQuery(conn, CommandType.StoredProcedure, "PublishOrders");
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型(存储过程,命令文本或其它.)
	 @param commandText 存储过程名称或T-SQL语句
	 @return 返回影响的行数
	*/
	public static int ExecuteNonQuery(SqlConnection connection, CommandType commandType, String commandText)
	{
		return ExecuteNonQuery(connection, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库连接对象的命令
	 
	 
	 示例:  
	  int result = ExecuteNonQuery(conn, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型(存储过程,命令文本或其它.)
	 @param commandText T存储过程名称或T-SQL语句
	 @param commandParameters SqlParamter参数数组
	 @return 返回影响的行数
	*/
	public static int ExecuteNonQuery(SqlConnection connection, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		// 创建SqlCommand命令,并进行预处理
		SqlCommand cmd = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(cmd, connection, (SqlTransaction)null, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// Finally, execute the command
		int retval = cmd.ExecuteNonQuery();

		// 清除参数,以便再次使用.
		cmd.Parameters.Clear();
		if (mustCloseConnection)
		{
			connection.Close();
		}
		return retval;
	}

	/** 
	 执行指定数据库连接对象的命令,将对象数组的值赋给存储过程参数.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值
	 示例:  
	  int result = ExecuteNonQuery(conn, "PublishOrders", 24, 36);
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回影响的行数
	*/
	public static int ExecuteNonQuery(SqlConnection connection, String spName, Object... parameterValues)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);
			// 给存储过程分配参数值
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteNonQuery(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return ExecuteNonQuery(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行带事务的SqlCommand.
	 
	 
	 示例.:  
	  int result = ExecuteNonQuery(trans, CommandType.StoredProcedure, "PublishOrders");
	 
	 @param transaction 一个有效的数据库连接对象
	 @param commandType 命令类型(存储过程,命令文本或其它.)
	 @param commandText 存储过程名称或T-SQL语句
	 @return 返回影响的行数/returns>
	*/
	public static int ExecuteNonQuery(SqlTransaction transaction, CommandType commandType, String commandText)
	{
		return ExecuteNonQuery(transaction, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行带事务的SqlCommand(指定参数).
	 
	 
	 示例:  
	  int result = ExecuteNonQuery(trans, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param transaction 一个有效的数据库连接对象
	 @param commandType 命令类型(存储过程,命令文本或其它.)
	 @param commandText 存储过程名称或T-SQL语句
	 @param commandParameters SqlParamter参数数组
	 @return 返回影响的行数
	*/
	public static int ExecuteNonQuery(SqlTransaction transaction, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		// 预处理
		SqlCommand cmd = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(cmd, transaction.Connection, transaction, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// 执行
		int retval = cmd.ExecuteNonQuery();

		// 清除参数集,以便再次使用.
		cmd.Parameters.Clear();
		return retval;
	}

	/** 
	 执行带事务的SqlCommand(指定参数值).
	 
	 
	 此方法不提供访问存储过程输出参数和返回值
	 示例:  
	  int result = ExecuteNonQuery(conn, trans, "PublishOrders", 24, 36);
	 
	 @param transaction 一个有效的数据库连接对象
	 @param spName 存储过程名
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回受影响的行数
	*/
	public static int ExecuteNonQuery(SqlTransaction transaction, String spName, Object... parameterValues)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			return ExecuteNonQuery(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数值
			return ExecuteNonQuery(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion ExecuteNonQuery方法结束

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteDataset方法
	/** 
	 执行指定数据库连接字符串的命令,返回DataSet.
	 
	 
	 示例:  
	  DataSet ds = ExecuteDataset(connString, CommandType.StoredProcedure, "GetOrders");
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(String connectionString, CommandType commandType, String commandText)
	{
		return ExecuteDataset(connectionString, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库连接字符串的命令,返回DataSet.
	 
	 
	 示例: 
	  DataSet ds = ExecuteDataset(connString, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param commandParameters SqlParamters参数数组
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(String connectionString, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		// 创建并打开数据库连接对象,操作完成释放对象.
		try (SqlConnection connection = new SqlConnection(connectionString))
		{
			connection.Open();
			// 调用指定数据库连接字符串重载方法.
			return ExecuteDataset(connection, commandType, commandText, commandParameters);
		}
	}

	/** 
	 执行指定数据库连接字符串的命令,直接提供参数值,返回DataSet.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值.
	 示例: 
	  DataSet ds = ExecuteDataset(connString, "GetOrders", 24, 36);
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(String connectionString, String spName, Object... parameterValues)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}

		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中检索存储过程参数
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);
			// 给存储过程参数分配值
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteDataset(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return ExecuteDataset(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定数据库连接对象的命令,返回DataSet.
	 
	 
	 示例:  
	  DataSet ds = ExecuteDataset(conn, CommandType.StoredProcedure, "GetOrders");
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(SqlConnection connection, CommandType commandType, String commandText)
	{
		return ExecuteDataset(connection, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库连接对象的命令,指定存储过程参数,返回DataSet.
	 
	 
	 示例:  
	  DataSet ds = ExecuteDataset(conn, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @param commandParameters SqlParamter参数数组
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(SqlConnection connection, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		// 预处理
		SqlCommand cmd = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(cmd, connection, (SqlTransaction)null, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// 创建SqlDataAdapter和DataSet.
		try (SqlDataAdapter da = new SqlDataAdapter(cmd))
		{
			DataSet ds = new DataSet();
			// 填充DataSet.
			da.Fill(ds);

			cmd.Parameters.Clear();
			if (mustCloseConnection)
			{
				connection.Close();
			}
			return ds;
		}
	}

	/** 
	 执行指定数据库连接对象的命令,指定参数值,返回DataSet.
	 
	 
	 此方法不提供访问存储过程输入参数和返回值.
	 示例.:  
	  DataSet ds = ExecuteDataset(conn, "GetOrders", 24, 36);
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(SqlConnection connection, String spName, Object... parameterValues)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 比缓存中加载存储过程参数
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);
			// 给存储过程参数分配值
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteDataset(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return ExecuteDataset(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定事务的命令,返回DataSet.
	 
	 
	 示例:  
	  DataSet ds = ExecuteDataset(trans, CommandType.StoredProcedure, "GetOrders");
	 
	 @param transaction 事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(SqlTransaction transaction, CommandType commandType, String commandText)
	{
		return ExecuteDataset(transaction, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定事务的命令,指定参数,返回DataSet.
	 
	 
	 示例:  
	  DataSet ds = ExecuteDataset(trans, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param transaction 事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @param commandParameters SqlParamter参数数组
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(SqlTransaction transaction, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		// 预处理
		SqlCommand cmd = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(cmd, transaction.Connection, transaction, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// 创建 DataAdapter & DataSet
		try (SqlDataAdapter da = new SqlDataAdapter(cmd))
		{
			DataSet ds = new DataSet();
			da.Fill(ds);
			cmd.Parameters.Clear();
			return ds;
		}
	}

	/** 
	 执行指定事务的命令,指定参数值,返回DataSet.
	 
	 
	 此方法不提供访问存储过程输入参数和返回值.
	 示例.:  
	  DataSet ds = ExecuteDataset(trans, "GetOrders", 24, 36);
	 
	 @param transaction 事务
	 @param spName 存储过程名
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回一个包含结果集的DataSet
	*/
	public static DataSet ExecuteDataset(SqlTransaction transaction, String spName, Object... parameterValues)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}

		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);
			// 给存储过程参数分配值
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteDataset(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return ExecuteDataset(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion ExecuteDataset数据集命令结束

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteReader 数据阅读器
	/** 
	 枚举,标识数据库连接是由SQLHelper提供还是由调用者提供
	*/
	private enum SqlConnectionOwnership
	{
		/** 由SQLHelper提供连接
		*/
		Internal,
		/** 由调用者提供连接
		*/
		External;

		public static final int SIZE = java.lang.Integer.SIZE;

		public int getValue()
		{
			return this.ordinal();
		}

		public static SqlConnectionOwnership forValue(int value)
		{
			return values()[value];
		}
	}

	/** 
	 执行指定数据库连接对象的数据阅读器.
	 
	 
	 如果是SQLHelper打开连接,当连接关闭DataReader也将关闭.
	 如果是调用都打开连接,DataReader由调用都管理.
	 
	 @param connection 一个有效的数据库连接对象
	 @param transaction 一个有效的事务,或者为 'null'
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @param commandParameters SqlParameters参数数组,如果没有参数则为'null'
	 @param connectionOwnership 标识数据库连接对象是由调用者提供还是由SQLHelper提供
	 @return 返回包含结果集的SqlDataReader
	*/
	private static SqlDataReader ExecuteReader(SqlConnection connection, SqlTransaction transaction, CommandType commandType, String commandText, SqlParameter[] commandParameters, SqlConnectionOwnership connectionOwnership)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		boolean mustCloseConnection = false;
		// 创建命令
		SqlCommand cmd = new SqlCommand();
		try
		{
			tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
			PrepareCommand(cmd, connection, transaction, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
		mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

			// 创建数据阅读器
			SqlDataReader dataReader;
			if (connectionOwnership == SqlConnectionOwnership.External)
			{
				dataReader = cmd.ExecuteReader();
			}
			else
			{
				dataReader = cmd.ExecuteReader(CommandBehavior.CloseConnection);
			}

			// 清除参数,以便再次使用..
			// HACK: There is a problem here, the output parameter values are fletched 
			// when the reader is closed, so if the parameters are detached from the command
			// then the SqlReader can磘 set its values. 
			// When this happen, the parameters can磘 be used again in other command.
			boolean canClear = true;
			for (SqlParameter commandParameter : cmd.Parameters)
			{
				if (commandParameter.Direction != ParameterDirection.Input)
				{
					canClear = false;
				}
			}

			if (canClear)
			{
				cmd.Parameters.Clear();
			}
			return dataReader;
		}
		catch (java.lang.Exception e)
		{
			if (mustCloseConnection)
			{
				connection.Close();
			}
			throw e;
		}
	}

	/** 
	 执行指定数据库连接字符串的数据阅读器.
	 
	 
	 示例:  
	  SqlDataReader dr = ExecuteReader(connString, CommandType.StoredProcedure, "GetOrders");
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(String connectionString, CommandType commandType, String commandText)
	{
		return ExecuteReader(connectionString, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库连接字符串的数据阅读器,指定参数.
	 
	 
	 示例:  
	  SqlDataReader dr = ExecuteReader(connString, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @param commandParameters SqlParamter参数数组(new SqlParameter("@prodid", 24))
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(String connectionString, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		SqlConnection connection = null;
		try
		{
			connection = new SqlConnection(connectionString);
			connection.Open();
			return ExecuteReader(connection, null, commandType, commandText, commandParameters, SqlConnectionOwnership.Internal);
		}
		catch (java.lang.Exception e)
		{
			// If we fail to return the SqlDatReader, we need to close the connection ourselves
			if (connection != null)
			{
				connection.Close();
			}
			throw e;
		}

	}

	/** 
	 执行指定数据库连接字符串的数据阅读器,指定参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 示例:  
	  SqlDataReader dr = ExecuteReader(connString, "GetOrders", 24, 36);
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(String connectionString, String spName, Object... parameterValues)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}

		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteReader(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return ExecuteReader(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定数据库连接对象的数据阅读器.
	 
	 
	 示例:  
	  SqlDataReader dr = ExecuteReader(conn, CommandType.StoredProcedure, "GetOrders");
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名或T-SQL语句
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(SqlConnection connection, CommandType commandType, String commandText)
	{
		return ExecuteReader(connection, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 [调用者方式]执行指定数据库连接对象的数据阅读器,指定参数.
	 
	 
	 示例:  
	  SqlDataReader dr = ExecuteReader(conn, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 命令类型 (存储过程,命令文本或其它)
	 @param commandParameters SqlParamter参数数组
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(SqlConnection connection, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		return ExecuteReader(connection, (SqlTransaction)null, commandType, commandText, commandParameters, SqlConnectionOwnership.External);
	}

	/** 
	 [调用者方式]执行指定数据库连接对象的数据阅读器,指定参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 示例:  
	  SqlDataReader dr = ExecuteReader(conn, "GetOrders", 24, 36);
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName T存储过程名
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(SqlConnection connection, String spName, Object... parameterValues)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteReader(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return ExecuteReader(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 [调用者方式]执行指定数据库事务的数据阅读器,指定参数值.
	 
	 
	 示例:  
	  SqlDataReader dr = ExecuteReader(trans, CommandType.StoredProcedure, "GetOrders");
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(SqlTransaction transaction, CommandType commandType, String commandText)
	{
		return ExecuteReader(transaction, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 [调用者方式]执行指定数据库事务的数据阅读器,指定参数.
	 
	 
	 示例:  
	   SqlDataReader dr = ExecuteReader(trans, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param commandParameters 分配给命令的SqlParamter参数数组
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(SqlTransaction transaction, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		return ExecuteReader(transaction.Connection, transaction, commandType, commandText, commandParameters, SqlConnectionOwnership.External);
	}

	/** 
	 [调用者方式]执行指定数据库事务的数据阅读器,指定参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  SqlDataReader dr = ExecuteReader(trans, "GetOrders", 24, 36);
	 
	 @param transaction 一个有效的连接事务
	 @param spName 存储过程名称
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReader(SqlTransaction transaction, String spName, Object... parameterValues)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);
			AssignParameterValues(commandParameters, parameterValues);
			return ExecuteReader(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数值
			return ExecuteReader(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion ExecuteReader数据阅读器

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteScalar 返回结果集中的第一行第一列
	/** 
	 执行指定数据库连接字符串的命令,返回结果集中的第一行第一列.
	 
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(connString, CommandType.StoredProcedure, "GetOrderCount");
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(String connectionString, CommandType commandType, String commandText)
	{
		// 执行参数为空的方法
		return ExecuteScalar(connectionString, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库连接字符串的命令,指定参数,返回结果集中的第一行第一列.
	 
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(connString, CommandType.StoredProcedure, "GetOrderCount", new SqlParameter("@prodid", 24));
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param commandParameters 分配给命令的SqlParamter参数数组
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(String connectionString, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		// 创建并打开数据库连接对象,操作完成释放对象.
		try (SqlConnection connection = new SqlConnection(connectionString))
		{
			connection.Open();
			// 调用指定数据库连接字符串重载方法.
			return ExecuteScalar(connection, commandType, commandText, commandParameters);
		}
	}

	/** 
	 执行指定数据库连接字符串的命令,指定参数值,返回结果集中的第一行第一列.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(connString, "GetOrderCount", 24, 36);
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名称
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(String connectionString, String spName, Object... parameterValues)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}

		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			return ExecuteScalar(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数值
			return ExecuteScalar(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定数据库连接对象的命令,返回结果集中的第一行第一列.
	 
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(conn, CommandType.StoredProcedure, "GetOrderCount");
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(SqlConnection connection, CommandType commandType, String commandText)
	{
		// 执行参数为空的方法
		return ExecuteScalar(connection, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库连接对象的命令,指定参数,返回结果集中的第一行第一列.
	 
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(conn, CommandType.StoredProcedure, "GetOrderCount", new SqlParameter("@prodid", 24));
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param commandParameters 分配给命令的SqlParamter参数数组
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(SqlConnection connection, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		// 创建SqlCommand命令,并进行预处理
		SqlCommand cmd = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(cmd, connection, (SqlTransaction)null, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// 执行SqlCommand命令,并返回结果.
		Object retval = cmd.ExecuteScalar();

		// 清除参数,以便再次使用.
		cmd.Parameters.Clear();
		if (mustCloseConnection)
		{
			connection.Close();
		}
		return retval;
	}

	/** 
	 执行指定数据库连接对象的命令,指定参数值,返回结果集中的第一行第一列.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(conn, "GetOrderCount", 24, 36);
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(SqlConnection connection, String spName, Object... parameterValues)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			return ExecuteScalar(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数值
			return ExecuteScalar(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定数据库事务的命令,返回结果集中的第一行第一列.
	 
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(trans, CommandType.StoredProcedure, "GetOrderCount");
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(SqlTransaction transaction, CommandType commandType, String commandText)
	{
		// 执行参数为空的方法
		return ExecuteScalar(transaction, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库事务的命令,指定参数,返回结果集中的第一行第一列.
	 
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(trans, CommandType.StoredProcedure, "GetOrderCount", new SqlParameter("@prodid", 24));
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param commandParameters 分配给命令的SqlParamter参数数组
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(SqlTransaction transaction, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		// 创建SqlCommand命令,并进行预处理
		SqlCommand cmd = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(cmd, transaction.Connection, transaction, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// 执行SqlCommand命令,并返回结果.
		Object retval = cmd.ExecuteScalar();

		// 清除参数,以便再次使用.
		cmd.Parameters.Clear();
		return retval;
	}

	/** 
	 执行指定数据库事务的命令,指定参数值,返回结果集中的第一行第一列.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  int orderCount = (int)ExecuteScalar(trans, "GetOrderCount", 24, 36);
	 
	 @param transaction 一个有效的连接事务
	 @param spName 存储过程名称
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalar(SqlTransaction transaction, String spName, Object... parameterValues)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// PPull the parameters for this stored procedure from the parameter cache ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			return ExecuteScalar(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数值
			return ExecuteScalar(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion ExecuteScalar

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteXmlReader XML阅读器
	/** 
	 执行指定数据库连接对象的SqlCommand命令,并产生一个XmlReader对象做为结果集返回.
	 
	 
	 示例:  
	  XmlReader r = ExecuteXmlReader(conn, CommandType.StoredProcedure, "GetOrders");
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句 using "FOR XML AUTO"
	 @return 返回XmlReader结果集对象.
	*/
	public static XmlReader ExecuteXmlReader(SqlConnection connection, CommandType commandType, String commandText)
	{
		// 执行参数为空的方法
		return ExecuteXmlReader(connection, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库连接对象的SqlCommand命令,并产生一个XmlReader对象做为结果集返回,指定参数.
	 
	 
	 示例:  
	  XmlReader r = ExecuteXmlReader(conn, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句 using "FOR XML AUTO"
	 @param commandParameters 分配给命令的SqlParamter参数数组
	 @return 返回XmlReader结果集对象.
	*/
	public static XmlReader ExecuteXmlReader(SqlConnection connection, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		boolean mustCloseConnection = false;
		// 创建SqlCommand命令,并进行预处理
		SqlCommand cmd = new SqlCommand();
		try
		{
			tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
			PrepareCommand(cmd, connection, (SqlTransaction)null, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
		mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

			// 执行命令
			XmlReader retval = cmd.ExecuteXmlReader();

			// 清除参数,以便再次使用.
			cmd.Parameters.Clear();
			return retval;
		}
		catch (java.lang.Exception e)
		{
			if (mustCloseConnection)
			{
				connection.Close();
			}
			throw e;
		}
	}

	/** 
	 执行指定数据库连接对象的SqlCommand命令,并产生一个XmlReader对象做为结果集返回,指定参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  XmlReader r = ExecuteXmlReader(conn, "GetOrders", 24, 36);
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称 using "FOR XML AUTO"
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回XmlReader结果集对象.
	*/
	public static XmlReader ExecuteXmlReader(SqlConnection connection, String spName, Object... parameterValues)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			return ExecuteXmlReader(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数值
			return ExecuteXmlReader(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定数据库事务的SqlCommand命令,并产生一个XmlReader对象做为结果集返回.
	 
	 
	 示例:  
	  XmlReader r = ExecuteXmlReader(trans, CommandType.StoredProcedure, "GetOrders");
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句 using "FOR XML AUTO"
	 @return 返回XmlReader结果集对象.
	*/
	public static XmlReader ExecuteXmlReader(SqlTransaction transaction, CommandType commandType, String commandText)
	{
		// 执行参数为空的方法
		return ExecuteXmlReader(transaction, commandType, commandText, (SqlParameter[])null);
	}

	/** 
	 执行指定数据库事务的SqlCommand命令,并产生一个XmlReader对象做为结果集返回,指定参数.
	 
	 
	 示例:  
	  XmlReader r = ExecuteXmlReader(trans, CommandType.StoredProcedure, "GetOrders", new SqlParameter("@prodid", 24));
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句 using "FOR XML AUTO"
	 @param commandParameters 分配给命令的SqlParamter参数数组
	 @return 返回XmlReader结果集对象.
	*/
	public static XmlReader ExecuteXmlReader(SqlTransaction transaction, CommandType commandType, String commandText, SqlParameter... commandParameters)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		// 创建SqlCommand命令,并进行预处理
		SqlCommand cmd = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(cmd, transaction.Connection, transaction, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// 执行命令
		XmlReader retval = cmd.ExecuteXmlReader();

		// 清除参数,以便再次使用.
		cmd.Parameters.Clear();
		return retval;
	}

	/** 
	 执行指定数据库事务的SqlCommand命令,并产生一个XmlReader对象做为结果集返回,指定参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  XmlReader r = ExecuteXmlReader(trans, "GetOrders", 24, 36);
	 
	 @param transaction 一个有效的连接事务
	 @param spName 存储过程名称
	 @param parameterValues 分配给存储过程输入参数的对象数组
	 @return 返回一个包含结果集的DataSet.
	*/
	public static XmlReader ExecuteXmlReader(SqlTransaction transaction, String spName, Object... parameterValues)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			return ExecuteXmlReader(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			// 没有参数值
			return ExecuteXmlReader(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion ExecuteXmlReader 阅读器结束

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region FillDataset 填充数据集
	/** 
	 执行指定数据库连接字符串的命令,映射数据表并填充数据集.
	 
	 
	 示例:  
	  FillDataset(connString, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"});
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	*/
	public static void FillDataset(String connectionString, CommandType commandType, String commandText, DataSet dataSet, String[] tableNames)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (dataSet == null)
		{
			throw new NullPointerException("dataSet");
		}

		// 创建并打开数据库连接对象,操作完成释放对象.
		try (SqlConnection connection = new SqlConnection(connectionString))
		{
			connection.Open();
			// 调用指定数据库连接字符串重载方法.
			FillDataset(connection, commandType, commandText, dataSet, tableNames);
		}
	}

	/** 
	 执行指定数据库连接字符串的命令,映射数据表并填充数据集.指定命令参数.
	 
	 
	 示例:  
	  FillDataset(connString, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"}, new SqlParameter("@prodid", 24));
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param commandParameters 分配给命令的SqlParamter参数数组
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	 
	*/
	public static void FillDataset(String connectionString, CommandType commandType, String commandText, DataSet dataSet, String[] tableNames, SqlParameter... commandParameters)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (dataSet == null)
		{
			throw new NullPointerException("dataSet");
		}
		// 创建并打开数据库连接对象,操作完成释放对象.
		try (SqlConnection connection = new SqlConnection(connectionString))
		{
			connection.Open();
			// 调用指定数据库连接字符串重载方法.
			FillDataset(connection, commandType, commandText, dataSet, tableNames, commandParameters);
		}
	}

	/** 
	 执行指定数据库连接字符串的命令,映射数据表并填充数据集,指定存储过程参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  FillDataset(connString, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"}, 24);
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名称
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
		 
	 @param parameterValues 分配给存储过程输入参数的对象数组
	*/
	public static void FillDataset(String connectionString, String spName, DataSet dataSet, String[] tableNames, Object... parameterValues)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (dataSet == null)
		{
			throw new NullPointerException("dataSet");
		}
		// 创建并打开数据库连接对象,操作完成释放对象.
		try (SqlConnection connection = new SqlConnection(connectionString))
		{
			connection.Open();
			// 调用指定数据库连接字符串重载方法.
			FillDataset(connection, spName, dataSet, tableNames, parameterValues);
		}
	}

	/** 
	 执行指定数据库连接对象的命令,映射数据表并填充数据集.
	 
	 
	 示例:  
	  FillDataset(conn, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"});
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
		 
	*/
	public static void FillDataset(SqlConnection connection, CommandType commandType, String commandText, DataSet dataSet, String[] tableNames)
	{
		FillDataset(connection, commandType, commandText, dataSet, tableNames, null);
	}

	/** 
	 执行指定数据库连接对象的命令,映射数据表并填充数据集,指定参数.
	 
	 
	 示例:  
	  FillDataset(conn, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"}, new SqlParameter("@prodid", 24));
	 
	 @param connection 一个有效的数据库连接对象
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	 
	 @param commandParameters 分配给命令的SqlParamter参数数组
	*/
	public static void FillDataset(SqlConnection connection, CommandType commandType, String commandText, DataSet dataSet, String[] tableNames, SqlParameter... commandParameters)
	{
		FillDataset(connection, null, commandType, commandText, dataSet, tableNames, commandParameters);
	}

	/** 
	 执行指定数据库连接对象的命令,映射数据表并填充数据集,指定存储过程参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  FillDataset(conn, "GetOrders", ds, new string[] {"orders"}, 24, 36);
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	 
	 @param parameterValues 分配给存储过程输入参数的对象数组
	*/
	public static void FillDataset(SqlConnection connection, String spName, DataSet dataSet, String[] tableNames, Object... parameterValues)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (dataSet == null)
		{
			throw new NullPointerException("dataSet");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			FillDataset(connection, CommandType.StoredProcedure, spName, dataSet, tableNames, commandParameters);
		}
		else
		{
			// 没有参数值
			FillDataset(connection, CommandType.StoredProcedure, spName, dataSet, tableNames);
		}
	}

	/** 
	 执行指定数据库事务的命令,映射数据表并填充数据集.
	 
	 
	 示例:  
	  FillDataset(trans, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"});
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	 
	*/
	public static void FillDataset(SqlTransaction transaction, CommandType commandType, String commandText, DataSet dataSet, String[] tableNames)
	{
		FillDataset(transaction, commandType, commandText, dataSet, tableNames, null);
	}

	/** 
	 执行指定数据库事务的命令,映射数据表并填充数据集,指定参数.
	 
	 
	 示例:  
	  FillDataset(trans, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"}, new SqlParameter("@prodid", 24));
	 
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	 
	 @param commandParameters 分配给命令的SqlParamter参数数组
	*/
	public static void FillDataset(SqlTransaction transaction, CommandType commandType, String commandText, DataSet dataSet, String[] tableNames, SqlParameter... commandParameters)
	{
		FillDataset(transaction.Connection, transaction, commandType, commandText, dataSet, tableNames, commandParameters);
	}

	/** 
	 执行指定数据库事务的命令,映射数据表并填充数据集,指定存储过程参数值.
	 
	 
	 此方法不提供访问存储过程输出参数和返回值参数.
	 
	 示例:  
	  FillDataset(trans, "GetOrders", ds, new string[]{"orders"}, 24, 36);
	 
	 @param transaction 一个有效的连接事务
	 @param spName 存储过程名称
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	 
	 @param parameterValues 分配给存储过程输入参数的对象数组
	*/
	public static void FillDataset(SqlTransaction transaction, String spName, DataSet dataSet, String[] tableNames, Object... parameterValues)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (dataSet == null)
		{
			throw new NullPointerException("dataSet");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果有参数值
		if ((parameterValues != null) && (parameterValues.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);
			// 给存储过程参数赋值
			AssignParameterValues(commandParameters, parameterValues);
			// 调用重载方法
			FillDataset(transaction, CommandType.StoredProcedure, spName, dataSet, tableNames, commandParameters);
		}
		else
		{
			// 没有参数值
			FillDataset(transaction, CommandType.StoredProcedure, spName, dataSet, tableNames);
		}
	}

	/** 
	 [私有方法][内部调用]执行指定数据库连接对象/事务的命令,映射数据表并填充数据集,DataSet/TableNames/SqlParameters.
	 
	 
	 示例:  
	  FillDataset(conn, trans, CommandType.StoredProcedure, "GetOrders", ds, new string[] {"orders"}, new SqlParameter("@prodid", 24));
	 
	 @param connection 一个有效的数据库连接对象
	 @param transaction 一个有效的连接事务
	 @param commandType 命令类型 (存储过程,命令文本或其它)
	 @param commandText 存储过程名称或T-SQL语句
	 @param dataSet 要填充结果集的DataSet实例
	 @param tableNames 表映射的数据表数组
	 用户定义的表名 (可有是实际的表名.)
	 
	 @param commandParameters 分配给命令的SqlParamter参数数组
	*/
	private static void FillDataset(SqlConnection connection, SqlTransaction transaction, CommandType commandType, String commandText, DataSet dataSet, String[] tableNames, SqlParameter... commandParameters)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (dataSet == null)
		{
			throw new NullPointerException("dataSet");
		}
		// 创建SqlCommand命令,并进行预处理
		SqlCommand command = new SqlCommand();
		boolean mustCloseConnection = false;
		tangible.OutObject<Boolean> tempOut_mustCloseConnection = new tangible.OutObject<Boolean>();
		PrepareCommand(command, connection, transaction, commandType, commandText, commandParameters, tempOut_mustCloseConnection);
	mustCloseConnection = tempOut_mustCloseConnection.outArgValue;

		// 执行命令
		try (SqlDataAdapter dataAdapter = new SqlDataAdapter(command))
		{

			// 追加表映射
			if (tableNames != null && tableNames.length > 0)
			{
				String tableName = "Table";
				for (int index = 0; index < tableNames.length; index++)
				{
					if (tableNames[index] == null || tableNames[index].length() == 0)
					{
						throw new IllegalArgumentException("The tableNames parameter must contain a list of tables, a value was provided as null or empty string.", "tableNames");
					}
					dataAdapter.TableMappings.Add(tableName, tableNames[index]);
					tableName += (String.valueOf(index);
				}
			}

			// 填充数据集使用默认表名称
			dataAdapter.Fill(dataSet);
			// 清除参数,以便再次使用.
			command.Parameters.Clear();
		}
		if (mustCloseConnection)
		{
			connection.Close();
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region UpdateDataset 更新数据集
	/** 
	 执行数据集更新到数据库,指定inserted, updated, or deleted命令.
	 
	 
	 示例:  
	  UpdateDataset(conn, insertCommand, deleteCommand, updateCommand, dataSet, "Order");
	 
	 @param insertCommand [追加记录]一个有效的T-SQL语句或存储过程
	 @param deleteCommand [删除记录]一个有效的T-SQL语句或存储过程
	 @param updateCommand [更新记录]一个有效的T-SQL语句或存储过程
	 @param dataSet 要更新到数据库的DataSet
	 @param tableName 要更新到数据库的DataTable
	*/
	public static void UpdateDataset(SqlCommand insertCommand, SqlCommand deleteCommand, SqlCommand updateCommand, DataSet dataSet, String tableName)
	{
		if (insertCommand == null)
		{
			throw new NullPointerException("insertCommand");
		}
		if (deleteCommand == null)
		{
			throw new NullPointerException("deleteCommand");
		}
		if (updateCommand == null)
		{
			throw new NullPointerException("updateCommand");
		}
		if (tableName == null || tableName.length() == 0)
		{
			throw new NullPointerException("tableName");
		}
		// 创建SqlDataAdapter,当操作完成后释放.
		try (SqlDataAdapter dataAdapter = new SqlDataAdapter())
		{
			// 设置数据适配器命令
			dataAdapter.UpdateCommand = updateCommand;
			dataAdapter.InsertCommand = insertCommand;
			dataAdapter.DeleteCommand = deleteCommand;
			// 更新数据集改变到数据库
			dataAdapter.Update(dataSet, tableName);
			// 提交所有改变到数据集.
			dataSet.AcceptChanges();
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region CreateCommand 创建一条SqlCommand命令
	/** 
	 创建SqlCommand命令,指定数据库连接对象,存储过程名和参数.
	 
	 
	 示例:  
	  SqlCommand command = CreateCommand(conn, "AddCustomer", "CustomerID", "CustomerName");
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param sourceColumns 源表的列名称数组
	 @return 返回SqlCommand命令
	*/
	public static SqlCommand CreateCommand(SqlConnection connection, String spName, String... sourceColumns)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 创建命令
		SqlCommand cmd = new SqlCommand(spName, connection);
		cmd.CommandType = CommandType.StoredProcedure;
		// 如果有参数值
		if ((sourceColumns != null) && (sourceColumns.length > 0))
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);
			// 将源表的列到映射到DataSet命令中.
			for (int index = 0; index < sourceColumns.length; index++)
			{
				commandParameters[index].SourceColumn = sourceColumns[index];
			}
			// Attach the discovered parameters to the SqlCommand object
			AttachParameters(cmd, commandParameters);
		}
		return cmd;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteNonQueryTypedParams 类型化参数(DataRow)
	/** 
	 执行指定连接数据库连接字符串的存储过程,使用DataRow做为参数值,返回受影响的行数.
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回影响的行数
	*/
	public static int ExecuteNonQueryTypedParams(String connectionString, String spName, DataRow dataRow)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}

		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteNonQuery(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteNonQuery(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库连接对象的存储过程,使用DataRow做为参数值,返回受影响的行数.
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回影响的行数
	*/
	public static int ExecuteNonQueryTypedParams(SqlConnection connection, String spName, DataRow dataRow)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteNonQuery(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteNonQuery(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库事物的存储过程,使用DataRow做为参数值,返回受影响的行数.
	 
	 @param transaction 一个有效的连接事务 object
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回影响的行数
	*/
	public static int ExecuteNonQueryTypedParams(SqlTransaction transaction, String spName, DataRow dataRow)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// Sf the row has values, the store procedure parameters must be initialized
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteNonQuery(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteNonQuery(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteDatasetTypedParams 类型化参数(DataRow)
	/** 
	 执行指定连接数据库连接字符串的存储过程,使用DataRow做为参数值,返回DataSet.
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回一个包含结果集的DataSet.
	*/
	public static DataSet ExecuteDatasetTypedParams(String connectionString, String spName, DataRow dataRow)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		//如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteDataset(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteDataset(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库连接对象的存储过程,使用DataRow做为参数值,返回DataSet.
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回一个包含结果集的DataSet.
	 
	*/
	public static DataSet ExecuteDatasetTypedParams(SqlConnection connection, String spName, DataRow dataRow)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteDataset(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteDataset(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库事务的存储过程,使用DataRow做为参数值,返回DataSet.
	 
	 @param transaction 一个有效的连接事务 object
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回一个包含结果集的DataSet.
	*/
	public static DataSet ExecuteDatasetTypedParams(SqlTransaction transaction, String spName, DataRow dataRow)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteDataset(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteDataset(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteReaderTypedParams 类型化参数(DataRow)
	/** 
	 执行指定连接数据库连接字符串的存储过程,使用DataRow做为参数值,返回DataReader.
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReaderTypedParams(String connectionString, String spName, DataRow dataRow)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}

		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteReader(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteReader(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库连接对象的存储过程,使用DataRow做为参数值,返回DataReader.
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReaderTypedParams(SqlConnection connection, String spName, DataRow dataRow)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteReader(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteReader(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库事物的存储过程,使用DataRow做为参数值,返回DataReader.
	 
	 @param transaction 一个有效的连接事务 object
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回包含结果集的SqlDataReader
	*/
	public static SqlDataReader ExecuteReaderTypedParams(SqlTransaction transaction, String spName, DataRow dataRow)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteReader(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteReader(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteScalarTypedParams 类型化参数(DataRow)
	/** 
	 执行指定连接数据库连接字符串的存储过程,使用DataRow做为参数值,返回结果集中的第一行第一列.
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalarTypedParams(String connectionString, String spName, DataRow dataRow)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}

		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connectionString, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteScalar(connectionString, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteScalar(connectionString, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库连接对象的存储过程,使用DataRow做为参数值,返回结果集中的第一行第一列.
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalarTypedParams(SqlConnection connection, String spName, DataRow dataRow)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteScalar(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteScalar(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库事务的存储过程,使用DataRow做为参数值,返回结果集中的第一行第一列.
	 
	 @param transaction 一个有效的连接事务 object
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回结果集中的第一行第一列
	*/
	public static Object ExecuteScalarTypedParams(SqlTransaction transaction, String spName, DataRow dataRow)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteScalar(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteScalar(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region ExecuteXmlReaderTypedParams 类型化参数(DataRow)
	/** 
	 执行指定连接数据库连接对象的存储过程,使用DataRow做为参数值,返回XmlReader类型的结果集.
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回XmlReader结果集对象.
	*/
	public static XmlReader ExecuteXmlReaderTypedParams(SqlConnection connection, String spName, DataRow dataRow)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteXmlReader(connection, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteXmlReader(connection, CommandType.StoredProcedure, spName);
		}
	}

	/** 
	 执行指定连接数据库事务的存储过程,使用DataRow做为参数值,返回XmlReader类型的结果集.
	 
	 @param transaction 一个有效的连接事务 object
	 @param spName 存储过程名称
	 @param dataRow 使用DataRow作为参数值
	 @return 返回XmlReader结果集对象.
	*/
	public static XmlReader ExecuteXmlReaderTypedParams(SqlTransaction transaction, String spName, DataRow dataRow)
	{
		if (transaction == null)
		{
			throw new NullPointerException("transaction");
		}
		if (transaction != null && transaction.Connection == null)
		{
			throw new IllegalArgumentException("The transaction was rollbacked or commited, please provide an open transaction.", "transaction");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		// 如果row有值,存储过程必须初始化.
		if (dataRow != null && dataRow.ItemArray.length > 0)
		{
			// 从缓存中加载存储过程参数,如果缓存中不存在则从数据库中检索参数信息并加载到缓存中. ()
			SqlParameter[] commandParameters = SQLHelperParameterCache.GetSpParameterSet(transaction.Connection, spName);

			// 分配参数值
			AssignParameterValues(commandParameters, dataRow);

			return SQLHelper.ExecuteXmlReader(transaction, CommandType.StoredProcedure, spName, commandParameters);
		}
		else
		{
			return SQLHelper.ExecuteXmlReader(transaction, CommandType.StoredProcedure, spName);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}