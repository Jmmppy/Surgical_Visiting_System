package camera_001;

import AForge.*;
import AForge.Controls.*;
import AForge.Video.*;
import AForge.Video.DirectShow.*;
import java.time.*;

/* ==============================================================================
 * 功能描述：    调用电脑摄像头，并进行拍摄、保存。
 * 创 建 者：    泰勒Peano
 * 交流邮箱：    goodzheng@88.com
 * 交流QQ：      656029714
 * 创建日期：    2020.09.04
 *.Net Version  3.5
 * ==============================================================================*/


public class Form1 extends Form
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 变量

	private FilterInfoCollection videoDevices; //摄像头设备集合
	private VideoCaptureDevice videoSource; //捕获设备源
	private Bitmap img; //处理图片

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 构造函数
	public Form1()
	{
		InitializeComponent();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 事件
	private void Form1_Load(Object sender, tangible.EventArgs e)
	{
		//先检测电脑所有的摄像头
		videoDevices = new FilterInfoCollection(FilterCategory.VideoInputDevice);
		MessageBox.Show("检测到了" + videoDevices.size().toString() + "个摄像头！");
	}

	private void comboBox1_SelectedIndexChanged(Object sender, tangible.EventArgs e)
	{
		ShutCamera(); //保证释放摄像头
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

	private void Form1_FormClosing(Object sender, FormClosingEventArgs e)
	{
		ShutCamera(); //保证释放摄像头

	}

	private void button1_Click(Object sender, tangible.EventArgs e)
	{
		img = videoSourcePlayer1.GetCurrentVideoFrame(); //拍摄
		pictureBox1.Image = img;
		button2.Enabled = true; //开启"保存”功能
	}

	//"保存"按钮click事件
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
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 方法
	// 关闭并释放摄像头
	public final void ShutCamera()
	{
		if (videoSourcePlayer1.VideoSource != null)
		{
			videoSourcePlayer1.SignalToStop();
			videoSourcePlayer1.WaitForStop();
			videoSourcePlayer1.VideoSource = null;
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion


	/** 
	 必需的设计器变量。
	*/
	private System.ComponentModel.IContainer components = null;

	/** 
	 清理所有正在使用的资源。
	 
	 @param disposing 如果应释放托管资源，为 true；否则为 false。
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
		///#region Windows 窗体设计器生成的代码

	/** 
	 设计器支持所需的方法 - 不要修改
	 使用代码编辑器修改此方法的内容。
	*/
	private void InitializeComponent()
	{
		this.videoSourcePlayer1 = new VideoSourcePlayer();
		this.button1 = new System.Windows.Forms.Button();
		this.button2 = new System.Windows.Forms.Button();
		this.comboBox1 = new System.Windows.Forms.ComboBox();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.SuspendLayout();
		// 
		// videoSourcePlayer1
		// 
		this.videoSourcePlayer1.Location = new System.Drawing.Point(32, 130);
		this.videoSourcePlayer1.Name = "videoSourcePlayer1";
		this.videoSourcePlayer1.Size = new System.Drawing.Size(509, 281);
		this.videoSourcePlayer1.TabIndex = 0;
		this.videoSourcePlayer1.Text = "videoSourcePlayer1";
		this.videoSourcePlayer1.VideoSource = null;
		// 
		// button1
		// 
		this.button1.Enabled = false;
		this.button1.Location = new System.Drawing.Point(368, 35);
		this.button1.Name = "button1";
		this.button1.Size = new System.Drawing.Size(94, 61);
		this.button1.TabIndex = 1;
		this.button1.Text = "拍摄";
		this.button1.UseVisualStyleBackColor = true;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.button1.Click += new System.EventHandler(this.button1_Click);
		// 
		// button2
		// 
		this.button2.Enabled = false;
		this.button2.Location = new System.Drawing.Point(511, 35);
		this.button2.Name = "button2";
		this.button2.Size = new System.Drawing.Size(94, 61);
		this.button2.TabIndex = 2;
		this.button2.Text = "保存";
		this.button2.UseVisualStyleBackColor = true;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.button2.Click += new System.EventHandler(this.button2_Click);
		// 
		// comboBox1
		// 
		this.comboBox1.FormattingEnabled = true;
		this.comboBox1.Items.AddRange(new Object[] {"摄像头1", "摄像头2"});
		this.comboBox1.Location = new System.Drawing.Point(76, 55);
		this.comboBox1.Name = "comboBox1";
		this.comboBox1.Size = new System.Drawing.Size(200, 23);
		this.comboBox1.TabIndex = 3;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
		this.pictureBox1.Location = new System.Drawing.Point(565, 241);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(223, 156);
		this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
		this.pictureBox1.TabIndex = 4;
		this.pictureBox1.TabStop = false;
		// 
		// Form1
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(800, 450);
		this.Controls.Add(this.pictureBox1);
		this.Controls.Add(this.comboBox1);
		this.Controls.Add(this.button2);
		this.Controls.Add(this.button1);
		this.Controls.Add(this.videoSourcePlayer1);
		this.Name = "Form1";
		this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
		this.Text = "Form1";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form1_Load);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private VideoSourcePlayer videoSourcePlayer1;
	private System.Windows.Forms.Button button1;
	private System.Windows.Forms.Button button2;
	private System.Windows.Forms.ComboBox comboBox1;
	private System.Windows.Forms.PictureBox pictureBox1;
}