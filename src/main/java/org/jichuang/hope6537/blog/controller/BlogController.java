package org.jichuang.hope6537.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

	private static final String PATH = FrontPageController.PATH;

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/insertBlog")
	public String insertBlog(Model model, @PathVariable Blog blog,
			HttpServletRequest request) {
		Member member = (Member) request.getSession().getAttribute(
				"LoginedMember");
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

}
