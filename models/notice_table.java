package models;

import java.time.*;

//这里【notice_date】：2020-01-26，【notice_time】12：25：34 ,都对应的是C# 的DateTime可能不对
public class notice_table
{
	private int notice_id;
	public final int getNoticeId()
	{
		return notice_id;
	}
	public final void setNoticeId(int value)
	{
		notice_id = value;
	}
	private String title;
	public final String getTitle()
	{
		return title;
	}
	public final void setTitle(String value)
	{
		title = value;
	}
	private String message;
	public final String getMessage()
	{
		return message;
	}
	public final void setMessage(String value)
	{
		message = value;
	}
	private LocalDateTime notice_date = LocalDateTime.MIN;
	public final LocalDateTime getNoticeDate()
	{
		return notice_date;
	}
	public final void setNoticeDate(LocalDateTime value)
	{
		notice_date = value;
	}
	// public DateTime notice_time { get; set; }
	private String notice_man;
	public final String getNoticeMan()
	{
		return notice_man;
	}
	public final void setNoticeMan(String value)
	{
		notice_man = value;
	}
}