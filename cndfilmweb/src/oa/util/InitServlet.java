package oa.util;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import oa.dao.table.SystemConfigDao;
import oa.dao.table.UserDao;
import oa.exception.LocalException;
import oa.model.table.System_config;
import oa.util.ExceptionUtil;
import oa.util.SystemConfig;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(InitServlet.class);
	private SystemConfigDao systemConfigDao;
	
	@Override
	public void init() {
		WebApplicationContext webContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		systemConfigDao = (SystemConfigDao)webContext.getBean("systemConfigDao");

		//这里调用 需要初始化方法，这些方法将在系统启动的时候被调用
		//每个初始化方法都要用try...catch语句完全包含起来，禁止抛出任何异常
		//否则，如果某个方法抛出未被捕捉的异常，会导致此线程立即中止
		//这样，后面的初始化方法将不能被调用，导致程序状态出错

		initPageSize();		//初始化每页显示条数
		initUploadPath();	//获得上传路径
		initCheckInterval();//获得检查时间间隔
			
	}

	private void initPageSize(){
		String pageSize = null;
		try {
			//先通过数据库操作获取pageSize
			System_config config = systemConfigDao.findById("page_size");
			
			if(config != null){
				pageSize = config.getCfg_value();
			}else{
				config = new System_config();
				config.setCfg_name("page_size");
				config.setCfg_value("20");
				config.setCfg_desc("每页显示条数");
				config.setRemark("init insert by java by java");
				systemConfigDao.save(config);
			}
			
			//设置默认值
			if(pageSize == null || pageSize.equals("")){
				pageSize = "20";
			}

			//再将pageSize传入SystemConfig
			SystemConfig.setPageSize(Integer.parseInt(pageSize));
		} catch (Exception e) {
			ExceptionUtil.handleException(new LocalException(e));
			SystemConfig.setPageSize(20);
		}
	}
	
	private void initUploadPath(){
		
		String uploadPathWindows = null;
		String uploadPathLinux = null;
		try {
			
			System_config config = systemConfigDao.findById("upload_path_linux");
			
			if(config != null){
				uploadPathLinux = config.getCfg_value();
			}else{
				config = new System_config();
				config.setCfg_name("upload_path_linux");
				config.setCfg_value("");
				config.setCfg_desc("linux上传路径");
				config.setRemark("init insert by java");
				systemConfigDao.save(config);
			}
			
			if(uploadPathLinux==null || uploadPathLinux.equals("")){
				
				uploadPathLinux = "";
			}
			
			config = systemConfigDao.findById("upload_path_windows");
			
			if(config != null){
				uploadPathWindows = config.getCfg_value();
			}else{
				config = new System_config();
				config.setCfg_name("upload_path_windows");
				config.setCfg_value("");
				config.setCfg_desc("windows上传路径");
				config.setRemark("init insert by java");
				systemConfigDao.save(config);
			}
			
			if(uploadPathWindows==null || uploadPathWindows.equals("")){
				
				uploadPathWindows = "";
			}
			
			//再传入SystemConfig
			SystemConfig.setUploadPathLinux(uploadPathLinux);
			SystemConfig.setUploadPathWindows(uploadPathWindows);
			
		} catch (Exception e) {
			ExceptionUtil.handleException(new LocalException(e));
		}
	}
	
	private void initCheckInterval(){
		
		String checkInterval = null;
		try {
			//先通过数据库操作获取pageSize
			System_config config = systemConfigDao.findById("check_interval");
			
			if(config != null){
				checkInterval = config.getCfg_value();
			}else{
				config = new System_config();
				config.setCfg_name("check_interval");
				config.setCfg_value("60");
				config.setCfg_desc("检查用户是否更改密码的时间间隔");
				config.setRemark("init insert by java by java");
				systemConfigDao.save(config);
			}
			
			//设置默认值
			if(checkInterval == null || checkInterval.equals("")){
				checkInterval = "60";
			}

			//再将pageSize传入SystemConfig
			SystemConfig.setCheckInterval(Integer.parseInt(checkInterval));
		} catch (Exception e) {
			ExceptionUtil.handleException(new LocalException(e));
			SystemConfig.setCheckInterval(60);
		}
	}

}
