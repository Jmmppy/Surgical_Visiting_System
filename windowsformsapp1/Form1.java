package windowsformsapp1;

import AForge.*;
import AForge.Controls.*;
import AForge.Video.*;
import AForge.Video.DirectShow.*;
import Models.*;
import BLL.*;
import Utility.*;
import java.time.*;

public class Form1 extends Form
{
	private meeting_table cur_meeting_Table;
	private ss_visitTableBll ss_visitTableBll_ = new ss_visitTableBll();
	private operation_tableBll operation_tableBll_ = new operation_tableBll();

	private FilterInfoCollection videoDevices; //摄像头设备集合
	private VideoCaptureDevice videoSource; //捕获设备源
	private Bitmap img; //拍照处理图片
	private Bitmap img22; //线程处理图片
	private boolean flag_time1 = false; //控制线程处理图片的原子性
	private int num1 = 0; // 记录语音违规次数
	private int num2 = 0; // 记录图片违规次数
	private SRecognition sr; //语音识别
	private ClassCheck check; //语音检测类
	private String vodice_txt; //语音文本
	private Cheak_isOk Cheak_isOk_ = new Cheak_isOk(); //语音文字检测类

	public Form1(meeting_table meeting_tab)
	{
		//meeting_table meeting_tab  /////////////////////
		InitializeComponent();
		////实例爬虫类，配置网址
		check = new ClassCheck();
		check.webBrowser = webBrowser1;
		check.SetUrl("https://www.book118.com/tool/sqjc/");

		//this.labName2.Text = Program.cur_LoginId
		cur_meeting_Table = meeting_tab;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 患者框
		int count = cur_meeting_Table.illness_id_count; //////////////////
		if (count == 1)
		{
			ss_visitTable ss_visitTable_ = ss_visitTableBll_.getss_visitTableObject(cur_meeting_Table.illness_id1);
			operation_table operation_table_ = operation_tableBll_.getOperation_tableObject(ss_visitTable_.operate_id);
			String ss = ss_visitTable_.patient_name.toString();
			char myChar = ss.charAt(0);
			this.label1.Text = String.valueOf(myChar);
			this.label5.Text = ss;
			this.label6.Text = operation_table_.operation_name.toString();
			this.label7.Text = String.valueOf(ss_visitTable_.start_time);
			this.panel3.Hide();
			this.panel4.Hide();
		}
		else if (count == 2)
		{
			ss_visitTable ss_visitTable_ = ss_visitTableBll_.getss_visitTableObject(cur_meeting_Table.illness_id1);
			operation_table operation_table_ = operation_tableBll_.getOperation_tableObject(ss_visitTable_.operate_id);
			String ss = ss_visitTable_.patient_name.toString();
			char myChar = ss.charAt(0);
			this.label1.Text = String.valueOf(myChar);
			this.label5.Text = ss;
			this.label6.Text = operation_table_.operation_name.toString();
			this.label7.Text = String.valueOf(ss_visitTable_.start_time);


			ss_visitTable ss_visitTable_2 = ss_visitTableBll_.getss_visitTableObject(cur_meeting_Table.illness_id2);
			operation_table operation_table_2 = operation_tableBll_.getOperation_tableObject(ss_visitTable_2.operate_id);
			String ss2 = ss_visitTable_2.patient_name.toString();
			char myChar2 = ss2.charAt(0);
			this.label14.Text = String.valueOf(myChar2);
			this.label12.Text = ss2;
			this.label11.Text = operation_table_2.operation_name.toString();
			this.label10.Text = String.valueOf(ss_visitTable_2.start_time);

			this.panel4.Hide();
		}
		else if (count == 3)
		{
			ss_visitTable ss_visitTable_ = ss_visitTableBll_.getss_visitTableObject(cur_meeting_Table.illness_id1);
			operation_table operation_table_ = operation_tableBll_.getOperation_tableObject(ss_visitTable_.operate_id);
			String ss = ss_visitTable_.patient_name.toString();
			char myChar = ss.charAt(0);
			this.label1.Text = String.valueOf(myChar);
			this.label5.Text = ss;
			this.label6.Text = operation_table_.operation_name.toString();
			this.label7.Text = String.valueOf(ss_visitTable_.start_time);


			ss_visitTable ss_visitTable_2 = ss_visitTableBll_.getss_visitTableObject(cur_meeting_Table.illness_id2);
			operation_table operation_table_2 = operation_tableBll_.getOperation_tableObject(ss_visitTable_2.operate_id);
			String ss2 = ss_visitTable_2.patient_name.toString();
			char myChar2 = ss2.charAt(0);
			this.label14.Text = String.valueOf(myChar2);
			this.label12.Text = ss2;
			this.label11.Text = operation_table_2.operation_name.toString();
			this.label10.Text = String.valueOf(ss_visitTable_2.start_time);

			ss_visitTable ss_visitTable_3 = ss_visitTableBll_.getss_visitTableObject(cur_meeting_Table.illness_id3);
			operation_table operation_table_3 = operation_tableBll_.getOperation_tableObject(ss_visitTable_3.operate_id);
			String ss3 = ss_visitTable_3.patient_name.toString();
			char myChar3 = ss3.charAt(0);
			this.label21.Text = String.valueOf(myChar3);

			this.label19.Text = ss3;
			this.label18.Text = operation_table_3.operation_name.toString();
			this.label17.Text = String.valueOf(ss_visitTable_3.start_time);

		}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion
	}


	public static native int mciSendString(String lpstrCommand, String lpstrReturnString, int uReturnLength, int hwndCallback);
	static
	{
		System.loadLibrary("winmm.dll");
	}

