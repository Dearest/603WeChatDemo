package com.mlkj.wechat.model;

import java.util.Set;


public class Response {
	private int id;
	private String content;
	private String userid;
	private long msgId;
	private Set<TextMessage> textMessage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<TextMessage> getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(Set<TextMessage> textMessage) {
		this.textMessage = textMessage;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	
	
}
