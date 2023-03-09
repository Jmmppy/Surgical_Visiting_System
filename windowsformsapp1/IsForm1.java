package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;
import java.util.*;
import java.time.*;

public class IsForm1 extends Form
{
	private ss_visitTable ss_visitTable_ = new ss_visitTable();
	private ss_visitTableBll ss_visitTableBll_ = new ss_visitTableBll();
	private String patient_name_;
	private String norcosis_name_;
	private LocalDateTime StartdateTime1 = LocalDateTime.MIN;
	private LocalDateTime EnddateTime2 = LocalDateTime.MIN;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 完成分页的前提
	/** 
	 每页记录数
	*/
	public int pageSize = 9;

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

	public IsForm1()
	{
		InitializeComponent();

	}

	private void panel1_Paint(Object sender, PaintEventArgs e)
	{

	}

	private void btnLogin_Click(Object sender, tangible.EventArgs e)
	{

		//NewMethod();
		patient_name_ = this.txtname1.Text.strip();
		norcosis_name_ = this.txtname2.Text.strip();
		StartdateTime1 = (LocalDateTime)this.dtp_time1.Value;
		EnddateTime2 = (LocalDateTime)this.dtp_time2.Value;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 绑定notice_table表数据 在这里可以证明，也拿到了isSelect字段（默认都是false）
		// 初始化绑定notice_table表数据
		this.dgvss_visit.AutoGenerateColumns = false; //控制DataGriView只显示需要的列
		// this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList(); //方法一
		ArrayList<cur_ss_visitTable> cur_ss_visitTable_ = ss_visitTableBll_.GetSs_visitTableList1();
		//列表的复制
		ArrayList<cur_ss_visitTable> cur2_ss_visitTable_ = new ArrayList<cur_ss_visitTable>();
		ArrayList<cur_ss_visitTable> cur2_ss_visitTable_22 = new ArrayList<cur_ss_visitTable>();
		cur2_ss_visitTable_22 = tangible.ListHelper.findAll(cur_ss_visitTable_, m -> m.is_bool1 == false && m.patient_name.Contains(patient_name_) && m.narcosis_doc_name.Contains(norcosis_name_) && (m.narcosis_time >= StartdateTime1 && m.narcosis_time <= EnddateTime2));
		if (cur2_ss_visitTable_22.toArray(new cur_ss_visitTable[0]).length == 0)
		{
			this.btnFirst.Enabled = false;
			this.btnPrev.Enabled = false;
			this.btnNext.Enabled = false;
			this.btnLast.Enabled = false;
			MessageBox.Show(String.format("0条数据"));
		}
		else
		{
			this.btnFirst.Enabled = true;
			this.btnPrev.Enabled = true;
			this.btnNext.Enabled = true;
			this.btnLast.Enabled = true;
			tangible.ListHelper.findAll(cur_ss_visitTable_, m -> m.is_bool1 == false && m.patient_name.Contains(patient_name_) && m.narcosis_doc_name.Contains(norcosis_name_) && (m.narcosis_time >= StartdateTime1 && m.narcosis_time <= EnddateTime2)).forEach(i -> cur2_ss_visitTable_.add(i)); //方法二
																																																													   //this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList1().FindAll
			mettingTable = List_To_table.ToDataTable(cur2_ss_visitTable_);
																				 //DataTable dataTable = this.dgvss_visit.DataSource;                                                                                                                                                                              //    (m => m.patient_name.Contains(patient_name_) && m.narcosis_doc_name.Contains(norcosis_name_));   //方法二
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
				///#endregion 绑定notice_table表数据

			recordCount = mettingTable.Rows.Count; //记录总行数
			if (recordCount == 0)
			{
				MessageBox.Show(String.format("当前查询到0条数据\n 请检查筛选条件"));
			}
			else
			{
				pageCount = (recordCount / pageSize);
				if ((recordCount % pageSize) > 0)
				{
					pageCount++;
				}

				//默认第一页
				currentPage = 1;
				LoadPage(); //调用加载数据的方法
						   //取巧
				labPageIndex.Text = "当前页: " + String.valueOf(currentPage) + " / " + String.valueOf(pageCount); //当前页
				labRecordCount.Text = "总行数: " + String.valueOf(recordCount) + " 行"; //总记录数
			}
		}

	}

