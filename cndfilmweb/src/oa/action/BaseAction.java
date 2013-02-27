package oa.action;

import oa.bean.common.ResultBean;
import oa.service.baseInfo.BaseInfoManager;
import oa.service.baseInfo.EmailManager;
import oa.service.film.FilmManager;
import oa.service.news.NewTrendsManager;
import oa.service.user.UserManager;

public class BaseAction {

	// 共用的常量
	protected static final String SUCCESS = "success";
	protected static final String ERROR = "error";
	protected String page="1";
	protected String count;
	protected String pageCount;
	protected String startWith;

	// 执行失败 或者 需要返回操作是否成功时使用
	protected ResultBean result;
	
	// 业务逻辑组件 
	protected UserManager userManager;
	protected FilmManager filmManager;
	protected BaseInfoManager baseInfoManager;
	protected EmailManager emailManager;
	protected NewTrendsManager newTrendsManager;
	
	
	//=================getter and setter============

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getStartWith() {
		return startWith;
	}

	public void setStartWith(String startWith) {
		this.startWith = startWith;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
		this.result = result;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public FilmManager getFilmManager() {
		return filmManager;
	}

	public void setFilmManager(FilmManager filmManager) {
		this.filmManager = filmManager;
	}

	public BaseInfoManager getBaseInfoManager() {
		return baseInfoManager;
	}

	public void setBaseInfoManager(BaseInfoManager baseInfoManager) {
		this.baseInfoManager = baseInfoManager;
	}

	public EmailManager getEmailManager() {
		return emailManager;
	}

	public void setEmailManager(EmailManager emailManager) {
		this.emailManager = emailManager;
	}

	public NewTrendsManager getNewTrendsManager() {
		return newTrendsManager;
	}

	public void setNewTrendsManager(NewTrendsManager newTrendsManager) {
		this.newTrendsManager = newTrendsManager;
	}
	
}
