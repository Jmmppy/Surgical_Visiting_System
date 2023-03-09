package dal;

import Models.*;
import Utility.*;
import java.util.*;

public class visit_result_tableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回visit_result_table表列表222
	/** 
	 外连接查询到，临时表中
	 
	 @return 
	*/
	public final ArrayList<visit_result_table> GetVisit_result_tableList1()
	{
		String sql = "select * from visit_result_table";

		ArrayList<visit_result_table> cur_visit_result_list = new ArrayList<visit_result_table>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			cur_visit_result_list.add(dr.<visit_result_table>DataRowToModel());
		}

		return cur_visit_result_list;

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回visit_result_table表列表222
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region
	/** 
	 插入visit_result_table
	 
	 @param visit_Result_Table
	 @return 
	*/
	public final int insert_visit_result_table(visit_result_table visit_Result_Table)
	{
		String sql = String.format("insert into visit_result_table(illness_id, drug_allergy, sanity, condition, test_result) values") + String.format("(@illness_id, @drug_allergy, @sanity, @condition, @test_result)");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@illness_id", visit_Result_Table.illness_id), new SqlParameter("@drug_allergy", visit_Result_Table.drug_allergy), new SqlParameter("@sanity", visit_Result_Table.sanity), new SqlParameter("@condition", visit_Result_Table.condition), new SqlParameter("@test_result", visit_Result_Table.test_result));

		return row;
	}
	//跟新
	public final int update_visit_result_table(visit_result_table visit_Result_Table)
	{
		String sql = String.format("update visit_result_table set illness_id = @illness_id, drug_allergy = @drug_allergy, sanity = @sanity, condition = @condition, test_result=@test_result ") + String.format("where visit_result_id = @visit_result_id");
		int row = MyHelper.ExecuteNoteQuery(sql, new SqlParameter("@visit_result_id", visit_Result_Table.visit_result_id), new SqlParameter("@illness_id", visit_Result_Table.illness_id), new SqlParameter("@drug_allergy", visit_Result_Table.drug_allergy), new SqlParameter("@sanity", visit_Result_Table.sanity), new SqlParameter("@condition", visit_Result_Table.condition), new SqlParameter("@test_result", visit_Result_Table.test_result));

		return row;
	}
	//查找
	public final visit_result_table getvisit_result_tableObject(String id_)
	{
		visit_result_table visit_result_table_ = new visit_result_table();
		String sql = String.format("select * from visit_result_table where illness_id = '%1$s'", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			visit_result_table_ = new visit_result_table();
			visit_result_table_.setvisit_result_id((Integer)reader1.get("visit_result_id"));
			visit_result_table_.setillness_id(reader1.get("illness_id").toString());
			visit_result_table_.setdrug_allergy(reader1.get("drug_allergy").toString());
			visit_result_table_.setcondition(reader1.get("condition").toString());
			visit_result_table_.setsanity(reader1.get("sanity").toString());
			visit_result_table_.settest_result(reader1.get("test_result").toString());

		}
		return visit_result_table_;
	}
	/** 
	 根据int 的visit_result_id去拿到一行
	 
	 @param visit_result_id_
	 @return 
	*/
	public final visit_result_table getvisit_result_tableObject2(int visit_result_id_)
	{
		visit_result_table visit_result_table_ = new visit_result_table();
		String sql = String.format("select * from visit_result_table where visit_result_id = %1$s", visit_result_id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			visit_result_table_ = new visit_result_table();
			visit_result_table_.setvisit_result_id((Integer)reader1.get("visit_result_id"));
			visit_result_table_.setillness_id(reader1.get("illness_id").toString());
			visit_result_table_.setdrug_allergy(reader1.get("drug_allergy").toString());
			visit_result_table_.setcondition(reader1.get("condition").toString());
			visit_result_table_.setsanity(reader1.get("sanity").toString());
			visit_result_table_.settest_result(reader1.get("test_result").toString());

		}
		return visit_result_table_;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}