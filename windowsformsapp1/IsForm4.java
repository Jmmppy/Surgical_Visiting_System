package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;
import java.util.*;
import java.time.*;

public class IsForm4 extends Form
{
	private ss_visitTable ss_visitTable_ = new ss_visitTable();
	private ss_visitTableBll ss_visitTableBll_ = new ss_visitTableBll();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 完成分页的前提
	/** 
	 每页记录数
	*/
	public int pageSize = 12;

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
	public IsForm4()
	{
		InitializeComponent();
	}

	private void IsForm4_Load(Object sender, tangible.EventArgs e)
	{
		start_dgv();

	}

	private void start_dgv()
	{
		String patient_name_ = this.txtname1.Text.strip();
		String peration_name_ = this.txtname2.Text.strip();
		boolean Is_select = this.chk_input.Checked;


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 绑定n表数据
		// 初始化绑定notice_table表数据
		this.dgvss_visit.AutoGenerateColumns = false; //控制DataGriView只显示需要的列
		// this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList(); //方法一
		ArrayList<cur_ss_visitTable> cur_ss_visitTable_ = ss_visitTableBll_.GetSs_visitTableList1();
		ArrayList<cur_ss_visitTable> cur2_ss_visitTable_ = new ArrayList<cur_ss_visitTable>();
		tangible.ListHelper.findAll(cur_ss_visitTable_, m -> m.is_bool1 == true && m.patient_name.Contains(patient_name_) && m.operation_name.Contains(peration_name_) && m.isSelect == Is_select).forEach(i -> cur2_ss_visitTable_.add(i)); //方法二
																																												//this.dgvss_visit.DataSource = cur_ss_visitTable_;                                                                                                   //this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList1().FindAll
																																												//    (m => m.patient_name.Contains(patient_name_) && m.narcosis_doc_name.Contains(norcosis_name_));   //方法二


		mettingTable = List_To_table.ToDataTable(cur2_ss_visitTable_);
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
			this.dgvss_visit.Rows.Add(new Object[] {dtTemp.Rows[i][1], dtTemp.Rows[i][2], dtTemp.Rows[i][4], dtTemp.Rows[i][5], dtTemp.Rows[i][6], dtTemp.Rows[i][7], dtTemp.Rows[i][8], dtTemp.Rows[i][10], dtTemp.Rows[i][0], dtTemp.Rows[i][10]}); // 要对应！！
		}

