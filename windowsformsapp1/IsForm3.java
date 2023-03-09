package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;
import java.util.*;
import java.time.*;

public class IsForm3 extends Form
{
	private meeting_tableBll meeting_tableBll_ = new meeting_tableBll();
	private LocalDateTime Cur_time = LocalDateTime.MIN;
	private LocalDateTime Cur_time2 = LocalDateTime.MIN;
	private boolean cheak_time = false;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 完成分页的前提
	/** 
	 每页记录数
	*/
	public int pageSize = 8;

	/** 
	 总记录数
	*/
	public int recordCount = 0;

	/** 
	 总页数
	*/
	public int pageCount = 0;

	/** 
	 当前页
	*/
	public int currentPage = 0;
	private DataTable mettingTable;
	private List_To_table List_To_table_ = new List_To_table();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
	public IsForm3()
	{
		InitializeComponent();
		Metting_Date_Show();
		cheak_time = true;
	}

	private void IsForm3_Load(Object sender, tangible.EventArgs e)
	{

	}
	private void Metting_Date_Show()
	{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 绑定 meeting_table表数据
		this.dgv_metting.AutoGenerateColumns = false;
		ArrayList<meeting_table> cur_smeeting_table_ = meeting_tableBll_.GetMeeting_tableList1();
		//列表的复制
		ArrayList<meeting_table> cur2_meeting_table_ = new ArrayList<meeting_table>();
		tangible.ListHelper.findAll(cur_smeeting_table_, m -> m.ismetting == false && m.Belong_doc == Program.cur_LoginId).forEach(i -> cur2_meeting_table_.add(i));
		////this.dgv_metting.DataSource = meeting_tableBll_.GetMeeting_tableList1();
		if (cur2_meeting_table_.toArray(new meeting_table[0]).length != 0)
		{ //如果登录对象所对应的他创建的会议记录bu 不空时
			this.btnFirst.Enabled = true;
			this.btnPrev.Enabled = true;
			this.btnNext.Enabled = true;
			this.btnLast.Enabled = true;
			mettingTable = List_To_table.ToDataTable(cur2_meeting_table_); // 运用工具类把List对象转化为DataTable
			recordCount = mettingTable.Rows.Count; //记录总行数
			pageCount = (recordCount / pageSize);
			if ((recordCount % pageSize) > 0)
			{
				pageCount++;
			}

			//默认第一页
			currentPage = 1;
			LoadPage(); //调用加载数据的方法

		}
		else
		{ //如果登录对象所对应的他创建的会议记录为空时
			this.btnFirst.Enabled = false;
			this.btnPrev.Enabled = false;
			this.btnNext.Enabled = false;
			this.btnLast.Enabled = false;
		}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 绑定 meeting_table表数据
	}
	private void LoadPage()
	{
		if (currentPage < 1)
		{
			currentPage = 1;
		}
		if (currentPage > pageCount)
		{
			currentPage = pageCount;
		}

		int beginRecord; //开始指针
		int endRecord; //结束指针
		DataTable dtTemp;
		dtTemp = mettingTable.Clone();

		beginRecord = pageSize * (currentPage - 1);
		if (currentPage == 1)
		{
			beginRecord = 0;
		}
		endRecord = pageSize * currentPage;

		if (currentPage == pageCount)
		{
			endRecord = recordCount;
		}
		for (int i = beginRecord; i < endRecord; i++)
		{
			dtTemp.ImportRow(mettingTable.Rows[i]);
		}

		dgv_metting.Rows.Clear();

		for (int i = 0; i < dtTemp.Rows.Count; i++)
		{
			dgv_metting.Rows.Add(new Object[] {dtTemp.Rows[i][0], dtTemp.Rows[i][1], dtTemp.Rows[i][2], dtTemp.Rows[i][3], dtTemp.Rows[i][4]});
		}

		labPageIndex.Text = "当前页: " + String.valueOf(currentPage) + " / " + String.valueOf(pageCount); //当前页
		labRecordCount.Text = "总行数: " + String.valueOf(recordCount) + " 行"; //总记录数
	}

