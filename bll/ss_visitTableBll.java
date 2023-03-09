package bll;

import Models.*;
import DAL.*;
import java.util.*;

public class ss_visitTableBll
{
	private ss_visitTableDal ss_VisitTable = new ss_visitTableDal();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_visitTable表列表 不用

	public final ArrayList<ss_visitTable> GetSs_visitTableList()
	{

		return ss_VisitTable.GetSs_visitTableList();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回ss_visitTable表列表222

	public final ArrayList<cur_ss_visitTable> GetSs_visitTableList1()
	{

		return ss_VisitTable.GetSs_visitTableList1();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回ss_visitTable表列表222

	public final int update_ss_visitTable(ss_visitTable ss_visitTable_)
	{

		return ss_VisitTable.update_ss_visitTable(ss_visitTable_);
	}

	public final int update_ss_visitTable2(ss_visitTable ss_visitTable_)
	{


		return ss_VisitTable.update_ss_visitTable2(ss_visitTable_);
	}

	public final int update_ss_visitTable3(ss_visitTable ss_visitTable_)
	{

		return ss_VisitTable.update_ss_visitTable3(ss_visitTable_);
	}

	public final int update_ss_visitTable4(ss_visitTable ss_visitTable_)
	{

		return ss_VisitTable.update_ss_visitTable4(ss_visitTable_);
	}
	/** 
	 根据患者id查询cur_ss_visitTable对象。
	 
	 @return 
	*/
	public final cur_ss_visitTable getcur_ss_visitTableObject(String id_)
	{

		return ss_VisitTable.getcur_ss_visitTableObject(id_);
	}


	/** 
	 根据患者id查询ss_visitTable对象
	 
	 @return 
	*/
	public final ss_visitTable getss_visitTableObject(String id_)
	{

		return ss_VisitTable.getss_visitTableObject(id_);
	}

}