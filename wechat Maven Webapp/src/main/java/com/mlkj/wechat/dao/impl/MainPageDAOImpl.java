package com.mlkj.wechat.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.mlkj.wechat.dao.IMainPageDAO;
import com.mlkj.wechat.model.TextMessage;

public class MainPageDAOImpl implements IMainPageDAO {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TextMessage> getTextMessages() {
		
		return sessionFactory.getCurrentSession().createQuery("from TextMessage").list();
	}

}
