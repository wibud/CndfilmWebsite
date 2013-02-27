package oa.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oa.dao.DatabaseAnno;

@DatabaseAnno(id = "seq")
@Entity
@Table(name = "film_type")
public class Film_type {
	
	@Id
	private Integer seq;		//---主键，递增
	
	private String name;		//---分类名称
	
	private String value;		
	
	private String remark;
	
	
	//=====getter and setter ==========
	
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
