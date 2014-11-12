package com.mlkj.wechat.service.impl;

import java.util.Properties;

import com.mlkj.wechat.Iservice.CallBackIservise;
import com.mlkj.wechat.utils.AesException;
import com.mlkj.wechat.utils.ConfigProperties;
import com.mlkj.wechat.utils.WXBizMsgCrypt;

public class CallBackServiceImpl implements CallBackIservise{

	@Override
	public String check(String msgSignature, String timeStamp, String nonce,
			String echoStr) throws Exception {
		// 
		Properties p = ConfigProperties.getProperties();
		WXBizMsgCrypt wxBizMsgCrypt;
		String verifyEchoStr = "";
		try {
			wxBizMsgCrypt = new WXBizMsgCrypt(p.getProperty("token"), p.getProperty("AESKey"), p.getProperty("corpid"));
			verifyEchoStr = wxBizMsgCrypt.VerifyURL(msgSignature, timeStamp, nonce, echoStr);
		} catch (AesException e1) {
			e1.printStackTrace();
		}
		return verifyEchoStr;
	}

	

}
