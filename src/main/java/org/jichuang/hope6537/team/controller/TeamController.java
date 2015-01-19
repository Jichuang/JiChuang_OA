package org.jichuang.hope6537.team.controller;

import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.controller.AdminPageController;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.team.model.Member_Team;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.team.service.TeamService;
import org.jichuang.hope6537.team.service.TeamTypeService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.ApplicationConstant;
import org.jichuang.hope6537.utils.ReturnState;
import org.jichuang.hope6537.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/team")
@Scope("prototype")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamTypeService teamTypeService;
    private Logger logger = Logger.getLogger(getClass());
    private static final String PATH = AdminPageController.PATH;

    @RequestMapping("/conf")
    public String toTeam() {
        logger.info("项目组业务——进入项目组维护页面");
        return PATH + "/team/conf";
    }

    @RequestMapping("/toAddTeam")
    public String toAddTeam() {
        logger.info("项目组业务——进入添加项目组");
        return PATH + "/team/addTeam";
    }

    @RequestMapping("/{teamId}/toUpdateTeam")
    public String toUpdateTeam(@PathVariable String teamId, HttpServletRequest request) {
        logger.info("项目组业务——根据ID进入项目组修改页面");
        request.setAttribute("isEdit", 1);
        request.setAttribute("teamId", teamId);
        return PATH + "/team/addTeam";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFront")
    @ResponseBody
    public AjaxResponse getTeamListByFront() {
        logger.info("项目组业务——前台查询所有的项目组");
        List<Team> list = teamService.selectTeamListByStatus(Status.正常);
        return AjaxResponse.getInstanceByResult(list != null).addAttribute("teamList", list);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse updateTeamById(@RequestBody Team team, HttpServletRequest request) {
        logger.info("项目组业务——更新当前单体项目组");
        Member member = (Member) request.getSession().getAttribute("loginMember");
        if (team == null) {
            return new AjaxResponse(ReturnState.ERROR, "没有对应的項目組");
        } else if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            int res = teamService.updateTeam(team, member);
            logger.info("项目组业务——更新当前单体项目组完成");
            return AjaxResponse.getInstanceByResult(res > ApplicationConstant.EFFECTIVE_LINE_ZERO).addReturnMsg("修改项目组成功");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{teamId}/queryMember")
    @ResponseBody
    public AjaxResponse refreshMemberOfTeam(@PathVariable String teamId, HttpServletRequest request) {
        logger.info("項目組業務——查詢當前項目組下成員");
        Member member = (Member) request.getSession().getAttribute("loginMember");
        if (!ApplicationConstant.notNull(member)) {
            return new AjaxResponse(ReturnState.ERROR, "操作超時");
        }
        if (!ApplicationConstant.notNull(teamId)) {
            return new AjaxResponse(ReturnState.ERROR, "没有对应的項目組");
        } else {
            Team team = teamService.selectEntryFromPrimaryKey(Integer.parseInt(teamId));
            List<Member_Team> objectList = teamService.selectMember_Team(team);
            return AjaxResponse.getInstanceByResult(ApplicationConstant.notNull(objectList)).addAttribute("list", objectList);
        }
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refresh(HttpServletRequest request) throws MemberException {
        logger.info("项目组业务——刷新当前列表");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        }
        List<Team> teamList = teamService.selectTeamListByMember(member);
        boolean isEnable = teamList != null && !teamList.isEmpty();
        if (!isEnable) {
            return new AjaxResponse(ReturnState.ERROR, "没有项目组对象");
        } else {
            AjaxResponse ajaxResponse = AjaxResponse
                    .getInstanceByResult(isEnable);
            ajaxResponse.setReturnMsg("刷新成功");
            ajaxResponse.addAttribute("teamList", teamList);
            return ajaxResponse;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addTeam(@RequestBody Team team, HttpServletRequest request) {
        logger.info("项目组业务——添加新项目组");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (team == null) {
            return new AjaxResponse(ReturnState.ERROR, "数据非法，请重新输入");
        }
        if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            int res = teamService.insertTeam(team, member);
            return AjaxResponse.getInstanceByResult(res > ApplicationConstant.EFFECTIVE_LINE_ZERO);
        }
    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResponse deleteTeamById(@PathVariable String teamId, HttpServletRequest request) {
        logger.info("项目组业务——删除当前项目组");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (teamId == null || member == null) {
            return new AjaxResponse(ReturnState.ERROR, "无效操作");
        } else {
            int res = teamService.deleteTeam(teamId, member);
            return AjaxResponse.getInstanceByResult(res > ApplicationConstant.EFFECTIVE_LINE_ZERO).addReturnMsg("删除成功");
        }

    }


    @RequestMapping(method = RequestMethod.GET, value = "/{teamId}")
    @ResponseBody
    public AjaxResponse getTeamById(@PathVariable String teamId, HttpServletRequest request) {
        logger.info("项目组业务——根据ID获取项目组");
        if (teamId == null) {
            return new AjaxResponse(ReturnState.ERROR, "错误的Id");
        } else {
            Team team = teamService.selectEntryFromPrimaryKey(Integer.parseInt(teamId));
            List<Member> memberList = teamService.selectMemberOfTeam(team);
            return AjaxResponse.getInstanceByResult(team != null)
                    .addAttribute("team", team)
                    .addAttribute("memberList", memberList);
        }
    }
}
