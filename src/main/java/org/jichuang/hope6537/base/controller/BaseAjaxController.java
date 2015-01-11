package org.jichuang.hope6537.base.controller;

import org.jichuang.hope6537.base.model.ResourceFile;
import org.jichuang.hope6537.utils.AjaxResponse;
import org.jichuang.hope6537.utils.FileUtil;
import org.jichuang.hope6537.utils.ReturnState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

@Controller()
@RequestMapping("/baseAjax")
public class BaseAjaxController {
    @Value("${apacheDocPath_Develop}")
    private String apacheDocPath;
    @Value("${apacheUrl}")
    private String apacheUrl;

    private Logger logger = Logger.getLogger("memberAjax");

    @RequestMapping(method = RequestMethod.POST, value = "/uploadImage")
    @ResponseBody
    public AjaxResponse uploadImage(@RequestParam("image") MultipartFile multipartFile,
                                    HttpServletRequest request, HttpServletResponse response) {
        String fileName = getUploadFileName(multipartFile);
        String uploadPath = getFileUploadPath(ResourceFile.IMAGE);
        String serverPath = getServerPath(ResourceFile.IMAGE);
        try {
            FileUtil.readWriteFile(multipartFile, fileName, uploadPath);
        } catch (IOException e) {
            return new AjaxResponse(ReturnState.ERROR, "上传失败，发生错误").addAttribute("Exception", e.getMessage());
        }
        return AjaxResponse.getInstanceByResult(true).addAttribute("path", serverPath + "/" + fileName);
    }

    private String getUploadFileName(MultipartFile multipartFile) {
        String uploadFileName = multipartFile.getOriginalFilename();
        String type = uploadFileName.substring(uploadFileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + type;
    }

    private String getFileUploadPath(String fileType) {
        return apacheDocPath + File.separator + ResourceFile.FILEUPLOAD + File.separator + fileType;
    }

    public String getServerPath(String fileType) {
        return apacheUrl + "/" + ResourceFile.FILEUPLOAD + "/" + fileType;
    }

}
