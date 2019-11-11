package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;


import com.entity.StuAnswer;
import com.util.HibernateSessionFactory;
import com.util.Page;

public class StuansDaoImpl extends BaseDaoImpl implements StuansDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<StuAnswer> findAnsByPage(Page page) {
		String hql = "from StuAnswer";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());//每页显示的数量
		query.setFirstResult(page.getBeginIndex());//起始位置
		List<StuAnswer> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int findAnsCount() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from StuAnswer");
		List<StuAnswer> list = query.list();
		int count = list.size();
		HibernateSessionFactory.closeSession();
		return count;
	}
}
