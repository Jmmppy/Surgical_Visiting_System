package windowsformsapp1;

import Models.*;
import BLL.*;
import java.util.*;

public class Create_Meeting2 extends Form
{
	private ss_visitTableBll ss_visitTableBll_;
	private ArrayList<cur_ss_visitTable> cur_ss_visitTable_;
	private cur_ss_visitTable[] cur_table_list;
	private ArrayList<Integer> cur_panl_click_indexList = new ArrayList<Integer>();
	private ArrayList<String> illnessIdList = new ArrayList<String>(); //记录选中的患者id列表

	private int table_length;
	private Form_Route Form_Route_;
	private Create_Meeting1 Create_Meeting1_;
	public Create_Meeting2(cur_ss_visitTable[] table_list, ArrayList<Integer> panl_click_indexList)
	{
		InitializeComponent();
		cur_table_list = table_list;
		cur_panl_click_indexList = panl_click_indexList;
	}

	private void Create_Meeting2_Load(Object sender, tangible.EventArgs e)
	{
		this.labSum.Text = String.valueOf(tangible.IntegerLists.toArray(cur_panl_click_indexList).length);
		System.out.println("---------------Create_Meeting2 : Form-------------------");
		// 拿到单击的index列表
		for (int i : cur_panl_click_indexList)
		{
			System.out.println(cur_table_list[i].patient_name.toString());
		}


	}

	private void btnRoute_Click(Object sender, tangible.EventArgs e)
	{
		Form_Route_ = new Form_Route(cur_table_list, cur_panl_click_indexList);
		Form_Route_.ShowDialog();
		this.Close();
	}

	private void btnCreate_Click(Object sender, tangible.EventArgs e)
	{
		ArrayList<String> str_illnessId = new ArrayList<String>();
		// 拿到单击的index列表
		for (int i : cur_panl_click_indexList)
		{
			str_illnessId.add(cur_table_list[i].illness_id.toString());
		}
		Create_Meeting1_ = new Create_Meeting1(str_illnessId);
		this.Hide();
		if (Create_Meeting1_.ShowDialog() == System.Windows.Forms.DialogResult.OK)
		{
			//MessageBox.Show(string.Format("成功"));
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
		System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(Create_Meeting2.class);
		this.btnCreate = new System.Windows.Forms.Button();
		this.btnRoute = new System.Windows.Forms.Button();
		this.labName1 = new System.Windows.Forms.Label();
		this.labSum = new System.Windows.Forms.Label();
		this.label2 = new System.Windows.Forms.Label();
		this.pictureBox6 = new System.Windows.Forms.PictureBox();
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
		this.SuspendLayout();
		// 
		// btnCreate
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnCreate.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.btnCreate.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnCreate.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnCreate.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnCreate.FlatAppearance.BorderSize = 0;
		this.btnCreate.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnCreate.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnCreate.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnCreate.ForeColor = System.Drawing.SystemColors.Window;
		this.btnCreate.Location = new System.Drawing.Point(33, 523);
		this.btnCreate.Name = "btnCreate";
		this.btnCreate.Size = new System.Drawing.Size(210, 31);
		this.btnCreate.TabIndex = 13;
		this.btnCreate.Text = "创建会议";
		this.btnCreate.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnCreate.Click += new System.EventHandler(this.btnCreate_Click);
		// 
		// btnRoute
		// 
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnRoute.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
		this.btnRoute.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(117)))), ((int)(((byte)(83)))), ((int)(((byte)(180)))));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnRoute.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnRoute.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnRoute.FlatAppearance.BorderSize = 0;
		this.btnRoute.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnRoute.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnRoute.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnRoute.ForeColor = System.Drawing.SystemColors.Window;
		this.btnRoute.Location = new System.Drawing.Point(33, 468);
		this.btnRoute.Name = "btnRoute";
		this.btnRoute.Size = new System.Drawing.Size(210, 32);
		this.btnRoute.TabIndex = 13;
		this.btnRoute.Text = "推荐路线";
		this.btnRoute.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnRoute.Click += new System.EventHandler(this.btnRoute_Click);
		// 
		// labName1
		// 
		this.labName1.AutoSize = true;
		this.labName1.BackColor = System.Drawing.Color.White;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labName1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labName1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labName1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.labName1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.labName1.Location = new System.Drawing.Point(37, 379);
		this.labName1.Name = "labName1";
		this.labName1.Size = new System.Drawing.Size(74, 22);
		this.labName1.TabIndex = 14;
		this.labName1.Text = "已选择：";
		// 
		// labSum
		// 
		this.labSum.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labSum.Font = new System.Drawing.Font("微软雅黑", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.labSum.Font = new System.Drawing.Font("微软雅黑", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.labSum.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(185)))), ((int)(((byte)(36)))));
		this.labSum.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(252)))), ((int)(((byte)(185)))), ((int)(((byte)(36)))));
		this.labSum.Location = new System.Drawing.Point(127, 377);
		this.labSum.Name = "labSum";
		this.labSum.Size = new System.Drawing.Size(25, 28);
		this.labSum.TabIndex = 14;
		this.labSum.Text = "0";
		// 
		// label2
		// 
		this.label2.AutoSize = true;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.label2.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.label2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.label2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(152)))), ((int)(((byte)(119)))), ((int)(((byte)(198)))));
		this.label2.Location = new System.Drawing.Point(169, 379);
		this.label2.Name = "label2";
		this.label2.Size = new System.Drawing.Size(63, 22);
		this.label2.TabIndex = 14;
		this.label2.Text = "名 患者";
		// 
		// pictureBox6
		// 
		this.pictureBox6.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox6.BackgroundImage")));
		this.pictureBox6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
		this.pictureBox6.Location = new System.Drawing.Point(1, 0);
		this.pictureBox6.Name = "pictureBox6";
		this.pictureBox6.Size = new System.Drawing.Size(290, 267);
		this.pictureBox6.TabIndex = 15;
		this.pictureBox6.TabStop = false;
		// 
		// Create_Meeting2
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.ButtonHighlight;
		this.ClientSize = new System.Drawing.Size(292, 605);
		this.Controls.Add(this.pictureBox6);
		this.Controls.Add(this.label2);
		this.Controls.Add(this.labSum);
		this.Controls.Add(this.labName1);
		this.Controls.Add(this.btnRoute);
		this.Controls.Add(this.btnCreate);
		this.Name = "Create_Meeting2";
		this.Text = "创建会议";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Create_Meeting2_Load);
		((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
		this.ResumeLayout(false);
		this.PerformLayout();

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.Button btnCreate;
	private System.Windows.Forms.Button btnRoute;
	private System.Windows.Forms.Label labName1;
	private System.Windows.Forms.Label labSum;
	private System.Windows.Forms.Label label2;
	private System.Windows.Forms.PictureBox pictureBox6;
}