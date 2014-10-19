package org.hope6537.dao.impl;

import java.util.List;

import org.hope6537.dao.MemberDao;
import org.hope6537.model.Member;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Member> selectEntryAll() {
		return sessionFactory.getCurrentSession().createQuery("from Member")
				.list();
	}

}
