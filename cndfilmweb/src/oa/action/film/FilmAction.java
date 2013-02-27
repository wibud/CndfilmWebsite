package oa.action.film;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import oa.action.BaseAction;
import oa.bean.BaseInfoBean;
import oa.bean.FilmBean;
import oa.bean.FilmTypeBean;
import oa.util.CommonUtil;
import oa.util.ResultList;

public class FilmAction  extends BaseAction{
	
	private String filmId;
	
	private String filmType;
	
	private String filmName;
	
	private String filmTime;
	
	private String filmIntro;
	
	private String director;
	
	private String link;
	
	private String recommend;
	
	private String filmSubject;
	
	private String filmLength;
	
	private String standard;
	
	private String employee;					//---职员表
	
	private String awards;						//---获奖情况
	
	private String producer;					//---制作单位
	
	private	String commentary;					//---台本/解说词
	
	private String broadcastSituation;			//---播出情况
	
	private String comment;						//---评论文章
	
	private String media;						//---媒体宣传
	
	private String folder_name;					
	
	private File recommendPicture;				//---上传的推荐节目图片
	
	private String recommendPictureFileName;	//---推荐节目图片文件名
	
	private String recommendPictureContentType;	//---推荐节目图片的类型
	
	private List<File> photo;					//---上传的剧照
	
	private List<String> photoFileName;			//---上传剧照的文件名
	
	private List<File> video;					//---上传的花絮
	
	private List<String> videoFileName;			//---上传花絮的文件名
	
	private List<File> poster;					//---上传的海报
	
	private List<String> posterFileName;		//---上传海报的文件名
	
	private List<File> videoScreen;				//---上传的视频截图
	
	private List<String> videoScreenFileName;	//---上传截图的文件名
	
	private String recommendDel;				//---删除的推荐图片名称
	
	private String photoDel;					//---删除的剧照名称
	
	private String posterDel;					//---删除的海报名称
	
	private String videoDel;					//---删除的视频名称
	
	private String filmKeyword;
	
	private String searchType;					//---查询类型，精确或模糊
	
	private String videoName;
	
	private String checkResult;
	
	private String resultMsg;
	
	private String linkFrom;
	
	private String linkTo;
	
	private String userName;					//---联系我们的用户名字
	
	private String userEmail;					//---联系我们的用户email
	
	private String message;						//---联系我们的内容
	
	private List<FilmTypeBean> filmTypeList;	//---影片分类
	
	private ResultList<FilmBean> filmList;		//---查询、列表使用
	
	private FilmBean filmDetail;				//---查看详情、编辑使用
	
	private BaseInfoBean baseInfo;
	
	private ResultList<FilmBean> recommendFilmList;	//---推荐影片列表
	
	/**
	 * 初始化
	 */
	public String init(){
		
		listFilm();
		listFilmType();
		listBaseInfo();
		return SUCCESS;
	}
	
	/**
	 * 首页
	 */
	public String homePage(){
		
		getRecommendFilms();
		listBaseInfo();
		String result = null;
		if(linkTo!=null && linkTo.equals("introduce")){
			result="introduce";
		}else if(linkTo!=null && linkTo.equals("contactUs")){
			result="contactUs";
		}else{
			result="index";
		}
		return result;
	}
	
	/**
	 * 影片库
	 */
	public String filmLibrary(){
		
		listFilm();
		getRecommendFilms();
		return SUCCESS;
	}
	
	/**
	 * 高级查询
	 */
	public String advancedSearch(){
		
		searchFilm();
		getRecommendFilms();
		return SUCCESS;
	}
	
	/**
	 * 影片详情
	 */
	public String filmDetail(){
		
		detailFilm();
		getRecommendFilms();
		String result = null;
		if(linkTo!=null && linkTo.equals("comment")){
			result="comment";
		}else if(linkTo!=null && linkTo.equals("commentary")){
			result="commentary";
		}else if(linkTo!=null && linkTo.equals("photo")){
			result="photo";
		}else if(linkTo!=null && linkTo.equals("poster")){
			result="poster";
		}else if(linkTo!=null && linkTo.equals("video")){
			result="video";
		}else if(linkTo!=null && linkTo.equals("videoDetail")){
			result="videoDetail";
		}else{
			result="detail";
		}
		return result;
	}
	
	/**
	 * 联系我们，发送邮件
	 */
	public String sendEmail(){
		
		emailManager.sendEmail(userName, userEmail, message);
		return SUCCESS;
	}
	
	/**
	 * 高级查询页面
	 */
	public String advancedSearchPage(){
		
		getRecommendFilms();
		listFilmType();
		return SUCCESS;
	}
	
	
	/**
	 * 获取影片分类
	 * @return
	 */
	public String listFilmType(){
		
		filmTypeList = filmManager.listFilmType();
		return SUCCESS;
	}
	
