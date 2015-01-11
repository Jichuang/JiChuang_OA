package org.jichuang.hope6537.base.service;

import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Post;

import java.util.List;

public interface MemberService extends BaseService<Member> {

    boolean insertRegister(Member member);

    public Member selectLogin(Member member);
    int updateMember(Member member);

    int updatePassword(Member member);

    List<Post> getPostsByMember(Member member);

    boolean updateMemberPost(Member member);

    @Override
    int insertEntry(Member member);
}
