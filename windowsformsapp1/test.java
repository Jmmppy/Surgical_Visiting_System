package windowsformsapp1;

public class test extends Form
{
	private static int node = 22;
	public test()
	{
		InitializeComponent();
	}

	private void test_Load(Object sender, tangible.EventArgs e)
	{
		init();
		ShortestPathByDijkstra();
	}

	private void init()
	{
		for (int i = 0; i < node; i++)
		{
			for (int j = 0;j < node; j++)
			{
				graph[i][j] = 10000; //初始化全为不通
			}
		}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 无向图连通设置
		graph[5][1] = 1;
		graph[1][5] = 1;
		graph[1][2] = 1;
		graph[2][1] = 1;
		graph[2][3] = 1;
		graph[3][2] = 1;
		graph[2][4] = 1;
		graph[4][2] = 1;
		graph[4][0] = 1;
		graph[0][4] = 1;
		graph[0][6] = 1;
		graph[6][0] = 1;
		graph[0][16] = 10;
		graph[16][0] = 10;
		graph[6][7] = 1;
		graph[7][6] = 1;
		graph[8][9] = 1;
		graph[9][8] = 1;
		graph[9][10] = 1;
		graph[10][9] = 1;
		graph[9][20] = 10;
		graph[20][9] = 10;
		//

		graph[11][12] = 1;
		graph[12][11] = 1;
		graph[12][13] = 1;
		graph[13][12] = 1;
		graph[13][14] = 1;
		graph[14][13] = 1;
		graph[13][15] = 1;
		graph[15][13] = 1;
		graph[15][16] = 1;
		graph[16][15] = 1;
		graph[16][17] = 1;
		graph[17][16] = 1;
		graph[17][18] = 1;
		graph[18][17] = 1;
		graph[18][19] = 1;
		graph[19][18] = 1;
		graph[19][20] = 1;
		graph[20][19] = 1;
		graph[20][21] = 1;
		graph[21][20] = 1;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 无向图连通设置


		for (int i = 0; i < node; i++)
		{
			S[i] = 0;
			mid[i] = "";
		}
	}

	private static int[][] graph = new int[node][node];
	private static int[] S = new int[node]; //最短路径的顶点集合
	private static String[] mid = new String[node]; //点的路线


	public static int IsContain(int m) //判断元素是否在mst中
	{
		int index = -1;
		for (int i = 1; i < node; i++)
		{
			if (S[i] == m)
			{
				index = i;
			}
		}
		return index;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Dijkstrah实现最短路算法
	/** 
	 Dijkstrah实现最短路算法
	*/
	private static void ShortestPathByDijkstra()
	{
		int min;
		int next;

		for (int f = node-1; f > 0; f--)
		{
			//置为初始值

			min = 1000;
			next = 0; //第一行最小的元素所在的列 next点
			//找出第一行最小的列值
			for (int j = 1; j < node; j++) //循环第0行的列
			{
				if ((IsContain(j) == -1) && (graph[0][j] < min)) //不在S中,找出第一行最小的元素所在的列
				{
					min = graph[0][j];
					next = j;
				}
			}
			//将下一个点加入S
			S[next] = next;
			//输出最短距离和路径
			if (min == 1000)
			{
				System.out.printf("V0到V%1$s的最短路径为：无" + "\r\n", next);
			}
			else
			{
				System.out.printf("V0到V%1$s的最短路径为：%2$s,路径为：V0%3$s->V%1$s" + "\r\n", next, min, mid[next]);
			}
			// 重新初始0行所有列值
			for (int j = 1; j < node; j++) //循环第0行的列
			{
				if (IsContain(j) == -1) //初始化除包含在S中的
				{
					if ((graph[next][j] + min) < graph[0][j]) //如果小于原来的值就替换
					{
						graph[0][j] = graph[next][j] + min;
						mid[j] = mid[next] + "->V" + next; //记录过程点
					}
				}
			}

		}

	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion Dijkstrah实现最短路算法









	/** 
	 Required designer variable.
	*/
	private System.ComponentModel.IContainer components = null;

	/** 
	 Clean up any resources being used.
	 
	 @param disposing true if managed resources should be disposed; otherwise, false.
	*/
	@Override
	protected void Dispose(boolean disposing)
	{
		if (disposing && (components != null))
		{
			components.Dispose();
		}
		super.Dispose(disposing);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Windows Form Designer generated code

	/** 
	 Required method for Designer support - do not modify
	 the contents of this method with the code editor.
	*/
	private void InitializeComponent()
	{
		this.SuspendLayout();
		// 
		// test
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(800, 450);
		this.Name = "test";
		this.Text = "test";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.test_Load);
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}