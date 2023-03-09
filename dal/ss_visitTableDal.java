package dal;

import Models.*;
import java.util.*;
import java.time.*;

public class ss_visitTableDal
{

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_visitTable表列表

	public final ArrayList<ss_visitTable> GetSs_visitTableList()
	{
		String sql = "select * from ss_visitTable";
		//string sql = "select ss.illness_id, ss.patient_name, ss.operation_date,ss.operation_room,ss.visit_time, op.operation_name, doc.doc_name,na.narcosis_doc_name,nurse_name from ss_visitTable ss "+
		//    " left join operation_table op on ss.operate_id = op.operation_id"+
		//    " Left join doc_table doc on ss.doc_id = doc.doctor_id"+
		//    " Left join narcosis_docTable na on ss.narcosis_doc_id = na.narcosis_doc_id"+
		//    " Left join nurse_table nu on ss.nurse_id = nu.nurse_id";
		ArrayList<ss_visitTable> ss_visits_list = new ArrayList<ss_visitTable>(); // 准备一个空的列表对象
		SqlDataReader dataReader = MyHelper.GetDataReader(sql); // 这个有问题？？？？？？
		//Console.WriteLine();
		System.out.println("read:" + dataReader.Read());
		while (dataReader.Read())
		{
			System.out.println("11111111111");
			//问题要不要写全？？？ 不要写完整
			ss_visitTable tempVar = new ss_visitTable();
			tempVar.setillness_id(dataReader.get("illness_id").toString());
			tempVar.setpatient_name(dataReader.get("patient_name").toString());
			tempVar.setoperation_date((LocalDateTime)dataReader.get("operation_date"));
			tempVar.setoperation_room(dataReader.get("operation_room").toString());
			tempVar.setnarcosis_time((LocalDateTime)dataReader.get("narcosis_time"));
			tempVar.setoperate_id(dataReader.get("operate_id").toString());
			tempVar.setdoc_id((Integer)dataReader.get("doc_id"));
			tempVar.setnarcosis_doc_id((Integer)dataReader.get("narcosis_doc_id"));
			tempVar.setnurse_id((Integer)dataReader.get("nurse_id"));
			ss_visits_list.add(tempVar);
		}
		dataReader.Close(); //采用了close进行手动关闭。
		return ss_visits_list;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_visitTable表列表222
	/** 
	 外连接查询到，临时表中
	 
	 @return 
	*/
	public final ArrayList<cur_ss_visitTable> GetSs_visitTableList1()
	{
		//string sql = "select * from ss_visitTable";
		String sql = "select ss.illness_id, ss.patient_name, ss.operation_date,ss.operation_room,ss.narcosis_time, op.operation_name, doc.doc_name,na.narcosis_doc_name,nu.nurse_name,ss.sickroom,ss.isSelect,ss.is_ss,ss.is_bool1,ss.is_bool2,ss.is_bool3,ss.visit_result_id from ss_visitTable ss " + " left join operation_table op on ss.operate_id = op.operation_id" + " Left join doc_table doc on ss.doc_id = doc.doctor_id" + " Left join narcosis_docTable na on ss.narcosis_doc_id = na.narcosis_doc_id" + " Left join nurse_table nu on ss.nurse_id = nu.nurse_id";
		ArrayList<cur_ss_visitTable> cur_ss_visits_list = new ArrayList<cur_ss_visitTable>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			cur_ss_visits_list.add(ToModel(dr));
		}

		return cur_ss_visits_list;

	}

