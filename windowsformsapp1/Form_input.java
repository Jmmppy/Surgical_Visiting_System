package windowsformsapp1;

import Models.*;
import BLL.*;

public class Form_input extends Form
{
	private cur_ss_visitTable cur_visit;
	private visit_result_tableBll visit_result_tableBll_ = new visit_result_tableBll();
	private ss_visitTableBll ss_visitTableBll_ = new ss_visitTableBll();
	private visit_result_table visit_result_table_;
	private ss_visitTable ss_visitTable_;
	private boolean isInput = false;

	public Form_input(cur_ss_visitTable visit)
	{
		InitializeComponent();
		cur_visit = visit;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 显示信息
		this.lbname.Text = visit.patient_name.toString();
		this.label11.Text = visit.illness_id.toString();
		this.label14.Text = visit.narcosis_doc_name.toString();
		this.label16.Text = visit.nurse_name.toString();
		this.label18.Text = visit.operation_name.toString();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 显示信息
	}

	private void Form_input_Load(Object sender, tangible.EventArgs e)
	{
		//判断是否已经录入
		if (cur_visit.isSelect == true)
		{
			isInput = true;
			//根据result_id 去查找
			visit_result_table_ = visit_result_tableBll_.getvisit_result_tableObject2(cur_visit.visit_result_id);
			//显示已经选择的数据
			this.txb_drug_allergy.Text = visit_result_table_.drug_allergy.toString();
			this.txb_sanity.Text = visit_result_table_.sanity.toString();
			this.txb_condition.Text = visit_result_table_.condition.toString();
			this.txb_test_result.Text = visit_result_table_.test_result.toString();


			//btn命名为"修改”
			this.btnOK.Text = "修 改";
			//跟新表
		}
		else
		{
			isInput = false;
		}
	}

	private void btnOK_Click(Object sender, tangible.EventArgs e)
	{
		String drug_allergy_ = this.txb_drug_allergy.Text;
		String sanity_ = this.txb_sanity.Text;
		String condition_ = this.txb_condition.Text;
		String test_result_ = this.txb_test_result.Text;
		if (isInput == true)
		{ //已经录入 "修改”
			//跟新到visit_result_table表
			visit_result_table visit_result_table_2 = new visit_result_table();
			visit_result_table_2.setvisit_result_id(cur_visit.visit_result_id);
			visit_result_table_2.setcondition(condition_);
			visit_result_table_2.setdrug_allergy(drug_allergy_);
			visit_result_table_2.setsanity(sanity_);
			visit_result_table_2.settest_result(test_result_);
			visit_result_table_2.setillness_id(cur_visit.illness_id);
			int row = visit_result_tableBll_.update_visit_result_table(visit_result_table_2);
			if (row > 0)
			{ // 修改成功
				MessageBox.Show(String.format("成功修改！"));
				this.Close();
			}
		}
		else
		{

			//对象初始化器
			visit_result_table visit_result_table_ = new visit_result_table();
			visit_result_table_.setillness_id(cur_visit.illness_id);
			visit_result_table_.setdrug_allergy(drug_allergy_);
			visit_result_table_.setsanity(sanity_);
			visit_result_table_.setcondition(condition_);
			visit_result_table_.settest_result(test_result_);

			int row = visit_result_tableBll_.insert_visit_result_table(visit_result_table_); //插入visit_result_table
			if (row > 0)
			{ // 插入成功
				visit_result_table_ = visit_result_tableBll_.getvisit_result_tableObject(cur_visit.illness_id);

				//返回visit_result_id  为  visit_result_table_.visit_result_id
				ss_visitTable_ = new ss_visitTable();
				ss_visitTable_.setillness_id(cur_visit.illness_id);
				ss_visitTable_.setvisit_result_id(visit_result_table_.visit_result_id);
				ss_visitTable_.setisSelect(true);

				//跟新ss_visitTable  visit_result_id、isSelect
				int row2 = ss_visitTableBll_.update_ss_visitTable(ss_visitTable_);
				this.Close();
			}

		}





	}

