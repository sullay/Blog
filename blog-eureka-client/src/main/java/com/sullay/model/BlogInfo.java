package com.sullay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BlogInfo {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique=true,nullable=false)
	private String title;
	@Column(columnDefinition="TEXT")
	private String html;
	private Date date;
	private String author;
	private String introduction;
	private String label;
	@ManyToOne
	@JoinColumn(name="Sid")
	private Special special;
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
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Special getSpecial() {
		return special;
	}
	public void setSpecial(Special special) {
		this.special = special;
	}
	@Override
	public String toString() {
		return "BlogInfo [title=" + title + ", html=" + html + ", date=" + date + ", author=" + author
				+ ", introduction=" + introduction + ", label=" + label + ", special=" + special + "]";
	}
	
	
}
