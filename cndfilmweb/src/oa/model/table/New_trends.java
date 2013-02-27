package oa.model.table;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oa.dao.DatabaseAnno;

@DatabaseAnno(id = "seq")
@Entity
@Table(name = "new_trends")
public class New_trends {
	
	@Id
	private Integer seq;					//---主键,递增
	
	private Date ctime;						//---入库时间
	
	private String content;					//---新闻动态
	
	private String title;					//---新闻标题
	
	private String time;					//---新闻时间
	
	//========getter and setter==================
	
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
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
	
}
