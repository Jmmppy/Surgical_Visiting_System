package bll;

import Models.*;
import DAL.*;

public class partment_tableBll
{
	private partment_tableDal partment_tableDal_ = new partment_tableDal(); // 初始化DAL层的partment_tableDal类对象

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 根据partment_id获取信息2222
	public final partment_table getPartment_tableObject(int partment_id)
	{

		return partment_tableDal_.getPartment_tableObject(partment_id);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 根据notice_id获取信息222
}