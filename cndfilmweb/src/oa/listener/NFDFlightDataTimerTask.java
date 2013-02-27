package oa.listener;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import oa.dao.HibernateTemplate;
import oa.dao.table.UserDao;
import oa.model.table.User;
import oa.service.user.impl.UserManagerImpl;
import oa.util.CommonUtil;
import oa.util.SystemConfig;

public class NFDFlightDataTimerTask extends TimerTask{
	
	@Override  
	public void run() {   
		try {    
			
			UserManagerImpl.autoControlLogin();
			
		 } catch (Exception e) {   
			 e.printStackTrace();
		 }  
	}

	
}
