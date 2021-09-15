package com.bitcamp.lecture.comm;

import java.util.ArrayList;
import java.util.List;


public class Notice {
	
	//필드
	public static List<Notice> list = new ArrayList<>(); //이렇게 하나만 존재하는 전역변수를 사용할 필요도 있을 것같아서 일단 만들어줌
	
	private int id = 0;
	private String title = null;
	private String writerId = null;
	private String regDate = null;
	private int hit = 0;
	
	//생성자
	public Notice() {
		
	}
	public Notice(int id, String title, String writerId, String regDate, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
	}
	
	//메소드(getter,setter)
	public static List<Notice> getList() {
		return list;
	}
	public static void setList(List<Notice> list) {
		Notice.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
