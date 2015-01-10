package org.jichuang.hope6537.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.dao.MemberDao;
import org.jichuang.hope6537.base.dao.Member_PostDao;
import org.jichuang.hope6537.base.dao.PostDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.utils.AESLocker;
import org.jichuang.hope6537.utils.ApplicationVar;
import org.jichuang.hope6537.utils.DateFormatCalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<Member> implements
        MemberService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private Member_PostDao member_postDao;
    @Autowired
    private PostDao postDao;

    public boolean insertRegister(Member member) {
        member.setDate(DateFormatCalculate.createNowTime());
        member.setStatus("未认证");
        member.setPassword(AESLocker.Encrypt(member.getPassword()));
        return memberDao.insertEntry(member) == ApplicationVar.EFFECTIVE_LINE_ONE;
    }

    @Override
    public int insertEntry(Member member) {
        member.setDate(DateFormatCalculate.createNowTime());
        member.setStatus("未认证");
        member.setPassword(AESLocker.Encrypt(member.getPassword()));
        return memberDao.insertEntry(member);
    }

    public boolean selectLogin(Member member) {
        return memberDao.selectLogin(member);
    }

    /**
     * 现有的map参数为 updateName updatePhoneNumber updateSex updateShortInfo updateInfo
     * 以后打算用JSON来显示
     *
     * @param member
     * @return
     * @throws MemberException
     */
    @Override
    public int updateMember(Member member) {
        return memberDao.updateEntryByObject(member);
    }

    @Override
    public int updatePassword(Member member) {
        return memberDao.updateEntryByObject(member);
    }

    public List<Post> getPostsByMember(Member member) {
        return postDao.getPostsByMember(member);
    }

    @Override
    public boolean updateMemberPost(Member member) {
        return member_postDao.updateMemberPost(member);
    }
}
