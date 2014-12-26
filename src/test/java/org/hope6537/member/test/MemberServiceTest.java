package org.hope6537.member.test;

import org.hope6537.utils.SpringHelper;
import org.jichuang.hope6537.base.service.PostService;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemberServiceTest extends SpringHelper {

    public MemberServiceTest() {
        super(true);
    }

    @Test
    public void testInsertMember() {
        PostService postService = (PostService) context.getBean("postService");
        int res = postService.doQueryBySql("insert into Post_Role(roleId,postId) values (1,6)");
        System.out.println(res);
    }

    @Test
    public void testBinary() {
        String[] oldRoles = {"1", "3", "5"};
        String[] newRoles = {"1", "7"};
        Set<String> oldSet = new HashSet<String>();
        Set<String> tempSet = new HashSet<String>();
        Set<String> newSet = new HashSet<String>();
        tempSet.addAll(Arrays.asList(oldRoles));
        oldSet.addAll(Arrays.asList(oldRoles));
        newSet.addAll(Arrays.asList(newRoles));
        oldSet.removeAll(newSet);
        newSet.removeAll(tempSet);
    }


}
