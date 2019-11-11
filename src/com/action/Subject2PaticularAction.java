package com.action;

import org.apache.struts2.ServletActionContext;

import com.entity.Subject2;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SubjectService;
import com.service.SubjectServiceImpl;
/**
 * 查看试题的详细信息
 * @author Administrator
 *
 */
public class Subject2PaticularAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stId;
	private SubjectService subjectService = new SubjectServiceImpl();
	
	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception {
		Subject2 subject2 = subjectService.showSubject2Detail(stId);
		ServletActionContext.getRequest().setAttribute("subject2", subject2);
		return this.SUCCESS;
	}
	
}
