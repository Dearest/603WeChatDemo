package com.mlkj.wechat.dao.impl;

import org.hibernate.SessionFactory;

import com.mlkj.wechat.dao.ICallBackDAO;
import com.mlkj.wechat.model.TextMessage;

public class CallBackDAOImpl implements ICallBackDAO{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveTextMessage(TextMessage textMessage) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(textMessage);
	}
}