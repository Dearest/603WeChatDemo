package com.mlkj.wechat.model;

import java.util.Date;
import java.util.Set;

public class TextMessage {
	private int id;
	private String userid;
	private String toUserName;
    private String fromUserName;
    /**
     * 微信发送的long型时间单位是秒（s）,Date(Long date)参数单位是毫秒（ms）
     */
    private Date createTime;
    private String msgType = "text";
    // 文本消息
    private String content;
    private Long msgId;
    //消息来源的应用
    private int agentID;
    private int isResponse = 0;
   
    private Set<Response> responses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public int getIsResponse() {
		return isResponse;
	}
	public void setIsResponse(int isResponse) {
		this.isResponse = isResponse;
	}
	
	public Set<Response> getResponses() {
		return responses;
	}
	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}
	
}
