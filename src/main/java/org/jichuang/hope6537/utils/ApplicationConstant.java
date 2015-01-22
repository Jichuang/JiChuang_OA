package org.jichuang.hope6537.utils;

import org.jichuang.hope6537.base.model.Member;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by Zhaopeng-Rabook on 15-1-9.
 */
public class ApplicationConstant {

    public static final int EFFECTIVE_LINE_ONE = 1;
    public static final int EFFECTIVE_LINE_ZERO = 0;

    public static boolean notNull(Object o) {
        if (o instanceof String) {
            return o != null && !((String) o).isEmpty();
        }
        if (o instanceof Collection) {
            return o != null && !((Collection) o).isEmpty();
        }
        return o != null;
    }


    public static boolean memberNotNull(HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute("loginMember");
        return member != null;
    }
}
