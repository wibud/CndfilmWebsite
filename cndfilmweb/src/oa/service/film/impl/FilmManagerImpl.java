package oa.service.film.impl;

import java.io.File;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.util.XWorkList;

import oa.bean.FilmBean;
import oa.bean.FilmTypeBean;
import oa.bean.VideoBean;
import oa.model.table.Film_info;
import oa.model.table.Film_type;
import oa.service.BaseManager;
import oa.service.film.FilmManager;
import oa.util.CommonUtil;
import oa.util.FileUtil;
import oa.util.ImgUtil;
import oa.util.ResultList;
import oa.util.SystemConfig;

public class FilmManagerImpl extends BaseManager implements FilmManager{
	
	/**
	 * 获取影片分类
	 */
	public List<FilmTypeBean> listFilmType(){
		
		List<FilmTypeBean> filmTypeBeans = new ArrayList<FilmTypeBean>();
		ResultList<Film_type> res = filmTypeDao.findAll(null);
		FilmTypeBean filmBean;
		for(Film_type it: res){
			
			filmBean = new FilmTypeBean();
			filmBean.setName(it.getName());
			filmBean.setValue(it.getValue());
			
			filmTypeBeans.add(filmBean);
		}
		
		return filmTypeBeans;
	}
	
	/**
	 * 修改影片分类
	 */
	public void modifyFilmType(String filmType){
		
		//先将所有分类全部删除
		List<Film_type> filmTypeList = filmTypeDao.findAll(null);
		for(Film_type type:filmTypeList){
			filmTypeDao.delete(type);
		}
		if(!filmType.equals("")){
			
			String[] filmTypes=filmType.split(",");
			filmTypeList = new ArrayList<Film_type>();
			Film_type table = null;
			int i=1;
			for(String type:filmTypes){
				
				table = new Film_type();
				table.setName(type);
				table.setSeq(i);
				table.setValue(Integer.toString(i));
				i++;
				filmTypeList.add(table);
			}
			filmTypeDao.saveFilmList(filmTypeList);
		}
		
	}
	
