package com.dao;

import java.util.List;

import com.entity.StuAnswer;
import com.util.Page;

public interface StuansDao extends BaseDao{
	public List<StuAnswer> findAnsByPage(Page page);//根据分页查询结果;
	public int findAnsCount();
}

