package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;
import java.util.*;
import java.io.*;
import java.time.*;

public class MainMain extends Form
{
	//主界面的初始化，先隐藏主界面，调用login界面
	private notice_tableBll notice_TableBll_ = new notice_tableBll(); // 初始化BLL中notice_tableBll类对象
	private notice_table notice_Table_ = new notice_table(); // 初始化Models中notice_table类对象
	private doc_tableBll _doc_tableBll = new doc_tableBll(); // 初始化BLL中doc_tableBll类对象
	private doc_table doc_table_ = new doc_table(); //初始化Models中doc_table表全局对象
	private meeting_tableBll meeting_tableBll_ = new meeting_tableBll(); ////
	private String cur_idTostring; //当前登录人的id string
	private int index_picture_index;
	private Bitmap bmpt;


	public MainMain()
	{

		InitializeComponent();
		timer1.Start();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 主窗体隐藏先登录
		login form1_login1 = new login(); // 初始化login界面 对象
		DialogResult dialogResult = form1_login1.ShowDialog(this);
		this.Hide();


		int cur_id = form1_login1.cur_doctor_id;
		String cur_doctor_id_str = String.valueOf(cur_id); // 吧登录成功的id转化为字符串
		if (cur_doctor_id_str != null)
		{
			this.Show();
			Program.cur_LoginId = cur_id; //把登录成功的id作为整个项目全局对象。


		}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 主窗体隐藏先登录
		// MessageBox.Show(string.Format("成功{0}", cur_id));

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 绑定notice_table表数据
		// 初始化绑定notice_table表数据
		this.dgvNotice.AutoGenerateColumns = false; //控制DataGriView只显示需要的列
		this.dgvNotice.DataSource = notice_TableBll_.Getnotice_TableList();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 绑定notice_table表数据


		//初始化当前登录人的信息
		cur_idTostring = String.valueOf(cur_id);


		doc_table_ = get_cur_doc_table(cur_id); // 当前登录人的对象
		labName1.Text = doc_table_.doc_name.toString();
		labName2.Text = doc_table_.doc_name.toString();
		// MessageBox.Show(string.Format("成功{0}", cur_doc.doc_name.ToString()));
		//string cur_idTostring2 = Regex.Replace(cur_idTostring, @"(?<=.{3}.*)", "");  // 正则取前三位
		String cur_idTostring2 = cur_idTostring.substring(0, 3);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 用户权限约束
		//if (cur_idTostring2 == "303")    // 护士
		//{
		//    this.pictureBox6.Enabled = false;
		//    this.pictureBox4.Enabled = true;
		//    this.pictureBox5.Enabled = true;
		//}
		//else if(cur_idTostring2 == "102")   // 访视用户就进不去手术申请和排班
		//{
		//    this.pictureBox6.Enabled = true;
		//    this.pictureBox4.Enabled = false;
		//    this.pictureBox5.Enabled = false;


		//}
		//else if (cur_idTostring2 == "202")     //医师
		//{
		//    this.pictureBox6.Enabled = false;
		//    this.pictureBox4.Enabled = true;
		//    this.pictureBox5.Enabled = true;
		//}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 用户权限约束
	}








//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 星期几输出
	private String GetWeek()
	{
		String week = "";
		switch (LocalDateTime.now().getDayOfWeek().getValue())
		{
			case 0:
				week = "星期日";
				break;
			case 1:
				week = "星期一";
				break;
			case 2:
				week = "星期二";
				break;
			case 3:
				week = "星期三";
				break;
			case 4:
				week = "星期四";
				break;
			case 5:
				week = "星期五";
				break;
			case 6:
				week = "星期六";
				break;

		}
		return week;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 星期几输出

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 根据当前登录人的id放回对象
	private doc_table get_cur_doc_table(int id)
	{
		doc_table cur_doc_table = _doc_tableBll.getCurDoc_table(id);
		return cur_doc_table;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 根据当前登录人的id放回对象

	private void label1_Click(Object sender, tangible.EventArgs e)
	{

	}

	private void MainMain_MouseEnter(Object sender, tangible.EventArgs e)
	{

	}

	private void MainMain_MouseDown(Object sender, MouseEventArgs e)
	{


	}

	private void pictureBox11_Click(Object sender, tangible.EventArgs e)
	{
		//退出登录，打开登录窗口
		//Application.Run(new MainMain());

		new MainMain();
	}
	// 点击进入访视系统界面
	private void pictureBox6_Click(Object sender, tangible.EventArgs e)
	{

		// 打开访视系统界面
		Form_visit form_visit = new Form_visit(doc_table_, bmpt);
		this.Hide();
		//form_visit.ShowDialog(this);
		if (form_visit.ShowDialog() == System.Windows.Forms.DialogResult.OK)
		{
			this.Show();
		}

		// 还是要把当前登录对象传过去、当前时间  ——》后期考虑放在tools中
	}

	private void dgvNotice_CellContentClick(Object sender, DataGridViewCellEventArgs e)
	{

	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 双击一行 进去新窗口
	private void dgvNotice_CellDoubleClick(Object sender, DataGridViewCellEventArgs e)
	{

		int cur_notice_id = Integer.parseInt(this.dgvNotice.CurrentRow.Cells[0].Value.toString());
		Form_notice Form_notice_ = new Form_notice(cur_notice_id);
		Form_notice_.ShowDialog();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 双击一行 进去新窗口

	private void timer1_Tick(Object sender, tangible.EventArgs e)
	{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region  初始化时间
		labDate1.Text = LocalDateTime.now().ToLongDateString().toString();
		labDate2.Text = GetWeek().toString();
		labDate3.Text = LocalDateTime.now().ToLongTimeString().toString();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 初始化时间
	}

	private void pictureBox4_Click(Object sender, tangible.EventArgs e)
	{
		// 打开访手术申请统界面
		//Form_apply1 Form_apply1_ = new Form_apply1();
		Form_apply0 Form_apply0_ = new Form_apply0();
		this.Hide();
		//Form_apply1_.ShowDialog(this);
		if (Form_apply0_.ShowDialog() == System.Windows.Forms.DialogResult.OK)
		{
			this.Show();
		}

		// 还是要把当前登录对象传过去、当前时间  ——》后期考虑放在tools中
	}

	private void MainMain_Load(Object sender, tangible.EventArgs e)
	{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region
		FillPieChart();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 随机化头像
		Random rd = new Random();
//C# TO JAVA CONVERTER TODO TASK: There is no two-argument version of 'nextInt' in Java:
		index_picture_index = rd.nextInt(1,4);
		OpenFileDialog openFileDialog1 = new OpenFileDialog();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] picturebytes;
		byte[] picturebytes;
		String ImagePath;

		if (index_picture_index == 1)
		{
			ImagePath = "C:\\Users\\1\\Desktop\\SQLHelper\\WindowsFormsApp1\\Images\\728452215511895916.jpg";
			FileInputStream fs = new FileInputStream(ImagePath);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: picturebytes = new byte[fs.Length];
			picturebytes = new byte[fs.Length];
			BinaryReader br = new BinaryReader(fs);
			picturebytes = br.ReadBytes((int)fs.Length);
//C# TO JAVA CONVERTER TODO TASK: C# to Java Converter cannot determine whether this System.IO.MemoryStream is input or output:
			MemoryStream ms = new MemoryStream(picturebytes);
			bmpt = new Bitmap(ms);
			this.pictureBox3.Visible = true;
			//this.pictureBox6.Image = bmpt;
			this.pictureBox3.BackgroundImage = bmpt;
			this.pictureBox13.BackgroundImage = bmpt;



		}
		else if (index_picture_index == 2)
		{
			ImagePath = "C:\\Users\\1\\Desktop\\SQLHelper\\WindowsFormsApp1\\Images\\728452215511895916.jpg";
			FileInputStream fs = new FileInputStream(ImagePath);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: picturebytes = new byte[fs.Length];
			picturebytes = new byte[fs.Length];
			BinaryReader br = new BinaryReader(fs);
			picturebytes = br.ReadBytes((int)fs.Length);
//C# TO JAVA CONVERTER TODO TASK: C# to Java Converter cannot determine whether this System.IO.MemoryStream is input or output:
			MemoryStream ms = new MemoryStream(picturebytes);
			bmpt = new Bitmap(ms);
			this.pictureBox3.Visible = true;
			//this.pictureBox6.Image = bmpt;
			this.pictureBox3.BackgroundImage = bmpt;
			this.pictureBox13.BackgroundImage = bmpt;

		}
		else
		{
			ImagePath = "C:\\Users\\1\\Desktop\\SQLHelper\\WindowsFormsApp1\\Images\\728452215511895916.jpg";
			FileInputStream fs = new FileInputStream(ImagePath);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: picturebytes = new byte[fs.Length];
			picturebytes = new byte[fs.Length];
			BinaryReader br = new BinaryReader(fs);
			picturebytes = br.ReadBytes((int)fs.Length);
//C# TO JAVA CONVERTER TODO TASK: C# to Java Converter cannot determine whether this System.IO.MemoryStream is input or output:
			MemoryStream ms = new MemoryStream(picturebytes);
			bmpt = new Bitmap(ms);
			this.pictureBox3.Visible = true;
			//this.pictureBox6.Image = bmpt;
			this.pictureBox3.BackgroundImage = bmpt;
			this.pictureBox13.BackgroundImage = bmpt;

		}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 随机化头像

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion
	}


	private void FillPieChart()
	{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region
		String[] x = new String[] {"访视医生", "诊断医生", "护士"}; //将饼图分为3块分别代表三块不同的油田
		int[] y = new int[] {30, 78, 30}; //代表三块不同的油田的数值
		//实习3D画面
		//this.chartpie.ChartAreas[0].Area3DStyle.Enable3D = true;
		this.chartpie.Series[0].ChartType = SeriesChartType.Doughnut; //选择图的类型为饼图
		//this.chartpie.Series[0].MarkerSize = 5;
		//this.chartpie.Series[0].MarkerStyle = MarkerStyle.Circle;
		//this.chartpie.Series[0]["PieLineColor"] = "Black";
		this.chartpie.Series[0]["PieLabelStyle"] = "Outside";

		//this.chartpie.Series[0].CustomProperties = "DoughnutRadius = 20";

		this.chartpie.Series[0].Points.DataBindXY(x, y); //绑定xy数据
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion


		String[] x1 = new String[] {"访视医生", "诊断医生", "护士"}; //将饼图分为3块分别代表三块不同的油田
		int[] y1 = new int[] {90, 78, 30}; //代表三块不同的油田的数值
		//实习3D画面
		//this.chartpie.ChartAreas[0].Area3DStyle.Enable3D = true;
		this.chart1.Series[0].ChartType = SeriesChartType.Doughnut; //选择图的类型为饼图
		//this.chartpie.Series[0].MarkerSize = 5;
		//this.chartpie.Series[0].MarkerStyle = MarkerStyle.Circle;
		//this.chartpie.Series[0]["PieLineColor"] = "Black";
		this.chart1.Series[0]["PieLabelStyle"] = "Outside";

		//this.chartpie.Series[0].CustomProperties = "DoughnutRadius = 20";

		this.chart1.Series[0].Points.DataBindXY(x1, y1); //绑定xy数据
	}
	private void pictureBox5_Click(Object sender, tangible.EventArgs e)
	{
		// 打开访手术申请统界面
		Form_arrage1 Form_arrage1_ = new Form_arrage1();
		this.Hide();
		//Form_arrage1_.ShowDialog(this);
		if (Form_arrage1_.ShowDialog() == System.Windows.Forms.DialogResult.OK)
		{
			this.Show();
		}

		// 还是要把当前登录对象传过去、当前时间  ——》后期考虑放在tools中
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 分页控件
	// 首页
	private void btnFirst_Click(Object sender, tangible.EventArgs e)
	{

	}
	// 上一页
	private void btnPrev_Click(Object sender, tangible.EventArgs e)
	{


	}
	// 下一页
	private void btnNext_Click(Object sender, tangible.EventArgs e)
	{
;

	}
	// 尾页
	private void btnLast_Click(Object sender, tangible.EventArgs e)
	{


	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
	/** 
	 每隔几秒钟去查一下会议表，看是否有小于或等于5分钟的，if有则提示。
	 
	 @param sender
	 @param e
	*/
	private void metting_timer_Tick(Object sender, tangible.EventArgs e)
	{



	}

	private void pictureBox7_Click(Object sender, tangible.EventArgs e)
	{
		// 打开访视系统界面
		Form_middle form_visit = new Form_middle();
		this.Hide();
		form_visit.ShowDialog(this);
		if (form_visit.ShowDialog() == System.Windows.Forms.DialogResult.OK)
		{
			this.Show();
		}
	}

	private void label9_Click(Object sender, tangible.EventArgs e)
	{

	}


	/** 
	 必需的设计器变量。
	*/
	private System.ComponentModel.IContainer components = null;

	/** 
	 清理所有正在使用的资源。
	 
	 @param disposing 如果应释放托管资源，为 true；否则为 false。
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
		///#region Windows 窗体设计器生成的代码

	/** 
	 设计器支持所需的方法 - 不要修改
	 使用代码编辑器修改此方法的内容。
	*/
	private void InitializeComponent()
	{
		this.components = new System.ComponentModel.Container();
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(MainMain.class);
		System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea7 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
		System.Windows.Forms.DataVisualization.Charting.Legend legend7 = new System.Windows.Forms.DataVisualization.Charting.Legend();
		System.Windows.Forms.DataVisualization.Charting.Series series7 = new System.Windows.Forms.DataVisualization.Charting.Series();
		System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea8 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
		System.Windows.Forms.DataVisualization.Charting.Legend legend8 = new System.Windows.Forms.DataVisualization.Charting.Legend();
		System.Windows.Forms.DataVisualization.Charting.Series series8 = new System.Windows.Forms.DataVisualization.Charting.Series();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle10 = new System.Windows.Forms.DataGridViewCellStyle();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle11 = new System.Windows.Forms.DataGridViewCellStyle();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle12 = new System.Windows.Forms.DataGridViewCellStyle();
		this.panel1 = new System.Windows.Forms.Panel();
		this.pictureBox13 = new System.Windows.Forms.PictureBox();
		this.pictureBox11 = new System.Windows.Forms.PictureBox();
		this.labDate3 = new System.Windows.Forms.Label();
		this.labName2 = new System.Windows.Forms.Label();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.label1 = new System.Windows.Forms.Label();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.panel2 = new System.Windows.Forms.Panel();
		this.button1 = new System.Windows.Forms.Button();
		this.btnLogin = new System.Windows.Forms.Button();
		this.label9 = new System.Windows.Forms.Label();
		this.labDate1 = new System.Windows.Forms.Label();
		this.label11 = new System.Windows.Forms.Label();
		this.label12 = new System.Windows.Forms.Label();
		this.label10 = new System.Windows.Forms.Label();
		this.label8 = new System.Windows.Forms.Label();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		this.pictureBox5 = new System.Windows.Forms.PictureBox();
		this.pictureBox8 = new System.Windows.Forms.PictureBox();
		this.pictureBox7 = new System.Windows.Forms.PictureBox();
		this.pictureBox4 = new System.Windows.Forms.PictureBox();
		this.label7 = new System.Windows.Forms.Label();
		this.labName1 = new System.Windows.Forms.Label();
		this.pictureBox3 = new System.Windows.Forms.PictureBox();
		this.labDate2 = new System.Windows.Forms.Label();
		this.panel3 = new System.Windows.Forms.Panel();
		this.pictureBox9 = new System.Windows.Forms.PictureBox();
		this.label14 = new System.Windows.Forms.Label();
		this.panel4 = new System.Windows.Forms.Panel();
		this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
		this.chartpie = new System.Windows.Forms.DataVisualization.Charting.Chart();
		this.pictureBox12 = new System.Windows.Forms.PictureBox();
		this.panel9 = new System.Windows.Forms.Panel();
		this.label19 = new System.Windows.Forms.Label();
		this.label20 = new System.Windows.Forms.Label();
		this.label21 = new System.Windows.Forms.Label();
		this.label22 = new System.Windows.Forms.Label();
		this.panel8 = new System.Windows.Forms.Panel();
		this.label15 = new System.Windows.Forms.Label();
		this.label16 = new System.Windows.Forms.Label();
		this.label17 = new System.Windows.Forms.Label();
		this.label18 = new System.Windows.Forms.Label();
		this.panel7 = new System.Windows.Forms.Panel();
		this.label4 = new System.Windows.Forms.Label();
		this.label3 = new System.Windows.Forms.Label();
		this.label6 = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.pictureBox10 = new System.Windows.Forms.PictureBox();
		this.label13 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.panel6 = new System.Windows.Forms.Panel();
		this.dgvNotice = new System.Windows.Forms.DataGridView();
		this.notice_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.title = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.notice_date = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.timer1 = new System.Windows.Forms.Timer(this.components);
		this.label23 = new System.Windows.Forms.Label();
		this.label24 = new System.Windows.Forms.Label();
		this.pictureBox14 = new System.Windows.Forms.PictureBox();
		this.label25 = new System.Windows.Forms.Label();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox13)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox11)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.panel2.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox8)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
		this.panel3.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox9)).BeginInit();
		this.panel4.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.chartpie)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).BeginInit();
		this.panel9.SuspendLayout();
		this.panel8.SuspendLayout();
		this.panel7.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).BeginInit();
		this.panel6.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.dgvNotice)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox14)).BeginInit();
		this.SuspendLayout();
		// 
		// panel1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(140)))), ((int)(((byte)(118)))), ((int)(((byte)(254)))));
		this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(140)))), ((int)(((byte)(118)))), ((int)(((byte)(254)))));
		this.panel1.Controls.Add(this.pictureBox13);
		this.panel1.Controls.Add(this.pictureBox11);
		this.panel1.Controls.Add(this.labDate3);
		this.panel1.Controls.Add(this.labName2);
		this.panel1.Controls.Add(this.pictureBox2);
		this.panel1.Controls.Add(this.label1);
		this.panel1.Controls.Add(this.pictureBox1);
		this.panel1.Location = new System.Drawing.Point(-7, 1);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(1119, 42);
		this.panel1.TabIndex = 0;
		// 
		// pictureBox13
		// 
		this.pictureBox13.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox13.BackgroundImage")));
		this.pictureBox13.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
		this.pictureBox13.Location = new System.Drawing.Point(843, 8);
		this.pictureBox13.Name = "pictureBox13";
		this.pictureBox13.Size = new System.Drawing.Size(42, 28);
		this.pictureBox13.TabIndex = 3;
		this.pictureBox13.TabStop = false;
		// 
		// pictureBox11
		// 
		this.pictureBox11.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox11.BackgroundImage")));
		this.pictureBox11.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox11.Location = new System.Drawing.Point(1062, 6);
		this.pictureBox11.Name = "pictureBox11";
		this.pictureBox11.Size = new System.Drawing.Size(46, 33);
		this.pictureBox11.TabIndex = 6;
		this.pictureBox11.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox11.Click += new System.EventHandler(this.pictureBox11_Click);
		// 
		// labDate3
		// 
		this.labDate3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labDate3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate3.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.labDate3.Location = new System.Drawing.Point(980, 16);
		this.labDate3.Name = "labDate3";
		this.labDate3.Size = new System.Drawing.Size(36, 17);
		this.labDate3.TabIndex = 4;
		this.labDate3.Text = "时 间";
		// 
		// labName2
		// 
		this.labName2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labName2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labName2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labName2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(185)))), ((int)(((byte)(36)))));
		this.labName2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(185)))), ((int)(((byte)(36)))));
		this.labName2.Location = new System.Drawing.Point(889, 12);
		this.labName2.Name = "labName2";
		this.labName2.Size = new System.Drawing.Size(57, 22);
		this.labName2.TabIndex = 3;
		this.labName2.Text = "手  术 ";
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
		this.pictureBox2.Location = new System.Drawing.Point(780, 6);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(47, 31);
		this.pictureBox2.TabIndex = 2;
		this.pictureBox2.TabStop = false;
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label1.Location = new System.Drawing.Point(82, 12);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(113, 19);
		this.label1.TabIndex = 1;
		this.label1.Text = "手 术 管 理 系 统";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.label1.Click += new System.EventHandler(this.label1_Click);
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
		this.pictureBox1.Location = new System.Drawing.Point(28, 6);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(48, 31);
		this.pictureBox1.TabIndex = 0;
		this.pictureBox1.TabStop = false;
		// 
		// panel2
		// 
		this.panel2.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.panel2.Controls.Add(this.button1);
		this.panel2.Controls.Add(this.btnLogin);
		this.panel2.Controls.Add(this.label9);
		this.panel2.Controls.Add(this.labDate1);
		this.panel2.Controls.Add(this.label11);
		this.panel2.Controls.Add(this.label12);
		this.panel2.Controls.Add(this.label25);
		this.panel2.Controls.Add(this.label10);
		this.panel2.Controls.Add(this.label8);
		this.panel2.Controls.Add(this.pictureBox6);
		this.panel2.Controls.Add(this.pictureBox5);
		this.panel2.Controls.Add(this.pictureBox14);
		this.panel2.Controls.Add(this.pictureBox8);
		this.panel2.Controls.Add(this.pictureBox7);
		this.panel2.Controls.Add(this.pictureBox4);
		this.panel2.Controls.Add(this.label7);
		this.panel2.Controls.Add(this.labName1);
		this.panel2.Controls.Add(this.pictureBox3);
		this.panel2.Controls.Add(this.labDate2);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.panel2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.panel2.Location = new System.Drawing.Point(0, 43);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(257, 572);
		this.panel2.TabIndex = 1;
		// 
		// button1
		// 
		this.button1.BackColor = System.Drawing.SystemColors.ButtonHighlight;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button1.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button1.FlatAppearance.BorderSize = 0;
		this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.ForeColor = System.Drawing.SystemColors.InactiveCaptionText;
		this.button1.Location = new System.Drawing.Point(138, 507);
		this.button1.Name = "button1";
		this.button1.Size = new System.Drawing.Size(94, 29);
		this.button1.TabIndex = 11;
		this.button1.Text = "修改密码";
		this.button1.UseVisualStyleBackColor = false;
		// 
		// btnLogin
		// 
		this.btnLogin.BackColor = System.Drawing.SystemColors.ButtonHighlight;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderSize = 0;
		this.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.ForeColor = System.Drawing.SystemColors.InactiveCaptionText;
		this.btnLogin.Location = new System.Drawing.Point(18, 507);
		this.btnLogin.Name = "btnLogin";
		this.btnLogin.Size = new System.Drawing.Size(94, 29);
		this.btnLogin.TabIndex = 11;
		this.btnLogin.Text = "系统设置";
		this.btnLogin.UseVisualStyleBackColor = false;
		// 
		// label9
		// 
		this.label9.AutoSize = true;
		this.label9.Location = new System.Drawing.Point(21, 363);
		this.label9.Name = "label9";
		this.label9.Size = new System.Drawing.Size(56, 17);
		this.label9.TabIndex = 6;
		this.label9.Text = "手术申请";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.label9.Click += new System.EventHandler(this.label9_Click);
		// 
		// labDate1
		// 
		this.labDate1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labDate1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate1.Location = new System.Drawing.Point(21, 25);
		this.labDate1.Name = "labDate1";
		this.labDate1.Size = new System.Drawing.Size(45, 19);
		this.labDate1.TabIndex = 0;
		this.labDate1.Text = "日  期";
		// 
		// label11
		// 
		this.label11.AutoSize = true;
		this.label11.Location = new System.Drawing.Point(183, 363);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(56, 17);
		this.label11.TabIndex = 6;
		this.label11.Text = "访视系统";
		// 
		// label12
		// 
		this.label12.AutoSize = true;
		this.label12.Location = new System.Drawing.Point(25, 454);
		this.label12.Name = "label12";
		this.label12.Size = new System.Drawing.Size(56, 17);
		this.label12.TabIndex = 6;
		this.label12.Text = "术中管理";
		// 
		// label10
		// 
		this.label10.AutoSize = true;
		this.label10.Location = new System.Drawing.Point(103, 454);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(56, 17);
		this.label10.TabIndex = 6;
		this.label10.Text = "手术记录";
		// 
		// label8
		// 
		this.label8.AutoSize = true;
		this.label8.Location = new System.Drawing.Point(102, 363);
		this.label8.Name = "label8";
		this.label8.Size = new System.Drawing.Size(56, 17);
		this.label8.TabIndex = 6;
		this.label8.Text = "手术排班";
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(184, 317);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(54, 41);
		this.pictureBox6.TabIndex = 5;
		this.pictureBox6.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox6.Click += new System.EventHandler(this.pictureBox6_Click);
		// 
		// pictureBox5
		// 
		this.pictureBox5.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox5.BackgroundImage")));
		this.pictureBox5.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox5.Location = new System.Drawing.Point(102, 318);
		this.pictureBox5.Name = "pictureBox5";
		this.pictureBox5.Size = new System.Drawing.Size(54, 41);
		this.pictureBox5.TabIndex = 5;
		this.pictureBox5.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox5.Click += new System.EventHandler(this.pictureBox5_Click);
		// 
		// pictureBox8
		// 
		this.pictureBox8.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.pictureBox8.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox8.BackgroundImage")));
		this.pictureBox8.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox8.Location = new System.Drawing.Point(105, 405);
		this.pictureBox8.Name = "pictureBox8";
		this.pictureBox8.Size = new System.Drawing.Size(54, 40);
		this.pictureBox8.TabIndex = 5;
		this.pictureBox8.TabStop = false;
		// 
		// pictureBox7
		// 
		this.pictureBox7.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox7.BackgroundImage")));
		this.pictureBox7.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox7.Location = new System.Drawing.Point(21, 404);
		this.pictureBox7.Name = "pictureBox7";
		this.pictureBox7.Size = new System.Drawing.Size(54, 40);
		this.pictureBox7.TabIndex = 5;
		this.pictureBox7.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox7.Click += new System.EventHandler(this.pictureBox7_Click);
		// 
		// pictureBox4
		// 
		this.pictureBox4.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox4.BackgroundImage")));
		this.pictureBox4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox4.Location = new System.Drawing.Point(23, 318);
		this.pictureBox4.Name = "pictureBox4";
		this.pictureBox4.Size = new System.Drawing.Size(52, 40);
		this.pictureBox4.TabIndex = 5;
		this.pictureBox4.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click);
		// 
		// label7
		// 
		this.label7.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Location = new System.Drawing.Point(79, 233);
		this.label7.Name = "label7";
		this.label7.Size = new System.Drawing.Size(59, 19);
		this.label7.TabIndex = 3;
		this.label7.Text = "您 好 ！";
		// 
		// labName1
		// 
		this.labName1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labName1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labName1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labName1.Location = new System.Drawing.Point(75, 209);
		this.labName1.Name = "labName1";
		this.labName1.Size = new System.Drawing.Size(58, 22);
		this.labName1.TabIndex = 3;
		this.labName1.Text = "用户名";
		// 
		// pictureBox3
		// 
		this.pictureBox3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox3.BackgroundImage")));
		this.pictureBox3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox3.Location = new System.Drawing.Point(43, 64);
		this.pictureBox3.Name = "pictureBox3";
		this.pictureBox3.Size = new System.Drawing.Size(139, 132);
		this.pictureBox3.TabIndex = 2;
		this.pictureBox3.TabStop = false;
		// 
		// labDate2
		// 
		this.labDate2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labDate2.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate2.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate2.Location = new System.Drawing.Point(158, 25);
		this.labDate2.Name = "labDate2";
		this.labDate2.Size = new System.Drawing.Size(37, 19);
		this.labDate2.TabIndex = 1;
		this.labDate2.Text = "星期";
		// 
		// panel3
		// 
		this.panel3.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.panel3.Controls.Add(this.pictureBox9);
		this.panel3.Controls.Add(this.label14);
		this.panel3.Location = new System.Drawing.Point(262, 44);
		this.panel3.Name = "panel3";
		this.panel3.Size = new System.Drawing.Size(412, 51);
		this.panel3.TabIndex = 2;
		// 
		// pictureBox9
		// 
		this.pictureBox9.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox9.BackgroundImage")));
		this.pictureBox9.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox9.Location = new System.Drawing.Point(13, 8);
		this.pictureBox9.Name = "pictureBox9";
		this.pictureBox9.Size = new System.Drawing.Size(12, 38);
		this.pictureBox9.TabIndex = 1;
		this.pictureBox9.TabStop = false;
		// 
		// label14
		// 
		this.label14.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Location = new System.Drawing.Point(39, 20);
		this.label14.Name = "label14";
		this.label14.Size = new System.Drawing.Size(77, 19);
		this.label14.TabIndex = 0;
		this.label14.Text = "通 知 公 告";
		// 
		// panel4
		// 
		this.panel4.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.panel4.Controls.Add(this.label24);
		this.panel4.Controls.Add(this.label23);
		this.panel4.Controls.Add(this.chart1);
		this.panel4.Controls.Add(this.chartpie);
		this.panel4.Controls.Add(this.pictureBox12);
		this.panel4.Controls.Add(this.panel9);
		this.panel4.Controls.Add(this.panel8);
		this.panel4.Controls.Add(this.panel7);
		this.panel4.Controls.Add(this.pictureBox10);
		this.panel4.Controls.Add(this.label13);
		this.panel4.Controls.Add(this.label2);
		this.panel4.ForeColor = System.Drawing.SystemColors.ControlText;
		this.panel4.Location = new System.Drawing.Point(680, 43);
		this.panel4.Name = "panel4";
		this.panel4.Size = new System.Drawing.Size(432, 536);
		this.panel4.TabIndex = 3;
		// 
		// chart1
		// 
		this.chart1.Anchor = (System.Windows.Forms.AnchorStyles.forValue((((System.Windows.Forms.AnchorStyles.Top.getValue() | System.Windows.Forms.AnchorStyles.Bottom.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Left.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Right.getValue())));
		chartArea7.Name = "ChartArea1";
		this.chart1.ChartAreas.Add(chartArea7);
		legend7.Name = "Legend1";
		this.chart1.Legends.Add(legend7);
		this.chart1.Location = new System.Drawing.Point(15, 376);
		this.chart1.Name = "chart1";
		this.chart1.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.Berry;
		series7.ChartArea = "ChartArea1";
		series7.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Doughnut;
		series7.Color = System.Drawing.Color.BlueViolet;
		series7.CustomProperties = "MinimumRelativePieSize=60, DoughnutRadius=30, CollectedColor=BlueViolet";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: series7.Font = new System.Drawing.Font("微软雅黑", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		series7.Font = new System.Drawing.Font("微软雅黑", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		series7.Legend = "Legend1";
		series7.Name = "Series1";
		this.chart1.Series.Add(series7);
		this.chart1.Size = new System.Drawing.Size(344, 157);
		this.chart1.TabIndex = 6;
		this.chart1.Text = "chart1";
		// 
		// chartpie
		// 
		this.chartpie.Anchor = (System.Windows.Forms.AnchorStyles.forValue((((System.Windows.Forms.AnchorStyles.Top.getValue() | System.Windows.Forms.AnchorStyles.Bottom.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Left.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Right.getValue())));
		chartArea8.Name = "ChartArea1";
		this.chartpie.ChartAreas.Add(chartArea8);
		legend8.Name = "Legend1";
		this.chartpie.Legends.Add(legend8);
		this.chartpie.Location = new System.Drawing.Point(16, 226);
		this.chartpie.Name = "chartpie";
		this.chartpie.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.Bright;
		series8.ChartArea = "ChartArea1";
		series8.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Doughnut;
		series8.Color = System.Drawing.Color.BlueViolet;
		series8.CustomProperties = "MinimumRelativePieSize=60, DoughnutRadius=30, CollectedColor=BlueViolet";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: series8.Font = new System.Drawing.Font("微软雅黑", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		series8.Font = new System.Drawing.Font("微软雅黑", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		series8.Legend = "Legend1";
		series8.Name = "Series1";
		this.chartpie.Series.Add(series8);
		this.chartpie.Size = new System.Drawing.Size(344, 157);
		this.chartpie.TabIndex = 6;
		this.chartpie.Text = "chart1";
		// 
		// pictureBox12
		// 
		this.pictureBox12.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox12.BackgroundImage")));
		this.pictureBox12.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox12.Location = new System.Drawing.Point(3, 504);
		this.pictureBox12.Name = "pictureBox12";
		this.pictureBox12.Size = new System.Drawing.Size(6, 32);
		this.pictureBox12.TabIndex = 5;
		this.pictureBox12.TabStop = false;
		// 
		// panel9
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel9.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel9.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel9.Controls.Add(this.label19);
		this.panel9.Controls.Add(this.label20);
		this.panel9.Controls.Add(this.label21);
		this.panel9.Controls.Add(this.label22);
		this.panel9.Location = new System.Drawing.Point(264, 92);
		this.panel9.Name = "panel9";
		this.panel9.Size = new System.Drawing.Size(96, 124);
		this.panel9.TabIndex = 2;
		// 
		// label19
		// 
		this.label19.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.ForeColor = System.Drawing.Color.DimGray;
		this.label19.Location = new System.Drawing.Point(11, 86);
		this.label19.Name = "label19";
		this.label19.Size = new System.Drawing.Size(80, 17);
		this.label19.TabIndex = 6;
		this.label19.Text = "比较昨天数据";
		// 
		// label20
		// 
		this.label20.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label20.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.ForeColor = System.Drawing.Color.DimGray;
		this.label20.Location = new System.Drawing.Point(11, 13);
		this.label20.Name = "label20";
		this.label20.Size = new System.Drawing.Size(68, 17);
		this.label20.TabIndex = 6;
		this.label20.Text = "未安排人数";
		// 
		// label21
		// 
		this.label21.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label21.Font = new System.Drawing.Font("Arial Rounded MT Bold", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label21.Font = new System.Drawing.Font("Arial Rounded MT Bold", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label21.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label21.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label21.Location = new System.Drawing.Point(45, 101);
		this.label21.Name = "label21";
		this.label21.Size = new System.Drawing.Size(49, 22);
		this.label21.TabIndex = 1;
		this.label21.Text = "0.50";
		// 
		// label22
		// 
		this.label22.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label22.Font = new System.Drawing.Font("Arial Rounded MT Bold", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label22.Font = new System.Drawing.Font("Arial Rounded MT Bold", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label22.Location = new System.Drawing.Point(22, 34);
		this.label22.Name = "label22";
		this.label22.Size = new System.Drawing.Size(55, 37);
		this.label22.TabIndex = 1;
		this.label22.Text = "33";
		// 
		// panel8
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel8.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel8.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel8.Controls.Add(this.label15);
		this.panel8.Controls.Add(this.label16);
		this.panel8.Controls.Add(this.label17);
		this.panel8.Controls.Add(this.label18);
		this.panel8.Location = new System.Drawing.Point(142, 93);
		this.panel8.Name = "panel8";
		this.panel8.Size = new System.Drawing.Size(96, 124);
		this.panel8.TabIndex = 2;
		// 
		// label15
		// 
		this.label15.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label15.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.ForeColor = System.Drawing.Color.DimGray;
		this.label15.Location = new System.Drawing.Point(11, 86);
		this.label15.Name = "label15";
		this.label15.Size = new System.Drawing.Size(80, 17);
		this.label15.TabIndex = 6;
		this.label15.Text = "比较昨天数据";
		// 
		// label16
		// 
		this.label16.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label16.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.ForeColor = System.Drawing.Color.DimGray;
		this.label16.Location = new System.Drawing.Point(11, 13);
		this.label16.Name = "label16";
		this.label16.Size = new System.Drawing.Size(80, 17);
		this.label16.TabIndex = 6;
		this.label16.Text = "已经安排人数";
		// 
		// label17
		// 
		this.label17.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.Font = new System.Drawing.Font("Arial Rounded MT Bold", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label17.Font = new System.Drawing.Font("Arial Rounded MT Bold", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label17.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label17.Location = new System.Drawing.Point(45, 101);
		this.label17.Name = "label17";
		this.label17.Size = new System.Drawing.Size(49, 22);
		this.label17.TabIndex = 1;
		this.label17.Text = "0.20";
		// 
		// label18
		// 
		this.label18.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label18.Font = new System.Drawing.Font("Arial Rounded MT Bold", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label18.Font = new System.Drawing.Font("Arial Rounded MT Bold", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label18.Location = new System.Drawing.Point(22, 34);
		this.label18.Name = "label18";
		this.label18.Size = new System.Drawing.Size(36, 37);
		this.label18.TabIndex = 1;
		this.label18.Text = "7";
		// 
		// panel7
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel7.Controls.Add(this.label4);
		this.panel7.Controls.Add(this.label3);
		this.panel7.Controls.Add(this.label6);
		this.panel7.Controls.Add(this.label5);
		this.panel7.Location = new System.Drawing.Point(23, 93);
		this.panel7.Name = "panel7";
		this.panel7.Size = new System.Drawing.Size(96, 124);
		this.panel7.TabIndex = 2;
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.ForeColor = System.Drawing.Color.DimGray;
		this.label4.Location = new System.Drawing.Point(11, 86);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(80, 17);
		this.label4.TabIndex = 6;
		this.label4.Text = "比较昨天数据";
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.ForeColor = System.Drawing.Color.DimGray;
		this.label3.Location = new System.Drawing.Point(11, 13);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(56, 17);
		this.label3.TabIndex = 6;
		this.label3.Text = "申请人数";
		// 
		// label6
		// 
		this.label6.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label6.Font = new System.Drawing.Font("Arial Rounded MT Bold", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label6.Font = new System.Drawing.Font("Arial Rounded MT Bold", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label6.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label6.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label6.Location = new System.Drawing.Point(45, 101);
		this.label6.Name = "label6";
		this.label6.Size = new System.Drawing.Size(49, 22);
		this.label6.TabIndex = 1;
		this.label6.Text = "0.80";
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("Arial Rounded MT Bold", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label5.Font = new System.Drawing.Font("Arial Rounded MT Bold", 24F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label5.Location = new System.Drawing.Point(22, 34);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(55, 37);
		this.label5.TabIndex = 1;
		this.label5.Text = "40";
		// 
		// pictureBox10
		// 
		this.pictureBox10.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox10.BackgroundImage")));
		this.pictureBox10.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox10.Location = new System.Drawing.Point(39, 21);
		this.pictureBox10.Name = "pictureBox10";
		this.pictureBox10.Size = new System.Drawing.Size(10, 32);
		this.pictureBox10.TabIndex = 1;
		this.pictureBox10.TabStop = false;
		// 
		// label13
		// 
		this.label13.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label13.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Location = new System.Drawing.Point(65, 28);
		this.label13.Name = "label13";
		this.label13.Size = new System.Drawing.Size(41, 19);
		this.label13.TabIndex = 1;
		this.label13.Text = "统 计";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Location = new System.Drawing.Point(19, 64);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(74, 22);
		this.label2.TabIndex = 3;
		this.label2.Text = "今日访视";
		// 
		// panel6
		// 
		this.panel6.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.panel6.Controls.Add(this.dgvNotice);
		this.panel6.Location = new System.Drawing.Point(262, 96);
		this.panel6.Name = "panel6";
		this.panel6.Size = new System.Drawing.Size(412, 290);
		this.panel6.TabIndex = 0;
		// 
		// dgvNotice
		// 
		this.dgvNotice.AllowUserToAddRows = false;
		this.dgvNotice.AllowUserToDeleteRows = false;
		this.dgvNotice.BackgroundColor = System.Drawing.SystemColors.ButtonHighlight;
		this.dgvNotice.BorderStyle = System.Windows.Forms.BorderStyle.None;
		this.dgvNotice.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
		this.dgvNotice.ColumnHeadersVisible = false;
		this.dgvNotice.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {this.notice_id, this.title, this.notice_date});
		this.dgvNotice.GridColor = System.Drawing.SystemColors.ButtonHighlight;
		this.dgvNotice.Location = new System.Drawing.Point(0, 0);
		this.dgvNotice.MultiSelect = false;
		this.dgvNotice.Name = "dgvNotice";
		this.dgvNotice.RowHeadersVisible = false;
		this.dgvNotice.RowHeadersWidth = 62;
		this.dgvNotice.RowTemplate.DefaultCellStyle.SelectionBackColor = System.Drawing.SystemColors.ButtonShadow;
		this.dgvNotice.RowTemplate.Height = 23;
		this.dgvNotice.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
		this.dgvNotice.Size = new System.Drawing.Size(409, 287);
		this.dgvNotice.TabIndex = 0;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvNotice.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvNotice_CellContentClick);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvNotice.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvNotice_CellDoubleClick);
		// 
		// notice_id
		// 
		this.notice_id.DataPropertyName = "notice_id";
		dataGridViewCellStyle10.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.notice_id.DefaultCellStyle = dataGridViewCellStyle10;
		this.notice_id.HeaderText = "notice_id";
		this.notice_id.MinimumWidth = 8;
		this.notice_id.Name = "notice_id";
		this.notice_id.Width = 8;
		// 
		// title
		// 
		this.title.DataPropertyName = "title";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle11.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle11.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle11.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
		dataGridViewCellStyle11.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
		this.title.DefaultCellStyle = dataGridViewCellStyle11;
		this.title.HeaderText = "title";
		this.title.MinimumWidth = 8;
		this.title.Name = "title";
		this.title.Width = 250;
		// 
		// notice_date
		// 
		this.notice_date.DataPropertyName = "notice_date";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle12.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle12.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle12.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
		dataGridViewCellStyle12.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
		this.notice_date.DefaultCellStyle = dataGridViewCellStyle12;
		this.notice_date.HeaderText = "notice_date";
		this.notice_date.MinimumWidth = 8;
		this.notice_date.Name = "notice_date";
		this.notice_date.Width = 150;
		// 
		// timer1
		// 
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
		// 
		// label23
		// 
		this.label23.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label23.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.ForeColor = System.Drawing.Color.Black;
		this.label23.Location = new System.Drawing.Point(20, 233);
		this.label23.Name = "label23";
		this.label23.Size = new System.Drawing.Size(80, 17);
		this.label23.TabIndex = 7;
		this.label23.Text = "在院医师占比";
		// 
		// label24
		// 
		this.label24.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label24.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.ForeColor = System.Drawing.Color.Black;
		this.label24.Location = new System.Drawing.Point(21, 376);
		this.label24.Name = "label24";
		this.label24.Size = new System.Drawing.Size(104, 17);
		this.label24.TabIndex = 8;
		this.label24.Text = "在院医师经费占比";
		// 
		// pictureBox14
		// 
		this.pictureBox14.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.pictureBox14.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox14.BackgroundImage")));
		this.pictureBox14.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox14.Location = new System.Drawing.Point(181, 405);
		this.pictureBox14.Name = "pictureBox14";
		this.pictureBox14.Size = new System.Drawing.Size(54, 40);
		this.pictureBox14.TabIndex = 5;
		this.pictureBox14.TabStop = false;
		// 
		// label25
		// 
		this.label25.AutoSize = true;
		this.label25.Location = new System.Drawing.Point(179, 454);
		this.label25.Name = "label25";
		this.label25.Size = new System.Drawing.Size(68, 17);
		this.label25.TabIndex = 6;
		this.label25.Text = "管理员系统";
		// 
		// MainMain
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(1113, 618);
		this.Controls.Add(this.panel4);
		this.Controls.Add(this.panel6);
		this.Controls.Add(this.panel3);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel1);
		this.Cursor = System.Windows.Forms.Cursors.Hand;
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.Name = "MainMain";
		this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
		this.Text = "Form1";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.MainMain_Load);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.MainMain_MouseDown);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.MouseEnter += new System.EventHandler(this.MainMain_MouseEnter);
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox13)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox11)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.panel2.ResumeLayout(false);
		this.panel2.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox8)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
		this.panel3.ResumeLayout(false);
		this.panel3.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox9)).EndInit();
		this.panel4.ResumeLayout(false);
		this.panel4.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.chartpie)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).EndInit();
		this.panel9.ResumeLayout(false);
		this.panel9.PerformLayout();
		this.panel8.ResumeLayout(false);
		this.panel8.PerformLayout();
		this.panel7.ResumeLayout(false);
		this.panel7.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).EndInit();
		this.panel6.ResumeLayout(false);
		((System.ComponentModel.ISupportInitialize)(this.dgvNotice)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox14)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.Label labDate3;
	private System.Windows.Forms.Label labName2;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.Label label8;
	private System.Windows.Forms.PictureBox pictureBox4;
	private System.Windows.Forms.Label label7;
	private System.Windows.Forms.Label labName1;
	private System.Windows.Forms.PictureBox pictureBox3;
	private System.Windows.Forms.Label labDate2;
	private System.Windows.Forms.Label labDate1;
	private System.Windows.Forms.Panel panel3;
	private System.Windows.Forms.Panel panel4;
	private System.Windows.Forms.Label label9;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.Label label12;
	private System.Windows.Forms.Label label10;
	private System.Windows.Forms.PictureBox pictureBox6;
	private System.Windows.Forms.PictureBox pictureBox5;
	private System.Windows.Forms.PictureBox pictureBox8;
	private System.Windows.Forms.PictureBox pictureBox7;
	private System.Windows.Forms.PictureBox pictureBox9;
	private System.Windows.Forms.Panel panel6;
	private System.Windows.Forms.Label label14;
	private System.Windows.Forms.PictureBox pictureBox10;
	private System.Windows.Forms.Label label13;
	private System.Windows.Forms.Button button1;
	private System.Windows.Forms.Button btnLogin;
	private System.Windows.Forms.DataGridView dgvNotice;
	private System.Windows.Forms.PictureBox pictureBox11;
	private System.Windows.Forms.Panel panel9;
	private System.Windows.Forms.Label label19;
	private System.Windows.Forms.Label label20;
	private System.Windows.Forms.Label label21;
	private System.Windows.Forms.Label label22;
	private System.Windows.Forms.Panel panel8;
	private System.Windows.Forms.Label label15;
	private System.Windows.Forms.Label label16;
	private System.Windows.Forms.Label label17;
	private System.Windows.Forms.Label label18;
	private System.Windows.Forms.Panel panel7;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label6;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.DataGridViewTextBoxColumn notice_id;
	private System.Windows.Forms.DataGridViewTextBoxColumn title;
	private System.Windows.Forms.DataGridViewTextBoxColumn notice_date;
	private System.Windows.Forms.Timer timer1;
	private System.Windows.Forms.PictureBox pictureBox12;
	private System.Windows.Forms.DataVisualization.Charting.Chart chartpie;
	private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
	private System.Windows.Forms.PictureBox pictureBox13;
	private System.Windows.Forms.Label label25;
	private System.Windows.Forms.PictureBox pictureBox14;
	private System.Windows.Forms.Label label24;
	private System.Windows.Forms.Label label23;
}