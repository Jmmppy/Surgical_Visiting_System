package windowsformsapp1.usercontrals;

import windowsformsapp1.*;

public class UC_Form extends UserControl
{
	public UC_Form()
	{
		InitializeComponent();
	}


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
		///#region 组件设计器生成的代码

	/**  
	 设计器支持所需的方法 - 不要修改
	 使用代码编辑器修改此方法的内容。
	*/
	private void InitializeComponent()
	{
		components = new System.ComponentModel.Container();
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}