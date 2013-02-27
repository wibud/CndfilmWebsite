package oa.bean;

import java.util.Date;

public class UserBean {
	
	private String id;
	
	private String userName;
	
	private String pswd;
	
	private String workplace;	//工作单位
	
	private String dept;		//部门
	
	private String cert_number;	//工作证号码
	
	private String email;		//email
	
	private String tel;			//电话
	
	private String rule;		//权限
	
	private String ctime;		//注册时间
	
	private String etime;		//修改时间
	
	private String isoverdue;	//密码是否过期
	
	private String real_name;	//真实姓名
	
	//=======getter and setter==========
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCert_number() {
		return cert_number;
	}

	public void setCert_number(String certNumber) {
		cert_number = certNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getIsoverdue() {
		return isoverdue;
	}

	public void setIsoverdue(String isoverdue) {
		this.isoverdue = isoverdue;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String realName) {
		real_name = realName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
