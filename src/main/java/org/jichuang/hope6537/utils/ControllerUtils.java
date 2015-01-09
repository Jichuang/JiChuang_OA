package org.jichuang.hope6537.utils;

import org.jichuang.hope6537.base.model.Member;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zhaopeng-Rabook on 15-1-9.
 */
public class ControllerUtils {

    public static boolean memberEnabled(HttpServletRequest request) {
        if (request == null) {
            return false;
        }
        if (request.getSession().getAttribute("loginMember") == null) {
            return false;
        }
        return true;
    }


    public static Member getLoginMember(HttpServletRequest request) {
        return (Member) request.getSession().getAttribute("loginMember");
    }
}
