package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;

public class Form_apply4 extends Form
{
	private cur_patient_table cur_visit;
	private boolean cur_isInput = false;
	private partment_tableBll partment_tableBll_ = new partment_tableBll();
	private ss_tableBll ss_tableBll_ = new ss_tableBll();
	private patient_tableBll patient_tableBll_ = new patient_tableBll();
	private patient_table patient_table_;
	public Form_apply4(cur_patient_table visit)
	{
		InitializeComponent();
		cur_visit = visit;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 显示信息
		this.lbname.Text = cur_visit.patient_name.toString();
		this.lb_ilnessid.Text = cur_visit.illness_id.toString();
		this.lbsickroom.Text = cur_visit.sickroom.toString();
		//没写完……
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 显示信息
	}

	private void Form_apply4_Load(Object sender, tangible.EventArgs e)
	{
		//ss_id 去查找
		ss_table ss_table_ = ss_tableBll_.getss_tableObject2(cur_visit.ss_id);
		String a = String.valueOf(ss_table_.ss_date);
		//显示已经选择的数据
		this.dateTimePicker1.Text = String.valueOf(ss_table_.ss_date); ///
		this.cmb_ss_type.Text = ss_table_.ss_type;
		this.cmb_ss_grade.Text = ss_table_.ss_grade;

		this.cmb_operation.Text = ss_table_.operation_id; ////
		this.cmb_position.Text = ss_table_.position;
		this.cmb_body_position.Text = ss_table_.body_position;
		this.cmb_cut_grade.Text = ss_table_.cut_grade;

		this.cmb_narcosis_way.Text = ss_table_.narcosis_way;

		this.cmb_hepatitisB.Text = ss_table_.hepatitisB;
		this.cmb_hepatitisC.Text = ss_table_.hepatitisC;
		this.cmb_syphilis.Text = ss_table_.syphilis;
		this.cmb_HIV.Text = ss_table_.HIV;
		this.cmb_tuberculosis.Text = ss_table_.tuberculosis;

		this.cmb_BH_blood.Text = ss_table_.BH_blood;
		this.txb_special_infection.Text = ss_table_.special_infection;
		this.txt_remarks.Text = ss_table_.remarks;


	}

