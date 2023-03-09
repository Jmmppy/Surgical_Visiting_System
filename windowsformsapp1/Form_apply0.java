package windowsformsapp1;

public class Form_apply0 extends Form
{
	public Form_apply0()
	{
		InitializeComponent();
	}

	private void pictureBox4_Click(Object sender, tangible.EventArgs e)
	{
		// 打开访手术申请统界面
		Form_apply1 Form_apply1_ = new Form_apply1();

		this.Hide();
		//Form_apply1_.ShowDialog(this);
		if (Form_apply1_.ShowDialog() == System.Windows.Forms.DialogResult.OK)
		{
			this.Show();
		}
	}

	private void pictureBox1_Click(Object sender, tangible.EventArgs e)
	{
		// 打开访审批界面
		Form_apply3 Form_apply3_ = new Form_apply3();

		this.Hide();
		//Form_apply1_.ShowDialog(this);
		if (Form_apply3_.ShowDialog() == System.Windows.Forms.DialogResult.OK)
		{
			this.Show();
		}
	}

	private void Form_apply0_FormClosing(Object sender, FormClosingEventArgs e)
	{

	}

	private void Form_apply0_FormClosed(Object sender, FormClosedEventArgs e)
	{
		this.Close();
		this.DialogResult = System.Windows.Forms.DialogResult.OK;
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form_apply0.class);
		this.label9 = new System.Windows.Forms.Label();
		this.pictureBox4 = new System.Windows.Forms.PictureBox();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.label1 = new System.Windows.Forms.Label();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.SuspendLayout();
		// 
		// label9
		// 
		this.label9.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label9.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label9.Location = new System.Drawing.Point(161, 268);
		this.label9.Name = "label9";
		this.label9.Size = new System.Drawing.Size(106, 21);
		this.label9.TabIndex = 8;
		this.label9.Text = "填写手术申请";
		// 
		// pictureBox4
		// 
		this.pictureBox4.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox4.BackgroundImage")));
		this.pictureBox4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox4.Location = new System.Drawing.Point(169, 187);
		this.pictureBox4.Name = "pictureBox4";
		this.pictureBox4.Size = new System.Drawing.Size(88, 63);
		this.pictureBox4.TabIndex = 7;
		this.pictureBox4.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click);
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(450, 187);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(88, 63);
		this.pictureBox1.TabIndex = 7;
		this.pictureBox1.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Location = new System.Drawing.Point(457, 268);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(74, 21);
		this.label1.TabIndex = 8;
		this.label1.Text = "审批申请";
		// 
		// Form_apply0
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.ClientSize = new System.Drawing.Size(899, 571);
		this.Controls.Add(this.label1);
		this.Controls.Add(this.label9);
		this.Controls.Add(this.pictureBox1);
		this.Controls.Add(this.pictureBox4);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
		this.Name = "Form_apply0";
		this.Text = "Form_apply0";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form_apply0_FormClosing);
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form_apply0_FormClosed);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Label label9;
	private System.Windows.Forms.PictureBox pictureBox4;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.Label label1;
}