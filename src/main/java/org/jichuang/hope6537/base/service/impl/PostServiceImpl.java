package org.jichuang.hope6537.base.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.base.model.Role;
import org.jichuang.hope6537.base.service.PostService;
import org.jichuang.hope6537.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("postService")
public class PostServiceImpl extends BaseServiceImpl<Post> implements
        PostService {
    @Autowired
    @Qualifier(value = "postDao")
    @Override
    public void setDao(BaseDao<Post> dao) {
        super.setDao(dao);
    }

    @Autowired
    private RoleService roleService;

    //事务异常
    @Override
    public int insertPost(String des, boolean isID) {
        Post post = new Post();
        post.setDes(des);
        post.setStatus("正常");
        int res = this.insertEntry(post);
        //在这里应该对事务进行提交
        return isID ? post.getPostId() : res;
    }

    public int updateRoles4PostById(String[] roles, String postId) {
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
        return res;
    }

    @Override
    public List<Role> selectRolesByPostId(String postId) {
        String hql = "SELECT r.roleId , r.des , r.status ,r.type from Role r , Post_Role pr where pr.roleId = r.roleId and pr.postId = " + postId;
        return roleService.selectEntryByHQL(hql);
    }

    /**
     * 思路很清晰 求出交集 old的非交集部分删掉 new的非交集部分添加
     *
     * @param oldRoles
     * @param newRoles
     * @param postId
     * @return
     */
    @Override
    public int updateRoles4PostById(Post post, String[] oldRoles, String[] newRoles, String postId) {
        int updateRes = this.updateEntryByObject(post);
        int[] unionIds = new int[Math.max(oldRoles.length, newRoles.length)];
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


        return updateRes + deleteRes + insertRes;
    }

    @Override
    public int deletePostRoles(String postId) {
        int res = doQueryBySql("delete from post_role where postId = " + postId);
        return res;
    }


}
