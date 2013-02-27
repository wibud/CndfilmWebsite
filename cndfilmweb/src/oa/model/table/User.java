package oa.model.table;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oa.dao.DatabaseAnno;

@DatabaseAnno(id = "id")
@Entity
@Table(name = "user")
public class User {
	
	@Id
	private Integer id;			//主键
	
	private String name;		//姓名
	
	private String pswd;		//密码
	
	private String workplace;	//工作单位
	
	private String dept;		//部门
	
	private String cert_number;	//工作证号码
	
	private String email;		//email
	
	private String tel;			//电话
	
	private String rule;		//权限
	
	private Date ctime;			//注册时间
	
	private Date etime;			//修改时间
	
	private String isoverdue;	//密码是否过期
	
	private String real_name;	//真实姓名
	
	
	//=====getter and setter=============
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
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
	
}