	/**
	 * 获取影片列表
	 * 
	 */
	public ResultList<FilmBean> listFilms(Integer page, FilmBean filmBean){
		
		String hql = "select info.seq,info.film_name,info.film_intro,info.film_time,info.director,info.link,type.name,info.standard,info.film_length,info.producer,info.recommend,info.film_subject,info.folder_name,info.film_intro" +
				" from Film_info info,Film_type type where info.film_type=type.value";
		String hqlCount = "select count(*) from Film_info info,Film_type type where info.film_type=type.value";
		String addhql = "";
		
		//查询使用，组合查询条件
		if(filmBean!=null){
			
			if(CommonUtil.isNullOrNoValue(filmBean.getFilmKeyword())){				//---查询关键字
				
				addhql += " and info.film_intro like '%"+filmBean.getFilmKeyword()+"%'";
			}
			
			if(CommonUtil.isNullOrNoValue(filmBean.getFilmName())){					//---查询节目名称
				
				if(CommonUtil.isNullOrNoValue(filmBean.getSearchType())){
					//---如果模糊查询
					if(filmBean.getSearchType().equals("1")){	
						addhql += " and info.film_name like '%"+filmBean.getFilmName()+"%'";
						
					//---如果精确查询
					}else{
						addhql += " and info.film_name='"+filmBean.getFilmName()+"'";
					}
				}
			}
			
			if(CommonUtil.isNullOrNoValue(filmBean.getFilmTime())){					//---查询出品日期
				
				addhql += " and info.film_time='"+filmBean.getFilmTime()+"'";
			}
			
			if(CommonUtil.isNullOrNoValue(filmBean.getFilmLength())){				//---查询节目时长
				
				addhql += " and info.film_length='"+filmBean.getFilmLength()+"'";
			}
			
			if(CommonUtil.isNullOrNoValue(filmBean.getFilmType())&& !filmBean.getFilmType().equals("0")){					//---查询影片类别
				
					addhql += " and info.film_type='"+filmBean.getFilmType()+"'";
			}
			
			if(CommonUtil.isNullOrNoValue(filmBean.getDirector())){					//---查询导演
				
				if(CommonUtil.isNullOrNoValue(filmBean.getSearchType())){
					//---如果模糊查询
					if(filmBean.getSearchType().equals("1")){	
						addhql += " and info.director like '%"+filmBean.getDirector()+"%'";
						
					//---如果精确查询
					}else{
						addhql += " and info.director='"+filmBean.getDirector()+"'";
					}
				}
			}
			
			if(CommonUtil.isNullOrNoValue(filmBean.getAwards())){					//---查询获奖情况
				
				if(CommonUtil.isNullOrNoValue(filmBean.getSearchType())){
					//---如果模糊查询
					if(filmBean.getSearchType().equals("1")){	
						addhql += " and info.awards like '%"+filmBean.getAwards()+"%'";
						
					//---如果精确查询
					}else{
						addhql += " and info.awards='"+filmBean.getAwards()+"'";
					}
				}
			}
			
			if(CommonUtil.isNullOrNoValue(filmBean.getStandard())){					//---查询获奖情况
				
				if(CommonUtil.isNullOrNoValue(filmBean.getSearchType())){
					//---如果模糊查询
					if(filmBean.getSearchType().equals("1")){	
						addhql += " and info.standard like '%"+filmBean.getStandard()+"%'";
						
					//---如果精确查询
					}else{
						addhql += " and info.standard='"+filmBean.getStandard()+"'";
					}
				}
			}
			
//			if(CommonUtil.isNullOrNoValue(filmBean.getActor())){					//---查询演员
//				
//				if(CommonUtil.isNullOrNoValue(filmBean.getSearchType())){
//					//---如果模糊查询
//					if(filmBean.getSearchType().equals("1")){	
//						addhql += " and info.actor like '%"+filmBean.getActor()+"%'";
//						
//					//---如果精确查询
//					}else{
//						addhql += " and info.actor='"+filmBean.getActor()+"'";
//					}
//				}
//			}
			
//			if(CommonUtil.isNullOrNoValue(filmBean.getCameraman())){					//---查询摄像
//				
//				if(CommonUtil.isNullOrNoValue(filmBean.getSearchType())){
//					//---如果模糊查询
//					if(filmBean.getSearchType().equals("1")){	
//						addhql += " and info.cameraman like '%"+filmBean.getCameraman()+"%'";
//						
//					//---如果精确查询
//					}else{
//						addhql += " and info.cameraman='"+filmBean.getCameraman()+"'";
//					}
//				}
//			}
		}
		
		hql += addhql+" order by info.ctime desc";
		hqlCount += addhql;
		
		List filmList = filmDao.findByHQL(page, hql);
		ResultList<FilmBean> filmBeanList = new ResultList<FilmBean>(filmList.size());
		String count = filmDao.findCount(hqlCount);
		filmBeanList.setCount(count);
		
		Iterator it=filmList.iterator();
		while(it.hasNext()){
			
			Object[] data= (Object[])it.next();
			
			FilmBean bean = new FilmBean();
			bean = resetFilmBean(bean);
			
			bean.setSeq(Integer.toString((Integer)data[0]));
//			bean.setFilmIntro(CommonUtil.noNullString((String)data[2]));	//---noNullString字符串为null时赋空
			bean.setFilmName(CommonUtil.noNullString((String)data[1]));
			bean.setFilmTime(CommonUtil.noNullString((String)data[3]));
			bean.setDirector(CommonUtil.noNullString((String)data[4]));
			bean.setLink(CommonUtil.noNullString((String)data[5]));
			bean.setFilmType(CommonUtil.noNullString((String)data[6]));
			bean.setStandard(CommonUtil.noNullString((String)data[7]));
			bean.setFilmLength(CommonUtil.noNullString((String)data[8]));
			bean.setProducer(CommonUtil.noNullString((String)data[9]));
			bean.setRecommend((((String)data[10]!=null)&&((String)data[10]).equals("1"))?"是":"否");
			bean.setFilmSubject(CommonUtil.noNullString((String)data[11]));
			bean.setFolder_name(CommonUtil.noNullString((String)data[12]));
			try {
				bean.setFilmIntro(CommonUtil.noNullString(CommonUtil.clobToString((Clob)data[13])));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			filmBeanList.add(bean);
		}
		
		return filmBeanList;
	}
	
	/**
	 * check影片名称时候重复
	 */
	public String checkFilmName(String filmName){
		
		String checkResult = "false";
		ResultList<Film_info> filmList = filmDao.findByProperty(null, "film_name", filmName);
		if(filmList.getCount().equals("0")){
			
			checkResult = "true";
		}
		
		return checkResult;
	}
	
	/**
	 * 添加影片
	 */
	public String addFilm(FilmBean filmBean){
		
		String errorInfo = "";
		
		Film_info film = new Film_info();
		
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmName())){
			film.setFilm_name(filmBean.getFilmName());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmIntro())){
			film.setFilm_intro(CommonUtil.stringToClob(filmBean.getFilmIntro()));
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmTime())){
			film.setFilm_time(filmBean.getFilmTime());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmType())){
			film.setFilm_type(filmBean.getFilmType());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getRecommend())){
			film.setRecommend(filmBean.getRecommend().equals("on")?"1":"0");
		}else{
			film.setRecommend("0");
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getDirector())){
			film.setDirector(filmBean.getDirector());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getLink())){
			film.setLink(filmBean.getLink());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmSubject())){
			film.setFilm_subject(filmBean.getFilmSubject());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmLength())){
			film.setFilm_length(filmBean.getFilmLength());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getStandard())){
			film.setStandard(filmBean.getStandard());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getEmployee())){
			film.setEmployee(filmBean.getEmployee());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getAwards())){
			film.setAwards(filmBean.getAwards());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getProducer())){
			film.setProducer(filmBean.getProducer());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getCommentary())){
			film.setCommentary(CommonUtil.stringToClob(filmBean.getCommentary()));
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getBroadcastSituation())){
			film.setBroadcast_situation(filmBean.getBroadcastSituation());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getComment())){
			film.setComment(CommonUtil.stringToClob(filmBean.getComment()));
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getMedia())){
			film.setMedia(filmBean.getMedia());
		}
		
		Date currentTime = new Date();
		film.setCtime(currentTime);
		film.setEtime(currentTime);
		if(film.getRecommend().equals("1")){
			film.setRecommend_time(currentTime);
		}
		
		film.setSeq(getMaxSeq()+1);
		
		String filmFolderName = (CommonUtil.DTtoString(currentTime)).replace(":", "-")+CommonUtil.getRandomID();
		film.setFolder_name(filmFolderName);
		
		String destDirPath="";