	private void btn_clear_Click(Object sender, tangible.EventArgs e)
	{
		//清空已经选择的数据
		this.txb_drug_allergy.Text = "";
		this.txb_sanity.Text = "";
		this.txb_condition.Text = "";
		this.txb_test_result.Text = "";
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form_input.class);
		this.label2 = new System.Windows.Forms.Label();
		this.pictureBox10 = new System.Windows.Forms.PictureBox();
		this.label1 = new System.Windows.Forms.Label();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.label3 = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.label4 = new System.Windows.Forms.Label();
		this.label6 = new System.Windows.Forms.Label();
		this.label7 = new System.Windows.Forms.Label();
		this.txb_drug_allergy = new System.Windows.Forms.TextBox();
		this.txb_test_result = new System.Windows.Forms.TextBox();
		this.txb_sanity = new System.Windows.Forms.TextBox();
		this.txb_condition = new System.Windows.Forms.TextBox();
		this.label8 = new System.Windows.Forms.Label();
		this.lbname = new System.Windows.Forms.Label();
		this.btnOK = new System.Windows.Forms.Button();
		this.btn_clear = new System.Windows.Forms.Button();
		this.panel1 = new System.Windows.Forms.Panel();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		this.panel5 = new System.Windows.Forms.Panel();
		this.label13 = new System.Windows.Forms.Label();
		this.panel2 = new System.Windows.Forms.Panel();
		this.label9 = new System.Windows.Forms.Label();
		this.label10 = new System.Windows.Forms.Label();
		this.label11 = new System.Windows.Forms.Label();
		this.label12 = new System.Windows.Forms.Label();
		this.label14 = new System.Windows.Forms.Label();
		this.label15 = new System.Windows.Forms.Label();
		this.label16 = new System.Windows.Forms.Label();
		this.label17 = new System.Windows.Forms.Label();
		this.label18 = new System.Windows.Forms.Label();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		this.SuspendLayout();
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
		this.label2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Location = new System.Drawing.Point(9, 32);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(151, 22);
		this.label2.TabIndex = 2;
		this.label2.Text = "    患者基本信息  :  ";
		// 
		// pictureBox10
		// 
		this.pictureBox10.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox10.BackgroundImage")));
		this.pictureBox10.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox10.Location = new System.Drawing.Point(7, 32);
		this.pictureBox10.Name = "pictureBox10";
		this.pictureBox10.Size = new System.Drawing.Size(10, 24);
		this.pictureBox10.TabIndex = 4;
		this.pictureBox10.TabStop = false;
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
		this.label1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Location = new System.Drawing.Point(10, 225);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(151, 22);
		this.label1.TabIndex = 2;
		this.label1.Text = "    患者基本信息  :  ";
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(5, 223);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(10, 24);
		this.pictureBox1.TabIndex = 4;
		this.pictureBox1.TabStop = false;
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label3.Location = new System.Drawing.Point(145, 20);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(132, 27);
		this.label3.TabIndex = 5;
		this.label3.Text = "访视结果录入";
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Location = new System.Drawing.Point(3, 283);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(79, 20);
		this.label5.TabIndex = 6;
		this.label5.Text = "药物过敏：";
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Location = new System.Drawing.Point(3, 342);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(79, 20);
		this.label4.TabIndex = 6;
		this.label4.Text = "患者神智：";
		// 
		// label6
		// 
		this.label6.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label6.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Location = new System.Drawing.Point(3, 397);
		this.label6.Name = "label6";
		this.label6.Size = new System.Drawing.Size(79, 20);
		this.label6.TabIndex = 6;
		this.label6.Text = "身体状况：";
		// 
		// label7
		// 
		this.label7.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Location = new System.Drawing.Point(3, 451);
		this.label7.Name = "label7";
		this.label7.Size = new System.Drawing.Size(107, 20);
		this.label7.TabIndex = 6;
		this.label7.Text = "辅助检查结果：";
		// 
		// txb_drug_allergy
		// 
		this.txb_drug_allergy.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txb_drug_allergy.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_drug_allergy.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_drug_allergy.Location = new System.Drawing.Point(116, 278);
		this.txb_drug_allergy.Multiline = true;
		this.txb_drug_allergy.Name = "txb_drug_allergy";
		this.txb_drug_allergy.Size = new System.Drawing.Size(218, 37);
		this.txb_drug_allergy.TabIndex = 7;
		// 
		// txb_test_result
		// 
		this.txb_test_result.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txb_test_result.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_test_result.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_test_result.Location = new System.Drawing.Point(116, 451);
		this.txb_test_result.Multiline = true;
		this.txb_test_result.Name = "txb_test_result";
		this.txb_test_result.Size = new System.Drawing.Size(297, 76);
		this.txb_test_result.TabIndex = 7;
		// 
		// txb_sanity
		// 
		this.txb_sanity.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txb_sanity.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_sanity.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_sanity.Location = new System.Drawing.Point(116, 337);
		this.txb_sanity.Multiline = true;
		this.txb_sanity.Name = "txb_sanity";
		this.txb_sanity.Size = new System.Drawing.Size(218, 37);
		this.txb_sanity.TabIndex = 7;
		// 
		// txb_condition
		// 
		this.txb_condition.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txb_condition.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_condition.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_condition.Location = new System.Drawing.Point(116, 392);
		this.txb_condition.Multiline = true;
		this.txb_condition.Name = "txb_condition";
		this.txb_condition.Size = new System.Drawing.Size(218, 37);
		this.txb_condition.TabIndex = 7;
		// 
		// label8
		// 
		this.label8.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Location = new System.Drawing.Point(12, 91);
		this.label8.Name = "label8";
		this.label8.Size = new System.Drawing.Size(51, 20);
		this.label8.TabIndex = 8;
		this.label8.Text = "姓名：";
		// 
		// lbname
		// 
		this.lbname.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lbname.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbname.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbname.Location = new System.Drawing.Point(77, 91);
		this.lbname.Name = "lbname";
		this.lbname.Size = new System.Drawing.Size(33, 20);
		this.lbname.TabIndex = 9;
		this.lbname.Text = "000";
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
		this.btnOK.Location = new System.Drawing.Point(154, 552);
		this.btnOK.Name = "btnOK";
		this.btnOK.Size = new System.Drawing.Size(94, 29);
		this.btnOK.TabIndex = 12;
		this.btnOK.Text = "提 交";
		this.btnOK.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
		// 
		// btn_clear
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btn_clear.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.btn_clear.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btn_clear.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btn_clear.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btn_clear.FlatAppearance.BorderSize = 0;
		this.btn_clear.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btn_clear.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btn_clear.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btn_clear.ForeColor = System.Drawing.SystemColors.Window;
		this.btn_clear.Location = new System.Drawing.Point(319, 552);
		this.btn_clear.Name = "btn_clear";
		this.btn_clear.Size = new System.Drawing.Size(94, 29);
		this.btn_clear.TabIndex = 12;
		this.btn_clear.Text = "取 消";
		this.btn_clear.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btn_clear.Click += new System.EventHandler(this.btn_clear_Click);
		// 
		// panel1
		// 
		this.panel1.BackColor = System.Drawing.Color.White;
		this.panel1.Controls.Add(this.pictureBox6);
		this.panel1.Controls.Add(this.pictureBox10);
		this.panel1.Controls.Add(this.pictureBox1);
		this.panel1.Controls.Add(this.label1);
		this.panel1.Controls.Add(this.btn_clear);
		this.panel1.Controls.Add(this.label2);
		this.panel1.Controls.Add(this.btnOK);
		this.panel1.Controls.Add(this.label18);
		this.panel1.Controls.Add(this.label16);
		this.panel1.Controls.Add(this.label14);
		this.panel1.Controls.Add(this.label11);
		this.panel1.Controls.Add(this.lbname);
		this.panel1.Controls.Add(this.label5);
		this.panel1.Controls.Add(this.label17);
		this.panel1.Controls.Add(this.label15);
		this.panel1.Controls.Add(this.label12);
		this.panel1.Controls.Add(this.label10);
		this.panel1.Controls.Add(this.label8);
		this.panel1.Controls.Add(this.label4);
		this.panel1.Controls.Add(this.txb_sanity);
		this.panel1.Controls.Add(this.label6);
		this.panel1.Controls.Add(this.txb_condition);
		this.panel1.Controls.Add(this.label7);
		this.panel1.Controls.Add(this.txb_test_result);
		this.panel1.Controls.Add(this.txb_drug_allergy);
		this.panel1.Location = new System.Drawing.Point(0, 67);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(431, 620);
		this.panel1.TabIndex = 13;
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(299, 32);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(114, 49);
		this.pictureBox6.TabIndex = 16;
		this.pictureBox6.TabStop = false;
		// 
		// panel5
		// 
		this.panel5.BackColor = System.Drawing.Color.White;
		this.panel5.Location = new System.Drawing.Point(35, 34);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(94, 3);
		this.panel5.TabIndex = 15;
		// 
		// label13
		// 
		this.label13.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label13.Font = new System.Drawing.Font("Rockwell", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label13.Font = new System.Drawing.Font("Rockwell", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label13.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label13.Location = new System.Drawing.Point(193, 71);
		this.label13.Name = "label13";
		this.label13.Size = new System.Drawing.Size(209, 25);
		this.label13.TabIndex = 13;
		this.label13.Text = "Patient information";
		// 
		// panel2
		// 
		this.panel2.BackColor = System.Drawing.Color.White;
		this.panel2.Location = new System.Drawing.Point(287, 34);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(94, 3);
		this.panel2.TabIndex = 15;
		// 
		// label9
		// 
		this.label9.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label9.Font = new System.Drawing.Font("Rockwell", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label9.Font = new System.Drawing.Font("Rockwell", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label9.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label9.Location = new System.Drawing.Point(151, 46);
		this.label9.Name = "label9";
		this.label9.Size = new System.Drawing.Size(104, 14);
		this.label9.TabIndex = 17;
		this.label9.Text = "Visit result entry";
		// 
		// label10
		// 
		this.label10.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Location = new System.Drawing.Point(12, 127);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(65, 20);
		this.label10.TabIndex = 8;
		this.label10.Text = "病案号：";
		// 
		// label11
		// 
		this.label11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Location = new System.Drawing.Point(77, 127);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(33, 20);
		this.label11.TabIndex = 9;
		this.label11.Text = "000";
		// 
		// label12
		// 
		this.label12.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label12.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Location = new System.Drawing.Point(12, 166);
		this.label12.Name = "label12";
		this.label12.Size = new System.Drawing.Size(107, 20);
		this.label12.TabIndex = 8;
		this.label12.Text = "访视医生姓名：";
		// 
		// label14
		// 
		this.label14.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Location = new System.Drawing.Point(146, 166);
		this.label14.Name = "label14";
		this.label14.Size = new System.Drawing.Size(33, 20);
		this.label14.TabIndex = 9;
		this.label14.Text = "000";
		// 
		// label15
		// 
		this.label15.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label15.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Location = new System.Drawing.Point(173, 91);
		this.label15.Name = "label15";
		this.label15.Size = new System.Drawing.Size(79, 20);
		this.label15.TabIndex = 8;
		this.label15.Text = "护士姓名：";
		// 
		// label16
		// 
		this.label16.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label16.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Location = new System.Drawing.Point(258, 91);
		this.label16.Name = "label16";
		this.label16.Size = new System.Drawing.Size(33, 20);
		this.label16.TabIndex = 9;
		this.label16.Text = "000";
		// 
		// label17
		// 
		this.label17.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Location = new System.Drawing.Point(173, 127);
		this.label17.Name = "label17";
		this.label17.Size = new System.Drawing.Size(65, 20);
		this.label17.TabIndex = 8;
		this.label17.Text = "手术名：";
		// 
		// label18
		// 
		this.label18.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Location = new System.Drawing.Point(238, 127);
		this.label18.Name = "label18";
		this.label18.Size = new System.Drawing.Size(33, 20);
		this.label18.TabIndex = 9;
		this.label18.Text = "000";
		// 
		// Form_input
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.ClientSize = new System.Drawing.Size(432, 686);
		this.Controls.Add(this.label9);
		this.Controls.Add(this.panel1);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel5);
		this.Controls.Add(this.label3);
		this.Controls.Add(this.label13);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
		this.Name = "Form_input";
		this.ShowIcon = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_input_Load);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.PictureBox pictureBox10;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label label6;
	private System.Windows.Forms.Label label7;
	private System.Windows.Forms.TextBox txb_drug_allergy;
	private System.Windows.Forms.TextBox txb_test_result;
	private System.Windows.Forms.TextBox txb_sanity;
	private System.Windows.Forms.TextBox txb_condition;
	private System.Windows.Forms.Label label8;
	private System.Windows.Forms.Label lbname;
	private System.Windows.Forms.Button btnOK;
	private System.Windows.Forms.Button btn_clear;
	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.PictureBox pictureBox6;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.Label label13;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.Label label9;
	private System.Windows.Forms.Label label18;
	private System.Windows.Forms.Label label16;
	private System.Windows.Forms.Label label14;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.Label label17;
	private System.Windows.Forms.Label label15;
	private System.Windows.Forms.Label label12;
	private System.Windows.Forms.Label label10;
}