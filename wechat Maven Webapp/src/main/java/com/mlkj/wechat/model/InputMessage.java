/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * http://www.ansitech.com/weixin/sdk/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mlkj.wechat.model;

/**
 * POST的XML数据包转换为消息接受对象
 *
 * <p>由于POST的是XML数据包，所以不确定为哪种接受消息，<br/>
 * 所以直接将所有字段都进行转换，最后根据<tt>MsgType</tt>字段来判断取何种数据</p>
 *
 * @author qsyang<yangqisheng274@163.com>
 */
public class InputMessage {

    private String ToUserName;
    private String FromUserName;
    /**
     * 微信发送的long型时间单位是秒（s）,Date(Long date)参数单位是毫秒（ms）
     */
    private Long CreateTime;
    private String MsgType = "text";
    private Long MsgId;
    //消息来源的应用
    private int AgentID;
    // 文本消息
    private String Content;
    // 图片消息
    private String PicUrl;
    // 位置消息
    private String LocationX;
    private String LocationY;
    private Long Scale;
    private String Label;
    /**
     * 纬度
     */
    private double Latitude;
    /**
     * 经度
     */
    private double Longitude;
    /**
     * 精度
     */
    private double Precision;
    // 链接消息
    private String Title;
    private String Description;
    private String Url;
    // 语音信息
    private String MediaId;
    private String Format;
    private String Recognition;
    // 事件
    private String Event;
    private String EventKey;
    private String Ticket;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getLocationX() {
        return LocationX;
    }

    public void setLocationX(String locationX) {
        LocationX = locationX;
    }

    public String getLocationY() {
        return LocationY;
    }

    public void setLocationY(String locationY) {
        LocationY = locationY;
    }

    public Long getScale() {
        return Scale;
    }

    public void setScale(Long scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

	public int getAgentID() {
		return AgentID;
	}

	public void setAgentID(int agentID) {
		AgentID = agentID;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public double getPrecision() {
		return Precision;
	}

	public void setPrecision(double precision) {
		Precision = precision;
	}
}