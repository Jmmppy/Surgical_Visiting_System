package windowsformsapp1;

import java.util.*;

//类2方便哈希表的操作
public class weight_path
{
	public int weigth;
	public ArrayList<Integer> path;
	public weight_path(int weigth, ArrayList<Integer> path)
	{
		this.weigth = weigth;
		this.path = path;
	}
	public final int get_weigth()
	{
		return weigth;
	}
	public final ArrayList<Integer> get_path()
	{
		return path;
	}
	public final void output()
	{

	}
}