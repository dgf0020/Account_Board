package com.itbank.vo;

import java.sql.Timestamp;

/*
	테이블)
	IDX      NOT NULL NUMBER        
	TITLE             VARCHAR2(100) 
	CONTENTS          CLOB          
	A_IDX             NUMBER        
	V_COUNT           NUMBER        
	W_DATE            TIMESTAMP(6)
	  
	뷰)
	NICK     NOT NULL VARCHAR2(60)  
	USERID   NOT NULL VARCHAR2(20)  
 */

public class BoardVO {
	private int idx, a_idx, v_count;
	private String title, contents, nick, userid;
	private Timestamp w_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}
	public int getV_count() {
		return v_count;
	}
	public void setV_count(int v_count) {
		this.v_count = v_count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Timestamp getW_date() {
		return w_date;
	}
	public void setW_date(Timestamp w_date) {
		this.w_date = w_date;
	}
}
