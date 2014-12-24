package org.jichuang.hope6537.base.controller;

import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Role;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.base.service.PostService;
import org.jichuang.hope6537.base.service.RoleService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Zhaopeng-Rabook on 14-12-23.
 */
@Controller
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private PostService postService;
    @Autowired
    private RoleService roleService;

    public static final String PATH = AdminPageController.PATH;
    private Logger logger = Logger.getLogger(getClass());

    /**
     * 定义AjaxResponse格式的List查询返回通式
     *
     * @param request
     * @param service
     * @param <T>
     * @return
     * @throws MemberException
     * @author Hope6537
     */
    public <T> AjaxResponse refresh(HttpServletRequest request, BaseService<T> service, String hql) throws MemberException {

        String modelName = service.getClass().getSimpleName().split("Service")[0].toLowerCase();
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        }
        List<T> list;
        if (hql == null || hql.equals("all")) {
            list = service.selectEntryAll();
        } else {
            list = service.selectEntryByHQL(hql);
        }
        boolean isEnable = list != null && !list.isEmpty();
        if (!isEnable) {
            return new AjaxResponse(ReturnState.ERROR, "没有用户对象");
        } else {
            AjaxResponse ajaxResponse = AjaxResponse
                    .getInstanceByResult(isEnable);
            ajaxResponse.setReturnMsg("刷新成功");
            ajaxResponse.addAttribute(modelName + "List", list);
            return ajaxResponse;
        }
    }

    @RequestMapping("toMember")
    public String toMember() {
        return PATH + "/base/memberconf";
    }


    @RequestMapping(value = "/member", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refreshMember(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——刷新当前用户列表");
        return refresh(request, memberService, "all");
    }


    @RequestMapping("toRole")
    public String toRole() {
        return PATH + "/base/roleconf";
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refreshRole(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——刷新当前权限列表");
        return refresh(request, roleService, "all");
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse insertNewRole(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——添加新权限");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            String des = request.getParameter("addNewRoleDes");
            int res = roleService.insertRole(des);
            return AjaxResponse.getInstanceByResult(res > 0).addReturnMsg("添加权限成功");
        }

    }

    @RequestMapping(value = "/{roleId}/role", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse selectRoleById(@PathVariable String roleId, HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——查询单体权限");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null || roleId == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            Role role = roleService.selectEntryFromPrimaryKey(Integer.parseInt(roleId));
            return AjaxResponse.getInstanceByResult(role != null).addAttribute("role", role);
        }

    }

    @RequestMapping(value = "/{roleId}/role", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse updateRoleById(@PathVariable String roleId, HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——更新单体权限");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null || roleId == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            Role role = roleService.selectEntryFromPrimaryKey(Integer.parseInt(roleId));
            role.setDes(request.getParameter("des"));
            role.setStatus(request.getParameter("status"));
            int res = roleService.updateEntryByObject(role);
            return AjaxResponse.getInstanceByResult(res > 0).addReturnMsg("更新权限成功");
        }
    }

    @RequestMapping(value = "/{roleId}/role", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResponse deleteRoleById(@PathVariable String roleId, HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——删除单体权限");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null || roleId == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            int res = roleService.deleteEntryByPrimaryKey(Integer.parseInt(roleId));
            return AjaxResponse.getInstanceByResult(res > 0).addReturnMsg("删除权限成功");
        }
    }


    @RequestMapping("toPost")
    public String toPost() {
        return PATH + "/base/postconf";
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refreshPost(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——刷新当前职务列表");
        return refresh(request, postService, "all");
    }


}
