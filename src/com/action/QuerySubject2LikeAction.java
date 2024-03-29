package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Subject2;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;
import com.util.Page;
import com.util.PageResult;
import com.util.PageUtil;

@SuppressWarnings("serial")
public class QuerySubject2LikeAction extends ActionSupport{
	private String subjectTitle;//获取的试题标题
	private int currentPage;//当前页
	private int everyPage=5;//每一页记录
	private SubjectService subjectService = new SubjectServiceImpl();
	private int totalCount;//总共页
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public SubjectService getSubjectService() {
		return subjectService;
	}
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		totalCount = subjectService.countLikeSubject2(subjectTitle);
		if(currentPage>0){
			//currentPage为0时，用post传参不会出现编码不一致
			//currentPage大于0时，用get传参会出现编码不一致的情况
			subjectTitle = new String(subjectTitle.getBytes("ISO-8859-1"),"UTF-8");
		}
		request.setAttribute("subjectTitle", subjectTitle);
		Page page = new Page();
		page = PageUtil.createPage(everyPage, totalCount, currentPage);
		PageResult pageResult = subjectService.likeQueryBySubject2Title(subjectTitle, page);
		List<Subject2> subjects2 = pageResult.getList();
		List<Subject2> newSubjects2 = new ArrayList<Subject2>();
		for (Subject2 subject : subjects2) {
			String newTitle =  subject.getStTitle().replaceAll(subjectTitle, "<font color='red'>"+subjectTitle+"</font>");//关键字标红
			subject.setStTitle(newTitle);
			newSubjects2.add(subject);
		}
		page = pageResult.getPage();
		request.setAttribute("subjects2", newSubjects2);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}
	
}
