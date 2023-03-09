package windowsformsapp1;

import Models.*;
import BLL.*;
import Utility.*;
import java.util.*;

public class Form_arrage1 extends Form
{
	private ArrayList<Integer> nurse_table_idList = new ArrayList<Integer>();
	private int nurse_table_idList_length;
	private ArrayList<Integer> narcosis_docTable_idList = new ArrayList<Integer>();
	private int narcosis_docTable_idList_length;
	private ArrayList<String> operation_roomList = new ArrayList<String>();
	private Map<String, Integer> operation_room_dic = new HashMap<String, Integer>();
	private HashMap<Integer, Integer> ListToDictionary_nurseId;
	private HashMap<Integer, Integer> ListToDictionary_narcosisId;
	private int operation_room_dic_length;
	//numberNames.Add(1,"One"); //使用Add()方法添加键/值
	//numberNames.Add(2,"Two");
	//numberNames.Add(3,"Three");
	private int curTable_length; //记录显示表的长度
	private patient_tableBll patient_tableBll_ = new patient_tableBll();
	private nurse_tableBll nurse_tableBll_ = new nurse_tableBll();
	private narcosis_docTableBll narcosis_docTableBll_ = new narcosis_docTableBll();
	private ArrayList<cur_patient_table> cur_patient_table_22; //全局对象列表 用于记录当前显示的行对象
	public Form_arrage1()
	{
		InitializeComponent();
	}

	private void Form_arrage1_Load(Object sender, tangible.EventArgs e)
	{
		start_dgv();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 初始化手术台
		operation_roomList.add("A1");
		operation_roomList.add("A2");
		operation_roomList.add("A3");
		operation_roomList.add("A4");
		operation_roomList.add("A5");
		//获取字典的长度——》没空写所以取巧……
		operation_room_dic.put("A1",1);
		operation_room_dic.put("A2", 1);
		operation_room_dic.put("A3", 1);
		operation_room_dic.put("A4", 1);
		operation_room_dic.put("A5", 1);
		//获取字典的长度——》没空写所以取巧……
		operation_room_dic_length = operation_roomList.toArray(new String[0]).length;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 初始化手术台

		ArrayList<nurse_table> nurse_table_list = nurse_tableBll_.GetNurse_tableList1();
		ArrayList<narcosis_docTable> narcosis_docTable_ = narcosis_docTableBll_.GetNarcosis_docTableList1();
		nurse_table_idList_length = nurse_table_list.toArray(new nurse_table[0]).length;
		narcosis_docTable_idList_length = narcosis_docTable_.toArray(new narcosis_docTable[0]).length;
		//Console.WriteLine("长度：    ok" + nurse_table_idList_length);          //检验正确
		//Console.WriteLine("长度：    ok" + narcosis_docTable_idList_length);

		for (var li : nurse_table_list)
		{
			nurse_table_idList.add(li.nurse_id);
		}
		for (var li : narcosis_docTable_)
		{
			narcosis_docTable_idList.add(li.narcosis_doc_id);
		}

		ListToDictionary_nurseId = nurse_table_idList.ToDictionary(key -> key, value -> value = 1);
		ListToDictionary_narcosisId = narcosis_docTable_idList.ToDictionary(key -> key, value -> value = 1);


		//foreach (var li in ListToDictionary_nurseId)    //检验正确
		//{
		//    Console.WriteLine("key" + li.Key + "  Value:" + li.Value);
		//}
		//foreach (var li in nurse_table_idList)    //检验正确
		//{
		//    Console.WriteLine(li);
		//}
		//foreach (var li in narcosis_docTable_idList)    //检验正确
		//{
		//    Console.WriteLine(li);
		//}

	}
	private void start_dgv()
	{



//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#region 绑定n表数据
		// 初始化绑定notice_table表数据
		this.dgvss_visit.AutoGenerateColumns = false; //控制DataGriView只显示需要的列
		// this.dgvss_visit.DataSource = ss_visitTableBll_.GetSs_visitTableList(); //方法一
		ArrayList<cur_patient_table> cur_patient_table_ = patient_tableBll_.GetPatient_tableList2();
		//curTable_length = cur_patient_table_.ToArray().Length;
		cur_patient_table_22 = tangible.ListHelper.findAll(cur_patient_table_, m -> m.Isinput == true);
		curTable_length = cur_patient_table_22.toArray(new cur_patient_table[0]).length;
		this.dgvss_visit.DataSource = cur_patient_table_22; // 这里只选择写过的



//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
			///#endregion 绑定notice_table表数据
	}

