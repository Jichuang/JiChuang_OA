package org.jichuang.hope6537.blog.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.controller.AdminPageController;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.blog.service.BlogService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.ControllerUtils;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class BlogController {

    private static final String PATH = AdminPageController.PATH + "/blog";

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private BlogService blogService;

    @RequestMapping("/conf")
    public String toConf() {
        logger.info("博客业务——进入维护");
        return PATH + "/conf";
    }

    @RequestMapping("/toAddBlog")
    public String toAddBlog() {
        logger.info("博客业务——进入添加博客页面");
        return PATH + "/addBlog";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addBlog(@RequestBody Blog blog, HttpServletRequest request) {
        logger.info("博客业务——进入添加博客业务");
        if (!ControllerUtils.memberEnabled(request)) {
            return AjaxResponse.getInstanceByResult(false).addReturnMsg("无效请求");
        }
        return AjaxResponse.getInstanceByResult(blogService.insertBlog(blog, ControllerUtils.getLoginMember(request)));
    }

    @RequestMapping("/{blogId}/toUpdateBlog")
    public String toUpdateBlog(@PathVariable String blogId, HttpServletRequest request) {
        logger.info("博客业务——进入更新博客页面");
        request.setAttribute("editBlogId", blogId);
        return PATH + "/addBlog";
    }


    @RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResponse deleteBlog(@PathVariable String blogId,
                                   HttpServletRequest request) {
        logger.info("博客业务——进入删除博客业务");
        if (blogId == null) {
            return new AjaxResponse(ReturnState.ERROR, "操作失败");
        } else {
            Logger.getLogger(getClass()).info("将要删除id为" + blogId + "的博客");
            int res = blogService.deleteEntryByPrimaryKey(Integer
                    .parseInt(blogId));
            return AjaxResponse.getInstanceByResult(res == 1);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse updateBlog(@RequestBody Blog blog, HttpServletRequest request) {
        logger.info("博客业务——进入更新博客业务");
        Logger.getLogger(getClass()).info(request.getParameter("blogId"));
        if (blog == null || blog.getBlogId() == null) {
            return new AjaxResponse(ReturnState.ERROR, "没有该博客对象");
        } else {
            Logger.getLogger(getClass()).info(
                    "将要修改id为" + blog.getBlogId() + "的博客");
            JSONObject infos = new JSONObject();
            String blogType = request.getParameter("type");
            String blogTags = request.getParameter("tags");
            infos.put("blogTag", blogTags.toString());
            infos.put("blogType", blogType);
            int res = blogService.updateBlog(blog, infos);
            return AjaxResponse.getInstanceByResult(res == 1);
        }

    }

    @RequestMapping(value = "/{blogId}/deployBlog", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse deployBlog(@PathVariable String blogId,
                                   HttpServletRequest request) {
        logger.info("博客业务——进入发布博客业务");
        Logger.getLogger(getClass()).info(request.getParameter("blogId"));
        if (blogId == null) {
            return new AjaxResponse(ReturnState.ERROR, "没有该博客对象");
        } else {
            Logger.getLogger(getClass()).info("将要发布id为" + blogId + "的博客");
            Blog blog = blogService.selectEntryFromPrimaryKey(Integer
                    .parseInt(blogId));
            blog.setStatus("正常");
            int res = blogService.updateEntryByObject(blog);
            AjaxResponse ajax = AjaxResponse.getInstanceByResult(res == 1);
            ajax.setReturnMsg(res == 1 ? "博客发布成功" : "博客发布失败");
            return ajax;
        }

    }

    @RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refreshSimpleBlog(@PathVariable String blogId, HttpServletRequest request) {
        logger.info("博客业务——进入查询单体博客业务");
        if (blogId == null) {
            return new AjaxResponse(ReturnState.ERROR, "没有该博客对象");
        } else {
            Logger.getLogger(getClass()).info("将要查看id为" + blogId + "的博客");
            Blog editBlog = blogService.selectEntryFromPrimaryKey(Integer.parseInt(blogId));
            Member member = (Member) request.getSession().getAttribute(
                    "loginMember");
            if (editBlog == null) {
                return new AjaxResponse(ReturnState.ERROR, "没有该博客对象");
            } else if (!editBlog.getMemberId().getMemberId().equals(member.getMemberId())) {
                return new AjaxResponse(ReturnState.ERROR, "您没有编辑其权限");
            } else {
                return AjaxResponse.getInstanceByResult(editBlog != null).addAttribute("blog", editBlog);
            }
        }
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refresh(HttpServletRequest request) {
        logger.info("博客业务——进入刷新博客列表业务");
        Member member = (Member) request.getSession().getAttribute("loginMember");
        if (member == null) {
            return new AjaxResponse(ReturnState.ERROR, "刷新失败");
        }
        List<Blog> blogList = blogService.selectBlogAllByMember(member);
        boolean isEnable = blogList != null && !blogList.isEmpty();
        if (!isEnable) {
            return new AjaxResponse(ReturnState.ERROR, "刷新失败");
        } else {
            AjaxResponse ajaxResponse = AjaxResponse
                    .getInstanceByResult(isEnable);
            ajaxResponse.setReturnMsg("刷新成功");
            ajaxResponse.addAttribute("blogList", blogList);
            return ajaxResponse;
        }

    }
}
