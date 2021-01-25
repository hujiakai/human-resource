package com.harvey.human.base;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable{
	private static final long serialVersionUID = 3412892042404117456L;
	
	private long id;
	
	private String createBy;
	
	private Date createDate;
	
	private String lastUpateBy;
	
	private Date lastUpdateDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastUpateBy() {
		return lastUpateBy;
	}

	public void setLastUpateBy(String lastUpateBy) {
		this.lastUpateBy = lastUpateBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}
