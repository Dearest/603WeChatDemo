package com.mlkj.wechat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlkj.wechat.Iservice.CallBackIservise;


/**
 * 回调模式的控制器
 * @author hanchen
 *
 */
@Controller
@RequestMapping("/callback")
public class CallBackController {
	
	@Resource(name="callBackService")
	private CallBackIservise callBackService;
	
	@RequestMapping("/api")
	public void callBack(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String msgSignature = request.getParameter("msg_signature");
		String timeStamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echoStr = request.getParameter("echostr");
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			response.getWriter().write(callBackService.check(msgSignature, timeStamp, nonce, echoStr));
			response.getWriter().close();
		}
 	}
}
