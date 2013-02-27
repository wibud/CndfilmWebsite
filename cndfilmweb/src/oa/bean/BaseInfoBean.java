package oa.bean;

import java.io.File;

public class BaseInfoBean {
	
	private String introduce;	//---简介
	
	private String address;		//---地址
	
	private String tel;			//---电话
	
	private String email;		//---email
	
	private String qq;			//---qq
	
	private String msn;			//---msn
	
	private File introduceImg;	//---简介图片 
	
	//=======getter and setter=============
	
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public File getIntroduceImg() {
		return introduceImg;
	}

	public void setIntroduceImg(File introduceImg) {
		this.introduceImg = introduceImg;
	}
	
}
