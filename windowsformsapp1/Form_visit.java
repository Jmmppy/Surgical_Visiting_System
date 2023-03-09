package windowsformsapp1;

import Models.*;
import BLL.*;
import java.time.*;

public class Form_visit extends Form
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 窗体加载
	private IsForm1 _IsForm1;
	private IsForm2 _IsForm2;
	private IsForm3 _IsForm3;
	private IsForm4 _IsForm4;
	private IsForm5 _IsForm5;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 窗体加载
	private doc_table doc_table_ = new doc_table(); //当前登录的doc_table对象
	private partment_tableBll partment_tableBll_ = new partment_tableBll();
	public Form_visit(doc_table doc_tab, Bitmap bmpt)
	{
		InitializeComponent();
		timer1.Start();
		doc_table_ = doc_tab;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 显示登录的人信息
		this.labName1.Text = doc_table_.doc_name.toString();
		this.labName2.Text = doc_table_.doc_name.toString();
		this.lab_profession.Text = doc_table_.profession.toString();
		this.labpice_place.Text = doc_table_.pice_place.toString();
		int part_id = (int)doc_table_.partment_id;
		//this.labpartment.Text = Convert.ToString(part_id); 这里证明正确
		partment_table partment_table1_ = GetPartment_tableObject1(part_id);
		this.labpartment.Text = partment_table1_.partment_name.toString();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 显示登录的人信息
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 随机化头像
		//Random rd = new Random();
		//index_picture_index = rd.Next(1, 4);
		OpenFileDialog openFileDialog1 = new OpenFileDialog();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] picturebytes;
		byte[] picturebytes;
		String ImagePath;
		this.pictureBox3.BackgroundImage = bmpt;
		this.pictureBox4.BackgroundImage = bmpt;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 随机化头像

	}
	/**  观察者和事件委托
	 // 当我们选择了树形菜单是运行
	 
	 @param sender 是树形菜单本身
	 @param e 是事件参数对象
	*/
	private void treeView1_AfterSelect(Object sender, TreeViewEventArgs e)
	{
		for (TreeNode node : treeView1.Nodes)
		{
			node.BackColor = Color.White;
			node.ForeColor = Color.Black;
		}
		e.Node.BackColor = SystemColors.ScrollBar;

		e.Node.ForeColor = Color.White;

		switch (e.Node.Index)
		{
			case 0:
				if (_IsForm1 == null)
				{
					_IsForm1 = new IsForm1(); // 创建子窗体
					_IsForm1.MdiParent = this; // 子窗体的父容器是当前窗体（this）
					_IsForm1.Parent = this.panel2; // 子窗体出现在最顶层
				}
				if (_IsForm2 != null)
				{
					_IsForm2.Hide();
				}
				if (_IsForm3 != null)
				{
					_IsForm3.Hide();
				}
				if (_IsForm4 != null)
				{
					_IsForm4.Hide();
				}
				if (_IsForm5 != null)
				{
					_IsForm5.Hide();
				}
				_IsForm1.Show();


				break;
			case 1:
				if (_IsForm2 == null)
				{
					_IsForm2 = new IsForm2(); // 创建子窗体
					_IsForm2.MdiParent = this; // 子窗体的父容器是当前窗体（this）
					_IsForm2.Parent = this.panel2; // 子窗体出现在最顶层
				}

				if (_IsForm1 != null)
				{
					_IsForm1.Hide();
				}
				if (_IsForm3 != null)
				{
					_IsForm3.Hide();
				}
				if (_IsForm4 != null)
				{
					_IsForm4.Hide();
				}
				if (_IsForm5 != null)
				{
					_IsForm5.Hide();
				}
				_IsForm2.Show();
				break;
			case 2:
				if (_IsForm3 == null)
				{
					_IsForm3 = new IsForm3(); // 创建子窗体
					_IsForm3.MdiParent = this; // 子窗体的父容器是当前窗体（this）
					_IsForm3.Parent = this.panel2; // 子窗体出现在最顶层
				}
				if (_IsForm1 != null)
				{
					_IsForm1.Hide();
				}
				if (_IsForm2 != null)
				{
					_IsForm2.Hide();
				}
				if (_IsForm4 != null)
				{
					_IsForm4.Hide();
				}
				if (_IsForm5 != null)
				{
					_IsForm5.Hide();
				}
				_IsForm3.Show();
				break;

			case 3:
				if (_IsForm4 == null)
				{
					_IsForm4 = new IsForm4(); // 创建子窗体
					_IsForm4.MdiParent = this; // 子窗体的父容器是当前窗体（this）
					_IsForm4.Parent = this.panel2; // 子窗体出现在最顶层
				}
				if (_IsForm1 != null)
				{
					_IsForm1.Hide();
				}
				if (_IsForm2 != null)
				{
					_IsForm2.Hide();
				}
				if (_IsForm3 != null)
				{
					_IsForm3.Hide();
				}
				if (_IsForm5 != null)
				{
					_IsForm5.Hide();
				}
				_IsForm4.Show();
				break;

			case 4:
				if (_IsForm5 == null)
				{
					_IsForm5 = new IsForm5(); // 创建子窗体
					_IsForm5.MdiParent = this; // 子窗体的父容器是当前窗体（this）
					_IsForm5.Parent = this.panel2; // 子窗体出现在最顶层
				}
				if (_IsForm1 != null)
				{
					_IsForm1.Hide();
				}
				if (_IsForm2 != null)
				{
					_IsForm2.Hide();
				}
				if (_IsForm3 != null)
				{
					_IsForm3.Hide();
				}
				if (_IsForm4 != null)
				{
					_IsForm4.Hide();
				}
				_IsForm5.Show();
				break;

			case 5:
				this.Close();
				this.DialogResult = System.Windows.Forms.DialogResult.OK;
				//Form_visit_FormClosed();
				break;

		}
	}
	// 窗体的Load方法

	private partment_table GetPartment_tableObject1(int part_id)
	{
		return partment_tableBll_.getPartment_tableObject(part_id);
	}
	private void Form_visit_Load(Object sender, tangible.EventArgs e)
	{
		_IsForm1 = new IsForm1(); // 创建子窗体
		_IsForm1.MdiParent = this; // 子窗体的父容器是当前窗体（this）
		_IsForm1.Parent = this.panel2; // 子窗体出现在最顶层
		_IsForm1.Show();
		if (_IsForm3 == null)
		{
			_IsForm3 = new IsForm3(); // 创建子窗体
			_IsForm3.MdiParent = this; // 子窗体的父容器是当前窗体（this）
			_IsForm3.Parent = this.panel2; // 子窗体出现在最顶层
			_IsForm3.Hide();
		}
		//IsForm2 _IsForm1 = new IsForm2(); // 创建子窗体
		//_IsForm1.MdiParent = this;  // 子窗体的父容器是当前窗体（this）
		//_IsForm1.Parent = this.panel2;  // 子窗体出现在最顶层
		//_IsForm1.Show();

	}

	private void timer1_Tick(Object sender, tangible.EventArgs e)
	{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region  初始化时间

		labDate3.Text = LocalDateTime.now().ToLongTimeString().toString();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 初始化时间
	}
	/** 
	 // 当我们选择了树形菜单是运行
	 
	 @param sender 是树形菜单本身
	 @param e 是事件参数对象
	*/
	private void treeView1_AfterCheck(Object sender, TreeViewEventArgs e)
	{

	}

	private void Form_visit_FormClosed(Object sender, FormClosedEventArgs e)
	{
		this.DialogResult = System.Windows.Forms.DialogResult.OK;
	}

	private void pictureBox11_Click(Object sender, tangible.EventArgs e)
	{
		this.Close();
		this.DialogResult = System.Windows.Forms.DialogResult.OK;
	}

	private void treeView1_BeforeSelect(Object sender, TreeViewCancelEventArgs e)
	{


	}

	private void treeView1_BeforeCheck(Object sender, TreeViewCancelEventArgs e)
	{

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
		this.components = new System.ComponentModel.Container();
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form_visit.class);
		System.Windows.Forms.TreeNode treeNode1 = new System.Windows.Forms.TreeNode("患者管理");
		System.Windows.Forms.TreeNode treeNode2 = new System.Windows.Forms.TreeNode("发起会议");
		System.Windows.Forms.TreeNode treeNode3 = new System.Windows.Forms.TreeNode("会议&访视库");
		System.Windows.Forms.TreeNode treeNode4 = new System.Windows.Forms.TreeNode("录入");
		System.Windows.Forms.TreeNode treeNode5 = new System.Windows.Forms.TreeNode("会议访视记录");
		System.Windows.Forms.TreeNode treeNode6 = new System.Windows.Forms.TreeNode("返回");
		this.panel1 = new System.Windows.Forms.Panel();
		this.lab_profession = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.label4 = new System.Windows.Forms.Label();
		this.labpartment = new System.Windows.Forms.Label();
		this.labpice_place = new System.Windows.Forms.Label();
		this.labName1 = new System.Windows.Forms.Label();
		this.pictureBox3 = new System.Windows.Forms.PictureBox();
		this.panel4 = new System.Windows.Forms.Panel();
		this.treeView1 = new System.Windows.Forms.TreeView();
		this.panel2 = new System.Windows.Forms.Panel();
		this.panel3 = new System.Windows.Forms.Panel();
		this.panel5 = new System.Windows.Forms.Panel();
		this.pictureBox11 = new System.Windows.Forms.PictureBox();
		this.labDate3 = new System.Windows.Forms.Label();
		this.labName2 = new System.Windows.Forms.Label();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.label1 = new System.Windows.Forms.Label();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.timer1 = new System.Windows.Forms.Timer(this.components);
		this.pictureBox4 = new System.Windows.Forms.PictureBox();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
		this.panel4.SuspendLayout();
		this.panel3.SuspendLayout();
		this.panel5.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox11)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
		this.SuspendLayout();
		// 
		// panel1
		// 
		this.panel1.Controls.Add(this.lab_profession);
		this.panel1.Controls.Add(this.label5);
		this.panel1.Controls.Add(this.label4);
		this.panel1.Controls.Add(this.labpartment);
		this.panel1.Controls.Add(this.labpice_place);
		this.panel1.Controls.Add(this.labName1);
		this.panel1.Controls.Add(this.pictureBox3);
		this.panel1.Controls.Add(this.panel4);
		this.panel1.Location = new System.Drawing.Point(-1, 33);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(268, 555);
		this.panel1.TabIndex = 0;
		// 
		// lab_profession
		// 
		this.lab_profession.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lab_profession.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_profession.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_profession.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
		this.lab_profession.Location = new System.Drawing.Point(128, 150);
		this.lab_profession.Name = "lab_profession";
		this.lab_profession.Size = new System.Drawing.Size(42, 22);
		this.lab_profession.TabIndex = 4;
		this.lab_profession.Text = "职称";
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("微软雅黑", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Font = new System.Drawing.Font("微软雅黑", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.label5.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.label5.Location = new System.Drawing.Point(141, 183);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(22, 31);
		this.label5.TabIndex = 4;
		this.label5.Text = "|";
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.label4.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.label4.Location = new System.Drawing.Point(112, 142);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(22, 31);
		this.label4.TabIndex = 4;
		this.label4.Text = "|";
		// 
		// labpartment
		// 
		this.labpartment.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labpartment.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labpartment.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labpartment.Location = new System.Drawing.Point(159, 191);
		this.labpartment.Name = "labpartment";
		this.labpartment.Size = new System.Drawing.Size(42, 22);
		this.labpartment.TabIndex = 4;
		this.labpartment.Text = "科室";
		// 
		// labpice_place
		// 
		this.labpice_place.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labpice_place.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labpice_place.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labpice_place.Location = new System.Drawing.Point(40, 193);
		this.labpice_place.Name = "labpice_place";
		this.labpice_place.Size = new System.Drawing.Size(52, 22);
		this.labpice_place.TabIndex = 4;
		this.labpice_place.Text = "片  区";
		// 
		// labName1
		// 
		this.labName1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labName1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labName1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labName1.Location = new System.Drawing.Point(40, 150);
		this.labName1.Name = "labName1";
		this.labName1.Size = new System.Drawing.Size(58, 22);
		this.labName1.TabIndex = 4;
		this.labName1.Text = "用户名";
		// 
		// pictureBox3
		// 
		this.pictureBox3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox3.BackgroundImage")));
		this.pictureBox3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox3.Location = new System.Drawing.Point(63, 30);
		this.pictureBox3.Name = "pictureBox3";
		this.pictureBox3.Size = new System.Drawing.Size(124, 99);
		this.pictureBox3.TabIndex = 3;
		this.pictureBox3.TabStop = false;
		// 
		// panel4
		// 
		this.panel4.Controls.Add(this.treeView1);
		this.panel4.Location = new System.Drawing.Point(3, 242);
		this.panel4.Name = "panel4";
		this.panel4.Size = new System.Drawing.Size(265, 313);
		this.panel4.TabIndex = 0;
		// 
		// treeView1
		// 
		this.treeView1.BackColor = System.Drawing.SystemColors.Window;
		this.treeView1.Dock = System.Windows.Forms.DockStyle.Fill;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.treeView1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.treeView1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.treeView1.FullRowSelect = true;
		this.treeView1.ItemHeight = 50;
		this.treeView1.Location = new System.Drawing.Point(0, 0);
		this.treeView1.Name = "treeView1";
		treeNode1.BackColor = System.Drawing.Color.White;
		treeNode1.Name = "patienct_gam";
		treeNode1.Text = "患者管理";
		treeNode2.Name = "tnUpMeeting";
		treeNode2.Text = "发起会议";
		treeNode3.Name = "tnVisit";
		treeNode3.Text = "会议&访视库";
		treeNode4.Name = "tnInput";
		treeNode4.Text = "录入";
		treeNode5.Name = "tnVisitRecord";
		treeNode5.Text = "会议访视记录";
		treeNode6.Name = "tnBack";
		treeNode6.Text = "返回";
		this.treeView1.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {treeNode1, treeNode2, treeNode3, treeNode4, treeNode5, treeNode6});
		this.treeView1.ShowLines = false;
		this.treeView1.Size = new System.Drawing.Size(265, 313);
		this.treeView1.TabIndex = 0;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.treeView1.BeforeCheck += new System.Windows.Forms.TreeViewCancelEventHandler(this.treeView1_BeforeCheck);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.treeView1.AfterCheck += new System.Windows.Forms.TreeViewEventHandler(this.treeView1_AfterCheck);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.treeView1.BeforeSelect += new System.Windows.Forms.TreeViewCancelEventHandler(this.treeView1_BeforeSelect);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.treeView1.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treeView1_AfterSelect);
		// 
		// panel2
		// 
		this.panel2.Location = new System.Drawing.Point(272, 33);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(846, 555);
		this.panel2.TabIndex = 1;
		// 
		// panel3
		// 
		this.panel3.Controls.Add(this.panel5);
		this.panel3.Location = new System.Drawing.Point(-2, -1);
		this.panel3.Name = "panel3";
		this.panel3.Size = new System.Drawing.Size(1120, 32);
		this.panel3.TabIndex = 2;
		// 
		// panel5
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.panel5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.panel5.Controls.Add(this.pictureBox11);
		this.panel5.Controls.Add(this.labDate3);
		this.panel5.Controls.Add(this.labName2);
		this.panel5.Controls.Add(this.pictureBox4);
		this.panel5.Controls.Add(this.pictureBox2);
		this.panel5.Controls.Add(this.label1);
		this.panel5.Controls.Add(this.pictureBox1);
		this.panel5.Location = new System.Drawing.Point(1, -5);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(1119, 42);
		this.panel5.TabIndex = 1;
		// 
		// pictureBox11
		// 
		this.pictureBox11.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox11.BackgroundImage")));
		this.pictureBox11.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox11.Location = new System.Drawing.Point(1082, 7);
		this.pictureBox11.Name = "pictureBox11";
		this.pictureBox11.Size = new System.Drawing.Size(26, 27);
		this.pictureBox11.TabIndex = 6;
		this.pictureBox11.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox11.Click += new System.EventHandler(this.pictureBox11_Click);
		// 
		// labDate3
		// 
		this.labDate3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labDate3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate3.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.labDate3.Location = new System.Drawing.Point(980, 15);
		this.labDate3.Name = "labDate3";
		this.labDate3.Size = new System.Drawing.Size(41, 19);
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
		this.labName2.Location = new System.Drawing.Point(901, 15);
		this.labName2.Name = "labName2";
		this.labName2.Size = new System.Drawing.Size(57, 22);
		this.labName2.TabIndex = 3;
		this.labName2.Text = "手  术 ";
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
		this.pictureBox2.Location = new System.Drawing.Point(825, 9);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(27, 26);
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
		this.label1.Location = new System.Drawing.Point(82, 14);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(149, 19);
		this.label1.TabIndex = 1;
		this.label1.Text = "手 术 麻 醉 访 视 系 统";
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
		// timer1
		// 
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
		// 
		// pictureBox4
		// 
		this.pictureBox4.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox4.BackgroundImage")));
		this.pictureBox4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
		this.pictureBox4.Location = new System.Drawing.Point(872, 13);
		this.pictureBox4.Name = "pictureBox4";
		this.pictureBox4.Size = new System.Drawing.Size(27, 21);
		this.pictureBox4.TabIndex = 2;
		this.pictureBox4.TabStop = false;
		// 
		// Form_visit
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(1119, 590);
		this.Controls.Add(this.panel3);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel1);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.IsMdiContainer = true;
		this.Name = "Form_visit";
		this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
		this.Text = "Form_visit";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form_visit_FormClosed);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_visit_Load);
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
		this.panel4.ResumeLayout(false);
		this.panel3.ResumeLayout(false);
		this.panel5.ResumeLayout(false);
		this.panel5.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox11)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.TreeView treeView1;
	private System.Windows.Forms.Panel panel4;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.Panel panel3;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.PictureBox pictureBox11;
	private System.Windows.Forms.Label labDate3;
	private System.Windows.Forms.Label labName2;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.PictureBox pictureBox3;
	private System.Windows.Forms.Label lab_profession;
	private System.Windows.Forms.Label labpice_place;
	private System.Windows.Forms.Label labName1;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label labpartment;
	private System.Windows.Forms.Timer timer1;
	private System.Windows.Forms.PictureBox pictureBox4;
}