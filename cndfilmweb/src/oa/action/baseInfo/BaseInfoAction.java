package oa.action.baseInfo;

import java.io.File;

import oa.action.BaseAction;
import oa.bean.BaseInfoBean;

public class BaseInfoAction extends BaseAction{
	
	private String introduce;
	
	private String address;
	
	private String tel;
	
	private String email;
	
	private String qq;
	
	private String msn;
	
	private File introduceImg;
	
	private BaseInfoBean baseInfo;
	
	/**
	 * 获取基本信息
	 * @return
	 */
	public String listBaseInfo(){
		
		baseInfo = baseInfoManager.getBaseInfo();
		return SUCCESS;
	}
	
	/**
	 * 修改基本信息
	 * @return
	 */
	public String modifyBaseInfo(){
		
		BaseInfoBean bean = new BaseInfoBean();
		bean.setAddress(address);
		bean.setEmail(email);
		bean.setIntroduce(introduce);
		bean.setTel(tel);
		bean.setQq(qq);
		bean.setMsn(msn);
		bean.setIntroduceImg(introduceImg);
		
		baseInfoManager.modifyBaseInfo(bean);
		return SUCCESS;
	}
	
	//=======getter and setter=====================
	
	public BaseInfoBean getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfoBean baseInfo) {
		this.baseInfo = baseInfo;
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

	public File getIntroduceImg() {
		return introduceImg;
	}

	public void setIntroduceImg(File introduceImg) {
		this.introduceImg = introduceImg;
	}
	
}
