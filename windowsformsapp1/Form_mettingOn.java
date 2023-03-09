package windowsformsapp1;

public class Form_mettingOn extends Form
{
	public Form_mettingOn()
	{
		InitializeComponent();
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
		this.label14 = new System.Windows.Forms.Label();
		this.cmb_ss_type = new System.Windows.Forms.ComboBox();
		this.btnLogin = new System.Windows.Forms.Button();
		this.button1 = new System.Windows.Forms.Button();
		this.button2 = new System.Windows.Forms.Button();
		this.button3 = new System.Windows.Forms.Button();
		this.panel1 = new System.Windows.Forms.Panel();
		this.panel1.SuspendLayout();
		this.SuspendLayout();
		// 
		// label14
		// 
		this.label14.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label14.Location = new System.Drawing.Point(15, 33);
		this.label14.Name = "label14";
		this.label14.Size = new System.Drawing.Size(113, 19);
		this.label14.TabIndex = 1;
		this.label14.Text = "视 频 输 入 设 备";
		// 
		// cmb_ss_type
		// 
		this.cmb_ss_type.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold);
		this.cmb_ss_type.FormattingEnabled = true;
		this.cmb_ss_type.Items.AddRange(new Object[] {"普通外科手术", "妇科手术", "眼科手术", "耳鼻喉科手术"});
		this.cmb_ss_type.Location = new System.Drawing.Point(144, 31);
		this.cmb_ss_type.Name = "cmb_ss_type";
		this.cmb_ss_type.Size = new System.Drawing.Size(210, 27);
		this.cmb_ss_type.TabIndex = 7;
		// 
		// btnLogin
		// 
		this.btnLogin.BackColor = System.Drawing.Color.SeaGreen;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnLogin.FlatAppearance.BorderSize = 0;
		this.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnLogin.ForeColor = System.Drawing.SystemColors.Window;
		this.btnLogin.Location = new System.Drawing.Point(399, 31);
		this.btnLogin.Name = "btnLogin";
		this.btnLogin.Size = new System.Drawing.Size(94, 29);
		this.btnLogin.TabIndex = 12;
		this.btnLogin.Text = "打开摄像头";
		this.btnLogin.UseVisualStyleBackColor = false;
		// 
		// button1
		// 
		this.button1.BackColor = System.Drawing.Color.SeaGreen;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button1.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button1.FlatAppearance.BorderSize = 0;
		this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button1.ForeColor = System.Drawing.SystemColors.Window;
		this.button1.Location = new System.Drawing.Point(525, 31);
		this.button1.Name = "button1";
		this.button1.Size = new System.Drawing.Size(94, 29);
		this.button1.TabIndex = 12;
		this.button1.Text = "关闭摄像头";
		this.button1.UseVisualStyleBackColor = false;
		// 
		// button2
		// 
		this.button2.BackColor = System.Drawing.Color.SeaGreen;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button2.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button2.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button2.FlatAppearance.BorderSize = 0;
		this.button2.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button2.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button2.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button2.ForeColor = System.Drawing.SystemColors.Window;
		this.button2.Location = new System.Drawing.Point(646, 31);
		this.button2.Name = "button2";
		this.button2.Size = new System.Drawing.Size(94, 29);
		this.button2.TabIndex = 12;
		this.button2.Text = "拍 照";
		this.button2.UseVisualStyleBackColor = false;
		// 
		// button3
		// 
		this.button3.BackColor = System.Drawing.Color.SeaGreen;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button3.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button3.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.button3.FlatAppearance.BorderSize = 0;
		this.button3.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.button3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.button3.ForeColor = System.Drawing.SystemColors.Window;
		this.button3.Location = new System.Drawing.Point(769, 31);
		this.button3.Name = "button3";
		this.button3.Size = new System.Drawing.Size(94, 29);
		this.button3.TabIndex = 12;
		this.button3.Text = "退 出";
		this.button3.UseVisualStyleBackColor = false;
		// 
		// panel1
		// 
		this.panel1.Controls.Add(this.btnLogin);
		this.panel1.Controls.Add(this.button3);
		this.panel1.Controls.Add(this.label14);
		this.panel1.Controls.Add(this.button2);
		this.panel1.Controls.Add(this.cmb_ss_type);
		this.panel1.Controls.Add(this.button1);
		this.panel1.Location = new System.Drawing.Point(0, 1);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(910, 89);
		this.panel1.TabIndex = 13;
		// 
		// Form_mettingOn
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.ClientSize = new System.Drawing.Size(913, 660);
		this.Controls.Add(this.panel1);
		this.Name = "Form_mettingOn";
		this.Text = "Form_mettingOn";
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Label label14;
	private System.Windows.Forms.ComboBox cmb_ss_type;
	private System.Windows.Forms.Button btnLogin;
	private System.Windows.Forms.Button button1;
	private System.Windows.Forms.Button button2;
	private System.Windows.Forms.Button button3;
	private System.Windows.Forms.Panel panel1;
}