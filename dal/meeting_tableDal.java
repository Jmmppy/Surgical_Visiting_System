package dal;

import Models.*;
import Utility.*;
import java.util.*;
import java.time.*;

public class meeting_tableDal
{
	//
	//插入
	//查询

	//List to dataTable
	//public DataTable GetMeeting_table(List<meeting_table> list)
	//{
	//    DataTable dt = new DataTable();


	//    return dt;
	//}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回meeting_table表列表222
	/** 
	 返回meeting_table表全部列表
	 
	 @return 
	*/
	public final ArrayList<meeting_table> GetMeeting_tableList1()
	{
		String sql = "select * from meeting_table";

		ArrayList<meeting_table> cur_meeting_table_list = new ArrayList<meeting_table>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			cur_meeting_table_list.add(dr.<meeting_table>DataRowToModel());
		}

		return cur_meeting_table_list;

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回visit_result_table表列表222
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region
	/** 
	 以meeting_table记录扎入
	 
	 @param meeting_table
	 @return 
	*/
	public final int insert_meeting_table(meeting_table meeting_table_)
	{
		String sql = String.format("insert into meeting_table(meeting_name, start_time, end_time, illness_id_count, meeting_Key,illness_id1,illness_id2,illness_id3,isMetting,Belong_doc) values") + String.format("(@meeting_name, @start_time, @end_time, @illness_id_count, @meeting_Key,@illness_id1,@illness_id2,@illness_id3,@isMetting,@Belong_doc)");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@meeting_id", meeting_table_.meeting_id), new SqlParameter("@meeting_name", meeting_table_.meeting_name), new SqlParameter("@start_time", meeting_table_.start_time), new SqlParameter("@end_time", meeting_table_.end_time), new SqlParameter("@illness_id_count", meeting_table_.illness_id_count), new SqlParameter("@meeting_Key", meeting_table_.meeting_Key), new SqlParameter("@illness_id1", meeting_table_.illness_id1), new SqlParameter("@illness_id2", meeting_table_.illness_id2), new SqlParameter("@illness_id3", meeting_table_.illness_id3), new SqlParameter("@isMetting", false), new SqlParameter("@Belong_doc", meeting_table_.Belong_doc));

		return row;
	}
	//跟新
	public final int update_meeting_table(meeting_table visit_Result_Table)
	{
		String sql = String.format("update meeting_table set meeting_name = @meeting_name, start_time = @start_time, end_time = @end_time, illness_id_count = @illness_id_count, meeting_Key=@meeting_Key ") + String.format("where meeting_id = @meeting_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@meeting_id", visit_Result_Table.meeting_id), new SqlParameter("@meeting_name", visit_Result_Table.meeting_name), new SqlParameter("@start_time", visit_Result_Table.start_time), new SqlParameter("@end_time", visit_Result_Table.end_time), new SqlParameter("@illness_id_count", visit_Result_Table.illness_id_count), new SqlParameter("@meeting_Key", visit_Result_Table.meeting_Key));

		return row;
	}

	/** 
	 根据mettingID 去设置isMetting值
	 
	 @param visit_Result_Table
	 @return 
	*/
	public final int update_isMeeting(int id, boolean isMetting_)
	{
		String sql = String.format("update meeting_table set  isMetting=@isMetting ") + String.format("where meeting_id = @meeting_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@meeting_id", id), new SqlParameter("@isMetting", isMetting_));

		return row;
	}



	/** 
	 根据mettingID 去更新start_time值
	 
	 @param visit_Result_Table
	 @return 
	*/
	public final int update_isMeeting2(int id, LocalDateTime start_time_)
	{
		String sql = String.format("update meeting_table set  start_time=@start_time ") + String.format("where meeting_id = @meeting_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@meeting_id", id), new SqlParameter("@start_time", start_time_));

		return row;
	}
	//
	/** 
	 根据meeting_id查找一行
	 
	 @param id_
	 @return 
	*/
	public final meeting_table getmeeting_tableObject(int id_)
	{
		meeting_table meeting_table_ = new meeting_table();
		String sql = String.format("select * from meeting_table where meeting_id = '%1$s'", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			meeting_table_ = new meeting_table();
			meeting_table_.setmeeting_id((Integer)reader1.get("meeting_id"));
			meeting_table_.setmeeting_name(reader1.get("meeting_name").toString());
			meeting_table_.setstart_time((LocalDateTime)reader1.get("start_time"));
			meeting_table_.setend_time((LocalDateTime)reader1.get("end_time"));
			meeting_table_.setillness_id_count((Integer)reader1.get("illness_id_count"));
			meeting_table_.setmeeting_Key(reader1.get("meeting_Key").toString());
			meeting_table_.setBelong_doc((Integer)reader1.get("Belong_doc"));

		}
		return meeting_table_;
	}
	//
	/** 
	 根据开始时间查找一行而且必须是该医生预约的会议。
	 
	 @param Cur_start_time
	 @return 
	*/
	public final meeting_table getmeeting_tableObject2(LocalDateTime Cur_start_time, LocalDateTime Cur_end_time)
	{
		meeting_table meeting_table_ = new meeting_table();
		String sql = String.format("select * from meeting_table where start_time between '%1$s' and '%2$s'and isMetting = '%3$s'", Cur_start_time, Cur_end_time, false);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			meeting_table_ = new meeting_table();
			meeting_table_.setmeeting_id((Integer)reader1.get("meeting_id"));
			meeting_table_.setmeeting_name(reader1.get("meeting_name").toString());
			meeting_table_.setstart_time((LocalDateTime)reader1.get("start_time"));
			meeting_table_.setend_time((LocalDateTime)reader1.get("end_time"));
			meeting_table_.setillness_id_count((Integer)reader1.get("illness_id_count"));
			meeting_table_.setmeeting_Key(reader1.get("meeting_Key").toString());
			meeting_table_.setillness_id1(reader1.get("illness_id1").toString());
			meeting_table_.setillness_id2(reader1.get("illness_id2").toString());
			meeting_table_.setillness_id3(reader1.get("illness_id3").toString());
			meeting_table_.setBelong_doc((Integer)reader1.get("Belong_doc"));

		}
		return meeting_table_;
	}
	/** 
	 根据int 的visit_result_id去拿到一行
	 
	 @param visit_result_id_
	 @return 
	*/
	//public visit_result_table getvisit_result_tableObject2(int visit_result_id_)
	//{
	//    visit_result_table visit_result_table_ = new visit_result_table();
	//    string sql = $"select * from visit_result_table where visit_result_id = {visit_result_id_}";
	//    SqlDataReader reader1 = MyHelper.GetDataReader(sql);

	//    while (reader1.Read())
	//    {
	//        visit_result_table_ = new visit_result_table()
	//        {

	//            visit_result_id = Convert.ToInt32(reader1["visit_result_id"]),
	//            illness_id = reader1["illness_id"].ToString(),
	//            drug_allergy = reader1["drug_allergy"].ToString(),
	//            condition = reader1["condition"].ToString(),
	//            sanity = reader1["sanity"].ToString(),
	//            test_result = reader1["test_result"].ToString()
	//        };

	//    }
	//    return visit_result_table_;
	//}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}