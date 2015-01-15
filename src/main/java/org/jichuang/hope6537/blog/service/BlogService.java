package org.jichuang.hope6537.blog.service;

import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.blog.model.Blog;

import java.util.List;

public interface BlogService extends BaseService<Blog> {

    int insertBlog(Blog blog, Member member, JSONObject infos);

    boolean insertBlog(Blog blog, Member member);

    List<Blog> selectBlogAllByMember(Member member);

    int updateBlog(Blog blog);
}
