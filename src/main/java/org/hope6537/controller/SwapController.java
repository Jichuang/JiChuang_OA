package org.hope6537.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swapPage")
public class SwapController {

	@RequestMapping("/welcome")
	public String welcomePage() {
		return "WEB-INF/jsp/admin_welcome";
	}

}
