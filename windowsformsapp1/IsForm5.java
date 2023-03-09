package windowsformsapp1;

public class IsForm5 extends Form
{
	public IsForm5()
	{
		InitializeComponent();
	}

	private void IsForm5_Load(Object sender, tangible.EventArgs e)
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
		this.SuspendLayout();
		// 
		// IsForm5
		// 
		this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
		this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
		this.ClientSize = new System.Drawing.Size(846, 555);
		this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
		this.Name = "IsForm5";
		this.Text = "IsForm5";
		this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
//C# TO JAVA CONVERTER TODO TASK: Java has no equivalent to C#-style event wireups:
		this.Load += new System.EventHandler(this.IsForm5_Load);
		this.ResumeLayout(false);

	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}