	private void Form1_Load(Object sender, tangible.EventArgs e)
	{
		//先检测电脑所有的摄像头
		videoDevices = new FilterInfoCollection(FilterCategory.VideoInputDevice);
		MessageBox.Show("检测到了" + videoDevices.size().toString() + "个摄像头！");
		//默认打开
		comboBox1.SelectedItem = "摄像头1";
		videoSource = new VideoCaptureDevice(videoDevices.get(0).MonikerString);
		//语音识别
		String[] fg = {"东方", "西方", "南方", "北方", "风骚", "诱人", "打开声音", "这里", "我", "又设置了", "每5秒", "进行", "一次", "可以", "完成", "实时的语音识别", "语音", "文字检测", "的"};
		sr = new SRecognition(fg);
		//button3.Enabled = false;


	}

	private void comboBox1_SelectedIndexChanged(Object sender, tangible.EventArgs e)
	{
		ShutCamera();
		if (comboBox1.Text.equals("摄像头1") && !videoDevices.isEmpty())
		{
			videoSource = new VideoCaptureDevice(videoDevices.get(0).MonikerString);
		}
		else if (comboBox1.Text.equals("摄像头2") && videoDevices.size() > 1)
		{
			videoSource = new VideoCaptureDevice(videoDevices.get(1).MonikerString);
		}
		else
		{
			MessageBox.Show("选择的摄像头不存在！！！");
			return;
		}
		videoSourcePlayer1.VideoSource = videoSource;
		videoSourcePlayer1.Start();

		button1.Enabled = true; //开启"拍摄功能”

	}

	/** 
	 // 关闭并释放摄像头
	*/
	public final void ShutCamera()
	{
		if (videoSourcePlayer1.VideoSource != null)
		{
			videoSourcePlayer1.SignalToStop();
			videoSourcePlayer1.WaitForStop();
			videoSourcePlayer1.VideoSource = null;
		}
	}

	private void Form1_FormClosing(Object sender, FormClosingEventArgs e)
	{
		ShutCamera();
	}

	private void button1_Click(Object sender, tangible.EventArgs e)
	{
		img = videoSourcePlayer1.GetCurrentVideoFrame(); //拍摄
		pictureBox1.Image = img;
		//图片处理--二维码识别
		Cheak_QRcode cheak_QRcode = new Cheak_QRcode();
		boolean ss = cheak_QRcode.Cheak_IF_QRcode(img);
		if (ss)
		{
			MessageBox.Show(String.format("存在二维码违规成功"));
			this.txbmessage2.Text = "存在二维码违规!!";
			//有二维码的图片显示
			this.pictureBox4.Visible = true;
			pictureBox4.Image = img;
			this.pictureBox4_panel9.BackColor = Color.Red; //////////////
			//保存图片：不做了
		}




		button2.Enabled = true; //开启"保存”功能
	}

	private void button2_Click(Object sender, tangible.EventArgs e)
	{
		try
		{
			//以当前时间为文件名，保存为jpg格式
			//图片路径在程序bin目录下的Debug下
			TimeSpan tss = LocalDateTime.UtcNow - LocalDateTime.of(1970, 1, 1, 0, 0, 0, 0);
			long a = FloatingPointToInteger.ToInt64(tss.TotalMilliseconds) / 1000; //以秒为单位
			img.Save(String.format("%1$s.jpg", String.valueOf(a)));
			MessageBox.Show("保存成功！");
			button2.Enabled = false;
		}
		catch (RuntimeException ex)
		{
			MessageBox.Show(ex.getMessage());
		}

	}

	private void panel1_Paint(Object sender, PaintEventArgs e)
	{

	}

	private void btnLogin_Click(Object sender, tangible.EventArgs e)
	{
		ShutCamera();
	}

	private void btnOn_Click(Object sender, tangible.EventArgs e)
	{
		mciSendString("set wave bitpersample 8", "", 0, 0);

		mciSendString("set wave samplespersec 20000", "", 0, 0);
		mciSendString("set wave channels 2", "", 0, 0);
		mciSendString("set wave format tag pcm", "", 0, 0);
		mciSendString("open new type WAVEAudio alias movie", "", 0, 0);
		mciSendString("record movie", "", 0, 0);
		//语音识别为文字
		sr.BeginRec(textBox1);
		btnOn.Enabled = false;
		btnSpouse.Enabled = true;
		this.timer2.Enabled = true;
	}

	private void btnSpouse_Click(Object sender, tangible.EventArgs e)
	{


		this.timer2.Enabled = false;
		//先删除之前的
		//再保存 
		mciSendString("stop movie", "", 0, 0);
		mciSendString("save movie 1.wav", "", 0, 0);
		mciSendString("close movie", "", 0, 0);
		SpeechRecognition("C:\\Users\\1\\Desktop\\SQLHelper\\WindowsFormsApp1\\bin\\Debug\\1.wav");
		// this.txbmessage.Text = str;
		sr.over();

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 语音内容检测
		//string void_string = this.textBox1.Text;   //拿到需要检测得语音文本


		////语音检测
		//if (this.textBox1.Text == "")
		//{
		//    return;
		//}
		//check.sta = 0;
		////使用check处理文件取得处理结果
		//if (check.CheckStr(this.textBox1.Text))
		//{
		//    check.sta = 1;


		//    Thread thread = new Thread(() =>
		//    {
		//        while (check.CheckStr(textBox1.Text) == true)
		//        {
		//        }
		//        if (check.CheckStr("") == true)
		//        {
		//            txbmessage.Invoke(new Action(() => { txbmessage.Text = "通过"; webBrowser1.Document.ExecCommand("Refresh", false, null); }));


		//        }

		//        else
		//        {
		//            txbmessage.Invoke(new Action(() => { txbmessage.Text = "语音涉黄，违规！！！"; webBrowser1.Document.ExecCommand("Refresh", false, null); num1++; this.lab_num1.Text = num1.ToString(); }));

		//            //webBrowser1.Select();
		//            //check.SetClose();
		//        }
		//    });
		//    thread.Start();

		//}
		//else
		//    txbmessage.Text = "提交失败,请检查网页状态，排除网络登录等情况";

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 语音检测
		btnOn.Enabled = true;
		btnSpouse.Enabled = false;
		//webBrowser1.Document.ExecCommand("Refresh", false, null);
	}

