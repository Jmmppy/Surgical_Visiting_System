package bll;

import Models.*;
import DAL.*;
import Utility.*;
import java.util.*;
import java.time.*;

public class meeting_tableBll
{
	private meeting_tableDal meeting_tableDal_ = new meeting_tableDal();


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回meeting_table表列表222
	/** 
	 返回meeting_table表全部列表
	 
	 @return 
	*/
	public final ArrayList<meeting_table> GetMeeting_tableList1()
	{

		return meeting_tableDal_.GetMeeting_tableList1();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回visit_result_table表列表222

	/** 
	 以meeting_table记录扎入
	 
	 @param meeting_table
	 @return 
	*/
	public final int insert_meeting_table(meeting_table meeting_table_)
	{
		return meeting_tableDal_.insert_meeting_table(meeting_table_);
	}
	public final int update_meeting_table(meeting_table visit_Result_Table)
	{


		return meeting_tableDal_.update_meeting_table(visit_Result_Table);
	}

	/** 
	 根据mettingID 去设置isMetting值
	 
	 @param visit_Result_Table
	 @return 
	*/
	public final int update_isMeeting(int id, boolean isMetting_)
	{

		return meeting_tableDal_.update_isMeeting(id, isMetting_);
	}


	/** 
	 根据mettingID 去更新start_time值
	 
	 @param visit_Result_Table
	 @return 
	*/
	public final int update_isMeeting2(int id, LocalDateTime start_time_)
	{

		return meeting_tableDal_.update_isMeeting2(id, start_time_);
	}




	/** 
	 根据meeting_id查找一行
	 
	 @param id_
	 @return 
	*/
	public final meeting_table getmeeting_tableObject(int id_)
	{

		return meeting_tableDal_.getmeeting_tableObject(id_);
	}


	//
	/** 
	 根据开始时间查找一行
	 
	 @param Cur_start_time
	 @return 
	*/
	public final meeting_table getmeeting_tableObject2(LocalDateTime Cur_start_time, LocalDateTime Cur_end_time)
	{

		return meeting_tableDal_.getmeeting_tableObject2(Cur_start_time, Cur_end_time);
	}

}