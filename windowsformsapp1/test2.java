package windowsformsapp1;

//using SeleniumUtil;

public class test2 extends Form
{
	private Cheak_isOk Cheak_isOk_ = new Cheak_isOk();
	public test2()
	{

		InitializeComponent();
	}


	private void test2_Load(Object sender, tangible.EventArgs e)
	{

		String str = "时期后欧珀是完全解耦赔偿jqcJPOVKVKDkcKVPFPOJAV O[KJOCSDKA[WEKEL[采集的实际库存，操";
		if (!str.equals(""))
		{
			if (Cheak_isOk_.Word_Cheak_is_OK(str))
			{ //真 ，有涉黄字：
				//txbmessage.Text = "语音涉黄，违规！！！";
				//num1++;
				//this.lab_num1.Text = num1.ToString();
				//this.textBox1.Text = "";
				MessageBox.Show(String.format("成功"));
			}
			else
			{
				//txbmessage.Text = "通过";
				//this.textBox1.Text = "";
				MessageBox.Show(String.format("失败"));
			}
		}


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
		this.SuspendLayout();
		// 
		// test2
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(800, 450);
		this.Name = "test2";
		this.Text = "test2";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.test2_Load);
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}