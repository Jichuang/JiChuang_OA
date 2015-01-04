package org.jichuang.hope6537.message.controller;

import org.jichuang.hope6537.base.controller.AdminPageController;
import org.jichuang.hope6537.base.controller.BaseController;

/**
 * Created by cuud70803 on 15-1-4.
 */
@Controller()
@RequestMapping("/message")
public class MessageController {

    private final String PATH = AdminPageController.PATH;
    /**
     * 分为两部分，其中一块是用户接口，而另一块是管理接口，不过都公用一个Controller，业务逻辑不冲突
     * @return
     */
    @RequestMapping(method = RequestType.GET)
    public String toMessage(HttpRequestServlet request){
        if(!BaseController.memberEnabled(request)){
            return PATH + "/login";
        }
        else {
            return PATH + "/message";
        }
    }

    @RequestMapping(value = "/conf" ,method = RequestType.GET)
    public String toMessageConf(HttpServletRequest request){
        if(!BaseController.memberEnabled(request)){
            return PATH + "/login";
        }
        else{
            return  PATH + "/message/conf";
        }

    }



}
