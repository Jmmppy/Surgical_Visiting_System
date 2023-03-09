package dal;

import Models.*;

public class partment_tableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 根据partment_id获取信息2222
	public final partment_table getPartment_tableObject(int partment_id)
	{
		partment_table partment_ = new partment_table();
		String sql = String.format("select * from partment_table where partment_id = %1$s", partment_id);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);
		//Console.WriteLine("1111111111111111111111111111111111");
		while (reader1.Read())
		{
			partment_ = new partment_table();
			partment_.setpartment_id((Integer)reader1.get("partment_id"));
			partment_.setpartment_name(reader1.get("partment_name").toString());

		}
		return partment_;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 根据notice_id获取信息222
}