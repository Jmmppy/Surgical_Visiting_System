package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;

public class Form_arrage2 extends Form
{
	private cur_patient_table cur_patient_table_ = new cur_patient_table();
	private patient_table patient_table_ = new patient_table();
	private patient_tableBll patient_tableBll_ = new patient_tableBll();
	public Form_arrage2(cur_patient_table patient_)
	{
		InitializeComponent();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 显示信息
		this.lbname.Text = patient_.patient_name.toString();
		this.lb_ilnessid.Text = patient_.illness_id.toString();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 显示信息
		cur_patient_table_ = patient_;
	}

	private void Form_arrage2_Load(Object sender, tangible.EventArgs e)
	{
		patient_table_ = patient_tableBll_.getpatient_tableObject(cur_patient_table_.illness_id);
		this.txtnarcosis_name.Text = cur_patient_table_.narcosis_doc_name.toString();
		this.txtnarcosis_id.Text = patient_table_.narcosis_doc_id.toString();
		this.cmb_operationRoom.Text = patient_table_.operation_room.toString();

		this.txtnurtion_name.Text = cur_patient_table_.nurse_name.toString();
		this.txtnurtion_id.Text = patient_table_.nurse_id.toString();

	}

	private void label18_Click(Object sender, tangible.EventArgs e)
	{

	}

