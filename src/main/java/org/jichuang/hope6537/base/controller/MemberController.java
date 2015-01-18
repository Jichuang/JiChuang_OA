package org.jichuang.hope6537.base.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.ApplicationConstant;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/member")
@Scope("prototype")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private Logger logger = Logger.getLogger(getClass());
    private static final String PATH = AdminPageController.PATH;

    public void afterLoginService(HttpServletRequest request, Member member) {
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse registerMember(@RequestBody Member member, HttpServletRequest request) {
        logger.info("进入用户注册业务");
        return AjaxResponse.getInstanceByResult(memberService.insertRegister(member));
    }

    @RequestMapping("/login")
    @ResponseBody
    public AjaxResponse loginMember(@RequestBody Member member, HttpServletRequest request) {
        logger.info("进入用户登录业务");
        Member isLogin = memberService.selectLogin(member);
        if (ApplicationConstant.notNull(isLogin)) {
            afterLoginService(request, isLogin);
        }
        return AjaxResponse.getInstanceByResult(ApplicationConstant.notNull(isLogin));

    }

    @RequestMapping("/logout")
    public void memberLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("进入用户登出业务");
        request.getSession().setAttribute("loginMember", null);
        response.sendRedirect("../page/login.hopedo?r=logout");
    }

    @RequestMapping("/refresh")
    @ResponseBody
    public AjaxResponse memberRefresh(HttpServletRequest request, HttpServletResponse response) {
        Member oldMember = (Member) request.getSession().getAttribute("loginMember");
        if (ApplicationConstant.notNull(oldMember)) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            oldMember = this.memberService.selectEntryFromPrimaryKey(oldMember.getMemberId());
            request.getSession().setAttribute("loginMember", oldMember);
            return AjaxResponse.getInstanceByResult(oldMember != null).addReturnMsg("用户信息刷新成功");
        }
    }


    @RequestMapping("{memberId}/toUpdate")
    public String toUpdate(@PathVariable String memberId, HttpServletRequest request, HttpServletResponse response) throws IOException, MemberException {
        Member member = (Member) request.getSession().getAttribute("loginMember");
        if (ApplicationConstant.notNull(member)) {
            response.sendRedirect("../page/login.hopedo");
            return null;
        } else {
            request.setAttribute("memberId", memberId);
            request.setAttribute("isEdit", "1");
            return PATH + "/member/conf";
        }
    }

    @RequestMapping("{memberId}/toShow")
    public String toShow(@PathVariable String memberId, HttpServletRequest request, HttpServletResponse response) throws IOException, MemberException {
        Member member = (Member) request.getSession().getAttribute("loginMember");
        if (ApplicationConstant.notNull(member)) {
            response.sendRedirect("../page/login.hopedo");
            return null;
        } else {
            request.setAttribute("memberId", memberId);
            request.setAttribute("isEdit", "0");
            return PATH + "/member/conf";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{memberId}")
    @ResponseBody
    public AjaxResponse refresh(@PathVariable String memberId) {
        Logger.getLogger(getClass()).info("进入用户刷新");
        if (ApplicationConstant.notNull(memberId)) {
            logger.error("没有ID");
            return new AjaxResponse(ReturnState.ERROR, "没有匹配的ID");
        } else {
            logger.info("即将获取ID为" + memberId + "的用户");
            Member ajaxMember = memberService.selectEntryFromPrimaryKey(Integer.parseInt(memberId));
            if (ApplicationConstant.notNull(ajaxMember)) {
                return new AjaxResponse(ReturnState.ERROR, "没有匹配的用户");
            } else {
                AjaxResponse ajaxResponse = AjaxResponse.getInstanceByResult(true);
                ajaxResponse.addAttribute("ajaxMember", ajaxMember);
                ajaxResponse.addAttribute("ajaxInfos", ajaxMember.getQa());
                ajaxResponse.setReturnMsg("用户数据获取成功");
                return ajaxResponse;
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{memberName}")
    @ResponseBody
    public AjaxResponse refreshByMemberName(@PathVariable String memberName) {
        Logger.getLogger(getClass()).info("进入用户刷新");
        if (ApplicationConstant.notNull(memberName)) {
            logger.error("沒有Name");
            return new AjaxResponse(ReturnState.ERROR, "没有匹配的Name");
        } else {
            logger.info("即将获取Name为" + memberName + "的用户");
            List<Member> ajaxMembers = memberService.selectMemberListByName(memberName);
            return AjaxResponse.getInstanceByResult(ajaxMembers != null && !ajaxMembers.isEmpty()).addAttribute("memberList", ajaxMembers);
        }
    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse updateMember(@PathVariable String memberId, HttpServletRequest request) throws MemberException {
        logger.info("进入更新用户数据用户");
        if (ApplicationConstant.notNull(memberId)) {
            logger.info("没有ID");
            return new AjaxResponse(ReturnState.ERROR, "没有获取到ID");
        } else {
            logger.info("获取ID为" + memberId + "的用户");
            Member member = memberService.selectEntryFromPrimaryKey(Integer.parseInt(memberId));
            if (ApplicationConstant.notNull(member)) {
                return new AjaxResponse(ReturnState.ERROR, "没有匹配的用户");
            } else {
                JSONObject qa = new JSONObject();
                member.setName(request.getParameter("updateName"));
                member.setInfo(request.getParameter("updateInfo"));
                qa.put("phoneNumber", request.getParameter("updatePhoneNumber"));
                qa.put("shortInfo", request.getParameter("updateShortInfo"));
                qa.put("sex", request.getParameter("updateSex"));
                member.setQa(qa.toJSONString());
                int res = memberService.updateMember(member);
                return AjaxResponse.getInstanceByResult(res == ApplicationConstant.EFFECTIVE_LINE_ONE);
            }
        }
    }

    @RequestMapping(value = "/{memberId}/updatePassword", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse updatePassword(@PathVariable String memberId, HttpServletRequest request) throws MemberException {
        logger.info("进入更新密码");
        if (ApplicationConstant.notNull(memberId)) {
            logger.info("没有ID");
            return new AjaxResponse(ReturnState.ERROR, "没有获取到ID");
        } else {
            logger.info("获取ID为" + memberId + "的用户");
            Member member = memberService.selectEntryFromPrimaryKey(Integer.parseInt(memberId));
            if (ApplicationConstant.notNull(member)) {
                return new AjaxResponse(ReturnState.ERROR, "没有匹配的用户");
            } else {
                member.setPassword(request.getParameter("newPassword"));
                int res = memberService.updatePassword(member);
                return AjaxResponse.getInstanceByResult(res == ApplicationConstant.EFFECTIVE_LINE_ONE);
            }
        }
    }


}
