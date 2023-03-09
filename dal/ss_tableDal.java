package dal;

import Models.*;
import Utility.*;
import java.util.*;
import java.time.*;

/** 
 填写手术申请表等同于填写访视结果
*/
public class ss_tableDal
{
	//插入

	//查询
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_table表列表222
	/** 
	 查询所以行对象列表，使用泛型反射
	 
	 @return 
	 
	*/
	public final ArrayList<ss_table> GetSs_tableList1()
	{
		String sql = "select * from ss_table";

		ArrayList<ss_table> cur_ss_tableList = new ArrayList<ss_table>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			cur_ss_tableList.add(dr.<ss_table>DataRowToModel());
		}

		return cur_ss_tableList;

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
		String sql = String.format("insert into ss_table(ss_type, ss_date, operation_id, ss_grade, position,body_position,narcosis_way,cut_grade,hepatitisB,hepatitisC,syphilis,HIV,tuberculosis,special_infection,BH_blood,remarks,illness_id) values") + String.format("(@ss_type, @ss_date, @operation_id, @ss_grade, @position,@body_position,@narcosis_way,@cut_grade,@hepatitisB,@hepatitisC,@syphilis,@HIV,@tuberculosis,@special_infection,@BH_blood,@remarks,@illness_id)");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@ss_type", ss_table_.ss_type), new SqlParameter("@ss_date", ss_table_.ss_date), new SqlParameter("@operation_id", ss_table_.operation_id), new SqlParameter("@ss_grade", ss_table_.ss_grade), new SqlParameter("@position", ss_table_.position), new SqlParameter("@body_position", ss_table_.body_position), new SqlParameter("@narcosis_way", ss_table_.narcosis_way), new SqlParameter("@cut_grade", ss_table_.cut_grade), new SqlParameter("@hepatitisB", ss_table_.hepatitisB), new SqlParameter("@hepatitisC", ss_table_.hepatitisC), new SqlParameter("@syphilis", ss_table_.syphilis), new SqlParameter("@HIV", ss_table_.HIV), new SqlParameter("@tuberculosis", ss_table_.tuberculosis), new SqlParameter("@special_infection", ss_table_.special_infection), new SqlParameter("@BH_blood", ss_table_.BH_blood), new SqlParameter("@remarks", ss_table_.remarks), new SqlParameter("@illness_id", ss_table_.illness_id));

		return row;
	}
	//跟新
	public final int update_ss_table(ss_table ss_table_)
	{
		String sql = String.format("update ss_table set ss_type = @ss_type, ss_date = @ss_date, operation_id = @operation_id, ss_grade = @ss_grade, position=@position ") + String.format("body_position = @body_position, narcosis_way = @narcosis_way, cut_grade = @cut_grade, hepatitisB = @hepatitisB, hepatitisC=@hepatitisC") + String.format("syphilis = @syphilis, HIV = @HIV, tuberculosis = @tuberculosis, special_infection = @special_infection, BH_blood=@BH_blood") + String.format("remarks = @remarks, illness_id = @illness_id ") + String.format("where ss_id = @ss_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@ss_id", ss_table_.ss_id), new SqlParameter("@ss_type", ss_table_.ss_type), new SqlParameter("@ss_date", ss_table_.ss_date), new SqlParameter("@operation_id", ss_table_.operation_id), new SqlParameter("@ss_grade", ss_table_.ss_grade), new SqlParameter("@position", ss_table_.position), new SqlParameter("@body_position", ss_table_.body_position), new SqlParameter("@narcosis_way", ss_table_.narcosis_way), new SqlParameter("@cut_grade", ss_table_.cut_grade), new SqlParameter("@hepatitisB", ss_table_.hepatitisB), new SqlParameter("@hepatitisC", ss_table_.hepatitisC), new SqlParameter("@syphilis", ss_table_.syphilis), new SqlParameter("@HIV", ss_table_.HIV), new SqlParameter("@tuberculosis", ss_table_.tuberculosis), new SqlParameter("@special_infection", ss_table_.special_infection), new SqlParameter("@BH_blood", ss_table_.BH_blood), new SqlParameter("@remarks", ss_table_.remarks), new SqlParameter("@illness_id", ss_table_.illness_id));

		return row;
	}


	/** 
	 根据illness_id查找一行，用于显示
	 
	 @param id_
	 @return 
	*/
	public final ss_table getss_tableObject(String id_)
	{
		ss_table ss_table_ = new ss_table();
		String sql = String.format("select * from ss_table where illness_id = '%1$s'", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			ss_table_ = new ss_table();
			ss_table_.setss_id((Integer)reader1.get("ss_id"));
			ss_table_.setBH_blood(reader1.get("BH_blood").toString());
			ss_table_.setbody_position(reader1.get("body_position").toString());
			ss_table_.setcut_grade(reader1.get("cut_grade").toString());
			ss_table_.sethepatitisB(reader1.get("hepatitisB").toString());
			ss_table_.sethepatitisC(reader1.get("hepatitisC").toString());
			ss_table_.setHIV(reader1.get("HIV").toString());
			ss_table_.setnarcosis_way(reader1.get("narcosis_way").toString());
			ss_table_.setoperation_id(reader1.get("operation_id").toString());
			ss_table_.setposition(reader1.get("position").toString());
			ss_table_.setspecial_infection(reader1.get("special_infection").toString());
			ss_table_.setsyphilis(reader1.get("syphilis").toString());
			ss_table_.settuberculosis(reader1.get("tuberculosis").toString());
			ss_table_.setss_grade(reader1.get("ss_grade").toString());
			ss_table_.setss_type(reader1.get("ss_type").toString());
			ss_table_.setss_date((LocalDateTime)reader1.get("ss_date"));
			ss_table_.setremarks(reader1.get("remarks").toString());

		}
		return ss_table_;
	}
	/** 
	 根据int 的ss_id去拿到一行
	 
	 @param ss_id_
	 @return 
	*/
	public final ss_table getss_tableObject2(int ss_id_)
	{
		ss_table ss_table_ = new ss_table();
		String sql = String.format("select * from ss_table where ss_id = %1$s", ss_id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			ss_table_ = new ss_table();
			ss_table_.setss_id((Integer)reader1.get("ss_id"));
			ss_table_.setBH_blood(reader1.get("BH_blood").toString());
			ss_table_.setbody_position(reader1.get("body_position").toString());
			ss_table_.setcut_grade(reader1.get("cut_grade").toString());
			ss_table_.sethepatitisB(reader1.get("hepatitisB").toString());
			ss_table_.sethepatitisC(reader1.get("hepatitisC").toString());
			ss_table_.setHIV(reader1.get("HIV").toString());
			ss_table_.setnarcosis_way(reader1.get("narcosis_way").toString());
			ss_table_.setoperation_id(reader1.get("operation_id").toString());
			ss_table_.setposition(reader1.get("position").toString());
			ss_table_.setspecial_infection(reader1.get("special_infection").toString());
			ss_table_.setsyphilis(reader1.get("syphilis").toString());
			ss_table_.settuberculosis(reader1.get("tuberculosis").toString());
			ss_table_.setss_grade(reader1.get("ss_grade").toString());
			ss_table_.setss_type(reader1.get("ss_type").toString());
			ss_table_.setss_date((LocalDateTime)reader1.get("ss_date"));
			ss_table_.setremarks(reader1.get("remarks").toString());

		}
		return ss_table_;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion


}