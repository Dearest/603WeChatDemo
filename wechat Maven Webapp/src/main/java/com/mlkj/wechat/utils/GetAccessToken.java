package com.mlkj.wechat.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import net.sf.json.JSONObject;

/**
 * 循环获取到accesstoken之后保存在properties key: accessToken
 * @author hanchen
 *
 */
public class GetAccessToken {
	private ServletContext context;
	private Timer timer = new Timer(true);

	public GetAccessToken(ServletContext context) {
		this.context = context;
		timer.schedule(task, 10, 7000 * 1000);
	}

	private TimerTask task = new TimerTask() {

		@Override
		public void run() {
			// 
			try {
				Properties properties =  ConfigProperties.getProperties();
				
				URL url = new URL(
						"https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+properties.getProperty("corpid")+"&corpsecret="+properties.getProperty("corpsecret"));
				HttpRequest httpRequest = HttpRequest.get(url);
				String result = httpRequest.body();
				System.out.println(result);
				JSONObject resultJsonObject = JSONObject.fromObject(result);
				if (result.contains("access_token")) {
					String accessToken = resultJsonObject
							.getString("access_token");
					context.setAttribute("accessToken", accessToken);
					context.setAttribute("errcode", null);
					context.setAttribute("errmsg", null);
					properties.setProperty("accessToken", accessToken);
					OutputStream out = new FileOutputStream("src\\main\\resources\\system.properties");
					properties.store(out, "accessToken");
					
				} else if (result.contains("errcode")) {

					String errcode = resultJsonObject.getString("errcode");
					String errmsg = resultJsonObject.getString("errmsg");
					context.setAttribute("errcode", errcode);
					context.setAttribute("errmsg", errmsg);
					context.setAttribute("accessToken", null);

				}
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	};
}
