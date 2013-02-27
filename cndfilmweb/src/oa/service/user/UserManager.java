package oa.service.user;

import oa.bean.UserBean;
import oa.util.ResultList;

public interface UserManager {
	
	//判断用户是否存在
	String checkUserName(String userName);
	
	//判断用户名是否存在、密码是否正确
	String checkLogin(String userName,String pswd);
	
	//修改密码
	void modifyPswd(String userName, String oldPswd, String newPswd);
	
	//获取用户列表
	ResultList<UserBean> listUsers(Integer page, UserBean userBean);
	
	//添加用户
	void addUser(UserBean userBean);
	
	//编辑用户
	void editUser(UserBean userBean);
	
	//删除用户
	void delUser(String id);
	
	//查看用户
	UserBean getUserDetail(String id);
	
	//查看用户(by name)
	UserBean getUserDetailByName(String name);
	
	//批量赋予用户权限
	void mutipleRuleUsers(String ids, String op);
}