		labPageIndex.Text = "当前页: " + String.valueOf(currentPage) + " / " + String.valueOf(pageCount); //当前页
		labRecordCount.Text = "总行数: " + String.valueOf(recordCount) + " 行"; //总记录数
	}

	private void btnSelect_Click(Object sender, tangible.EventArgs e)
	{
		start_dgv();
	}

	private void dgvss_visit_DoubleClick(Object sender, tangible.EventArgs e)
	{

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

	private void dgvss_visit_CellDoubleClick(Object sender, DataGridViewCellEventArgs e)
	{
		//MessageBox.Show("选中行" + (e.RowIndex + 1));
		//MessageBox.Show(dgvss_visit.Rows[e.RowIndex].Cells["illness_id"].Value.ToString());//获取选中行指定列的值
		//var visit = this.dgvss_visit.CurrentRow.DataBoundItem as cur_ss_visitTable;
		//MessageBox.Show(string.Format("成功{0}", visit.illness_id));



		String illnessId_ = dgvss_visit.Rows[e.RowIndex].Cells["illness_id"].Value.toString();
		String patient_name_ = dgvss_visit.Rows[e.RowIndex].Cells["patient_name"].Value.toString();
		LocalDateTime operation_date_ = (LocalDateTime)dgvss_visit.Rows[e.RowIndex].Cells["operation_date"].Value;


		LocalDateTime narcosis_time_ = (LocalDateTime)dgvss_visit.Rows[e.RowIndex].Cells["narcosis_time"].Value;
		String operation_name_ = dgvss_visit.Rows[e.RowIndex].Cells["operation_name"].Value.toString();

		String doc_name_ = dgvss_visit.Rows[e.RowIndex].Cells["doc_name"].Value.toString();
		String narcosis_doc_name_ = dgvss_visit.Rows[e.RowIndex].Cells["narcosis_doc_name"].Value.toString();
		String nurse_name_ = dgvss_visit.Rows[e.RowIndex].Cells["nurse_name"].Value.toString();
		boolean isSelect_ = (boolean)(dgvss_visit.Rows[e.RowIndex].Cells["isSelect"].Value);
		int visit_result_id_ = (int)(dgvss_visit.Rows[e.RowIndex].Cells["visit_result_id"].Value);
		cur_ss_visitTable visit = new cur_ss_visitTable();
		visit.setillness_id(illnessId_);
		visit.setpatient_name(patient_name_);
		visit.setoperation_date(operation_date_);
		visit.setnarcosis_time(narcosis_time_);
		visit.setoperation_name(operation_name_);
		visit.setdoc_name(doc_name_);
		visit.setnarcosis_doc_name(narcosis_doc_name_);
		visit.setnurse_name(nurse_name_);
		visit.setvisit_result_id(visit_result_id_);
		visit.setisSelect(isSelect_);
		Form_input Form_input_ = new Form_input(visit);
		Form_input_.ShowDialog();
		//窗体关闭后
		//跟新显示数据表
		start_dgv();


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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(IsForm4.class);
		this.groupBox1 = new System.Windows.Forms.GroupBox();
		this.chk_input = new System.Windows.Forms.CheckBox();
		this.btnSelect = new System.Windows.Forms.Button();
		this.txtname2 = new System.Windows.Forms.TextBox();
		this.txtname1 = new System.Windows.Forms.TextBox();
		this.label3 = new System.Windows.Forms.Label();
		this.label1 = new System.Windows.Forms.Label();
		this.dgvss_visit = new System.Windows.Forms.DataGridView();
		this.patient_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.operation_date = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.narcosis_time = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.operation_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.doc_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.narcosis_doc_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.nurse_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.isSelect = new System.Windows.Forms.DataGridViewCheckBoxColumn();
		this.illness_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.visit_result_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.panel5 = new System.Windows.Forms.Panel();
		this.pictureBox12 = new System.Windows.Forms.PictureBox();
		this.btnLast = new System.Windows.Forms.Button();
		this.btnNext = new System.Windows.Forms.Button();
		this.btnPrev = new System.Windows.Forms.Button();
		this.btnFirst = new System.Windows.Forms.Button();
		this.labPageIndex = new System.Windows.Forms.Label();
		this.labRecordCount = new System.Windows.Forms.Label();
		this.groupBox1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).BeginInit();
		this.panel5.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).BeginInit();
		this.SuspendLayout();
		// 
		// groupBox1
		// 
		this.groupBox1.Anchor = (System.Windows.Forms.AnchorStyles.forValue((((System.Windows.Forms.AnchorStyles.Top.getValue() | System.Windows.Forms.AnchorStyles.Bottom.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Left.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Right.getValue())));
		this.groupBox1.Controls.Add(this.chk_input);
		this.groupBox1.Controls.Add(this.btnSelect);
		this.groupBox1.Controls.Add(this.txtname2);
		this.groupBox1.Controls.Add(this.txtname1);
		this.groupBox1.Controls.Add(this.label3);
		this.groupBox1.Controls.Add(this.label1);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Location = new System.Drawing.Point(4, -3);
		this.groupBox1.Name = "groupBox1";
		this.groupBox1.Size = new System.Drawing.Size(839, 59);
		this.groupBox1.TabIndex = 4;
		this.groupBox1.TabStop = false;
		this.groupBox1.Text = "筛选";
		// 
		// chk_input
		// 
		this.chk_input.AutoSize = true;
		this.chk_input.Location = new System.Drawing.Point(449, 22);
		this.chk_input.Name = "chk_input";
		this.chk_input.Size = new System.Drawing.Size(75, 21);
		this.chk_input.TabIndex = 12;
		this.chk_input.Text = "是否录入";
		this.chk_input.UseVisualStyleBackColor = true;
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
		// dgvss_visit
		// 
		this.dgvss_visit.AllowUserToAddRows = false;
		this.dgvss_visit.AllowUserToDeleteRows = false;
		this.dgvss_visit.BackgroundColor = System.Drawing.SystemColors.Window;
		this.dgvss_visit.BorderStyle = System.Windows.Forms.BorderStyle.None;
		this.dgvss_visit.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
		this.dgvss_visit.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {this.patient_name, this.operation_date, this.narcosis_time, this.operation_name, this.doc_name, this.narcosis_doc_name, this.nurse_name, this.isSelect, this.illness_id, this.visit_result_id});
		this.dgvss_visit.GridColor = System.Drawing.SystemColors.Control;
		this.dgvss_visit.Location = new System.Drawing.Point(2, 57);
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
		this.dgvss_visit.Size = new System.Drawing.Size(843, 453);
		this.dgvss_visit.TabIndex = 5;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvss_visit_CellDoubleClick);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.DoubleClick += new System.EventHandler(this.dgvss_visit_DoubleClick);
		// 
		// patient_name
		// 
		this.patient_name.DataPropertyName = "patient_name";
		this.patient_name.HeaderText = "患者名";
		this.patient_name.MinimumWidth = 10;
		this.patient_name.Name = "patient_name";
		this.patient_name.ReadOnly = true;
		this.patient_name.Width = 86;
		// 
		// operation_date
		// 
		this.operation_date.DataPropertyName = "operation_date";
		this.operation_date.HeaderText = "手术日期";
		this.operation_date.Name = "operation_date";
		this.operation_date.ReadOnly = true;
		this.operation_date.Width = 130;
		// 
		// narcosis_time
		// 
		this.narcosis_time.DataPropertyName = "narcosis_time";
		this.narcosis_time.HeaderText = "访视时间";
		this.narcosis_time.Name = "narcosis_time";
		this.narcosis_time.ReadOnly = true;
		this.narcosis_time.Width = 130;
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
		// isSelect
		// 
		this.isSelect.DataPropertyName = "isSelect";
		this.isSelect.HeaderText = "是否录入";
		this.isSelect.Name = "isSelect";
		this.isSelect.ReadOnly = true;
		this.isSelect.Resizable = System.Windows.Forms.DataGridViewTriState.True;
		this.isSelect.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
		this.isSelect.Width = 60;
		// 
		// illness_id
		// 
		this.illness_id.DataPropertyName = "illness_id";
		this.illness_id.HeaderText = "患者id";
		this.illness_id.MinimumWidth = 2;
		this.illness_id.Name = "illness_id";
		this.illness_id.ReadOnly = true;
		this.illness_id.Width = 2;
		// 
		// visit_result_id
		// 
		this.visit_result_id.DataPropertyName = "visit_result_id";
		this.visit_result_id.HeaderText = "访视结果名";
		this.visit_result_id.MinimumWidth = 2;
		this.visit_result_id.Name = "visit_result_id";
		this.visit_result_id.ReadOnly = true;
		this.visit_result_id.Width = 2;
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
		this.panel5.Location = new System.Drawing.Point(2, 512);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(843, 43);
		this.panel5.TabIndex = 6;
		// 
		// pictureBox12
		// 
		this.pictureBox12.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox12.BackgroundImage")));
		this.pictureBox12.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox12.Location = new System.Drawing.Point(0, -2);
		this.pictureBox12.Name = "pictureBox12";
		this.pictureBox12.Size = new System.Drawing.Size(15, 45);
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
		// IsForm4
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(846, 555);
		this.Controls.Add(this.panel5);
		this.Controls.Add(this.dgvss_visit);
		this.Controls.Add(this.groupBox1);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.Name = "IsForm4";
		this.Text = "IsForm4";
		this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.IsForm4_Load);
		this.groupBox1.ResumeLayout(false);
		this.groupBox1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).EndInit();
		this.panel5.ResumeLayout(false);
		this.panel5.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox12)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.GroupBox groupBox1;
	private System.Windows.Forms.CheckBox chk_input;
	private System.Windows.Forms.Button btnSelect;
	private System.Windows.Forms.TextBox txtname2;
	private System.Windows.Forms.TextBox txtname1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.DataGridView dgvss_visit;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.PictureBox pictureBox12;
	private System.Windows.Forms.Button btnLast;
	private System.Windows.Forms.Button btnNext;
	private System.Windows.Forms.Button btnPrev;
	private System.Windows.Forms.Button btnFirst;
	private System.Windows.Forms.Label labPageIndex;
	private System.Windows.Forms.Label labRecordCount;
	private System.Windows.Forms.DataGridViewTextBoxColumn patient_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn operation_date;
	private System.Windows.Forms.DataGridViewTextBoxColumn narcosis_time;
	private System.Windows.Forms.DataGridViewTextBoxColumn operation_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn doc_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn narcosis_doc_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn nurse_name;
	private System.Windows.Forms.DataGridViewCheckBoxColumn isSelect;
	private System.Windows.Forms.DataGridViewTextBoxColumn illness_id;
	private System.Windows.Forms.DataGridViewTextBoxColumn visit_result_id;
}