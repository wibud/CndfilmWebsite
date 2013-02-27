package oa.service.news;

import oa.bean.NewTrendsBean;
import oa.util.ResultList;

public interface NewTrendsManager {
	
	//获取新闻动态的列表
	ResultList<NewTrendsBean> listNewTrends(Integer page, NewTrendsBean newTrendsBean);
	
	//添加新闻动态
	void addNewTrends(NewTrendsBean newTrendsBean);
	
	//删除新闻动态
	void delNewTrends(String seq);
	
	//编辑新闻动态
	void editNewTrends(NewTrendsBean newTrendsBean);
	
	//查看新闻动态
	NewTrendsBean getNewTrends(String seq);
}
