package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Subject2;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;

/**
 *  获取随机的题目
 * 
 *
 */
public class GetRandomSubjects2 extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubjectService subjectService  = new SubjectServiceImpl();
	@SuppressWarnings("static-access")
	public String execute(){
		List<Subject2> subjects2 = subjectService.randomFindSubject2(1);//获取1题
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects2", subjects2);
		return this.SUCCESS;
	}
}