	/**
	 * 修改影片分类
	 * @return
	 */
	public String modifyFilmType(){
		filmManager.modifyFilmType(filmType);
		return SUCCESS;
	}
	
	/**
	 * 获取影片列表
	 * @return
	 */
	public String listFilm(){
		
		Integer pageNo = 1;			//默认第一页
		if(page!=null){
			pageNo = Integer.parseInt(page);
		}
		
		filmList = filmManager.listFilms(pageNo, null);
		count = filmList.getCount();
		pageCount = CommonUtil.getPageCount(count);
		startWith = CommonUtil.getStartWith(pageNo);
		return SUCCESS;
	}
	
	/**
	 * 获取基本信息
	 * @return
	 */
	public String listBaseInfo(){
		
		baseInfo = baseInfoManager.getBaseInfo();
		return SUCCESS;
	}
	
	/**
	 * check影片名称是否重复
	 * @return
	 */
	public String checkFilmName(){
		
		checkResult = filmManager.checkFilmName(filmName);
		return SUCCESS;
	}
	
	/**
	 * 添加影片
	 * @return
	 */
	public String addFilm(){
		
		FilmBean filmBean = new FilmBean();
		filmBean.setDirector(director);
		filmBean.setFilmIntro(filmIntro);
		filmBean.setFilmName(filmName);
		filmBean.setFilmTime(filmTime);
		filmBean.setFilmType(filmType);
		filmBean.setLink(link);
		filmBean.setRecommend(recommend);
		filmBean.setFilmSubject(filmSubject);
		filmBean.setFilmLength(filmLength);
		filmBean.setStandard(standard);
		filmBean.setEmployee(employee);
		filmBean.setAwards(awards);
		filmBean.setProducer(producer);
		filmBean.setCommentary(commentary);
		filmBean.setBroadcastSituation(broadcastSituation);
		filmBean.setComment(comment);
		filmBean.setMedia(media);
		filmBean.setRecommendPicture(recommendPicture);
		filmBean.setPhoto(photo);
		filmBean.setPhotoFileName(photoFileName);
		filmBean.setVideo(video);
		filmBean.setVideoFileName(videoFileName);
		filmBean.setPoster(poster);
		filmBean.setPosterFileName(posterFileName);
		filmBean.setVideoScreen(videoScreen);
		filmBean.setVideoScreenFileName(videoScreenFileName);
		resultMsg=filmManager.addFilm(filmBean);
		return SUCCESS;
	}
	
	/**
	 * 编辑影片
	 * 
	 */
	public String editFilm(){
		
		FilmBean filmBean = new FilmBean();
		filmBean.setSeq(filmId);
		filmBean.setFolder_name(folder_name);
		filmBean.setDirector(director);
		filmBean.setFilmIntro(filmIntro);
		filmBean.setFilmName(filmName);
		filmBean.setFilmTime(filmTime);
		filmBean.setFilmType(filmType);
		filmBean.setLink(link);
		filmBean.setRecommend(recommend);
		filmBean.setFilmSubject(filmSubject);
		filmBean.setFilmLength(filmLength);
		filmBean.setStandard(standard);
		filmBean.setEmployee(employee);
		filmBean.setAwards(awards);
		filmBean.setProducer(producer);
		filmBean.setCommentary(commentary);
		filmBean.setBroadcastSituation(broadcastSituation);
		filmBean.setComment(comment);
		filmBean.setMedia(media);
		filmBean.setRecommendPicture(recommendPicture);
		filmBean.setPhoto(photo);
		filmBean.setPhotoFileName(photoFileName);
		filmBean.setVideo(video);
		filmBean.setVideoFileName(videoFileName);
		filmBean.setPoster(poster);
		filmBean.setPosterFileName(posterFileName);
		filmBean.setVideoScreen(videoScreen);
		filmBean.setVideoScreenFileName(videoScreenFileName);
		filmBean.setRecommendDel(recommendDel);
		filmBean.setPhotoDel(photoDel);
		filmBean.setPosterDel(posterDel);
		filmBean.setVideoDel(videoDel);
		resultMsg=filmManager.editFilm(filmBean);
		return SUCCESS;
	}
	
	/**
	 * 删除影片
	 * @return
	 */
	public String delFilm(){
		
		filmManager.delFilm(filmId);
		return SUCCESS;
	}
	
	/**
	 * 批量删除影片
	 * @return
	 */
	public String mutipleDelFilms(){
		
		filmManager.mutipleDelFilms(filmId);
		return SUCCESS;
	}
	
