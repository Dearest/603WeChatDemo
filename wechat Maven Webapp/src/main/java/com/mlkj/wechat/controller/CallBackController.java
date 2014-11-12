package com.mlkj.wechat.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlkj.wechat.Iservice.ICallBackServise;


/**
 * 回调模式的控制器
 * @author hanchen
 *
 */
@Controller
@RequestMapping("/callback")
public class CallBackController {
	
	@Resource(name="callBackService")
	private ICallBackServise callBackService;
	
	@RequestMapping("/api")
	public void callBack(HttpServletRequest request,HttpServletResponse response,PrintWriter writer) throws Exception{
		String msgSignature = request.getParameter("msg_signature");
		String timeStamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echoStr = request.getParameter("echostr");
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			response.getWriter().write(callBackService.check(msgSignature, timeStamp, nonce, echoStr));
			response.getWriter().close();
		}else {
			//从数据流中得到微信发来的解密前的xml字符串
			 ServletInputStream in = request.getInputStream();  
			 StringBuilder xmlMsg = new StringBuilder();  
			 byte[] b = new byte[4096];  
	            for (int n; (n = in.read(b)) != -1;) {  
	                xmlMsg.append(new String(b, 0, n, "UTF-8"));  
	            } 
	         callBackService.getMessage(msgSignature, timeStamp, nonce, xmlMsg.toString());
	         writer.write("");
	         writer.close();
		}
 	}
}
