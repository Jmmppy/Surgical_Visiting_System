package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;
import java.util.*;

public class Form_apply3 extends Form
{
	private patient_tableBll patient_tableBll_ = new patient_tableBll();
	public Form_apply3()
	{
		InitializeComponent();
	}

	private void Form_apply3_FormClosed(Object sender, FormClosedEventArgs e)
	{
		this.Close();
		this.DialogResult = System.Windows.Forms.DialogResult.OK;
	}

	private void Form_apply3_Load(Object sender, tangible.EventArgs e)
	{
		dgv_show(); //MessageBox.Show(string.Format("当前可提交的数据为0条"));
	}

	private void dgv_show()
	{
		String patient_name_ = this.txtname1.Text.strip();
		String doc_name_ = this.txtname2.Text.strip();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 绑定n表数据
		// 初始化绑定notice_table表数据
		this.dgvss_visit.AutoGenerateColumns = false; //控制DataGriView只显示需要的列
													   // this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList(); //方法一
		ArrayList<cur_patient_table> cur_patient_table_ = patient_tableBll_.GetPatient_tableList1();
		this.dgvss_visit.DataSource = tangible.ListHelper.findAll(cur_patient_table_, m -> m.patient_name.Contains(patient_name_) && m.doc_name.Contains(doc_name_) && m.Isinput == true && m.Isinput2 == false); //方法二
																													//this.dgvss_visit.DataSource = cur_ss_visitTable_;                                                                                                   //this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList1().FindAll
																													//    (m => m.patient_name.Contains(patient_name_) && m.narcosis_doc_name.Contains(norcosis_name_));   //方法二
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 绑定notice_table表数据
	}

	private void dgvss_visit_CellContentClick(Object sender, DataGridViewCellEventArgs e)
	{

	}

	private void btnSelect_Click(Object sender, tangible.EventArgs e)
	{
		dgv_show();
	}

