package models;

import java.time.*;

public class cur_ss_visitTable
{
	//9
	/** 
	 临时表
	*/
	private String illness_id;
	public final String getIllnessId()
	{
		return illness_id;
	}
	public final void setIllnessId(String value)
	{
		illness_id = value;
	}
	private String patient_name;
	public final String getPatientName()
	{
		return patient_name;
	}
	public final void setPatientName(String value)
	{
		patient_name = value;
	}
	private LocalDateTime operation_date = LocalDateTime.MIN;
	public final LocalDateTime getOperationDate()
	{
		return operation_date;
	}
	public final void setOperationDate(LocalDateTime value)
	{
		operation_date = value;
	}
	private String operation_room;
	public final String getOperationRoom()
	{
		return operation_room;
	}
	public final void setOperationRoom(String value)
	{
		operation_room = value;
	}
	//public DateTime start_time { get; set; }
	//public DateTime visit_time { get; set; }
	private LocalDateTime narcosis_time = LocalDateTime.MIN;
	public final LocalDateTime getNarcosisTime()
	{
		return narcosis_time;
	}
	public final void setNarcosisTime(LocalDateTime value)
	{
		narcosis_time = value;
	}
	//public int department_id { get; set; }
	//public string pice_place_id { get; set; }
	private String operation_name;
	public final String getOperationName()
	{
		return operation_name;
	}
	public final void setOperationName(String value)
	{
		operation_name = value;
	}
	private String doc_name;
	public final String getDocName()
	{
		return doc_name;
	}
	public final void setDocName(String value)
	{
		doc_name = value;
	}
	private String narcosis_doc_name;
	public final String getNarcosisDocName()
	{
		return narcosis_doc_name;
	}
	public final void setNarcosisDocName(String value)
	{
		narcosis_doc_name = value;
	}
	private String nurse_name;
	public final String getNurseName()
	{
		return nurse_name;
	}
	public final void setNurseName(String value)
	{
		nurse_name = value;
	}
	private String sickroom;
	public final String getSickroom()
	{
		return sickroom;
	}
	public final void setSickroom(String value)
	{
		sickroom = value;
	}
	private int visit_result_id;
	public final int getVisitResultId()
	{
		return visit_result_id;
	}
	public final void setVisitResultId(int value)
	{
		visit_result_id = value;
	}
	private boolean isSelect;
	public final boolean isSelect()
	{
		return isSelect;
	}
	public final void setSelect(boolean value)
	{
		isSelect = value;
	}
	private boolean is_ss;
	public final boolean isSs()
	{
		return is_ss;
	}
	public final void setSs(boolean value)
	{
		is_ss = value;
	}
	//新加
	private boolean is_bool1;
	public final boolean isBool1()
	{
		return is_bool1;
	}
	public final void setBool1(boolean value)
	{
		is_bool1 = value;
	}
	private boolean is_bool2;
	public final boolean isBool2()
	{
		return is_bool2;
	}
	public final void setBool2(boolean value)
	{
		is_bool2 = value;
	}
	private boolean is_bool3;
	public final boolean isBool3()
	{
		return is_bool3;
	}
	public final void setBool3(boolean value)
	{
		is_bool3 = value;
	}

}