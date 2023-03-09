package dal;

public class MyHelper
{
	/** 
	 数据库连接字符串，从配置文件读取
	*/
	private static final String connString = "Data Source=DESKTOP-52O598N\\MSSQLSERVERCPY;Initial Catalog=gdmu;Integrated Security=True;User ID =sa;Password = 123";
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 增、删，改
	/** 
	 
	 
	 @param sql
	 @return 
	*/
	public static int GetSingleResult(String sql)
	{
		//连接Ado.Net,做数据查询
		SqlConnection conn = new SqlConnection(connString);
		SqlCommand cmd = new SqlCommand(sql, conn);
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			int result = cmd.ExecuteNonQuery();
			return result;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetSingleResult(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
		finally
		{
			//最后需要处理的
			conn.Close();
		}
	}

	// 读去单一结果
	public static Object GetSingleObject(String sql)
	{
		SqlConnection conn = new SqlConnection(connString);
		SqlCommand cmd = new SqlCommand(sql, conn);
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			Object obj = cmd.ExecuteNonQuery();
			return obj;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetSingleResult(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
		finally
		{
			//最后需要处理的
			conn.Close();
		}


	}

	// 读取多个对象
	public static SqlDataReader GetDataReader(String sql)
	{
		SqlConnection conn = new SqlConnection(connString);
		SqlCommand cmd = new SqlCommand(sql, conn);
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			//CommandBehavior.CloseConnection ; //检测并关闭自动连接
			SqlDataReader reader = cmd.ExecuteReader(CommandBehavior.CloseConnection);

			return reader;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetDataReader(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}

	}

	/** 
	 新取数据方法
	 
	 @param sql
	 @return 
	*/
	public static DataTable ExecuteTable(String sql)
	{
		//连接Ado.Net,做数据查询
		SqlConnection conn = new SqlConnection(connString); //来连接
		SqlCommand cmd = new SqlCommand(sql, conn); //来管家
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			SqlDataAdapter sda = new SqlDataAdapter(cmd); //推车
			DataSet ds = new DataSet(); //货车
			sda.Fill(ds);

			return ds.Tables[0];
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetDataReader(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
	}

	/** 
	 新的非取数据方法——增、删、改
	 
	 @param sql
	 @param param
	 @return 
	*/
	public static int ExecuteNoteQuery(String sql)
	{
		//连接Ado.Net,做数据查询
		SqlConnection conn = new SqlConnection(connString); //来连接
		SqlCommand cmd = new SqlCommand(sql, conn); //来管家
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			int rows = cmd.ExecuteNonQuery();
			if (rows <= 0)
			{
				throw new RuntimeException("执行GetDataReader(string sql)方法出错");
			}

			return rows;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetDataReader(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 增、删，改


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 加参数的增、删，改
	public static int GetSingleResult(String sql, SqlParameter[] param)
	{
		//连接Ado.Net,做数据查询
		SqlConnection conn = new SqlConnection(connString);
		SqlCommand cmd = new SqlCommand(sql, conn);
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			cmd.Parameters.AddRange(param); //多参数给推车
			int result = cmd.ExecuteNonQuery();
			return result;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetSingleResult(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
		finally
		{
			//最后需要处理的
			conn.Close();
		}
	}
	// 读去单一结果
	public static Object GetSingleObject(String sql, SqlParameter[] param)
	{
		SqlConnection conn = new SqlConnection(connString);
		SqlCommand cmd = new SqlCommand(sql, conn);
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			cmd.Parameters.AddRange(param);
			Object obj = cmd.ExecuteNonQuery();
			return obj;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetSingleResult(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
		finally
		{
			//最后需要处理的
			conn.Close();
		}


	}
	// 读取多个对象
	public static SqlDataReader GetDataReader(String sql, SqlParameter[] param)
	{
		SqlConnection conn = new SqlConnection(connString);
		SqlCommand cmd = new SqlCommand(sql, conn);
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			cmd.Parameters.AddRange(param);
			//CommandBehavior.CloseConnection ; //检测并关闭自动连接
			SqlDataReader reader = cmd.ExecuteReader(CommandBehavior.CloseConnection);

			return reader;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetDataReader(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
		//finally
		//{
		//    //最后需要处理的
		//    conn.Close();
		//}

	}

	/** 
	 新的非取数据方法——增、删、改
	 
	 @param sql
	 @param param
	 @return 
	*/
	public static int ExecuteNoteQuery(String sql, SqlParameter... SqlParameters)
	{
		//连接Ado.Net,做数据查询
		SqlConnection conn = new SqlConnection(connString); //来连接
		SqlCommand cmd = new SqlCommand(sql, conn); //来管家
		cmd.Parameters.AddRange(SqlParameters);
		try
		{
			//这里写需要检测的语句,拿推车去操作数据库
			conn.Open();
			int rows = cmd.ExecuteNonQuery();
			if (rows <= 0)
			{
				throw new RuntimeException("执行GetDataReader(string sql)方法出错");
			}

			return rows;
		}
		catch (RuntimeException ex)
		{
			//处理异常
			//可以直接显示或者写入系统日志
			System.out.println("执行GetDataReader(string sql)方法出错 " + ex.getMessage());
			throw ex;
		}
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 加参数的增、删，改
}