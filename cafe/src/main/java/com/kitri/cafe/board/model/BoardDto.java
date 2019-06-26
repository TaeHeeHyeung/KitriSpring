package com.kitri.cafe.board.model;

import java.util.List;
import java.util.Map;

import oracle.sql.CLOB;
import oracle.sql.DATE;

public class BoardDto {
	private int seq;
	private String name;
	private String id;
	private String email;
	private String subject;
	private String content;
	private int hit;
	private String logtime;
	private int bcode;
	
	@Override
	public String toString() {
		return "BoardDto [seq=" + seq + ", name=" + name + ", id=" + id + ", email=" + email + ", subject=" + subject
				+ ", content=" + content + ", hit=" + hit + ", logtime=" + logtime + ", bcode=" + bcode + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	
	
	
}
