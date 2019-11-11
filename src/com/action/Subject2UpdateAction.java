package com.action;

import com.entity.Subject2;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;

public class Subject2UpdateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stId;//编号
	private String stTitle;//题目
	private String stParse;//解析
	
	private SubjectService subjectService = new SubjectServiceImpl();
	
	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
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

	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception {
		Subject2 subject2 = new Subject2();
		subject2.setStID(stId);
		subject2.setStTitle(stTitle);
		subject2.setStParse(stParse);
		subjectService.updateSubject2(subject2);
		this.addActionMessage("更新成功");
		return this.SUCCESS;
	}
	
}
