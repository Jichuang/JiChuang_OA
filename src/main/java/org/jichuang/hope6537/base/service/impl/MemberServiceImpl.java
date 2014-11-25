package org.jichuang.hope6537.base.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<Member> implements
		MemberService {
	@Autowired
	@Qualifier(value = "memberDao")
	@Override
	public void setDao(BaseDao<Member> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
