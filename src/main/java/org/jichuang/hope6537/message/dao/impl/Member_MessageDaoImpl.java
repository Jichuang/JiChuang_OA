package org.jichuang.hope6537.message.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.message.dao.Member_MessageDao;
import org.jichuang.hope6537.message.model.Member_Message;
import org.springframework.stereotype.Repository;

@Repository("member_MessageDao")
public class Member_MessageDaoImpl extends BaseDaoImpl<Member_Message> implements Member_MessageDao {
}
