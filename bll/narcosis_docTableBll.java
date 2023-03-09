package bll;

import Models.*;
import DAL.*;
import Utility.*;
import java.util.*;

public class narcosis_docTableBll
{
	private narcosis_docTableDal narcosis_docTableDal_ = new narcosis_docTableDal();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 返回narcosis_docTable表列表222
	/** 
	 返回narcosis_docTable表列表,采用了公共类
	 
	 @return 
	*/
	public final ArrayList<narcosis_docTable> GetNarcosis_docTableList1()
	{

		return narcosis_docTableDal_.GetNarcosis_docTableList1();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 返回narcosis_docTable表列表222


	public final narcosis_docTable getCurNarcosis_docTable(int id)
	{

		return narcosis_docTableDal_.getCurNarcosis_docTable(id);

	}
}