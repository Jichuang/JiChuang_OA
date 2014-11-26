package org.jichuang.hope6537.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class AdminPageController {

	public static final String PATH = "admin/";

	@RequestMapping("/index")
	public String toIndex() {
		return PATH + "/index";
	}

	@RequestMapping("/login")
	public String toLogin() {
		return PATH + "/login";
	}

	@RequestMapping("/blog")
	public String toBlog() {
		return PATH + "/blog/conf";
	}

}
