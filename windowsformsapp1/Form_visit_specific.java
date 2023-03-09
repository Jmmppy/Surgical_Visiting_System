package windowsformsapp1;

import Models.*;
import BLL.*;
import ZXing.*;
import ZXing.Common.*;
import ZXing.QrCode.*;

public class Form_visit_specific extends Form
{
	private patient_tableBll patient_tableBll_ = new patient_tableBll();
	private ss_tableBll ss_tableBll_ = new ss_tableBll();
	private ss_visitTableBll ss_visitTableBll_ = new ss_visitTableBll();
	private patient_table patient_table_;
	private ss_table ss_table_;
	private cur_ss_visitTable cur_ss_visitTable_;
	private String cur_ilness_id;
	public Form_visit_specific(cur_ss_visitTable visit)
	{

		InitializeComponent();
		cur_ss_visitTable_ = visit;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 显示信息
		this.lbname.Text = visit.patient_name.toString();
		this.lb_ilnessid.Text = visit.illness_id.toString();
		this.pictureBox6.BackgroundImage = GetBarcodeBitmap(cur_ss_visitTable_.illness_id);
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 显示信息
	}

	private void label2_Click(Object sender, tangible.EventArgs e)
	{

	}

	private void txbmessage_TextChanged(Object sender, tangible.EventArgs e)
	{

	}

	private void Form_visit_specific_Load(Object sender, tangible.EventArgs e)
	{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 患者信息
		patient_table_ = patient_tableBll_.getpatient_tableObject(cur_ss_visitTable_.illness_id);
		this.lb_sex.Text = "男";
		this.lb_department.Text = patient_table_.age.toString();
		this.lb_sickroom.Text = patient_table_.sickroom.toString();
		this.txbmessage.Text = patient_table_.diagnosis.toString();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 手术申请
		int ss_Id = (int)patient_table_.ss_id;
		if (ss_Id != 0)
		{
			ss_table_ = ss_tableBll_.getss_tableObject2(ss_Id);
			this.lb_ss_time.Text = String.valueOf(ss_table_.ss_date);
			this.label42.Text = ss_table_.ss_type.toString();
			this.label43.Text = ss_table_.ss_grade.toString();
			this.label9.Text = ss_table_.operation_id.toString(); //////
			this.label11.Text = ss_table_.position.toString();
			this.label44.Text = ss_table_.body_position.toString();
			this.label45.Text = ss_table_.cut_grade.toString();
			this.label46.Text = ss_table_.narcosis_way.toString();
			this.label47.Text = ss_table_.special_infection.toString();
			this.label48.Text = ss_table_.remarks.toString();
			this.label20.Text = ss_table_.hepatitisB.toString();
			this.label21.Text = ss_table_.hepatitisC.toString();
			this.label23.Text = ss_table_.syphilis.toString();
			this.label25.Text = ss_table_.HIV.toString();
			this.label27.Text = ss_table_.tuberculosis.toString();
		}


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 手术排班
		this.label30.Text = "手术室A";
		this.label32.Text = patient_table_.operation_room.toString();
		this.label33.Text = patient_table_.doc_id.toString(); /////
		this.label35.Text = patient_table_.narcosis_doc_id.toString();
		this.label37.Text = patient_table_.nurse_id.toString();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion
	}

	private void label1_Click(Object sender, tangible.EventArgs e)
	{

	}

	private void panel5_Paint(Object sender, PaintEventArgs e)
	{

	}

	private void btnLogin_Click(Object sender, tangible.EventArgs e)
	{
		//// is_bool1 确保是否已经经过访视的确认
		/**更改is_bool1为true
		*/
		cur_ilness_id = cur_ss_visitTable_.illness_id;
		//bool cur_is_bool1 = true;
		ss_visitTable ss_Table = new ss_visitTable();
		ss_Table.setillness_id(cur_ilness_id);
		ss_Table.setis_bool1(true);
		int row = ss_visitTableBll_.update_ss_visitTable3(ss_Table);
		if (row == 1)
		{
			this.Close();
		}

	}

