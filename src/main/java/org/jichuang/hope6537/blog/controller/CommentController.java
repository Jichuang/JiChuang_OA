package org.jichuang.hope6537.blog.controller;

import org.jichuang.hope6537.base.controller.AdminPageController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zhaopeng-Rabook on 15-1-11.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    public static final String PATH = AdminPageController.PATH;

    @RequestMapping(method = RequestMethod.GET)
    public String comment(HttpServletRequest request) {
        return PATH + "/blog";
    }

}
