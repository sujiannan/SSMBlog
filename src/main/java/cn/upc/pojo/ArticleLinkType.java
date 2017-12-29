package cn.upc.pojo;

import java.util.Date;

public class ArticleLinkType {

	private Integer id;

	private String title;
	
	private ArtiType artiType;
	
	private Date time;
	
	private String context;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArtiType getArtiType() {
		return artiType;
	}

	public void setArtiType(ArtiType artiType) {
		this.artiType = artiType;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "ArticleLinkType [id=" + id + ", title=" + title + ", artiType=" + artiType + ", time=" + time
				+ ", context=" + context + "]";
	}
	
	
}
