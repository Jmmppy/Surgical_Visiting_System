package windowsformsapp1;

import Models.*;
import BLL.*;
import java.util.*;
import java.time.*;

public class Create_Meeting1 extends Form
{
	//List<int> cur_index = new List<int>();
	//ss_visitTableBll ss_visitTableBll_;
	//List<cur_ss_visitTable> cur_ss_visitTable_;
	//cur_ss_visitTable[] cur_table_list;
	//int table_length;
	private meeting_tableBll meeting_tableBll_ = new meeting_tableBll();
	private ArrayList<String> cur_illnessId_list = new ArrayList<String>();
	private boolean isSelect = false;
	private String txb_title_;
	private LocalDateTime metting_start = LocalDateTime.MIN;
	private LocalDateTime metting_end = LocalDateTime.MIN;
	private String metting_pwd;
	private int list_len;
	private int t;



	/** 
	 初始化函数，
	 
	 @param 记录
	 @param index_list
	*/
	public Create_Meeting1(ArrayList<String> illnessId_list)
	{
		InitializeComponent();
		illnessId_list.forEach(i -> cur_illnessId_list.add(i)); //列表复制
		//头参数cur_ss_visitTable[] table_list, List< int > index_list
		//index_list.ForEach(i => cur_index.Add(i));   //列表复制
		//cur_table_list = table_list;



	}

	private void Create_Meeting1_Load(Object sender, tangible.EventArgs e)
	{
		this.timer3.Enabled = false;
		/*
		#region 来源于isForm2
		ss_visitTableBll_ = new ss_visitTableBll();  //Bll对象
		cur_ss_visitTable_ = ss_visitTableBll_.GetSs_visitTableList1();

		cur_ss_visitTable_.Sort((x, y) => x.narcosis_time.CompareTo(y.narcosis_time));   // narcosis_time时间排序
		table_list = cur_ss_visitTable_.ToArray(); // list转化为数组
		                                           
		table_length = table_list.Length; // 数据表对象长度;
		#endregion 来源于isForm2
		*/




		//this.label1.Text = cur_table_list[cur_index[0]].patient_name.ToString();
	}

	private void pictureBox1_Click(Object sender, tangible.EventArgs e)
	{
		this.txb_title.Text = "";
	}
	//当鼠标在会议密码上的操作
	private void ckB_mettingPwd_MouseEnter(Object sender, tangible.EventArgs e)
	{
		isSelect = this.ckB_mettingPwd.Checked;
		if (isSelect)
		{
			this.txb_pwd.Show();
			this.pictureBox2.Show();


		}
		else
		{
			this.txb_pwd.Hide();
			this.pictureBox2.Hide();

		}
	}

