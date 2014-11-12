package com.mlkj.wechat.model;

/** 
 * 这个类实现了<tt>OutputMessage</tt>，用来回复文本消息 
 * 
 * <p>提供了获取文本内容<code>getContent()</code>等主要方法.</p> 
 */  
public class TextOutputMessage extends OutputMessage{ 
    private String MsgType = "text"; //消息类型:文本消息
    private String Content;  //文本消息
    
    public TextOutputMessage() {  
    }  

    public TextOutputMessage(String content) {  
        Content = content;  
    }  
    
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return MsgType;
	}
	
	public String getContent() {  
        return Content;  
    }  
	
	public void setContent(String content) {  
        Content = content;  
    }  

}
