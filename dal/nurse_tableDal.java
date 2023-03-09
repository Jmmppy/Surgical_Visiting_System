package dal;

import Models.*;
import Utility.*;
import java.util.*;

public class nurse_tableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回nurse_table表列表222
	/** 
	 返回nurse_table表列表,采用了公共类
	 
	 @return 
	*/
	public final ArrayList<nurse_table> GetNurse_tableList1()
	{
		String sql = "select * from nurse_table";

		ArrayList<nurse_table> cur_nurse_table_list = new ArrayList<nurse_table>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			cur_nurse_table_list.add(dr.<nurse_table>DataRowToModel());
		}

		return cur_nurse_table_list;

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回visit_result_table表列表222
}