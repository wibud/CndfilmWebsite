package oa.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oa.dao.DatabaseAnno;


@DatabaseAnno(id="cfg_name")
@Entity
@Table(name="systemconfig")
public class System_config {
	@Id
	private String cfg_name;	//配置名称
	private String cfg_value;	//配置值
	private String cfg_desc;	//配置描述
	private String remark;		//备注
	
	
	public String getCfg_name() {
		return cfg_name;
	}
	public void setCfg_name(String cfg_name) {
		this.cfg_name = cfg_name;
	}
	public String getCfg_value() {
		return cfg_value;
	}
	public void setCfg_value(String cfg_value) {
		this.cfg_value = cfg_value;
	}
	public String getCfg_desc() {
		return cfg_desc;
	}
	public void setCfg_desc(String cfg_desc) {
		this.cfg_desc = cfg_desc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
