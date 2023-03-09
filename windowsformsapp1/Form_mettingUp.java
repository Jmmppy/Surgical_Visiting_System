package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;
import java.time.*;

public class Form_mettingUp extends Form
{
	private meeting_tableBll meeting_tableBll_ = new meeting_tableBll();
	private meeting_table cur_meeting_Table;
	private LocalDateTime t1 = LocalDateTime.MIN;
	private LocalDateTime t2 = LocalDateTime.MIN;
	public Form_mettingUp(meeting_table meeting_Table)
	{
		cur_meeting_Table = meeting_Table;
		InitializeComponent();
		int x = System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Size.Width - this.Width;
		int y = System.Windows.Forms.Screen.PrimaryScreen.WorkingArea.Size.Height - this.Height;
		Point p = new Point(x, y);
		this.PointToScreen(p);
		this.Location = p;


	}

	private void Form_mettingUp_Load(Object sender, tangible.EventArgs e)
	{
		this.lab_title.Text = cur_meeting_Table.meeting_name.toString();
		t1 = (LocalDateTime)cur_meeting_Table.start_time;
		t2 = (LocalDateTime)cur_meeting_Table.end_time;

		this.lab_start.Text = String.valueOf(t1.getHour()) + ":" + String.valueOf(t1.getMinute());
		this.lab_end.Text = String.valueOf(t2.getHour()) + ":" + String.valueOf(t2.getMinute());
		this.lab_count.Text = cur_meeting_Table.illness_id_count.toString();

	}

	private void btnOK_Click(Object sender, tangible.EventArgs e)
	{




	}
	/** 
	 推迟
	 
	 @param sender
	 @param e
	*/
	private void pictureBox6_Click(Object sender, tangible.EventArgs e)
	{
		String laid_time = this.comboBox1.Text;
		LocalDateTime start_time = LocalDateTime.MIN;
		int row = 0;
		if (laid_time.length() != 0)
		{ //更新开始时间
			if (laid_time.equals("5分钟"))
			{
				start_time = t1.plusMinutes(5);
				//跟新到数据库
				row = meeting_tableBll_.update_isMeeting2(cur_meeting_Table.meeting_id, start_time);

			}
			else if (laid_time.equals("10分钟"))
			{
				start_time = t1.plusMinutes(10);
				row = meeting_tableBll_.update_isMeeting2(cur_meeting_Table.meeting_id, start_time);
			}
			else
			{ //laid_time == "15分钟"
				start_time = t1.plusMinutes(15);
				row = meeting_tableBll_.update_isMeeting2(cur_meeting_Table.meeting_id, start_time);
			}
		}
		if (row == 1)
		{
			MessageBox.Show(String.format("成功推迟"));
			this.Close();
		}

	}

	private void picB_ok_Click(Object sender, tangible.EventArgs e)
	{
		//加入会议

		Form1 Form1_ = new Form1(cur_meeting_Table); ////////////////////////
		//Form1 Form1_ = new Form1();

		this.Close();
		this.DialogResult = System.Windows.Forms.DialogResult.OK;
		Form1_.Show();
	}

