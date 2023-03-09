package windowsformsapp1;

import BLL.*;
import Models.*;
import java.util.*;

public class login extends Form
{
	private String str;
	private Doc_loginBLL LoginBLL = new Doc_loginBLL(); // 初始化BLL登录类对象
	public int cur_doctor_id; //保存当前登录成功的id
	public login() //出生化界面类
	{
		InitializeComponent();
		YZM();
	}

	private void btnLogin_Click(Object sender, tangible.EventArgs e)
	{
		if (!txtUser.Text.equals("") && !txtPsword.Text.equals(""))
		{ //初始化，doc_table表对象(有id， 密码)
			doc_table doc_Table = new doc_table();
			doc_Table.setdoctor_id(Integer.parseInt(this.txtUser.Text.strip()));
			doc_Table.setpwd(this.txtPsword.Text.strip());
			boolean res;
			res = LoginBLL.login(doc_Table);
			if (txtNumber.Text.equals(str))
			{
				if (res)
				{
					cur_doctor_id = doc_Table.doctor_id;
					//MainMain MainForm = new MainMain();// 创建主窗体
					//MainForm.Show();  //显示主页面
					//this.Owner.Hide();
					this.DialogResult = System.Windows.Forms.DialogResult.OK;
					this.Close();
					MessageBox.Show(String.format("成功%1$s", cur_doctor_id));
					System.out.printf("-------ok:%1$s" + "\r\n", cur_doctor_id);
				}
				else
				{
					MessageBox.Show("密码账号出错，请重新输入！");
					YZM(); //同时更改验证码
				}
			}
			else
			{
				MessageBox.Show("验证码不正确请重新输入", "提示");
				YZM(); //同时更改验证码
			}
		}
		else
		{
			MessageBox.Show("密码账号出错，请重新输入！");
		}
		//定义新表对象用来保存登录成功后的，














	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 验证码
	//产生随机数图片
	private void YZM() //方法
	{
		Random r = new Random(); //产生随机数
		str = null;
		for (int i = 0; i < 5; i++)
		{
			int rNumber = r.nextInt(10);
			str += rNumber;
		} //用循环产生所需循环的数量

		//  label1.Text = str;

		Bitmap bmp = new Bitmap(90, 30); //创建一个位图

		Graphics g = Graphics.FromImage(bmp);



		for (int i = 0; i < 5; i++)
		{
			Point p = new Point(i * 15, 0);
			String[] fonts = {"宋体", "黑体", "仿宋", "隶书", "楷书"};
			Color[] colors = {Color.Red, Color.Blue, Color.Green, Color.Black, Color.Pink};
			g.DrawString(str.charAt(i).toString(), new Font(fonts[r.nextInt(4)], 20, FontStyle.Bold), new SolidBrush(colors[r.nextInt(4)]), p);

		} //画随机数

		//for (int i = 0; i < 10; i++)

		//{

		//    Point p1 =new Point(r.Next(0,bmp.Width),r.Next(0,bmp.Height));

		//     Point p2 =new Point(r.Next(0,bmp.Width),r.Next(0,bmp.Height));

		//   g.DrawLine(new Pen(Brushes.Green),p1,p2); 

		//}//随机数上横线

		for (int i = 0; i < 1500; i++)
		{
			Point p = new Point(r.nextInt(bmp.Width), r.nextInt(bmp.Height));

			bmp.SetPixel(p.X, p.Y, Color.Black);

		} //随机数背景加像素

		//将图片放到Picturebox中
		pictureBox2.Image = bmp; //把图片放到 位图上

	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion 验证码
	//点击图片 换一个验证码
	private void pictureBox2_Click(Object sender, tangible.EventArgs e)
	{
		YZM();
	}
	//点击label，换一个验证码
	private void labelBtn_Click(Object sender, tangible.EventArgs e)
	{
		YZM();
	}

	private void btnCancel_Click(Object sender, tangible.EventArgs e) //取消按钮 退出程序
	{
		System.exit(0);
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(login.class);
		this.label1 = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.label3 = new System.Windows.Forms.Label();
		this.panel1 = new System.Windows.Forms.Panel();
		this.btnCancel = new System.Windows.Forms.Button();
		this.btnLogin = new System.Windows.Forms.Button();
		this.labelBtn = new System.Windows.Forms.Label();
		this.pictureBox2 = new System.Windows.Forms.PictureBox();
		this.pictureBox1 = new System.Windows.Forms.PictureBox();
		this.txtNumber = new System.Windows.Forms.TextBox();
		this.txtPsword = new System.Windows.Forms.TextBox();
		this.txtUser = new System.Windows.Forms.TextBox();
		this.label4 = new System.Windows.Forms.Label();
		this.panel1.SuspendLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
		this.SuspendLayout();
		// 
		// label1
		// 
		this.label1.AutoSize = true;
		this.label1.BackColor = System.Drawing.SystemColors.Control;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.ForeColor = System.Drawing.Color.SeaGreen;
		this.label1.Location = new System.Drawing.Point(257, 56);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(344, 42);
		this.label1.TabIndex = 0;
		this.label1.Text = "手 术 麻 醉 访 视 系 统";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.ForeColor = System.Drawing.Color.SeaGreen;
		this.label2.Location = new System.Drawing.Point(31, 40);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(64, 17);
		this.label2.TabIndex = 1;
		this.label2.Text = "用 户 名：";
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.ForeColor = System.Drawing.Color.SeaGreen;
		this.label3.Location = new System.Drawing.Point(31, 74);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(56, 17);
		this.label3.TabIndex = 2;
		this.label3.Text = "密   码：";
		// 
		// panel1
		// 
		this.panel1.Controls.Add(this.btnCancel);
		this.panel1.Controls.Add(this.btnLogin);
		this.panel1.Controls.Add(this.labelBtn);
		this.panel1.Controls.Add(this.pictureBox2);
		this.panel1.Controls.Add(this.pictureBox1);
		this.panel1.Controls.Add(this.txtNumber);
		this.panel1.Controls.Add(this.txtPsword);
		this.panel1.Controls.Add(this.txtUser);
		this.panel1.Controls.Add(this.label4);
		this.panel1.Controls.Add(this.label2);
		this.panel1.Controls.Add(this.label3);
		this.panel1.Location = new System.Drawing.Point(313, 153);
		this.panel1.Name = "panel1";
		this.panel1.Size = new System.Drawing.Size(373, 225);
		this.panel1.TabIndex = 4;
		// 
		// btnCancel
		// 
		this.btnCancel.BackColor = System.Drawing.Color.SeaGreen;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnCancel.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnCancel.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnCancel.FlatAppearance.BorderSize = 0;
		this.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnCancel.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnCancel.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnCancel.ForeColor = System.Drawing.SystemColors.Window;
		this.btnCancel.Location = new System.Drawing.Point(146, 161);
		this.btnCancel.Name = "btnCancel";
		this.btnCancel.Size = new System.Drawing.Size(99, 29);
		this.btnCancel.TabIndex = 10;
		this.btnCancel.Text = "取  消";
		this.btnCancel.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
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
		this.btnLogin.Location = new System.Drawing.Point(35, 161);
		this.btnLogin.Name = "btnLogin";
		this.btnLogin.Size = new System.Drawing.Size(94, 29);
		this.btnLogin.TabIndex = 10;
		this.btnLogin.Text = "登  录";
		this.btnLogin.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
		// 
		// labelBtn
		// 
		this.labelBtn.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labelBtn.Font = new System.Drawing.Font("微软雅黑", 7.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labelBtn.Font = new System.Drawing.Font("微软雅黑", 7.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labelBtn.Location = new System.Drawing.Point(268, 125);
		this.labelBtn.Name = "labelBtn";
		this.labelBtn.Size = new System.Drawing.Size(58, 16);
		this.labelBtn.TabIndex = 9;
		this.labelBtn.Text = "点击换一张";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.labelBtn.Click += new System.EventHandler(this.labelBtn_Click);
		// 
		// pictureBox2
		// 
		this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox2.Location = new System.Drawing.Point(260, 94);
		this.pictureBox2.Name = "pictureBox2";
		this.pictureBox2.Size = new System.Drawing.Size(84, 31);
		this.pictureBox2.TabIndex = 8;
		this.pictureBox2.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click);
		// 
		// pictureBox1
		// 
		this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
		this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox1.Location = new System.Drawing.Point(281, 24);
		this.pictureBox1.Name = "pictureBox1";
		this.pictureBox1.Size = new System.Drawing.Size(61, 46);
		this.pictureBox1.TabIndex = 7;
		this.pictureBox1.TabStop = false;
		// 
		// txtNumber
		// 
		this.txtNumber.Location = new System.Drawing.Point(112, 111);
		this.txtNumber.Name = "txtNumber";
		this.txtNumber.Size = new System.Drawing.Size(133, 21);
		this.txtNumber.TabIndex = 6;
		// 
		// txtPsword
		// 
		this.txtPsword.Location = new System.Drawing.Point(112, 74);
		this.txtPsword.Name = "txtPsword";
		this.txtPsword.PasswordChar = '*';
		this.txtPsword.Size = new System.Drawing.Size(133, 21);
		this.txtPsword.TabIndex = 5;
		// 
		// txtUser
		// 
		this.txtUser.Location = new System.Drawing.Point(112, 40);
		this.txtUser.Name = "txtUser";
		this.txtUser.Size = new System.Drawing.Size(133, 21);
		this.txtUser.TabIndex = 4;
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.ForeColor = System.Drawing.Color.SeaGreen;
		this.label4.Location = new System.Drawing.Point(32, 111);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(64, 17);
		this.label4.TabIndex = 3;
		this.label4.Text = "验 证 码：";
		// 
		// login
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
		this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.ClientSize = new System.Drawing.Size(748, 475);
		this.Controls.Add(this.panel1);
		this.Controls.Add(this.label1);
		this.Cursor = System.Windows.Forms.Cursors.Default;
		this.DoubleBuffered = true;
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.MaximumSize = new System.Drawing.Size(748, 475);
		this.MinimumSize = new System.Drawing.Size(748, 475);
		this.Name = "login";
		this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
		this.Text = "login";
		this.panel1.ResumeLayout(false);
		this.panel1.PerformLayout();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.Panel panel1;
	private System.Windows.Forms.Button btnCancel;
	private System.Windows.Forms.Button btnLogin;
	private System.Windows.Forms.Label labelBtn;
	private System.Windows.Forms.PictureBox pictureBox2;
	private System.Windows.Forms.PictureBox pictureBox1;
	private System.Windows.Forms.TextBox txtNumber;
	private System.Windows.Forms.TextBox txtPsword;
	private System.Windows.Forms.TextBox txtUser;
	private System.Windows.Forms.Label label4;
}