package com.service;

import java.util.List;
import com.entity.Subject2;
import com.entity.Student;
import com.util.Page;
import com.util.PageResult;

public interface StudentService {
	//判断是否为合法学生，决定是否登录
	public boolean allowLogin(String studentID,String password);
	//获得学生的信息 单个
	public Student getStudentInfo(String studentID);
	public Student getStudentInfoBysysid(int sysid);
	//设置学生成绩
	public void setStudentResult(String studentID,int result);
	//保存学生答案
	public void saveStudentAns(String answer,String studentID,Subject2 subject2);
	//根据学生的姓名查找信息
	public List<Student> getStudentByName(String studentName);
	//根据班级查找学生
	public PageResult getStudentByClass(String sclass,Page page);
	//保存一个学生记录
	public void saveStudent(Student student);
	//根据分页查询学生记录
	public PageResult queryStudentByPage(Page page);
	//根据分页查询学生简答题答案
	public PageResult queryAnsByPage(Page page);
	//获取学生数量
	public int countStudent();
	public int countStudentByClass(String sclass);
	public int countAnswers();
}
