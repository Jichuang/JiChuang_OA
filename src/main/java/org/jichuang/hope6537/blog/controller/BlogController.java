package org.jichuang.hope6537.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jichuang.hope6537.base.controller.AdminPageController;
import org.jichuang.hope6537.base.controller.FrontPageController;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class BlogController {

	private static final String PATH = AdminPageController.PATH + "/blog";

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/insertBlog")
	public String insertBlog(Model model, @PathVariable Blog blog,
			HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"loginMember");
		// TODO : 在这里编写其他的信息 例如info的 然后别忘了封装
		Map<String, String> infos = new HashMap<String, String>();
		String blogType = (String) request.getAttribute("blogtype");
		String[] blogTags = (String[]) request.getAttribute("blogtags");
		infos.put("blogTags", blogTags.toString());
		infos.put("blogType", blogType);
		int res = blogService.insertBlog(blog, member, infos);
		model.addAttribute("insertRes", res);
		return PATH + "/blog";
	}

	@RequestMapping("/conf")
	public String toConf(HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"loginMember");
		List<Blog> blogList = blogService.selectBlogAllByMember(member);
		request.setAttribute("blogList", blogList);
		return PATH + "/conf";
	}

	@RequestMapping("/addBlog")
	public String toAdd() {
		return PATH + "/addBlog";
	}
}