	private void dgvss_visit_DoubleClick(Object sender, tangible.EventArgs e)
	{
		Object tempVar = this.dgvss_visit.CurrentRow.DataBoundItem;
		var visit = tempVar instanceof cur_patient_table ? (cur_patient_table)tempVar : null;
		//MessageBox.Show(string.Format("成功{0}", visit.illness_id));
		Form_apply4 Form_apply4_ = new Form_apply4(visit);
		Form_apply4_.ShowDialog();
		//窗体关闭后
		//跟新显示数据表
		dgv_show();
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
		this.dgvss_visit = new System.Windows.Forms.DataGridView();
		this.label1 = new System.Windows.Forms.Label();
		this.groupBox1 = new System.Windows.Forms.GroupBox();
		this.btnSelect = new System.Windows.Forms.Button();
		this.txtname2 = new System.Windows.Forms.TextBox();
		this.txtname1 = new System.Windows.Forms.TextBox();
		this.label3 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.patient_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.age = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.height = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.weigth = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.phone = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.insurance_type = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.sickroom = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.doc_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.pice_place_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.partment_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.diagnosis = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.isInput = new System.Windows.Forms.DataGridViewTextBoxColumn();
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).BeginInit();
		this.groupBox1.SuspendLayout();
		this.SuspendLayout();
		// 
		// dgvss_visit
		// 
		this.dgvss_visit.AllowUserToAddRows = false;
		this.dgvss_visit.AllowUserToDeleteRows = false;
		this.dgvss_visit.BackgroundColor = System.Drawing.SystemColors.Window;
		this.dgvss_visit.BorderStyle = System.Windows.Forms.BorderStyle.None;
		this.dgvss_visit.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
		this.dgvss_visit.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {this.patient_name, this.age, this.height, this.weigth, this.phone, this.insurance_type, this.sickroom, this.doc_name, this.pice_place_name, this.partment_name, this.diagnosis, this.isInput});
		this.dgvss_visit.GridColor = System.Drawing.SystemColors.Control;
		this.dgvss_visit.Location = new System.Drawing.Point(0, 133);
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
		this.dgvss_visit.Size = new System.Drawing.Size(1114, 498);
		this.dgvss_visit.TabIndex = 8;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvss_visit_CellContentClick);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.DoubleClick += new System.EventHandler(this.dgvss_visit_DoubleClick);
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Location = new System.Drawing.Point(449, 9);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(133, 39);
		this.label1.TabIndex = 9;
		this.label1.Text = "审批申请";
		// 
		// groupBox1
		// 
		this.groupBox1.Anchor = (System.Windows.Forms.AnchorStyles.forValue((((System.Windows.Forms.AnchorStyles.Top.getValue() | System.Windows.Forms.AnchorStyles.Bottom.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Left.getValue()).getValue() | System.Windows.Forms.AnchorStyles.Right.getValue())));
		this.groupBox1.BackColor = System.Drawing.SystemColors.ControlLightLight;
		this.groupBox1.Controls.Add(this.btnSelect);
		this.groupBox1.Controls.Add(this.txtname2);
		this.groupBox1.Controls.Add(this.txtname1);
		this.groupBox1.Controls.Add(this.label3);
		this.groupBox1.Controls.Add(this.label2);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.groupBox1.Location = new System.Drawing.Point(3, 70);
		this.groupBox1.Name = "groupBox1";
		this.groupBox1.Size = new System.Drawing.Size(1001, 61);
		this.groupBox1.TabIndex = 10;
		this.groupBox1.TabStop = false;
		this.groupBox1.Text = "筛选";
		// 
		// btnSelect
		// 
		this.btnSelect.BackColor = System.Drawing.Color.SeaGreen;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSelect.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnSelect.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnSelect.FlatAppearance.BorderSize = 0;
		this.btnSelect.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSelect.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnSelect.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnSelect.ForeColor = System.Drawing.SystemColors.Window;
		this.btnSelect.Location = new System.Drawing.Point(764, 22);
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
		this.label3.Size = new System.Drawing.Size(59, 17);
		this.label3.TabIndex = 0;
		this.label3.Text = "就诊医师:";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
		this.label2.Location = new System.Drawing.Point(16, 24);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(44, 17);
		this.label2.TabIndex = 0;
		this.label2.Text = "姓名：";
		// 
		// patient_name
		// 
		this.patient_name.DataPropertyName = "patient_name";
		this.patient_name.HeaderText = "患者名";
		this.patient_name.Name = "patient_name";
		this.patient_name.ReadOnly = true;
		this.patient_name.Width = 90;
		// 
		// age
		// 
		this.age.DataPropertyName = "age";
		this.age.HeaderText = "年龄";
		this.age.Name = "age";
		this.age.ReadOnly = true;
		this.age.Width = 30;
		// 
		// height
		// 
		this.height.DataPropertyName = "height";
		this.height.HeaderText = "身高";
		this.height.Name = "height";
		this.height.ReadOnly = true;
		this.height.Width = 30;
		// 
		// weigth
		// 
		this.weigth.DataPropertyName = "weigth";
		this.weigth.HeaderText = "体重";
		this.weigth.Name = "weigth";
		this.weigth.ReadOnly = true;
		this.weigth.Width = 50;
		// 
		// phone
		// 
		this.phone.DataPropertyName = "phone";
		this.phone.HeaderText = "手机号";
		this.phone.Name = "phone";
		this.phone.ReadOnly = true;
		this.phone.Width = 110;
		// 
		// insurance_type
		// 
		this.insurance_type.DataPropertyName = "insurance_type";
		this.insurance_type.HeaderText = "医保类型";
		this.insurance_type.Name = "insurance_type";
		this.insurance_type.ReadOnly = true;
		this.insurance_type.Width = 95;
		// 
		// sickroom
		// 
		this.sickroom.DataPropertyName = "sickroom";
		this.sickroom.HeaderText = "病房";
		this.sickroom.Name = "sickroom";
		this.sickroom.ReadOnly = true;
		this.sickroom.Width = 80;
		// 
		// doc_name
		// 
		this.doc_name.DataPropertyName = "doc_name";
		this.doc_name.HeaderText = "医师";
		this.doc_name.Name = "doc_name";
		this.doc_name.ReadOnly = true;
		this.doc_name.Width = 95;
		// 
		// pice_place_name
		// 
		this.pice_place_name.DataPropertyName = "pice_place_name";
		this.pice_place_name.HeaderText = "片区";
		this.pice_place_name.Name = "pice_place_name";
		this.pice_place_name.ReadOnly = true;
		this.pice_place_name.Width = 125;
		// 
		// partment_name
		// 
		this.partment_name.DataPropertyName = "partment_name";
		this.partment_name.HeaderText = "科室";
		this.partment_name.Name = "partment_name";
		this.partment_name.ReadOnly = true;
		// 
		// diagnosis
		// 
		this.diagnosis.DataPropertyName = "diagnosis";
		this.diagnosis.HeaderText = "诊断";
		this.diagnosis.Name = "diagnosis";
		this.diagnosis.ReadOnly = true;
		this.diagnosis.Width = 200;
		// 
		// isInput
		// 
		this.isInput.DataPropertyName = "isInput";
		this.isInput.HeaderText = "录入";
		this.isInput.MinimumWidth = 2;
		this.isInput.Name = "isInput";
		this.isInput.ReadOnly = true;
		this.isInput.Resizable = System.Windows.Forms.DataGridViewTriState.True;
		this.isInput.Width = 2;
		// 
		// Form_apply3
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.ClientSize = new System.Drawing.Size(1016, 632);
		this.Controls.Add(this.groupBox1);
		this.Controls.Add(this.label1);
		this.Controls.Add(this.dgvss_visit);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
		this.Name = "Form_apply3";
		this.Text = "Form_apply3";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form_apply3_FormClosed);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_apply3_Load);
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).EndInit();
		this.groupBox1.ResumeLayout(false);
		this.groupBox1.PerformLayout();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.DataGridView dgvss_visit;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.DataGridViewTextBoxColumn patient_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn age;
	private System.Windows.Forms.DataGridViewTextBoxColumn height;
	private System.Windows.Forms.DataGridViewTextBoxColumn weigth;
	private System.Windows.Forms.DataGridViewTextBoxColumn phone;
	private System.Windows.Forms.DataGridViewTextBoxColumn insurance_type;
	private System.Windows.Forms.DataGridViewTextBoxColumn sickroom;
	private System.Windows.Forms.DataGridViewTextBoxColumn doc_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn pice_place_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn partment_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn diagnosis;
	private System.Windows.Forms.DataGridViewTextBoxColumn isInput;
	private System.Windows.Forms.GroupBox groupBox1;
	private System.Windows.Forms.Button btnSelect;
	private System.Windows.Forms.TextBox txtname2;
	private System.Windows.Forms.TextBox txtname1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label2;
}