package com.entity;

public class StuAnswer {
	private int id;
	private int stID;
	private String studentID;
	private String stTitle;
	private String stParse;
	private String stuAns;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public int getStID() {
		return stID;
	}
	public void setStID(int stID) {
		this.stID = stID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStTitle() {
		return stTitle;
	}
	public void setStTitle(String stTitle) {
		this.stTitle = stTitle;
	}
	public String getStParse() {
		return stParse;
	}
	public void setStParse(String stParse) {
		this.stParse = stParse;
	}
	public String getStuAns() {
		return stuAns;
	}
	public void setStuAns(String stuAns) {
		this.stuAns = stuAns;
	}
	@Override
	public String toString() {
		return " [StuAnswer=" + "stID=" + stID + ", studentID=" + studentID
				+ ", stTitle=" + stTitle + ",stParse=" + stParse
				+ ", stuAns=" + stuAns + ", id=" + id + "]";
	}
}
