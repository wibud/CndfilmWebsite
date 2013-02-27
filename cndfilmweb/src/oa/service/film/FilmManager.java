package oa.service.film;

import java.util.List;

import oa.bean.FilmBean;
import oa.bean.FilmTypeBean;
import oa.util.ResultList;

public interface FilmManager {
	
	//获取影片分类信息
	List<FilmTypeBean> listFilmType();
	
	//修改影片分类
	void modifyFilmType(String filmType);
	
	//获取影片列表
	ResultList<FilmBean> listFilms(Integer page, FilmBean filmBean);
	
	// check影片名称时候重复
	String checkFilmName(String filmName);
	
	//添加影片
	String addFilm(FilmBean filmBean);
	
	//删除影片
	void delFilm(String filmId);
	
	//批量删除影片
	void mutipleDelFilms(String filmIds);
	
	//根据id获取单个影片的详细信息
	FilmBean getFilmDetail(String filmId); 
	
	//编辑节目
	String editFilm(FilmBean filmBean);
	
	//获取推荐影片列表
	ResultList<FilmBean> getRecommendFilms();
}
