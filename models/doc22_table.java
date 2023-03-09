package models;

/** 
 这个才是真正的医生表，doc_table那个是变成登录表
*/
public class doc22_table
{
	private int doctor_id;
	public final int getDoctorId()
	{
		return doctor_id;
	}
	public final void setDoctorId(int value)
	{
		doctor_id = value;
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
	private String pice_place;
	public final String getPicePlace()
	{
		return pice_place;
	}
	public final void setPicePlace(String value)
	{
		pice_place = value;
	}
	private String profession;
	public final String getProfession()
	{
		return profession;
	}
	public final void setProfession(String value)
	{
		profession = value;
	}
	private String sex;
	public final String getSex()
	{
		return sex;
	}
	public final void setSex(String value)
	{
		sex = value;
	}
	private String age;
	public final String getAge()
	{
		return age;
	}
	public final void setAge(String value)
	{
		age = value;
	}
	private String phone;
	public final String getPhone()
	{
		return phone;
	}
	public final void setPhone(String value)
	{
		phone = value;
	}
	private String pwd;
	public final String getPwd()
	{
		return pwd;
	}
	public final void setPwd(String value)
	{
		pwd = value;
	}
	private int partment_id;
	public final int getPartmentId()
	{
		return partment_id;
	}
	public final void setPartmentId(int value)
	{
		partment_id = value;
	}
}