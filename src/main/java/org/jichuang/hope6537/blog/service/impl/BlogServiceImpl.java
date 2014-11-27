package org.jichuang.hope6537.blog.service.impl;

import java.util.List;
import java.util.Map;

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
		// TODO Auto-generated method stub
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
	public int insertBlog(Blog blog, Member member, Map<String, String> infos) {
		if (blog == null) {
			throw new NullPointerException("博客对象为空");
		}
		if (blog.getBlogtitle() == null || blog.getBlogtitle().isEmpty()) {
			throw new NullPointerException("博客没有标题");
		}
		if (blog.getBlogcont() == null || blog.getBlogcont().isEmpty()) {
			throw new NullPointerException("博客没有内容");
		}
		if (member == null) {
			throw new NullPointerException("博客没有作者");
		} else {
			blog.setBlogmid(member);
			blog.setBlogdate(DateFormat_Jisuan.createNowTime());
			blog.setBlogstatus("待审核");
			blog.setBloginfo(infos.toString());
			super.insertEntry(blog);
		}
		return 0;
	}

	public List<Blog> selectBlogAllByMember(Member member) {
		return dao.selectEntryByHQL("from Blog where blogmid = "
				+ member.getMid());
	}
}
