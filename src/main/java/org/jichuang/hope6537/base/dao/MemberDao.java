package org.jichuang.hope6537.base.dao;

import org.jichuang.hope6537.base.model.Member;

public interface MemberDao extends BaseDao<Member> {

    public Member selectLogin(Member member);

}