	public final String SpeechRecognition(String wavPath)
	{
		try
		{
			System.Speech.Recognition.SpeechRecognitionEngine sre = new System.Speech.Recognition.SpeechRecognitionEngine();
			sre.LoadGrammar(new System.Speech.Recognition.DictationGrammar());
			sre.SetInputToWaveFile(wavPath);
			String res = null;
			StringBuilder sb = new StringBuilder();
			do
			{
				try
				{
					RecognitionResult result = sre.Recognize();
					if (result != null)
					{
						 res = result.Text;
					}
					else
					{
						System.out.println("No recognition result available.");
					}

				}
				catch (RuntimeException e)
				{
					res = null;
				}
				sb.append(res);
			} while (res != null);
			sre.Dispose();
			return (sb.toString());
		}
		catch (RuntimeException e)
		{
			return (e.getMessage());
		}







	}

	private void button4_Click(Object sender, tangible.EventArgs e)
	{

		//sr.BeginRec(textBox1);
		//button4.Enabled = false;
		//button3.Enabled = true;
	}

	private void button3_Click(Object sender, tangible.EventArgs e)
	{
		//sr.over();
		//button4.Enabled = true;
		//button3.Enabled = false;
	}

	/** 
	 类线程，每一秒执行一次
	 
	 @param sender
	 @param e
	*/
	private void timer1_Tick(Object sender, tangible.EventArgs e)
	{
		//拿图
		//判断是否存在二维码
		//if 存在 提醒
		//if not pass

		img22 = videoSourcePlayer1.GetCurrentVideoFrame(); //拍摄


		//图片处理--二维码识别
		Cheak_QRcode cheak_QRcode = new Cheak_QRcode();
		boolean ss = cheak_QRcode.Cheak_IF_QRcode(img22);
		if (ss)
		{
			num2++;
			//MessageBox.Show(string.Format("存在二维码违规成功"));
			this.txbmessage2.Text = "存在二维码违规!!";
			//有二维码的图片显示
			this.pictureBox4.Visible = true;
			pictureBox4.Image = img22;
			this.pictureBox4_panel9.BackColor = Color.Red; //////////////
			this.lab_num2.Text = String.valueOf(num2);
			//保存图片：不做了
		}


	}
	/** 
	 语音检测线程
	 
	 @param sender
	 @param e
	*/
	private void timer2_Tick(Object sender, tangible.EventArgs e)
	{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 语音内容检测
		//vodice_txt = this.textBox1.Text;   //拿到需要检测得语音文本


		//if (vodice_txt!="")
		//{
		//    //语音检测
		//    if (this.textBox1.Text == "")
		//    {
		//        return;
		//    }
		//    check.sta = 0;
		//    //使用check处理文件取得处理结果
		//    if (check.CheckStr(this.textBox1.Text))
		//    {
		//        check.sta = 1;


		//        Thread thread = new Thread(() =>
		//        {
		//            while (check.CheckStr(textBox1.Text) == true)
		//            {
		//            }
		//            if (check.CheckStr("") == true)
		//            {
		//                txbmessage.Invoke(new Action(() => { txbmessage.Text = "通过"; webBrowser1.Document.ExecCommand("Refresh", false, null); this.textBox1.Text = ""; }));


		//            }

		//            else
		//            {
		//                txbmessage.Invoke(new Action(() => { txbmessage.Text = "语音涉黄，违规！！！"; webBrowser1.Document.ExecCommand("Refresh", false, null); num1++; this.lab_num1.Text = num1.ToString(); this.textBox1.Text = ""; }));

		//                //webBrowser1.Select();
		//                //check.SetClose();
		//            }
		//        });
		//        thread.Start();

		//    }
		//    else
		//        txbmessage.Text = "提交失败,请检查网页状态，排除网络登录等情况";
		//}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 语音检测

		vodice_txt = this.textBox1.Text; //拿到需要检测得语音文本
		if (!vodice_txt.equals(""))
		{
			if (!this.textBox1.Text.equals(""))
			{
				if (Cheak_isOk_.Word_Cheak_is_OK(vodice_txt))
				{ //真 ，有涉黄字：
					txbmessage.Text = "语音涉黄，违规！！！";
					num1++;
					this.lab_num1.Text = String.valueOf(num1);
					this.textBox1.Text = "";
				}
				else
				{
					txbmessage.Text = "通过";
					this.textBox1.Text = "";
				}
			}




		}

	}

	private void timer3_Tick(Object sender, tangible.EventArgs e)
	{
		labDate3.Text = LocalDateTime.now().ToLongTimeString().toString();
	}

