package com.mlkj.wechat.Iservice;

/**
 * 回调模式的服务层
 * @author hanchen
 *
 */
public interface CallBackIservise {
	
	/**
	 * 通过检测 以开启回调模式
	 * @return 
	 */
	public String check(String msgSignature,String timeStamp,String nonce,String echoStr) throws Exception;
}
