package oa.model.table;


import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oa.dao.DatabaseAnno;

@DatabaseAnno(id = "seq")
@Entity
@Table(name = "film_info")
public class Film_info {
	
	@Id
	private Integer seq;					//---主键,递增
	
	private String film_name;				//---节目片名
	
	private Clob film_intro;				//---内容简介
	
	private String film_type;				//---节目类型
	
	private String film_time;				//---出品日期
	
	private String film_subject;			//---节目主题
	
	private String director;				//---导演/编导
	
	private String recommend;				//---是否推荐:0,否;1,是
	
	private Date ctime;						//---入库时间
	
	private String link;					//---链接
	
	private String standard;				//---节目格式
	
	private String film_length;				//---节目时长
	
	private Date etime;						//---修改时间
	
	private String folder_name;				//---上传文件所在文件夹名称
	
	private String employee;				//---职员表
	
	private String awards;					//---获奖情况
	
	private String producer;				//---制作单位
	
	private	Clob commentary;				//---台本/解说词
	
	private String broadcast_situation;		//---播出情况
	
	private Clob comment;					//---评论文章
	
	private String media;					//---媒体宣传
	
	private Date recommend_time;			//---推荐时间
	
	private String remark;					
	
	
	//======getter and setter==============
	
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getFilm_name() {
		return film_name;
	}

	public void setFilm_name(String filmName) {
		film_name = filmName;
	}

	public Clob getFilm_intro() {
		return film_intro;
	}

	public void setFilm_intro(Clob filmIntro) {
		film_intro = filmIntro;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFilm_time() {
		return film_time;
	}

	public void setFilm_time(String filmTime) {
		film_time = filmTime;
	}

	public String getFilm_type() {
		return film_type;
	}

	public void setFilm_type(String filmType) {
		film_type = filmType;
	}

	public String getFilm_subject() {
		return film_subject;
	}

	public void setFilm_subject(String filmSubject) {
		film_subject = filmSubject;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
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

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getFilm_length() {
		return film_length;
	}

	public void setFilm_length(String filmLength) {
		film_length = filmLength;
	}

	public String getFolder_name() {
		return folder_name;
	}

	public void setFolder_name(String folderName) {
		folder_name = folderName;
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

	public Clob getCommentary() {
		return commentary;
	}

	public void setCommentary(Clob commentary) {
		this.commentary = commentary;
	}

	public String getBroadcast_situation() {
		return broadcast_situation;
	}

	public void setBroadcast_situation(String broadcastSituation) {
		broadcast_situation = broadcastSituation;
	}

	public Clob getComment() {
		return comment;
	}

	public void setComment(Clob comment) {
		this.comment = comment;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public Date getRecommend_time() {
		return recommend_time;
	}

	public void setRecommend_time(Date recommendTime) {
		recommend_time = recommendTime;
	}
	
}
