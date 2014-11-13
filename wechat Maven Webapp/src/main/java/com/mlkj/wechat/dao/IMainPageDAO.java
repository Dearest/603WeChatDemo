package com.mlkj.wechat.dao;

import java.util.List;

import com.mlkj.wechat.model.TextMessage;

/**
 * 主界面的数据持久层
 * @author hanchen
 *
 */
public interface IMainPageDAO {
	/**
	 * 得到消息列表
	 * @return
	 */
	public List<TextMessage> getTextMessages();
}
