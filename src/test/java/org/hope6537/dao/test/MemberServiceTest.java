package org.hope6537.dao.test;

import org.hope6537.utils.SpringHelper;
import org.jichuang.hope6537.base.service.MemberService;
import org.junit.Test;

public class MemberServiceTest extends SpringHelper {

	public MemberServiceTest() {
		super(true);
	}

	@Test
	public void testInsertMember() {
		MemberService memberService = (MemberService) context
				.getBean("memberService");
		memberService.selectEntryFromPrimaryKey(1);
	}

}
