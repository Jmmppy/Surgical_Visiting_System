package dal;

import Models.*;
import java.util.*;

public class patient_tableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回patient_table表列表222
	/** 
	 外连接查询到，临时表中
	 
	 @return 
	*/
	public final ArrayList<cur_patient_table> GetPatient_tableList1()
	{
		//string sql = "select * from ss_visitTable";
		String sql = "select pa.illness_id, pa.patient_name,pa.age,pa.height,pa.weigth,pa.sickroom,pa.insurance_type,pa.diagnosis,pa.phone,pa.card_type,pa.card_id,pa.isInput,pa.isInput2,pa.ss_id,doc.doc_name,pic.pice_place_name,part.partment_name from patient_table pa   " + " Left join doc_table doc on pa.doc_id = doc.doctor_id" + " Left join pice_placeTable pic on pa.pice_place_id = pic.pice_place_id" + " Left join partment_table part on pa.department_id = part.partment_id";

		ArrayList<cur_patient_table> patient_table_list = new ArrayList<cur_patient_table>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			patient_table_list.add(ToModel(dr));
		}

		return patient_table_list;

	}

	private static cur_patient_table ToModel(DataRow dr) // 上面查询的列信息(上面可以写很多，但下面的出现的必须是上面所查询的)
	{
		cur_patient_table cur_patient_table_ = new cur_patient_table();
		cur_patient_table_.illness_id = dr.get("illness_id").toString();
		cur_patient_table_.patient_name = dr.get("patient_name").toString();
		cur_patient_table_.age = dr.get("age").toString();
		cur_patient_table_.height = dr.get("height").toString();
		cur_patient_table_.weigth = dr.get("weigth").toString();
		cur_patient_table_.sickroom = dr.get("sickroom").toString();


		cur_patient_table_.insurance_type = dr.get("insurance_type").toString();
		cur_patient_table_.card_type = dr.get("card_type").toString();
		cur_patient_table_.card_id = dr.get("card_id").toString(); ///
		cur_patient_table_.phone = dr.get("phone").toString(); ///
		// ss_visitTable_.operate_id = dr["operate_id"].ToString();
		cur_patient_table_.diagnosis = dr.get("diagnosis").toString();
		cur_patient_table_.doc_name = dr.get("doc_name").toString();
		cur_patient_table_.pice_place_name = dr.get("pice_place_name").toString();
		cur_patient_table_.partment_name = dr.get("partment_name").toString();

		cur_patient_table_.Isinput = (Boolean)dr.get("isInput"); // 新加 默认全为false
		cur_patient_table_.Isinput2 = (Boolean)dr.get("isInput2"); // 新加 默认全为false

		cur_patient_table_.ss_id = (Integer)dr.get("ss_id");
		return cur_patient_table_;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表222


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回patient_table表列表222
	/** 
	 有了新的字段的临时表
	 
	 @return 
	*/
	public final ArrayList<cur_patient_table> GetPatient_tableList2()
	{
		//string sql = "select * from ss_visitTable";
		String sql = "select pa.illness_id, pa.patient_name,pa.age,pa.height,pa.weigth,pa.sickroom,pa.insurance_type,pa.diagnosis,pa.phone,pa.card_type,pa.card_id,pa.isInput,pa.ss_id,doc.doc_name,na.narcosis_doc_name,nur.nurse_name,pa.operation_room,pic.pice_place_name,part.partment_name from patient_table pa   " + " Left join doc_table doc on pa.doc_id = doc.doctor_id" + " Left join pice_placeTable pic on pa.pice_place_id = pic.pice_place_id" + " Left join partment_table part on pa.department_id = part.partment_id" + " Left join narcosis_docTable na on pa.narcosis_doc_id = na.narcosis_doc_id" + " Left join nurse_table nur on pa.nurse_id = nur.nurse_id";

		ArrayList<cur_patient_table> patient_table_list = new ArrayList<cur_patient_table>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			patient_table_list.add(ToModel2(dr));
		}

		return patient_table_list;

	}

	private static cur_patient_table ToModel2(DataRow dr) // 上面查询的列信息(上面可以写很多，但下面的出现的必须是上面所查询的)
	{
		cur_patient_table cur_patient_table_ = new cur_patient_table();
		cur_patient_table_.illness_id = dr.get("illness_id").toString();
		cur_patient_table_.patient_name = dr.get("patient_name").toString();
		cur_patient_table_.age = dr.get("age").toString();
		cur_patient_table_.height = dr.get("height").toString();
		cur_patient_table_.weigth = dr.get("weigth").toString();
		cur_patient_table_.sickroom = dr.get("sickroom").toString();


		cur_patient_table_.insurance_type = dr.get("insurance_type").toString();
		cur_patient_table_.card_type = dr.get("card_type").toString();
		cur_patient_table_.card_id = dr.get("card_id").toString(); ///
		cur_patient_table_.phone = dr.get("phone").toString(); ///
		// ss_visitTable_.operate_id = dr["operate_id"].ToString();
		cur_patient_table_.diagnosis = dr.get("diagnosis").toString();
		cur_patient_table_.doc_name = dr.get("doc_name").toString();
		cur_patient_table_.pice_place_name = dr.get("pice_place_name").toString();
		cur_patient_table_.partment_name = dr.get("partment_name").toString();

		cur_patient_table_.Isinput = (Boolean)dr.get("isInput"); // 新加 默认全为false
		cur_patient_table_.ss_id = (Integer)dr.get("ss_id");
		cur_patient_table_.narcosis_doc_name = dr.get("narcosis_doc_name").toString();
		cur_patient_table_.nurse_name = dr.get("nurse_name").toString();
		cur_patient_table_.operation_room = dr.get("operation_room").toString();

		return cur_patient_table_;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表222


	/** 
	 跟新patient_table表
	 
	 @param ss_visitTable_
	 @return 
	*/
	public final int update_patient_table(patient_table patient_table_)
	{
		String sql = String.format("update patient_table set isInput = @isInput,ss_id = @ss_id ") + String.format("where illness_id = @illness_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", patient_table_.illness_id), new SqlParameter("@isInput", patient_table_.isInput), new SqlParameter("@ss_id", patient_table_.ss_id));

		return row;
	}

	public final int update_patient_table22(patient_table patient_table_)
	{
		String sql = String.format("update patient_table set isInput2 = @isInput2 ") + String.format("where illness_id = @illness_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", patient_table_.illness_id), new SqlParameter("@isInput2", patient_table_.isInput2));

		return row;
	}
	/** 
	 随机分配的跟新patient_table表
	 
	 @param ss_visitTable_
	 @return 
	*/
	public final int update_patient_table2(patient_table patient_table_)
	{
		String sql = String.format("update patient_table set narcosis_doc_id = @narcosis_doc_id,nurse_id = @nurse_id,operation_room = @operation_room ") + String.format("where illness_id = @illness_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", patient_table_.illness_id), new SqlParameter("@narcosis_doc_id", patient_table_.narcosis_doc_id), new SqlParameter("@nurse_id", patient_table_.nurse_id), new SqlParameter("@operation_room", patient_table_.operation_room));
		return row;
	}

	/** 
	 根据illness_id查找一行，用于显示
	 
	 @param id_
	 @return 
	*/
	public final patient_table getpatient_tableObject(String id_)
	{
		patient_table patient_table_ = new patient_table();
		String sql = String.format("select * from patient_table where illness_id = '%1$s'", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			patient_table_ = new patient_table();
			patient_table_.setage(reader1.get("age").toString());
			patient_table_.setcard_id(reader1.get("card_id").toString());
			patient_table_.setcard_type(reader1.get("card_type").toString());
			patient_table_.setdepartment_id((Integer)reader1.get("department_id"));
			patient_table_.setdiagnosis(reader1.get("diagnosis").toString());
			patient_table_.setheight(reader1.get("height").toString());
			patient_table_.setinsurance_type(reader1.get("insurance_type").toString());
			patient_table_.setpatient_name(reader1.get("patient_name").toString());
			patient_table_.setphone(reader1.get("phone").toString());
			patient_table_.setweigth(reader1.get("weigth").toString());
			patient_table_.setpice_place_id(reader1.get("pice_place_id").toString());
			patient_table_.setsickroom(reader1.get("sickroom").toString());
			patient_table_.setoperation_room(reader1.get("operation_room").toString());
			patient_table_.setss_id((Integer)reader1.get("ss_id"));
			patient_table_.setdoc_id((Integer)reader1.get("doc_id"));
			patient_table_.setnarcosis_doc_id((Integer)reader1.get("narcosis_doc_id"));
			patient_table_.setnurse_id((Integer)reader1.get("nurse_id"));
			patient_table_.setisInput((Boolean)reader1.get("isInput"));

		}
		return patient_table_;
	}
}