	private void btnOK_Click(Object sender, tangible.EventArgs e)
	{
		patient_table_ = new patient_table();
		patient_table_.setillness_id(cur_visit.illness_id);
		patient_table_.setisInput2(true);
		//跟新ss_visitTable  visit_result_id、isSelect
		int row2 = patient_tableBll_.update_patient_table22(patient_table_);

		this.Close();
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form_apply4.class);
		this.label1 = new System.Windows.Forms.Label();
		this.panel1 = new System.Windows.Forms.Panel();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		this.txbmessage = new System.Windows.Forms.TextBox();
		this.pictureBox10 = new System.Windows.Forms.PictureBox();
		this.label11 = new System.Windows.Forms.Label();
		this.label7 = new System.Windows.Forms.Label();
		this.lbsickroom = new System.Windows.Forms.Label();
		this.lbpartment = new System.Windows.Forms.Label();
		this.lb_ilnessid = new System.Windows.Forms.Label();
		this.label15 = new System.Windows.Forms.Label();
		this.sex = new System.Windows.Forms.Label();
		this.label13 = new System.Windows.Forms.Label();
		this.lbname = new System.Windows.Forms.Label();
		this.label9 = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.panel2 = new System.Windows.Forms.Panel();
		this.txb_special_infection = new System.Windows.Forms.TextBox();
		this.txt_remarks = new System.Windows.Forms.TextBox();
		this.cmb_BH_blood = new System.Windows.Forms.ComboBox();
		this.cmb_tuberculosis = new System.Windows.Forms.ComboBox();
		this.cmb_HIV = new System.Windows.Forms.ComboBox();
		this.cmb_syphilis = new System.Windows.Forms.ComboBox();
		this.cmb_hepatitisC = new System.Windows.Forms.ComboBox();
		this.cmb_hepatitisB = new System.Windows.Forms.ComboBox();
		this.cmb_narcosis_way = new System.Windows.Forms.ComboBox();
		this.cmb_cut_grade = new System.Windows.Forms.ComboBox();
		this.cmb_body_position = new System.Windows.Forms.ComboBox();
		this.cmb_position = new System.Windows.Forms.ComboBox();
		this.cmb_operation = new System.Windows.Forms.ComboBox();
		this.cmb_ss_grade = new System.Windows.Forms.ComboBox();
		this.cmb_ss_type = new System.Windows.Forms.ComboBox();
		this.dateTimePicker1 = new System.Windows.Forms.DateTimePicker();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.label3 = new System.Windows.Forms.Label();
		this.label28 = new System.Windows.Forms.Label();
		this.label26 = new System.Windows.Forms.Label();
		this.label24 = new System.Windows.Forms.Label();
		this.label22 = new System.Windows.Forms.Label();
		this.label23 = new System.Windows.Forms.Label();
		this.label21 = new System.Windows.Forms.Label();
		this.label20 = new System.Windows.Forms.Label();
		this.label19 = new System.Windows.Forms.Label();
		this.label16 = new System.Windows.Forms.Label();
		this.label10 = new System.Windows.Forms.Label();
		this.label12 = new System.Windows.Forms.Label();
		this.label8 = new System.Windows.Forms.Label();
		this.label18 = new System.Windows.Forms.Label();
		this.label6 = new System.Windows.Forms.Label();
		this.label4 = new System.Windows.Forms.Label();
		this.label17 = new System.Windows.Forms.Label();
		this.btnOK = new System.Windows.Forms.Button();
		this.btnClear = new System.Windows.Forms.Button();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).BeginInit();
		this.panel2.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.SuspendLayout();
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("宋体", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("宋体", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Location = new System.Drawing.Point(293, 18);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(109, 20);
		this.label1.TabIndex = 3;
		this.label1.Text = "手术申请单";
		// 
		// panel1
		// 
		this.panel1.Controls.Add(this.pictureBox2);
		this.panel1.Controls.Add(this.pictureBox6);
		this.panel1.Controls.Add(this.txbmessage);
		this.panel1.Controls.Add(this.pictureBox10);
		this.panel1.Controls.Add(this.label11);
		this.panel1.Controls.Add(this.label7);
		this.panel1.Controls.Add(this.lbsickroom);
		this.panel1.Controls.Add(this.lbpartment);
		this.panel1.Controls.Add(this.lb_ilnessid);
		this.panel1.Controls.Add(this.label15);
		this.panel1.Controls.Add(this.sex);
		this.panel1.Controls.Add(this.label13);
		this.panel1.Controls.Add(this.lbname);
		this.panel1.Controls.Add(this.label9);
		this.panel1.Controls.Add(this.label5);
		this.panel1.Controls.Add(this.label2);
		this.panel1.Location = new System.Drawing.Point(27, 61);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(834, 234);
		this.panel1.TabIndex = 4;
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox2.Location = new System.Drawing.Point(643, 138);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(105, 89);
		this.pictureBox2.TabIndex = 14;
		this.pictureBox2.TabStop = false;
		this.pictureBox2.Visible = false;
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(527, 138);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(105, 89);
		this.pictureBox6.TabIndex = 14;
		this.pictureBox6.TabStop = false;
		this.pictureBox6.Visible = false;
		// 
		// txbmessage
		// 
		this.txbmessage.BorderStyle = System.Windows.Forms.BorderStyle.None;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage.Location = new System.Drawing.Point(90, 126);
		this.txbmessage.Multiline = true;
		this.txbmessage.Name = "txbmessage";
		this.txbmessage.Size = new System.Drawing.Size(417, 31);
		this.txbmessage.TabIndex = 4;
		// 
		// pictureBox10
		// 
		this.pictureBox10.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox10.BackgroundImage")));
		this.pictureBox10.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox10.Location = new System.Drawing.Point(12, 22);
		this.pictureBox10.Name = "pictureBox10";
		this.pictureBox10.Size = new System.Drawing.Size(10, 24);
		this.pictureBox10.TabIndex = 3;
		this.pictureBox10.TabStop = false;
		// 
		// label11
		// 
		this.label11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Location = new System.Drawing.Point(269, 86);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(51, 20);
		this.label11.TabIndex = 2;
		this.label11.Text = "科室：";
		// 
		// label7
		// 
		this.label7.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Location = new System.Drawing.Point(269, 47);
		this.label7.Name = "label7";
		this.label7.Size = new System.Drawing.Size(65, 20);
		this.label7.TabIndex = 2;
		this.label7.Text = "病案号：";
		// 
		// lbsickroom
		// 
		this.lbsickroom.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lbsickroom.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbsickroom.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbsickroom.Location = new System.Drawing.Point(610, 47);
		this.lbsickroom.Name = "lbsickroom";
		this.lbsickroom.Size = new System.Drawing.Size(33, 20);
		this.lbsickroom.TabIndex = 2;
		this.lbsickroom.Text = "000";
		// 
		// lbpartment
		// 
		this.lbpartment.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lbpartment.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbpartment.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbpartment.Location = new System.Drawing.Point(340, 86);
		this.lbpartment.Name = "lbpartment";
		this.lbpartment.Size = new System.Drawing.Size(33, 20);
		this.lbpartment.TabIndex = 2;
		this.lbpartment.Text = "000";
		// 
		// lb_ilnessid
		// 
		this.lb_ilnessid.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_ilnessid.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_ilnessid.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_ilnessid.Location = new System.Drawing.Point(340, 47);
		this.lb_ilnessid.Name = "lb_ilnessid";
		this.lb_ilnessid.Size = new System.Drawing.Size(33, 20);
		this.lb_ilnessid.TabIndex = 2;
		this.lb_ilnessid.Text = "000";
		// 
		// label15
		// 
		this.label15.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label15.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Location = new System.Drawing.Point(16, 126);
		this.label15.Name = "label15";
		this.label15.Size = new System.Drawing.Size(79, 20);
		this.label15.TabIndex = 2;
		this.label15.Text = "术前诊断：";
		// 
		// sex
		// 
		this.sex.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.sex.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.sex.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.sex.Location = new System.Drawing.Point(82, 86);
		this.sex.Name = "sex";
		this.sex.Size = new System.Drawing.Size(17, 20);
		this.sex.TabIndex = 2;
		this.sex.Text = "0";
		// 
		// label13
		// 
		this.label13.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label13.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Location = new System.Drawing.Point(479, 47);
		this.label13.Name = "label13";
		this.label13.Size = new System.Drawing.Size(79, 20);
		this.label13.TabIndex = 2;
		this.label13.Text = "病区床号：";
		// 
		// lbname
		// 
		this.lbname.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lbname.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbname.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbname.Location = new System.Drawing.Point(78, 47);
		this.lbname.Name = "lbname";
		this.lbname.Size = new System.Drawing.Size(33, 20);
		this.lbname.TabIndex = 2;
		this.lbname.Text = "000";
		// 
		// label9
		// 
		this.label9.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label9.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Location = new System.Drawing.Point(16, 86);
		this.label9.Name = "label9";
		this.label9.Size = new System.Drawing.Size(51, 20);
		this.label9.TabIndex = 2;
		this.label9.Text = "性别：";
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Location = new System.Drawing.Point(16, 47);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(51, 20);
		this.label5.TabIndex = 2;
		this.label5.Text = "姓名：";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(179)))), ((int)(((byte)(201)))), ((int)(((byte)(122)))));
		this.label2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(179)))), ((int)(((byte)(201)))), ((int)(((byte)(122)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Location = new System.Drawing.Point(12, 8);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(151, 22);
		this.label2.TabIndex = 1;
		this.label2.Text = "    患者基本信息  :  ";
		// 
		// panel2
		// 
		this.panel2.Controls.Add(this.txb_special_infection);
		this.panel2.Controls.Add(this.txt_remarks);
		this.panel2.Controls.Add(this.cmb_BH_blood);
		this.panel2.Controls.Add(this.cmb_tuberculosis);
		this.panel2.Controls.Add(this.cmb_HIV);
		this.panel2.Controls.Add(this.cmb_syphilis);
		this.panel2.Controls.Add(this.cmb_hepatitisC);
		this.panel2.Controls.Add(this.cmb_hepatitisB);
		this.panel2.Controls.Add(this.cmb_narcosis_way);
		this.panel2.Controls.Add(this.cmb_cut_grade);
		this.panel2.Controls.Add(this.cmb_body_position);
		this.panel2.Controls.Add(this.cmb_position);
		this.panel2.Controls.Add(this.cmb_operation);
		this.panel2.Controls.Add(this.cmb_ss_grade);
		this.panel2.Controls.Add(this.cmb_ss_type);
		this.panel2.Controls.Add(this.dateTimePicker1);
		this.panel2.Controls.Add(this.pictureBox1);
		this.panel2.Controls.Add(this.label3);
		this.panel2.Controls.Add(this.label28);
		this.panel2.Controls.Add(this.label26);
		this.panel2.Controls.Add(this.label24);
		this.panel2.Controls.Add(this.label22);
		this.panel2.Controls.Add(this.label23);
		this.panel2.Controls.Add(this.label21);
		this.panel2.Controls.Add(this.label20);
		this.panel2.Controls.Add(this.label19);
		this.panel2.Controls.Add(this.label16);
		this.panel2.Controls.Add(this.label10);
		this.panel2.Controls.Add(this.label12);
		this.panel2.Controls.Add(this.label8);
		this.panel2.Controls.Add(this.label18);
		this.panel2.Controls.Add(this.label6);
		this.panel2.Controls.Add(this.label4);
		this.panel2.Controls.Add(this.label17);
		this.panel2.Location = new System.Drawing.Point(27, 301);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(834, 380);
		this.panel2.TabIndex = 5;
		// 
		// txb_special_infection
		// 
		this.txb_special_infection.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txb_special_infection.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_special_infection.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txb_special_infection.Location = new System.Drawing.Point(396, 270);
		this.txb_special_infection.Multiline = true;
		this.txb_special_infection.Name = "txb_special_infection";
		this.txb_special_infection.Size = new System.Drawing.Size(218, 42);
		this.txb_special_infection.TabIndex = 15;
		// 
		// txt_remarks
		// 
		this.txt_remarks.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txt_remarks.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txt_remarks.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txt_remarks.Location = new System.Drawing.Point(97, 328);
		this.txt_remarks.Multiline = true;
		this.txt_remarks.Name = "txt_remarks";
		this.txt_remarks.Size = new System.Drawing.Size(430, 37);
		this.txt_remarks.TabIndex = 16;
		// 
		// cmb_BH_blood
		// 
		this.cmb_BH_blood.FormattingEnabled = true;
		this.cmb_BH_blood.Items.AddRange(new Object[] {"阳性", "阴性"});
		this.cmb_BH_blood.Location = new System.Drawing.Point(97, 280);
		this.cmb_BH_blood.Name = "cmb_BH_blood";
		this.cmb_BH_blood.Size = new System.Drawing.Size(61, 20);
		this.cmb_BH_blood.TabIndex = 14;
		// 
		// cmb_tuberculosis
		// 
		this.cmb_tuberculosis.FormattingEnabled = true;
		this.cmb_tuberculosis.Items.AddRange(new Object[] {"阳性", "阴性"});
		this.cmb_tuberculosis.Location = new System.Drawing.Point(700, 226);
		this.cmb_tuberculosis.Name = "cmb_tuberculosis";
		this.cmb_tuberculosis.Size = new System.Drawing.Size(61, 20);
		this.cmb_tuberculosis.TabIndex = 13;
		// 
		// cmb_HIV
		// 
		this.cmb_HIV.FormattingEnabled = true;
		this.cmb_HIV.Items.AddRange(new Object[] {"阳性", "阴性"});
		this.cmb_HIV.Location = new System.Drawing.Point(550, 226);
		this.cmb_HIV.Name = "cmb_HIV";
		this.cmb_HIV.Size = new System.Drawing.Size(61, 20);
		this.cmb_HIV.TabIndex = 12;
		// 
		// cmb_syphilis
		// 
		this.cmb_syphilis.FormattingEnabled = true;
		this.cmb_syphilis.Items.AddRange(new Object[] {"阳性", "阴性"});
		this.cmb_syphilis.Location = new System.Drawing.Point(396, 226);
		this.cmb_syphilis.Name = "cmb_syphilis";
		this.cmb_syphilis.Size = new System.Drawing.Size(61, 20);
		this.cmb_syphilis.TabIndex = 11;
		// 
		// cmb_hepatitisC
		// 
		this.cmb_hepatitisC.FormattingEnabled = true;
		this.cmb_hepatitisC.Items.AddRange(new Object[] {"阳性", "阴性"});
		this.cmb_hepatitisC.Location = new System.Drawing.Point(254, 226);
		this.cmb_hepatitisC.Name = "cmb_hepatitisC";
		this.cmb_hepatitisC.Size = new System.Drawing.Size(61, 20);
		this.cmb_hepatitisC.TabIndex = 10;
		// 
		// cmb_hepatitisB
		// 
		this.cmb_hepatitisB.FormattingEnabled = true;
		this.cmb_hepatitisB.Items.AddRange(new Object[] {"阳性", "阴性"});
		this.cmb_hepatitisB.Location = new System.Drawing.Point(101, 226);
		this.cmb_hepatitisB.Name = "cmb_hepatitisB";
		this.cmb_hepatitisB.Size = new System.Drawing.Size(61, 20);
		this.cmb_hepatitisB.TabIndex = 9;
		// 
		// cmb_narcosis_way
		// 
		this.cmb_narcosis_way.FormattingEnabled = true;
		this.cmb_narcosis_way.Items.AddRange(new Object[] {"一级", "二级", "三级", "特级"});
		this.cmb_narcosis_way.Location = new System.Drawing.Point(97, 174);
		this.cmb_narcosis_way.Name = "cmb_narcosis_way";
		this.cmb_narcosis_way.Size = new System.Drawing.Size(121, 20);
		this.cmb_narcosis_way.TabIndex = 9;
		// 
		// cmb_cut_grade
		// 
		this.cmb_cut_grade.FormattingEnabled = true;
		this.cmb_cut_grade.Items.AddRange(new Object[] {"Ⅰ", "Ⅱ", "Ⅲ"});
		this.cmb_cut_grade.Location = new System.Drawing.Point(627, 126);
		this.cmb_cut_grade.Name = "cmb_cut_grade";
		this.cmb_cut_grade.Size = new System.Drawing.Size(121, 20);
		this.cmb_cut_grade.TabIndex = 9;
		// 
		// cmb_body_position
		// 
		this.cmb_body_position.FormattingEnabled = true;
		this.cmb_body_position.Items.AddRange(new Object[] {"仰卧位", "侧卧位", "俯卧位", "膀胱截石位", "坐位"});
		this.cmb_body_position.Location = new System.Drawing.Point(412, 126);
		this.cmb_body_position.Name = "cmb_body_position";
		this.cmb_body_position.Size = new System.Drawing.Size(79, 20);
		this.cmb_body_position.TabIndex = 9;
		// 
		// cmb_position
		// 
		this.cmb_position.FormattingEnabled = true;
		this.cmb_position.Items.AddRange(new Object[] {"头部", "眼部", "心脏", "上肢", "下肢", "手指", "足指", "生殖器官", "植皮术", "肾脏", "肝脏", "胃部", "肺部", "脾脏", "胰脏", "胸腔", "脊椎"});
		this.cmb_position.Location = new System.Drawing.Point(271, 126);
		this.cmb_position.Name = "cmb_position";
		this.cmb_position.Size = new System.Drawing.Size(79, 20);
		this.cmb_position.TabIndex = 8;
		// 
		// cmb_operation
		// 
		this.cmb_operation.FormattingEnabled = true;
		this.cmb_operation.Items.AddRange(new Object[] {"第⼀次单纯阑尾⼿术", "第⼀次单纯疝修补术", "体表肿瘤、异物摘除术", "痔核、痔瘘⼿术", "体表脓肿切开引流术", "肝脓肿切开引流术", "肠切除术", "胃肠穿孔修补术", "胃肠造⼝术、吻合术", "⼤隐静脉结扎转流术及剔除术", "胆囊单纯造⼝术", "乳腺单纯切除术", "⽿腮裂瘘管切除术", "⿐中隔矫正术", "⿎膜置管术", "⿐息⾁摘除术", "⿐中隔软⾻取⾻术", "上颌窦根治术", "⽓管切开术", "扁桃体切除术", "腺样体刮除术", "⾷道异物取出术", "⽀撑喉镜下喉部肿物摘除术", "部分断⽿再植术", "乳突改良根治术", "⿐部分缺损修复术", "筛前动脉结扎术", "经⿐内镜⿐窦⼿术", "喉良性肿瘤切除术", "喉裂开声带切除术", "⽓管、⽀⽓管异物取出术", "⿎室成形术", "各种⿐窦内窥镜⼿术", "⿐内脑膜脑膨出颅底修补术", "电⼦⽿蜗植⼊术", "喉全切除术", "喉功能重建术", "喉次全切除术", "3/4喉切除术及喉功能重建术", "垂直半喉切除术及喉功能重建术", "声门上⽔平喉切除术", "经⿐内镜眶减压术", "⿐咽纤维⾎管瘤摘除术", "⿐侧切开术", "颈淋巴结清扫术", "听⾻链重建术", "悬雍垂腭咽成形术", "", "⾯神经减压术、移植术、吻合术", "听神经瘤切除术", "下颌骨切除术", "上颌⾻切除术", "中⽿癌根治术", "喉颈段⽓管狭窄成形术", "⿐内镜下垂体瘤切除术", "经⽪选择性静脉造影术", "经⽪静脉内溶栓术", "经皮选择性动脉造影术（不含脑及冠脉）", "经⽪选择性动脉置管术（包括各种药物治疗、栓塞）", "经皮静脉内滤⽹置⼊术", "经⽪超选择性动脉造影术", "⼼内电⽣理检查", "临时起搏器植⼊术", "经⽪静脉内⽀架置⼊术", "经⽪动脉⽀架置⼊术（包括肢体动脉、颈动脉、肾功脉）", "经皮动脉激光成形+球囊扩张术", "经⽪瓣膜球囊成形术（包括⼆尖瓣、三尖瓣、主动脉瓣、肺动脉瓣膜成形术、房间隔⼿", "剥术）", "经⽪⼼内膜⼼肌活检术（不含病理诊断及其它特殊检查）", "先⼼性介⼊治疗（包括动脉导管未闭、房间隔缺损）", "冠状动脉造影术", "经⽪冠状动脉内溶栓术", "射频消融术（不包括房颤）", "永久起搏器置⼊术（不包括 ICD）", "经皮⼤动脉⽀架植⼊术（包括腹主动脉、假性动脉瘤）", "经⽪冠状动脉腔内成形术（PTCA）", "经⽪冠状动脉内⽀架置⼊术（STENT）", "经⽪冠状动脉腔内激光成形术", "冠状动脉内膜旋磨术", "定向冠脉内膜旋磨术", "冠脉⾎管内超声检查术（IVUS）", "冠脉⾎管内冠镜检查术", "先⼼病室间隔缺损介⼊封堵术", "房颤射频消融术", "永久起搏器（ICD）置⼊术"});
		this.cmb_operation.Location = new System.Drawing.Point(97, 126);
		this.cmb_operation.Name = "cmb_operation";
		this.cmb_operation.Size = new System.Drawing.Size(121, 20);
		this.cmb_operation.TabIndex = 7;
		// 
		// cmb_ss_grade
		// 
		this.cmb_ss_grade.FormattingEnabled = true;
		this.cmb_ss_grade.Items.AddRange(new Object[] {"一级", "二级", "三级", "特级"});
		this.cmb_ss_grade.Location = new System.Drawing.Point(627, 71);
		this.cmb_ss_grade.Name = "cmb_ss_grade";
		this.cmb_ss_grade.Size = new System.Drawing.Size(121, 20);
		this.cmb_ss_grade.TabIndex = 6;
		// 
		// cmb_ss_type
		// 
		this.cmb_ss_type.FormattingEnabled = true;
		this.cmb_ss_type.Items.AddRange(new Object[] {"普通外科手术", "妇科手术", "眼科手术", "耳鼻喉科手术"});
		this.cmb_ss_type.Location = new System.Drawing.Point(412, 71);
		this.cmb_ss_type.Name = "cmb_ss_type";
		this.cmb_ss_type.Size = new System.Drawing.Size(121, 20);
		this.cmb_ss_type.TabIndex = 6;
		// 
		// dateTimePicker1
		// 
		this.dateTimePicker1.Location = new System.Drawing.Point(124, 72);
		this.dateTimePicker1.Name = "dateTimePicker1";
		this.dateTimePicker1.Size = new System.Drawing.Size(124, 21);
		this.dateTimePicker1.TabIndex = 5;
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(12, 20);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(10, 24);
		this.pictureBox1.TabIndex = 4;
		this.pictureBox1.TabStop = false;
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(179)))), ((int)(((byte)(201)))), ((int)(((byte)(122)))));
		this.label3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(179)))), ((int)(((byte)(201)))), ((int)(((byte)(122)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Location = new System.Drawing.Point(12, 22);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(183, 22);
		this.label3.TabIndex = 1;
		this.label3.Text = "    填写手术申请信息  :  ";
		// 
		// label28
		// 
		this.label28.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label28.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label28.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label28.Location = new System.Drawing.Point(629, 226);
		this.label28.Name = "label28";
		this.label28.Size = new System.Drawing.Size(65, 20);
		this.label28.TabIndex = 2;
		this.label28.Text = "肺结核：";
		// 
		// label26
		// 
		this.label26.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label26.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label26.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label26.Location = new System.Drawing.Point(483, 226);
		this.label26.Name = "label26";
		this.label26.Size = new System.Drawing.Size(75, 20);
		this.label26.TabIndex = 2;
		this.label26.Text = "HIV标志：";
		// 
		// label24
		// 
		this.label24.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label24.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.Location = new System.Drawing.Point(326, 226);
		this.label24.Name = "label24";
		this.label24.Size = new System.Drawing.Size(79, 20);
		this.label24.TabIndex = 2;
		this.label24.Text = "梅毒标志：";
		// 
		// label22
		// 
		this.label22.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.Location = new System.Drawing.Point(169, 226);
		this.label22.Name = "label22";
		this.label22.Size = new System.Drawing.Size(79, 20);
		this.label22.TabIndex = 2;
		this.label22.Text = "丙肝标志：";
		// 
		// label23
		// 
		this.label23.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label23.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.Location = new System.Drawing.Point(20, 328);
		this.label23.Name = "label23";
		this.label23.Size = new System.Drawing.Size(51, 20);
		this.label23.TabIndex = 2;
		this.label23.Text = "备注：";
		// 
		// label21
		// 
		this.label21.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label21.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label21.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label21.Location = new System.Drawing.Point(20, 277);
		this.label21.Name = "label21";
		this.label21.Size = new System.Drawing.Size(57, 20);
		this.label21.TabIndex = 2;
		this.label21.Text = "RH血型";
		// 
		// label20
		// 
		this.label20.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label20.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Location = new System.Drawing.Point(328, 277);
		this.label20.Name = "label20";
		this.label20.Size = new System.Drawing.Size(65, 20);
		this.label20.TabIndex = 2;
		this.label20.Text = "特殊感染";
		// 
		// label19
		// 
		this.label19.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Location = new System.Drawing.Point(16, 226);
		this.label19.Name = "label19";
		this.label19.Size = new System.Drawing.Size(79, 20);
		this.label19.TabIndex = 2;
		this.label19.Text = "乙肝标志：";
		// 
		// label16
		// 
		this.label16.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label16.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Location = new System.Drawing.Point(546, 126);
		this.label16.Name = "label16";
		this.label16.Size = new System.Drawing.Size(65, 20);
		this.label16.TabIndex = 2;
		this.label16.Text = "切口等级";
		// 
		// label10
		// 
		this.label10.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Location = new System.Drawing.Point(546, 72);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(65, 20);
		this.label10.TabIndex = 2;
		this.label10.Text = "手术等级";
		// 
		// label12
		// 
		this.label12.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label12.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Location = new System.Drawing.Point(356, 126);
		this.label12.Name = "label12";
		this.label12.Size = new System.Drawing.Size(37, 20);
		this.label12.TabIndex = 2;
		this.label12.Text = "体位";
		// 
		// label8
		// 
		this.label8.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Location = new System.Drawing.Point(228, 126);
		this.label8.Name = "label8";
		this.label8.Size = new System.Drawing.Size(37, 20);
		this.label8.TabIndex = 2;
		this.label8.Text = "部位";
		// 
		// label18
		// 
		this.label18.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Location = new System.Drawing.Point(20, 174);
		this.label18.Name = "label18";
		this.label18.Size = new System.Drawing.Size(65, 20);
		this.label18.TabIndex = 2;
		this.label18.Text = "麻醉方法";
		// 
		// label6
		// 
		this.label6.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label6.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Location = new System.Drawing.Point(20, 126);
		this.label6.Name = "label6";
		this.label6.Size = new System.Drawing.Size(51, 20);
		this.label6.TabIndex = 2;
		this.label6.Text = "拟手术";
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Location = new System.Drawing.Point(340, 72);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(65, 20);
		this.label4.TabIndex = 2;
		this.label4.Text = "手术类型";
		// 
		// label17
		// 
		this.label17.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Location = new System.Drawing.Point(20, 74);
		this.label17.Name = "label17";
		this.label17.Size = new System.Drawing.Size(97, 20);
		this.label17.TabIndex = 2;
		this.label17.Text = "拟手术时间： ";
		// 
		// btnOK
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOK.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(65)))), ((int)(((byte)(141)))), ((int)(((byte)(109)))));
		this.btnOK.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(65)))), ((int)(((byte)(141)))), ((int)(((byte)(109)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOK.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOK.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOK.FlatAppearance.BorderSize = 0;
		this.btnOK.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOK.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOK.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOK.ForeColor = System.Drawing.SystemColors.Window;
		this.btnOK.Location = new System.Drawing.Point(649, 687);
		this.btnOK.Name = "btnOK";
		this.btnOK.Size = new System.Drawing.Size(94, 29);
		this.btnOK.TabIndex = 15;
		this.btnOK.Text = "审批通过";
		this.btnOK.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
		// 
		// btnClear
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnClear.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(65)))), ((int)(((byte)(141)))), ((int)(((byte)(109)))));
		this.btnClear.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(65)))), ((int)(((byte)(141)))), ((int)(((byte)(109)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnClear.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnClear.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnClear.FlatAppearance.BorderSize = 0;
		this.btnClear.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnClear.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnClear.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnClear.ForeColor = System.Drawing.SystemColors.Window;
		this.btnClear.Location = new System.Drawing.Point(151, 687);
		this.btnClear.Name = "btnClear";
		this.btnClear.Size = new System.Drawing.Size(94, 29);
		this.btnClear.TabIndex = 14;
		this.btnClear.Text = "打回";
		this.btnClear.UseVisualStyleBackColor = false;
		// 
		// Form_apply4
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(934, 756);
		this.Controls.Add(this.btnOK);
		this.Controls.Add(this.btnClear);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel1);
		this.Controls.Add(this.label1);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
		this.Name = "Form_apply4";
		this.Text = "Form_apply4";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_apply4_Load);
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).EndInit();
		this.panel2.ResumeLayout(false);
		this.panel2.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.PictureBox pictureBox6;
	private System.Windows.Forms.TextBox txbmessage;
	private System.Windows.Forms.PictureBox pictureBox10;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.Label label7;
	private System.Windows.Forms.Label lbsickroom;
	private System.Windows.Forms.Label lbpartment;
	private System.Windows.Forms.Label lb_ilnessid;
	private System.Windows.Forms.Label label15;
	private System.Windows.Forms.Label sex;
	private System.Windows.Forms.Label label13;
	private System.Windows.Forms.Label lbname;
	private System.Windows.Forms.Label label9;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.TextBox txb_special_infection;
	private System.Windows.Forms.TextBox txt_remarks;
	private System.Windows.Forms.ComboBox cmb_BH_blood;
	private System.Windows.Forms.ComboBox cmb_tuberculosis;
	private System.Windows.Forms.ComboBox cmb_HIV;
	private System.Windows.Forms.ComboBox cmb_syphilis;
	private System.Windows.Forms.ComboBox cmb_hepatitisC;
	private System.Windows.Forms.ComboBox cmb_hepatitisB;
	private System.Windows.Forms.ComboBox cmb_narcosis_way;
	private System.Windows.Forms.ComboBox cmb_cut_grade;
	private System.Windows.Forms.ComboBox cmb_body_position;
	private System.Windows.Forms.ComboBox cmb_position;
	private System.Windows.Forms.ComboBox cmb_operation;
	private System.Windows.Forms.ComboBox cmb_ss_grade;
	private System.Windows.Forms.ComboBox cmb_ss_type;
	private System.Windows.Forms.DateTimePicker dateTimePicker1;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label28;
	private System.Windows.Forms.Label label26;
	private System.Windows.Forms.Label label24;
	private System.Windows.Forms.Label label22;
	private System.Windows.Forms.Label label23;
	private System.Windows.Forms.Label label21;
	private System.Windows.Forms.Label label20;
	private System.Windows.Forms.Label label19;
	private System.Windows.Forms.Label label16;
	private System.Windows.Forms.Label label10;
	private System.Windows.Forms.Label label12;
	private System.Windows.Forms.Label label8;
	private System.Windows.Forms.Label label18;
	private System.Windows.Forms.Label label6;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label label17;
	private System.Windows.Forms.Button btnOK;
	private System.Windows.Forms.Button btnClear;
}