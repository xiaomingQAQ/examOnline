package com.action;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;

public class giveGradeBefore extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentId;
	private StudentService studentService = new StudentServiceImpl();
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception {
		Student student = studentService.getStudentInfo(studentId);
		ServletActionContext.getRequest().setAttribute("student",student);
		return this.SUCCESS;
	}
	
}
