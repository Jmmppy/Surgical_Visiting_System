package dal;

import java.util.*;

/** 
 SQLHelperParameterCache提供缓存存储过程参数,并能够在运行时从存储过程中探索参数.
*/
public final class SQLHelperParameterCache
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 私有方法,字段,构造函数
	// 私有构造函数,妨止类被实例化.
	private SQLHelperParameterCache()
	{
	}
	// 这个方法要注意
	private static Hashtable paramCache = Hashtable.Synchronized(new Hashtable());
	/** 
	 探索运行时的存储过程,返回SqlParameter参数数组.
	 初始化参数值为 DBNull.Value.
	 
	 @param connection 一个有效的数据库连接
	 @param spName 存储过程名称
	 @param includeReturnValueParameter 是否包含返回值参数
	 @return 返回SqlParameter参数数组
	*/
	private static SqlParameter[] DiscoverSpParameterSet(SqlConnection connection, String spName, boolean includeReturnValueParameter)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		SqlCommand cmd = new SqlCommand(spName, connection);
		cmd.CommandType = CommandType.StoredProcedure;
		connection.Open();
		// 检索cmd指定的存储过程的参数信息,并填充到cmd的Parameters参数集中.
		SqlCommandBuilder.DeriveParameters(cmd);
		connection.Close();
		// 如果不包含返回值参数,将参数集中的每一个参数删除.
		if (!includeReturnValueParameter)
		{
			cmd.Parameters.RemoveAt(0);
		}

		// 创建参数数组
		SqlParameter[] discoveredParameters = new SqlParameter[cmd.Parameters.Count];
		// 将cmd的Parameters参数集复制到discoveredParameters数组.
		cmd.Parameters.CopyTo(discoveredParameters, 0);
		// 初始化参数值为 DBNull.Value.
		for (SqlParameter discoveredParameter : discoveredParameters)
		{
			discoveredParameter.Value = DBNull.Value;
		}
		return discoveredParameters;
	}

	/** 
	 SqlParameter参数数组的深层拷贝.
	 
	 @param originalParameters 原始参数数组
	 @return 返回一个同样的参数数组
	*/
	private static SqlParameter[] CloneParameters(SqlParameter[] originalParameters)
	{
		SqlParameter[] clonedParameters = new SqlParameter[originalParameters.length];
		for (int i = 0, j = originalParameters.length; i < j; i++)
		{
			clonedParameters[i] = (SqlParameter)((Cloneable)originalParameters[i]).Clone();
		}
		return clonedParameters;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 私有方法,字段,构造函数结束

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 缓存方法
	/** 
	 追加参数数组到缓存.
	 
	 @param connectionString 一个有效的数据库连接字符串
	 @param commandText 存储过程名或SQL语句
	 @param commandParameters 要缓存的参数数组
	*/
	public static void CacheParameterSet(String connectionString, String commandText, SqlParameter... commandParameters)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (commandText == null || commandText.length() == 0)
		{
			throw new NullPointerException("commandText");
		}
		String hashKey = connectionString + ":" + commandText;
		paramCache.put(hashKey, commandParameters);
	}

	/** 
	 从缓存中获取参数数组.
	 
	 @param connectionString 一个有效的数据库连接字符
	 @param commandText 存储过程名或SQL语句
	 @return 参数数组
	*/
	public static SqlParameter[] GetCachedParameterSet(String connectionString, String commandText)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (commandText == null || commandText.length() == 0)
		{
			throw new NullPointerException("commandText");
		}
		String hashKey = connectionString + ":" + commandText;
		SqlParameter[] cachedParameters = paramCache.get(hashKey) instanceof SqlParameter[] ? (SqlParameter[])paramCache.get(hashKey) : null;
		if (cachedParameters == null)
		{
			return null;
		}
		else
		{
			return CloneParameters(cachedParameters);
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 缓存方法结束

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 检索指定的存储过程的参数集
	/** 
	 返回指定的存储过程的参数集
	 
	 
	 这个方法将查询数据库,并将信息存储到缓存.
	 
	 @param connectionString 一个有效的数据库连接字符
	 @param spName 存储过程名
	 @return 返回SqlParameter参数数组
	*/
	public static SqlParameter[] GetSpParameterSet(String connectionString, String spName)
	{
		return GetSpParameterSet(connectionString, spName, false);
	}

	/** 
	 返回指定的存储过程的参数集
	 
	 
	 这个方法将查询数据库,并将信息存储到缓存.
	 
	 @param connectionString 一个有效的数据库连接字符.
	 @param spName 存储过程名
	 @param includeReturnValueParameter 是否包含返回值参数
	 @return 返回SqlParameter参数数组
	*/
	public static SqlParameter[] GetSpParameterSet(String connectionString, String spName, boolean includeReturnValueParameter)
	{
		if (connectionString == null || connectionString.length() == 0)
		{
			throw new NullPointerException("connectionString");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		try (SqlConnection connection = new SqlConnection(connectionString))
		{
			return GetSpParameterSetInternal(connection, spName, includeReturnValueParameter);
		}
	}

	/** 
	 [内部]返回指定的存储过程的参数集(使用连接对象).
	 
	 
	 这个方法将查询数据库,并将信息存储到缓存.
	 
	 @param connection 一个有效的数据库连接字符
	 @param spName 存储过程名
	 @return 返回SqlParameter参数数组
	*/
	public static SqlParameter[] GetSpParameterSet(SqlConnection connection, String spName)
	{
		return GetSpParameterSet(connection, spName, false);
	}

	/** 
	 [内部]返回指定的存储过程的参数集(使用连接对象)
	 
	 
	 这个方法将查询数据库,并将信息存储到缓存.
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名
	 @param includeReturnValueParameter
	 是否包含返回值参数
	 
	 @return 返回SqlParameter参数数组
	*/
	public static SqlParameter[] GetSpParameterSet(SqlConnection connection, String spName, boolean includeReturnValueParameter)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		try (SqlConnection clonedConnection = (SqlConnection)((Cloneable)connection).Clone())
		{
			return GetSpParameterSetInternal(clonedConnection, spName, includeReturnValueParameter);
		}
	}

	/** 
	 [私有]返回指定的存储过程的参数集(使用连接对象)
	 
	 @param connection 一个有效的数据库连接对象
	 @param spName 存储过程名
	 @param includeReturnValueParameter 是否包含返回值参数
	 @return 返回SqlParameter参数数组
	*/
	private static SqlParameter[] GetSpParameterSetInternal(SqlConnection connection, String spName, boolean includeReturnValueParameter)
	{
		if (connection == null)
		{
			throw new NullPointerException("connection");
		}
		if (spName == null || spName.length() == 0)
		{
			throw new NullPointerException("spName");
		}
		String hashKey = connection.ConnectionString + ":" + spName + (includeReturnValueParameter ? ":include ReturnValue Parameter" : "");
		SqlParameter[] cachedParameters;

		cachedParameters = paramCache.get(hashKey) instanceof SqlParameter[] ? (SqlParameter[])paramCache.get(hashKey) : null;
		if (cachedParameters == null)
		{
			SqlParameter[] spParameters = DiscoverSpParameterSet(connection, spName, includeReturnValueParameter);
			paramCache.put(hashKey, spParameters);
			cachedParameters = spParameters;
		}

		return CloneParameters(cachedParameters);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 参数集检索结束
}