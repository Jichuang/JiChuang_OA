package org.jichuang.hope6537.base.controller;

import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/frontpage")
@Scope(value = "prototype")
public class FrontPageController {
    public static final String PATH = "frontend/";
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/aboutus"/* , method = RequestMethod.GET */)
    public String toAboutUs(HttpServletRequest request) {
        return PATH + "/aboutus";
    }

    @RequestMapping("/blog")
    public String toBlog(HttpServletRequest request) {
        List<Blog> blogList = blogService.selectEntryAll();
        request.setAttribute("blogList", blogList);
        return PATH + "/blog";
    }

    @RequestMapping("/contact")
    public String toContact(HttpServletRequest request) {
        return PATH + "/contact";
    }

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request) {
        return PATH + "/index";
    }

    @RequestMapping("/single")
    public String toSingle(HttpServletRequest request) {
        return PATH + "/single";
    }

    @RequestMapping("/project")
    public String toProject(HttpServletRequest request) {
        return PATH + "/project";
    }

    @RequestMapping("/register")
    public String toRegister(HttpServletRequest request) {
        return PATH + "/register";
    }

    @RequestMapping("/admin")
    public String toAdmin(HttpServletRequest request) {
        return PATH + "/admin";
    }

    @RequestMapping("/{blogId}/blogitem")
    public String toBlogItem(@PathVariable String blogId, HttpServletRequest request) {
        request.setAttribute("blogItemId", blogId);
        return PATH + "/blogitem";
    }


}
