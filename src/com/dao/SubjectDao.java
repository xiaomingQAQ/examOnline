package com.dao;

import java.util.List;

import com.entity.Subject;
import com.entity.Subject2;
import com.util.Page;

public interface SubjectDao extends BaseDao{
	//根据标题找到题目
	public Subject findSubjectByTitle(String title);
	public Subject2 findSubjectByTitle2(String title);
	//分页查询试题
	public List<Subject> findSubjectsByPage(Page page);
	public List<Subject2> findSubjects2ByPage(Page page);
	//查询试题总量
	public int findSubjectCount();
	public int findSubject2Count();
	//根据id查询试题
	public Subject findSubjectByID(int id);
	public Subject2 findSubject2ByID(int id);
	//根据试题ID删除试题
	public void deleteByID(int id);
	public void deleteByID2(int id);
	//根据试题标题**模糊查询**试题
	public List<Subject> likeQueryByTitle(String title,Page page);
	public List<Subject2> likeQueryByTitle2(String title,Page page);
	//模糊查询的记录数
	public int findLikeQueryCount(String title);
	public int findLikeQueryCount2(String title);
	//随机取出试题
	public List<Subject> randomFindSubjects(int number);
	public List<Subject2> randomFindSubjects2(int number);
}