	private void button1_Click(Object sender, tangible.EventArgs e)
	{
		//// is_bool3 确保否已经经过访视的确认
		/**更改is_bool3为true
		*/
		cur_ilness_id = cur_ss_visitTable_.illness_id;
		//bool cur_is_bool1 = true;
		ss_visitTable ss_Table = new ss_visitTable();
		ss_Table.setillness_id(cur_ilness_id);
		ss_Table.setis_bool3(true);
		int row = ss_visitTableBll_.update_ss_visitTable4(ss_Table);
		if (row == 1)
		{
			this.Close();
		}
	}
	/** 
	 生成条形码
	 
	 @param barcodeContent 需要生成条码的内容
	 @param barcodeWidth 条码宽度
	 @param barcodeHeight 条码长度
	 @return 返回条码图形
	*/
	public static Bitmap GetBarcodeBitmap(String barcodeContent)
	{
		int barcodeWidth = 114;
		int barcodeHeight = 49;
		BarcodeWriter barcodeWriter = new BarcodeWriter();
		barcodeWriter.Format = BarcodeFormat.CODE_39; //设置编码格式
		EncodingOptions encodingOptions = new EncodingOptions();
		encodingOptions.Width = barcodeWidth; //设置宽度
		encodingOptions.Height = barcodeHeight; //设置长度
		encodingOptions.Margin = 2; //设置边距
		barcodeWriter.Options = encodingOptions;
		Bitmap bitmap = barcodeWriter.Write(barcodeContent);
		return bitmap;
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form_visit_specific.class);
		this.panel1 = new System.Windows.Forms.Panel();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		this.txbmessage = new System.Windows.Forms.TextBox();
		this.pictureBox10 = new System.Windows.Forms.PictureBox();
		this.lb_department11 = new System.Windows.Forms.Label();
		this.label7 = new System.Windows.Forms.Label();
		this.lb_sickroom = new System.Windows.Forms.Label();
		this.lb_department = new System.Windows.Forms.Label();
		this.lb_ilnessid = new System.Windows.Forms.Label();
		this.label15 = new System.Windows.Forms.Label();
		this.lb_sex = new System.Windows.Forms.Label();
		this.lb_sickroom11 = new System.Windows.Forms.Label();
		this.lbname = new System.Windows.Forms.Label();
		this.lb_sex11 = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.panel2 = new System.Windows.Forms.Panel();
		this.panel4 = new System.Windows.Forms.Panel();
		this.label26 = new System.Windows.Forms.Label();
		this.label20 = new System.Windows.Forms.Label();
		this.label21 = new System.Windows.Forms.Label();
		this.label19 = new System.Windows.Forms.Label();
		this.label23 = new System.Windows.Forms.Label();
		this.label22 = new System.Windows.Forms.Label();
		this.label25 = new System.Windows.Forms.Label();
		this.label24 = new System.Windows.Forms.Label();
		this.label27 = new System.Windows.Forms.Label();
		this.label28 = new System.Windows.Forms.Label();
		this.label41 = new System.Windows.Forms.Label();
		this.label40 = new System.Windows.Forms.Label();
		this.label39 = new System.Windows.Forms.Label();
		this.label18 = new System.Windows.Forms.Label();
		this.label16 = new System.Windows.Forms.Label();
		this.label12 = new System.Windows.Forms.Label();
		this.label8 = new System.Windows.Forms.Label();
		this.label10 = new System.Windows.Forms.Label();
		this.label6 = new System.Windows.Forms.Label();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.label48 = new System.Windows.Forms.Label();
		this.label11 = new System.Windows.Forms.Label();
		this.label9 = new System.Windows.Forms.Label();
		this.label47 = new System.Windows.Forms.Label();
		this.label46 = new System.Windows.Forms.Label();
		this.label45 = new System.Windows.Forms.Label();
		this.label44 = new System.Windows.Forms.Label();
		this.label43 = new System.Windows.Forms.Label();
		this.label42 = new System.Windows.Forms.Label();
		this.label3 = new System.Windows.Forms.Label();
		this.label17 = new System.Windows.Forms.Label();
		this.lb_ss_time = new System.Windows.Forms.Label();
		this.panel3 = new System.Windows.Forms.Panel();
		this.button1 = new System.Windows.Forms.Button();
		this.btnLogin = new System.Windows.Forms.Button();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.label4 = new System.Windows.Forms.Label();
		this.label31 = new System.Windows.Forms.Label();
		this.label38 = new System.Windows.Forms.Label();
		this.label36 = new System.Windows.Forms.Label();
		this.label37 = new System.Windows.Forms.Label();
		this.label34 = new System.Windows.Forms.Label();
		this.label35 = new System.Windows.Forms.Label();
		this.label29 = new System.Windows.Forms.Label();
		this.label33 = new System.Windows.Forms.Label();
		this.label32 = new System.Windows.Forms.Label();
		this.label30 = new System.Windows.Forms.Label();
		this.label1 = new System.Windows.Forms.Label();
		this.panel5 = new System.Windows.Forms.Panel();
		this.panel6 = new System.Windows.Forms.Panel();
		this.label13 = new System.Windows.Forms.Label();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).BeginInit();
		this.panel2.SuspendLayout();
		this.panel4.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.panel3.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		this.SuspendLayout();
		// 
		// panel1
		// 
		this.panel1.BackColor = System.Drawing.Color.White;
		this.panel1.Controls.Add(this.pictureBox6);
		this.panel1.Controls.Add(this.txbmessage);
		this.panel1.Controls.Add(this.pictureBox10);
		this.panel1.Controls.Add(this.lb_department11);
		this.panel1.Controls.Add(this.label7);
		this.panel1.Controls.Add(this.lb_sickroom);
		this.panel1.Controls.Add(this.lb_department);
		this.panel1.Controls.Add(this.lb_ilnessid);
		this.panel1.Controls.Add(this.label15);
		this.panel1.Controls.Add(this.lb_sex);
		this.panel1.Controls.Add(this.lb_sickroom11);
		this.panel1.Controls.Add(this.lbname);
		this.panel1.Controls.Add(this.lb_sex11);
		this.panel1.Controls.Add(this.label5);
		this.panel1.Controls.Add(this.label2);
		this.panel1.Location = new System.Drawing.Point(0, 80);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(662, 229);
		this.panel1.TabIndex = 0;
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(499, 34);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(114, 49);
		this.pictureBox6.TabIndex = 6;
		this.pictureBox6.TabStop = false;
		// 
		// txbmessage
		// 
		this.txbmessage.BorderStyle = System.Windows.Forms.BorderStyle.None;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage.Location = new System.Drawing.Point(86, 170);
		this.txbmessage.Multiline = true;
		this.txbmessage.Name = "txbmessage";
		this.txbmessage.Size = new System.Drawing.Size(417, 53);
		this.txbmessage.TabIndex = 4;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.txbmessage.TextChanged += new System.EventHandler(this.txbmessage_TextChanged);
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
		// lb_department11
		// 
		this.lb_department11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_department11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_department11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_department11.Location = new System.Drawing.Point(202, 102);
		this.lb_department11.Name = "lb_department11";
		this.lb_department11.Size = new System.Drawing.Size(51, 20);
		this.lb_department11.TabIndex = 2;
		this.lb_department11.Text = "年龄：";
		// 
		// label7
		// 
		this.label7.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Location = new System.Drawing.Point(202, 63);
		this.label7.Name = "label7";
		this.label7.Size = new System.Drawing.Size(65, 20);
		this.label7.TabIndex = 2;
		this.label7.Text = "病案号：";
		// 
		// lb_sickroom
		// 
		this.lb_sickroom.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_sickroom.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sickroom.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sickroom.Location = new System.Drawing.Point(101, 147);
		this.lb_sickroom.Name = "lb_sickroom";
		this.lb_sickroom.Size = new System.Drawing.Size(33, 20);
		this.lb_sickroom.TabIndex = 2;
		this.lb_sickroom.Text = "000";
		// 
		// lb_department
		// 
		this.lb_department.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_department.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_department.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_department.Location = new System.Drawing.Point(259, 102);
		this.lb_department.Name = "lb_department";
		this.lb_department.Size = new System.Drawing.Size(33, 20);
		this.lb_department.TabIndex = 2;
		this.lb_department.Text = "000";
		// 
		// lb_ilnessid
		// 
		this.lb_ilnessid.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_ilnessid.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_ilnessid.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_ilnessid.Location = new System.Drawing.Point(273, 63);
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
		this.label15.Location = new System.Drawing.Point(16, 182);
		this.label15.Name = "label15";
		this.label15.Size = new System.Drawing.Size(79, 20);
		this.label15.TabIndex = 2;
		this.label15.Text = "术前诊断：";
		// 
		// lb_sex
		// 
		this.lb_sex.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_sex.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sex.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sex.Location = new System.Drawing.Point(73, 102);
		this.lb_sex.Name = "lb_sex";
		this.lb_sex.Size = new System.Drawing.Size(17, 20);
		this.lb_sex.TabIndex = 2;
		this.lb_sex.Text = "0";
		// 
		// lb_sickroom11
		// 
		this.lb_sickroom11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_sickroom11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sickroom11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sickroom11.Location = new System.Drawing.Point(16, 147);
		this.lb_sickroom11.Name = "lb_sickroom11";
		this.lb_sickroom11.Size = new System.Drawing.Size(79, 20);
		this.lb_sickroom11.TabIndex = 2;
		this.lb_sickroom11.Text = "病区床号：";
		// 
		// lbname
		// 
		this.lbname.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lbname.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbname.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lbname.Location = new System.Drawing.Point(73, 63);
		this.lbname.Name = "lbname";
		this.lbname.Size = new System.Drawing.Size(33, 20);
		this.lbname.TabIndex = 2;
		this.lbname.Text = "000";
		// 
		// lb_sex11
		// 
		this.lb_sex11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_sex11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sex11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_sex11.Location = new System.Drawing.Point(16, 102);
		this.lb_sex11.Name = "lb_sex11";
		this.lb_sex11.Size = new System.Drawing.Size(51, 20);
		this.lb_sex11.TabIndex = 2;
		this.lb_sex11.Text = "性别：";
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
//ORIGINAL LINE: this.label2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
		this.label2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Location = new System.Drawing.Point(28, 24);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(151, 22);
		this.label2.TabIndex = 1;
		this.label2.Text = "    患者基本信息  :  ";
		// 
		// panel2
		// 
		this.panel2.BackColor = System.Drawing.Color.White;
		this.panel2.Controls.Add(this.panel4);
		this.panel2.Controls.Add(this.label41);
		this.panel2.Controls.Add(this.label40);
		this.panel2.Controls.Add(this.label39);
		this.panel2.Controls.Add(this.label18);
		this.panel2.Controls.Add(this.label16);
		this.panel2.Controls.Add(this.label12);
		this.panel2.Controls.Add(this.label8);
		this.panel2.Controls.Add(this.label10);
		this.panel2.Controls.Add(this.label6);
		this.panel2.Controls.Add(this.pictureBox1);
		this.panel2.Controls.Add(this.label48);
		this.panel2.Controls.Add(this.label11);
		this.panel2.Controls.Add(this.label9);
		this.panel2.Controls.Add(this.label47);
		this.panel2.Controls.Add(this.label46);
		this.panel2.Controls.Add(this.label45);
		this.panel2.Controls.Add(this.label44);
		this.panel2.Controls.Add(this.label43);
		this.panel2.Controls.Add(this.label42);
		this.panel2.Controls.Add(this.label3);
		this.panel2.Controls.Add(this.label17);
		this.panel2.Controls.Add(this.lb_ss_time);
		this.panel2.Location = new System.Drawing.Point(0, 309);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(662, 269);
		this.panel2.TabIndex = 0;
		// 
		// panel4
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(227)))), ((int)(((byte)(224)))), ((int)(((byte)(251)))));
		this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(227)))), ((int)(((byte)(224)))), ((int)(((byte)(251)))));
		this.panel4.Controls.Add(this.label26);
		this.panel4.Controls.Add(this.label20);
		this.panel4.Controls.Add(this.label21);
		this.panel4.Controls.Add(this.label19);
		this.panel4.Controls.Add(this.label23);
		this.panel4.Controls.Add(this.label22);
		this.panel4.Controls.Add(this.label25);
		this.panel4.Controls.Add(this.label24);
		this.panel4.Controls.Add(this.label27);
		this.panel4.Controls.Add(this.label28);
		this.panel4.Location = new System.Drawing.Point(0, 195);
		this.panel4.Name = "panel4";
		this.panel4.Size = new System.Drawing.Size(659, 71);
		this.panel4.TabIndex = 14;
		// 
		// label26
		// 
		this.label26.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label26.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label26.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label26.Location = new System.Drawing.Point(401, 4);
		this.label26.Name = "label26";
		this.label26.Size = new System.Drawing.Size(78, 19);
		this.label26.TabIndex = 2;
		this.label26.Text = "HIV标志：";
		// 
		// label20
		// 
		this.label20.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label20.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Location = new System.Drawing.Point(13, 28);
		this.label20.Name = "label20";
		this.label20.Size = new System.Drawing.Size(33, 20);
		this.label20.TabIndex = 2;
		this.label20.Text = "000";
		// 
		// label21
		// 
		this.label21.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label21.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label21.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label21.Location = new System.Drawing.Point(150, 28);
		this.label21.Name = "label21";
		this.label21.Size = new System.Drawing.Size(33, 20);
		this.label21.TabIndex = 2;
		this.label21.Text = "000";
		// 
		// label19
		// 
		this.label19.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Location = new System.Drawing.Point(8, 4);
		this.label19.Name = "label19";
		this.label19.Size = new System.Drawing.Size(79, 19);
		this.label19.TabIndex = 2;
		this.label19.Text = "乙肝标志：";
		// 
		// label23
		// 
		this.label23.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label23.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label23.Location = new System.Drawing.Point(278, 28);
		this.label23.Name = "label23";
		this.label23.Size = new System.Drawing.Size(33, 20);
		this.label23.TabIndex = 2;
		this.label23.Text = "000";
		// 
		// label22
		// 
		this.label22.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.Location = new System.Drawing.Point(147, 4);
		this.label22.Name = "label22";
		this.label22.Size = new System.Drawing.Size(79, 19);
		this.label22.TabIndex = 2;
		this.label22.Text = "丙肝标志：";
		// 
		// label25
		// 
		this.label25.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label25.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label25.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label25.Location = new System.Drawing.Point(405, 28);
		this.label25.Name = "label25";
		this.label25.Size = new System.Drawing.Size(33, 20);
		this.label25.TabIndex = 2;
		this.label25.Text = "000";
		// 
		// label24
		// 
		this.label24.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label24.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label24.Location = new System.Drawing.Point(277, 4);
		this.label24.Name = "label24";
		this.label24.Size = new System.Drawing.Size(79, 19);
		this.label24.TabIndex = 2;
		this.label24.Text = "梅毒标志：";
		// 
		// label27
		// 
		this.label27.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label27.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label27.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label27.Location = new System.Drawing.Point(529, 28);
		this.label27.Name = "label27";
		this.label27.Size = new System.Drawing.Size(33, 20);
		this.label27.TabIndex = 2;
		this.label27.Text = "000";
		// 
		// label28
		// 
		this.label28.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label28.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label28.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label28.Location = new System.Drawing.Point(525, 4);
		this.label28.Name = "label28";
		this.label28.Size = new System.Drawing.Size(65, 19);
		this.label28.TabIndex = 2;
		this.label28.Text = "肺结核：";
		// 
		// label41
		// 
		this.label41.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label41.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label41.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label41.Location = new System.Drawing.Point(16, 167);
		this.label41.Name = "label41";
		this.label41.Size = new System.Drawing.Size(51, 20);
		this.label41.TabIndex = 13;
		this.label41.Text = "备注：";
		// 
		// label40
		// 
		this.label40.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label40.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label40.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label40.Location = new System.Drawing.Point(451, 131);
		this.label40.Name = "label40";
		this.label40.Size = new System.Drawing.Size(68, 20);
		this.label40.TabIndex = 12;
		this.label40.Text = "特殊感染:";
		// 
		// label39
		// 
		this.label39.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label39.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label39.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label39.Location = new System.Drawing.Point(16, 131);
		this.label39.Name = "label39";
		this.label39.Size = new System.Drawing.Size(68, 20);
		this.label39.TabIndex = 11;
		this.label39.Text = "麻醉方法:";
		// 
		// label18
		// 
		this.label18.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Location = new System.Drawing.Point(449, 91);
		this.label18.Name = "label18";
		this.label18.Size = new System.Drawing.Size(68, 20);
		this.label18.TabIndex = 10;
		this.label18.Text = "切口等级:";
		// 
		// label16
		// 
		this.label16.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label16.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Location = new System.Drawing.Point(259, 131);
		this.label16.Name = "label16";
		this.label16.Size = new System.Drawing.Size(40, 20);
		this.label16.TabIndex = 9;
		this.label16.Text = "体位:";
		// 
		// label12
		// 
		this.label12.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label12.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Location = new System.Drawing.Point(261, 91);
		this.label12.Name = "label12";
		this.label12.Size = new System.Drawing.Size(40, 20);
		this.label12.TabIndex = 8;
		this.label12.Text = "部位:";
		// 
		// label8
		// 
		this.label8.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Location = new System.Drawing.Point(16, 91);
		this.label8.Name = "label8";
		this.label8.Size = new System.Drawing.Size(54, 20);
		this.label8.TabIndex = 7;
		this.label8.Text = "拟手术:";
		// 
		// label10
		// 
		this.label10.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Location = new System.Drawing.Point(450, 54);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(68, 20);
		this.label10.TabIndex = 6;
		this.label10.Text = "手术等级:";
		// 
		// label6
		// 
		this.label6.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label6.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Location = new System.Drawing.Point(260, 54);
		this.label6.Name = "label6";
		this.label6.Size = new System.Drawing.Size(68, 20);
		this.label6.TabIndex = 5;
		this.label6.Text = "手术类型:";
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(12, 13);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(10, 24);
		this.pictureBox1.TabIndex = 4;
		this.pictureBox1.TabStop = false;
		// 
		// label48
		// 
		this.label48.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label48.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label48.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label48.Location = new System.Drawing.Point(73, 167);
		this.label48.Name = "label48";
		this.label48.Size = new System.Drawing.Size(33, 20);
		this.label48.TabIndex = 2;
		this.label48.Text = "000";
		// 
		// label11
		// 
		this.label11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Location = new System.Drawing.Point(296, 91);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(33, 20);
		this.label11.TabIndex = 2;
		this.label11.Text = "000";
		// 
		// label9
		// 
		this.label9.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label9.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Location = new System.Drawing.Point(73, 91);
		this.label9.Name = "label9";
		this.label9.Size = new System.Drawing.Size(33, 20);
		this.label9.TabIndex = 2;
		this.label9.Text = "000";
		// 
		// label47
		// 
		this.label47.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label47.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label47.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label47.Location = new System.Drawing.Point(522, 131);
		this.label47.Name = "label47";
		this.label47.Size = new System.Drawing.Size(33, 20);
		this.label47.TabIndex = 2;
		this.label47.Text = "000";
		// 
		// label46
		// 
		this.label46.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label46.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label46.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label46.Location = new System.Drawing.Point(90, 131);
		this.label46.Name = "label46";
		this.label46.Size = new System.Drawing.Size(33, 20);
		this.label46.TabIndex = 2;
		this.label46.Text = "000";
		// 
		// label45
		// 
		this.label45.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label45.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label45.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label45.Location = new System.Drawing.Point(520, 91);
		this.label45.Name = "label45";
		this.label45.Size = new System.Drawing.Size(33, 20);
		this.label45.TabIndex = 2;
		this.label45.Text = "000";
		// 
		// label44
		// 
		this.label44.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label44.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label44.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label44.Location = new System.Drawing.Point(313, 131);
		this.label44.Name = "label44";
		this.label44.Size = new System.Drawing.Size(33, 20);
		this.label44.TabIndex = 2;
		this.label44.Text = "000";
		// 
		// label43
		// 
		this.label43.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label43.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label43.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label43.Location = new System.Drawing.Point(520, 54);
		this.label43.Name = "label43";
		this.label43.Size = new System.Drawing.Size(33, 20);
		this.label43.TabIndex = 2;
		this.label43.Text = "000";
		// 
		// label42
		// 
		this.label42.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label42.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label42.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label42.Location = new System.Drawing.Point(329, 54);
		this.label42.Name = "label42";
		this.label42.Size = new System.Drawing.Size(33, 20);
		this.label42.TabIndex = 2;
		this.label42.Text = "000";
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
		this.label3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Location = new System.Drawing.Point(28, 13);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(151, 22);
		this.label3.TabIndex = 1;
		this.label3.Text = "    手术申请信息  :  ";
		// 
		// label17
		// 
		this.label17.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Location = new System.Drawing.Point(16, 53);
		this.label17.Name = "label17";
		this.label17.Size = new System.Drawing.Size(97, 20);
		this.label17.TabIndex = 2;
		this.label17.Text = "拟手术时间： ";
		// 
		// lb_ss_time
		// 
		this.lb_ss_time.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lb_ss_time.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_ss_time.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lb_ss_time.Location = new System.Drawing.Point(108, 54);
		this.lb_ss_time.Name = "lb_ss_time";
		this.lb_ss_time.Size = new System.Drawing.Size(65, 20);
		this.lb_ss_time.TabIndex = 2;
		this.lb_ss_time.Text = "0000000";
		// 
		// panel3
		// 
		this.panel3.BackColor = System.Drawing.Color.White;
		this.panel3.Controls.Add(this.button1);
		this.panel3.Controls.Add(this.btnLogin);
		this.panel3.Controls.Add(this.pictureBox2);
		this.panel3.Controls.Add(this.label4);
		this.panel3.Controls.Add(this.label31);
		this.panel3.Controls.Add(this.label38);
		this.panel3.Controls.Add(this.label36);
		this.panel3.Controls.Add(this.label37);
		this.panel3.Controls.Add(this.label34);
		this.panel3.Controls.Add(this.label35);
		this.panel3.Controls.Add(this.label29);
		this.panel3.Controls.Add(this.label33);
		this.panel3.Controls.Add(this.label32);
		this.panel3.Controls.Add(this.label30);
		this.panel3.Location = new System.Drawing.Point(0, 572);
		this.panel3.Name = "panel3";
		this.panel3.Size = new System.Drawing.Size(662, 249);
		this.panel3.TabIndex = 0;
		// 
		// button1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.button1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button1.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button1.FlatAppearance.BorderSize = 0;
		this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.ForeColor = System.Drawing.SystemColors.Window;
		this.button1.Location = new System.Drawing.Point(94, 203);
		this.button1.Name = "button1";
		this.button1.Size = new System.Drawing.Size(94, 29);
		this.button1.TabIndex = 12;
		this.button1.Text = "有 误";
		this.button1.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.button1.Click += new System.EventHandler(this.button1_Click);
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
		this.btnLogin.Location = new System.Drawing.Point(499, 203);
		this.btnLogin.Name = "btnLogin";
		this.btnLogin.Size = new System.Drawing.Size(94, 29);
		this.btnLogin.TabIndex = 12;
		this.btnLogin.Text = "确 认";
		this.btnLogin.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox2.Location = new System.Drawing.Point(12, 20);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(10, 24);
		this.pictureBox2.TabIndex = 4;
		this.pictureBox2.TabStop = false;
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
		this.label4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(155)))), ((int)(((byte)(143)))), ((int)(((byte)(244)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Location = new System.Drawing.Point(28, 23);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(151, 22);
		this.label4.TabIndex = 1;
		this.label4.Text = "    手术安排信息  :  ";
		// 
		// label31
		// 
		this.label31.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label31.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label31.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label31.Location = new System.Drawing.Point(199, 75);
		this.label31.Name = "label31";
		this.label31.Size = new System.Drawing.Size(51, 20);
		this.label31.TabIndex = 2;
		this.label31.Text = "台次：";
		// 
		// label38
		// 
		this.label38.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label38.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label38.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label38.Location = new System.Drawing.Point(383, 128);
		this.label38.Name = "label38";
		this.label38.Size = new System.Drawing.Size(79, 20);
		this.label38.TabIndex = 2;
		this.label38.Text = "护理医师：";
		// 
		// label36
		// 
		this.label36.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label36.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label36.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label36.Location = new System.Drawing.Point(185, 128);
		this.label36.Name = "label36";
		this.label36.Size = new System.Drawing.Size(79, 20);
		this.label36.TabIndex = 2;
		this.label36.Text = "麻醉医师：";
		// 
		// label37
		// 
		this.label37.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label37.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label37.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label37.Location = new System.Drawing.Point(461, 128);
		this.label37.Name = "label37";
		this.label37.Size = new System.Drawing.Size(33, 20);
		this.label37.TabIndex = 2;
		this.label37.Text = "000";
		// 
		// label34
		// 
		this.label34.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label34.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label34.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label34.Location = new System.Drawing.Point(12, 128);
		this.label34.Name = "label34";
		this.label34.Size = new System.Drawing.Size(79, 20);
		this.label34.TabIndex = 2;
		this.label34.Text = "手术医师：";
		// 
		// label35
		// 
		this.label35.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label35.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label35.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label35.Location = new System.Drawing.Point(265, 128);
		this.label35.Name = "label35";
		this.label35.Size = new System.Drawing.Size(33, 20);
		this.label35.TabIndex = 2;
		this.label35.Text = "000";
		// 
		// label29
		// 
		this.label29.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label29.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label29.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label29.Location = new System.Drawing.Point(11, 75);
		this.label29.Name = "label29";
		this.label29.Size = new System.Drawing.Size(65, 20);
		this.label29.TabIndex = 2;
		this.label29.Text = "手术室：";
		// 
		// label33
		// 
		this.label33.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label33.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label33.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label33.Location = new System.Drawing.Point(90, 128);
		this.label33.Name = "label33";
		this.label33.Size = new System.Drawing.Size(33, 20);
		this.label33.TabIndex = 2;
		this.label33.Text = "000";
		// 
		// label32
		// 
		this.label32.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label32.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label32.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label32.Location = new System.Drawing.Point(270, 75);
		this.label32.Name = "label32";
		this.label32.Size = new System.Drawing.Size(33, 20);
		this.label32.TabIndex = 2;
		this.label32.Text = "000";
		// 
		// label30
		// 
		this.label30.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label30.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label30.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label30.Location = new System.Drawing.Point(82, 75);
		this.label30.Name = "label30";
		this.label30.Size = new System.Drawing.Size(33, 20);
		this.label30.TabIndex = 2;
		this.label30.Text = "000";
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label1.Location = new System.Drawing.Point(257, 23);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(132, 28);
		this.label1.TabIndex = 1;
		this.label1.Text = "患  者  信  息";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.label1.Click += new System.EventHandler(this.label1_Click);
		// 
		// panel5
		// 
		this.panel5.BackColor = System.Drawing.Color.White;
		this.panel5.Location = new System.Drawing.Point(33, 34);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(200, 3);
		this.panel5.TabIndex = 2;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel5.Paint += new System.Windows.Forms.PaintEventHandler(this.panel5_Paint);
		// 
		// panel6
		// 
		this.panel6.BackColor = System.Drawing.Color.White;
		this.panel6.Location = new System.Drawing.Point(413, 35);
		this.panel6.Name = "panel6";
		this.panel6.Size = new System.Drawing.Size(200, 3);
		this.panel6.TabIndex = 2;
		// 
		// label13
		// 
		this.label13.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label13.Font = new System.Drawing.Font("Rockwell", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label13.Font = new System.Drawing.Font("Rockwell", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
		this.label13.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label13.Location = new System.Drawing.Point(221, 48);
		this.label13.Name = "label13";
		this.label13.Size = new System.Drawing.Size(209, 25);
		this.label13.TabIndex = 1;
		this.label13.Text = "Patient information";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.label13.Click += new System.EventHandler(this.label1_Click);
		// 
		// Form_visit_specific
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.ClientSize = new System.Drawing.Size(657, 833);
		this.Controls.Add(this.panel6);
		this.Controls.Add(this.panel5);
		this.Controls.Add(this.label13);
		this.Controls.Add(this.label1);
		this.Controls.Add(this.panel3);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.panel1);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
		this.Name = "Form_visit_specific";
		this.ShowIcon = false;
		this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_visit_specific_Load);
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).EndInit();
		this.panel2.ResumeLayout(false);
		this.panel2.PerformLayout();
		this.panel4.ResumeLayout(false);
		this.panel4.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.panel3.ResumeLayout(false);
		this.panel3.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.Panel panel3;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.PictureBox pictureBox10;
	private System.Windows.Forms.Label lb_department11;
	private System.Windows.Forms.Label label7;
	private System.Windows.Forms.Label lb_sickroom;
	private System.Windows.Forms.Label lb_department;
	private System.Windows.Forms.Label lb_ilnessid;
	private System.Windows.Forms.Label label15;
	private System.Windows.Forms.Label lb_sex;
	private System.Windows.Forms.Label lb_sickroom11;
	private System.Windows.Forms.Label lbname;
	private System.Windows.Forms.Label lb_sex11;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.Label label28;
	private System.Windows.Forms.Label label26;
	private System.Windows.Forms.Label label27;
	private System.Windows.Forms.Label label24;
	private System.Windows.Forms.Label label25;
	private System.Windows.Forms.Label label22;
	private System.Windows.Forms.Label label23;
	private System.Windows.Forms.Label label19;
	private System.Windows.Forms.Label label21;
	private System.Windows.Forms.Label label17;
	private System.Windows.Forms.Label label20;
	private System.Windows.Forms.Label lb_ss_time;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.Label label31;
	private System.Windows.Forms.Label label38;
	private System.Windows.Forms.Label label36;
	private System.Windows.Forms.Label label37;
	private System.Windows.Forms.Label label34;
	private System.Windows.Forms.Label label35;
	private System.Windows.Forms.Label label29;
	private System.Windows.Forms.Label label33;
	private System.Windows.Forms.Label label32;
	private System.Windows.Forms.Label label30;
	private System.Windows.Forms.TextBox txbmessage;
	private System.Windows.Forms.Label label6;
	private System.Windows.Forms.Label label10;
	private System.Windows.Forms.Label label8;
	private System.Windows.Forms.Label label12;
	private System.Windows.Forms.Label label16;
	private System.Windows.Forms.Label label18;
	private System.Windows.Forms.Label label39;
	private System.Windows.Forms.Label label40;
	private System.Windows.Forms.Label label41;
	private System.Windows.Forms.Label label48;
	private System.Windows.Forms.Label label47;
	private System.Windows.Forms.Label label46;
	private System.Windows.Forms.Label label45;
	private System.Windows.Forms.Label label44;
	private System.Windows.Forms.Label label43;
	private System.Windows.Forms.Label label42;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.Label label9;
	private System.Windows.Forms.Panel panel4;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.Panel panel6;
	private System.Windows.Forms.Label label13;
	private System.Windows.Forms.PictureBox pictureBox6;
	private System.Windows.Forms.Button button1;
	private System.Windows.Forms.Button btnLogin;
}