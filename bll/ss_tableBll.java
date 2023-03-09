package bll;

import Models.*;
import DAL.*;
import Utility.*;
import java.util.*;

public class ss_tableBll
{
	private ss_tableDal ss_tableDal_ = new ss_tableDal();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_table表列表222
	/** 
	 查询所以行对象列表，使用泛型反射
	 
	 @return 
	 
	*/
	public final ArrayList<ss_table> GetSs_tableList1()
	{

		return ss_tableDal_.GetSs_tableList1();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_table表列表222

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region
	/** 
	 插入ss_table
	 
	 @param visit_Result_Table
	 @return 
	*/
	public final int insert_ss_table(ss_table ss_table_)
	{


		return ss_tableDal_.insert_ss_table(ss_table_);
	}
	//跟新
	public final int update_ss_table(ss_table ss_table_)
	{


		return ss_tableDal_.update_ss_table(ss_table_);
	}


	/** 
	 根据illness_id查找一行，用于显示
	 
	 @param id_
	 @return 
	*/
	public final ss_table getss_tableObject(String illness_id)
	{



		return ss_tableDal_.getss_tableObject(illness_id);
	}
	/** 
	 根据int 的ss_id去拿到一行
	 
	 @param ss_id_
	 @return 
	*/
	public final ss_table getss_tableObject2(int ss_id_)
	{

		return ss_tableDal_.getss_tableObject2(ss_id_);
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}