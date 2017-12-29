package cn.upc.pojo;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private Integer typeId;

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
        this.title = title == null ? null : title.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
        this.context = context == null ? null : context.trim();
    }

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", typeId=" + typeId + ", time=" + time + ", context="
				+ context + "]";
	}
    
    
}