	private void btn_change_Click(Object sender, tangible.EventArgs e)
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form1.class);
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.comboBox1 = new System.Windows.Forms.ComboBox();
		this.button2 = new System.Windows.Forms.Button();
		this.button1 = new System.Windows.Forms.Button();
		this.videoSourcePlayer1 = new VideoSourcePlayer();
		this.labName1 = new System.Windows.Forms.Label();
		this.btnLogin = new System.Windows.Forms.Button();
		this.panel1 = new System.Windows.Forms.Panel();
		this.label4 = new System.Windows.Forms.Label();
		this.label3 = new System.Windows.Forms.Label();
		this.label7 = new System.Windows.Forms.Label();
		this.label6 = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.label1 = new System.Windows.Forms.Label();
		this.panel2 = new System.Windows.Forms.Panel();
		this.pictureBox10 = new System.Windows.Forms.PictureBox();
		this.panel3 = new System.Windows.Forms.Panel();
		this.label8 = new System.Windows.Forms.Label();
		this.label9 = new System.Windows.Forms.Label();
		this.label10 = new System.Windows.Forms.Label();
		this.label11 = new System.Windows.Forms.Label();
		this.label12 = new System.Windows.Forms.Label();
		this.label13 = new System.Windows.Forms.Label();
		this.label14 = new System.Windows.Forms.Label();
		this.panel4 = new System.Windows.Forms.Panel();
		this.label15 = new System.Windows.Forms.Label();
		this.label16 = new System.Windows.Forms.Label();
		this.label17 = new System.Windows.Forms.Label();
		this.label18 = new System.Windows.Forms.Label();
		this.label19 = new System.Windows.Forms.Label();
		this.label20 = new System.Windows.Forms.Label();
		this.label21 = new System.Windows.Forms.Label();
		this.panel5 = new System.Windows.Forms.Panel();
		this.panel6 = new System.Windows.Forms.Panel();
		this.label24 = new System.Windows.Forms.Label();
		this.btnSpouse = new System.Windows.Forms.Button();
		this.btnOn = new System.Windows.Forms.Button();
		this.txbmessage = new System.Windows.Forms.TextBox();
		this.panel7 = new System.Windows.Forms.Panel();
		this.labDate3 = new System.Windows.Forms.Label();
		this.labName2 = new System.Windows.Forms.Label();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.label22 = new System.Windows.Forms.Label();
		this.pictureBox3 = new System.Windows.Forms.PictureBox();
		this.textBox1 = new System.Windows.Forms.TextBox();
		this.webBrowser1 = new System.Windows.Forms.WebBrowser();
		this.timer1 = new System.Windows.Forms.Timer(this.components);
		this.pageSetupDialog1 = new System.Windows.Forms.PageSetupDialog();
		this.panel8 = new System.Windows.Forms.Panel();
		this.label25 = new System.Windows.Forms.Label();
		this.lab_num2 = new System.Windows.Forms.Label();
		this.lab_num1 = new System.Windows.Forms.Label();
		this.pictureBox4_panel9 = new System.Windows.Forms.Panel();
		this.pictureBox4 = new System.Windows.Forms.PictureBox();
		this.txbmessage2 = new System.Windows.Forms.TextBox();
		this.label23 = new System.Windows.Forms.Label();
		this.timer2 = new System.Windows.Forms.Timer(this.components);
		this.timer3 = new System.Windows.Forms.Timer(this.components);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.panel1.SuspendLayout();
		this.panel2.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).BeginInit();
		this.panel3.SuspendLayout();
		this.panel4.SuspendLayout();
		this.panel5.SuspendLayout();
		this.panel6.SuspendLayout();
		this.panel7.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
		this.panel8.SuspendLayout();
		this.pictureBox4_panel9.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
		this.SuspendLayout();
		// 
		// pictureBox1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.pictureBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(239)))), ((int)(((byte)(250)))));
		this.pictureBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(239)))), ((int)(((byte)(250)))));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
		this.pictureBox1.Location = new System.Drawing.Point(504, 19);
		this.pictureBox1.Margin = new System.Windows.Forms.Padding(2);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(167, 125);
		this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
		this.pictureBox1.TabIndex = 9;
		this.pictureBox1.TabStop = false;
		// 
		// comboBox1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.comboBox1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.comboBox1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.comboBox1.FormattingEnabled = true;
		this.comboBox1.Items.AddRange(new Object[] {"摄像头1", "摄像头2"});
		this.comboBox1.Location = new System.Drawing.Point(155, 6);
		this.comboBox1.Margin = new System.Windows.Forms.Padding(2);
		this.comboBox1.Name = "comboBox1";
		this.comboBox1.Size = new System.Drawing.Size(151, 28);
		this.comboBox1.TabIndex = 8;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
		// 
		// button2
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.button2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.button2.Enabled = false;
		this.button2.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold);
		this.button2.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.button2.Location = new System.Drawing.Point(216, 28);
		this.button2.Margin = new System.Windows.Forms.Padding(2);
		this.button2.Name = "button2";
		this.button2.Size = new System.Drawing.Size(90, 40);
		this.button2.TabIndex = 7;
		this.button2.Text = "保存图片";
		this.button2.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.button2.Click += new System.EventHandler(this.button2_Click);
		// 
		// button1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.button1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.button1.Enabled = false;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.button1.Location = new System.Drawing.Point(90, 27);
		this.button1.Margin = new System.Windows.Forms.Padding(2);
		this.button1.Name = "button1";
		this.button1.Size = new System.Drawing.Size(90, 40);
		this.button1.TabIndex = 6;
		this.button1.Text = "拍摄";
		this.button1.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.button1.Click += new System.EventHandler(this.button1_Click);
		// 
		// videoSourcePlayer1
		// 
		this.videoSourcePlayer1.Location = new System.Drawing.Point(11, 77);
		this.videoSourcePlayer1.Margin = new System.Windows.Forms.Padding(2);
		this.videoSourcePlayer1.Name = "videoSourcePlayer1";
		this.videoSourcePlayer1.Size = new System.Drawing.Size(690, 382);
		this.videoSourcePlayer1.TabIndex = 5;
		this.videoSourcePlayer1.Text = "videoSourcePlayer1";
		this.videoSourcePlayer1.VideoSource = null;
		// 
		// labName1
		// 
		this.labName1.AutoSize = true;
		this.labName1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold);
		this.labName1.Location = new System.Drawing.Point(25, 11);
		this.labName1.Name = "labName1";
		this.labName1.Size = new System.Drawing.Size(104, 17);
		this.labName1.TabIndex = 10;
		this.labName1.Text = "选择打开的相机源";
		// 
		// btnLogin
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.btnLogin.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderSize = 0;
		this.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.ForeColor = System.Drawing.SystemColors.Window;
		this.btnLogin.Location = new System.Drawing.Point(538, 5);
		this.btnLogin.Name = "btnLogin";
		this.btnLogin.Size = new System.Drawing.Size(113, 27);
		this.btnLogin.TabIndex = 12;
		this.btnLogin.Text = "结束会议";
		this.btnLogin.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
		// 
		// panel1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel1.Controls.Add(this.label4);
		this.panel1.Controls.Add(this.label3);
		this.panel1.Controls.Add(this.label7);
		this.panel1.Controls.Add(this.label6);
		this.panel1.Controls.Add(this.label5);
		this.panel1.Controls.Add(this.label2);
		this.panel1.Controls.Add(this.label1);
		this.panel1.Location = new System.Drawing.Point(13, 32);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(189, 160);
		this.panel1.TabIndex = 13;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel1.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Location = new System.Drawing.Point(8, 129);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(68, 17);
		this.label4.TabIndex = 10;
		this.label4.Text = "手术时间：";
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Location = new System.Drawing.Point(11, 102);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(56, 17);
		this.label3.TabIndex = 10;
		this.label3.Text = "手术名：";
		// 
		// label7
		// 
		this.label7.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label7.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label7.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(229)))), ((int)(((byte)(133)))), ((int)(((byte)(31)))));
		this.label7.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(229)))), ((int)(((byte)(133)))), ((int)(((byte)(31)))));
		this.label7.Location = new System.Drawing.Point(74, 129);
		this.label7.Name = "label7";
		this.label7.Size = new System.Drawing.Size(44, 17);
		this.label7.TabIndex = 10;
		this.label7.Text = "姓名：";
		// 
		// label6
		// 
		this.label6.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label6.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label6.Location = new System.Drawing.Point(74, 102);
		this.label6.Name = "label6";
		this.label6.Size = new System.Drawing.Size(44, 17);
		this.label6.TabIndex = 10;
		this.label6.Text = "姓名：";
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Location = new System.Drawing.Point(74, 76);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(44, 17);
		this.label5.TabIndex = 10;
		this.label5.Text = "姓名：";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Location = new System.Drawing.Point(11, 76);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(44, 17);
		this.label2.TabIndex = 10;
		this.label2.Text = "姓名：";
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(108)))), ((int)(((byte)(39)))), ((int)(((byte)(174)))));
		this.label1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(108)))), ((int)(((byte)(39)))), ((int)(((byte)(174)))));
		this.label1.Location = new System.Drawing.Point(51, 1);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(88, 75);
		this.label1.TabIndex = 0;
		this.label1.Text = "李";
		// 
		// panel2
		// 
		this.panel2.Controls.Add(this.pictureBox10);
		this.panel2.Controls.Add(this.labName1);
		this.panel2.Controls.Add(this.comboBox1);
		this.panel2.Controls.Add(this.btnLogin);
		this.panel2.Location = new System.Drawing.Point(11, 40);
		this.panel2.Name = "panel2";
		this.panel2.Size = new System.Drawing.Size(690, 36);
		this.panel2.TabIndex = 14;
		// 
		// pictureBox10
		// 
		this.pictureBox10.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox10.BackgroundImage")));
		this.pictureBox10.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox10.Location = new System.Drawing.Point(3, 3);
		this.pictureBox10.Name = "pictureBox10";
		this.pictureBox10.Size = new System.Drawing.Size(10, 32);
		this.pictureBox10.TabIndex = 19;
		this.pictureBox10.TabStop = false;
		// 
		// panel3
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel3.Controls.Add(this.label8);
		this.panel3.Controls.Add(this.label9);
		this.panel3.Controls.Add(this.label10);
		this.panel3.Controls.Add(this.label11);
		this.panel3.Controls.Add(this.label12);
		this.panel3.Controls.Add(this.label13);
		this.panel3.Controls.Add(this.label14);
		this.panel3.Location = new System.Drawing.Point(13, 198);
		this.panel3.Name = "panel3";
		this.panel3.Size = new System.Drawing.Size(189, 160);
		this.panel3.TabIndex = 13;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel3.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
		// 
		// label8
		// 
		this.label8.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label8.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Location = new System.Drawing.Point(8, 129);
		this.label8.Name = "label8";
		this.label8.Size = new System.Drawing.Size(68, 17);
		this.label8.TabIndex = 10;
		this.label8.Text = "手术时间：";
		// 
		// label9
		// 
		this.label9.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label9.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Location = new System.Drawing.Point(11, 102);
		this.label9.Name = "label9";
		this.label9.Size = new System.Drawing.Size(56, 17);
		this.label9.TabIndex = 10;
		this.label9.Text = "手术名：";
		// 
		// label10
		// 
		this.label10.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label10.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label10.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label10.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(229)))), ((int)(((byte)(133)))), ((int)(((byte)(31)))));
		this.label10.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(229)))), ((int)(((byte)(133)))), ((int)(((byte)(31)))));
		this.label10.Location = new System.Drawing.Point(74, 129);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(74, 17);
		this.label10.TabIndex = 10;
		this.label10.Text = "0000:00000";
		// 
		// label11
		// 
		this.label11.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label11.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label11.Location = new System.Drawing.Point(74, 102);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(62, 17);
		this.label11.TabIndex = 10;
		this.label11.Text = "xxxxxxxxx";
		// 
		// label12
		// 
		this.label12.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label12.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label12.Location = new System.Drawing.Point(74, 76);
		this.label12.Name = "label12";
		this.label12.Size = new System.Drawing.Size(38, 17);
		this.label12.TabIndex = 10;
		this.label12.Text = "xxxxx";
		// 
		// label13
		// 
		this.label13.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label13.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label13.Location = new System.Drawing.Point(11, 76);
		this.label13.Name = "label13";
		this.label13.Size = new System.Drawing.Size(44, 17);
		this.label13.TabIndex = 10;
		this.label13.Text = "姓名：";
		// 
		// label14
		// 
		this.label14.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label14.Font = new System.Drawing.Font("微软雅黑", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Font = new System.Drawing.Font("微软雅黑", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label14.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(108)))), ((int)(((byte)(39)))), ((int)(((byte)(174)))));
		this.label14.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(108)))), ((int)(((byte)(39)))), ((int)(((byte)(174)))));
		this.label14.Location = new System.Drawing.Point(51, 1);
		this.label14.Name = "label14";
		this.label14.Size = new System.Drawing.Size(88, 75);
		this.label14.TabIndex = 0;
		this.label14.Text = "李";
		// 
		// panel4
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(253)))), ((int)(((byte)(253)))), ((int)(((byte)(253)))));
		this.panel4.Controls.Add(this.label15);
		this.panel4.Controls.Add(this.label16);
		this.panel4.Controls.Add(this.label17);
		this.panel4.Controls.Add(this.label18);
		this.panel4.Controls.Add(this.label19);
		this.panel4.Controls.Add(this.label20);
		this.panel4.Controls.Add(this.label21);
		this.panel4.Location = new System.Drawing.Point(13, 364);
		this.panel4.Name = "panel4";
		this.panel4.Size = new System.Drawing.Size(189, 160);
		this.panel4.TabIndex = 13;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.panel4.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
		// 
		// label15
		// 
		this.label15.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label15.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label15.Location = new System.Drawing.Point(8, 129);
		this.label15.Name = "label15";
		this.label15.Size = new System.Drawing.Size(68, 17);
		this.label15.TabIndex = 10;
		this.label15.Text = "手术时间：";
		// 
		// label16
		// 
		this.label16.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label16.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label16.Location = new System.Drawing.Point(11, 102);
		this.label16.Name = "label16";
		this.label16.Size = new System.Drawing.Size(56, 17);
		this.label16.TabIndex = 10;
		this.label16.Text = "手术名：";
		// 
		// label17
		// 
		this.label17.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label17.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label17.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(229)))), ((int)(((byte)(133)))), ((int)(((byte)(31)))));
		this.label17.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(229)))), ((int)(((byte)(133)))), ((int)(((byte)(31)))));
		this.label17.Location = new System.Drawing.Point(74, 129);
		this.label17.Name = "label17";
		this.label17.Size = new System.Drawing.Size(74, 17);
		this.label17.TabIndex = 10;
		this.label17.Text = "0000:00000";
		// 
		// label18
		// 
		this.label18.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label18.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label18.Location = new System.Drawing.Point(74, 102);
		this.label18.Name = "label18";
		this.label18.Size = new System.Drawing.Size(62, 17);
		this.label18.TabIndex = 10;
		this.label18.Text = "xxxxxxxxx";
		// 
		// label19
		// 
		this.label19.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label19.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label19.Location = new System.Drawing.Point(74, 76);
		this.label19.Name = "label19";
		this.label19.Size = new System.Drawing.Size(38, 17);
		this.label19.TabIndex = 10;
		this.label19.Text = "xxxxx";
		// 
		// label20
		// 
		this.label20.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label20.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label20.Location = new System.Drawing.Point(11, 76);
		this.label20.Name = "label20";
		this.label20.Size = new System.Drawing.Size(44, 17);
		this.label20.TabIndex = 10;
		this.label20.Text = "姓名：";
		// 
		// label21
		// 
		this.label21.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label21.Font = new System.Drawing.Font("微软雅黑", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label21.Font = new System.Drawing.Font("微软雅黑", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label21.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(108)))), ((int)(((byte)(39)))), ((int)(((byte)(174)))));
		this.label21.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(108)))), ((int)(((byte)(39)))), ((int)(((byte)(174)))));
		this.label21.Location = new System.Drawing.Point(51, 1);
		this.label21.Name = "label21";
		this.label21.Size = new System.Drawing.Size(88, 75);
		this.label21.TabIndex = 0;
		this.label21.Text = "李";
		// 
		// panel5
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(58)))), ((int)(((byte)(30)))), ((int)(((byte)(107)))));
		this.panel5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(58)))), ((int)(((byte)(30)))), ((int)(((byte)(107)))));
		this.panel5.Controls.Add(this.panel1);
		this.panel5.Controls.Add(this.panel3);
		this.panel5.Controls.Add(this.panel4);
		this.panel5.Location = new System.Drawing.Point(788, 40);
		this.panel5.Name = "panel5";
		this.panel5.Size = new System.Drawing.Size(220, 555);
		this.panel5.TabIndex = 15;
		// 
		// panel6
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel6.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(232)))), ((int)(((byte)(230)))), ((int)(((byte)(233)))));
		this.panel6.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(232)))), ((int)(((byte)(230)))), ((int)(((byte)(233)))));
		this.panel6.Controls.Add(this.label24);
		this.panel6.Controls.Add(this.btnSpouse);
		this.panel6.Controls.Add(this.btnOn);
		this.panel6.Controls.Add(this.button1);
		this.panel6.Controls.Add(this.button2);
		this.panel6.Controls.Add(this.pictureBox1);
		this.panel6.Location = new System.Drawing.Point(11, 461);
		this.panel6.Name = "panel6";
		this.panel6.Size = new System.Drawing.Size(690, 164);
		this.panel6.TabIndex = 16;
		// 
		// label24
		// 
		this.label24.AutoSize = true;
		this.label24.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold);
		this.label24.Location = new System.Drawing.Point(10, 7);
		this.label24.Name = "label24";
		this.label24.Size = new System.Drawing.Size(68, 17);
		this.label24.TabIndex = 19;
		this.label24.Text = "功能选择：";
		// 
		// btnSpouse
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSpouse.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.btnSpouse.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSpouse.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnSpouse.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnSpouse.FlatAppearance.BorderSize = 0;
		this.btnSpouse.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnSpouse.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnSpouse.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnSpouse.ForeColor = System.Drawing.SystemColors.Window;
		this.btnSpouse.Location = new System.Drawing.Point(216, 87);
		this.btnSpouse.Name = "btnSpouse";
		this.btnSpouse.Size = new System.Drawing.Size(87, 34);
		this.btnSpouse.TabIndex = 17;
		this.btnSpouse.Text = "关闭声音";
		this.btnSpouse.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnSpouse.Click += new System.EventHandler(this.btnSpouse_Click);
		// 
		// btnOn
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOn.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.btnOn.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOn.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOn.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOn.FlatAppearance.BorderSize = 0;
		this.btnOn.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOn.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOn.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOn.ForeColor = System.Drawing.SystemColors.Window;
		this.btnOn.Location = new System.Drawing.Point(90, 87);
		this.btnOn.Name = "btnOn";
		this.btnOn.Size = new System.Drawing.Size(86, 34);
		this.btnOn.TabIndex = 16;
		this.btnOn.Text = "打开声音";
		this.btnOn.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnOn.Click += new System.EventHandler(this.btnOn_Click);
		// 
		// txbmessage
		// 
		this.txbmessage.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txbmessage.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(58)))), ((int)(((byte)(30)))), ((int)(((byte)(107)))));
		this.txbmessage.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(58)))), ((int)(((byte)(30)))), ((int)(((byte)(107)))));
		this.txbmessage.Location = new System.Drawing.Point(14, 40);
		this.txbmessage.Multiline = true;
		this.txbmessage.Name = "txbmessage";
		this.txbmessage.Size = new System.Drawing.Size(189, 21);
		this.txbmessage.TabIndex = 17;
		// 
		// panel7
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.panel7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.panel7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.panel7.Controls.Add(this.labDate3);
		this.panel7.Controls.Add(this.labName2);
		this.panel7.Controls.Add(this.pictureBox2);
		this.panel7.Controls.Add(this.label22);
		this.panel7.Controls.Add(this.pictureBox3);
		this.panel7.Location = new System.Drawing.Point(0, 0);
		this.panel7.Name = "panel7";
		this.panel7.Size = new System.Drawing.Size(1008, 34);
		this.panel7.TabIndex = 18;
		// 
		// labDate3
		// 
		this.labDate3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labDate3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labDate3.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.labDate3.Location = new System.Drawing.Point(883, 10);
		this.labDate3.Name = "labDate3";
		this.labDate3.Size = new System.Drawing.Size(36, 17);
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
		this.labName2.Location = new System.Drawing.Point(771, 6);
		this.labName2.Name = "labName2";
		this.labName2.Size = new System.Drawing.Size(106, 22);
		this.labName2.TabIndex = 3;
		this.labName2.Text = "正在会议访视";
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.BackgroundImage")));
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
		this.pictureBox2.Location = new System.Drawing.Point(714, 4);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(41, 26);
		this.pictureBox2.TabIndex = 2;
		this.pictureBox2.TabStop = false;
		// 
		// label22
		// 
		this.label22.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label22.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label22.Location = new System.Drawing.Point(82, 9);
		this.label22.Name = "label22";
		this.label22.Size = new System.Drawing.Size(149, 19);
		this.label22.TabIndex = 1;
		this.label22.Text = "手 术 麻 醉 访 视 系 统";
		// 
		// pictureBox3
		// 
		this.pictureBox3.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox3.BackgroundImage")));
		this.pictureBox3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
		this.pictureBox3.Location = new System.Drawing.Point(28, 3);
		this.pictureBox3.Name = "pictureBox3";
		this.pictureBox3.Size = new System.Drawing.Size(48, 27);
		this.pictureBox3.TabIndex = 0;
		this.pictureBox3.TabStop = false;
		// 
		// textBox1
		// 
		this.textBox1.Location = new System.Drawing.Point(748, 630);
		this.textBox1.Multiline = true;
		this.textBox1.Name = "textBox1";
		this.textBox1.Size = new System.Drawing.Size(260, 19);
		this.textBox1.TabIndex = 21;
		// 
		// webBrowser1
		// 
		this.webBrowser1.Location = new System.Drawing.Point(14, 103);
		this.webBrowser1.MinimumSize = new System.Drawing.Size(20, 20);
		this.webBrowser1.Name = "webBrowser1";
		this.webBrowser1.Size = new System.Drawing.Size(99, 20);
		this.webBrowser1.TabIndex = 22;
		this.webBrowser1.Url = new System.Uri("", System.UriKind.Relative);
		// 
		// timer1
		// 
		this.timer1.Enabled = true;
		this.timer1.Interval = 2000;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
		// 
		// panel8
		// 
		this.panel8.Controls.Add(this.label25);
		this.panel8.Controls.Add(this.webBrowser1);
		this.panel8.Controls.Add(this.lab_num2);
		this.panel8.Controls.Add(this.lab_num1);
		this.panel8.Controls.Add(this.pictureBox4_panel9);
		this.panel8.Controls.Add(this.txbmessage2);
		this.panel8.Controls.Add(this.label23);
		this.panel8.Controls.Add(this.txbmessage);
		this.panel8.Location = new System.Drawing.Point(14, 644);
		this.panel8.Name = "panel8";
		this.panel8.Size = new System.Drawing.Size(687, 142);
		this.panel8.TabIndex = 23;
		// 
		// label25
		// 
		this.label25.AutoSize = true;
		this.label25.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold);
		this.label25.ForeColor = System.Drawing.SystemColors.MenuText;
		this.label25.Location = new System.Drawing.Point(220, 15);
		this.label25.Name = "label25";
		this.label25.Size = new System.Drawing.Size(32, 17);
		this.label25.TabIndex = 23;
		this.label25.Text = "次数";
		// 
		// lab_num2
		// 
		this.lab_num2.AutoSize = true;
		this.lab_num2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold);
		this.lab_num2.ForeColor = System.Drawing.Color.Red;
		this.lab_num2.Location = new System.Drawing.Point(227, 71);
		this.lab_num2.Name = "lab_num2";
		this.lab_num2.Size = new System.Drawing.Size(0, 17);
		this.lab_num2.TabIndex = 22;
		// 
		// lab_num1
		// 
		this.lab_num1.AutoSize = true;
		this.lab_num1.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold);
		this.lab_num1.ForeColor = System.Drawing.Color.Red;
		this.lab_num1.Location = new System.Drawing.Point(227, 40);
		this.lab_num1.Name = "lab_num1";
		this.lab_num1.Size = new System.Drawing.Size(0, 17);
		this.lab_num1.TabIndex = 22;
		// 
		// pictureBox4_panel9
		// 
		this.pictureBox4_panel9.Controls.Add(this.pictureBox4);
		this.pictureBox4_panel9.Location = new System.Drawing.Point(501, 6);
		this.pictureBox4_panel9.Name = "pictureBox4_panel9";
		this.pictureBox4_panel9.Size = new System.Drawing.Size(183, 136);
		this.pictureBox4_panel9.TabIndex = 21;
		// 
		// pictureBox4
		// 
		this.pictureBox4.BackColor = System.Drawing.Color.White;
		this.pictureBox4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
		this.pictureBox4.Location = new System.Drawing.Point(9, 7);
		this.pictureBox4.Margin = new System.Windows.Forms.Padding(2);
		this.pictureBox4.Name = "pictureBox4";
		this.pictureBox4.Size = new System.Drawing.Size(167, 125);
		this.pictureBox4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
		this.pictureBox4.TabIndex = 20;
		this.pictureBox4.TabStop = false;
		this.pictureBox4.Visible = false;
		// 
		// txbmessage2
		// 
		this.txbmessage2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txbmessage2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.txbmessage2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.txbmessage2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(58)))), ((int)(((byte)(30)))), ((int)(((byte)(107)))));
		this.txbmessage2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(58)))), ((int)(((byte)(30)))), ((int)(((byte)(107)))));
		this.txbmessage2.Location = new System.Drawing.Point(14, 67);
		this.txbmessage2.Multiline = true;
		this.txbmessage2.Name = "txbmessage2";
		this.txbmessage2.Size = new System.Drawing.Size(189, 21);
		this.txbmessage2.TabIndex = 19;
		// 
		// label23
		// 
		this.label23.AutoSize = true;
		this.label23.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold);
		this.label23.Location = new System.Drawing.Point(11, 9);
		this.label23.Name = "label23";
		this.label23.Size = new System.Drawing.Size(68, 17);
		this.label23.TabIndex = 18;
		this.label23.Text = "故障显示：";
		// 
		// timer2
		// 
		this.timer2.Enabled = true;
		this.timer2.Interval = 5000;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer2.Tick += new System.EventHandler(this.timer2_Tick);
		// 
		// timer3
		// 
		this.timer3.Enabled = true;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.timer3.Tick += new System.EventHandler(this.timer3_Tick);
		// 
		// Form1
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.ClientSize = new System.Drawing.Size(1008, 796);
		this.Controls.Add(this.panel8);
		this.Controls.Add(this.textBox1);
		this.Controls.Add(this.panel7);
		this.Controls.Add(this.panel6);
		this.Controls.Add(this.panel5);
		this.Controls.Add(this.panel2);
		this.Controls.Add(this.videoSourcePlayer1);
		this.Name = "Form1";
		this.Text = "Form1";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form1_Load);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		this.panel2.ResumeLayout(false);
		this.panel2.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).EndInit();
		this.panel3.ResumeLayout(false);
		this.panel3.PerformLayout();
		this.panel4.ResumeLayout(false);
		this.panel4.PerformLayout();
		this.panel5.ResumeLayout(false);
		this.panel6.ResumeLayout(false);
		this.panel6.PerformLayout();
		this.panel7.ResumeLayout(false);
		this.panel7.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
		this.panel8.ResumeLayout(false);
		this.panel8.PerformLayout();
		this.pictureBox4_panel9.ResumeLayout(false);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.ComboBox comboBox1;
	private System.Windows.Forms.Button button2;
	private System.Windows.Forms.Button button1;
	private VideoSourcePlayer videoSourcePlayer1;
	private System.Windows.Forms.Label labName1;
	private System.Windows.Forms.Button btnLogin;
	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Label label7;
	private System.Windows.Forms.Label label6;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.Panel panel2;
	private System.Windows.Forms.Panel panel3;
	private System.Windows.Forms.Label label8;
	private System.Windows.Forms.Label label9;
	private System.Windows.Forms.Label label10;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.Label label12;
	private System.Windows.Forms.Label label13;
	private System.Windows.Forms.Label label14;
	private System.Windows.Forms.Panel panel4;
	private System.Windows.Forms.Label label15;
	private System.Windows.Forms.Label label16;
	private System.Windows.Forms.Label label17;
	private System.Windows.Forms.Label label18;
	private System.Windows.Forms.Label label19;
	private System.Windows.Forms.Label label20;
	private System.Windows.Forms.Label label21;
	private System.Windows.Forms.Panel panel5;
	private System.Windows.Forms.Panel panel6;
	private System.Windows.Forms.TextBox txbmessage;
	private System.Windows.Forms.Panel panel7;
	private System.Windows.Forms.Label labDate3;
	private System.Windows.Forms.Label labName2;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.Label label22;
	private System.Windows.Forms.PictureBox pictureBox3;
	private System.Windows.Forms.PictureBox pictureBox10;
	private System.Windows.Forms.Button btnOn;
	private System.Windows.Forms.Button btnSpouse;
	private System.Windows.Forms.TextBox textBox1;
	private System.Windows.Forms.WebBrowser webBrowser1;
	private System.Windows.Forms.Timer timer1;
	private System.Windows.Forms.Label label24;
	private System.Windows.Forms.PageSetupDialog pageSetupDialog1;
	private System.Windows.Forms.Panel panel8;
	private System.Windows.Forms.Panel pictureBox4_panel9;
	private System.Windows.Forms.PictureBox pictureBox4;
	private System.Windows.Forms.TextBox txbmessage2;
	private System.Windows.Forms.Label label23;
	private System.Windows.Forms.Label lab_num2;
	private System.Windows.Forms.Label lab_num1;
	private System.Windows.Forms.Label label25;
	private System.Windows.Forms.Timer timer2;
	private System.Windows.Forms.Timer timer3;
}