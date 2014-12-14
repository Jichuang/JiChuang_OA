package org.jichuang.hope6537.team.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.controller.AdminPageController;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.team.model.TeamType;
import org.jichuang.hope6537.team.service.TeamService;
import org.jichuang.hope6537.team.service.TeamTypeService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.lang.reflect.Method;
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
        return PATH + "/team/conf";
    }

    @RequestMapping("/toAddTeam")
    public String toAddTeam() {
        return PATH + "/team/addTeam";
    }

    @RequestMapping("/{teamId}/toUpdateTeam")
    public String toUpdateTeam(@PathVariable String teamId, HttpServletRequest request) {
        request.setAttribute("isEdit", 1);
        request.setAttribute("teamId", teamId);
        return PATH + "/team/addTeam";
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refresh(HttpServletRequest request) throws MemberException {
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
    public AjaxResponse addTeam(Model model, @ModelAttribute Team team, HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (team == null) {
            return new AjaxResponse(ReturnState.ERROR, "数据非法，请重新输入");
        }
        if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作超时，请重新登录");
        } else {
            String teamTypeId = request.getParameter("teamType");
            int res = teamService.insertTeam(team, member, teamTypeId);
            return AjaxResponse.getInstanceByResult(res > 0);
        }
    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResponse deleteTeamById(@PathVariable String teamId, HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (teamId == null || member == null) {
            return new AjaxResponse(ReturnState.ERROR, "无效操作");
        } else {
            int res = teamService.deleteTeam(teamId, member);
            return AjaxResponse.getInstanceByResult(res > 0).addReturnMsg("删除成功");
        }

    }


    @RequestMapping(method = RequestMethod.GET, value = "/{teamId}")
    @ResponseBody
    public AjaxResponse getTeamById(@PathVariable String teamId, HttpServletRequest request) {
        if (teamId == null) {
            return new AjaxResponse(ReturnState.ERROR, "错误的Id");
        } else {
            Team team = teamService.selectEntryFromPrimaryKey(Integer.parseInt(teamId));
            return AjaxResponse.getInstanceByResult(team != null).addAttribute("team", team);
        }
    }
}
