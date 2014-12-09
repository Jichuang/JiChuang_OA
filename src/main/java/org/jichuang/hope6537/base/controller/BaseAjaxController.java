package org.jichuang.hope6537.base.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.ResourceFile;
import org.jichuang.hope6537.base.service.MemberService;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.FileUtil;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Describe: 异步交互控制器</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月15日下午2:01:15</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Controller()
@RequestMapping("/baseAjax")
public class BaseAjaxController {
    @Value("${apacheDocPath}")
    private String apacheDocPath;

    private Logger logger = Logger.getLogger("memberAjax");

    @RequestMapping(method = RequestMethod.POST, value = "/uploadImage")
    @ResponseBody
    public AjaxResponse uploadImage(@RequestParam("image") MultipartFile multipartFile,
                                    HttpServletRequest request, HttpServletResponse response) {
        String fileName = getUploadFileName(multipartFile);
        String uploadPath = getFileUploadPath(ResourceFile.IMAGE);
        try {
            FileUtil.readWriteFile(multipartFile, fileName, uploadPath);
        } catch (IOException e) {
            return new AjaxResponse(ReturnState.ERROR, "上传失败，发生错误").addAttribute("Exception", e.getMessage());
        }
        return AjaxResponse.getInstanceByResult(true).addAttribute("path", uploadPath + File.separator + fileName);
    }

    /**
     * 生成上传文件的名字
     *
     * @param multipartFile
     * @return
     */
    private String getUploadFileName(MultipartFile multipartFile) {
        String uploadFileName = multipartFile.getOriginalFilename();
        String type = uploadFileName.substring(uploadFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + type;
    }

    /**
     * 获取上传文件的保存路径
     *
     * @return 路径
     */
    private String getFileUploadPath(String fileType) {
        return apacheDocPath + File.separator + ResourceFile.FILEUPLOAD + File.separator + fileType;
    }


}
