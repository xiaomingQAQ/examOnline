package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;
/**
 * 提交试卷，计算分数
 * @author Junchuan.Wu
 *
 */
public class GetExamResult extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubjectService subjectService = new SubjectServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	@SuppressWarnings({ "unchecked", "static-access" })
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("studentInfo");//获取Session中的学生信息
		request.setAttribute("student",student);
		return this.SUCCESS;
	}
	
}
