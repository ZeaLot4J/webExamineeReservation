package com.zealot.web.biz;

import java.util.List;

import com.zealot.bean.Message;

public interface IMessageBiz {
	//管理员用
	public List<Message> getAllStuMessages();
	public List<Message> getAllAdminMessages();
	public int sendToSingleStu(String sno, String content);
	public void sendToAllStu(String content);
	
	//学生用
	public List<Message> receiveMessagesByNo(String sno);
	public int sendStuMessage(String sno, String content);
	public List<Message> getStuEverSendMessage(String sno);
	public int adminHasRead();
	public int stuHasRead(String sno);
}
