package bll;

import Models.*;
import DAL.*;

public class doc_tableBll
{
	// 初始化Dal对象
	private doc_tableDal _doc_tableDal = new doc_tableDal();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 查询doc_table表一条记录
	public final doc_table getCurDoc_table(int id)
	{

		return _doc_tableDal.getCurDoc_table(id);

	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 查询doc_table表记录
}