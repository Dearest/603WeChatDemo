package com.mlkj.wechat.dao;

import com.mlkj.wechat.model.TextMessage;

public interface ICallBackDAO {
	/**
	 * 保存文本消息到数据库
	 * @param textMessage
	 */
	public void saveTextMessage(TextMessage textMessage);
}
