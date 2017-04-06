package com.zealot.bean;

import java.io.Serializable;

public class Administrator implements Serializable {
	private static final long serialVersionUID = -7702254142835944826L;
	
	private int aid;
	private String aname;
	private String apwd;
	private String verifycode;
	private String autologin;
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getAutologin() {
		return autologin;
	}

	public void setAutologin(String autologin) {
		this.autologin = autologin;
	}

	@Override
	public String toString() {
		return "administrator [aid=" + aid + ", aname=" + aname + ", apwd=" + apwd + ", verifycode=" + verifycode
				+ ", autologin=" + autologin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((apwd == null) ? 0 : apwd.hashCode());
		result = prime * result + ((autologin == null) ? 0 : autologin.hashCode());
		result = prime * result + ((verifycode == null) ? 0 : verifycode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		if (aid != other.aid)
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (apwd == null) {
			if (other.apwd != null)
				return false;
		} else if (!apwd.equals(other.apwd))
			return false;
		if (autologin == null) {
			if (other.autologin != null)
				return false;
		} else if (!autologin.equals(other.autologin))
			return false;
		if (verifycode == null) {
			if (other.verifycode != null)
				return false;
		} else if (!verifycode.equals(other.verifycode))
			return false;
		return true;
	}

	public Administrator() {
		super();
	}
}