	private void dgvss_visit_CellContentClick(Object sender, DataGridViewCellEventArgs e)
	{

	}

	private void IsForm1_Load(Object sender, tangible.EventArgs e)
	{
		NewMethod();

	}

	private void NewMethod()
	{
		String patient_name_ = this.txtname1.Text.strip();
		String norcosis_name_ = this.txtname2.Text.strip();
		LocalDateTime StartdateTime1 = (LocalDateTime)this.dtp_time1.Value;
		LocalDateTime EnddateTime2 = (LocalDateTime)this.dtp_time2.Value;
		//MessageBox.Show(string.Format("成功{0}", name));检测成功
		//MessageBox.Show(string.Format("成功{0}", StartdateTime1));
		//MessageBox.Show(string.Format("成功{0}", EnddateTime2));

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 绑定notice_table表数据
		// 初始化绑定notice_table表数据
		this.dgvss_visit.AutoGenerateColumns = false; //控制DataGriView只显示需要的列
		// this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList(); //方法一
		ArrayList<cur_ss_visitTable> cur_ss_visitTable_2 = ss_visitTableBll_.GetSs_visitTableList1();
		ArrayList<cur_ss_visitTable> cur_ss_visitTable_ = tangible.ListHelper.findAll(cur_ss_visitTable_2, m -> m.is_bool1 == false && m.is_bool3 == false);
		//this.dgvss_visit.DataSource = cur_ss_visitTable_.FindAll
		//    (m => m.patient_name.Contains(patient_name_) && m.narcosis_doc_name.Contains(norcosis_name_) && (m.narcosis_time >= StartdateTime1 && m.narcosis_time <= EnddateTime2));   //方法二
		//////////////this.dgvss_visit.DataSource = cur_ss_visitTable_;                                                                                                   //this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList1().FindAll
		//    (m => m.patient_name.Contains(patient_name_) && m.narcosis_doc_name.Contains(norcosis_name_));   //方法二

		mettingTable = List_To_table.ToDataTable(cur_ss_visitTable_); // 运用工具类把List对象转化为DataTable
		recordCount = mettingTable.Rows.Count; //记录总行数
		pageCount = (recordCount / pageSize);
		if ((recordCount % pageSize) > 0)
		{
			pageCount++;
		}

		//默认第一页
		currentPage = 1;
		LoadPage(); //调用加载数据的方法
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 绑定notice_table表数据
	}

	/** 
	 LoadPage方法
	*/
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

		this.dgvss_visit.Rows.Clear();

		for (int i = 0; i < dtTemp.Rows.Count; i++)
		{
			this.dgvss_visit.Rows.Add(new Object[] {dtTemp.Rows[i][0], dtTemp.Rows[i][1], dtTemp.Rows[i][2], dtTemp.Rows[i][3], dtTemp.Rows[i][4], dtTemp.Rows[i][5], dtTemp.Rows[i][6], dtTemp.Rows[i][7], dtTemp.Rows[i][8]});
		}

