package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.StuAnswer;
import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.util.Page;
import com.util.PageResult;
import com.util.PageUtil;

public class judgeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;//当前页
	private int everyPage =10;//每一页记录
	private StudentService studentService = new StudentServiceImpl();
	private int totalCount = studentService.countAnswers();
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	/**
	 * 获取所有学生答案
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public String execute() throws Exception {
		Page page = new Page();
		page = PageUtil.createPage(everyPage, totalCount, currentPage);//获取分页信息
		PageResult pageResult = studentService.queryAnsByPage(page);
		List<StuAnswer> stuans = pageResult.getList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("stuans", stuans);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}
}
