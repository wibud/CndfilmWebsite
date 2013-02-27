package oa.service.baseInfo.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oa.bean.BaseInfoBean;
import oa.model.table.Base_info;
import oa.service.BaseManager;
import oa.service.baseInfo.BaseInfoManager;
import oa.util.CommonUtil;
import oa.util.FileUtil;
import oa.util.ImgUtil;
import oa.util.SystemConfig;

public class BaseInfoManagerImpl extends BaseManager implements BaseInfoManager{
	
	/**
	 * 获取基本信息
	 */
	public BaseInfoBean getBaseInfo(){
		
		BaseInfoBean infoBean = new BaseInfoBean();
		infoBean.setAddress("");
		infoBean.setEmail("");
		infoBean.setIntroduce("");
		infoBean.setTel("");
		infoBean.setQq("");
		infoBean.setMsn("");
		
		List<Base_info> res = baseInfoDao.findAll(null);
		Iterator<Base_info> it = res.iterator();
		if(it.hasNext()){
			
			Base_info data = (Base_info)it.next();
			if(data.getAddress()!=null){
				infoBean.setAddress(data.getAddress());
			}
			if(data.getEmail()!=null){
				infoBean.setEmail(data.getEmail());
			}
			if(data.getIntroduce()!=null){
				infoBean.setIntroduce(data.getIntroduce());
			}
			if(data.getTel()!=null){
				infoBean.setTel(data.getTel());
			}
			if(data.getQq()!=null){
				infoBean.setQq(data.getQq());
			}
			if(data.getMsn()!=null){
				infoBean.setMsn(data.getMsn());
			}
		}
		
		return infoBean;
	}
	
	/**
	 * 修改基本信息
	 */
	public void modifyBaseInfo(BaseInfoBean bean){
		
		List<Base_info> res = baseInfoDao.findAll(null);
		Iterator<Base_info> it = res.iterator();
		Base_info data = null;
		if(it.hasNext()){
			data = (Base_info)it.next();
			if(CommonUtil.isNullOrNoValue(bean.getAddress())){
				data.setAddress(bean.getAddress());
			}
			if(CommonUtil.isNullOrNoValue(bean.getEmail())){
				data.setEmail(bean.getEmail());
			}
			if(CommonUtil.isNullOrNoValue(bean.getIntroduce())){
				data.setIntroduce(bean.getIntroduce());
			}
			if(CommonUtil.isNullOrNoValue(bean.getTel())){
				data.setTel(bean.getTel());
			}
			if(CommonUtil.isNullOrNoValue(bean.getQq())){
				data.setQq(bean.getQq());
			}
			if(CommonUtil.isNullOrNoValue(bean.getMsn())){
				data.setMsn(bean.getMsn());
			}
			
			baseInfoDao.update(data);
		}else{
			data = new Base_info();
			data.setSeq(1);
			data.setAddress(bean.getAddress());
			data.setEmail(bean.getEmail());
			data.setIntroduce(bean.getIntroduce());
			data.setTel(bean.getTel());
			data.setQq(bean.getQq());
			data.setMsn(bean.getMsn());
			baseInfoDao.save(data);
		}
		
		String destDirPath="";
		//上传简介图片
		if(bean.getIntroduceImg()!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\";
			}
			
			List<File> files = new ArrayList<File>();
			files.add(bean.getIntroduceImg());
			List<String> fileNames = new ArrayList<String>();
			fileNames.add("introduceImg.jpg");
			
			FileUtil.upload(destDirPath, files, fileNames);
			
			//调整图片尺寸
//			ImgUtil.createImage(true, new File(destDirPath+"introduceImg.jpg"), destDirPath+"introduceImg.jpg" , 498, 180);
		}
	}
}
