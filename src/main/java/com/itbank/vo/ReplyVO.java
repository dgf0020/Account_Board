package com.itbank.vo;

import java.sql.Timestamp;

/*
	reply 테이블)
	IDX      NOT NULL NUMBER       
	B_IDX    NOT NULL NUMBER       
	A_IDX    NOT NULL NUMBER       
	CONTENTS          CLOB         
	W_DATE            TIMESTAMP(6) 
	
	reply_view 뷰)
	NICK     NOT NULL VARCHAR2(60) 
 */

public class ReplyVO {
	private int idx, b_idx, a_idx;
	private String contents, nick;
	private Timestamp w_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
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
	public Timestamp getW_date() {
		return w_date;
	}
	public void setW_date(Timestamp w_date) {
		this.w_date = w_date;
	}
}
