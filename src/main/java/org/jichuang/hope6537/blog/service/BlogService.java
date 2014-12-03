package org.jichuang.hope6537.blog.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.blog.model.Blog;
import org.springframework.stereotype.Service;

public interface BlogService extends BaseService<Blog> {

    /**
     * <p>Describe: 添加博客</p>
     * <p>DevelopedTime: 2014年11月26日下午4:07:39 </p>
     * <p>Author:Hope6537</p>
     *
     * @param blog
     * @param member
     * @return
     * @see
     */
    int insertBlog(Blog blog, Member member, JSONObject infos);

    List<Blog> selectBlogAllByMember(Member member);

    int updateBlog(Blog blog, JSONObject infos);
}