	private void btnOK_Click(Object sender, tangible.EventArgs e)
	{
		int narcosis_doc_id_1 = Integer.parseInt(this.txtnarcosis_id.Text.strip());
		int nurse_id_ = Integer.parseInt(this.txtnurtion_id.Text.strip());
		String room = this.cmb_operationRoom.Text.strip();
		patient_table patient_table_ = new patient_table();
		patient_table_.setillness_id(cur_patient_table_.illness_id);
		patient_table_.setnarcosis_doc_id(narcosis_doc_id_1);
		patient_table_.setnurse_id(nurse_id_);
		patient_table_.setoperation_room(room);
		int row = patient_tableBll_.update_patient_table2(patient_table_);
		MessageBox.Show(String.format("修改成功")); //检测成功
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form_arrage2.class);
		this.panel1 = new System.Windows.Forms.Panel();
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
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.label3 = new System.Windows.Forms.Label();
		this.label10 = new System.Windows.Forms.Label();
		this.label18 = new System.Windows.Forms.Label();
		this.label19 = new System.Windows.Forms.Label();
		this.txtnarcosis_name = new System.Windows.Forms.TextBox();
		this.txtnarcosis_id = new System.Windows.Forms.TextBox();
		this.cmb_operationRoom = new System.Windows.Forms.ComboBox();
		this.label1 = new System.Windows.Forms.Label();
		this.txtnurtion_name = new System.Windows.Forms.TextBox();
		this.label4 = new System.Windows.Forms.Label();
		this.txtnurtion_id = new System.Windows.Forms.TextBox();
		this.btnOK = new System.Windows.Forms.Button();
		this.btnClear = new System.Windows.Forms.Button();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).BeginInit();
		this.panel2.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.SuspendLayout();
		// 
		// panel1
		// 
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
		this.panel1.Location = new System.Drawing.Point(3, 53);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(819, 191);
		this.panel1.TabIndex = 4;
		// 
		// txbmessage
		// 
		this.txbmessage.BorderStyle = System.Windows.Forms.BorderStyle.None;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage.Location = new System.Drawing.Point(90, 125);
		this.txbmessage.Multiline = true;
		this.txbmessage.Name = "txbmessage";
		this.txbmessage.Size = new System.Drawing.Size(417, 53);
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
		this.label11.Location = new System.Drawing.Point(269, 102);
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
		this.label7.Location = new System.Drawing.Point(269, 63);
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
		this.lbsickroom.Location = new System.Drawing.Point(610, 63);
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
		this.lbpartment.Location = new System.Drawing.Point(340, 102);
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
		this.lb_ilnessid.Location = new System.Drawing.Point(340, 63);
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
		this.label15.Location = new System.Drawing.Point(16, 142);
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
		this.sex.Location = new System.Drawing.Point(82, 102);
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
		this.label13.Location = new System.Drawing.Point(479, 63);
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
		this.lbname.Location = new System.Drawing.Point(78, 63);
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
		this.label9.Location = new System.Drawing.Point(16, 102);
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
		this.label5.Location = new System.Drawing.Point(16, 63);
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
		this.label2.Location = new System.Drawing.Point(12, 24);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(151, 22);
		this.label2.TabIndex = 1;
		this.label2.Text = "    患者基本信息  :  ";
		// 
		// panel2
		// 
		this.panel2.Controls.Add(this.label4);
		this.panel2.Controls.Add(this.label1);
		this.panel2.Controls.Add(this.cmb_operationRoom);
		this.panel2.Controls.Add(this.txtnurtion_id);
		this.panel2.Controls.Add(this.txtnarcosis_id);
		this.panel2.Controls.Add(this.txtnurtion_name);
		this.panel2.Controls.Add(this.txtnarcosis_name);
		this.panel2.Controls.Add(this.pictureBox1);
		this.panel2.Controls.Add(this.label3);
		this.panel2.Controls.Add(this.label10);
		this.panel2.Controls.Add(this.label18);
		this.panel2.Controls.Add(this.label19);
		this.panel2.Location = new System.Drawing.Point(3, 269);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(819, 191);
		this.panel2.TabIndex = 4;
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(12, 22);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(10, 24);
		this.pictureBox1.TabIndex = 3;
		this.pictureBox1.TabStop = false;
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Location = new System.Drawing.Point(269, 63);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(93, 20);
		this.label3.TabIndex = 2;
		this.label3.Text = "访视医师号：";
		// 
		// label10
		// 
		this.label10.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Location = new System.Drawing.Point(542, 63);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(65, 20);
		this.label10.TabIndex = 2;
		this.label10.Text = "手术台：";
		// 
		// label18
		// 
		this.label18.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Location = new System.Drawing.Point(16, 63);
		this.label18.Name = "label18";
		this.label18.Size = new System.Drawing.Size(107, 20);
		this.label18.TabIndex = 2;
		this.label18.Text = "访视医师姓名：";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.label18.Click += new System.EventHandler(this.label18_Click);
		// 
		// label19
		// 
		this.label19.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(179)))), ((int)(((byte)(201)))), ((int)(((byte)(122)))));
		this.label19.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(179)))), ((int)(((byte)(201)))), ((int)(((byte)(122)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Location = new System.Drawing.Point(12, 24);
		this.label19.Name = "label19";
		this.label19.Size = new System.Drawing.Size(151, 22);
		this.label19.TabIndex = 1;
		this.label19.Text = "    手术排班信息  :  ";
		// 
		// txtnarcosis_name
		// 
		this.txtnarcosis_name.Location = new System.Drawing.Point(129, 63);
		this.txtnarcosis_name.Name = "txtnarcosis_name";
		this.txtnarcosis_name.Size = new System.Drawing.Size(100, 21);
		this.txtnarcosis_name.TabIndex = 5;
		// 
		// txtnarcosis_id
		// 
		this.txtnarcosis_id.Location = new System.Drawing.Point(368, 62);
		this.txtnarcosis_id.Name = "txtnarcosis_id";
		this.txtnarcosis_id.Size = new System.Drawing.Size(100, 21);
		this.txtnarcosis_id.TabIndex = 5;
		// 
		// cmb_operationRoom
		// 
		this.cmb_operationRoom.FormattingEnabled = true;
		this.cmb_operationRoom.Items.AddRange(new Object[] {"A1", "A2", "A3", "A4", "A5"});
		this.cmb_operationRoom.Location = new System.Drawing.Point(601, 63);
		this.cmb_operationRoom.Name = "cmb_operationRoom";
		this.cmb_operationRoom.Size = new System.Drawing.Size(121, 20);
		this.cmb_operationRoom.TabIndex = 7;
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Location = new System.Drawing.Point(16, 105);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(93, 20);
		this.label1.TabIndex = 8;
		this.label1.Text = "护士医师名：";
		// 
		// txtnurtion_name
		// 
		this.txtnurtion_name.Location = new System.Drawing.Point(129, 108);
		this.txtnurtion_name.Name = "txtnurtion_name";
		this.txtnurtion_name.Size = new System.Drawing.Size(100, 21);
		this.txtnurtion_name.TabIndex = 5;
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Location = new System.Drawing.Point(275, 106);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(65, 20);
		this.label4.TabIndex = 9;
		this.label4.Text = "护士号：";
		// 
		// txtnurtion_id
		// 
		this.txtnurtion_id.Location = new System.Drawing.Point(368, 105);
		this.txtnurtion_id.Name = "txtnurtion_id";
		this.txtnurtion_id.Size = new System.Drawing.Size(100, 21);
		this.txtnurtion_id.TabIndex = 5;
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
		this.btnOK.Location = new System.Drawing.Point(652, 602);
		this.btnOK.Name = "btnOK";
		this.btnOK.Size = new System.Drawing.Size(94, 29);
		this.btnOK.TabIndex = 14;
		this.btnOK.Text = "提交";
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
		this.btnClear.Location = new System.Drawing.Point(132, 602);
		this.btnClear.Name = "btnClear";
		this.btnClear.Size = new System.Drawing.Size(94, 29);
		this.btnClear.TabIndex = 15;
		this.btnClear.Text = "取消";
		this.btnClear.UseVisualStyleBackColor = false;
		// 
		// Form_arrage2
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.Control;
		this.ClientSize = new System.Drawing.Size(834, 696);
		this.Controls.Add(this.btnClear);
		this.Controls.Add(this.btnOK);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel1);
		this.Name = "Form_arrage2";
		this.Text = "Form_arrage2";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_arrage2_Load);
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).EndInit();
		this.panel2.ResumeLayout(false);
		this.panel2.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Panel panel1;
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
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label10;
	private System.Windows.Forms.Label label18;
	private System.Windows.Forms.Label label19;
	private System.Windows.Forms.TextBox txtnarcosis_id;
	private System.Windows.Forms.TextBox txtnarcosis_name;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.ComboBox cmb_operationRoom;
	private System.Windows.Forms.TextBox txtnurtion_id;
	private System.Windows.Forms.TextBox txtnurtion_name;
	private System.Windows.Forms.Button btnOK;
	private System.Windows.Forms.Button btnClear;
}