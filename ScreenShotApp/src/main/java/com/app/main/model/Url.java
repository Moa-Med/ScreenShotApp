package com.app.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tables")
public class Url {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id")
  private long id;
	
  private String urls;
  private String filename;
  
  public Url() {
		
	} 
  
public Url(String urls, String filename) {
	this.urls = urls;
	this.filename = filename;
}

public Url(long id, String urls, String filename) {
	super();
	this.id = id;
	this.urls = urls;
	this.filename = filename;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUrls() {
	return urls;
}
public void setUrls(String urls) {
	
	this.urls = urls;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
  
  


}
