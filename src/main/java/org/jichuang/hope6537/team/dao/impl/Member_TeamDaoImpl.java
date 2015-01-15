package org.jichuang.hope6537.team.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.team.dao.Member_TeamDao;
import org.jichuang.hope6537.team.model.Member_Team;
import org.jichuang.hope6537.team.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("member_teamDao")
public class Member_TeamDaoImpl extends BaseDaoImpl<Member_Team> implements Member_TeamDao {


}