	/**
	 * 根据id获取单个影片的详细信息
	 * @return
	 */
	public String detailFilm(){
		
		filmDetail = filmManager.getFilmDetail(filmId);
		if(filmDetail.getRemark().equals("false")){
			resultMsg="影片资源不存在，请重新刷新页面！";
		}
		
		if(linkFrom!=null && linkFrom.equals("detail")){
			return "detail";
		}else{
			listFilmType();
			return "edit";
		}
		
	}
	
	/**
	 * 影片查询
	 * @return
	 */
	public String searchFilm(){
		
		Integer pageNo = 1;			//默认第一页
		if(page!=null){
			pageNo = Integer.parseInt(page);
		}
		
		FilmBean filmBean = new FilmBean();
//		if(ServletActionContext.getRequest().getRequestURI().equals("/searchFilm")){
//			director = new String(director.getBytes("ISO-8859-1"), "UTF-8");
//			filmName = new String(filmName.getBytes("ISO-8859-1"), "UTF-8");
//			filmTime = new String(filmTime.getBytes("ISO-8859-1"), "UTF-8");
//			filmType = new String(filmType.getBytes("ISO-8859-1"), "UTF-8");
//			filmKeyword = new String(filmKeyword.getBytes("ISO-8859-1"), "UTF-8");
//			filmLength = new String(filmLength.getBytes("ISO-8859-1"), "UTF-8");
//			awards = new String(awards.getBytes("ISO-8859-1"), "UTF-8");
//			standard = new String(standard.getBytes("ISO-8859-1"), "UTF-8");
//		}
		filmBean.setDirector(director);
		filmBean.setFilmName(filmName);
		filmBean.setFilmTime(filmTime);
		filmBean.setFilmType(filmType);
		filmBean.setFilmKeyword(filmKeyword);
		filmBean.setFilmLength(filmLength);
		filmBean.setAwards(awards);
		filmBean.setStandard(standard);
		filmBean.setSearchType("1");			//---默认成模糊查询
		
		filmList = filmManager.listFilms(pageNo, filmBean);
		count = filmList.getCount();
		pageCount = CommonUtil.getPageCount(count);
		startWith = CommonUtil.getStartWith(pageNo);
		return SUCCESS;
	}
	
	public String getRecommendFilms(){
		
		recommendFilmList = filmManager.getRecommendFilms();
		return SUCCESS;
	}
	
	
	//=======getter and setter======================
	
	public List<FilmTypeBean> getFilmTypeList() {
		return filmTypeList;
	}

	public void setFilmTypeList(List<FilmTypeBean> filmTypeList) {
		this.filmTypeList = filmTypeList;
	}

	public String getFilmType() {
		return filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public ResultList<FilmBean> getFilmList() {
		return filmList;
	}

	public void setFilmList(ResultList<FilmBean> filmList) {
		this.filmList = filmList;
	}

	public BaseInfoBean getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfoBean baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
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

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getFilmSubject() {
		return filmSubject;
	}

	public void setFilmSubject(String filmSubject) {
		this.filmSubject = filmSubject;
	}

	public String getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(String filmLength) {
		this.filmLength = filmLength;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public File getRecommendPicture() {
		return recommendPicture;
	}

	public void setRecommendPicture(File recommendPicture) {
		this.recommendPicture = recommendPicture;
	}

	public String getRecommendPictureFileName() {
		return recommendPictureFileName;
	}

	public void setRecommendPictureFileName(String recommendPictureFileName) {
		this.recommendPictureFileName = recommendPictureFileName;
	}

	public String getRecommendPictureContentType() {
		return recommendPictureContentType;
	}

	public void setRecommendPictureContentType(String recommendPictureContentType) {
		this.recommendPictureContentType = recommendPictureContentType;
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

	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public FilmBean getFilmDetail() {
		return filmDetail;
	}

	public void setFilmDetail(FilmBean filmDetail) {
		this.filmDetail = filmDetail;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getFilmKeyword() {
		return filmKeyword;
	}

	public void setFilmKeyword(String filmKeyword) {
		this.filmKeyword = filmKeyword;
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

	public String getLinkFrom() {
		return linkFrom;
	}

	public void setLinkFrom(String linkFrom) {
		this.linkFrom = linkFrom;
	}

	public String getFolder_name() {
		return folder_name;
	}

	public void setFolder_name(String folderName) {
		folder_name = folderName;
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

	public ResultList<FilmBean> getRecommendFilmList() {
		return recommendFilmList;
	}

	public void setRecommendFilmList(ResultList<FilmBean> recommendFilmList) {
		this.recommendFilmList = recommendFilmList;
	}

	public String getLinkTo() {
		return linkTo;
	}

	public void setLinkTo(String linkTo) {
		this.linkTo = linkTo;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
