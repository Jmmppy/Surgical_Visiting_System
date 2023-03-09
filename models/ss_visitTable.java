package models;

import java.time.*;

public class ss_visitTable
{
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
	private LocalDateTime start_time = LocalDateTime.MIN;
	public final LocalDateTime getStartTime()
	{
		return start_time;
	}
	public final void setStartTime(LocalDateTime value)
	{
		start_time = value;
	}
	private LocalDateTime visit_time = LocalDateTime.MIN;
	public final LocalDateTime getVisitTime()
	{
		return visit_time;
	}
	public final void setVisitTime(LocalDateTime value)
	{
		visit_time = value;
	}
	private LocalDateTime narcosis_time = LocalDateTime.MIN;
	public final LocalDateTime getNarcosisTime()
	{
		return narcosis_time;
	}
	public final void setNarcosisTime(LocalDateTime value)
	{
		narcosis_time = value;
	}
	private int department_id;
	public final int getDepartmentId()
	{
		return department_id;
	}
	public final void setDepartmentId(int value)
	{
		department_id = value;
	}
	private String pice_place_id;
	public final String getPicePlaceId()
	{
		return pice_place_id;
	}
	public final void setPicePlaceId(String value)
	{
		pice_place_id = value;
	}
	private String operate_id;
	public final String getOperateId()
	{
		return operate_id;
	}
	public final void setOperateId(String value)
	{
		operate_id = value;
	}
	private int doc_id;
	public final int getDocId()
	{
		return doc_id;
	}
	public final void setDocId(int value)
	{
		doc_id = value;
	}
	private int narcosis_doc_id;
	public final int getNarcosisDocId()
	{
		return narcosis_doc_id;
	}
	public final void setNarcosisDocId(int value)
	{
		narcosis_doc_id = value;
	}
	private int nurse_id;
	public final int getNurseId()
	{
		return nurse_id;
	}
	public final void setNurseId(int value)
	{
		nurse_id = value;
	}

	//新加
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