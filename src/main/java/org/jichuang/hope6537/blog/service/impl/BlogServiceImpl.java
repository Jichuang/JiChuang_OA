package org.jichuang.hope6537.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.blog.service.BlogService;
import org.jichuang.hope6537.utils.ApplicationVar;
import org.jichuang.hope6537.utils.DateFormatCalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
            blog.setDate(DateFormatCalculate.createNowTime());
            blog.setStatus("待审核");
            blog.setInfo(infos.toString());
            return super.insertEntry(blog);
        }
    }

    @Override
    public boolean insertBlog(Blog blog, Member member) {
        blog.setMemberId(member);
        blog.setDate(DateFormatCalculate.createNowTime());
        blog.setStatus("待审核");
        return super.insertEntry(blog) == ApplicationVar.EFFECTIVE_LINE_ONE;
    }

    public List<Blog> selectBlogAllByMember(Member member) {


        List<Blog> blogList = dao.selectEntryByHQL("from Blog where memberId = "
                + member.getMemberId());
        return blogList;
    }

    public int updateBlog(Blog blog) {
        if (blog == null) {
            throw new NullPointerException("博客对象为空");
        } else {
            Blog oldBlog = this.selectEntryFromPrimaryKey(blog.getBlogId());
            oldBlog.setContent(blog.getContent());
            oldBlog.setTitle(blog.getTitle());
            oldBlog.setStatus("待审核");
            oldBlog.setInfo(blog.getInfo());
            return this.updateEntryByObject(oldBlog);
        }
    }
}
