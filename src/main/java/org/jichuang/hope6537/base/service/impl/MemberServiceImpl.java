package org.jichuang.hope6537.base.service.impl;

import java.util.List;
import java.util.Map;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.utils.AESLocker;
import org.jichuang.hope6537.utils.DateFormat_Jisuan;
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

	public int insertRegisterService(Member member, Map<String, String> infos)
			throws MemberException {
		if (member == null) {
			throw new MemberException("成员对象为空");
		}
		if (member.getMpassword() == null || member.getMpassword().isEmpty()) {
			throw new MemberException("成员没有密码");
		}
		if (member.getMusername() == null || member.getMusername().isEmpty()) {
			throw new MemberException("成员没有邮箱");
		}
		member.setMdate(DateFormat_Jisuan.createNowTime());
		member.setMqa(infos.toString());
		member.setMstatus("未认证");
		member.setMpassword(AESLocker.Encrypt(member.getMpassword()));
		super.insertEntry(member);
		return 1;
	}

	public Member selectLoginService(Member member) throws MemberException {

		if (member == null) {
			throw new MemberException("成员对象为空");
		}
		if (member.getMpassword() == null || member.getMpassword().isEmpty()) {
			throw new MemberException("成员没有密码");
		}
		if (member.getMusername() == null || member.getMusername().isEmpty()) {
			throw new MemberException("成员没有邮箱");
		}

		List<Member> list = super.selectEntryByHQL("from Member where musername = '"
				+ member.getMusername() + "'");

		return list.size() > 0 ? list.get(0) : null;
	}
}
