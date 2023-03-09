package windowsformsapp1;

import java.util.*;

public class FloydShortestPath
{
	private int[][] matrix;
	private int vexCount;
	public final void GraphAdjacencyMatrix(Vertex[] vex, Edge[] edge)
	{

		matrix = new int[vex.length][vex.length];
		for (int i = 0; i < vex.length; i++)
		{
			for (int j = 0; j < vex.length; j++)
			{
				if (i != j)
				{
					matrix[i][j] = 1000;
				}
			}
		}
		vexCount = vex.length;

		for (int i = 0; i < edge.length; i++)
		{
			int tail = edge[i].tail;
			int head = edge[i].head;
			matrix[tail][head] = edge[i].width;
			matrix[head][tail] = edge[i].width;
		}
		System.out.println("邻接矩阵：");
		System.out.print("\t ");
		for (int i = 0; i < vex.length; i++)
		{
			System.out.print(vex[i].data + "\t ");
		}
		System.out.println("\n\n");
		for (int i = 0; i < vex.length; i++)
		{
			System.out.print(vex[i].data + "\t");
			for (int j = 0; j < vex.length; j++)
			{
				System.out.print("[" + matrix[i][j] + "]\t");
			}
			System.out.println("\n\n");
		}
	}

	public final Hashtable Floyd()
	{
		Hashtable ht_Floyd2 = new Hashtable(); //哈希表智能是局部变量
		//初始化
		int[][] Fmatrix = matrix;
		int[][] Fpath = new int[vexCount][vexCount]; //用来存储终点前一个点
		for (int i = 0; i < vexCount; i++)
		{
			for (int j = 0; j < vexCount; j++)
			{
				Fpath[i][j] = j;
			}
		}
		//核心
		for (int k = 0; k < vexCount; k++)
		{
			for (int i = 0; i < vexCount; i++)
			{
				for (int j = 0; j < vexCount; j++)
				{
					if (Fmatrix[i][j] > Fmatrix[i][k] + Fmatrix[k][j])
					{
						Fmatrix[i][j] = Fmatrix[i][k] + Fmatrix[k][j];
						Fpath[i][j] = Fpath[i][k]; //给终点记录前一个点
					}
				}
			}
		}
		//打印输出
		for (int i = 0; i < vexCount; i++)
		{
			for (int j = 0; j < vexCount; j++)
			{
				if (j != i)
				{
					System.out.print(i + " -> " + j + " weigth:" + Fmatrix[i][j] + " Path:" + i);
					//哈希表增加记录
					String cur_i = i + "," + j;
					int cur_weigth = Fmatrix[i][j];
					ArrayList<Integer> cur_path_list = new ArrayList<Integer>();
					cur_path_list.add(i);
					//哈希表增加记录
					int next = i;
					while (next != j)
					{
						System.out.print(" -> " + Fpath[next][j]);
						cur_path_list.add(Fpath[next][j]);
						next = Fpath[next][j];
					}
					ht_Floyd2.put(cur_i,new weight_path(cur_weigth, cur_path_list));
					System.out.println();
				}
			}
			System.out.println();
		}
		return ht_Floyd2;
	}
}