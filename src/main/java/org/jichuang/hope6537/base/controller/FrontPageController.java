package org.jichuang.hope6537.base.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontpage")
@Scope(value = "prototype")
public class FrontPageController {

	public static final String PATH = "frontend/";

	@RequestMapping(value = "/aboutus"/* , method = RequestMethod.GET */)
	public String toAboutUs(HttpServletRequest request) {
		return PATH + "/aboutus";
	}

	@RequestMapping("/blog")
	public String toBlog(HttpServletRequest request) {
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

	@RequestMapping("/register")
	public String toRegister(HttpServletRequest request) {
		return PATH + "/register";
	}

	@RequestMapping("/admin")
	public String toAdmin(HttpServletRequest request) {
		return PATH + "/admin";
	}

}
