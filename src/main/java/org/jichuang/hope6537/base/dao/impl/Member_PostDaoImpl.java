package org.jichuang.hope6537.base.dao.impl;

import com.alibaba.fastjson.JSONArray;
import org.jichuang.hope6537.base.dao.Member_PostDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Member_Post;
import org.jichuang.hope6537.utils.ApplicationConstant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("member_PostDao")
public class Member_PostDaoImpl extends BaseDaoImpl<Member_Post> implements Member_PostDao {

    @Override
    public boolean updateMemberPost(Member member) {
        if (member == null || member.getPostId() == null) {
            return false;
        } else {
            int res = 0;
            List<Member_Post> getPostIds = this.selectEntryByHQL("from Member_Post where memberId = " + member.getMemberId());
            if (!(getPostIds == null || getPostIds.isEmpty())) {
                String sql = "delete from Member_Post where memberId = " + member.getMemberId();
                res += this.doQueryBySql(sql);
            }
            if (member.getPostId() != null && !member.getPostId().equals("null")) {
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
                res += this.doQueryBySql(sql2.toString());
            }
            return res >= ApplicationConstant.EFFECTIVE_LINE_ZERO ? true : false;
        }

    }
}
