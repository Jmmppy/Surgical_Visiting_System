package dal;

import Models.*;
import Utility.*;
import java.util.*;

public class operation_tableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回operation_table表列表222
	/** 
	 查询所以行对象列表，使用泛型反射
	 
	 @return 
	 
	*/
	public final ArrayList<operation_table> GetOperation_tableList1()
	{
		String sql = "select * from operation_table";

		ArrayList<operation_table> cur_operation_tableList = new ArrayList<operation_table>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			cur_operation_tableList.add(dr.<operation_table>DataRowToModel());
		}

		return cur_operation_tableList;

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回operation_table表列表222

	/** 
	 根据患者id查询operation_table对象
	 
	 @return 
	*/
	public final operation_table getOperation_tableObject(String id_)
	{
		operation_table operation_table_ = new operation_table();
		String sql = String.format("select * from operation_table where operation_id = '%1$s'", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);

		while (reader1.Read())
		{
			operation_table_ = new operation_table();
			operation_table_.setoperation_name(reader1.get("operation_name").toString());
			operation_table_.setoperation_id(reader1.get("operation_id").toString());
			operation_table_.setnote(reader1.get("note").toString());
			operation_table_.setpice_place_id(reader1.get("pice_place_id").toString());

		}
		return operation_table_;
	}


}