package windowsformsapp1;

import java.util.*;
import java.io.*;

//------------------------------------------------------------------------------
// <auto-generated>
//     此代码由工具生成。
//     运行时版本:4.0.30319.42000
//
//     对此文件的更改可能会导致不正确的行为，并且如果
//     重新生成代码，这些更改将会丢失。
// </auto-generated>
//------------------------------------------------------------------------------


/** 
Represents a strongly typed in-memory cache of data.
*/
//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Serializable()][System.ComponentModel.DesignerCategoryAttribute("code")][System.ComponentModel.ToolboxItem(true)][System.Xml.Serialization.XmlSchemaProviderAttribute("GetTypedDataSetSchema")][System.Xml.Serialization.XmlRootAttribute("gdmuDataSet")][System.ComponentModel.Design.HelpKeywordAttribute("vs.data.DataSet")] public partial class gdmuDataSet: System.Data.DataSet
public class gdmuDataSet extends System.Data.DataSet implements Serializable
{

	private System.Data.SchemaSerializationMode _schemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] public gdmuDataSet()
	public gdmuDataSet()
	{
		this.BeginInit();
		this.InitClass();
		System.ComponentModel.CollectionChangeEventHandler schemaChangedHandler = this::SchemaChanged;
		super.Tables.CollectionChanged += schemaChangedHandler;
		super.Relations.CollectionChanged += schemaChangedHandler;
		this.EndInit();
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] protected gdmuDataSet(System.Runtime.Serialization.SerializationInfo info, System.Runtime.Serialization.StreamingContext context)
	protected gdmuDataSet(System.Runtime.Serialization.SerializationInfo info, System.Runtime.Serialization.StreamingContext context)
	{
		super(info, context, false);
		if ((this.IsBinarySerialized(info, context) == true))
		{
			this.InitVars(false);
			System.ComponentModel.CollectionChangeEventHandler schemaChangedHandler1 = this::SchemaChanged;
			this.getTables().CollectionChanged += schemaChangedHandler1;
			this.getRelations().CollectionChanged += schemaChangedHandler1;
			return;
		}
		String strSchema = ((String)(info.GetValue("XmlSchema", String.class)));
		if ((this.DetermineSchemaSerializationMode(info, context) == System.Data.SchemaSerializationMode.IncludeSchema))
		{
			System.Data.DataSet ds = new System.Data.DataSet();
			ds.ReadXmlSchema(new System.Xml.XmlTextReader(new System.IO.StringReader(strSchema)));
			this.DataSetName = ds.DataSetName;
			this.Prefix = ds.Prefix;
			this.Namespace = ds.Namespace;
			this.Locale = ds.Locale;
			this.CaseSensitive = ds.CaseSensitive;
			this.EnforceConstraints = ds.EnforceConstraints;
			this.Merge(ds, false, System.Data.MissingSchemaAction.Add);
			this.InitVars();
		}
		else
		{
			this.ReadXmlSchema(new System.Xml.XmlTextReader(new System.IO.StringReader(strSchema)));
		}
		this.GetSerializationData(info, context);
		System.ComponentModel.CollectionChangeEventHandler schemaChangedHandler = this::SchemaChanged;
		super.Tables.CollectionChanged += schemaChangedHandler;
		this.getRelations().CollectionChanged += schemaChangedHandler;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")][System.ComponentModel.BrowsableAttribute(true)][System.ComponentModel.DesignerSerializationVisibilityAttribute(System.ComponentModel.DesignerSerializationVisibility.Visible)] public override System.Data.SchemaSerializationMode SchemaSerializationMode
	@Override
	public System.Data.SchemaSerializationMode getSchemaSerializationMode()
	{
		return this._schemaSerializationMode;
	}
	@Override
	public void setSchemaSerializationMode(System.Data.SchemaSerializationMode value)
	{
		this._schemaSerializationMode = value;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")][System.ComponentModel.DesignerSerializationVisibilityAttribute(System.ComponentModel.DesignerSerializationVisibility.Hidden)] public new System.Data.DataTableCollection Tables
	public final System.Data.DataTableCollection getTables()
	{
		return super.Tables;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")][System.ComponentModel.DesignerSerializationVisibilityAttribute(System.ComponentModel.DesignerSerializationVisibility.Hidden)] public new System.Data.DataRelationCollection Relations
	public final System.Data.DataRelationCollection getRelations()
	{
		return super.Relations;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] protected override void InitializeDerivedDataSet()
	@Override
	protected void InitializeDerivedDataSet()
	{
		this.BeginInit();
		this.InitClass();
		this.EndInit();
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] public override System.Data.DataSet Clone()
	@Override
	public System.Data.DataSet Clone()
	{
		gdmuDataSet cln = ((gdmuDataSet)(super.Clone()));
		cln.InitVars();
		cln.setSchemaSerializationMode(this.getSchemaSerializationMode());
		return cln;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] protected override bool ShouldSerializeTables()
	@Override
	protected boolean ShouldSerializeTables()
	{
		return false;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] protected override bool ShouldSerializeRelations()
	@Override
	protected boolean ShouldSerializeRelations()
	{
		return false;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] protected override void ReadXmlSerializable(System.Xml.XmlReader reader)
	@Override
	protected void ReadXmlSerializable(System.Xml.XmlReader reader)
	{
		if ((this.DetermineSchemaSerializationMode(reader) == System.Data.SchemaSerializationMode.IncludeSchema))
		{
			this.Reset();
			System.Data.DataSet ds = new System.Data.DataSet();
			ds.ReadXml(reader);
			this.DataSetName = ds.DataSetName;
			this.Prefix = ds.Prefix;
			this.Namespace = ds.Namespace;
			this.Locale = ds.Locale;
			this.CaseSensitive = ds.CaseSensitive;
			this.EnforceConstraints = ds.EnforceConstraints;
			this.Merge(ds, false, System.Data.MissingSchemaAction.Add);
			this.InitVars();
		}
		else
		{
			this.ReadXml(reader);
			this.InitVars();
		}
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] protected override System.Xml.Schema.XmlSchema GetSchemaSerializable()
	@Override
	protected System.Xml.Schema.XmlSchema GetSchemaSerializable()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		this.WriteXmlSchema(new System.Xml.XmlTextWriter(stream, null));
		stream.Position = 0;
		return System.Xml.Schema.XmlSchema.Read(new System.Xml.XmlTextReader(stream), null);
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] internal void InitVars()
	public final void InitVars()
	{
		this.InitVars(true);
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] internal void InitVars(bool initTable)
	public final void InitVars(boolean initTable)
	{
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] private void InitClass()
	private void InitClass()
	{
		this.DataSetName = "gdmuDataSet";
		this.Prefix = "";
		this.Namespace = "http://tempuri.org/gdmuDataSet.xsd";
		this.EnforceConstraints = true;
		this.setSchemaSerializationMode(System.Data.SchemaSerializationMode.IncludeSchema);
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] private void SchemaChanged(object sender, System.ComponentModel.CollectionChangeEventArgs e)
	private void SchemaChanged(Object sender, System.ComponentModel.CollectionChangeEventArgs e)
	{
		if ((e.Action == System.ComponentModel.CollectionChangeAction.Remove))
		{
			this.InitVars();
		}
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [System.Diagnostics.DebuggerNonUserCodeAttribute()][System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Design.TypedDataSetGenerator", "16.0.0.0")] public static System.Xml.Schema.XmlSchemaComplexType GetTypedDataSetSchema(System.Xml.Schema.XmlSchemaSet xs)
	public static System.Xml.Schema.XmlSchemaComplexType GetTypedDataSetSchema(System.Xml.Schema.XmlSchemaSet xs)
	{
		gdmuDataSet ds = new gdmuDataSet();
		System.Xml.Schema.XmlSchemaComplexType type = new System.Xml.Schema.XmlSchemaComplexType();
		System.Xml.Schema.XmlSchemaSequence sequence = new System.Xml.Schema.XmlSchemaSequence();
		System.Xml.Schema.XmlSchemaAny any = new System.Xml.Schema.XmlSchemaAny();
		any.Namespace = ds.Namespace;
		sequence.Items.Add(any);
		type.Particle = sequence;
		System.Xml.Schema.XmlSchema dsSchema = ds.GetSchemaSerializable();
		if (xs.Contains(dsSchema.TargetNamespace))
		{
			ByteArrayInputStream s1 = new ByteArrayInputStream();
			ByteArrayInputStream s2 = new ByteArrayInputStream();
			try
			{
				System.Xml.Schema.XmlSchema schema = null;
				dsSchema.Write(s1);
				for (Iterator schemas = xs.Schemas(dsSchema.TargetNamespace).iterator(); schemas.hasNext();)
				{
					schema = ((System.Xml.Schema.XmlSchema)(schemas.next()));
					s2.SetLength(0);
					schema.Write(s2);
					if ((s1.Length == s2.Length))
					{
						s1.Position = 0;
						s2.Position = 0;
						for (; ((s1.Position != s1.Length) && (s1.read() == s2.read()));)
						{
							;
						}
						if ((s1.Position == s1.Length))
						{
							return type;
						}
					}
				}
			}
			finally
			{
				if ((s1 != null))
				{
					s1.close();
				}
				if ((s2 != null))
				{
					s2.close();
				}
			}
		}
		xs.Add(dsSchema);
		return type;
	}
}