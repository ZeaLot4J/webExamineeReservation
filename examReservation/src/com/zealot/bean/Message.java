package com.zealot.bean;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = -1783485193778722849L;
	private int mid;
	private String sno;
	private String content;
	private String sendtime;
	private boolean mtype;
	private boolean isnew;
	public Message() {
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendTime() {
		return sendtime;
	}
	public void setSendTime(String sendtime) {
		this.sendtime = sendtime;
	}
	public boolean getMtype() {
		return mtype;
	}
	public void setMtype(boolean mtype) {
		this.mtype = mtype;
	}
	public boolean getIsNew() {
		return isnew;
	}
	public void setIsNew(boolean isnew) {
		this.isnew = isnew;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", sno=" + sno + ", content=" + content + ", sendTime=" + sendtime + ", mtype="
				+ mtype + ", isNew=" + isnew + "]";
	}
	
	
}
