package windowsformsapp1;

import AForge.*;
import AForge.Controls.*;
import AForge.Video.*;
import AForge.Video.DirectShow.*;
import Models.*;
import BLL.*;
import Utility.*;
import ZXing.*;
import ZXing.Common.*;

/** 
 判断输入的图片是否存在二维码
 if yes 返回提醒
 if no 返回空
*/
public class Cheak_QRcode
{
	//Bitmap img;//处理图片
	public final boolean Cheak_IF_QRcode(Bitmap image)
	{
		String str = null;
		try
		{
			if (image != null)
			{
				//Bitmap img = new Bitmap(@"D:\069936cb-b9a7-4fed-a7de-b9cd99f487ad.png");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] bt = getImgByte(image);
				byte[] bt = getImgByte(image);
				LuminanceSource source = new RGBLuminanceSource(bt, image.Width, image.Height);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
				Result result = (new MultiFormatReader()).decode(bitmap);
				if (result != null)
				{
					str = result.Text;

				}
			}
		}
		catch (RuntimeException re)
		{
			throw re;

		}
		if (str == null)
		{ //没有二维码
			return false;
		}
		else
		{ //有二维码
			return true;
		}







	}
	// 性能最高，其数组和像素一一对应
	//public static byte[] GetImgByte(this Bitmap bmp)
	//{
	//    BitmapData bitmapData = bmp.LockBits(new System.Drawing.Rectangle(new System.Drawing.Point(0, 0), bmp.Size),
	//        ImageLockMode.ReadWrite, PixelFormat.Format24bppRgb);
	//    byte[] res = new byte[bitmapData.Stride * bitmapData.Height];

	//    IntPtr Ptr = bitmapData.Scan0;
	//    System.Runtime.InteropServices.Marshal.Copy(Ptr, res, 0, res.Length);

	//    bmp.UnlockBits(bitmapData);
	//    return res;
	//}


//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte[] getImgByte(Image image)
	public final byte[] getImgByte(Image image)
	{
//C# TO JAVA CONVERTER TODO TASK: C# to Java Converter cannot determine whether this System.IO.MemoryStream is input or output:
		MemoryStream ms = new MemoryStream();
		try
		{
			image.Save(ms, ImageFormat.Bmp);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] bt = ms.GetBuffer();
			byte[] bt = ms.GetBuffer();
			return bt;
		}
		catch (RuntimeException ex)
		{
			throw ex;
		}
		finally
		{
			ms.Close();
		}
	}
}