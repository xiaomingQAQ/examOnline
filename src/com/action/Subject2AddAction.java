package com.action;

import com.entity.Subject2;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;

public class Subject2AddAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String stTitle;
	private String stOptionA;
	private String stOptionB;
	private String stOptionC;
	private String stOptionD;
	private String stAnswer;
	private String stParse;
	private SubjectService subjectService = new SubjectServiceImpl();
	public String getStTitle() {
		return stTitle;
	}
	public void setStTitle(String stTitle) {
		this.stTitle = stTitle;
	}
	public String getStOptionA() {
		return stOptionA;
	}
	public void setStOptionA(String stOptionA) {
		stOptionA=null;
		this.stOptionA = stOptionA;
	}
	public String getStOptionB() {
		stOptionB=null;
		return stOptionB;
	}
	public void setStOptionB(String stOptionB) {
		this.stOptionB = stOptionB;
	}
	public String getStOptionC() {
		stOptionC=null;
		return stOptionC;
	}
	public void setStOptionC(String stOptionC) {
		this.stOptionC = stOptionC;
	}
	public String getStOptionD() {
		stOptionD=null;
		return stOptionD;
	}
	public void setStOptionD(String stOptionD) {
		this.stOptionD = stOptionD;
	}
	public String getStAnswer() {
		stAnswer=null;
		return stAnswer;
	}
	public void setStAnswer(String stAnswer) {
		this.stAnswer = stAnswer;
	}
	public String getStParse() {
		return stParse;
	}
	public void setStParse(String stParse) {
		this.stParse = stParse;
	}
	@SuppressWarnings("static-access")
	public String execute() throws Exception{
		Subject2 subject2 = new Subject2();
		subject2.setStTitle(stTitle);
		subject2.setStOptionA(stOptionA);
		subject2.setStOptionB(stOptionB);
		subject2.setStOptionC(stOptionC);
		subject2.setStOptionD(stOptionD);
		subject2.setStAnswer(stAnswer);
		subject2.setStParse(stParse);
		if(subjectService.saveSubject2(subject2)){
			return this.SUCCESS;
		}else{
			this.addActionError("试题重复，不要重复添加");
			return this.ERROR;
		}
	}
}
