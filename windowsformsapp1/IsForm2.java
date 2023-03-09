package windowsformsapp1;

import Models.*;
import BLL.*;
import java.util.*;

public class IsForm2 extends Form
{
	public IsForm2()
	{
		InitializeComponent();
	}
	private boolean whether_right_click;
	private boolean whether_left_click;
	private int data_index;
	private ss_visitTableBll ss_visitTableBll_;
	private ArrayList<cur_ss_visitTable> cur_ss_visitTable_;
	private cur_ss_visitTable[] table_list;
	private Create_Meeting1 Form_Create_Meeting1; // 窗体对象
	private Create_Meeting2 Form_Create_Meeting2; // 窗体对象
	private int table_length;
	//
	private String patient_name_;
	private String operation_name_;
	private boolean is_visit;
	private int page = 0; //标记左右键的翻页
	private ArrayList<Integer> panl_click_indexList = new ArrayList<Integer>();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region panl控件是否点击
	private boolean panl1_double_Click;
	private boolean panl2_double_Click;
	private boolean panl3_double_Click;
	private boolean panl4_double_Click;
	private boolean panl5_double_Click;
	private boolean panl6_double_Click;
	private boolean panl7_double_Click;
	private boolean panl8_double_Click;


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion panl控件是否点击
	private void IsForm2_Load(Object sender, tangible.EventArgs e)
	{
		ss_visitTableBll_ = new ss_visitTableBll(); //Bll对象
		is_visit = this.chk_isvisit.Checked; ////////////////////
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 默认是有选择的
		patient_name_ = this.txtname1.Text.strip();
		operation_name_ = this.txtname2.Text.strip();
		is_visit = this.chk_isvisit.Checked;
		//MessageBox.Show(string.Format("成功{0}", is_visit));
		cur_ss_visitTable_ = tangible.ListHelper.findAll(ss_visitTableBll_.GetSs_visitTableList1(), m -> m.patient_name.Contains(patient_name_) && m.operation_name.Contains(operation_name_) && m.is_bool1 == true && m.is_bool2 == false);

		// 是否被悬着过
		//cur_ss_visitTable_ = ss_visitTableBll_.GetSs_visitTableList1().FindAll(m => m.patient_name.Contains(patient_name_) && m.operation_name.Contains(operation_name_) && m.isSelect == is_visit);
		Collections.sort(cur_ss_visitTable_, (x, y) -> x.narcosis_time.CompareTo(y.narcosis_time)); // narcosis_time时间排序
		table_list = cur_ss_visitTable_.toArray(new cur_ss_visitTable[0]);
		table_length = table_list.length; // 数据表对象长度;
		data_index = 0;
		data_card(table_list, table_length); ///////////////
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 默认是有选择的
	}

	private void data_card(cur_ss_visitTable[] table_list, int table_length)
	{
		for (int i = data_index; i < table_length;) //i 绑定数据库的表数据的索引
		{

			int j = 0; //j 用于记录8个panel框的哪一个
			//int x = this.Controls.Count;                                                      // this.Controls.Count; 改控件的子控件，计数
			for (int _ = this.Controls.Count - 1; _ >= 0; _--) // 循环this窗体的索引子控件
			{
				Control panel_cc = this.Controls[_];

				if (panel_cc instanceof Panel)
				{
					// int x = this.Controls.GetChildIndex(panel_cc);
					panel_cc.Controls[4].Text = table_list[i].narcosis_time.toString();
					panel_cc.Controls[5].Text = table_list[i].patient_name.toString();
					panel_cc.Controls[6].Text = table_list[i].operation_room.toString();
					panel_cc.Controls[7].Text = table_list[i].operation_name.toString();
					//panel_cc.Controls[7].Text = table_list[i].sickroom.ToString();   //   证明可以拿到sickroom
					i++;
					j++;
					data_index++;
					if (i >= table_length || j > 7) // 数据显示完，或者框体超过8
					{
						j = this.Controls.GetChildIndex(panel_cc);
						break;
					}
				}

			}


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#region 窗体显示
			if (whether_left_click == true)
			{
				for (int _ = 0; _ < this.Controls.Count; _++)
				{
					if (this.Controls[_] instanceof Panel)
					{
						this.Controls[_].Show();

					}
				}
				whether_left_click = false;
			}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#endregion 窗体显示


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#region 窗体隐藏
			for (int _ = 0; _ < this.Controls.Count && _ < j; _++)
			{
				if (this.Controls[_] instanceof Panel)
				{
					this.Controls[_].Hide();

				}
			}
			break;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#endregion 窗体隐藏


		}
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 左右键的翻页
	private void pBx_right_Click(Object sender, tangible.EventArgs e)
	{
		if (page >= table_length / 8)
		{
			return;
		}
		else
		{
			page++;
			whether_right_click = true;
			//窗体背景恢复
			Form_panel_refaind();
			/**  data_card方法中有data_index的++ 所以不用加减8
			*/
			data_card(table_list, table_length);
		}




	}

	private void pBx_left_Click(Object sender, tangible.EventArgs e)
	{


		if (page == 0 || data_index < 8) /////////////
		{
			//this.pBx_left.Enabled = false;
			return;
		}
		else
		{
			page--;
			whether_left_click = true;
			//窗体背景恢复
			Form_panel_refaind();
			data_index = (data_index - 8) / 8; /// data_index 必须是8的整数被
			data_card(table_list, table_length);
		}


	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 左右键的翻页



//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 筛选按钮
	private void btnSelect_Click(Object sender, tangible.EventArgs e)
	{
		getdata();

		//MessageBox.Show(string.Format("成功{0}", data_index));
	}
	/** 
	 获取筛选数据的方法，把符合条件的数据放在列表中
	*/
	private void getdata()
	{
		patient_name_ = this.txtname1.Text.strip();
		operation_name_ = this.txtname2.Text.strip();
		is_visit = this.chk_isvisit.Checked;
		//MessageBox.Show(string.Format("成功{0}", is_visit));
		cur_ss_visitTable_ = tangible.ListHelper.findAll(ss_visitTableBll_.GetSs_visitTableList1(), m -> m.patient_name.Contains(patient_name_) && m.operation_name.Contains(operation_name_) && m.is_bool1 == true && m.is_bool2 == false);

		// 是否被悬着过
		//cur_ss_visitTable_ = ss_visitTableBll_.GetSs_visitTableList1().FindAll(m => m.patient_name.Contains(patient_name_) && m.operation_name.Contains(operation_name_) && m.isSelect == is_visit);
		Collections.sort(cur_ss_visitTable_, (x, y) -> x.narcosis_time.CompareTo(y.narcosis_time)); // narcosis_time时间排序
		table_list = cur_ss_visitTable_.toArray(new cur_ss_visitTable[0]);
		table_length = table_list.length; // 数据表对象长度;
		data_index = 0;
		whether_left_click = true;
		if (table_length == 0)
		{
			MessageBox.Show(String.format("没有数据"));

		}
		data_card(table_list, table_length);
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion  筛选按钮

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 8个panl双击事件
	private void panel1_DoubleClick(Object sender, tangible.EventArgs e)
	{

		int idx = 0;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		//List<int> panel_DoubleClick_;
		//panel_DoubleClick_.Add(listIndex);        //// 有什么问题？？？
		//Console.WriteLine(table_list[listIndex].patient_name.ToString());
		System.out.println(table_list[listIndex].patient_name.toString());
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//if (Form_Create_Meeting1.ShowDialog() == DialogResult.OK)
		//{
		//    //窗体背景恢复
		//    Form_panel_refaind();
		//}
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();

	}

	private void panel2_DoubleClick(Object sender, tangible.EventArgs e)
	{
		int idx = 1;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		System.out.println(table_list[listIndex].patient_name.toString());
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();
	}

	private void panel3_DoubleClick(Object sender, tangible.EventArgs e)
	{
		int idx = 2;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		System.out.println(table_list[listIndex].patient_name.toString());
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();
	}

	private void panel4_DoubleClick(Object sender, tangible.EventArgs e)
	{
		int idx = 3;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		System.out.println(table_list[listIndex].patient_name.toString());
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();
		// openDetails(listIndex);
	}

	private void panel5_DoubleClick(Object sender, tangible.EventArgs e)
	{
		int idx = 4;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		System.out.println(table_list[listIndex].patient_name.toString());
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();
	}

	private void panel6_DoubleClick(Object sender, tangible.EventArgs e)
	{
		int idx = 5;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		System.out.println(table_list[listIndex].patient_name.toString());
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();
	}

	private void panel7_DoubleClick(Object sender, tangible.EventArgs e)
	{
		int idx = 6;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		System.out.println(table_list[listIndex].patient_name.toString());
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();
	}

	private void panel8_DoubleClick(Object sender, tangible.EventArgs e)
	{
		int idx = 7;
		panl1_double_Click = true;
		int listIndex = idx + page * 8;
		System.out.println(table_list[listIndex].patient_name.toString());
		//List<int> index_list = new List<int>();
		//index_list.Add(listIndex);
		//Form_Create_Meeting1 = new Create_Meeting1(table_list, index_list);
		//Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 实现把患者id存储到列表，传到创建会议界面上
		String illnessId = table_list[listIndex].illness_id.toString();
		ArrayList<String> illnessId_list = new ArrayList<String>();
		illnessId_list.add(illnessId);
		Form_Create_Meeting1 = new Create_Meeting1(illnessId_list);
		Form_Create_Meeting1.ShowDialog();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 实现把患者id存储到列表，传到创建会议界面上
		//下两句只会在点击关闭窗口才会执行
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();
	}


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 8个panl双击事件
	private void panel2_Paint(Object sender, PaintEventArgs e)
	{

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 8个panl单击,不能再双击
	private void panel1_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 0; // 局部变量记录8个panl中的哪一个
		this.panel1.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8; // 局部变量记录点击后的，该背后的数据index
		panl_click_indexList.add(listIndex); // 列表增加一个元素      ????????有问题
		System.out.println(table_list[listIndex].patient_name.toString());

	}

	private void panel2_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 1;
		this.panel2.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8;
		panl_click_indexList.add(listIndex);
		System.out.println(table_list[listIndex].patient_name.toString());
	}

	private void panel3_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 2;
		this.panel3.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8;
		panl_click_indexList.add(listIndex);
		System.out.println(table_list[listIndex].patient_name.toString());
	}

	private void panel4_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 3;
		this.panel4.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8;
		panl_click_indexList.add(listIndex);
		System.out.println(table_list[listIndex].patient_name.toString());
	}

