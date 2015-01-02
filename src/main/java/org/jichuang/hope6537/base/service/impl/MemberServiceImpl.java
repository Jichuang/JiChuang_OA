package org.jichuang.hope6537.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.dao.Member_PostDao;
import org.jichuang.hope6537.base.dao.PostDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Member_Post;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.utils.AESLocker;
import org.jichuang.hope6537.utils.DateFormatCalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<Member> implements
        MemberService {
    @Autowired
    @Qualifier(value = "memberDao")
    @Override
    public void setDao(BaseDao<Member> dao) {
        super.setDao(dao);
    }

    @Autowired
    private Member_PostDao member_postDao;
    @Autowired
    private PostDao postDao;

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
        member.setDate(DateFormatCalculate.createNowTime());
        member.setQa(infos.toJSONString());
        member.setStatus("未认证");
        member.setPassword(AESLocker.Encrypt(member.getPassword()));
        return super.insertEntry(member);
    }


    @Override
    public int insertEntry(Member member) {
        member.setDate(DateFormatCalculate.createNowTime());
        member.setStatus("未认证");
        member.setPassword(AESLocker.Encrypt(member.getPassword()));
        return super.insertEntry(member);
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

    public List<Post> getPostsByMember(Member member) {
        String hql = "SELECT p.* FROM post p , member_post mp WHERE mp.postId = p.postId AND mp.memberId = " + member.getMemberId();
        List<Post> postList = postDao.selectEntryBySQL(hql);
        return postList;
    }

    /**
     * 业务逻辑很清晰 就是删掉再重新添加
     *
     * @param member
     * @return
     */
    @Override
    public int updateMemberPost(Member member) {
        if (member == null || member.getPostId() == null) {
            return -1;
        } else {
            int res = 0;
            List<Member_Post> getPostIds = member_postDao.selectEntryByHQL("from Member_Post where memberId = " + member.getMemberId());
            if (!(getPostIds == null || getPostIds.isEmpty())) {
                String sql = "delete from Member_Post where memberId = " + member.getMemberId();
                res += member_postDao.doQueryBySql(sql);
            }
            List<String> postIds = JSONArray.parseArray(member.getPostId(), String.class);
            StringBuffer sql2 = new StringBuffer().append("insert into Member_Post(memberId,postId) values");
            int index = 0;
            for (String postId : postIds) {
                index++;
                sql2.append("(").append(member.getMemberId()).append(",").append(postId).append(")");
                if (index < postIds.size()) {
                    sql2.append(",");
                }
            }
            res += member_postDao.doQueryBySql(sql2.toString());
            return res;
        }

    }


}
