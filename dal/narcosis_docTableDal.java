package dal;

import Models.*;
import Utility.*;
import java.util.*;

public class narcosis_docTableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回narcosis_docTable表列表222
	/** 
	 返回narcosis_docTable表列表,采用了公共类
	 
	 @return 
	*/
	public final ArrayList<narcosis_docTable> GetNarcosis_docTableList1()
	{
		String sql = "select * from narcosis_docTable";

		ArrayList<narcosis_docTable> cur_narcosis_docTable_list = new ArrayList<narcosis_docTable>(); // 准备一个空的列表对象
		DataTable dt = MyHelper.ExecuteTable(sql);
		for (DataRow dr : dt.Rows)
		{
			cur_narcosis_docTable_list.add(dr.<narcosis_docTable>DataRowToModel());
		}

		return cur_narcosis_docTable_list;

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回narcosis_docTable表列表222

	public final narcosis_docTable getCurNarcosis_docTable(int id)
	{
		narcosis_docTable doc = new narcosis_docTable();
		String sql = "select * from narcosis_docTable where narcosis_doc_id = @narcosis_doc_id";
		SqlParameter[] paremeters = new SqlParameter[] {new SqlParameter("@narcosis_doc_id",id)};
		// doc_table newdoc = new doc_table();
		try
		{
			//调用本层的MyHelper类中的公开函数
			SqlDataReader reader = MyHelper.GetDataReader(sql, paremeters);
			if (reader.Read()) //如果有这条记录的话
			{

				doc.narcosis_doc_name = reader.get("narcosis_doc_name").toString();
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
}