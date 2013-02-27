package oa.service.baseInfo;

import oa.bean.BaseInfoBean;

public interface BaseInfoManager {
	
	//获取基本信息
	BaseInfoBean getBaseInfo();
	
	//修改基本信息
	void modifyBaseInfo(BaseInfoBean bean);
}