//		String destthumbnailsDirPath="";
		//添加推荐影片图片
		if(filmBean.getRecommendPicture()!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/recommend/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\recommend\\";
			}
			List<File> files = new ArrayList<File>();
			files.add(filmBean.getRecommendPicture());
			List<String> fileNames = new ArrayList<String>();
			fileNames.add("recommendPicture.jpg");
			
			errorInfo = FileUtil.upload(destDirPath, files, fileNames);
			if(!errorInfo.equals("")){
				return errorInfo;
			}
			
			//调整图片尺寸
			ImgUtil.createImage(true, new File(destDirPath+"recommendPicture.jpg"), destDirPath+"recommendPicture.jpg" , 610, 250);
			
		}
		
		// 上传剧照
		if(filmBean.getPhoto()!=null && ((XWorkList)filmBean.getPhoto()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/photo/";
//				destthumbnailsDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/thumbnails/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\photo\\";
//				destthumbnailsDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\thumbnails\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getPhoto(), filmBean.getPhotoFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
//			errorInfo = FileUtil.upload(destthumbnailsDirPath, filmBean.getPhoto(), filmBean.getPhotoFileName());
//			if(!errorInfo.equals("")){
//				return errorInfo;
//			}
			
			//调整图片尺寸
//			for(String filmName: filmBean.getPhotoFileName()){
//				
//				ImgUtil.createImage(false, new File(destDirPath+filmName), destDirPath+filmName , 800, 600);
////				ImgUtil.createImage(false, new File(destthumbnailsDirPath+filmName), destthumbnailsDirPath+filmName , 200, 100);
//			}
			
		}
		
		// 上传海报
		if(filmBean.getPoster()!=null && ((XWorkList)filmBean.getPoster()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/poster/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\poster\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getPoster(), filmBean.getPosterFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
		}
		
		//上传视频截图
		if(filmBean.getVideoScreen()!=null && ((XWorkList)filmBean.getVideoScreen()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/video/screen/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\video\\screen\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getVideoScreen(), filmBean.getVideoScreenFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
		}
		
		//上传花絮视频
		if(filmBean.getVideo()!=null && ((XWorkList)filmBean.getVideo()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/video/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\video\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getVideo(), filmBean.getVideoFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
		}
		
		filmDao.save(film);
		return errorInfo;
	}
	
	/**
	 * 
	 * 编辑节目
	 */
	public String editFilm(FilmBean filmBean){
		
		String errorInfo = "";
		
		Film_info film = new Film_info();
		String sql = "select film from Film_info film where seq="+Integer.parseInt(filmBean.getSeq())+"";
		List<Film_info> films = filmDao.findByHQL(null, sql);
		Iterator<Film_info> it = films.iterator();
		if(it.hasNext()){
			film = (Film_info)it.next();
		}else{
			return "节目不存在";
		}
		
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmName())){
			film.setFilm_name(filmBean.getFilmName());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmIntro())){
			film.setFilm_intro(CommonUtil.stringToClob(filmBean.getFilmIntro()));
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmTime())){
			film.setFilm_time(filmBean.getFilmTime());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmType())){
			film.setFilm_type(filmBean.getFilmType());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getRecommend())){
			film.setRecommend(filmBean.getRecommend().equals("on")?"1":"0");
		}else{
			film.setRecommend("0");
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getDirector())){
			film.setDirector(filmBean.getDirector());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getLink())){
			film.setLink(filmBean.getLink());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmSubject())){
			film.setFilm_subject(filmBean.getFilmSubject());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getFilmLength())){
			film.setFilm_length(filmBean.getFilmLength());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getStandard())){
			film.setStandard(filmBean.getStandard());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getEmployee())){
			film.setEmployee(filmBean.getEmployee());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getAwards())){
			film.setAwards(filmBean.getAwards());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getProducer())){
			film.setProducer(filmBean.getProducer());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getCommentary())){
			film.setCommentary(CommonUtil.stringToClob(filmBean.getCommentary()));
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getBroadcastSituation())){
			film.setBroadcast_situation(filmBean.getBroadcastSituation());
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getComment())){
			film.setComment(CommonUtil.stringToClob(filmBean.getComment()));
		}
		if(CommonUtil.isNullOrNoValue(filmBean.getMedia())){
			film.setMedia(filmBean.getMedia());
		}
		
		Date currentTime = new Date();
		film.setEtime(currentTime);
		if(film.getRecommend().equals("1")){
			film.setRecommend_time(currentTime);
		}
		String filmFolderName = film.getFolder_name();
		
		String destDirPath="";
