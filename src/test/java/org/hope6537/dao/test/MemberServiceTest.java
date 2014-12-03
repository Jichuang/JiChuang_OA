package org.hope6537.dao.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hope6537.utils.SpringHelper;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.MemberService;
import org.junit.Test;

import static com.alibaba.fastjson.JSONObject.*;

public class MemberServiceTest extends SpringHelper {

    public MemberServiceTest() {
        super(true);
    }

    @Test
    public void testInsertMember() {
        MemberService memberService = (MemberService) context
                .getBean("memberService");
        Member member = new Member();
        member.setUsername("_test@test.com");
        member.setName("_test");
        member.setPassword("_password");
        member.setStatus("_status");
        member.setImage("admin_assets/img/photo/_test.jpg");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", "男");
        jsonObject.put("age", "20");
        jsonObject.put("phoneNumber", "18844123822");
        jsonObject.put("shortInfo", "_shortInfo");
        jsonObject.put("tags", new String[]{"java", "hadoop"});
        member.setQa(jsonObject.toJSONString());
        memberService.insertEntry(member);
    }

    @Test
    public void testSelectMember() {
        MemberService memberService = (MemberService) context
                .getBean("memberService");
        Member member = memberService.selectEntryByHQL("from Member where username = '_test@test.com'").get(0);
        String qa = member.getQa();
        JSONObject jsonObject = (JSONObject) JSONObject.parse(qa);
        System.out.println(jsonObject);
    }


}