	private void panel5_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 4;
		this.panel5.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8;
		panl_click_indexList.add(listIndex);
		System.out.println(table_list[listIndex].patient_name.toString());
	}

	private void panel6_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 5;
		this.panel6.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8;
		panl_click_indexList.add(listIndex);
		System.out.println(table_list[listIndex].patient_name.toString());
	}

	private void panel7_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 6;
		this.panel7.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8;
		panl_click_indexList.add(listIndex);
		System.out.println(table_list[listIndex].patient_name.toString());
	}

	private void panel8_Click(Object sender, tangible.EventArgs e)
	{
		int idx = 7;
		this.panel8.BackColor = Color.FromArgb(222, 222, 222);
		int listIndex = idx + page * 8;
		panl_click_indexList.add(listIndex);
		System.out.println(table_list[listIndex].patient_name.toString());
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion  8个panl单击

	private void btnOk_Click(Object sender, tangible.EventArgs e)
	{
		if (tangible.IntegerLists.toArray(panl_click_indexList).length > 3)
		{
			MessageBox.Show(String.format("最多只能选择三个！！"));
		}
		else
		{
			Form_Create_Meeting2 = new Create_Meeting2(table_list, panl_click_indexList);
			Form_Create_Meeting2.ShowDialog();
			//窗体背景恢复
			Form_panel_refaind();

			//如果那边点击确定创建
			//这边对应的id要设置为true；
			//……

			//列表清空
			panl_click_indexList.clear();
			//更新8个panl
			//
		}

	}

	//窗体背景恢复
	private void Form_panel_refaind()
	{
		for (int _ = this.Controls.Count - 1; _ >= 0; _--) // 循环this窗体的索引子控件
		{
			Control panel_cc = this.Controls[_];

			if (panel_cc instanceof Panel)
			{
				panel_cc.BackColor = Color.FromArgb(253, 253, 253);

			}

		}
	}

	private void btnOff_Click(Object sender, tangible.EventArgs e)
	{
		//窗体背景恢复
		Form_panel_refaind();
		//列表清空
		panl_click_indexList.clear();

	}


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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(IsForm2.class);
		this.groupBox1 = new System.Windows.Forms.GroupBox();
		this.chk_isvisit = new System.Windows.Forms.CheckBox();
		this.btnSelect = new System.Windows.Forms.Button();
		this.txtname2 = new System.Windows.Forms.TextBox();
		this.txtname1 = new System.Windows.Forms.TextBox();
		this.label3 = new System.Windows.Forms.Label();
		this.label1 = new System.Windows.Forms.Label();
		this.pBx_left = new System.Windows.Forms.PictureBox();
		this.pBx_right = new System.Windows.Forms.PictureBox();
		this.btnOk = new System.Windows.Forms.Button();
		this.btnOff = new System.Windows.Forms.Button();
		this.panel1 = new System.Windows.Forms.Panel();
		this.label9 = new System.Windows.Forms.Label();
		this.label10 = new System.Windows.Forms.Label();
		this.label11 = new System.Windows.Forms.Label();
		this.label12 = new System.Windows.Forms.Label();
		this.p1narcosisTime = new System.Windows.Forms.Label();
		this.p1name = new System.Windows.Forms.Label();
		this.p1room = new System.Windows.Forms.Label();
		this.p1operation = new System.Windows.Forms.Label();
		this.panel2 = new System.Windows.Forms.Panel();
		this.label2 = new System.Windows.Forms.Label();
		this.label4 = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.label6 = new System.Windows.Forms.Label();
		this.label7 = new System.Windows.Forms.Label();
		this.label8 = new System.Windows.Forms.Label();
		this.label13 = new System.Windows.Forms.Label();
		this.label14 = new System.Windows.Forms.Label();
		this.panel3 = new System.Windows.Forms.Panel();
		this.label15 = new System.Windows.Forms.Label();
		this.label16 = new System.Windows.Forms.Label();
		this.label17 = new System.Windows.Forms.Label();
		this.label18 = new System.Windows.Forms.Label();
		this.label19 = new System.Windows.Forms.Label();
		this.label20 = new System.Windows.Forms.Label();
		this.label21 = new System.Windows.Forms.Label();
		this.label22 = new System.Windows.Forms.Label();
		this.panel4 = new System.Windows.Forms.Panel();
		this.label23 = new System.Windows.Forms.Label();
		this.label24 = new System.Windows.Forms.Label();
		this.label25 = new System.Windows.Forms.Label();
		this.label26 = new System.Windows.Forms.Label();
		this.label27 = new System.Windows.Forms.Label();
		this.label28 = new System.Windows.Forms.Label();
		this.label29 = new System.Windows.Forms.Label();
		this.label30 = new System.Windows.Forms.Label();
		this.panel5 = new System.Windows.Forms.Panel();
		this.label31 = new System.Windows.Forms.Label();
		this.label32 = new System.Windows.Forms.Label();
		this.label33 = new System.Windows.Forms.Label();
		this.label34 = new System.Windows.Forms.Label();
		this.label35 = new System.Windows.Forms.Label();
		this.label36 = new System.Windows.Forms.Label();
		this.label37 = new System.Windows.Forms.Label();
		this.label38 = new System.Windows.Forms.Label();
		this.panel6 = new System.Windows.Forms.Panel();
		this.label39 = new System.Windows.Forms.Label();
		this.label40 = new System.Windows.Forms.Label();
		this.label41 = new System.Windows.Forms.Label();
		this.label42 = new System.Windows.Forms.Label();
		this.label43 = new System.Windows.Forms.Label();
		this.label44 = new System.Windows.Forms.Label();
		this.label45 = new System.Windows.Forms.Label();
		this.label46 = new System.Windows.Forms.Label();
		this.panel7 = new System.Windows.Forms.Panel();
		this.label47 = new System.Windows.Forms.Label();
		this.label48 = new System.Windows.Forms.Label();
		this.label49 = new System.Windows.Forms.Label();
		this.label50 = new System.Windows.Forms.Label();
		this.label51 = new System.Windows.Forms.Label();
		this.label52 = new System.Windows.Forms.Label();
		this.label53 = new System.Windows.Forms.Label();
		this.label54 = new System.Windows.Forms.Label();
		this.panel8 = new System.Windows.Forms.Panel();
		this.label55 = new System.Windows.Forms.Label();
		this.label56 = new System.Windows.Forms.Label();
		this.label57 = new System.Windows.Forms.Label();
		this.label58 = new System.Windows.Forms.Label();
		this.label59 = new System.Windows.Forms.Label();
		this.label60 = new System.Windows.Forms.Label();
		this.label61 = new System.Windows.Forms.Label();
		this.label62 = new System.Windows.Forms.Label();
		this.groupBox1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pBx_left)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pBx_right)).BeginInit();
		this.panel1.SuspendLayout();
		this.panel2.SuspendLayout();
		this.panel3.SuspendLayout();
		this.panel4.SuspendLayout();
		this.panel5.SuspendLayout();
		this.panel6.SuspendLayout();
		this.panel7.SuspendLayout();
		this.panel8.SuspendLayout();
		this.SuspendLayout();
		// 
		// groupBox1
		// 
		this.groupBox1.Anchor = (System.Windows.Forms.AnchorStyles.forValue((((System.Windows.Forms.AnchorStyles.Top.getValue() | System.Windows.Forms.AnchorStyles.Bottom.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Left.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Right.getValue())));
		this.groupBox1.Controls.Add(this.chk_isvisit);
		this.groupBox1.Controls.Add(this.btnSelect);
		this.groupBox1.Controls.Add(this.txtname2);
		this.groupBox1.Controls.Add(this.txtname1);
		this.groupBox1.Controls.Add(this.label3);
		this.groupBox1.Controls.Add(this.label1);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Location = new System.Drawing.Point(3, 3);
		this.groupBox1.Name = "groupBox1";
		this.groupBox1.Size = new System.Drawing.Size(839, 59);
		this.groupBox1.TabIndex = 3;
		this.groupBox1.TabStop = false;
		this.groupBox1.Text = "筛选";
		// 
		// chk_isvisit
		// 
		this.chk_isvisit.AutoSize = true;
		this.chk_isvisit.Location = new System.Drawing.Point(449, 22);
		this.chk_isvisit.Name = "chk_isvisit";
		this.chk_isvisit.Size = new System.Drawing.Size(111, 21);
		this.chk_isvisit.TabIndex = 12;
		this.chk_isvisit.Text = "是否已创建访视";
		this.chk_isvisit.UseVisualStyleBackColor = true;
		// 
		// btnSelect
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSelect.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnSelect.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSelect.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnSelect.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnSelect.FlatAppearance.BorderSize = 0;
		this.btnSelect.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSelect.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnSelect.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnSelect.ForeColor = System.Drawing.SystemColors.Window;
		this.btnSelect.Location = new System.Drawing.Point(708, 20);
		this.btnSelect.Name = "btnSelect";
		this.btnSelect.Size = new System.Drawing.Size(94, 29);
		this.btnSelect.TabIndex = 11;
		this.btnSelect.Text = "查  找";
		this.btnSelect.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnSelect.Click += new System.EventHandler(this.btnSelect_Click);
		// 
		// txtname2
		// 
		this.txtname2.Location = new System.Drawing.Point(247, 22);
		this.txtname2.Name = "txtname2";
		this.txtname2.Size = new System.Drawing.Size(120, 23);
		this.txtname2.TabIndex = 1;
		// 
		// txtname1
		// 
		this.txtname1.Location = new System.Drawing.Point(54, 21);
		this.txtname1.Name = "txtname1";
		this.txtname1.Size = new System.Drawing.Size(79, 23);
		this.txtname1.TabIndex = 1;
		// 
		// label3
		// 
		this.label3.AutoSize = true;
		this.label3.Location = new System.Drawing.Point(176, 24);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(56, 17);
		this.label3.TabIndex = 0;
		this.label3.Text = "手术名：";
		// 
		// label1
		// 
		this.label1.AutoSize = true;
		this.label1.Location = new System.Drawing.Point(16, 24);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(44, 17);
		this.label1.TabIndex = 0;
		this.label1.Text = "姓名：";
		// 
		// pBx_left
		// 
		this.pBx_left.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.pBx_left.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pBx_left.BackgroundImage")));
		this.pBx_left.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pBx_left.Location = new System.Drawing.Point(3, 270);
		this.pBx_left.Name = "pBx_left";
		this.pBx_left.Size = new System.Drawing.Size(45, 40);
		this.pBx_left.TabIndex = 6;
		this.pBx_left.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pBx_left.Click += new System.EventHandler(this.pBx_left_Click);
		// 
		// pBx_right
		// 
		this.pBx_right.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.pBx_right.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pBx_right.BackgroundImage")));
		this.pBx_right.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pBx_right.Location = new System.Drawing.Point(789, 270);
		this.pBx_right.Name = "pBx_right";
		this.pBx_right.Size = new System.Drawing.Size(45, 40);
		this.pBx_right.TabIndex = 6;
		this.pBx_right.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pBx_right.Click += new System.EventHandler(this.pBx_right_Click);
		// 
		// btnOk
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOk.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnOk.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOk.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOk.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOk.FlatAppearance.BorderSize = 0;
		this.btnOk.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOk.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOk.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOk.ForeColor = System.Drawing.SystemColors.Window;
		this.btnOk.Location = new System.Drawing.Point(492, 511);
		this.btnOk.Name = "btnOk";
		this.btnOk.Size = new System.Drawing.Size(94, 29);
		this.btnOk.TabIndex = 12;
		this.btnOk.Text = "确 定";
		this.btnOk.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
		// 
		// btnOff
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOff.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnOff.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOff.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOff.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOff.FlatAppearance.BorderSize = 0;
		this.btnOff.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOff.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOff.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOff.ForeColor = System.Drawing.SystemColors.Window;
		this.btnOff.Location = new System.Drawing.Point(688, 511);
		this.btnOff.Name = "btnOff";
		this.btnOff.Size = new System.Drawing.Size(94, 29);
		this.btnOff.TabIndex = 13;
		this.btnOff.Text = "取 消";
		this.btnOff.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnOff.Click += new System.EventHandler(this.btnOff_Click);
		// 
		// panel1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel1.Controls.Add(this.label9);
		this.panel1.Controls.Add(this.label10);
		this.panel1.Controls.Add(this.label11);
		this.panel1.Controls.Add(this.label12);
		this.panel1.Controls.Add(this.p1narcosisTime);
		this.panel1.Controls.Add(this.p1name);
		this.panel1.Controls.Add(this.p1room);
		this.panel1.Controls.Add(this.p1operation);
		this.panel1.Location = new System.Drawing.Point(40, 107);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(150, 160);
		this.panel1.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel1.Click += new System.EventHandler(this.panel1_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel1.DoubleClick += new System.EventHandler(this.panel1_DoubleClick);
		// 
		// label9
		// 
		this.label9.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label9.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.ForeColor = System.Drawing.Color.DimGray;
		this.label9.Location = new System.Drawing.Point(5, 79);
		this.label9.Name = "label9";
		this.label9.Size = new System.Drawing.Size(56, 17);
		this.label9.TabIndex = 6;
		this.label9.Text = "手术室：";
		// 
		// label10
		// 
		this.label10.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label10.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.ForeColor = System.Drawing.Color.DimGray;
		this.label10.Location = new System.Drawing.Point(3, 105);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(68, 17);
		this.label10.TabIndex = 6;
		this.label10.Text = "访视时间：";
		// 
		// label11
		// 
		this.label11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label11.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.ForeColor = System.Drawing.Color.DimGray;
		this.label11.Location = new System.Drawing.Point(3, 50);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(47, 17);
		this.label11.TabIndex = 6;
		this.label11.Text = "手术名:";
		// 
		// label12
		// 
		this.label12.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label12.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.ForeColor = System.Drawing.Color.DimGray;
		this.label12.Location = new System.Drawing.Point(11, 13);
		this.label12.Name = "label12";
		this.label12.Size = new System.Drawing.Size(32, 17);
		this.label12.TabIndex = 6;
		this.label12.Text = "名：";
		// 
		// p1narcosisTime
		// 
		this.p1narcosisTime.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.p1narcosisTime.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.p1narcosisTime.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.p1narcosisTime.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.p1narcosisTime.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.p1narcosisTime.Location = new System.Drawing.Point(0, 126);
		this.p1narcosisTime.Name = "p1narcosisTime";
		this.p1narcosisTime.Size = new System.Drawing.Size(28, 18);
		this.p1narcosisTime.TabIndex = 1;
		this.p1narcosisTime.Text = "00";
		// 
		// p1name
		// 
		this.p1name.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.p1name.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.p1name.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.p1name.Location = new System.Drawing.Point(42, 15);
		this.p1name.Name = "p1name";
		this.p1name.Size = new System.Drawing.Size(15, 17);
		this.p1name.TabIndex = 1;
		this.p1name.Text = "0";
		// 
		// p1room
		// 
		this.p1room.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.p1room.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.p1room.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.p1room.Location = new System.Drawing.Point(59, 76);
		this.p1room.Name = "p1room";
		this.p1room.Size = new System.Drawing.Size(17, 20);
		this.p1room.TabIndex = 1;
		this.p1room.Text = "0";
		// 
		// p1operation
		// 
		this.p1operation.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.p1operation.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.p1operation.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.p1operation.Location = new System.Drawing.Point(51, 49);
		this.p1operation.Name = "p1operation";
		this.p1operation.Size = new System.Drawing.Size(17, 20);
		this.p1operation.TabIndex = 1;
		this.p1operation.Text = "0";
		// 
		// panel2
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel2.Controls.Add(this.label2);
		this.panel2.Controls.Add(this.label4);
		this.panel2.Controls.Add(this.label5);
		this.panel2.Controls.Add(this.label6);
		this.panel2.Controls.Add(this.label7);
		this.panel2.Controls.Add(this.label8);
		this.panel2.Controls.Add(this.label13);
		this.panel2.Controls.Add(this.label14);
		this.panel2.Location = new System.Drawing.Point(250, 107);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(150, 160);
		this.panel2.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel2.Click += new System.EventHandler(this.panel2_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel2.Paint += new System.Windows.Forms.PaintEventHandler(this.panel2_Paint);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel2.DoubleClick += new System.EventHandler(this.panel2_DoubleClick);
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.ForeColor = System.Drawing.Color.DimGray;
		this.label2.Location = new System.Drawing.Point(5, 79);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(56, 17);
		this.label2.TabIndex = 6;
		this.label2.Text = "手术室：";
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.ForeColor = System.Drawing.Color.DimGray;
		this.label4.Location = new System.Drawing.Point(3, 105);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(68, 17);
		this.label4.TabIndex = 6;
		this.label4.Text = "访视时间：";
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.ForeColor = System.Drawing.Color.DimGray;
		this.label5.Location = new System.Drawing.Point(3, 50);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(47, 17);
		this.label5.TabIndex = 6;
		this.label5.Text = "手术名:";
		// 
		// label6
		// 
		this.label6.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label6.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.ForeColor = System.Drawing.Color.DimGray;
		this.label6.Location = new System.Drawing.Point(11, 13);
		this.label6.Name = "label6";
		this.label6.Size = new System.Drawing.Size(32, 17);
		this.label6.TabIndex = 6;
		this.label6.Text = "名：";
		// 
		// label7
		// 
		this.label7.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label7.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label7.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label7.Location = new System.Drawing.Point(0, 126);
		this.label7.Name = "label7";
		this.label7.Size = new System.Drawing.Size(28, 18);
		this.label7.TabIndex = 1;
		this.label7.Text = "00";
		// 
		// label8
		// 
		this.label8.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label8.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Location = new System.Drawing.Point(42, 15);
		this.label8.Name = "label8";
		this.label8.Size = new System.Drawing.Size(15, 17);
		this.label8.TabIndex = 1;
		this.label8.Text = "0";
		// 
		// label13
		// 
		this.label13.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label13.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Location = new System.Drawing.Point(59, 76);
		this.label13.Name = "label13";
		this.label13.Size = new System.Drawing.Size(17, 20);
		this.label13.TabIndex = 1;
		this.label13.Text = "0";
		// 
		// label14
		// 
		this.label14.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Location = new System.Drawing.Point(51, 49);
		this.label14.Name = "label14";
		this.label14.Size = new System.Drawing.Size(17, 20);
		this.label14.TabIndex = 1;
		this.label14.Text = "0";
		// 
		// panel3
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel3.Controls.Add(this.label15);
		this.panel3.Controls.Add(this.label16);
		this.panel3.Controls.Add(this.label17);
		this.panel3.Controls.Add(this.label18);
		this.panel3.Controls.Add(this.label19);
		this.panel3.Controls.Add(this.label20);
		this.panel3.Controls.Add(this.label21);
		this.panel3.Controls.Add(this.label22);
		this.panel3.Location = new System.Drawing.Point(452, 107);
		this.panel3.Name = "panel3";
		this.panel3.Size = new System.Drawing.Size(150, 160);
		this.panel3.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel3.Click += new System.EventHandler(this.panel3_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel3.DoubleClick += new System.EventHandler(this.panel3_DoubleClick);
		// 
		// label15
		// 
		this.label15.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label15.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.ForeColor = System.Drawing.Color.DimGray;
		this.label15.Location = new System.Drawing.Point(5, 79);
		this.label15.Name = "label15";
		this.label15.Size = new System.Drawing.Size(56, 17);
		this.label15.TabIndex = 6;
		this.label15.Text = "手术室：";
		// 
		// label16
		// 
		this.label16.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label16.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.ForeColor = System.Drawing.Color.DimGray;
		this.label16.Location = new System.Drawing.Point(3, 105);
		this.label16.Name = "label16";
		this.label16.Size = new System.Drawing.Size(68, 17);
		this.label16.TabIndex = 6;
		this.label16.Text = "访视时间：";
		// 
		// label17
		// 
		this.label17.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.ForeColor = System.Drawing.Color.DimGray;
		this.label17.Location = new System.Drawing.Point(3, 50);
		this.label17.Name = "label17";
		this.label17.Size = new System.Drawing.Size(47, 17);
		this.label17.TabIndex = 6;
		this.label17.Text = "手术名:";
		// 
		// label18
		// 
		this.label18.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label18.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.ForeColor = System.Drawing.Color.DimGray;
		this.label18.Location = new System.Drawing.Point(11, 13);
		this.label18.Name = "label18";
		this.label18.Size = new System.Drawing.Size(32, 17);
		this.label18.TabIndex = 6;
		this.label18.Text = "名：";
		// 
		// label19
		// 
		this.label19.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label19.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label19.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label19.Location = new System.Drawing.Point(0, 126);
		this.label19.Name = "label19";
		this.label19.Size = new System.Drawing.Size(28, 18);
		this.label19.TabIndex = 1;
		this.label19.Text = "00";
		// 
		// label20
		// 
		this.label20.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label20.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Location = new System.Drawing.Point(42, 15);
		this.label20.Name = "label20";
		this.label20.Size = new System.Drawing.Size(15, 17);
		this.label20.TabIndex = 1;
		this.label20.Text = "0";
		// 
		// label21
		// 
		this.label21.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label21.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label21.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label21.Location = new System.Drawing.Point(59, 76);
		this.label21.Name = "label21";
		this.label21.Size = new System.Drawing.Size(17, 20);
		this.label21.TabIndex = 1;
		this.label21.Text = "0";
		// 
		// label22
		// 
		this.label22.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.Location = new System.Drawing.Point(51, 49);
		this.label22.Name = "label22";
		this.label22.Size = new System.Drawing.Size(17, 20);
		this.label22.TabIndex = 1;
		this.label22.Text = "0";
		// 
		// panel4
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel4.Controls.Add(this.label23);
		this.panel4.Controls.Add(this.label24);
		this.panel4.Controls.Add(this.label25);
		this.panel4.Controls.Add(this.label26);
		this.panel4.Controls.Add(this.label27);
		this.panel4.Controls.Add(this.label28);
		this.panel4.Controls.Add(this.label29);
		this.panel4.Controls.Add(this.label30);
		this.panel4.Location = new System.Drawing.Point(655, 107);
		this.panel4.Name = "panel4";
		this.panel4.Size = new System.Drawing.Size(150, 160);
		this.panel4.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel4.Click += new System.EventHandler(this.panel4_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel4.DoubleClick += new System.EventHandler(this.panel4_DoubleClick);
		// 
		// label23
		// 
		this.label23.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label23.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.ForeColor = System.Drawing.Color.DimGray;
		this.label23.Location = new System.Drawing.Point(5, 79);
		this.label23.Name = "label23";
		this.label23.Size = new System.Drawing.Size(56, 17);
		this.label23.TabIndex = 6;
		this.label23.Text = "手术室：";
		// 
		// label24
		// 
		this.label24.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label24.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.ForeColor = System.Drawing.Color.DimGray;
		this.label24.Location = new System.Drawing.Point(3, 105);
		this.label24.Name = "label24";
		this.label24.Size = new System.Drawing.Size(68, 17);
		this.label24.TabIndex = 6;
		this.label24.Text = "访视时间：";
		// 
		// label25
		// 
		this.label25.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label25.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label25.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label25.ForeColor = System.Drawing.Color.DimGray;
		this.label25.Location = new System.Drawing.Point(3, 50);
		this.label25.Name = "label25";
		this.label25.Size = new System.Drawing.Size(47, 17);
		this.label25.TabIndex = 6;
		this.label25.Text = "手术名:";
		// 
		// label26
		// 
		this.label26.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label26.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label26.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label26.ForeColor = System.Drawing.Color.DimGray;
		this.label26.Location = new System.Drawing.Point(11, 13);
		this.label26.Name = "label26";
		this.label26.Size = new System.Drawing.Size(32, 17);
		this.label26.TabIndex = 6;
		this.label26.Text = "名：";
		// 
		// label27
		// 
		this.label27.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label27.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label27.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label27.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label27.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label27.Location = new System.Drawing.Point(0, 126);
		this.label27.Name = "label27";
		this.label27.Size = new System.Drawing.Size(28, 18);
		this.label27.TabIndex = 1;
		this.label27.Text = "00";
		// 
		// label28
		// 
		this.label28.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label28.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label28.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label28.Location = new System.Drawing.Point(42, 15);
		this.label28.Name = "label28";
		this.label28.Size = new System.Drawing.Size(15, 17);
		this.label28.TabIndex = 1;
		this.label28.Text = "0";
		// 
		// label29
		// 
		this.label29.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label29.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label29.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label29.Location = new System.Drawing.Point(59, 76);
		this.label29.Name = "label29";
		this.label29.Size = new System.Drawing.Size(17, 20);
		this.label29.TabIndex = 1;
		this.label29.Text = "0";
		// 
		// label30
		// 
		this.label30.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label30.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label30.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label30.Location = new System.Drawing.Point(51, 49);
		this.label30.Name = "label30";
		this.label30.Size = new System.Drawing.Size(17, 20);
		this.label30.TabIndex = 1;
		this.label30.Text = "0";
		// 
		// panel5
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel5.Controls.Add(this.label31);
		this.panel5.Controls.Add(this.label32);
		this.panel5.Controls.Add(this.label33);
		this.panel5.Controls.Add(this.label34);
		this.panel5.Controls.Add(this.label35);
		this.panel5.Controls.Add(this.label36);
		this.panel5.Controls.Add(this.label37);
		this.panel5.Controls.Add(this.label38);
		this.panel5.Location = new System.Drawing.Point(43, 331);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(150, 160);
		this.panel5.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel5.Click += new System.EventHandler(this.panel5_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel5.DoubleClick += new System.EventHandler(this.panel5_DoubleClick);
		// 
		// label31
		// 
		this.label31.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label31.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label31.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label31.ForeColor = System.Drawing.Color.DimGray;
		this.label31.Location = new System.Drawing.Point(5, 79);
		this.label31.Name = "label31";
		this.label31.Size = new System.Drawing.Size(56, 17);
		this.label31.TabIndex = 6;
		this.label31.Text = "手术室：";
		// 
		// label32
		// 
		this.label32.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label32.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label32.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label32.ForeColor = System.Drawing.Color.DimGray;
		this.label32.Location = new System.Drawing.Point(3, 105);
		this.label32.Name = "label32";
		this.label32.Size = new System.Drawing.Size(68, 17);
		this.label32.TabIndex = 6;
		this.label32.Text = "访视时间：";
		// 
		// label33
		// 
		this.label33.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label33.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label33.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label33.ForeColor = System.Drawing.Color.DimGray;
		this.label33.Location = new System.Drawing.Point(3, 50);
		this.label33.Name = "label33";
		this.label33.Size = new System.Drawing.Size(47, 17);
		this.label33.TabIndex = 6;
		this.label33.Text = "手术名:";
		// 
		// label34
		// 
		this.label34.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label34.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label34.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label34.ForeColor = System.Drawing.Color.DimGray;
		this.label34.Location = new System.Drawing.Point(11, 13);
		this.label34.Name = "label34";
		this.label34.Size = new System.Drawing.Size(32, 17);
		this.label34.TabIndex = 6;
		this.label34.Text = "名：";
		// 
		// label35
		// 
		this.label35.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label35.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label35.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label35.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label35.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label35.Location = new System.Drawing.Point(0, 126);
		this.label35.Name = "label35";
		this.label35.Size = new System.Drawing.Size(28, 18);
		this.label35.TabIndex = 1;
		this.label35.Text = "00";
		// 
		// label36
		// 
		this.label36.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label36.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label36.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label36.Location = new System.Drawing.Point(42, 15);
		this.label36.Name = "label36";
		this.label36.Size = new System.Drawing.Size(15, 17);
		this.label36.TabIndex = 1;
		this.label36.Text = "0";
		// 
		// label37
		// 
		this.label37.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label37.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label37.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label37.Location = new System.Drawing.Point(59, 76);
		this.label37.Name = "label37";
		this.label37.Size = new System.Drawing.Size(17, 20);
		this.label37.TabIndex = 1;
		this.label37.Text = "0";
		// 
		// label38
		// 
		this.label38.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label38.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label38.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label38.Location = new System.Drawing.Point(51, 49);
		this.label38.Name = "label38";
		this.label38.Size = new System.Drawing.Size(17, 20);
		this.label38.TabIndex = 1;
		this.label38.Text = "0";
		// 
		// panel6
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel6.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel6.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel6.Controls.Add(this.label39);
		this.panel6.Controls.Add(this.label40);
		this.panel6.Controls.Add(this.label41);
		this.panel6.Controls.Add(this.label42);
		this.panel6.Controls.Add(this.label43);
		this.panel6.Controls.Add(this.label44);
		this.panel6.Controls.Add(this.label45);
		this.panel6.Controls.Add(this.label46);
		this.panel6.Location = new System.Drawing.Point(250, 331);
		this.panel6.Name = "panel6";
		this.panel6.Size = new System.Drawing.Size(150, 160);
		this.panel6.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel6.Click += new System.EventHandler(this.panel6_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel6.DoubleClick += new System.EventHandler(this.panel6_DoubleClick);
		// 
		// label39
		// 
		this.label39.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label39.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label39.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label39.ForeColor = System.Drawing.Color.DimGray;
		this.label39.Location = new System.Drawing.Point(5, 79);
		this.label39.Name = "label39";
		this.label39.Size = new System.Drawing.Size(56, 17);
		this.label39.TabIndex = 6;
		this.label39.Text = "手术室：";
		// 
		// label40
		// 
		this.label40.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label40.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label40.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label40.ForeColor = System.Drawing.Color.DimGray;
		this.label40.Location = new System.Drawing.Point(3, 105);
		this.label40.Name = "label40";
		this.label40.Size = new System.Drawing.Size(68, 17);
		this.label40.TabIndex = 6;
		this.label40.Text = "访视时间：";
		// 
		// label41
		// 
		this.label41.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label41.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label41.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label41.ForeColor = System.Drawing.Color.DimGray;
		this.label41.Location = new System.Drawing.Point(3, 50);
		this.label41.Name = "label41";
		this.label41.Size = new System.Drawing.Size(47, 17);
		this.label41.TabIndex = 6;
		this.label41.Text = "手术名:";
		// 
		// label42
		// 
		this.label42.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label42.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label42.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label42.ForeColor = System.Drawing.Color.DimGray;
		this.label42.Location = new System.Drawing.Point(11, 13);
		this.label42.Name = "label42";
		this.label42.Size = new System.Drawing.Size(32, 17);
		this.label42.TabIndex = 6;
		this.label42.Text = "名：";
		// 
		// label43
		// 
		this.label43.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label43.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label43.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label43.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label43.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label43.Location = new System.Drawing.Point(0, 126);
		this.label43.Name = "label43";
		this.label43.Size = new System.Drawing.Size(28, 18);
		this.label43.TabIndex = 1;
		this.label43.Text = "00";
		// 
		// label44
		// 
		this.label44.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label44.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label44.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label44.Location = new System.Drawing.Point(42, 15);
		this.label44.Name = "label44";
		this.label44.Size = new System.Drawing.Size(15, 17);
		this.label44.TabIndex = 1;
		this.label44.Text = "0";
		// 
		// label45
		// 
		this.label45.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label45.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label45.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label45.Location = new System.Drawing.Point(59, 76);
		this.label45.Name = "label45";
		this.label45.Size = new System.Drawing.Size(17, 20);
		this.label45.TabIndex = 1;
		this.label45.Text = "0";
		// 
		// label46
		// 
		this.label46.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label46.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label46.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label46.Location = new System.Drawing.Point(51, 49);
		this.label46.Name = "label46";
		this.label46.Size = new System.Drawing.Size(17, 20);
		this.label46.TabIndex = 1;
		this.label46.Text = "0";
		// 
		// panel7
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel7.Controls.Add(this.label47);
		this.panel7.Controls.Add(this.label48);
		this.panel7.Controls.Add(this.label49);
		this.panel7.Controls.Add(this.label50);
		this.panel7.Controls.Add(this.label51);
		this.panel7.Controls.Add(this.label52);
		this.panel7.Controls.Add(this.label53);
		this.panel7.Controls.Add(this.label54);
		this.panel7.Location = new System.Drawing.Point(455, 331);
		this.panel7.Name = "panel7";
		this.panel7.Size = new System.Drawing.Size(150, 160);
		this.panel7.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel7.Click += new System.EventHandler(this.panel7_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel7.DoubleClick += new System.EventHandler(this.panel7_DoubleClick);
		// 
		// label47
		// 
		this.label47.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label47.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label47.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label47.ForeColor = System.Drawing.Color.DimGray;
		this.label47.Location = new System.Drawing.Point(5, 79);
		this.label47.Name = "label47";
		this.label47.Size = new System.Drawing.Size(56, 17);
		this.label47.TabIndex = 6;
		this.label47.Text = "手术室：";
		// 
		// label48
		// 
		this.label48.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label48.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label48.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label48.ForeColor = System.Drawing.Color.DimGray;
		this.label48.Location = new System.Drawing.Point(3, 105);
		this.label48.Name = "label48";
		this.label48.Size = new System.Drawing.Size(68, 17);
		this.label48.TabIndex = 6;
		this.label48.Text = "访视时间：";
		// 
		// label49
		// 
		this.label49.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label49.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label49.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label49.ForeColor = System.Drawing.Color.DimGray;
		this.label49.Location = new System.Drawing.Point(3, 50);
		this.label49.Name = "label49";
		this.label49.Size = new System.Drawing.Size(47, 17);
		this.label49.TabIndex = 6;
		this.label49.Text = "手术名:";
		// 
		// label50
		// 
		this.label50.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label50.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label50.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label50.ForeColor = System.Drawing.Color.DimGray;
		this.label50.Location = new System.Drawing.Point(11, 13);
		this.label50.Name = "label50";
		this.label50.Size = new System.Drawing.Size(32, 17);
		this.label50.TabIndex = 6;
		this.label50.Text = "名：";
		// 
		// label51
		// 
		this.label51.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label51.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label51.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label51.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label51.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label51.Location = new System.Drawing.Point(0, 126);
		this.label51.Name = "label51";
		this.label51.Size = new System.Drawing.Size(28, 18);
		this.label51.TabIndex = 1;
		this.label51.Text = "00";
		// 
		// label52
		// 
		this.label52.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label52.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label52.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label52.Location = new System.Drawing.Point(42, 15);
		this.label52.Name = "label52";
		this.label52.Size = new System.Drawing.Size(15, 17);
		this.label52.TabIndex = 1;
		this.label52.Text = "0";
		// 
		// label53
		// 
		this.label53.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label53.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label53.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label53.Location = new System.Drawing.Point(59, 76);
		this.label53.Name = "label53";
		this.label53.Size = new System.Drawing.Size(17, 20);
		this.label53.TabIndex = 1;
		this.label53.Text = "0";
		// 
		// label54
		// 
		this.label54.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label54.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label54.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label54.Location = new System.Drawing.Point(51, 49);
		this.label54.Name = "label54";
		this.label54.Size = new System.Drawing.Size(17, 20);
		this.label54.TabIndex = 1;
		this.label54.Text = "0";
		// 
		// panel8
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel8.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel8.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel8.Controls.Add(this.label55);
		this.panel8.Controls.Add(this.label56);
		this.panel8.Controls.Add(this.label57);
		this.panel8.Controls.Add(this.label58);
		this.panel8.Controls.Add(this.label59);
		this.panel8.Controls.Add(this.label60);
		this.panel8.Controls.Add(this.label61);
		this.panel8.Controls.Add(this.label62);
		this.panel8.Location = new System.Drawing.Point(655, 331);
		this.panel8.Name = "panel8";
		this.panel8.Size = new System.Drawing.Size(150, 160);
		this.panel8.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel8.Click += new System.EventHandler(this.panel8_Click);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel8.DoubleClick += new System.EventHandler(this.panel8_DoubleClick);
		// 
		// label55
		// 
		this.label55.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label55.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label55.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label55.ForeColor = System.Drawing.Color.DimGray;
		this.label55.Location = new System.Drawing.Point(5, 79);
		this.label55.Name = "label55";
		this.label55.Size = new System.Drawing.Size(56, 17);
		this.label55.TabIndex = 6;
		this.label55.Text = "手术室：";
		// 
		// label56
		// 
		this.label56.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label56.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label56.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label56.ForeColor = System.Drawing.Color.DimGray;
		this.label56.Location = new System.Drawing.Point(3, 105);
		this.label56.Name = "label56";
		this.label56.Size = new System.Drawing.Size(68, 17);
		this.label56.TabIndex = 6;
		this.label56.Text = "访视时间：";
		// 
		// label57
		// 
		this.label57.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label57.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label57.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label57.ForeColor = System.Drawing.Color.DimGray;
		this.label57.Location = new System.Drawing.Point(3, 50);
		this.label57.Name = "label57";
		this.label57.Size = new System.Drawing.Size(47, 17);
		this.label57.TabIndex = 6;
		this.label57.Text = "手术名:";
		// 
		// label58
		// 
		this.label58.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label58.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label58.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label58.ForeColor = System.Drawing.Color.DimGray;
		this.label58.Location = new System.Drawing.Point(11, 13);
		this.label58.Name = "label58";
		this.label58.Size = new System.Drawing.Size(32, 17);
		this.label58.TabIndex = 6;
		this.label58.Text = "名：";
		// 
		// label59
		// 
		this.label59.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label59.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label59.Font = new System.Drawing.Font("Arial Rounded MT Bold", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label59.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label59.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label59.Location = new System.Drawing.Point(0, 126);
		this.label59.Name = "label59";
		this.label59.Size = new System.Drawing.Size(28, 18);
		this.label59.TabIndex = 1;
		this.label59.Text = "00";
		// 
		// label60
		// 
		this.label60.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label60.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label60.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label60.Location = new System.Drawing.Point(42, 15);
		this.label60.Name = "label60";
		this.label60.Size = new System.Drawing.Size(15, 17);
		this.label60.TabIndex = 1;
		this.label60.Text = "0";
		// 
		// label61
		// 
		this.label61.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label61.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label61.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label61.Location = new System.Drawing.Point(59, 76);
		this.label61.Name = "label61";
		this.label61.Size = new System.Drawing.Size(17, 20);
		this.label61.TabIndex = 1;
		this.label61.Text = "0";
		// 
		// label62
		// 
		this.label62.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label62.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label62.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label62.Location = new System.Drawing.Point(51, 49);
		this.label62.Name = "label62";
		this.label62.Size = new System.Drawing.Size(17, 20);
		this.label62.TabIndex = 1;
		this.label62.Text = "0";
		// 
		// IsForm2
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(846, 555);
		this.Controls.Add(this.btnOff);
		this.Controls.Add(this.btnOk);
		this.Controls.Add(this.pBx_right);
		this.Controls.Add(this.pBx_left);
		this.Controls.Add(this.panel8);
		this.Controls.Add(this.panel7);
		this.Controls.Add(this.panel6);
		this.Controls.Add(this.panel5);
		this.Controls.Add(this.panel4);
		this.Controls.Add(this.panel3);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel1);
		this.Controls.Add(this.groupBox1);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.Name = "IsForm2";
		this.Text = "IsForm2";
		this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.IsForm2_Load);
		this.groupBox1.ResumeLayout(false);
		this.groupBox1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pBx_left)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pBx_right)).EndInit();
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		this.panel2.ResumeLayout(false);
		this.panel2.PerformLayout();
		this.panel3.ResumeLayout(false);
		this.panel3.PerformLayout();
		this.panel4.ResumeLayout(false);
		this.panel4.PerformLayout();
		this.panel5.ResumeLayout(false);
		this.panel5.PerformLayout();
		this.panel6.ResumeLayout(false);
		this.panel6.PerformLayout();
		this.panel7.ResumeLayout(false);
		this.panel7.PerformLayout();
		this.panel8.ResumeLayout(false);
		this.panel8.PerformLayout();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.GroupBox groupBox1;
	private System.Windows.Forms.Button btnSelect;
	private System.Windows.Forms.TextBox txtname2;
	private System.Windows.Forms.TextBox txtname1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.PictureBox pBx_left;
	private System.Windows.Forms.PictureBox pBx_right;
	private System.Windows.Forms.Button btnOk;
	private System.Windows.Forms.Button btnOff;
	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.Label label9;
	private System.Windows.Forms.Label label10;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.Label label12;
	private System.Windows.Forms.Label p1narcosisTime;
	private System.Windows.Forms.Label p1name;
	private System.Windows.Forms.Label p1room;
	private System.Windows.Forms.Label p1operation;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label label6;
	private System.Windows.Forms.Label label7;
	private System.Windows.Forms.Label label8;
	private System.Windows.Forms.Label label13;
	private System.Windows.Forms.Label label14;
	private System.Windows.Forms.Panel panel3;
	private System.Windows.Forms.Label label15;
	private System.Windows.Forms.Label label16;
	private System.Windows.Forms.Label label17;
	private System.Windows.Forms.Label label18;
	private System.Windows.Forms.Label label19;
	private System.Windows.Forms.Label label20;
	private System.Windows.Forms.Label label21;
	private System.Windows.Forms.Label label22;
	private System.Windows.Forms.Panel panel4;
	private System.Windows.Forms.Label label23;
	private System.Windows.Forms.Label label24;
	private System.Windows.Forms.Label label25;
	private System.Windows.Forms.Label label26;
	private System.Windows.Forms.Label label27;
	private System.Windows.Forms.Label label28;
	private System.Windows.Forms.Label label29;
	private System.Windows.Forms.Label label30;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.Label label31;
	private System.Windows.Forms.Label label32;
	private System.Windows.Forms.Label label33;
	private System.Windows.Forms.Label label34;
	private System.Windows.Forms.Label label35;
	private System.Windows.Forms.Label label36;
	private System.Windows.Forms.Label label37;
	private System.Windows.Forms.Label label38;
	private System.Windows.Forms.Panel panel6;
	private System.Windows.Forms.Label label39;
	private System.Windows.Forms.Label label40;
	private System.Windows.Forms.Label label41;
	private System.Windows.Forms.Label label42;
	private System.Windows.Forms.Label label43;
	private System.Windows.Forms.Label label44;
	private System.Windows.Forms.Label label45;
	private System.Windows.Forms.Label label46;
	private System.Windows.Forms.Panel panel7;
	private System.Windows.Forms.Label label47;
	private System.Windows.Forms.Label label48;
	private System.Windows.Forms.Label label49;
	private System.Windows.Forms.Label label50;
	private System.Windows.Forms.Label label51;
	private System.Windows.Forms.Label label52;
	private System.Windows.Forms.Label label53;
	private System.Windows.Forms.Label label54;
	private System.Windows.Forms.Panel panel8;
	private System.Windows.Forms.Label label55;
	private System.Windows.Forms.Label label56;
	private System.Windows.Forms.Label label57;
	private System.Windows.Forms.Label label58;
	private System.Windows.Forms.Label label59;
	private System.Windows.Forms.Label label60;
	private System.Windows.Forms.Label label61;
	private System.Windows.Forms.Label label62;
	private System.Windows.Forms.CheckBox chk_isvisit;
}