		labPageIndex.Text = "当前页: " + String.valueOf(currentPage) + " / " + String.valueOf(pageCount); //当前页
		labRecordCount.Text = "总行数: " + String.valueOf(recordCount) + " 行"; //总记录数
	}

	private void groupBox1_Enter(Object sender, tangible.EventArgs e)
	{


	}

	private void dtp_time1_ValueChanged(Object sender, tangible.EventArgs e)
	{

	}

	private void dgvss_visit_DoubleClick(Object sender, tangible.EventArgs e)
	{



		//var visit = this.dgvss_visit.CurrentRow.DataBoundItem as cur_ss_visitTable;
		//MessageBox.Show(string.Format("成功{0}", visit.illness_id));
		//Form_visit_specific Form_visit_specific_ = new Form_visit_specific(visit);
		//Form_visit_specific_.ShowDialog(); 



	}

	private void btnFirst_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == 1)
		{
			return;
		}
		currentPage = 1;
		LoadPage();
	}

	private void btnPrev_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == 1)
		{
			return;
		}
		currentPage--;
		LoadPage();
	}

	private void btnNext_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == pageCount)
		{
			return;
		}
		currentPage++;
		LoadPage();
	}

	private void btnLast_Click(Object sender, tangible.EventArgs e)
	{
		if (currentPage == pageCount)
		{
			return;
		}
		currentPage = pageCount;
		LoadPage();
	}

	private void dgvss_visit_CellClick(Object sender, DataGridViewCellEventArgs e)
	{

	}

	private void dgvss_visit_CellDoubleClick(Object sender, DataGridViewCellEventArgs e)
	{
		//MessageBox.Show("选中行" + (e.RowIndex + 1));
		//MessageBox.Show(dgvss_visit.Rows[e.RowIndex].Cells["illness_id"].Value.ToString());//获取选中行指定列的值

		//根据患者id转化为cur_ss_visitTable对象

		String illnessId_ = dgvss_visit.Rows[e.RowIndex].Cells["illness_id"].Value.toString();
		String patient_name_ = dgvss_visit.Rows[e.RowIndex].Cells["patient_name"].Value.toString();
		;
		LocalDateTime operation_date_ = (LocalDateTime)dgvss_visit.Rows[e.RowIndex].Cells["operation_date"].Value;
		String operation_room_ = dgvss_visit.Rows[e.RowIndex].Cells["operation_room"].Value.toString();

		LocalDateTime narcosis_time_ = (LocalDateTime)dgvss_visit.Rows[e.RowIndex].Cells["narcosis_time"].Value;
		String operation_name_ = dgvss_visit.Rows[e.RowIndex].Cells["operation_name"].Value.toString();

		String doc_name_ = dgvss_visit.Rows[e.RowIndex].Cells["doc_name"].Value.toString();
		String narcosis_doc_name_ = dgvss_visit.Rows[e.RowIndex].Cells["narcosis_doc_name"].Value.toString();
		String nurse_name_ = dgvss_visit.Rows[e.RowIndex].Cells["nurse_name"].Value.toString();

		cur_ss_visitTable visit = new cur_ss_visitTable();
		visit.setillness_id(illnessId_);
		visit.setpatient_name(patient_name_);
		visit.setoperation_date(operation_date_);
		visit.setoperation_room(operation_room_);
		visit.setnarcosis_time(narcosis_time_);
		visit.setoperation_name(operation_name_);
		visit.setdoc_name(doc_name_);
		visit.setnarcosis_doc_name(narcosis_doc_name_);
		visit.setnurse_name(nurse_name_);
		Form_visit_specific Form_visit_specific_ = new Form_visit_specific(visit);
		Form_visit_specific_.ShowDialog();
		NewMethod();
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(IsForm1.class);
		this.dgvss_visit = new System.Windows.Forms.DataGridView();
		this.groupBox1 = new System.Windows.Forms.GroupBox();
		this.dtp_time1 = new System.Windows.Forms.DateTimePicker();
		this.dtp_time2 = new System.Windows.Forms.DateTimePicker();
		this.btnLogin = new System.Windows.Forms.Button();
		this.txtname2 = new System.Windows.Forms.TextBox();
		this.txtname1 = new System.Windows.Forms.TextBox();
		this.label3 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.label4 = new System.Windows.Forms.Label();
		this.label1 = new System.Windows.Forms.Label();
		this.panel5 = new System.Windows.Forms.Panel();
		this.pictureBox12 = new System.Windows.Forms.PictureBox();
		this.btnLast = new System.Windows.Forms.Button();
		this.btnNext = new System.Windows.Forms.Button();
		this.btnPrev = new System.Windows.Forms.Button();
		this.btnFirst = new System.Windows.Forms.Button();
		this.labPageIndex = new System.Windows.Forms.Label();
		this.labRecordCount = new System.Windows.Forms.Label();
		this.illness_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.patient_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.operation_date = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.operation_room = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.narcosis_time = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.operation_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.doc_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.narcosis_doc_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.nurse_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).BeginInit();
		this.groupBox1.SuspendLayout();
		this.panel5.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).BeginInit();
		this.SuspendLayout();
		// 
		// dgvss_visit
		// 
		this.dgvss_visit.AllowUserToAddRows = false;
		this.dgvss_visit.AllowUserToDeleteRows = false;
		this.dgvss_visit.BackgroundColor = System.Drawing.SystemColors.Window;
		this.dgvss_visit.BorderStyle = System.Windows.Forms.BorderStyle.None;
		this.dgvss_visit.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
		this.dgvss_visit.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {this.illness_id, this.patient_name, this.operation_date, this.operation_room, this.narcosis_time, this.operation_name, this.doc_name, this.narcosis_doc_name, this.nurse_name});
		this.dgvss_visit.GridColor = System.Drawing.SystemColors.Control;
		this.dgvss_visit.Location = new System.Drawing.Point(-2, 60);
		this.dgvss_visit.MultiSelect = false;
		this.dgvss_visit.Name = "dgvss_visit";
		this.dgvss_visit.ReadOnly = true;
		this.dgvss_visit.RowHeadersBorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.None;
		this.dgvss_visit.RowHeadersVisible = false;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.dgvss_visit.RowTemplate.DefaultCellStyle.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.dgvss_visit.RowTemplate.DefaultCellStyle.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.dgvss_visit.RowTemplate.DefaultCellStyle.SelectionBackColor = System.Drawing.Color.Silver;
		this.dgvss_visit.RowTemplate.DefaultCellStyle.SelectionForeColor = System.Drawing.Color.White;
		this.dgvss_visit.RowTemplate.Height = 23;
		this.dgvss_visit.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
		this.dgvss_visit.Size = new System.Drawing.Size(843, 449);
		this.dgvss_visit.TabIndex = 1;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvss_visit_CellClick);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvss_visit_CellContentClick);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvss_visit_CellDoubleClick);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.DoubleClick += new System.EventHandler(this.dgvss_visit_DoubleClick);
		// 
		// groupBox1
		// 
		this.groupBox1.Controls.Add(this.dtp_time1);
		this.groupBox1.Controls.Add(this.dtp_time2);
		this.groupBox1.Controls.Add(this.btnLogin);
		this.groupBox1.Controls.Add(this.txtname2);
		this.groupBox1.Controls.Add(this.txtname1);
		this.groupBox1.Controls.Add(this.label3);
		this.groupBox1.Controls.Add(this.label2);
		this.groupBox1.Controls.Add(this.label4);
		this.groupBox1.Controls.Add(this.label1);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Location = new System.Drawing.Point(-2, 2);
		this.groupBox1.Name = "groupBox1";
		this.groupBox1.Size = new System.Drawing.Size(843, 61);
		this.groupBox1.TabIndex = 2;
		this.groupBox1.TabStop = false;
		this.groupBox1.Text = "筛选";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
		// 
		// dtp_time1
		// 
		this.dtp_time1.CustomFormat = "yyyy-MM-dd HH:mm:ss";
		this.dtp_time1.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
		this.dtp_time1.Location = new System.Drawing.Point(212, 24);
		this.dtp_time1.Name = "dtp_time1";
		this.dtp_time1.Size = new System.Drawing.Size(156, 23);
		this.dtp_time1.TabIndex = 12;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dtp_time1.ValueChanged += new System.EventHandler(this.dtp_time1_ValueChanged);
		// 
		// dtp_time2
		// 
		this.dtp_time2.CustomFormat = "yyyy-MM-dd HH:mm:ss";
		this.dtp_time2.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
		this.dtp_time2.Location = new System.Drawing.Point(387, 24);
		this.dtp_time2.Name = "dtp_time2";
		this.dtp_time2.Size = new System.Drawing.Size(159, 23);
		this.dtp_time2.TabIndex = 12;
		// 
		// btnLogin
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.btnLogin.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderSize = 0;
		this.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.ForeColor = System.Drawing.SystemColors.Window;
		this.btnLogin.Location = new System.Drawing.Point(708, 20);
		this.btnLogin.Name = "btnLogin";
		this.btnLogin.Size = new System.Drawing.Size(94, 29);
		this.btnLogin.TabIndex = 11;
		this.btnLogin.Text = "查  找";
		this.btnLogin.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
		// 
		// txtname2
		// 
		this.txtname2.Location = new System.Drawing.Point(608, 23);
		this.txtname2.Name = "txtname2";
		this.txtname2.Size = new System.Drawing.Size(73, 23);
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
		this.label3.Location = new System.Drawing.Point(552, 26);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(56, 17);
		this.label3.TabIndex = 0;
		this.label3.Text = "麻醉医师";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
		this.label2.Location = new System.Drawing.Point(159, 27);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(56, 17);
		this.label2.TabIndex = 0;
		this.label2.Text = "访视时间";
		// 
		// label4
		// 
		this.label4.AutoSize = true;
		this.label4.Location = new System.Drawing.Point(370, 27);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(17, 17);
		this.label4.TabIndex = 0;
		this.label4.Text = "~";
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
		// panel5
		// 
		this.panel5.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.panel5.Controls.Add(this.pictureBox12);
		this.panel5.Controls.Add(this.btnLast);
		this.panel5.Controls.Add(this.btnNext);
		this.panel5.Controls.Add(this.btnPrev);
		this.panel5.Controls.Add(this.btnFirst);
		this.panel5.Controls.Add(this.labPageIndex);
		this.panel5.Controls.Add(this.labRecordCount);
		this.panel5.Location = new System.Drawing.Point(-2, 510);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(843, 43);
		this.panel5.TabIndex = 5;
		// 
		// pictureBox12
		// 
		this.pictureBox12.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox12.BackgroundImage")));
		this.pictureBox12.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox12.Location = new System.Drawing.Point(0, -2);
		this.pictureBox12.Name = "pictureBox12";
		this.pictureBox12.Size = new System.Drawing.Size(12, 32);
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
		this.btnLast.Location = new System.Drawing.Point(706, 4);
		this.btnLast.Name = "btnLast";
		this.btnLast.Size = new System.Drawing.Size(53, 24);
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
		this.btnNext.Location = new System.Drawing.Point(584, 4);
		this.btnNext.Name = "btnNext";
		this.btnNext.Size = new System.Drawing.Size(69, 24);
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
		this.btnPrev.Location = new System.Drawing.Point(443, 4);
		this.btnPrev.Name = "btnPrev";
		this.btnPrev.Size = new System.Drawing.Size(70, 24);
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
		this.btnFirst.Location = new System.Drawing.Point(343, 4);
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
		this.labPageIndex.Location = new System.Drawing.Point(186, 8);
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
		this.labRecordCount.Location = new System.Drawing.Point(51, 8);
		this.labRecordCount.Name = "labRecordCount";
		this.labRecordCount.Size = new System.Drawing.Size(36, 17);
		this.labRecordCount.TabIndex = 2;
		this.labRecordCount.Text = "统 计";
		// 
		// illness_id
		// 
		this.illness_id.DataPropertyName = "illness_id";
		this.illness_id.HeaderText = "患者id";
		this.illness_id.Name = "illness_id";
		this.illness_id.ReadOnly = true;
		this.illness_id.Width = 65;
		// 
		// patient_name
		// 
		this.patient_name.DataPropertyName = "patient_name";
		this.patient_name.HeaderText = "患者名";
		this.patient_name.Name = "patient_name";
		this.patient_name.ReadOnly = true;
		this.patient_name.Width = 90;
		// 
		// operation_date
		// 
		this.operation_date.DataPropertyName = "operation_date";
		this.operation_date.HeaderText = "手术日期";
		this.operation_date.Name = "operation_date";
		this.operation_date.ReadOnly = true;
		this.operation_date.Width = 110;
		// 
		// operation_room
		// 
		this.operation_room.DataPropertyName = "operation_room";
		this.operation_room.HeaderText = "手术室";
		this.operation_room.Name = "operation_room";
		this.operation_room.ReadOnly = true;
		this.operation_room.Width = 35;
		// 
		// narcosis_time
		// 
		this.narcosis_time.DataPropertyName = "narcosis_time";
		this.narcosis_time.HeaderText = "访视时间";
		this.narcosis_time.Name = "narcosis_time";
		this.narcosis_time.ReadOnly = true;
		this.narcosis_time.Width = 110;
		// 
		// operation_name
		// 
		this.operation_name.DataPropertyName = "operation_name";
		this.operation_name.HeaderText = "手术名称";
		this.operation_name.Name = "operation_name";
		this.operation_name.ReadOnly = true;
		this.operation_name.Width = 145;
		// 
		// doc_name
		// 
		this.doc_name.DataPropertyName = "doc_name";
		this.doc_name.HeaderText = "手术医师";
		this.doc_name.Name = "doc_name";
		this.doc_name.ReadOnly = true;
		this.doc_name.Width = 95;
		// 
		// narcosis_doc_name
		// 
		this.narcosis_doc_name.DataPropertyName = "narcosis_doc_name";
		this.narcosis_doc_name.HeaderText = "麻醉医师";
		this.narcosis_doc_name.Name = "narcosis_doc_name";
		this.narcosis_doc_name.ReadOnly = true;
		this.narcosis_doc_name.Width = 95;
		// 
		// nurse_name
		// 
		this.nurse_name.DataPropertyName = "nurse_name";
		this.nurse_name.HeaderText = "护理医师";
		this.nurse_name.Name = "nurse_name";
		this.nurse_name.ReadOnly = true;
		this.nurse_name.Width = 95;
		// 
		// IsForm1
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(846, 555);
		this.Controls.Add(this.panel5);
		this.Controls.Add(this.groupBox1);
		this.Controls.Add(this.dgvss_visit);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.Name = "IsForm1";
		this.Text = "IsForm1";
		this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.IsForm1_Load);
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).EndInit();
		this.groupBox1.ResumeLayout(false);
		this.groupBox1.PerformLayout();
		this.panel5.ResumeLayout(false);
		this.panel5.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
	private System.Windows.Forms.DataGridView dgvss_visit;
	private System.Windows.Forms.GroupBox groupBox1;
	private System.Windows.Forms.TextBox txtname2;
	private System.Windows.Forms.TextBox txtname1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.Button btnLogin;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.DateTimePicker dtp_time2;
	private System.Windows.Forms.DateTimePicker dtp_time1;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.PictureBox pictureBox12;
	private System.Windows.Forms.Button btnLast;
	private System.Windows.Forms.Button btnNext;
	private System.Windows.Forms.Button btnPrev;
	private System.Windows.Forms.Button btnFirst;
	private System.Windows.Forms.Label labPageIndex;
	private System.Windows.Forms.Label labRecordCount;
	private System.Windows.Forms.DataGridViewTextBoxColumn illness_id;
	private System.Windows.Forms.DataGridViewTextBoxColumn patient_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn operation_date;
	private System.Windows.Forms.DataGridViewTextBoxColumn operation_room;
	private System.Windows.Forms.DataGridViewTextBoxColumn narcosis_time;
	private System.Windows.Forms.DataGridViewTextBoxColumn operation_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn doc_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn narcosis_doc_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn nurse_name;
}