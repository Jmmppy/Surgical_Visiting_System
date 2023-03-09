package bll;

import DAL.*;
import Models.*;

/** 
 登录业务逻辑类
*/
public class Doc_loginBLL
{
	//实例化DAL登录类对象
	private Doc_loginDal _LoginDal = new Doc_loginDal();

	public final doc_table UserLogin(doc_table doc)
	{
		return _LoginDal.UserLogin(doc); //返回DAL对象里的方法
	}

	//登录方法二
	public final boolean login(doc_table doc)
	{

		boolean result = _LoginDal.login(doc);

		return result;
	}
}