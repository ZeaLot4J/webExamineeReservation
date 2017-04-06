package com.zealot.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = -6330497710348485037L;
	private String sno;
	private String spwd;
	private String sname;
	private String sbirth;
	private String sidentity;
	private String ssex;
	private String stel;
	private String semail;
	private String sunivsersity;
	private String savator;
	private String verifycode;
	private String autologin;
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSbirth() {
		return sbirth;
	}

	public void setSbirth(String sbirth) {
		this.sbirth = sbirth;
	}

	public String getSidentity() {
		return sidentity;
	}

	public void setSidentity(String sidentity) {
		this.sidentity = sidentity;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getStel() {
		return stel;
	}

	public void setStel(String stel) {
		this.stel = stel;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSunivsersity() {
		return sunivsersity;
	}

	public void setSunivsersity(String sunivsersity) {
		this.sunivsersity = sunivsersity;
	}

	public String getSavator() {
		return savator;
	}

	public void setSavator(String savator) {
		this.savator = savator;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autologin == null) ? 0 : autologin.hashCode());
		result = prime * result + ((savator == null) ? 0 : savator.hashCode());
		result = prime * result + ((sbirth == null) ? 0 : sbirth.hashCode());
		result = prime * result + ((semail == null) ? 0 : semail.hashCode());
		result = prime * result + ((sidentity == null) ? 0 : sidentity.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((sno == null) ? 0 : sno.hashCode());
		result = prime * result + ((spwd == null) ? 0 : spwd.hashCode());
		result = prime * result + ((ssex == null) ? 0 : ssex.hashCode());
		result = prime * result + ((stel == null) ? 0 : stel.hashCode());
		result = prime * result + ((sunivsersity == null) ? 0 : sunivsersity.hashCode());
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
		Student other = (Student) obj;
		if (autologin == null) {
			if (other.autologin != null)
				return false;
		} else if (!autologin.equals(other.autologin))
			return false;
		if (savator == null) {
			if (other.savator != null)
				return false;
		} else if (!savator.equals(other.savator))
			return false;
		if (sbirth == null) {
			if (other.sbirth != null)
				return false;
		} else if (!sbirth.equals(other.sbirth))
			return false;
		if (semail == null) {
			if (other.semail != null)
				return false;
		} else if (!semail.equals(other.semail))
			return false;
		if (sidentity == null) {
			if (other.sidentity != null)
				return false;
		} else if (!sidentity.equals(other.sidentity))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (sno == null) {
			if (other.sno != null)
				return false;
		} else if (!sno.equals(other.sno))
			return false;
		if (spwd == null) {
			if (other.spwd != null)
				return false;
		} else if (!spwd.equals(other.spwd))
			return false;
		if (ssex == null) {
			if (other.ssex != null)
				return false;
		} else if (!ssex.equals(other.ssex))
			return false;
		if (stel == null) {
			if (other.stel != null)
				return false;
		} else if (!stel.equals(other.stel))
			return false;
		if (sunivsersity == null) {
			if (other.sunivsersity != null)
				return false;
		} else if (!sunivsersity.equals(other.sunivsersity))
			return false;
		if (verifycode == null) {
			if (other.verifycode != null)
				return false;
		} else if (!verifycode.equals(other.verifycode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", spwd=" + spwd + ", sname=" + sname + ", sbirth=" + sbirth + ", sidentity="
				+ sidentity + ", ssex=" + ssex + ", stel=" + stel + ", semail=" + semail + ", sunivsersity="
				+ sunivsersity + ", savator=" + savator + ", verifycode=" + verifycode + ", autologin=" + autologin
				+ "]";
	}

	public Student() {
		super();
	}
	
	
}
