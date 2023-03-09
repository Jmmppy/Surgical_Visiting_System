package bll;

import Models.*;
import DAL.*;
import Utility.*;
import java.util.*;

public class operation_tableBll
{
	private operation_tableDal operation_tableDal_ = new operation_tableDal();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回operation_table表列表222
	/** 
	 查询所以行对象列表，使用泛型反射
	 
	 @return 
	 
	*/
	public final ArrayList<operation_table> GetOperation_tableList1()
	{

		return operation_tableDal_.GetOperation_tableList1();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回operation_table表列表222

	/** 
	 根据患者id查询operation_table对象
	 
	 @return 
	*/
	public final operation_table getOperation_tableObject(String id_)
	{

		return operation_tableDal_.getOperation_tableObject(id_);
	}
}