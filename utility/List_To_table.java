package utility;

import java.util.*;

public class List_To_table
{
	public static <T> DataTable ToDataTable(java.lang.Iterable<T> list)
	{
		PropertyInfo[] modelItemType = T.class.GetProperties();
		DataTable dataTable = new DataTable();
		dataTable.Columns.AddRange(modelItemType.Select(Columns -> new DataColumn(Columns.Name, Columns.PropertyType)).ToArray());
		if (list.size() > 0)
		{
			for (int i = 0; i < list.size(); i++)
			{
				ArrayList tempList = new ArrayList();
				for (PropertyInfo pi : modelItemType)
				{
					Object obj = pi.GetValue(list.ElementAt(i), null);
					tempList.add(obj);
				}
				Object[] dataRow = tempList.toArray(new Object[0]);
				dataTable.LoadDataRow(dataRow, true);
			}
		}
		return dataTable;
	}

}