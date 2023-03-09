package bll;

import Models.*;
import DAL.*;
import java.util.*;

public class notice_tableBll
{
	private notice_tableDal notice_TableDal_ = new notice_tableDal(); // 初始化DAL层的notice_tableDal类对象
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回notice表列表
	/** 
	 读取notice表的全部对象，返回到界面的DataGridVie里
	 
	 @return 
	*/
	public final ArrayList<notice_table> Getnotice_TableList()
	{
		//调用DAL层的notice_tableDal类的一个方法
		return notice_TableDal_.Getnotice_TableList();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回notice表列表


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 根据notice_id获取信息
	public final notice_table getCurNotice_table(int id)
	{

		return notice_TableDal_.getCurNotice_table(id);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 根据notice_id获取信息

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 根据notice_id获取信息2222
	public final notice_table getCurNoticeObject(int id)
	{

		return notice_TableDal_.getCurNoticeObject(id);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 根据notice_id获取信息222
}