package org.hope6537.dao.impl;

import org.hope6537.dao.MemberDao;
import org.hope6537.model.Member;
import org.springframework.stereotype.Repository;
@Repository("memberDao")
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao {

}
