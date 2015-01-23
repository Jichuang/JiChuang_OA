package org.jichuang.hope6537.base.dao.impl;

import org.jichuang.hope6537.base.dao.PostDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.utils.ApplicationConstant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

    @Override
    public List<Post> getPostsByMember(Member member) {
        String hql = "SELECT p.* FROM post p , member_post mp WHERE mp.postId = p.postId AND mp.memberId = " + member.getMemberId();
        List<Post> postList = this.selectEntryBySQL(hql);
        return postList;
    }

    /**
     * 删掉原来，添加新增
     *
     * @return
     */
    @Override
    public boolean updateRoles4PostById(Post post) {
        this.doQueryBySql("delete pr.* from post_role pr where pr.postId = " + post.getPostId());
        String[] roles = post.getRoleId().split(",");
        StringBuilder insertSql = new StringBuilder().append("insert into post_role (postId , roleId ) values ");
        for (int i = 0; i < roles.length; i++) {
            insertSql.append("(")
                    .append(post.getPostId())
                    .append(",")
                    .append(roles[i])
                    .append(")");
            if (i < roles.length - 1) {
                insertSql.append(",");
            }
        }
        this.doQueryBySql(insertSql.toString());
        int updateEntryRes = this.updateEntryByObject(post);
        return updateEntryRes == ApplicationConstant.EFFECTIVE_LINE_ONE;
    }

    @Override
    public boolean updateRoles4PostById(String[] roles, String postId) {
        StringBuffer hql = new StringBuffer().append("insert into Post_Role(roleId,postId) values ");
        int index = 0;
        for (String roleId : roles) {
            index++;
            hql.append("(" + roleId + "," + postId + ")");
            if (index < roles.length) {
                hql.append(",");
            }
        }
        String sql = hql.toString();
        int res = this.doQueryBySql(sql);
        return res > ApplicationConstant.EFFECTIVE_LINE_ZERO;
    }


    @Override
    public boolean deletePostRoles(String postId) {
        int res = doQueryBySql("delete from post_role where postId = " + postId);
        return res > ApplicationConstant.EFFECTIVE_LINE_ZERO;
    }
}
