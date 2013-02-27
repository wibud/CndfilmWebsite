package oa.service.user.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import oa.bean.NewTrendsBean;
import oa.bean.UserBean;
import oa.model.table.New_trends;
import oa.model.table.User;
import oa.service.BaseManager;
import oa.service.user.UserManager;
import oa.util.CommonUtil;
import oa.util.ResultList;
import oa.util.SystemConfig;

public class UserManagerImpl extends BaseManager implements UserManager{
	
	/**
	 * 判断用户是否存在
	 */
	public String checkUserName(String userName){
		
		String error = "";
		ResultList<User> res = userDao.findByProperty(null, "name", userName);
		Iterator it = res.iterator();
		if(it.hasNext()){
			error = "用户名已存在";
		}
		
		return error;
	}
	
	/**
	 * 判断用户名是否存在、密码是否正确
	 */
	public String checkLogin(String userName,String pswd){
		
		String error = "";
		ResultList<User> res = userDao.findByProperty(null, "name", userName);
		Iterator it = res.iterator();
		if(it.hasNext()){
			User user = (User)it.next();
//			pswd = DigestUtils.sha256Hex(pswd);
			if(!pswd.equals(user.getPswd())){
				error="密码不正确";
			}
		}else{
			error="该用户不存在";
		}
		
		return error;
	}
	
	/**
	 * 修改密码
	 */
	public void modifyPswd(String userName, String oldPswd, String newPswd){
		
		ResultList<User> res = userDao.findByProperty(null, "name", userName);
		Iterator it = res.iterator();
		User user;
		
		if(it.hasNext()){
			
			user = (User)it.next();
			user.setPswd(newPswd);
			user.setEtime(new Date());
			user.setIsoverdue("0");
			userDao.update(user);
		}
		
	}
	
	//获取用户列表
	public ResultList<UserBean> listUsers(Integer page, UserBean userBean){
		
		User user = new User();
		if(userBean!=null){
			user.setCert_number(userBean.getCert_number());
			user.setDept(userBean.getDept());
			user.setName(userBean.getUserName());
			user.setWorkplace(userBean.getWorkplace());
			user.setReal_name(userBean.getReal_name());
		}
		
		String conditions = oa.dao.DaoUtil.getStringConditions(user)+" and name<>'admin' order by isoverdue desc,etime,ctime desc";
		ResultList<User> list = userDao.findByCondition(page, conditions);
		ResultList<UserBean> beanList = new ResultList<UserBean>(list.size());
		beanList.setCount(list.getCount());
		
		UserBean bean;
		for(User u: list){
			
			bean = new UserBean();
			bean = setBean(bean, u);
			
			beanList.add(bean);
		}
		
		return beanList;
	}
	
	//添加用户
	public void  addUser(UserBean bean){
		
		User user = new User();
		if(CommonUtil.isNullOrNoValue(bean.getCert_number())){
			user.setCert_number(bean.getCert_number());
		}
		if(CommonUtil.isNullOrNoValue(bean.getDept())){
			user.setDept(bean.getDept());
		}
		if(CommonUtil.isNullOrNoValue(bean.getEmail())){
			user.setEmail(bean.getEmail());
		}
		if(CommonUtil.isNullOrNoValue(bean.getPswd())){
			user.setPswd(bean.getPswd());
		}
		if(CommonUtil.isNullOrNoValue(bean.getReal_name())){
			user.setReal_name(bean.getReal_name());
		}
		if(CommonUtil.isNullOrNoValue(bean.getTel())){
			user.setTel(bean.getTel());
		}
		if(CommonUtil.isNullOrNoValue(bean.getUserName())){
			user.setName(bean.getUserName());
		}
		if(CommonUtil.isNullOrNoValue(bean.getWorkplace())){
			user.setWorkplace(bean.getWorkplace());
		}
		
		Date currentTime = new Date();
		user.setCtime(currentTime);
		user.setEtime(currentTime);
		user.setIsoverdue("0");
		user.setRule("0");
		
		user.setId(getMaxSeq()+1);
		
		userDao.save(user);
	}
	
	//删除用户
	public void delUser(String id){
		
		User user = getUserById(id);
		userDao.delete(user);
	}
	
	//编辑用户
	public void editUser(UserBean bean){
		
		User user = getUserById(bean.getId());
		if(CommonUtil.isNullOrNoValue(bean.getCert_number())){
			user.setCert_number(bean.getCert_number());
		}
		if(CommonUtil.isNullOrNoValue(bean.getDept())){
			user.setDept(bean.getDept());
		}
		if(CommonUtil.isNullOrNoValue(bean.getEmail())){
			user.setEmail(bean.getEmail());
		}
		if(CommonUtil.isNullOrNoValue(bean.getPswd())){
			user.setPswd(bean.getPswd());
		}
		if(CommonUtil.isNullOrNoValue(bean.getReal_name())){
			user.setReal_name(bean.getReal_name());
		}
		if(CommonUtil.isNullOrNoValue(bean.getTel())){
			user.setTel(bean.getTel());
		}
		if(CommonUtil.isNullOrNoValue(bean.getUserName())){
			user.setName(bean.getUserName());
		}
		if(CommonUtil.isNullOrNoValue(bean.getWorkplace())){
			user.setWorkplace(bean.getWorkplace());
		}
		if(CommonUtil.isNullOrNoValue(bean.getRule())){
			user.setRule(bean.getRule());
		}
		
		userDao.update(user);
	}
	