	private void ckB_mettingPwd_MouseDown(Object sender, MouseEventArgs e)
	{

	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 密码的可见与隐藏
	private void pictureBox2_Click(Object sender, tangible.EventArgs e)
	{
		this.txb_pwd.PasswordChar = '\0';
	}

	private void timer1_Tick(Object sender, tangible.EventArgs e)
	{
		this.txb_pwd.PasswordChar = '*';
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 密码的可见与隐藏

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 控制是否输入密码
	private void timer2_Tick(Object sender, tangible.EventArgs e)
	{
		isSelect = this.ckB_mettingPwd.Checked;
		if (isSelect)
		{
			this.txb_pwd.Show();
			this.pictureBox2.Show();


		}
		else
		{
			this.txb_pwd.Hide();
			this.pictureBox2.Hide();

		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 控制是否输入密码

	private void btnOK_Click(Object sender, tangible.EventArgs e)
	{
		meeting_table meeting_table_ = new meeting_table();
		txb_title_ = this.txb_title.Text.strip();
		metting_start = (LocalDateTime)this.dateTimePicker_start.Value;
		metting_end = (LocalDateTime)this.dateTimePicker_end.Value;
		metting_pwd = this.txb_pwd.Text.strip();
		list_len = cur_illnessId_list.toArray(new String[0]).length;
		if (list_len == 1)
		{
			meeting_table_ = new meeting_table();
			meeting_table_.setmeeting_name(txb_title_);
			meeting_table_.setstart_time(metting_start);
			meeting_table_.setend_time(metting_end);
			meeting_table_.setmeeting_Key(metting_pwd);
			meeting_table_.setillness_id_count(list_len);
			meeting_table_.setillness_id1((String)cur_illnessId_list.get(0));
			meeting_table_.setillness_id2((String)"0");
			meeting_table_.setillness_id3((String)"0");
			meeting_table_.setBelong_doc(Program.cur_LoginId);
		}
		if (list_len == 2)
		{
			meeting_table_ = new meeting_table();
			meeting_table_.setmeeting_name(txb_title_);
			meeting_table_.setstart_time(metting_start);
			meeting_table_.setend_time(metting_end);
			meeting_table_.setmeeting_Key(metting_pwd);
			meeting_table_.setillness_id_count(list_len);
			meeting_table_.setillness_id1((String)cur_illnessId_list.get(0));
			meeting_table_.setillness_id2((String)cur_illnessId_list.get(1));
			meeting_table_.setillness_id3((String)"0");
			meeting_table_.setBelong_doc(Program.cur_LoginId);
		}
		if (list_len == 3)
		{
			meeting_table_ = new meeting_table();
			meeting_table_.setmeeting_name(txb_title_);
			meeting_table_.setstart_time(metting_start);
			meeting_table_.setend_time(metting_end);
			meeting_table_.setmeeting_Key(metting_pwd);
			meeting_table_.setillness_id_count(list_len);
			meeting_table_.setillness_id1((String)cur_illnessId_list.get(0));
			meeting_table_.setillness_id2((String)cur_illnessId_list.get(1));
			meeting_table_.setillness_id3((String)cur_illnessId_list.get(2));
			meeting_table_.setBelong_doc(Program.cur_LoginId);
		}

		int row = meeting_tableBll_.insert_meeting_table(meeting_table_);
		if (row == 1)
		{ //插入成功
			this.timer3.Enabled = true;
			int t = 2;
			//MessageBox.Show("插入成功", $"提示!");
			this.DialogResult = System.Windows.Forms.DialogResult.OK;
			this.Close();
		}
	}

	private void timer3_Tick(Object sender, tangible.EventArgs e)
	{
		//t = t - 1;
		//if (t == 0)
		//{
		//    timer3.Enabled = false;

		//}
		//MessageBox.Show("插入成功", $"提示！{t}秒后关闭");




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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Create_Meeting1.class);
		this.label1 = new System.Windows.Forms.Label();
		this.txb_title = new System.Windows.Forms.TextBox();
		this.label2 = new System.Windows.Forms.Label();
		this.label3 = new System.Windows.Forms.Label();
		this.label4 = new System.Windows.Forms.Label();
		this.txb_pwd = new System.Windows.Forms.TextBox();
		this.ckB_mettingPwd = new System.Windows.Forms.CheckBox();
		this.btnOK = new System.Windows.Forms.Button();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.timer1 = new System.Windows.Forms.Timer(this.components);
		this.timer2 = new System.Windows.Forms.Timer(this.components);
		this.timer3 = new System.Windows.Forms.Timer(this.components);
		this.dateTimePicker_start = new System.Windows.Forms.DateTimePicker();
		this.dateTimePicker_end = new System.Windows.Forms.DateTimePicker();
		this.panel1 = new System.Windows.Forms.Panel();
		this.label5 = new System.Windows.Forms.Label();
		this.pictureBox9 = new System.Windows.Forms.PictureBox();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox9)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		this.SuspendLayout();
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
		this.label1.Location = new System.Drawing.Point(32, 33);
		this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(79, 20);
		this.label1.TabIndex = 0;
		this.label1.Text = "会议主题：";
		// 
		// txb_title
		// 
		this.txb_title.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
		this.txb_title.Location = new System.Drawing.Point(24, 61);
		this.txb_title.Name = "txb_title";
		this.txb_title.Size = new System.Drawing.Size(229, 21);
		this.txb_title.TabIndex = 1;
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
		this.label2.Location = new System.Drawing.Point(20, 111);
		this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(65, 20);
		this.label2.TabIndex = 0;
		this.label2.Text = "开始时间";
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
		this.label3.Location = new System.Drawing.Point(20, 185);
		this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(65, 20);
		this.label3.TabIndex = 0;
		this.label3.Text = "结束时间";
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
		this.label4.Location = new System.Drawing.Point(20, 276);
		this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(79, 20);
		this.label4.TabIndex = 0;
		this.label4.Text = "会议主题：";
		// 
		// txb_pwd
		// 
		this.txb_pwd.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
		this.txb_pwd.Location = new System.Drawing.Point(123, 312);
		this.txb_pwd.Name = "txb_pwd";
		this.txb_pwd.PasswordChar = '*';
		this.txb_pwd.Size = new System.Drawing.Size(106, 21);
		this.txb_pwd.TabIndex = 1;
		this.txb_pwd.Visible = false;
		// 
		// ckB_mettingPwd
		// 
		this.ckB_mettingPwd.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.ckB_mettingPwd.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.ckB_mettingPwd.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.ckB_mettingPwd.Location = new System.Drawing.Point(23, 312);
		this.ckB_mettingPwd.Name = "ckB_mettingPwd";
		this.ckB_mettingPwd.Size = new System.Drawing.Size(84, 24);
		this.ckB_mettingPwd.TabIndex = 3;
		this.ckB_mettingPwd.Text = "入会密码";
		this.ckB_mettingPwd.UseVisualStyleBackColor = true;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.ckB_mettingPwd.MouseDown += new System.Windows.Forms.MouseEventHandler(this.ckB_mettingPwd_MouseDown);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.ckB_mettingPwd.MouseEnter += new System.EventHandler(this.ckB_mettingPwd_MouseEnter);
		// 
		// btnOK
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOK.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.btnOK.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOK.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOK.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOK.FlatAppearance.BorderSize = 0;
		this.btnOK.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOK.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOK.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOK.ForeColor = System.Drawing.SystemColors.Window;
		this.btnOK.Location = new System.Drawing.Point(21, 389);
		this.btnOK.Name = "btnOK";
		this.btnOK.Size = new System.Drawing.Size(232, 33);
		this.btnOK.TabIndex = 14;
		this.btnOK.Text = "预约会议";
		this.btnOK.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(231, 63);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(23, 18);
		this.pictureBox1.TabIndex = 15;
		this.pictureBox1.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox2.Location = new System.Drawing.Point(232, 312);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(24, 24);
		this.pictureBox2.TabIndex = 15;
		this.pictureBox2.TabStop = false;
		this.pictureBox2.Visible = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click);
		// 
		// timer1
		// 
		this.timer1.Enabled = true;
		this.timer1.Interval = 2000;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
		// 
		// timer2
		// 
		this.timer2.Enabled = true;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer2.Tick += new System.EventHandler(this.timer2_Tick);
		// 
		// timer3
		// 
		this.timer3.Interval = 1000;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer3.Tick += new System.EventHandler(this.timer3_Tick);
		// 
		// dateTimePicker_start
		// 
		this.dateTimePicker_start.CustomFormat = "yyyy-MM-dd HH:mm:ss";
		this.dateTimePicker_start.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
		this.dateTimePicker_start.Location = new System.Drawing.Point(23, 144);
		this.dateTimePicker_start.Name = "dateTimePicker_start";
		this.dateTimePicker_start.Size = new System.Drawing.Size(174, 21);
		this.dateTimePicker_start.TabIndex = 16;
		// 
		// dateTimePicker_end
		// 
		this.dateTimePicker_end.CustomFormat = "yyyy-MM-dd HH:mm:ss";
		this.dateTimePicker_end.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
		this.dateTimePicker_end.Location = new System.Drawing.Point(23, 218);
		this.dateTimePicker_end.Name = "dateTimePicker_end";
		this.dateTimePicker_end.Size = new System.Drawing.Size(174, 21);
		this.dateTimePicker_end.TabIndex = 17;
		// 
		// panel1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.panel1.Controls.Add(this.pictureBox6);
		this.panel1.Controls.Add(this.label5);
		this.panel1.Location = new System.Drawing.Point(-3, 446);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(287, 56);
		this.panel1.TabIndex = 18;
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label5.Location = new System.Drawing.Point(84, 20);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(149, 19);
		this.label5.TabIndex = 2;
		this.label5.Text = "手 术 麻 醉 访 视 系 统";
		// 
		// pictureBox9
		// 
		this.pictureBox9.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox9.BackgroundImage")));
		this.pictureBox9.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox9.Location = new System.Drawing.Point(23, 33);
		this.pictureBox9.Name = "pictureBox9";
		this.pictureBox9.Size = new System.Drawing.Size(10, 22);
		this.pictureBox9.TabIndex = 19;
		this.pictureBox9.TabStop = false;
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(24, 8);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(54, 41);
		this.pictureBox6.TabIndex = 20;
		this.pictureBox6.TabStop = false;
		// 
		// Create_Meeting1
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.Color.White;
		this.ClientSize = new System.Drawing.Size(280, 501);
		this.Controls.Add(this.pictureBox9);
		this.Controls.Add(this.panel1);
		this.Controls.Add(this.dateTimePicker_end);
		this.Controls.Add(this.dateTimePicker_start);
		this.Controls.Add(this.pictureBox2);
		this.Controls.Add(this.pictureBox1);
		this.Controls.Add(this.btnOK);
		this.Controls.Add(this.ckB_mettingPwd);
		this.Controls.Add(this.txb_pwd);
		this.Controls.Add(this.txb_title);
		this.Controls.Add(this.label4);
		this.Controls.Add(this.label3);
		this.Controls.Add(this.label2);
		this.Controls.Add(this.label1);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.SizableToolWindow;
		this.Margin = new System.Windows.Forms.Padding(2);
		this.Name = "Create_Meeting1";
		this.ShowIcon = false;
		this.Text = "创建会议";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Create_Meeting1_Load);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox9)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.TextBox txb_title;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.TextBox txb_pwd;
	private System.Windows.Forms.CheckBox ckB_mettingPwd;
	private System.Windows.Forms.Button btnOK;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.Timer timer1;
	private System.Windows.Forms.Timer timer2;
	private System.Windows.Forms.Timer timer3;
	private System.Windows.Forms.DateTimePicker dateTimePicker_start;
	private System.Windows.Forms.DateTimePicker dateTimePicker_end;
	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.PictureBox pictureBox9;
	private System.Windows.Forms.PictureBox pictureBox6;
}