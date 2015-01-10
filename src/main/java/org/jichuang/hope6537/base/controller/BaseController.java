package org.jichuang.hope6537.base.controller;

import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.base.model.Role;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.base.service.PostService;
import org.jichuang.hope6537.base.service.RoleService;
import org.jichuang.hope6537.utils.AESLocker;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.ApplicationVar;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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


    @PostConstruct
    public void initController() {
        logger.info("===========JiChuang_OA Application Init===========");
    }


    static Member MemberBaseReplace(Member oldMember, Member newMember) {
        oldMember.setName(newMember.getName());
        oldMember.setStatus(newMember.getStatus());
        oldMember.setUsername(newMember.getUsername());
        oldMember.setPassword((newMember.getPassword() == null || newMember.getPassword().isEmpty()) ?
                oldMember.getPassword() : AESLocker.Encrypt(newMember.getPassword()));
        oldMember.setPostId(newMember.getPostId());
        return oldMember;
    }

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
        //TODO:添加权限验证
        return PATH + "/base/memberconf";
    }


    @RequestMapping(value = "/member", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refreshMember(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——刷新当前用户列表");
        return refresh(request, memberService, "all");
    }

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse insertNewMember(@RequestBody Member member, HttpServletRequest request) {
        logger.info("管理员业务——添加新用户");
        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
        if (loginMember == null || member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            boolean res = memberService.insertEntry(member) > ApplicationVar.EFFECTIVE_LINE_ONE;
            res = res && memberService.updateMemberPost(member);
            return AjaxResponse.getInstanceByResult(res).addReturnMsg("添加用户成功");
        }
    }

    @RequestMapping(value = "/{memberId}/member", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse updateMember(@PathVariable String memberId, @RequestBody Member member, HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——更新新用户");
        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
        if (loginMember == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            member = MemberBaseReplace(
                    memberService.selectEntryFromPrimaryKey(Integer.parseInt(memberId)), member);
            return AjaxResponse.getInstanceByResult
                    (memberService.updateMember(member) > ApplicationVar.EFFECTIVE_LINE_ONE && memberService.updateMemberPost(member)).
                    addReturnMsg("更新用户成功");
        }
    }

    @RequestMapping(value = "/{memberId}/member", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResponse deleteMember(@PathVariable String memberId, HttpServletRequest request) {
        logger.info("管理员业务——删除新用户");
        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
        if (loginMember == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            int res = memberService.deleteEntryByPrimaryKey(Integer.parseInt(memberId));
            return AjaxResponse.getInstanceByResult(res > 0).addReturnMsg("删除用户成功");
        }
    }

    @RequestMapping(value = "/{memberId}/member", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse getMemberById(@PathVariable String memberId, HttpServletRequest request) {
        logger.info("管理员业务——查询单体用户");
        Member loginMember = (Member) request.getSession().getAttribute("loginMember");
        if (loginMember == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            Member member = memberService.selectEntryFromPrimaryKey(Integer.parseInt(memberId));
            List<Post> postList = memberService.getPostsByMember(member);
            return AjaxResponse.
                    getInstanceByResult(member != null)
                    .addAttribute("member", member)
                    .addAttribute("postList", postList);
        }
    }


    @RequestMapping("toRole")
    public String toRole() {
        //TODO:添加权限验证
        return PATH + "/base/roleconf";
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refreshRole(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——刷新当前权限列表");
        String status = request.getParameter("status");
        String hql = "all";
        if (status != null) {
            hql = "from Role where status = '正常'";
        }
        return refresh(request, roleService, hql);
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
            String type = request.getParameter("addNewRoleType");
            int res = roleService.insertRole(des, type);
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
            role.setType(request.getParameter("type"));
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
        //TODO:添加权限验证
        return PATH + "/base/postconf";
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refreshPost(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——刷新当前职务列表");
        return refresh(request, postService, "all");
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse insertNewPost(HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——添加新职位");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            String des = request.getParameter("addNewPostDes");
            String[] type = request.getParameter("addNewPostRoles").split(",");
            int postId = postService.insertPost(des, true);
            return AjaxResponse.getInstanceByResult(postService.updateRoles4PostById(type, postId + "")).addReturnMsg("添加职位成功");
        }

    }

    @RequestMapping(value = "/{postId}/post", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse selectPostById(@PathVariable String postId, HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——查询单体职位");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null || postId == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            Post post = postService.selectEntryFromPrimaryKey(Integer.parseInt(postId));
            List<Role> roleList = postService.selectRolesByPostId(postId);
            return AjaxResponse.getInstanceByResult(post != null)
                    .addAttribute("post", post)
                    .addAttribute("roleList", roleList);
        }

    }


    @RequestMapping(value = "/{postId}/post", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse updatePostById(@PathVariable String postId, HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——更新单体职位");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null || postId == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            Post post = postService.selectEntryFromPrimaryKey(Integer.parseInt(postId));
            post.setDes(request.getParameter("des"));
            post.setStatus(request.getParameter("status"));
            String[] oldRoles = request.getParameter("postRoleIds").split(",");
            String[] newRoles = request.getParameter("roleList").split(",");
            //本体更新完了，接下来更新权限集合
            return AjaxResponse.getInstanceByResult(postService.updateRoles4PostById(post, oldRoles, newRoles, postId)).addReturnMsg("更新权限成功");
        }
    }


    @RequestMapping(value = "/{postId}/post", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResponse deletePostById(@PathVariable String postId, HttpServletRequest request) throws MemberException {
        logger.info("管理员业务——删除单体职位");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null || postId == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            boolean res = postService.deletePostRoles(postId);
            res = res && postService.deleteEntryByPrimaryKey(Integer.parseInt(postId)) > ApplicationVar.EFFECTIVE_LINE_ONE;
            return AjaxResponse.getInstanceByResult(res);
        }
    }

}
