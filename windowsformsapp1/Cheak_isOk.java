package windowsformsapp1;

import java.util.*;

public class Cheak_isOk
{
	private ArrayList<String> strList = new ArrayList<String>(Arrays.asList("我操", "cao", "操", "风骚", "诱惑", "卧槽"));

	public final boolean Word_Cheak_is_OK(String str)
	{
		for (var item : strList)
		{
			if (str.contains(item))
			{
				return true;
			}
		}
		return false;
	}
}