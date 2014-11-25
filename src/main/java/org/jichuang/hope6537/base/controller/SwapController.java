package org.jichuang.hope6537.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class SwapController {

	@RequestMapping("/welcome")
	public String welcomePage() {
		return "admin/admin_welcome";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "admin/login";
	}

}
