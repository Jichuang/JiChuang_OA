package org.jichuang.hope6537.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.utils.AESLocker;
import org.jichuang.hope6537.utils.DateFormat_Jisuan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memberAction")
public class MemberActionController {

	@Autowired
	private MemberService memberService;
	private Logger logger = Logger.getLogger(getClass());

	/**
	 * <p>Describe: 用户注册控制器</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月15日下午1:44:09 </p>
	 * <p>Author:Hope6537</p>
	 * @param model 模型驱动
	 * @param member 实体类
	 * @param request request请求
	 * @return 最后返回的是URL
	 * @see
	 */
	@RequestMapping("/SIGNUP")
	public String signUp(Model model, @ModelAttribute Member member,
			HttpServletRequest request) {
		logger.info("进入用户注册业务");
		String sex = (String) request.getParameter("sex");
		String phonenumber = (String) request.getParameter("phone");
		String country = (String) request.getParameter("country");
		Map<String, String> info = new HashMap<String, String>();
		info.put("phonenumber", phonenumber);
		info.put("sex", sex);
		info.put("country", country);
		member.setMdate(DateFormat_Jisuan.createNowTime());
		member.setMqa(info.toString());
		member.setMstatus("未认证");
		member.setMpassword(AESLocker.Encrypt(member.getMpassword()));
		logger.info(member.toString());
		memberService.insertEntry(member);
		logger.info(member.getMname() + "已成功注册");
		return "WEB-INF/jsp/login";
	}
}
