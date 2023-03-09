package models;

public class visit_result_table
{
	private int visit_result_id;
	public final int getVisitResultId()
	{
		return visit_result_id;
	}
	public final void setVisitResultId(int value)
	{
		visit_result_id = value;
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
	private String drug_allergy;
	public final String getDrugAllergy()
	{
		return drug_allergy;
	}
	public final void setDrugAllergy(String value)
	{
		drug_allergy = value;
	}
	private String sanity;
	public final String getSanity()
	{
		return sanity;
	}
	public final void setSanity(String value)
	{
		sanity = value;
	}
	private String condition;
	public final String getCondition()
	{
		return condition;
	}
	public final void setCondition(String value)
	{
		condition = value;
	}
	private String test_result;
	public final String getTestResult()
	{
		return test_result;
	}
	public final void setTestResult(String value)
	{
		test_result = value;
	}


}