//		String destthumbnailsDirPath="";
		//删除推荐影片图片
		if(CommonUtil.isNullOrNoValue(filmBean.getRecommendDel())){
			for(String recommendName: filmBean.getRecommendDel().split(",")){
				if(CommonUtil.isNullOrNoValue(recommendName)){
					if(File.separator.equals("/")){				//---Linux系统
						destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/recommend/";
					}
					if(File.separator.equals("\\")){			//---Windows系统
						destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\recommend\\";
					}
					FileUtil.DeleteFolder(destDirPath+recommendName);
				}
			}
		}
		
		//删除节目剧照
		if(CommonUtil.isNullOrNoValue(filmBean.getPhotoDel())){
			for(String photoName: filmBean.getPhotoDel().split(",")){
				if(CommonUtil.isNullOrNoValue(photoName)){
					if(File.separator.equals("/")){				//---Linux系统
						destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/photo/";
//						destthumbnailsDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/thumbnails/";
					}
					if(File.separator.equals("\\")){			//---Windows系统
						destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\photo\\";
//						destthumbnailsDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\thumbnails\\";
					}
					FileUtil.DeleteFolder(destDirPath+photoName);
				}
			}
		}
		
		//删除节目海报
		if(CommonUtil.isNullOrNoValue(filmBean.getPosterDel())){
			for(String posterName: filmBean.getPosterDel().split(",")){
				if(CommonUtil.isNullOrNoValue(posterName)){
					if(File.separator.equals("/")){				//---Linux系统
						destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/poster/";
					}
					if(File.separator.equals("\\")){			//---Windows系统
						destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\poster\\";
					}
					FileUtil.DeleteFolder(destDirPath+posterName);
				}
			}
		}
		
		//删除节目花絮
		if(CommonUtil.isNullOrNoValue(filmBean.getVideoDel())){
			for(String videoName: filmBean.getVideoDel().split(",")){
				if(CommonUtil.isNullOrNoValue(videoName)){
					if(File.separator.equals("/")){				//---Linux系统
						destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/video/";
					}
					if(File.separator.equals("\\")){			//---Windows系统
						destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\video\\";
					}
					FileUtil.DeleteFolder(destDirPath+videoName);
				}
			}
		}
		
		//删除花絮截图
		if(CommonUtil.isNullOrNoValue(filmBean.getVideoDel())){
			for(String videoName: filmBean.getVideoDel().split(",")){
				if(CommonUtil.isNullOrNoValue(videoName)){
					if(File.separator.equals("/")){				//---Linux系统
						destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/video/screen/";
					}
					if(File.separator.equals("\\")){			//---Windows系统
						destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\video\\screen\\";
					}
					FileUtil.DeleteFolder(destDirPath+videoName.replace("flv", "jpg"));
				}
			}
		}
		
		//添加推荐影片图片
		if(filmBean.getRecommendPicture()!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/recommend/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\recommend\\";
			}
			List<File> files = new ArrayList<File>();
			files.add(filmBean.getRecommendPicture());
			List<String> fileNames = new ArrayList<String>();
			fileNames.add("recommendPicture.jpg");
			
			errorInfo = FileUtil.upload(destDirPath, files, fileNames);
			if(!errorInfo.equals("")){
				return errorInfo;
			}
			
			//调整图片尺寸
			ImgUtil.createImage(true, new File(destDirPath+"recommendPicture.jpg"), destDirPath+"recommendPicture.jpg" , 610, 250);
			
		}
		
		// 上传剧照
		if(filmBean.getPhoto()!=null && ((XWorkList)filmBean.getPhoto()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/photo/";
//				destthumbnailsDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/thumbnails/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\photo\\";
//				destthumbnailsDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\thumbnails\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getPhoto(), filmBean.getPhotoFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
//			errorInfo = FileUtil.upload(destthumbnailsDirPath, filmBean.getPhoto(), filmBean.getPhotoFileName());
//			if(!errorInfo.equals("")){
//				return errorInfo;
//			}
			
			//调整图片尺寸
//			for(String filmName: filmBean.getPhotoFileName()){
//				
//				ImgUtil.createImage(false, new File(destDirPath+filmName), destDirPath+filmName , 800, 600);
////				ImgUtil.createImage(false, new File(destthumbnailsDirPath+filmName), destthumbnailsDirPath+filmName , 200, 100);
//			}
			
		}
		
		// 上传海报
		if(filmBean.getPoster()!=null && ((XWorkList)filmBean.getPoster()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/poster/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\poster\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getPoster(), filmBean.getPosterFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
		}
		
		//上传视频截图
		if(filmBean.getVideoScreen()!=null && ((XWorkList)filmBean.getVideoScreen()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/video/screen/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\video\\screen\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getVideoScreen(), filmBean.getVideoScreenFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
		}
		
		//上传花絮视频
		if(filmBean.getVideo()!=null && ((XWorkList)filmBean.getVideo()).get(0)!=null){
			
			if(File.separator.equals("/")){				//---Linux系统
				destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/video/";
			}
			if(File.separator.equals("\\")){			//---Windows系统
				destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\video\\";
			}
			
			errorInfo = FileUtil.upload(destDirPath, filmBean.getVideo(), filmBean.getVideoFileName());
			if(!errorInfo.equals("")){
				return errorInfo;
			}
		}
		
		filmDao.update(film);
		return errorInfo;
	}
	
	/**
	 * 删除影片
	 */
	public void delFilm(String filmId){
		
			
		Film_info film = getFilmById(filmId);
		if(film!=null){
			
			String filmFolderName = film.getFolder_name()!=null?film.getFolder_name():"";
			if(filmFolderName!=null && !filmFolderName.equals("")){
				//删除上传的文件
				String destDirPath = "";
				if(File.separator.equals("/")){				//---Linux系统
					destDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName;
				}
				if(File.separator.equals("\\")){			//---Windows系统
					destDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName;
				}
				FileUtil.DeleteFolder(destDirPath);
			}
			
			filmDao.delete(film);
		}
	}
	
	/**
	 * 批量删除影片
	 */
	public void mutipleDelFilms(String filmIds){
		
		String[] filmIdArray = filmIds.split(",");
		for(String filmId: filmIdArray){
			
			delFilm(filmId);
		}
	}
	
	/**
	 * 根据id获取单个影片的详细信息
	 */
	public FilmBean getFilmDetail(String filmId){
		
		FilmBean filmBean = resetFilmBean(new FilmBean());
		Film_info film = getFilmById(filmId);
		if(film!=null){
			
			try {
				setFilmBean(filmBean,film);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String filmFolderName = film.getFolder_name();
			if(filmFolderName!=null && !filmFolderName.equals("")){
				
				String recommendDirPath = "";
				String photoDirPath = "";
				String videoDirPath = "";
				String posterDirPath = "";
//				String thumbnailsDirPath = "";
				if(File.separator.equals("/")){				//---Linux系统
					recommendDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/recommend";
					photoDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/photo";
					videoDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/video";
					posterDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/poster";
//					thumbnailsDirPath = SystemConfig.getUploadPathLinux()+"/"+filmFolderName+"/picture/thumbnails";
				}
				if(File.separator.equals("\\")){			//---Windows系统
					recommendDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\recommend";
					photoDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\photo";
					videoDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\video";
					posterDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\poster";
//					thumbnailsDirPath = SystemConfig.getUploadPathWindows()+"\\"+filmFolderName+"\\picture\\thumbnails";
				}
				
				filmBean.setRecommendPath(FileUtil.getFileAbsolutePath(recommendDirPath));
				filmBean.setPhotoPath(FileUtil.getFileAbsolutePath(photoDirPath));
				ResultList<String> videoRes = FileUtil.getFileAbsolutePath(videoDirPath);
				filmBean.setPosterPath(FileUtil.getFileAbsolutePath(posterDirPath));
				
				ResultList<VideoBean> videoList = new ResultList<VideoBean>();
				VideoBean videoBean = null;
				for(String s: videoRes){
					videoBean = new VideoBean();
					videoBean.setVideoName(s);
					videoBean.setVideoScreenName(s.replace("flv", "jpg"));
					videoList.add(videoBean);
				}
				filmBean.setVideoPath(videoList);
//				filmBean.setThumbnailsPath(FileUtil.getFileAbsolutePath(thumbnailsDirPath));
			}
		}else{
			
			filmBean.setRemark("false");		//---影片不存在
		}
		return filmBean;
	}
	
	/**
	 * 获取推荐影片列表
	 * 
	 */
	public ResultList<FilmBean> getRecommendFilms(){
		
		ResultList<FilmBean> list = new ResultList<FilmBean>();
		String sql = "select info.seq, info.film_subject, info.folder_name from Film_info info where info.recommend='1' order by info.recommend_time desc limit 5";
		List res = filmDao.findByHQL(null, sql);
		Iterator it = res.iterator();
		FilmBean bean = null;
		int i=1;
		while(it.hasNext()){
			if(i>5){
				break;
			}
			Object[] data = (Object[])it.next();
			bean = new FilmBean();
			bean.setSeq(Integer.toString((Integer)data[0]));
			bean.setFilmSubject((String)data[1]);
			bean.setFolder_name((String)data[2]);
			
			list.add(bean);
			i++;
		}
		return list;
	}
	
	/**
	 * 初始化FilmBean
	 */
	public static FilmBean resetFilmBean(FilmBean filmBean){
		
		if(filmBean==null){
			
			filmBean = new FilmBean();
		}
		
		filmBean.setFilmIntro("");
		filmBean.setFilmName("");
		filmBean.setFilmTime("");
		filmBean.setFilmType("");
		filmBean.setRemark("");
		filmBean.setDirector("");
		filmBean.setLink("");
		filmBean.setFilmLength("");
		filmBean.setStandard("");
		filmBean.setCtime("");
		filmBean.setFolder_name("");
		filmBean.setEmployee("");
		filmBean.setAwards("");
		filmBean.setProducer("");
		filmBean.setCommentary("");
		filmBean.setBroadcastSituation("");
		filmBean.setComment("");
		filmBean.setMedia("");
//		filmBean.setVideoFileName(new ResultList<String>());
//		filmBean.setRecommendName(new ResultList<String>());
//		filmBean.setPosterFileName(new ResultList<String>());
//		filmBean.setPhotoFileName(new ResultList<String>());
		filmBean.setRecommendPath(new ResultList<String>());
		filmBean.setPhotoPath(new ResultList<String>());
		filmBean.setVideoPath(new ResultList<VideoBean>());
		filmBean.setPosterPath(new ResultList<String>());
//		filmBean.setThumbnailsPath(new ResultList<String>());
		
		return filmBean;
	}
	
	/**
	 * 为FilmBean赋值
	 * @throws SQLException 
	 */
	public FilmBean setFilmBean(FilmBean filmBean, Film_info film) throws SQLException{
		
		filmBean.setSeq(Integer.toString(film.getSeq()));
		filmBean.setCtime(CommonUtil.noNullString(CommonUtil.DTtoString(film.getCtime())));
		filmBean.setDirector(CommonUtil.noNullString(film.getDirector()));
		filmBean.setFilmIntro(CommonUtil.noNullString(CommonUtil.clobToString(film.getFilm_intro())));
		filmBean.setFilmLength(CommonUtil.noNullString(film.getFilm_length()));
		filmBean.setFilmName(CommonUtil.noNullString(film.getFilm_name()));
		filmBean.setFilmSubject(CommonUtil.noNullString(film.getFilm_subject()));
		filmBean.setFilmTime(CommonUtil.noNullString(film.getFilm_time()));
		filmBean.setFilmTypeValue(film.getFilm_type());
		filmBean.setFilmType(getTypeNameByValue(film.getFilm_type()));
		filmBean.setLink(CommonUtil.noNullString(film.getLink()));
		filmBean.setRecommend(CommonUtil.noNullString(film.getRecommend()));
		filmBean.setStandard(CommonUtil.noNullString(film.getStandard()));
		filmBean.setEmployee(CommonUtil.noNullString(film.getEmployee()));
		filmBean.setAwards(CommonUtil.noNullString(film.getAwards()));
		filmBean.setProducer(CommonUtil.noNullString(film.getProducer()));
		filmBean.setCommentary(CommonUtil.noNullString(CommonUtil.clobToString(film.getCommentary())));
		filmBean.setBroadcastSituation(CommonUtil.noNullString(film.getBroadcast_situation()));
		filmBean.setComment(CommonUtil.noNullString(CommonUtil.clobToString(film.getComment())));
		filmBean.setMedia(CommonUtil.noNullString(film.getMedia()));
		filmBean.setFolder_name(CommonUtil.noNullString(film.getFolder_name()));

		return filmBean;
	}
	
	/**
	 * 获取film_info表最大的seq值
	 */
	public Integer getMaxSeq(){
		
		int max = 0;
		String hql = "select MAX(seq) from Film_info";
		List res = filmDao.findByHQL(null, hql);
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
	 * 根据分类的value获取分类名称
	 */
	public String getTypeNameByValue(String value){
		
		String typeName = "";
		if(value!=null){
			
			ResultList<Film_type> res = filmTypeDao.findByProperty(null, "value", value);
			Iterator<Film_type> it = res.iterator();
			
			if(it.hasNext()){
				
				Film_type filmType = (Film_type)it.next();
				typeName = filmType.getName();
			}
		}
		return typeName;
	}
	
	/**
	 * 根据seq（id）获取影片
	 */
	public Film_info getFilmById(String filmId){
		
		Film_info film = null;
		String hql = "select film from Film_info film where seq="+Integer.parseInt(filmId);
		List<Film_info> filmList = filmDao.findByHQL(null, hql);
		Iterator<Film_info> it = filmList.iterator();
		if(it.hasNext()){
			film = (Film_info)it.next();
		}
		
		return film;
	}
}