	private void btnOk_Click(Object sender, tangible.EventArgs e)
	{
		int nurse_table_id_;
		int narcosis_docTableId_;
		String operation_room_;
		Random Random_nurse_table_id = new Random();
		Random Random_narcosis_docTable = new Random();
		Random Random_operation_room_dic = new Random();
		int j_1;
		int j_2;
		int j_3;
		int max = 5; //每个医师不能超过多少次
		int ss1;
		int ss2;
		int ss3;
		int row = 0; //记录更新的行数
		int j = 0; //记录有多少次不成功的
		boolean result = true;
		//j_2 = Random_narcosis_docTable.Next(0, narcosis_docTable_idList_length);
		//Console.WriteLine("-----------------------------------ok");
		//narcosis_docTableId_ = narcosis_docTable_idList[j_2];
		//Console.WriteLine("-列表 :"+ narcosis_docTableId_);

		//Console.WriteLine("-字典1 :" + ListToDictionary_narcosisId[narcosis_docTableId_]);
		//ListToDictionary_narcosisId[narcosis_docTableId_] += 1;
		//int ss = ListToDictionary_narcosisId[narcosis_docTableId_];
		//Console.WriteLine("-字典2 :" + ss);
		//foreach (var li in ListToDictionary_narcosisId)    //检验正确
		//{
		//    Console.WriteLine("key" + li.Key + "  Value:" + li.Value);
		//}
		for (int i = 0; i < curTable_length; i++)
		{
			//产生随机数
			while (result == true)
			{
				j_1 = Random_nurse_table_id.nextInt(nurse_table_idList_length);
				j_2 = Random_narcosis_docTable.nextInt(narcosis_docTable_idList_length);
				j_3 = Random_operation_room_dic.nextInt(operation_room_dic_length);

				narcosis_docTableId_ = narcosis_docTable_idList.get(j_2);
				nurse_table_id_ = nurse_table_idList.get(j_1);
				operation_room_ = operation_roomList.get(j_3);
				//判断如果是一个对象的三个随机就不charu
				//三字段的插入
				patient_table patient_table_ = new patient_table();
				patient_table_.setillness_id(cur_patient_table_22.get(i).illness_id);
				patient_table_.setnarcosis_doc_id(narcosis_docTableId_);
				patient_table_.setnurse_id(nurse_table_id_);
				patient_table_.setoperation_room(operation_room_);
				ss1 = ListToDictionary_narcosisId.get(narcosis_docTableId_);
				ss2 = ListToDictionary_nurseId.get(nurse_table_id_);
				//ss3 =
				row = 0;
				if (ss1 <= max && ss2 <= max)
				{
					row = patient_tableBll_.update_patient_table2(patient_table_);
					if (row == 1)
					{ // 更新成功 对应的Value++更改Value值
						ListToDictionary_narcosisId.put(narcosis_docTableId_, ListToDictionary_narcosisId.get(narcosis_docTableId_) + 1);
						ListToDictionary_nurseId.put(nurse_table_id_, ListToDictionary_nurseId.get(nurse_table_id_) + 1);
						operation_room_dic.put(operation_room_, operation_room_dic.get(operation_room_) + 1);
					}
					break;
				}
				else
				{
					result = true;
				}

				// ……
			}



		}
		//已经随机分配成功，
		//分配完再显示
		start_dgv();
		for (var li : ListToDictionary_narcosisId.entrySet()) //检验正确
		{
			System.out.println("key" + li.getKey() + "  Value:" + li.getValue());
		}
	}

