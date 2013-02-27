package oa.action.news;

import oa.action.BaseAction;
import oa.bean.FilmBean;
import oa.bean.NewTrendsBean;
import oa.util.CommonUtil;
import oa.util.ResultList;

public class NewTrendsAction extends BaseAction{
	
	private String seq;			//---seq
	
	private String title;		//---标题
	
	private String time;		//---时间
	
	private String content;		//---内容
	
	private String linkFrom;
	
	private ResultList<NewTrendsBean> newTrendsList;	//---新闻动态列表
	
	private NewTrendsBean newTrendsBean;				//---新闻动态详情
	
	private ResultList<FilmBean> recommendFilmList;		//---推荐影片列表
	
	
	/**
	 * 新闻动态展示页面
	 */
	public String init(){
		
		listNewTrends();
		getRecommendFilms();
		return SUCCESS;
	}
	
	public String seeNewTrendsDetail(){
		
		detailNewTrends();
		getRecommendFilms();
		return SUCCESS;
	}
	
	/**
	 * 添加新闻动态
	 * @return
	 */
	public String addNewTrends(){
		
		NewTrendsBean newTrendsBean = new NewTrendsBean();
		newTrendsBean.setContent(content);
		newTrendsBean.setTime(time);
		newTrendsBean.setTitle(title);
		newTrendsManager.addNewTrends(newTrendsBean);
		return SUCCESS;
	}
	
	/**
	 * 获取新闻动态list
	 * @return
	 */
	public String listNewTrends(){
		
		Integer pageNo = 1;			//默认第一页
		if(page!=null){
			pageNo = Integer.parseInt(page);
		}
		
		newTrendsList = newTrendsManager.listNewTrends(pageNo, null);
		count = newTrendsList.getCount();
		pageCount = CommonUtil.getPageCount(count);
		startWith = CommonUtil.getStartWith(pageNo);
		return SUCCESS;
	}
	
	/**
	 * 删除新闻动态
	 * @return
	 */
	public String delNewTrends(){
		
		newTrendsManager.delNewTrends(seq);
		return SUCCESS;
	}
	
	/**
	 * 获取新闻动态的详情
	 * @return
	 */
	public String detailNewTrends(){
		
		newTrendsBean = newTrendsManager.getNewTrends(seq);
		
		if(linkFrom!=null && linkFrom.equals("detail")){
			return "detail";
		}else{
			return "edit";
		}
	}
	
	/**
	 * 编辑新闻动态
	 * @return
	 */
	public String editNewTrends(){
		
		NewTrendsBean bean = new NewTrendsBean();
		bean.setSeq(seq);
		bean.setContent(content);
		bean.setTime(time);
		bean.setTitle(title);
		newTrendsManager.editNewTrends(bean);
		return SUCCESS;
	}
	
	public String getRecommendFilms(){
		
		recommendFilmList = filmManager.getRecommendFilms();
		return SUCCESS;
	}
	
	//==========getter and setter===============
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ResultList<NewTrendsBean> getNewTrendsList() {
		return newTrendsList;
	}

	public void setNewTrendsList(ResultList<NewTrendsBean> newTrendsList) {
		this.newTrendsList = newTrendsList;
	}

	public String getLinkFrom() {
		return linkFrom;
	}

	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom;
	}

	public NewTrendsBean getNewTrendsBean() {
		return newTrendsBean;
	}

	public void setNewTrendsBean(NewTrendsBean newTrendsBean) {
		this.newTrendsBean = newTrendsBean;
	}

	public ResultList<FilmBean> getRecommendFilmList() {
		return recommendFilmList;
	}

	public void setRecommendFilmList(ResultList<FilmBean> recommendFilmList) {
		this.recommendFilmList = recommendFilmList;
	}
	
}
