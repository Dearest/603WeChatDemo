package com.mlkj.wechat.Iservice;

/**
 * 回调模式的服务层
 * @author hanchen
 *
 */
public interface ICallBackServise {
	
	/**
	 * 通过检测 以开启回调模式
	 * @return 
	 */
	public String check(String msgSignature,String timeStamp,String nonce,String echoStr) throws Exception;
	
	/**
	 * 得到微信服务器发来的信息
	 * @param msgSignature
	 * @param timeStamp
	 * @param nonce
	 * @param xmlData
	 * @return
	 * @throws Exception
	 */
	public String getMessage(String msgSignature,String timeStamp,String nonce,String xmlData) throws Exception;
}
