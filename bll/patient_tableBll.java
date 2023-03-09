package bll;

import Models.*;
import DAL.*;
import java.util.*;

public class patient_tableBll
{
	private patient_tableDal patient_tableDal_ = new patient_tableDal();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_visitTable表列表222

	public final ArrayList<cur_patient_table> GetPatient_tableList1()
	{

		return patient_tableDal_.GetPatient_tableList1();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表222
	/** 
	 有了新的字段的临时表
	 
	 @return 
	*/
	public final ArrayList<cur_patient_table> GetPatient_tableList2()
	{

		return patient_tableDal_.GetPatient_tableList2();

	}




	/** 
	 跟新patient_table表
	 
	 @param ss_visitTable_
	 @return 
	*/
	public final int update_patient_table(patient_table patient_table_)
	{

		return patient_tableDal_.update_patient_table(patient_table_);
	}

	public final int update_patient_table22(patient_table patient_table_)
	{


		return patient_tableDal_.update_patient_table22(patient_table_);
	}
	/** 
	 随机分配的跟新patient_table表
	 
	 @param ss_visitTable_
	 @return 
	*/
	public final int update_patient_table2(patient_table patient_table_)
	{

		return patient_tableDal_.update_patient_table2(patient_table_);
	}

	/** 
	 根据illness_id查找一行，用于显示
	 
	 @param id_
	 @return 
	*/
	public final patient_table getpatient_tableObject(String id_)
	{

		return patient_tableDal_.getpatient_tableObject(id_);
	}

}