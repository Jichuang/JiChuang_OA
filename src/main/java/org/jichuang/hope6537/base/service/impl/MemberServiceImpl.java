package org.jichuang.hope6537.base.service.impl;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    public int insertRegisterService(Member member, JSONObject infos)
            throws MemberException {
        if (member == null) {
            throw new MemberException("成员对象为空");
        }
        if (member.getPassword() == null || member.getPassword().isEmpty()) {
            throw new MemberException("成员没有密码");
        }
        if (member.getUsername() == null || member.getUsername().isEmpty()) {
            throw new MemberException("成员没有邮箱");
        }
        member.setDate(DateFormat_Jisuan.createNowTime());
        member.setQa(infos.toJSONString());
        member.setStatus("未认证");
        member.setPassword(AESLocker.Encrypt(member.getPassword()));
        super.insertEntry(member);
        return 1;
    }

    public Member selectLoginService(Member member) throws MemberException {

        if (member == null) {
            throw new MemberException("成员对象为空");
        }
        if (member.getPassword() == null || member.getPassword().isEmpty()) {
            throw new MemberException("成员没有密码");
        }
        if (member.getUsername() == null || member.getUsername().isEmpty()) {
            throw new MemberException("成员没有邮箱");
        }

        List<Member> list = super
                .selectEntryByHQL("from Member where username = '"
                        + member.getUsername() + "'");

        return list.size() > 0 ? list.get(0) : null;
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
    public int updateMember(Member member) throws MemberException {
        if (member == null) {
            throw new MemberException("成员对象为空");
        } else {
            return this.updateEntryByObject(member);
        }
    }

    @Override
    public int updatePassword(Member member) throws MemberException {
        if (member == null) {
            throw new MemberException("成员对象为空");
        } else {
            return this.updateEntryByObject(member);
        }
    }
}
