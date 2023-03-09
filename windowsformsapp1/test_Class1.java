package windowsformsapp1;

public class test_Class1
{
	private String url;
	public final String getUrl()
	{
		return url;
	}
	public final void setUrl(String value)
	{
		url = value;
	}
	private String html;
	public final String getHtml()
	{
		return html;
	}
	public final void setHtml(String value)
	{
		html = value;
	}
	public test_Class1(String _url)
	{
		setUrl(_url);

	}
	public final void DoRequest()
	{

		HttpWebRequest request = (HttpWebRequest)HttpWebRequest.Create(getUrl());
		//设置请求方法
		request.Method = "GET";
		//设置请求头
		request.UserAgent = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:94.0) Gecko/20100101 Firefox/94.0";
		//获取resonse
		WebResponse response = request.GetResponse();
		//获取结果转化为string
		try (Stream stream = response.GetResponseStream())
		{
			try (InputStreamReader reader = new InputStreamReader(stream, java.nio.charset.StandardCharsets.UTF_8))
			{
				this.setHtml(reader.ReadToEnd());
			}
		}
		System.out.println(getHtml());
	}



	//static void Main(string[] args)
	//{
	//    test_Class1 robj = new test_Class1("https://www.baidu.com/");
	//    robj.DoRequest();
	//}






}