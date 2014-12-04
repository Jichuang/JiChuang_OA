package org.jichuang.hope6537.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.jichuang.hope6537.base.controller.AdminPageController;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.blog.service.BlogService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class BlogController {

    private static final String PATH = AdminPageController.PATH + "/blog";

    @Autowired
    private BlogService blogService;

    @RequestMapping("/conf")
    public String toConf(HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        if (member == null) {
            return PATH + "/conf";
        }
        List<Blog> blogList = blogService.selectBlogAllByMember(member);
        request.setAttribute("blogList", blogList);
        return PATH + "/conf";
    }

    @RequestMapping("/toAddBlog")
    public String toAddBlog() {
        return PATH + "/addBlog";
    }

    @RequestMapping("/insertBlog")
    @ResponseBody
    public void addBlog(Model model, @ModelAttribute Blog blog,
                        HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Logger.getLogger(getClass()).info("进入添加博客业务");
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
        // TODO : 在这里编写其他的信息 例如info的 然后别忘了封装
        JSONObject infos = new JSONObject();
        String blogType = request.getParameter("type");
        String blogTags = request.getParameter("tags");
        infos.put("blogTag", blogTags.toString());
        infos.put("blogType", blogType);
        int res = blogService.insertBlog(blog, member, infos);
        request.setAttribute("insertRes", res);
        if (res != 0) {
            response.sendRedirect("conf.hopedo?res=1");
        } else {
            response.sendRedirect("conf.hopedo?res=0");
        }
    }

    @RequestMapping("/{blogId}/toUpdateBlog")
    public String toUpdateBlog(@PathVariable String blogId,
                               HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (blogId == null) {
            response.sendRedirect("conf.hopedo?selectRes=0");
            return null;
        } else {
            Blog editBlog = blogService.selectEntryFromPrimaryKey(Integer
                    .parseInt(blogId));
            Member member = (Member) request.getSession().getAttribute(
                    "loginMember");
            if (!editBlog.getMemberId().getMemberId()
                    .equals(member.getMemberId())) {
                response.sendRedirect("../conf.hopedo?selectRes=0");
            }
            request.setAttribute("editBlog", editBlog);
            return PATH + "/addBlog";
        }
    }

    @RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResponse deleteBlog(@PathVariable String blogId,
                                   HttpServletRequest request) {
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
    public AjaxResponse updateBlog(Blog blog, HttpServletRequest request) {
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

    /**
     * 发布博客按钮
     *
     * @param blogId
     * @param request
     * @return
     */
    @RequestMapping(value = "/{blogId}/deployBlog", method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResponse deployBlog(@PathVariable String blogId,
                                   HttpServletRequest request) {
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse refresh(HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute(
                "loginMember");
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
