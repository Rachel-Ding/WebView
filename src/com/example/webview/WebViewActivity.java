package com.example.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity
{
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//获取WebView实例
		webView=(WebView)findViewById(R.id.web_view);
		
		//调用 WebView的 getSettings()方法可以去设置一些浏览器的属性
		//调用 setJavaScriptEnabled()方法来让 WebView 支持 JavaScript 脚本
		webView.getSettings().setJavaScriptEnabled(true);
		
		webView.setWebViewClient(new WebViewClient()
		{
			//重写shouldOverrideUrlLoading()方法
			//表明当需要从一个网页跳转到另一个网页时，目标网页仍然在当前 WebView 中显
			//示，而不是打开系统浏览器
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url )
			{
				 // 根据传入的参数再去加载新的网页
				view.loadUrl(url);
				 // 表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器
				return true;
			}
		});
		
		//调用 WebView 的 loadUrl()方法，并将网址传入，即可展示相应网页的内容
		webView.loadUrl("http://www.zhihu.com");
		
		
	}

}
