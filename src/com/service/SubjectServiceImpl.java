package com.service;

import java.util.List;

import com.dao.SubjectDao;
import com.dao.SubjectDaoImpl;
import com.entity.Subject;
import com.entity.Subject2;
import com.util.Page;
import com.util.PageResult;
import com.util.PageUtil;

public class SubjectServiceImpl implements SubjectService {
	private SubjectDao subjectDao = new SubjectDaoImpl();
	/**
	 * 计算成绩
	 * @param subjectIDs 传入的试题id List
	 * @param studentAnswers 传入的学生回答 List
	 */
	@Override
	public int accountResult(List<Integer> subjectIDs,List<String> studentAnswers) {
		int score = 0;// 初始化总分为0
		for (int i = 0; i < subjectIDs.size(); i++) {
			String rightAnswer = subjectDao.findSubjectByID(subjectIDs.get(i)).getStAnswer();// 通过试题的id得到正确的答案
			if (rightAnswer.equals(studentAnswers.get(i))) {
				score += 20;
			}
		}
		return score;
	}

	/**
	 * 根据id删除Subject
	 */
	@Override
	public void deleteSubject(int subjectID) {
		subjectDao.deleteByID(subjectID);
	}
	public void deleteSubject2(int subjectID) {
		subjectDao.deleteByID2(subjectID);
	}
	/**
	 * 模糊查询试题，并且返回分页信息
	 */
	@Override
	public PageResult likeQueryBySubjectTitle(String subjectTitle, Page page) {
		page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());//创建分页信息
		List<Subject> list = subjectDao.likeQueryByTitle(subjectTitle, page);//通过分页信息模糊查询试题
		PageResult result = new PageResult(page, list);//封装好封页信息和记录信息，返回给调用者
		return result;
	}
	public PageResult likeQueryBySubject2Title(String subjectTitle, Page page) {
		page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());//创建分页信息
		List<Subject2> list = subjectDao.likeQueryByTitle2(subjectTitle, page);//通过分页信息模糊查询试题
		PageResult result = new PageResult(page, list);//封装好封页信息和记录信息，返回给调用者
		return result;
	}
	/**
	 * 根据分页 查询试题
	 */
	@Override
	public PageResult querySubjectByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(), page.getTotalCount(), page.getCurrentPage());
		List<Subject> list = subjectDao.findSubjectsByPage(page);
		PageResult result = new PageResult(page, list);
		return result;
	}
	public PageResult querySubject2ByPage(Page page2) {
		page2 = PageUtil.createPage(page2.getEveryPage(), page2.getTotalCount(), page2.getCurrentPage());
		List<Subject2> list2 = subjectDao.findSubjects2ByPage(page2);
		PageResult result = new PageResult(page2, list2);
		return result;
	}
	/**	
	 * 随机抽取题库
	 * @param number 即数量
	 */
	@Override
	public List<Subject> randomFindSubject(int number) {
		return subjectDao.randomFindSubjects(number);
	}
	public List<Subject2> randomFindSubject2(int number) {
		return subjectDao.randomFindSubjects2(number);
	}
	/**
	 * 添加试题，如果试题标题已经存在，就不能添加
	 */
	@Override
		public boolean saveSubject(Subject subject) {
			String title = subject.getStTitle();
			if(subjectDao.findSubjectByTitle(title)==null){
				//如果试题标题在数据库中没有找到的话，就允许添加
				subjectDao.save(subject);
				return true;
			}else{
				return false;
			}
		}
	public boolean saveSubject2(Subject2 subject2) {
		String title = subject2.getStTitle();
		if(subjectDao.findSubjectByTitle2(title)==null){
			//如果试题标题在数据库中没有找到的话，就允许添加
			subjectDao.save(subject2);
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 根据id，返回Subject对象
	 */
	@Override
	public Subject showSubjectDetail(int subjectID) {
		return subjectDao.findSubjectByID(subjectID);
	}
	/**
	 * 传入Subject对象
	 */
	@Override
	public Subject2 showSubject2Detail(int subject2ID) {
		return subjectDao.findSubject2ByID(subject2ID);
	}
	/**
	 * 传入Subject对象
	 */
	@Override
	public void updateSubject(Subject subject) {
		subjectDao.update(subject);
	}
	public void updateSubject2(Subject2 subject2) {
		subjectDao.update(subject2);
	}
	/**
	 * 获得subject数量
	 */
	@Override
	public int countSubject() {
		return subjectDao.findSubjectCount();
	}
	public int countSubject2() {
		return subjectDao.findSubject2Count();
	}
	@Override
	public int countLikeSubject(String title) {
		return subjectDao.findLikeQueryCount(title);
	}
	public int countLikeSubject2(String title) {
		return subjectDao.findLikeQueryCount2(title);
	}

}
