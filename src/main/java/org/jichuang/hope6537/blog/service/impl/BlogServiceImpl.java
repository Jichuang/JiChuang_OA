package org.jichuang.hope6537.blog.service.impl;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.blog.service.BlogService;
import org.jichuang.hope6537.utils.DateFormat_Jisuan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("blogService")
public class BlogServiceImpl extends BaseServiceImpl<Blog> implements
        BlogService {
    @Autowired
    @Qualifier(value = "blogDao")
    @Override
    public void setDao(BaseDao<Blog> dao) {
        super.setDao(dao);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.jichuang.hope6537.blog.service.BlogService#insertBlog(org.jichuang
     * .hope6537.blog.model.Blog, org.jichuang.hope6537.base.model.Member)
     *
     * @Change:Hope6537
     */
    public int insertBlog(Blog blog, Member member, JSONObject infos) {
        if (blog == null) {
            throw new NullPointerException("博客对象为空");
        }
        if (blog.getTitle() == null || blog.getTitle().isEmpty()) {
            throw new NullPointerException("博客没有标题");
        }
        if (blog.getContent() == null || blog.getContent().isEmpty()) {
            throw new NullPointerException("博客没有内容");
        }
        if (member == null) {
            throw new NullPointerException("博客没有作者");
        } else {
            blog.setMemberId(member);
            blog.setDate(DateFormat_Jisuan.createNowTime());
            blog.setStatus("待审核");
            blog.setInfo(infos.toString());
            return super.insertEntry(blog);
        }
    }

    public List<Blog> selectBlogAllByMember(Member member) {
        return dao.selectEntryByHQL("from Blog where memberId = "
                + member.getMemberId());
    }

    public int updateBlog(Blog blog, JSONObject infos) {
        if (blog == null) {
            throw new NullPointerException("博客对象为空");
        }
        if (blog.getTitle() == null || blog.getTitle().isEmpty()) {
            throw new NullPointerException("博客没有标题");
        }
        if (blog.getContent() == null || blog.getContent().isEmpty()) {
            throw new NullPointerException("博客没有内容");
        } else {
            Blog oldBlog = this.selectEntryFromPrimaryKey(blog.getBlogId());
            oldBlog.setContent(blog.getContent());
            oldBlog.setTitle(blog.getTitle());
            // 不设置日期
            oldBlog.setStatus("待审核");
            oldBlog.setInfo(infos.toString());
            return this.updateEntryByObject(oldBlog);
        }
    }
}
