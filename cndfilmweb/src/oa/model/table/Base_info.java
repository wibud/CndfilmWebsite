package oa.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oa.dao.DatabaseAnno;

@DatabaseAnno(id = "seq")
@Entity
@Table(name = "base_info")
public class Base_info {
	
	@Id
	private Integer seq;
	
	private String introduce;			//---简介
	
	private String address;				//---地址
	
	private String tel;					//---电话
	
	private String email;				//---email
	
	private String qq;					//---qq
	
	private String msn;					//---msn
	
	
	//========getter and setter==================
	
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

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
	
}
