package org.jichuang.hope6537.base.dao.impl;

import org.jichuang.hope6537.base.dao.MemberDao;
import org.jichuang.hope6537.base.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDao")
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<Member> selectEntryAll() {
        return sessionFactory.getCurrentSession().createQuery("from Member")
                .list();
    }

}