	private void picB_close_Click(Object sender, tangible.EventArgs e)
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Form_mettingUp.class);
		this.label1 = new System.Windows.Forms.Label();
		this.lab_count = new System.Windows.Forms.Label();
		this.label4 = new System.Windows.Forms.Label();
		this.label5 = new System.Windows.Forms.Label();
		this.lab_title = new System.Windows.Forms.Label();
		this.lab_start = new System.Windows.Forms.Label();
		this.label8 = new System.Windows.Forms.Label();
		this.lab_end = new System.Windows.Forms.Label();
		this.label3 = new System.Windows.Forms.Label();
		this.comboBox1 = new System.Windows.Forms.ComboBox();
		this.label11 = new System.Windows.Forms.Label();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		this.picB_ok = new System.Windows.Forms.PictureBox();
		this.label10 = new System.Windows.Forms.Label();
		this.picB_close = new System.Windows.Forms.PictureBox();
		this.label12 = new System.Windows.Forms.Label();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.picB_ok)).BeginInit();
		((System.ComponentModel.ISupportInitialize)(this.picB_close)).BeginInit();
		this.SuspendLayout();
		// 
		// label1
		// 
		this.label1.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label1.Location = new System.Drawing.Point(227, 15);
		this.label1.Name = "label1";
		this.label1.Size = new System.Drawing.Size(74, 22);
		this.label1.TabIndex = 4;
		this.label1.Text = "患者数：";
		// 
		// lab_count
		// 
		this.lab_count.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lab_count.Font = new System.Drawing.Font("微软雅黑", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_count.Font = new System.Drawing.Font("微软雅黑", 12F, (System.Drawing.FontStyle.forValue((System.Drawing.FontStyle.Bold.getValue() | System.Drawing.FontStyle.Underline.getValue()))), System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_count.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.lab_count.Location = new System.Drawing.Point(297, 15);
		this.lab_count.Name = "lab_count";
		this.lab_count.Size = new System.Drawing.Size(74, 22);
		this.lab_count.TabIndex = 4;
		this.lab_count.Text = "您创建的";
		// 
		// label4
		// 
		this.label4.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label4.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label4.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label4.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(184)))), ((int)(((byte)(43)))));
		this.label4.Location = new System.Drawing.Point(102, 107);
		this.label4.Name = "label4";
		this.label4.Size = new System.Drawing.Size(180, 22);
		this.label4.TabIndex = 4;
		this.label4.Text = "不足5分钟就要开始了！";
		// 
		// label5
		// 
		this.label5.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label5.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label5.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
		this.label5.Location = new System.Drawing.Point(19, 15);
		this.label5.Name = "label5";
		this.label5.Size = new System.Drawing.Size(74, 22);
		this.label5.TabIndex = 4;
		this.label5.Text = "会议名称";
		// 
		// lab_title
		// 
		this.lab_title.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lab_title.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_title.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_title.ForeColor = System.Drawing.Color.DimGray;
		this.lab_title.Location = new System.Drawing.Point(29, 41);
		this.lab_title.Name = "lab_title";
		this.lab_title.Size = new System.Drawing.Size(51, 19);
		this.lab_title.TabIndex = 4;
		this.lab_title.Text = "办公室";
		// 
		// lab_start
		// 
		this.lab_start.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lab_start.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_start.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_start.ForeColor = System.Drawing.Color.DimGray;
		this.lab_start.Location = new System.Drawing.Point(29, 60);
		this.lab_start.Name = "lab_start";
		this.lab_start.Size = new System.Drawing.Size(51, 19);
		this.lab_start.TabIndex = 4;
		this.lab_start.Text = "办公室";
		// 
		// label8
		// 
		this.label8.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label8.ForeColor = System.Drawing.Color.DimGray;
		this.label8.Location = new System.Drawing.Point(81, 59);
		this.label8.Name = "label8";
		this.label8.Size = new System.Drawing.Size(15, 19);
		this.label8.TabIndex = 4;
		this.label8.Text = "-";
		// 
		// lab_end
		// 
		this.lab_end.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.lab_end.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_end.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.lab_end.ForeColor = System.Drawing.Color.DimGray;
		this.lab_end.Location = new System.Drawing.Point(102, 61);
		this.lab_end.Name = "lab_end";
		this.lab_end.Size = new System.Drawing.Size(51, 19);
		this.lab_end.TabIndex = 4;
		this.lab_end.Text = "办公室";
		// 
		// label3
		// 
		this.label3.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label3.ForeColor = System.Drawing.Color.WhiteSmoke;
		this.label3.Location = new System.Drawing.Point(29, 155);
		this.label3.Name = "label3";
		this.label3.Size = new System.Drawing.Size(37, 19);
		this.label3.TabIndex = 4;
		this.label3.Text = "暂停";
		// 
		// comboBox1
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.comboBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(35)))), ((int)(((byte)(35)))));
		this.comboBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(35)))), ((int)(((byte)(35)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.comboBox1.Font = new System.Drawing.Font("微软雅黑", 7.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.comboBox1.Font = new System.Drawing.Font("微软雅黑", 7.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.comboBox1.ForeColor = System.Drawing.SystemColors.InactiveBorder;
		this.comboBox1.FormattingEnabled = true;
		this.comboBox1.Items.AddRange(new Object[] {"5分钟", "10分钟", "15分钟"});
		this.comboBox1.Location = new System.Drawing.Point(33, 182);
		this.comboBox1.Name = "comboBox1";
		this.comboBox1.Size = new System.Drawing.Size(349, 24);
		this.comboBox1.TabIndex = 16;
		// 
		// label11
		// 
		this.label11.AutoSize = true;
		this.label11.Location = new System.Drawing.Point(54, 284);
		this.label11.Name = "label11";
		this.label11.Size = new System.Drawing.Size(29, 12);
		this.label11.TabIndex = 18;
		this.label11.Text = "推迟";
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(55, 240);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(27, 32);
		this.pictureBox6.TabIndex = 17;
		this.pictureBox6.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.pictureBox6.Click += new System.EventHandler(this.pictureBox6_Click);
		// 
		// picB_ok
		// 
		this.picB_ok.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("picB_ok.BackgroundImage")));
		this.picB_ok.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.picB_ok.Location = new System.Drawing.Point(176, 240);
		this.picB_ok.Name = "picB_ok";
		this.picB_ok.Size = new System.Drawing.Size(27, 32);
		this.picB_ok.TabIndex = 17;
		this.picB_ok.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.picB_ok.Click += new System.EventHandler(this.picB_ok_Click);
		// 
		// label10
		// 
		this.label10.AutoSize = true;
		this.label10.Location = new System.Drawing.Point(163, 284);
		this.label10.Name = "label10";
		this.label10.Size = new System.Drawing.Size(53, 12);
		this.label10.TabIndex = 18;
		this.label10.Text = "进入会议";
		// 
		// picB_close
		// 
		this.picB_close.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("picB_close.BackgroundImage")));
		this.picB_close.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.picB_close.Location = new System.Drawing.Point(301, 240);
		this.picB_close.Name = "picB_close";
		this.picB_close.Size = new System.Drawing.Size(27, 32);
		this.picB_close.TabIndex = 17;
		this.picB_close.TabStop = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.picB_close.Click += new System.EventHandler(this.picB_close_Click);
		// 
		// label12
		// 
		this.label12.AutoSize = true;
		this.label12.Location = new System.Drawing.Point(300, 284);
		this.label12.Name = "label12";
		this.label12.Size = new System.Drawing.Size(29, 12);
		this.label12.TabIndex = 18;
		this.label12.Text = "取消";
		// 
		// Form_mettingUp
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(35)))), ((int)(((byte)(35)))));
		this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(35)))), ((int)(((byte)(35)))), ((int)(((byte)(35)))));
		this.ClientSize = new System.Drawing.Size(409, 318);
		this.Controls.Add(this.label12);
		this.Controls.Add(this.label10);
		this.Controls.Add(this.label11);
		this.Controls.Add(this.picB_close);
		this.Controls.Add(this.picB_ok);
		this.Controls.Add(this.pictureBox6);
		this.Controls.Add(this.comboBox1);
		this.Controls.Add(this.label4);
		this.Controls.Add(this.lab_count);
		this.Controls.Add(this.lab_end);
		this.Controls.Add(this.label8);
		this.Controls.Add(this.lab_start);
		this.Controls.Add(this.label3);
		this.Controls.Add(this.lab_title);
		this.Controls.Add(this.label5);
		this.Controls.Add(this.label1);
		this.ForeColor = System.Drawing.SystemColors.ButtonFace;
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
		this.Name = "Form_mettingUp";
		this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
		this.Text = "会议提醒";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_mettingUp_Load);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.picB_ok)).EndInit();
		((System.ComponentModel.ISupportInitialize)(this.picB_close)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Label label1;
	private System.Windows.Forms.Label lab_count;
	private System.Windows.Forms.Label label4;
	private System.Windows.Forms.Label label5;
	private System.Windows.Forms.Label lab_title;
	private System.Windows.Forms.Label lab_start;
	private System.Windows.Forms.Label label8;
	private System.Windows.Forms.Label lab_end;
	private System.Windows.Forms.Label label3;
	private System.Windows.Forms.ComboBox comboBox1;
	private System.Windows.Forms.Label label11;
	private System.Windows.Forms.PictureBox pictureBox6;
	private System.Windows.Forms.PictureBox picB_ok;
	private System.Windows.Forms.Label label10;
	private System.Windows.Forms.PictureBox picB_close;
	private System.Windows.Forms.Label label12;
}