package oa.action.user;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;

import oa.action.BaseAction;
import oa.bean.FilmBean;
import oa.bean.UserBean;
import oa.util.CommonUtil;
import oa.util.ResultList;

public class UserAction extends BaseAction{
	
	private String id;
	
	private String op;
	
	private String userName;
	
	private String pswd;
	
	private String newPswd;
	
	private String realName;
	
	private String workPlace;
	
	private String dept;
	
	private String certNumber;
	
	private String email;
	
	private String tel;
	
	private String rule;
	
	private String errormsg;
	
	private String linkFrom;
	
	private ResultList<FilmBean> recommendFilmList;		//---推荐影片列表
	
	private ResultList<UserBean> userList;				//---用户列表
	
	private UserBean userBean;							//---用户详情
	
	/**
	 * 判断用户名是否已经存在
	 */
	public String checkUserName(){
		
		errormsg = userManager.checkUserName(userName);
		return SUCCESS;
	}
	
	/**
	 * 管理员登录check
	 * @return
	 */
	public String checkLogin(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String error = userManager.checkLogin(userName, pswd);
		if(error.equals("")){
			
			UserBean userBean = new UserBean();
			userBean.setUserName(userName);
//			userBean.setPswd(DigestUtils.sha256Hex(pswd));
			userBean.setPswd(pswd);
			session.setAttribute("admin", userBean);				//将管理员放入session中
			return SUCCESS;
		}else{
			
			this.setErrormsg(error);
			return ERROR;
		}
	}
	
	/**
	 * 用户登录
	 */
	public String checkUserLogin(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		errormsg = userManager.checkLogin(userName, pswd);
		if(errormsg.equals("")){
			
//			UserBean userBean = new UserBean();
//			userBean.setUserName(userName);
////			userBean.setPswd(DigestUtils.sha256Hex(pswd));
//			userBean.setPswd(pswd);
			UserBean userBean = userManager.getUserDetailByName(userName);
			session.setAttribute("user", userBean);				//将用户放入session中
		}
		
		return SUCCESS;
	}
	
	/**
	 * 进入用户注册页面
	 */
	public String registerPage(){
		
		getRecommendFilms();
		return SUCCESS;
	}
	
	/**
	 * 用户注册
	 */
	public String userRegister(){
		
		UserBean bean = new UserBean();
		bean.setCert_number(certNumber);
		bean.setDept(dept);
		bean.setEmail(email);
		bean.setPswd(pswd);
		bean.setReal_name(realName);
		bean.setTel(tel);
		bean.setUserName(userName);
		bean.setWorkplace(workPlace);
		userManager.addUser(bean);
		return SUCCESS;
	}
	
	/**
	 * 用户修改密码
	 */
	public String userModifyPswd(){
		
		//从session中获取用户
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserBean bean = (UserBean)session.getAttribute("user");
		userManager.modifyPswd(bean.getUserName(), bean.getPswd(), newPswd);
		return SUCCESS;
	}
	
	/**
	 * admin修改密码
	 * @return
	 */
	public String modifyPswd(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserBean userBean = (UserBean)session.getAttribute("admin");
//		String oldPswd = DigestUtils.sha256Hex(pswd);				//密码加密
		String oldPswd = pswd;
		if(userBean==null){
			errormsg="您还没有登录";
//			return ERROR;
		}else{
			if(oldPswd.equals(userBean.getPswd())){
				
//				String newPswd = DigestUtils.sha256Hex(this.newPswd);
				userManager.modifyPswd(userBean.getUserName(),oldPswd,newPswd);
				errormsg="修改成功";
//				return SUCCESS;
			}else{
				errormsg="密码不正确";
//				return ERROR;
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	public String listUsers(){
		
		Integer pageNo = 1;			//默认第一页
		if(page!=null){
			pageNo = Integer.parseInt(page);
		}
		
		userList = userManager.listUsers(pageNo, null);
		count = userList.getCount();
		pageCount = CommonUtil.getPageCount(count);
		startWith = CommonUtil.getStartWith(pageNo);
		return SUCCESS;
	}
	
	/**
	 * 用户查询
	 */
	public String searchUser(){
		
		Integer pageNo = 1;			//默认第一页
		if(page!=null){
			pageNo = Integer.parseInt(page);
		}
		
		UserBean bean = new UserBean();
		bean.setUserName(userName);
		bean.setReal_name(realName);
		bean.setWorkplace(workPlace);
		bean.setDept(dept);
		bean.setCert_number(certNumber);
		
		userList = userManager.listUsers(pageNo, bean);
		count = userList.getCount();
		pageCount = CommonUtil.getPageCount(count);
		startWith = CommonUtil.getStartWith(pageNo);
		return SUCCESS;
	}
	
	/**
	 * 批量赋予用户权限
	 * @return
	 */
	public String mutipleRuleUsers(){
		
		userManager.mutipleRuleUsers(id, op);
		return SUCCESS;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String delUser(){
		
		userManager.delUser(id);
		return SUCCESS;
	}
	
	/**
	 * 用户详情
	 * @return
	 */
	public String detailUser(){
		
		userBean = userManager.getUserDetail(id);
		if(linkFrom.equals("detail")){
			return "detail";
		}else{
			return "edit";
		}
	}
	
	/**
	 * 编辑用户
	 * @return
	 */
	public String editUser(){
		
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setUserName(userName);
		bean.setReal_name(realName);
		bean.setWorkplace(workPlace);
		bean.setDept(dept);
		bean.setCert_number(certNumber);
		bean.setEmail(email);
		bean.setTel(tel);
		bean.setRule(rule);
		userManager.editUser(bean);
		return SUCCESS;
	}
	
	public String getRecommendFilms(){
		
		recommendFilmList = filmManager.getRecommendFilms();
		return SUCCESS;
	}
	
	//======getter and setter================
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getNewPswd() {
		return newPswd;
	}

	public void setNewPswd(String newPswd) {
		this.newPswd = newPswd;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public ResultList<FilmBean> getRecommendFilmList() {
		return recommendFilmList;
	}

	public void setRecommendFilmList(ResultList<FilmBean> recommendFilmList) {
		this.recommendFilmList = recommendFilmList;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCertNumber() {
		return certNumber;
	}

	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public ResultList<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(ResultList<UserBean> userList) {
		this.userList = userList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String getLinkFrom() {
		return linkFrom;
	}

	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}
	
}
