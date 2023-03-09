package bll;

import Models.*;
import DAL.*;
import Utility.*;
import java.util.*;

public class visit_result_tableBll
{
	private visit_result_tableDal visit_result_table_ = new visit_result_tableDal();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回visit_result_table表列表222
	/** 
	 外连接查询到，临时表中
	 
	 @return 
	*/
	public final ArrayList<visit_result_table> GetVisit_result_tableList1()
	{


		return visit_result_table_.GetVisit_result_tableList1();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回visit_result_table表列表222
	/** 
	 insert_visit_result_table
	 
	 @param visit_Result_Table
	 @return 
	*/
	public final int insert_visit_result_table(visit_result_table visit_Result_Table)
	{

		return visit_result_table_.insert_visit_result_table(visit_Result_Table);
	}
	//跟新
	public final int update_visit_result_table(visit_result_table visit_Result_Table)
	{
		return visit_result_table_.update_visit_result_table(visit_Result_Table);
	}
	//查找
	public final visit_result_table getvisit_result_tableObject(String illness_id)
	{

		return visit_result_table_.getvisit_result_tableObject(illness_id);
	}
	/** 
	 根据int 的visit_result_id去拿到一行
	 
	 @param visit_result_id_
	 @return 
	*/
	public final visit_result_table getvisit_result_tableObject2(int visit_result_id_)
	{

		return visit_result_table_.getvisit_result_tableObject2(visit_result_id_);
	}
}