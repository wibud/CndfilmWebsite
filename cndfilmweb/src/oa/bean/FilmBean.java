package oa.bean;

import java.io.File;
import java.util.List;

import oa.util.ResultList;

public class FilmBean {
	
	private String seq;
	
	private String filmName;					//---节目片名
	
	private String filmType;					//---节目类型
	
	private String filmTypeValue;				
	
	private String filmTime;					//---出品日期
	
	private String filmIntro;					//---内容简介
	
	private String remark;						//---备注
	
	private String filmKeyword;					//---关键词
	
	private String searchType;					//---查询方式：0，精确；1：模糊
	
	private String recommend;					//---是否推荐：0，否；1，是
	
	private String filmSubject;					
	
	private File recommendPicture;				//---上传的推荐节目图片
	
	private List<String> recommendName;			//---上传推荐图片的文件名
	
	private List<File> photo;					//---上传的剧照
	
	private List<String> photoFileName;			//---上传剧照的文件名
	
	private List<File> video;					//---上传的花絮
	
	private List<String> videoFileName;			//---上传花絮的文件名
	
	private List<File> poster;					//---上传的海报
	
	private List<String> posterFileName;		//---上传海报的文件名
	
	private List<File> videoScreen;				//---上传的视频截图
	
	private List<String> videoScreenFileName;	//---上传截图的文件名
	
	private String ctime;						//---入库时间
	
	private String etime;						//---修改时间
	
	private String director;					//---导演/编导
	
	private String link;						//---链接
	
	private String standard;					//---节目格式
	
	private String filmLength;					//---节目时长
	
	private String employee;					//---职员表
	
	private String awards;						//---获奖情况
	
	private String producer;					//---制作单位
	
	private	String commentary;					//---台本/解说词
	
	private String broadcastSituation;			//---播出情况
	
	private String comment;						//---评论文章
	
	private String media;						//---媒体宣传
	
	private String folder_name;					//---上传文件所在文件夹名称
	
	private ResultList<String> recommendPath;	//---推荐影片展示图片的路径
//	
	private ResultList<String> photoPath;		//---上传剧照的路径
//	
//	private ResultList<String> thumbnailsPath;	//---剧照缩略图的路径
//	
	private ResultList<VideoBean> videoPath;	//---上传视频的路径
	
	private ResultList<String> posterPath;		//---上传的海报的路径
	
	private String recommendDel;				//---删除的推荐图片名称
	
	private String photoDel;					//---删除的剧照名称
	
	private String posterDel;					//---删除的海报名称
	
	private String videoDel;					//---删除的视频名称
	
	
	//=======getter and setter============
	
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmType() {
		return filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	public String getFilmTime() {
		return filmTime;
	}

	public void setFilmTime(String filmTime) {
		this.filmTime = filmTime;
	}

	public String getFilmIntro() {
		return filmIntro;
	}

	public void setFilmIntro(String filmIntro) {
		this.filmIntro = filmIntro;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFilmKeyword() {
		return filmKeyword;
	}

	public void setFilmKeyword(String filmKeyword) {
		this.filmKeyword = filmKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public ResultList<String> getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(ResultList<String> photoPath) {
		this.photoPath = photoPath;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getFilmSubject() {
		return filmSubject;
	}

	public void setFilmSubject(String filmSubject) {
		this.filmSubject = filmSubject;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(String filmLength) {
		this.filmLength = filmLength;
	}

	public File getRecommendPicture() {
		return recommendPicture;
	}

	public void setRecommendPicture(File recommendPicture) {
		this.recommendPicture = recommendPicture;
	}

	public List<File> getPhoto() {
		return photo;
	}

	public void setPhoto(List<File> photo) {
		this.photo = photo;
	}


	public List<File> getVideo() {
		return video;
	}

	public void setVideo(List<File> video) {
		this.video = video;
	}

	public String getFolder_name() {
		return folder_name;
	}

	public void setFolder_name(String folderName) {
		folder_name = folderName;
	}

//	public ResultList<String> getThumbnailsPath() {
//		return thumbnailsPath;
//	}
//
//	public void setThumbnailsPath(ResultList<String> thumbnailsPath) {
//		this.thumbnailsPath = thumbnailsPath;
//	}
//
	public ResultList<String> getRecommendPath() {
		return recommendPath;
	}

	public void setRecommendPath(ResultList<String> recommendPath) {
		this.recommendPath = recommendPath;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public List<File> getPoster() {
		return poster;
	}

	public void setPoster(List<File> poster) {
		this.poster = poster;
	}

	public String getBroadcastSituation() {
		return broadcastSituation;
	}

	public void setBroadcastSituation(String broadcastSituation) {
		this.broadcastSituation = broadcastSituation;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public List<String> getRecommendName() {
		return recommendName;
	}

	public void setRecommendName(List<String> recommendName) {
		this.recommendName = recommendName;
	}

	public List<String> getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(List<String> photoFileName) {
		this.photoFileName = photoFileName;
	}

	public List<String> getVideoFileName() {
		return videoFileName;
	}

	public void setVideoFileName(List<String> videoFileName) {
		this.videoFileName = videoFileName;
	}

	public List<String> getPosterFileName() {
		return posterFileName;
	}

	public void setPosterFileName(List<String> posterFileName) {
		this.posterFileName = posterFileName;
	}

	public ResultList<String> getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(ResultList<String> posterPath) {
		this.posterPath = posterPath;
	}

	public String getCtime() {
		return ctime;
	}

	public String getFilmTypeValue() {
		return filmTypeValue;
	}

	public void setFilmTypeValue(String filmTypeValue) {
		this.filmTypeValue = filmTypeValue;
	}

	public List<File> getVideoScreen() {
		return videoScreen;
	}

	public void setVideoScreen(List<File> videoScreen) {
		this.videoScreen = videoScreen;
	}

	public List<String> getVideoScreenFileName() {
		return videoScreenFileName;
	}

	public void setVideoScreenFileName(List<String> videoScreenFileName) {
		this.videoScreenFileName = videoScreenFileName;
	}

	public ResultList<VideoBean> getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(ResultList<VideoBean> videoPath) {
		this.videoPath = videoPath;
	}

	public String getRecommendDel() {
		return recommendDel;
	}

	public void setRecommendDel(String recommendDel) {
		this.recommendDel = recommendDel;
	}

	public String getPhotoDel() {
		return photoDel;
	}

	public void setPhotoDel(String photoDel) {
		this.photoDel = photoDel;
	}

	public String getPosterDel() {
		return posterDel;
	}

	public void setPosterDel(String posterDel) {
		this.posterDel = posterDel;
	}

	public String getVideoDel() {
		return videoDel;
	}

	public void setVideoDel(String videoDel) {
		this.videoDel = videoDel;
	}
	
}
