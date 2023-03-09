package dal;

import Models.*;
import java.util.*;
import java.time.*;

/** 
对notice_table表的数据访问层的操作
*/
public class notice_tableDal
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回notice表列表
	/** 
	 读取notice表的全部对象，返回到界面的DataGridVie里
	 
	 @return 
	*/
	public final ArrayList<notice_table> Getnotice_TableList()
	{
		String sql = "select * from notice_table";
		ArrayList<notice_table> notices_list = new ArrayList<notice_table>(); // 准备一个空的列表对象
		SqlDataReader dataReader = MyHelper.GetDataReader(sql); // 这个有问题？？？？？？
		//Console.WriteLine();
		System.out.println("read:" + dataReader.Read());
		while (dataReader.Read())
		{
			System.out.println("11111111111");
			//问题要不要写全？？？ 不要写完整
			notice_table tempVar = new notice_table();
			tempVar.setnotice_id((Integer)dataReader.get("notice_id"));
			tempVar.settitle(dataReader.get("title").toString());
			tempVar.setnotice_date((LocalDateTime)dataReader.get("notice_date"));
			notices_list.add(tempVar);
		}
		dataReader.Close(); //采用了close进行手动关闭。
		return notices_list;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回notice表列表

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 根据notice_id获取信息
	public final notice_table getCurNotice_table(int id)
	{
		notice_table notice_ = new notice_table();
		String sql = "select * from notice_table where notice_id = @notice_id";
		//SqlParameter paremeters = new SqlParameter("@notice_id", id);
		SqlParameter[] paremeters = new SqlParameter[] {new SqlParameter("@notice_id",id)};
		// doc_table newdoc = new doc_table();
		try
		{
			//调用本层的MyHelper类中的公开函数
			SqlDataReader reader = MyHelper.GetDataReader(sql, paremeters);
			if (reader.Read()) //如果有这条记录的话
			{
				notice_.notice_id = (Integer)reader.get("notice_id");
				notice_.message = reader.get("message").toString();
				notice_.title = reader.get("title").toString();
				notice_.notice_date = (LocalDateTime)reader.get("notice_date");
				notice_.notice_man = reader.get("notice_man").toString();


			}
			else
			{
				notice_ = null;
			}
			//reader.Close();
		}
		catch (RuntimeException ex)
		{
			throw ex;
		}
		return notice_;

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 根据notice_id获取信息


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 根据notice_id获取信息2222
	public final notice_table getCurNoticeObject(int id_)
	{
		notice_table notice_ = new notice_table();
		String sql = String.format("select * from notice_table where notice_id = %1$s", id_);
		SqlDataReader reader1 = MyHelper.GetDataReader(sql);
		System.out.println("1111111111111111111111111111111111");
		while (reader1.Read())
		{
			notice_ = new notice_table();
			notice_.setnotice_id((Integer)reader1.get("notice_id"));
			notice_.settitle(reader1.get("title").toString());
			notice_.setmessage(reader1.get("message").toString());
			notice_.setnotice_date((LocalDateTime)reader1.get("notice_date"));
			notice_.setnotice_man(reader1.get("notice_man").toString());

		}
		return notice_;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 根据notice_id获取信息222
}