	private static cur_ss_visitTable ToModel(DataRow dr) // 上面查询的列信息
	{
		cur_ss_visitTable cur_ss_visitTable_ = new cur_ss_visitTable();
		cur_ss_visitTable_.illness_id = dr.get("illness_id").toString();
		cur_ss_visitTable_.patient_name = dr.get("patient_name").toString();
		cur_ss_visitTable_.operation_date = (LocalDateTime)dr.get("operation_date");
		cur_ss_visitTable_.operation_room = dr.get("operation_room").toString();
		cur_ss_visitTable_.narcosis_time = (LocalDateTime)dr.get("narcosis_time");
		// ss_visitTable_.operate_id = dr["operate_id"].ToString();
		cur_ss_visitTable_.operation_name = dr.get("operation_name").toString();
		cur_ss_visitTable_.doc_name = dr.get("doc_name").toString();
		cur_ss_visitTable_.narcosis_doc_name = dr.get("narcosis_doc_name").toString();
		cur_ss_visitTable_.nurse_name = dr.get("nurse_name").toString();
		cur_ss_visitTable_.sickroom = dr.get("sickroom").toString();
		cur_ss_visitTable_.isSelect = (Boolean)dr.get("isSelect");
		cur_ss_visitTable_.is_ss = (Boolean)dr.get("is_ss");

		cur_ss_visitTable_.is_bool1 = (Boolean)dr.get("is_bool1");
		cur_ss_visitTable_.is_bool2 = (Boolean)dr.get("is_bool2");
		cur_ss_visitTable_.is_bool3 = (Boolean)dr.get("is_bool3");

		cur_ss_visitTable_.visit_result_id = (Integer)dr.get("visit_result_id");
		//cur_ss_visitTable_.isSelect = false; // 新加 默认全为false
		return cur_ss_visitTable_;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表222



	/** 
	 根据患者id查询cur_ss_visitTable对象。不用
	 
	 @return 
	*/
	public final cur_ss_visitTable getcur_ss_visitTableObject(String id_)
	{
		cur_ss_visitTable cur_ss_visitTable_ = new cur_ss_visitTable();
		String sql = String.format("select * from cur_ss_visitTable where illness_id = '%1$s'", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			cur_ss_visitTable_ = new cur_ss_visitTable();
			cur_ss_visitTable_.setillness_id(reader1.get("illness_id").toString());
			cur_ss_visitTable_.setdoc_name(reader1.get("doc_name").toString());
			cur_ss_visitTable_.setnarcosis_doc_name(reader1.get("narcosis_doc_name").toString());
			cur_ss_visitTable_.setnarcosis_time((LocalDateTime)reader1.get("narcosis_time"));
			cur_ss_visitTable_.setnurse_name(reader1.get("nurse_name").toString());
			cur_ss_visitTable_.setoperation_date((LocalDateTime)reader1.get("operation_date"));
			cur_ss_visitTable_.setoperation_name(reader1.get("operation_name").toString());
			cur_ss_visitTable_.setoperation_room(reader1.get("operation_room").toString());
			cur_ss_visitTable_.setpatient_name(reader1.get("patient_name").toString());
			cur_ss_visitTable_.setsickroom(reader1.get("sickroom").toString());
			cur_ss_visitTable_.setvisit_result_id((Integer)reader1.get("visit_result_id"));

		}
		return cur_ss_visitTable_;
	}


	/** 
	 根据患者id查询ss_visitTable对象
	 
	 @return 
	*/
	public final ss_visitTable getss_visitTableObject(String id_)
	{
		ss_visitTable ss_visitTable_ = new ss_visitTable();
		String sql = String.format("select * from ss_visitTable where illness_id = '%1$s'", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			ss_visitTable_ = new ss_visitTable();
			ss_visitTable_.setillness_id(reader1.get("illness_id").toString());
			ss_visitTable_.setdepartment_id((Integer)reader1.get("department_id"));
			ss_visitTable_.setnarcosis_doc_id((Integer)reader1.get("narcosis_doc_id"));
			ss_visitTable_.setnurse_id((Integer)reader1.get("nurse_id"));
			ss_visitTable_.setdoc_id((Integer)reader1.get("doc_id"));
			ss_visitTable_.setoperate_id(reader1.get("operate_id").toString());
			ss_visitTable_.setstart_time((LocalDateTime)reader1.get("start_time"));
			ss_visitTable_.setvisit_time((LocalDateTime)reader1.get("visit_time"));
			ss_visitTable_.setpice_place_id(reader1.get("pice_place_id").toString());
			ss_visitTable_.setpatient_name(reader1.get("patient_name").toString());
			ss_visitTable_.setoperation_date((LocalDateTime)reader1.get("operation_date"));
			ss_visitTable_.setnarcosis_time((LocalDateTime)reader1.get("narcosis_time"));
			ss_visitTable_.setoperation_room(reader1.get("operation_room").toString());

		}
		return ss_visitTable_;
	}



	//跟新
	public final int update_ss_visitTable(ss_visitTable ss_visitTable_)
	{
		String sql = String.format("update ss_visitTable set isSelect = @isSelect,visit_result_id = @visit_result_id ") + String.format("where illness_id = @illness_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", ss_visitTable_.illness_id), new SqlParameter("@isSelect", ss_visitTable_.isSelect), new SqlParameter("@visit_result_id", ss_visitTable_.visit_result_id));

		return row;
	}


