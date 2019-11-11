package com.action;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;
public class giveGradeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentID = "2015301500149";
	private int grade;
	private StudentService studentService = new StudentServiceImpl();
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade=grade;
	}

	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception {
		Student student = studentService.getStudentInfo(studentID);
		int result = student.getResult() + grade;
		studentService.setStudentResult(studentID, result);
		return this.SUCCESS;
	}
	
}
