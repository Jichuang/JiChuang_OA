package org.jichuang.hope6537.base.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.utils.AESLocker;
import org.jichuang.hope6537.utils.DateFormat_Jisuan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Scope("prototype")
public class MemberController {

	@Autowired
	private MemberService memberService;
	private Logger logger = Logger.getLogger(getClass());
	private static final String PATH = AdminPageController.PATH;

	/**
	 * <p>Describe: 用户注册控制器</p>
	 * <p>DevelopedTime: 2014年10月15日下午1:44:09 </p>
	 * <p>Author:Hope6537</p>
	 * @param model 模型驱动
	 * @param member 实体类
	 * @param request request请求
	 * @return 最后返回的是URL
	 * @throws MemberException 
	 * @see
	 */
	@RequestMapping("/register")
	public String memberRegister(Model model, @ModelAttribute Member member,
			HttpServletRequest request) throws MemberException {
		logger.info("进入用户注册业务");
		String sex = (String) request.getParameter("sex");
		String phonenumber = (String) request.getParameter("phone");
		String country = (String) request.getParameter("country");
		Map<String, String> infos = new HashMap<String, String>();
		infos.put("phonenumber", phonenumber);
		infos.put("sex", sex);
		infos.put("country", country);
		logger.info(member.toString());
		int res = memberService.insertRegisterService(member, infos);
		request.setAttribute("insertRes", res);
		logger.info(member.getName() + "已成功注册");
		return PATH + "login";
	}

	/**
	 * <p>Describe: 用户登录控制器</p>
	 * <p>DevelopedTime: 2014年11月26日下午5:10:27 </p>
	 * <p>Author:Hope6537</p>
	 * @param model
	 * @param member
	 * @param request
	 * @return
	 * @throws MemberException
	 * @throws IOException 
	 * @see
	 */
	@RequestMapping("/login")
	public void memberLogin(Model model, @ModelAttribute Member member,
			HttpServletRequest request, HttpServletResponse response)
			throws MemberException, IOException {
		logger.info("进入用户登录业务");
		Member loginMember = memberService.selectLoginService(member);
		if (loginMember == null) {
			response.sendRedirect("../page/login.hopedo");
		} else {
			request.getSession().setAttribute("loginMember", loginMember);
			response.sendRedirect("../page/index.hopedo");
		}
	}
}