	//批量赋予用户权限
	public void mutipleRuleUsers(String ids, String op){
		
		String[] userIdArray = ids.split(",");
		User user;
		for(String id: userIdArray){
			
			user = getUserById(id);
			if(op.equals("1")){
				user.setRule("1");
			}else if(op.equals("2")){
				user.setRule("0");
			}
			 
			userDao.update(user);
		}
	}
	
	//查看用户(by id)
	public UserBean getUserDetail(String id){
		
		User user = getUserById(id);
		UserBean userBean = resetBean(new UserBean());
		if(user!=null){
			userBean = setBean(userBean, user);
		}
		
		return userBean;
	}
	
	//查看用户(by name)
	public UserBean getUserDetailByName(String name){
		
		User user = getUserByName(name);
		UserBean userBean = resetBean(new UserBean());
		if(user!=null){
			userBean = setBean(userBean, user);
		}
		
		return userBean;
	}
	
	/**
	 * 为bean赋值
	 */
	public UserBean setBean(UserBean bean, User user){
		
		bean.setCert_number(CommonUtil.noNullString(user.getCert_number()));
		bean.setCtime(CommonUtil.DTtoString(user.getCtime()));
		bean.setDept(CommonUtil.noNullString(user.getDept()));
		bean.setEmail(CommonUtil.noNullString(user.getEmail()));
		bean.setEtime(CommonUtil.DTtoString(user.getEtime()));
		bean.setPswd(CommonUtil.noNullString(user.getPswd()));
		bean.setRule(CommonUtil.noNullString(user.getRule()));
		bean.setTel(CommonUtil.noNullString(user.getTel()));
		bean.setUserName(CommonUtil.noNullString(user.getName()));
		bean.setWorkplace(CommonUtil.noNullString(user.getWorkplace()));
		bean.setIsoverdue(CommonUtil.noNullString(user.getIsoverdue()));
		bean.setReal_name(CommonUtil.noNullString(user.getReal_name()));
		bean.setId(Integer.toString(user.getId()));
		
		
		return bean;
	}
	
	/**
	 * 初始化bean
	 */
	public UserBean resetBean(UserBean bean){
		
		if(bean==null){
			bean = new UserBean();
		}
		
		bean.setCert_number("");
		bean.setCtime("");
		bean.setDept("");
		bean.setEmail("");
		bean.setEtime("");
		bean.setPswd("");
		bean.setRule("");
		bean.setTel("");
		bean.setUserName("");
		bean.setWorkplace("");
		bean.setIsoverdue("");
		bean.setReal_name("");
		bean.setId("");
		
		return bean;
	}
	
	//超过期限时间用户没有修改密码，则系统自动重置该用户密码
	public static void autoControlLogin(){
		//判断用户是否在规定时间间隔内修改了密码
		List<User> userList = userDao.findAll(null);
		Date currentTime = new Date();		//---当前时间
		int settingInterval = SystemConfig.getCheckInterval();		//---更新密码的时间间隔
		
		for(User user: userList){
			
			if(!user.getName().equals("admin")){
				Date etime = user.getEtime();
				if(etime==null){
					
					user.setPswd(CommonUtil.getRandomString(6));
					user.setEtime(new Date());
					user.setIsoverdue("1");
					userDao.update(user);
				}else{
					
					//判断是否超过了时间间隔
					int interval = (int) ((currentTime.getTime()-etime.getTime())/(24*60*60*1000));
					if(interval>=settingInterval){
						
						//超过了时间间隔，则更换密码
						user.setPswd(CommonUtil.getRandomString(6));
						user.setEtime(new Date());
						user.setIsoverdue("1");
						userDao.update(user);
					}
				}
			}
		}
	}
	
	/**
	 * 获取film_info表最大的seq值
	 */
	public Integer getMaxSeq(){
		
		int max = 0;
		String hql = "select MAX(id) from User";
		List res = userDao.findByHQL(null, hql);
		Iterator it = res.iterator();
		if(it.hasNext()){
			Object data = (Object)it.next();
			if(data!=null){
				max = (Integer)data;
			}
			
		}
		
		return max;
	}
	
	/**
	 * 根据seq（id）获取用户
	 */
	public User getUserById(String id){
		
		User user = null;
		String hql = "select u from User u where id="+Integer.parseInt(id);
		List<User> list = userDao.findByHQL(null, hql);
		Iterator<User> it = list.iterator();
		if(it.hasNext()){
			user = (User)it.next();
		}
		
		return user;
	}
	
	/**
	 * 根据用户名获取用户
	 */
	public User getUserByName(String name){
		
		User user = null;
		String hql = "select u from User u where name='"+name+"'";
		List<User> list = userDao.findByHQL(null, hql);
		Iterator<User> it = list.iterator();
		if(it.hasNext()){
			user = (User)it.next();
		}
		
		return user;
	}
}
