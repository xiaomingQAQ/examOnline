package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.entity.Subject2;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;
/**
 * 提交试卷
 *
 */
public class SubmitExamAction2 extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stID;//考试的题目id
	private SubjectService subjectService = new SubjectServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	public int getStID() {
		return stID;
	}
	public void setStID(int stID) {
		this.stID = stID;
	}
	@SuppressWarnings({ "unchecked", "static-access" })
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String stuanswer = request.getParameter("answer");
		Map session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("studentInfo");//获取Session中的学生信息
		Subject2 subject2 = subjectService.showSubject2Detail(stID);
		String studentID = student.getStudentID();
		studentService.saveStudentAns(stuanswer,studentID,subject2);//把回答保存到数据库中
		request.setAttribute("studentName",student.getStudentName());
		return this.SUCCESS;
	}
	
}
