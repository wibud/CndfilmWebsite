package oa.service;

import oa.dao.table.BaseInfoDao;
import oa.dao.table.FilmDao;
import oa.dao.table.FilmTypeDao;
import oa.dao.table.NewTrendsDao;
import oa.dao.table.SystemConfigDao;
import oa.dao.table.UserDao;
import oa.service.baseInfo.BaseInfoManager;
import oa.service.film.FilmManager;
import oa.service.news.NewTrendsManager;
import oa.service.user.UserManager;

public class BaseManager {

	// 业务逻辑组件
	protected UserManager userManager;
	protected FilmManager filmManager;
	protected BaseInfoManager baseInfoManager;
	protected NewTrendsManager newTrendsManager;
	
	// 声明所有的DAO组件，这样就不用每个业务逻辑组件都重新声明了
	protected static UserDao userDao;
	protected SystemConfigDao systemConfigDao;
	protected FilmDao filmDao;
	protected FilmTypeDao filmTypeDao;
	protected BaseInfoDao baseInfoDao;
	protected NewTrendsDao newTrendsDao;
	
	
	//========getter and setter==================
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public SystemConfigDao getSystemConfigDao() {
		return systemConfigDao;
	}

	public void setSystemConfigDao(SystemConfigDao systemConfigDao) {
		this.systemConfigDao = systemConfigDao;
	}

	public FilmDao getFilmDao() {
		return filmDao;
	}

	public void setFilmDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

	public FilmTypeDao getFilmTypeDao() {
		return filmTypeDao;
	}

	public void setFilmTypeDao(FilmTypeDao filmTypeDao) {
		this.filmTypeDao = filmTypeDao;
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

	public BaseInfoDao getBaseInfoDao() {
		return baseInfoDao;
	}

	public void setBaseInfoDao(BaseInfoDao baseInfoDao) {
		this.baseInfoDao = baseInfoDao;
	}

	public NewTrendsManager getNewTrendsManager() {
		return newTrendsManager;
	}

	public void setNewTrendsManager(NewTrendsManager newTrendsManager) {
		this.newTrendsManager = newTrendsManager;
	}

	public NewTrendsDao getNewTrendsDao() {
		return newTrendsDao;
	}

	public void setNewTrendsDao(NewTrendsDao newTrendsDao) {
		this.newTrendsDao = newTrendsDao;
	}
}
