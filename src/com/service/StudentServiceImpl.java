package com.service;

import java.util.List;
import com.dao.StuansDao;
import com.dao.StuansDaoImpl;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;
import com.entity.Subject2;
import com.entity.StuAnswer;
import com.util.MD5;
import com.util.Page;
import com.util.PageResult;
import com.util.PageUtil;

public class StudentServiceImpl implements StudentService{
	private StudentDao studentDao = new StudentDaoImpl();
	private StuansDao stuansDao = new StuansDaoImpl();
	/**
	 * 判断学生是否符合登录条件
	 */
	@Override
	public boolean allowLogin(String studentID, String password) {
		password = MD5.Encrypt(password);
		Student student = studentDao.findByStudenID(studentID);//根据ID查找学生的记录
		if(student==null){//如果找不到的话就返回false
			return false;
		}else {
			if(password.equals(student.getPassword())){//如果传入的密码和学生的密码一致的话，就返回true
				return true;
			}else {
				return false;
			}
		}
	}
	/**
	 * 根据学生的班级返回结果
	 */
	@Override
	public PageResult getStudentByClass(String sclass,Page page){
		page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());
		List<Student> list = studentDao.findStudentsByClass(sclass,page);//TODO:
		PageResult result = new PageResult(page, list);
		return result;
	}
	/**
	 * 根据学生姓名返回结果
	 */
	@Override
	public List<Student> getStudentByName(String studentName) {
		return studentDao.findByStudentName(studentName);
	}
	/**
	 * 根据id返回
	 */
	@Override
	public Student getStudentInfo(String studentID) {
		return studentDao.findByStudenID(studentID);
	}
	public Student getStudentInfoBysysid(int sysid) {
		return studentDao.findBysysid(sysid);
	}
	/**
	 * 根据学生id更新学生成绩
	 */
	@Override
	public void setStudentResult(String studentID, int result) {
		Student student = studentDao.findByStudenID(studentID);
		student.setResult(result);
		studentDao.updateStudent(student);
	}
	public void saveStudentAns(String answer,String studentID,Subject2 subject2)
	{
		StuAnswer stuans = new StuAnswer();
		stuans.setStID(subject2.getStID());
		stuans.setStParse(subject2.getStParse());
		stuans.setStTitle(subject2.getStTitle());
		stuans.setStudentID(studentID);
		stuans.setStuAns(answer);
		stuansDao.save(stuans);
	}
	/**
	 * 保存一条学生记录
	 */
	@Override
	public void saveStudent(Student student) {
		studentDao.save(student);
	}
	/**
	 * 根据分页  查找学生
	 */
	@Override
	public PageResult queryStudentByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());
		List<Student> list = studentDao.findStudentsByPage(page);
		PageResult result = new PageResult(page, list);
		return result;
	}
	public PageResult queryAnsByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());
		List<StuAnswer> list = stuansDao.findAnsByPage(page);
		PageResult result = new PageResult(page, list);
		return result;
	}
	/**
	 * 获取学生数量
	 */
	@Override
	public int countStudent() {
		return studentDao.fintStudentCount();
	}
	public int countAnswers() {
		return stuansDao.findAnsCount();
	}
	/**
	 * 返回班级学生数量
	 */
	@Override
	public int countStudentByClass(String sclass) {
		return studentDao.fintStudentCountByClass(sclass);
	}
	
}