	private void dgvss_visit_DoubleClick(Object sender, tangible.EventArgs e)
	{
		Object tempVar = this.dgvss_visit.CurrentRow.DataBoundItem;
		var visit = tempVar instanceof cur_patient_table ? (cur_patient_table)tempVar : null;
		MessageBox.Show(String.format("成功%1$s", visit.illness_id));
		Form_arrage2 Form_arrage2_ = new Form_arrage2(visit);

		Form_arrage2_.ShowDialog();
		start_dgv();


		//右键按钮，回退功能没写：就是把这条记录删除，连通其他的表的记录也删除；恢复到没有申请的时候......
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
		this.dgvss_visit = new System.Windows.Forms.DataGridView();
		this.btnOk = new System.Windows.Forms.Button();
		this.patient_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.age = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.height = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.weigth = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.sickroom = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.pice_place_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.partment_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.diagnosis = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.doc_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.narcosis_doc_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.nurse_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
		this.operation_room = new System.Windows.Forms.DataGridViewTextBoxColumn();
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).BeginInit();
		this.SuspendLayout();
		// 
		// dgvss_visit
		// 
		this.dgvss_visit.AllowUserToAddRows = false;
		this.dgvss_visit.AllowUserToDeleteRows = false;
		this.dgvss_visit.BackgroundColor = System.Drawing.SystemColors.Window;
		this.dgvss_visit.BorderStyle = System.Windows.Forms.BorderStyle.None;
		this.dgvss_visit.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
		this.dgvss_visit.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {this.patient_name, this.age, this.height, this.weigth, this.sickroom, this.pice_place_name, this.partment_name, this.diagnosis, this.doc_name, this.narcosis_doc_name, this.nurse_name, this.operation_room});
		this.dgvss_visit.GridColor = System.Drawing.SystemColors.Control;
		this.dgvss_visit.Location = new System.Drawing.Point(29, 75);
		this.dgvss_visit.MultiSelect = false;
		this.dgvss_visit.Name = "dgvss_visit";
		this.dgvss_visit.ReadOnly = true;
		this.dgvss_visit.RowHeadersBorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.None;
		this.dgvss_visit.RowHeadersVisible = false;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.dgvss_visit.RowTemplate.DefaultCellStyle.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.dgvss_visit.RowTemplate.DefaultCellStyle.Font = new System.Drawing.Font("微软雅黑", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.dgvss_visit.RowTemplate.DefaultCellStyle.SelectionBackColor = System.Drawing.Color.Silver;
		this.dgvss_visit.RowTemplate.DefaultCellStyle.SelectionForeColor = System.Drawing.Color.White;
		this.dgvss_visit.RowTemplate.Height = 23;
		this.dgvss_visit.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
		this.dgvss_visit.Size = new System.Drawing.Size(1114, 546);
		this.dgvss_visit.TabIndex = 8;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.dgvss_visit.DoubleClick += new System.EventHandler(this.dgvss_visit_DoubleClick);
		// 
		// btnOk
		// 
		this.btnOk.BackColor = System.Drawing.Color.SeaGreen;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOk.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOk.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
		this.btnOk.FlatAppearance.BorderSize = 0;
		this.btnOk.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.btnOk.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOk.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
		this.btnOk.ForeColor = System.Drawing.SystemColors.Window;
		this.btnOk.Location = new System.Drawing.Point(115, 636);
		this.btnOk.Name = "btnOk";
		this.btnOk.Size = new System.Drawing.Size(94, 29);
		this.btnOk.TabIndex = 12;
		this.btnOk.Text = "自动分配";
		this.btnOk.UseVisualStyleBackColor = false;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
		// 
		// patient_name
		// 
		this.patient_name.DataPropertyName = "patient_name";
		this.patient_name.HeaderText = "患者名";
		this.patient_name.Name = "patient_name";
		this.patient_name.ReadOnly = true;
		this.patient_name.Width = 90;
		// 
		// age
		// 
		this.age.DataPropertyName = "age";
		this.age.HeaderText = "年龄";
		this.age.Name = "age";
		this.age.ReadOnly = true;
		this.age.Width = 30;
		// 
		// height
		// 
		this.height.DataPropertyName = "height";
		this.height.HeaderText = "身高";
		this.height.Name = "height";
		this.height.ReadOnly = true;
		this.height.Width = 30;
		// 
		// weigth
		// 
		this.weigth.DataPropertyName = "weigth";
		this.weigth.HeaderText = "体重";
		this.weigth.Name = "weigth";
		this.weigth.ReadOnly = true;
		this.weigth.Width = 50;
		// 
		// sickroom
		// 
		this.sickroom.DataPropertyName = "sickroom";
		this.sickroom.HeaderText = "病房";
		this.sickroom.Name = "sickroom";
		this.sickroom.ReadOnly = true;
		this.sickroom.Width = 80;
		// 
		// pice_place_name
		// 
		this.pice_place_name.DataPropertyName = "pice_place_name";
		this.pice_place_name.HeaderText = "片区";
		this.pice_place_name.Name = "pice_place_name";
		this.pice_place_name.ReadOnly = true;
		this.pice_place_name.Width = 125;
		// 
		// partment_name
		// 
		this.partment_name.DataPropertyName = "partment_name";
		this.partment_name.HeaderText = "科室";
		this.partment_name.Name = "partment_name";
		this.partment_name.ReadOnly = true;
		// 
		// diagnosis
		// 
		this.diagnosis.DataPropertyName = "diagnosis";
		this.diagnosis.HeaderText = "诊断";
		this.diagnosis.Name = "diagnosis";
		this.diagnosis.ReadOnly = true;
		this.diagnosis.Width = 200;
		// 
		// doc_name
		// 
		this.doc_name.DataPropertyName = "doc_name";
		this.doc_name.HeaderText = "医师";
		this.doc_name.Name = "doc_name";
		this.doc_name.ReadOnly = true;
		this.doc_name.Width = 95;
		// 
		// narcosis_doc_name
		// 
		this.narcosis_doc_name.DataPropertyName = "narcosis_doc_name";
		this.narcosis_doc_name.HeaderText = "麻醉医师";
		this.narcosis_doc_name.Name = "narcosis_doc_name";
		this.narcosis_doc_name.ReadOnly = true;
		// 
		// nurse_name
		// 
		this.nurse_name.DataPropertyName = "nurse_name";
		this.nurse_name.HeaderText = "护士";
		this.nurse_name.Name = "nurse_name";
		this.nurse_name.ReadOnly = true;
		// 
		// operation_room
		// 
		this.operation_room.DataPropertyName = "operation_room";
		this.operation_room.HeaderText = "手术台";
		this.operation_room.Name = "operation_room";
		this.operation_room.ReadOnly = true;
		// 
		// Form_arrage1
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.BackColor = System.Drawing.SystemColors.ControlLightLight;
		this.ClientSize = new System.Drawing.Size(1179, 689);
		this.Controls.Add(this.btnOk);
		this.Controls.Add(this.dgvss_visit);
		this.Name = "Form_arrage1";
		this.Text = "Form_arrage1";
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.Form_arrage1_Load);
		((System.ComponentModel.ISupportInitialize)(this.dgvss_visit)).EndInit();
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	private System.Windows.Forms.DataGridView dgvss_visit;
	private System.Windows.Forms.Button btnOk;
	private System.Windows.Forms.DataGridViewTextBoxColumn patient_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn age;
	private System.Windows.Forms.DataGridViewTextBoxColumn height;
	private System.Windows.Forms.DataGridViewTextBoxColumn weigth;
	private System.Windows.Forms.DataGridViewTextBoxColumn sickroom;
	private System.Windows.Forms.DataGridViewTextBoxColumn pice_place_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn partment_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn diagnosis;
	private System.Windows.Forms.DataGridViewTextBoxColumn doc_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn narcosis_doc_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn nurse_name;
	private System.Windows.Forms.DataGridViewTextBoxColumn operation_room;
}