	/** 
	 每隔几秒钟去查一下会议表，看是否有小于或等于5分钟的，if有则提示。
	 
	 @param sender
	 @param e
	*/
	private void metting_timer_Tick(Object sender, tangible.EventArgs e)
	{
		//MessageBox.Show(string.Format("成功"));
		Metting_Date_Show();
		meeting_table meeting_Table;
		if (cheak_time)
		{
			Cur_time = LocalDateTime.parse(LocalDateTime.now().ToLongTimeString());
			Cur_time2 = Cur_time.plusMinutes(5);
			meeting_Table = meeting_tableBll_.getmeeting_tableObject2(Cur_time, Cur_time2);
			if (meeting_Table.meeting_id != 0)
			{ //查到了提示
				this.metting_timer.Enabled = false;
				Form_mettingUp Form_mettingUp_ = new Form_mettingUp(meeting_Table);
				//Form_mettingUp_.ShowDialog();    多余！！！！！！

				if (Form_mettingUp_.ShowDialog() == System.Windows.Forms.DialogResult.OK)
				{ //加入了会议
				 //不是删除刚那一条记录而是增加是否有加入的bool变量。
					int row = meeting_tableBll_.update_isMeeting(meeting_Table.meeting_id, true);
					// 更新
					//timer打开
					Metting_Date_Show();
					this.metting_timer.Enabled = true;

				}
				this.metting_timer.Enabled = true;
				Metting_Date_Show();

			}
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 分页控件
	// 首页
	private void btnFirst_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == 1)
		{
			return;
		}
		currentPage = 1;
		LoadPage();
	}
	// 上一页
	private void btnPrev_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == 1)
		{
			return;
		}
		currentPage--;
		LoadPage();
	}
	// 下一页
	private void btnNext_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == pageCount)
		{
			return;
		}
		currentPage++;
		LoadPage();
	}
	// 尾页
	private void btnLast_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == pageCount)
		{
			return;
		}
		currentPage = pageCount;
		LoadPage();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 分页控件

	private void pictureBox6_Click(Object sender, tangible.EventArgs e)
	{
		String strPath = "F:\\毕业设计所用测试文件夹\\访视所用表";
		System.Diagnostics.Process.Start("explorer.exe", strPath);
	}

	private void pictureBox1_Click(Object sender, tangible.EventArgs e)
	{
		String strPath = "F:\\毕业设计所用测试文件夹\\访视所用视频";
		System.Diagnostics.Process.Start("explorer.exe", strPath);
	}

	private void pictureBox2_Click(Object sender, tangible.EventArgs e)
	{
		String strPath = "F:\\毕业设计所用测试文件夹\\访视所用文件夹";
		System.Diagnostics.Process.Start("explorer.exe", strPath);
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(IsForm3.class);
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle6 = new System.Windows.Forms.DataGridViewCellStyle();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle4 = new System.Windows.Forms.DataGridViewCellStyle();
		System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle5 = new System.Windows.Forms.DataGridViewCellStyle();
		this.panel1 = new System.Windows.Forms.Panel();
		this.panel3 = new System.Windows.Forms.Panel();
		this.panel5 = new System.Windows.Forms.Panel();
		this.pictureBox12 = new System.Windows.Forms.PictureBox();
		this.btnLast = new System.Windows.Forms.Button();
		this.btnNext = new System.Windows.Forms.Button();
		this.btnPrev = new System.Windows.Forms.Button();
		this.btnFirst = new System.Windows.Forms.Button();
		this.labPageIndex = new System.Windows.Forms.Label();
		this.labRecordCount = new System.Windows.Forms.Label();
		this.dgv_metting = new System.Windows.Forms.DataGridView();
		this.meeting_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.meeting_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.start_time = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.end_time = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.illness_id_count = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.label14 = new System.Windows.Forms.Label();
		this.pictureBox3 = new System.Windows.Forms.PictureBox();
		this.panel2 = new System.Windows.Forms.Panel();
		this.label3 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.pictureBox4 = new System.Windows.Forms.PictureBox();
		this.label11 = new System.Windows.Forms.Label();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		this.label1 = new System.Windows.Forms.Label();
		this.metting_timer = new System.Windows.Forms.Timer(this.components);
		this.panel1.SuspendLayout();
		this.panel3.SuspendLayout();
		this.panel5.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.dgv_metting)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
		this.panel2.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		this.SuspendLayout();
		// 
		// panel1
		// 
		this.panel1.Controls.Add(this.panel3);
		this.panel1.Controls.Add(this.label14);
		this.panel1.Controls.Add(this.pictureBox3);
		this.panel1.Location = new System.Drawing.Point(8, 1);
		this.panel1.Margin = new System.Windows.Forms.Padding(2);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(827, 338);
		this.panel1.TabIndex = 0;
		// 
		// panel3
		// 
		this.panel3.BackColor = System.Drawing.SystemColors.Control;
		this.panel3.Controls.Add(this.panel5);
		this.panel3.Controls.Add(this.dgv_metting);
		this.panel3.Location = new System.Drawing.Point(11, 48);
		this.panel3.Name = "panel3";
		this.panel3.Size = new System.Drawing.Size(815, 289);
		this.panel3.TabIndex = 8;
		// 
		// panel5
		// 
		this.panel5.BackColor = System.Drawing.SystemColors.ButtonFace;
		this.panel5.Controls.Add(this.pictureBox12);
		this.panel5.Controls.Add(this.btnLast);
		this.panel5.Controls.Add(this.btnNext);
		this.panel5.Controls.Add(this.btnPrev);
		this.panel5.Controls.Add(this.btnFirst);
		this.panel5.Controls.Add(this.labPageIndex);
		this.panel5.Controls.Add(this.labRecordCount);
		this.panel5.Location = new System.Drawing.Point(3, 257);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(809, 30);
		this.panel5.TabIndex = 5;
		// 
		// pictureBox12
		// 
		this.pictureBox12.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox12.BackgroundImage")));
		this.pictureBox12.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox12.Location = new System.Drawing.Point(0, -2);
		this.pictureBox12.Name = "pictureBox12";
		this.pictureBox12.Size = new System.Drawing.Size(10, 32);
		this.pictureBox12.TabIndex = 5;
		this.pictureBox12.TabStop = false;
		// 
		// btnLast
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLast.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnLast.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLast.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLast.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLast.FlatAppearance.BorderSize = 0;
		this.btnLast.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLast.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLast.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLast.ForeColor = System.Drawing.SystemColors.Window;
		this.btnLast.Location = new System.Drawing.Point(569, 3);
		this.btnLast.Name = "btnLast";
		this.btnLast.Size = new System.Drawing.Size(44, 24);
		this.btnLast.TabIndex = 15;
		this.btnLast.Text = "尾页";
		this.btnLast.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnLast.Click += new System.EventHandler(this.btnLast_Click);
		// 
		// btnNext
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnNext.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnNext.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnNext.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnNext.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnNext.FlatAppearance.BorderSize = 0;
		this.btnNext.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnNext.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnNext.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnNext.ForeColor = System.Drawing.SystemColors.Window;
		this.btnNext.Location = new System.Drawing.Point(466, 3);
		this.btnNext.Name = "btnNext";
		this.btnNext.Size = new System.Drawing.Size(53, 24);
		this.btnNext.TabIndex = 15;
		this.btnNext.Text = "下一页";
		this.btnNext.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnNext.Click += new System.EventHandler(this.btnNext_Click);
		// 
		// btnPrev
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnPrev.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnPrev.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnPrev.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnPrev.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnPrev.FlatAppearance.BorderSize = 0;
		this.btnPrev.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnPrev.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnPrev.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnPrev.ForeColor = System.Drawing.SystemColors.Window;
		this.btnPrev.Location = new System.Drawing.Point(395, 3);
		this.btnPrev.Name = "btnPrev";
		this.btnPrev.Size = new System.Drawing.Size(53, 24);
		this.btnPrev.TabIndex = 15;
		this.btnPrev.Text = "上一页";
		this.btnPrev.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnPrev.Click += new System.EventHandler(this.btnPrev_Click);
		// 
		// btnFirst
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnFirst.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnFirst.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnFirst.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnFirst.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnFirst.FlatAppearance.BorderSize = 0;
		this.btnFirst.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnFirst.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnFirst.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnFirst.ForeColor = System.Drawing.SystemColors.Window;
		this.btnFirst.Location = new System.Drawing.Point(303, 3);
		this.btnFirst.Name = "btnFirst";
		this.btnFirst.Size = new System.Drawing.Size(44, 24);
		this.btnFirst.TabIndex = 15;
		this.btnFirst.Text = "首页";
		this.btnFirst.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnFirst.Click += new System.EventHandler(this.btnFirst_Click);
		// 
		// labPageIndex
		// 
		this.labPageIndex.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labPageIndex.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labPageIndex.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labPageIndex.Location = new System.Drawing.Point(116, 7);
		this.labPageIndex.Name = "labPageIndex";
		this.labPageIndex.Size = new System.Drawing.Size(42, 17);
		this.labPageIndex.TabIndex = 2;
		this.labPageIndex.Text = "统/ 计";
		// 
		// labRecordCount
		// 
		this.labRecordCount.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labRecordCount.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labRecordCount.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labRecordCount.Location = new System.Drawing.Point(33, 7);
		this.labRecordCount.Name = "labRecordCount";
		this.labRecordCount.Size = new System.Drawing.Size(36, 17);
		this.labRecordCount.TabIndex = 2;
		this.labRecordCount.Text = "统 计";
		// 
		// dgv_metting
		// 
		this.dgv_metting.AllowUserToAddRows = false;
		this.dgv_metting.AllowUserToDeleteRows = false;
		this.dgv_metting.BackgroundColor = System.Drawing.SystemColors.Window;
		this.dgv_metting.BorderStyle = System.Windows.Forms.BorderStyle.None;
		this.dgv_metting.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
		this.dgv_metting.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {this.meeting_id, this.meeting_name, this.start_time, this.end_time, this.illness_id_count});
		dataGridViewCellStyle6.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
		dataGridViewCellStyle6.BackColor = System.Drawing.SystemColors.Window;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle6.Font = new System.Drawing.Font("微软雅黑", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle6.Font = new System.Drawing.Font("微软雅黑", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle6.ForeColor = System.Drawing.SystemColors.ControlText;
		dataGridViewCellStyle6.SelectionBackColor = System.Drawing.SystemColors.Highlight;
		dataGridViewCellStyle6.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
		dataGridViewCellStyle6.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
		this.dgv_metting.DefaultCellStyle = dataGridViewCellStyle6;
		this.dgv_metting.GridColor = System.Drawing.SystemColors.Control;
		this.dgv_metting.Location = new System.Drawing.Point(9, 3);
		this.dgv_metting.MultiSelect = false;
		this.dgv_metting.Name = "dgv_metting";
		this.dgv_metting.ReadOnly = true;
		this.dgv_metting.RowHeadersBorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.None;
		this.dgv_metting.RowHeadersVisible = false;
		this.dgv_metting.RowHeadersWidth = 62;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.dgv_metting.RowTemplate.DefaultCellStyle.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.dgv_metting.RowTemplate.DefaultCellStyle.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.dgv_metting.RowTemplate.DefaultCellStyle.SelectionBackColor = System.Drawing.Color.Silver;
		this.dgv_metting.RowTemplate.DefaultCellStyle.SelectionForeColor = System.Drawing.Color.White;
		this.dgv_metting.RowTemplate.Height = 23;
		this.dgv_metting.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
		this.dgv_metting.Size = new System.Drawing.Size(796, 255);
		this.dgv_metting.TabIndex = 6;
		// 
		// meeting_id
		// 
		this.meeting_id.DataPropertyName = "meeting_id";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle1.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle1.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.meeting_id.DefaultCellStyle = dataGridViewCellStyle1;
		this.meeting_id.HeaderText = "会议号";
		this.meeting_id.MinimumWidth = 110;
		this.meeting_id.Name = "meeting_id";
		this.meeting_id.ReadOnly = true;
		this.meeting_id.Width = 110;
		// 
		// meeting_name
		// 
		this.meeting_name.DataPropertyName = "meeting_name";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle2.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle2.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.meeting_name.DefaultCellStyle = dataGridViewCellStyle2;
		this.meeting_name.HeaderText = "主题";
		this.meeting_name.MinimumWidth = 250;
		this.meeting_name.Name = "meeting_name";
		this.meeting_name.ReadOnly = true;
		this.meeting_name.Width = 250;
		// 
		// start_time
		// 
		this.start_time.DataPropertyName = "start_time";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle3.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle3.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.start_time.DefaultCellStyle = dataGridViewCellStyle3;
		this.start_time.HeaderText = "开始时间";
		this.start_time.MinimumWidth = 160;
		this.start_time.Name = "start_time";
		this.start_time.ReadOnly = true;
		this.start_time.Width = 160;
		// 
		// end_time
		// 
		this.end_time.DataPropertyName = "end_time";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle4.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle4.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.end_time.DefaultCellStyle = dataGridViewCellStyle4;
		this.end_time.HeaderText = "结束时间";
		this.end_time.MinimumWidth = 160;
		this.end_time.Name = "end_time";
		this.end_time.ReadOnly = true;
		this.end_time.Width = 160;
		// 
		// illness_id_count
		// 
		this.illness_id_count.DataPropertyName = "illness_id_count";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: dataGridViewCellStyle5.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		dataGridViewCellStyle5.Font = new System.Drawing.Font("微软雅黑", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.illness_id_count.DefaultCellStyle = dataGridViewCellStyle5;
		this.illness_id_count.HeaderText = "患者数";
		this.illness_id_count.MinimumWidth = 110;
		this.illness_id_count.Name = "illness_id_count";
		this.illness_id_count.ReadOnly = true;
		this.illness_id_count.Width = 110;
		// 
		// label14
		// 
		this.label14.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label14.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Location = new System.Drawing.Point(39, 18);
		this.label14.Name = "label14";
		this.label14.Size = new System.Drawing.Size(194, 22);
		this.label14.TabIndex = 7;
		this.label14.Text = "您 预 约 的 这 一 天 会 议";
		// 
		// pictureBox3
		// 
		this.pictureBox3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox3.BackgroundImage")));
		this.pictureBox3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox3.Location = new System.Drawing.Point(13, 14);
		this.pictureBox3.Name = "pictureBox3";
		this.pictureBox3.Size = new System.Drawing.Size(11, 26);
		this.pictureBox3.TabIndex = 9;
		this.pictureBox3.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox3.Click += new System.EventHandler(this.pictureBox6_Click);
		// 
		// panel2
		// 
		this.panel2.Controls.Add(this.label3);
		this.panel2.Controls.Add(this.label2);
		this.panel2.Controls.Add(this.pictureBox4);
		this.panel2.Controls.Add(this.label11);
		this.panel2.Controls.Add(this.pictureBox2);
		this.panel2.Controls.Add(this.pictureBox1);
		this.panel2.Controls.Add(this.pictureBox6);
		this.panel2.Controls.Add(this.label1);
		this.panel2.Location = new System.Drawing.Point(9, 343);
		this.panel2.Margin = new System.Windows.Forms.Padding(2);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(829, 197);
		this.panel2.TabIndex = 1;
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Location = new System.Drawing.Point(391, 148);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(122, 21);
		this.label3.TabIndex = 10;
		this.label3.Text = "访视所用文件夹";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Location = new System.Drawing.Point(247, 148);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(106, 21);
		this.label2.TabIndex = 10;
		this.label2.Text = "访视所用视频";
		// 
		// pictureBox4
		// 
		this.pictureBox4.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox4.BackgroundImage")));
		this.pictureBox4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox4.Location = new System.Drawing.Point(13, 17);
		this.pictureBox4.Name = "pictureBox4";
		this.pictureBox4.Size = new System.Drawing.Size(11, 26);
		this.pictureBox4.TabIndex = 9;
		this.pictureBox4.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox4.Click += new System.EventHandler(this.pictureBox6_Click);
		// 
		// label11
		// 
		this.label11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label11.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Location = new System.Drawing.Point(98, 148);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(90, 21);
		this.label11.TabIndex = 10;
		this.label11.Text = "访视所用表";
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox2.Location = new System.Drawing.Point(408, 62);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(81, 73);
		this.pictureBox2.TabIndex = 9;
		this.pictureBox2.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click);
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(257, 62);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(81, 73);
		this.pictureBox1.TabIndex = 9;
		this.pictureBox1.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(100, 62);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(81, 73);
		this.pictureBox6.TabIndex = 9;
		this.pictureBox6.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox6.Click += new System.EventHandler(this.pictureBox6_Click);
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Location = new System.Drawing.Point(37, 19);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(90, 22);
		this.label1.TabIndex = 8;
		this.label1.Text = "访视库操作";
		// 
		// metting_timer
		// 
		this.metting_timer.Enabled = true;
		this.metting_timer.Interval = 2000;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.metting_timer.Tick += new System.EventHandler(this.metting_timer_Tick);
		// 
		// IsForm3
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.ClientSize = new System.Drawing.Size(846, 555);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel1);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.Name = "IsForm3";
		this.Text = "IsForm3";
		this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.IsForm3_Load);
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		this.panel3.ResumeLayout(false);
		this.panel5.ResumeLayout(false);
		this.panel5.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.dgv_metting)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
		this.panel2.ResumeLayout(false);
		this.panel2.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.PictureBox pictureBox12;
	private System.Windows.Forms.Button btnLast;
	private System.Windows.Forms.Button btnNext;
	private System.Windows.Forms.Button btnPrev;
	private System.Windows.Forms.Button btnFirst;
	private System.Windows.Forms.Label labPageIndex;
	private System.Windows.Forms.Label labRecordCount;
	private System.Windows.Forms.DataGridView dgv_metting;
	private System.Windows.Forms.DataGridViewTextBoxColumn meeting_id;
	private System.Windows.Forms.DataGridViewTextBoxColumn meeting_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn start_time;
	private System.Windows.Forms.DataGridViewTextBoxColumn end_time;
	private System.Windows.Forms.DataGridViewTextBoxColumn illness_id_count;
	private System.Windows.Forms.Label label14;
	private System.Windows.Forms.Timer metting_timer;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.PictureBox pictureBox6;
	private System.Windows.Forms.Panel panel3;
	private System.Windows.Forms.PictureBox pictureBox3;
	private System.Windows.Forms.PictureBox pictureBox4;
}