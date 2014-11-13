package com.mlkj.wechat.service.impl;

import java.util.Date;
import java.util.Properties;

import com.mlkj.wechat.Iservice.ICallBackServise;
import com.mlkj.wechat.dao.ICallBackDAO;
import com.mlkj.wechat.model.InputMessage;
import com.mlkj.wechat.model.TextMessage;
import com.mlkj.wechat.utils.AesException;
import com.mlkj.wechat.utils.ConfigProperties;
import com.mlkj.wechat.utils.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CallBackServiceImpl implements ICallBackServise{
	
	private ICallBackDAO callBackDAO;
	public void setCallBackDAO(ICallBackDAO callBackDAO) {
		this.callBackDAO = callBackDAO;
	}

	Properties p = ConfigProperties.getProperties();
	private WXBizMsgCrypt wxBizMsgCrypt ;
	/* (non-Javadoc)
	 * @see com.mlkj.wechat.Iservice.CallBackIservise#check(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String check(String msgSignature, String timeStamp, String nonce,
			String echoStr) throws Exception {
	
		wxBizMsgCrypt = new WXBizMsgCrypt(p.getProperty("token"), p.getProperty("AESKey"), p.getProperty("corpid"));
		String verifyEchoStr = "";//解密之后的字符串 用来回复给微信
		try {
			
			verifyEchoStr = wxBizMsgCrypt.VerifyURL(msgSignature, timeStamp, nonce, echoStr);
		} catch (AesException e1) {
			e1.printStackTrace();
		}
		return verifyEchoStr;
	}

	@Override
	public String getMessage(String msgSignature, String timeStamp,
			String nonce, String xmlData) throws Exception {
		 
		wxBizMsgCrypt = new WXBizMsgCrypt(p.getProperty("token"), p.getProperty("AESKey"), p.getProperty("corpid"));
        
		XStream xs = new XStream(new DomDriver());  
        //将指定节点下的xml节点数据映射为对象  
        xs.alias("xml", InputMessage.class);  
        String result = wxBizMsgCrypt.DecryptMsg(msgSignature,timeStamp,nonce,xmlData);
        InputMessage inputMsg = (InputMessage) xs.fromXML(result.toString());  
        
     
        TextMessage textMsg = new TextMessage();
        textMsg.setUserid(inputMsg.getFromUserName());
        textMsg.setToUserName(inputMsg.getToUserName());
        textMsg.setFromUserName(inputMsg.getFromUserName());
        textMsg.setCreateTime(new Date(inputMsg.getCreateTime()*1000));
        textMsg.setContent(inputMsg.getContent());
        textMsg.setMsgId(inputMsg.getMsgId());
        //保存信息到数据库
        callBackDAO.saveTextMessage(textMsg);
        
        
		return "";
	}


	
	

}
