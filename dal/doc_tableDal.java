package dal;

import Models.*;

public class doc_tableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 查询doc_table表记录
	public final doc_table getCurDoc_table(int id)
	{
		doc_table doc = new doc_table();
		String sql = "select * from doc_table where doctor_id = @doctor_id";
		SqlParameter[] paremeters = new SqlParameter[] {new SqlParameter("@doctor_id",id)};
		// doc_table newdoc = new doc_table();
		try
		{
			//调用本层的MyHelper类中的公开函数
			SqlDataReader reader = MyHelper.GetDataReader(sql, paremeters);
			if (reader.Read()) //如果有这条记录的话
			{
				doc.doc_name = reader.get("doc_name").toString();
				doc.pice_place = reader.get("pice_place").toString();
				doc.profession = reader.get("profession").toString();
				doc.sex = reader.get("sex").toString();
				doc.age = reader.get("age").toString();
				doc.phone = reader.get("phone").toString();
				doc.partment_id = (Integer)reader.get("partment_id");

			}
			else
			{
				doc = null;
			}
			reader.Close();
		}
		catch (RuntimeException ex)
		{
			throw ex;
		}
		return doc;

	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 查询doc_table表记录
}