package models;

import Utility.*;
import java.time.*;

public class meeting_table
{
	private int meeting_id;
	public final int getMeetingId()
	{
		return meeting_id;
	}
	public final void setMeetingId(int value)
	{
		meeting_id = value;
	}
	private String meeting_name;
	public final String getMeetingName()
	{
		return meeting_name;
	}
	public final void setMeetingName(String value)
	{
		meeting_name = value;
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
	private LocalDateTime end_time = LocalDateTime.MIN;
	public final LocalDateTime getEndTime()
	{
		return end_time;
	}
	public final void setEndTime(LocalDateTime value)
	{
		end_time = value;
	}
	private int illness_id_count;
	public final int getIllnessIdCount()
	{
		return illness_id_count;
	}
	public final void setIllnessIdCount(int value)
	{
		illness_id_count = value;
	}
	private String meeting_Key;
	public final String getMeetingKey()
	{
		return meeting_Key;
	}
	public final void setMeetingKey(String value)
	{
		meeting_Key = value;
	}

	private String illness_id1;
	public final String getIllnessId1()
	{
		return illness_id1;
	}
	public final void setIllnessId1(String value)
	{
		illness_id1 = value;
	}
	private String illness_id2;
	public final String getIllnessId2()
	{
		return illness_id2;
	}
	public final void setIllnessId2(String value)
	{
		illness_id2 = value;
	}
	private String illness_id3;
	public final String getIllnessId3()
	{
		return illness_id3;
	}
	public final void setIllnessId3(String value)
	{
		illness_id3 = value;
	}
	private boolean ismetting;
	public final boolean getIsmetting()
	{
		return ismetting;
	}
	public final void setIsmetting(boolean value)
	{
		ismetting = value;
	}
	private int Belong_doc;
	public final int getBelongDoc()
	{
		return Belong_doc;
	}
	public final void setBelongDoc(int value)
	{
		Belong_doc = value;
	}
}