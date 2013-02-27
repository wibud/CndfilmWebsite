package oa.service.news.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import oa.bean.NewTrendsBean;
import oa.model.table.Film_info;
import oa.model.table.New_trends;
import oa.service.BaseManager;
import oa.service.news.NewTrendsManager;
import oa.util.CommonUtil;
import oa.util.ResultList;

public class NewTrendsManagerImpl extends BaseManager implements NewTrendsManager{
	
	//获取新闻动态的列表
	public ResultList<NewTrendsBean> listNewTrends(Integer page, NewTrendsBean newTrendsBean){
		
		New_trends new_trends = new New_trends();
		if(newTrendsBean!=null){
			new_trends.setTime(newTrendsBean.getTime());
		}
		
		String conditions = oa.dao.DaoUtil.getStringConditions(new_trends)+" order by time desc";
		ResultList<New_trends> list = newTrendsDao.findByCondition(page, conditions);
		ResultList<NewTrendsBean> beanList = new ResultList<NewTrendsBean>(list.size());
		beanList.setCount(list.getCount());
		
		NewTrendsBean bean;
		for(New_trends news: list){
			
			bean = new NewTrendsBean();
			bean.setSeq(Integer.toString(news.getSeq()));
			bean.setCtime(CommonUtil.DTtoString(news.getCtime()));
			bean.setContent(news.getContent());
			bean.setTime(news.getTime());
			bean.setTitle(news.getTitle());
			
			beanList.add(bean);
		}
		
		return beanList;
	}
	
	//添加新闻动态
	public void addNewTrends(NewTrendsBean newTrendsBean){
		
		New_trends news = new New_trends();
		if(CommonUtil.isNullOrNoValue(newTrendsBean.getContent())){
			news.setContent(newTrendsBean.getContent());
		}
		if(CommonUtil.isNullOrNoValue(newTrendsBean.getTitle())){
			news.setTitle(newTrendsBean.getTitle());
		}
		if(CommonUtil.isNullOrNoValue(newTrendsBean.getTime())){
			news.setTime(newTrendsBean.getTime());
		}
		Date currentTime = new Date();
		news.setCtime(currentTime);
		
		news.setSeq(getMaxSeq()+1);
		
		newTrendsDao.save(news);
	}
	
	//删除新闻动态
	public void delNewTrends(String seq){
		New_trends news = getNewsById(seq);
		newTrendsDao.delete(news);
	}
	
	
	//编辑新闻动态
	public void editNewTrends(NewTrendsBean newTrendsBean){
		
		New_trends news = getNewsById(newTrendsBean.getSeq());
		if(CommonUtil.isNullOrNoValue(newTrendsBean.getContent())){
			news.setContent(newTrendsBean.getContent());
		}
		if(CommonUtil.isNullOrNoValue(newTrendsBean.getTitle())){
			news.setTitle(newTrendsBean.getTitle());
		}
		if(CommonUtil.isNullOrNoValue(newTrendsBean.getTime())){
			news.setTime(newTrendsBean.getTime());
		}
		
		newTrendsDao.update(news);
	}
	
	//查看新闻动态
	public NewTrendsBean getNewTrends(String seq){
		
		New_trends news = getNewsById(seq);
		NewTrendsBean bean = resetBean(new NewTrendsBean());
		if(news!=null){
			bean = setBean(bean, news);
		}
		
		return bean;
	}
	
	/**
	 * 根据seq（id）获取新闻动态
	 */
	public New_trends getNewsById(String seq){
		
		New_trends news = null;
		String hql = "select news from New_trends news where seq="+Integer.parseInt(seq);
		List<New_trends> newsList = newTrendsDao.findByHQL(null, hql);
		Iterator<New_trends> it = newsList.iterator();
		if(it.hasNext()){
			news = (New_trends)it.next();
		}
		
		return news;
	}
	
	/**
	 * 初始化bean
	 */
	public NewTrendsBean resetBean(NewTrendsBean bean){
		
		if(bean==null){
			bean = new NewTrendsBean();
		}
		
		bean.setContent("");
		bean.setCtime("");
		bean.setSeq("");
		bean.setTime("");
		bean.setTitle("");
		
		return bean;
	}
	
	/**
	 * 将table的值附到bean中
	 */
	public NewTrendsBean setBean(NewTrendsBean bean, New_trends table){
		
		bean.setSeq(Integer.toString(table.getSeq()));
		bean.setContent(CommonUtil.noNullString(table.getContent()));
		bean.setCtime(CommonUtil.DTtoString(table.getCtime()));
		bean.setTime(CommonUtil.noNullString(table.getTime()));
		bean.setTitle(CommonUtil.noNullString(table.getTitle()));
		
		return bean;
	}
	
	/**
	 * 获取New_trends表seq的最大值
	 */
	public Integer getMaxSeq(){
		
		int max = 0;
		String hql = "select MAX(seq) from New_trends";
		List res = newTrendsDao.findByHQL(null, hql);
		Iterator it = res.iterator();
		if(it.hasNext()){
			Object data = (Object)it.next();
			if(data!=null){
				max = (Integer)data;
			}
			
		}
		
		return max;
	}
}
