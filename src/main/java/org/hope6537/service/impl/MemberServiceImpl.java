package org.hope6537.service.impl;

import org.hope6537.dao.BaseDao;
import org.hope6537.model.Member;
import org.hope6537.service.MemberService;
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
