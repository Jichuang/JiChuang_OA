package org.jichuang.hope6537.team.controller;

import org.apache.log4j.Logger;
import org.jichuang.hope6537.team.service.TeamTypeService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/teamType")
@Scope("prototype")
public class TeamTypeController {

    @Autowired
    private TeamTypeService teamTypeService;

    private Logger logger = Logger.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refresh(HttpServletRequest request) {
        AjaxResponse ajaxResponse = AjaxResponse.getInstanceByResult(true);
        ajaxResponse.addAttribute("teamTypeList", teamTypeService.selectEntryAll());
        return ajaxResponse;
    }

}
