package bll;

import Models.*;
import DAL.*;
import Utility.*;
import java.util.*;

public class nurse_tableBll
{
	private nurse_tableDal nurse_tableDal_ = new nurse_tableDal();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回nurse_table表列表222
	/** 
	 返回nurse_table表列表,采用了公共类
	 
	 @return 
	*/
	public final ArrayList<nurse_table> GetNurse_tableList1()
	{

		return nurse_tableDal_.GetNurse_tableList1();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回visit_result_table表列表222
}