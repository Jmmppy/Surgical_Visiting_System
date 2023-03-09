package dal;

import Models.*;

public class Doc_loginDal
{
	/** 
	 处理登录时，如果输入的id 和密码有记录则返回一条有全部8个字段的记录
	 
	 @param doc
	 @return 
	*/
	public final doc_table UserLogin(doc_table doc)
	{
		String sql = "select doctor_id,pwd from doc_table where doctor_id = @doctor_id and pwd = @pwd";
		SqlParameter[] paremeters = new SqlParameter[]
		{
			new SqlParameter("@doctor_id",doc.doctor_id),
			new SqlParameter("@pwd",doc.pwd)
		};
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

	//登录方法二
	public final boolean login(doc_table doc)
	{
		boolean res = false;
		try (SqlConnection m_cnADONetConnection = new SqlConnection())
		{
			m_cnADONetConnection.ConnectionString = connection.connect_str;

			SqlCommand cmd = m_cnADONetConnection.CreateCommand();
			String sql = "select count(*)from doc_table where doctor_id=@doctor_id and pwd = @pwd";
			cmd.CommandText = sql;

			cmd.Parameters.AddWithValue("@doctor_id", doc.doctor_id);
			cmd.Parameters.AddWithValue("@pwd", doc.pwd);
			m_cnADONetConnection.Open();
			int result = (Integer)cmd.ExecuteScalar();
			if (result == 1)
			{
				res = true;
			}
		}
		return res;
	}
}