	public final int update_ss_visitTable2(ss_visitTable ss_visitTable_)
	{
		String sql = String.format("update ss_visitTable set is_ss = @is_ss ") + String.format("where illness_id = @illness_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", ss_visitTable_.illness_id), new SqlParameter("@is_ss", ss_visitTable_.is_ss));

		return row;
	}

	public final int update_ss_visitTable3(ss_visitTable ss_visitTable_)
	{
		String sql = String.format("update ss_visitTable set is_bool1 = @is_bool1 ") + String.format("where illness_id = @illness_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", ss_visitTable_.illness_id), new SqlParameter("@is_bool1", ss_visitTable_.is_bool1));

		return row;
	}

	public final int update_ss_visitTable4(ss_visitTable ss_visitTable_)
	{
		String sql = String.format("update ss_visitTable set is_bool3 = @is_bool3 ") + String.format("where illness_id = @illness_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", ss_visitTable_.illness_id), new SqlParameter("@is_bool3", ss_visitTable_.is_bool3));

		return row;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_visitTable表列表333
	/** 
	 外连接查询到，临时表中
	 
	 @return 
	*/
	//public List<ss_visitTable> GetSs_visitTableList3()
	//{
	//    //string sql = "select * from ss_visitTable";
	//    string sql = "select ss.illness_id, ss.patient_name, ss.operation_date,ss.operation_room,ss.narcosis_time, op.operation_name, doc.doc_name,na.narcosis_doc_name,nu.nurse_name,ss.sickroom,ss.visit_result_id,ss.Select from ss_visitTable ss " +
	//        " left join operation_table op on ss.operate_id = op.operation_id" +
	//        " Left join doc_table doc on ss.doc_id = doc.doctor_id" +
	//        " Left join narcosis_docTable na on ss.narcosis_doc_id = na.narcosis_doc_id" +
	//        " Left join nurse_table nu on ss.nurse_id = nu.nurse_id";
	//    List<ss_visitTable> ss_visitTable_list = new List<ss_visitTable>(); // 准备一个空的列表对象
	//    DataTable dt = MyHelper.ExecuteTable(sql);
	//    foreach (DataRow dr in dt.Rows)
	//    {
	//        ss_visitTable_list.Add(ToModel3(dr));
	//    }

	//    return ss_visitTable_list;

	//}

	//private static ss_visitTable ToModel3(DataRow dr)  // 上面查询的列信息
	//{
	//    ss_visitTable cur_ss_visitTable_ = new ss_visitTable();
	//    cur_ss_visitTable_.illness_id = dr["illness_id"].ToString();
	//    cur_ss_visitTable_.patient_name = dr["patient_name"].ToString();
	//    cur_ss_visitTable_.operation_date = Convert.ToDateTime(dr["operation_date"]);
	//    cur_ss_visitTable_.operation_room = dr["operation_room"].ToString();
	//    cur_ss_visitTable_.narcosis_time = Convert.ToDateTime(dr["narcosis_time"]);
	//    // ss_visitTable_.operate_id = dr["operate_id"].ToString();
	//    cur_ss_visitTable_.operation_name = dr["operation_name"].ToString();
	//    cur_ss_visitTable_.doc_name = dr["doc_name"].ToString();
	//    cur_ss_visitTable_.narcosis_doc_name = dr["narcosis_doc_name"].ToString();
	//    cur_ss_visitTable_.nurse_name = dr["nurse_name"].ToString();
	//    cur_ss_visitTable_.sickroom = dr["sickroom"].ToString();
	//    cur_ss_visitTable_.isSelect = false; // 新加 默认全为false
	//    return cur_ss_visitTable_;
	//}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表222
}