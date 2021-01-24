package com.harvey.human.base;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseModel implements Serializable{
	private static final long serialVersionUID = 3412892042404117456L;
	
	private long id;
	
	private String createBy;
	
	private Date createDate;
	
	private String lastUpateBy;
	
	private Date lastUpdateDate;
}
