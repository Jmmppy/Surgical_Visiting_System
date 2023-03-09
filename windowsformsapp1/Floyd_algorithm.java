package windowsformsapp1;

import java.util.*;

public class Floyd_algorithm
{
	private Hashtable ht_Floyd = new Hashtable(); //哈希表用于记录Floyd输出结果
	public final void star_Floyd() //main（）
	{

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region  数据结构无向图的点和边的设置
		FloydShortestPath floyd = new FloydShortestPath();
		Vertex vex0 = new Vertex(0);
		Vertex vex1 = new Vertex(1);
		Vertex vex2 = new Vertex(2);
		Vertex vex3 = new Vertex(3);
		Vertex vex4 = new Vertex(4);
		Vertex vex5 = new Vertex(5);
		Vertex vex6 = new Vertex(6);
		Vertex vex7 = new Vertex(7);
		Vertex vex8 = new Vertex(8);
		Vertex vex9 = new Vertex(9);
		Vertex vex10 = new Vertex(10);
		Vertex vex11 = new Vertex(11);
		Vertex vex12 = new Vertex(12);
		Vertex vex13 = new Vertex(13);
		Vertex vex14 = new Vertex(14);
		Vertex vex15 = new Vertex(15);
		Vertex vex16 = new Vertex(16);
		Vertex vex17 = new Vertex(17);
		Vertex vex18 = new Vertex(18);
		Vertex vex19 = new Vertex(19);
		Vertex vex20 = new Vertex(20);
		Vertex vex21 = new Vertex(21);













		Vertex[] vex = {vex0, vex1, vex2, vex3, vex4, vex5, vex6, vex7, vex8, vex9, vex10, vex11, vex12, vex13, vex14, vex15, vex16, vex17, vex18, vex19, vex20, vex21};



		Edge edge0 = new Edge(5, 1, 1);

		Edge edge1 = new Edge(1, 2, 1);

		Edge edge2 = new Edge(2, 3, 1);

		Edge edge3 = new Edge(2, 4, 1);

		Edge edge4 = new Edge(4, 0, 1);

		Edge edge5 = new Edge(0, 6, 1);

		Edge edge6 = new Edge(0, 16, 10);

		Edge edge7 = new Edge(6, 7, 1);

		Edge edge21 = new Edge(7, 8, 1);

		Edge edge8 = new Edge(8, 9, 1);

		Edge edge9 = new Edge(9, 10, 1);

		Edge edge10 = new Edge(9, 20, 10);

		Edge edge11 = new Edge(11, 12, 1);

		Edge edge12 = new Edge(12, 13, 1);

		Edge edge13 = new Edge(13, 14, 1);

		Edge edge14 = new Edge(13, 15, 1);

		Edge edge15 = new Edge(15, 16, 1);

		Edge edge16 = new Edge(16, 17, 1);

		Edge edge17 = new Edge(17, 18, 1);

		Edge edge18 = new Edge(18, 19, 1);

		Edge edge19 = new Edge(19, 20, 1);

		Edge edge20 = new Edge(20, 21, 1);




		Edge[] edge = {edge0, edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11, edge12, edge13, edge14, edge15, edge16, edge17, edge18, edge19, edge20, edge21};
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 数据结构无向图的点和边的设置
		//ht_Floyd  = new Hashtable();



		floyd.GraphAdjacencyMatrix(vex, edge);
		ht_Floyd = floyd.Floyd();

		System.out.println("---------------测试Hashtable,Keys-------------------"); //√
		for (String key : ht_Floyd.keySet())
		{
			System.out.println(key);
		}
		//Console.WriteLine("---------------测试Hashtable,Value-------------------");   //√ 
		//foreach (string key in ht_Floyd.Keys)
		//{
		//    weight_path w = (weight_path)ht_Floyd[key];      //把哈希的值（类对象）强制转换
		//    //Console.WriteLine(w.weigth);
		//    List<int> path_list = w.path;
		//    Console.WriteLine("\n");
		//    foreach (int li in path_list) 
		//    {
		//        Console.Write("->" + li);
		//    };
		//}


	}
	//函数：根据出发点和目的地 去哈希里查询 返回路径
	public final ArrayList<Integer> twoPaint_Floydpath(int paint1, int paint2, tangible.OutObject<Integer> weigth_)
	{
		System.out.println("---------------测试twoPaint_Floydpath-------------------");
		String paint = (String)(String.valueOf(paint1) + "," + String.valueOf(paint2));
		weight_path w = (weight_path)ht_Floyd.get(paint); //把哈希的值（类对象）强制转换
		weigth_.outArgValue = w.weigth;
		System.out.println(String.valueOf(w.weigth));

		//foreach (int li in w.path)
		//{
		//    Console.WriteLine(li);
		//};
		return w.path;
	}
}