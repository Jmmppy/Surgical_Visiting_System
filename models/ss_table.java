package models;

import java.time.*;

/** 
 手术申请表
*/
public class ss_table
{
	private int ss_id;
	public final int getSsId()
	{
		return ss_id;
	}
	public final void setSsId(int value)
	{
		ss_id = value;
	}
	private String ss_type;
	public final String getSsType()
	{
		return ss_type;
	}
	public final void setSsType(String value)
	{
		ss_type = value;
	}
	private LocalDateTime ss_date = LocalDateTime.MIN;
	public final LocalDateTime getSsDate()
	{
		return ss_date;
	}
	public final void setSsDate(LocalDateTime value)
	{
		ss_date = value;
	}
	private String operation_id;
	public final String getOperationId()
	{
		return operation_id;
	}
	public final void setOperationId(String value)
	{
		operation_id = value;
	}
	private String ss_grade;
	public final String getSsGrade()
	{
		return ss_grade;
	}
	public final void setSsGrade(String value)
	{
		ss_grade = value;
	}
	private String position;
	public final String getPosition()
	{
		return position;
	}
	public final void setPosition(String value)
	{
		position = value;
	}
	private String body_position;
	public final String getBodyPosition()
	{
		return body_position;
	}
	public final void setBodyPosition(String value)
	{
		body_position = value;
	}
	private String narcosis_way;
	public final String getNarcosisWay()
	{
		return narcosis_way;
	}
	public final void setNarcosisWay(String value)
	{
		narcosis_way = value;
	}
	private String cut_grade;
	public final String getCutGrade()
	{
		return cut_grade;
	}
	public final void setCutGrade(String value)
	{
		cut_grade = value;
	}
	private String hepatitisB;
	public final String getHepatitisB()
	{
		return hepatitisB;
	}
	public final void setHepatitisB(String value)
	{
		hepatitisB = value;
	}
	private String hepatitisC;
	public final String getHepatitisC()
	{
		return hepatitisC;
	}
	public final void setHepatitisC(String value)
	{
		hepatitisC = value;
	}
	private String syphilis;
	public final String getSyphilis()
	{
		return syphilis;
	}
	public final void setSyphilis(String value)
	{
		syphilis = value;
	}
	private String HIV;
	public final String getHIV()
	{
		return HIV;
	}
	public final void setHIV(String value)
	{
		HIV = value;
	}
	private String tuberculosis;
	public final String getTuberculosis()
	{
		return tuberculosis;
	}
	public final void setTuberculosis(String value)
	{
		tuberculosis = value;
	}
	private String special_infection;
	public final String getSpecialInfection()
	{
		return special_infection;
	}
	public final void setSpecialInfection(String value)
	{
		special_infection = value;
	}
	private String BH_blood;
	public final String getBHBlood()
	{
		return BH_blood;
	}
	public final void setBHBlood(String value)
	{
		BH_blood = value;
	}
	private String remarks;
	public final String getRemarks()
	{
		return remarks;
	}
	public final void setRemarks(String value)
	{
		remarks = value;
	}

	private String illness_id;
	public final String getIllnessId()
	{
		return illness_id;
	}
	public final void setIllnessId(String value)
	{
		illness_id = value;
	}

}