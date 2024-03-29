package com.action;

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

public class QuerySubject2Action extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;//当前页
	private int everyPage=5;//每一页记录
	private SubjectService subjectService = new SubjectServiceImpl();
	private int totalCount = subjectService.countSubject2();//总共页
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
	public String execute() throws Exception{
		Page page2 = new Page();
		page2 = PageUtil.createPage(everyPage, totalCount, currentPage);//获取分页信息
		PageResult pageResult2 = subjectService.querySubject2ByPage(page2);
		List<Subject2> subjects2 = pageResult2.getList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects2", subjects2);
		request.setAttribute("page2", page2);
		return this.SUCCESS;
	}
}
