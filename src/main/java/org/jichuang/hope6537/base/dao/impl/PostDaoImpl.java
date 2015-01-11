package org.jichuang.hope6537.base.dao.impl;

import org.jichuang.hope6537.base.dao.PostDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.utils.ApplicationVar;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

    @Override
    public List<Post> getPostsByMember(Member member) {
        String hql = "SELECT p.* FROM post p , member_post mp WHERE mp.postId = p.postId AND mp.memberId = " + member.getMemberId();
        List<Post> postList = this.selectEntryBySQL(hql);
        return postList;
    }

    /**
     * 思路很清晰 求出交集 old的非交集部分删掉 new的非交集部分添加
     *
     * @param post
     * @param oldRoles
     * @param newRoles
     * @param postId
     * @return
     */
    @Override
    public boolean updateRoles4PostById(Post post, String[] oldRoles, String[] newRoles, String postId) {
        int updateRes = this.updateEntryByObject(post);
        Set<String> oldSet = new HashSet<String>();
        Set<String> tempSet = new HashSet<String>();
        Set<String> newSet = new HashSet<String>();
        tempSet.addAll(Arrays.asList(oldRoles));
        oldSet.addAll(Arrays.asList(oldRoles));
        newSet.addAll(Arrays.asList(newRoles));
        oldSet.removeAll(newSet);
        newSet.removeAll(tempSet);
        int deleteRes = 0;
        if (!oldSet.isEmpty()) {
            StringBuffer deleteQuery = new StringBuffer()
                    .append("delete from Post_Role where ")
                    .append(" postId =")
                    .append(postId)
                    .append(" and (");

            int index = 0;
            for (String roleId : oldSet) {
                index++;
                deleteQuery
                        .append("roleId")
                        .append(" = ")
                        .append(roleId);
                if (index < oldSet.size()) {
                    deleteQuery.append(" OR ");
                }
            }
            deleteQuery.append(")");
            deleteRes = this.doQueryBySql(deleteQuery.toString());
        }
        int insertRes = 0;
        if (!newSet.isEmpty()) {
            StringBuffer insertQuery = new StringBuffer().append("insert into Post_Role (postId,roleId) values ");
            int index = 0;
            for (String roleId : newSet) {
                index++;
                insertQuery.append("(").append(postId).append(",").append(roleId).append(")");
                if (index < newSet.size()) {
                    insertQuery.append(",");
                }
            }
            insertRes = this.doQueryBySql(insertQuery.toString());
        }
        return updateRes + deleteRes + insertRes >= ApplicationVar.EFFECTIVE_LINE_ONE;
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
        return res > ApplicationVar.EFFECTIVE_LINE_ZERO;
    }


    @Override
    public boolean deletePostRoles(String postId) {
        int res = doQueryBySql("delete from post_role where postId = " + postId);
        return res > ApplicationVar.EFFECTIVE_LINE_ZERO;
    }
}
