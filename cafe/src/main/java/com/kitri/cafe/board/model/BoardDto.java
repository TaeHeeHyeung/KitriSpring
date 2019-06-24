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
	private CLOB content;
	private int hint;
	private String logTime;
	private int bcode;
	
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
	public CLOB getContent() {
		return content;
	}
	public void setContent(CLOB content) {
		this.content = content;
	}
	public int getHint() {
		return hint;
	}
	public void setHint(int hint) {
		this.hint = hint;
	}

	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	
	
	
}
