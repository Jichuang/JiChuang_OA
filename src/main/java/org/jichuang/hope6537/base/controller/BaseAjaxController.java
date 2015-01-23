package org.jichuang.hope6537.base.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

    @RequestMapping(method = RequestMethod.POST, value = "multiUpload")
    @ResponseBody
    public AjaxResponse multiUpload(@RequestParam(value = "files[]", required = false) MultipartFile multipartFile
            , MultipartHttpServletRequest request) {
        logger.info("基本业务——多重文件上传");
        System.out.println(multipartFile);
        String fileName = getUploadFileName(multipartFile);
        String uploadPath = getFileUploadPath(ResourceFile.IMAGE);
        String serverPath = getServerPath(ResourceFile.IMAGE);
        try {
            FileUtil.readWriteFile(multipartFile, fileName, uploadPath);
        } catch (IOException e) {
            return new AjaxResponse(ReturnState.ERROR, "上传失败，发生错误").addAttribute("Exception", e.getMessage());
        }
        return AjaxResponse.getInstanceByResult(true)
                .addAttribute("path", serverPath + "/" + fileName)
                .addAttribute("originName", multipartFile.getOriginalFilename())
                .addAttribute("name", fileName)
                .addAttribute("size", (multipartFile.getSize() / 1024.0 + "").substring(0, 6) + "K");
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

    public String returnJsonString(MultipartFile multipartFile, String fileName, String serverPath) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        return "{ files: [ { \"name\": \"iPhone5 docking station.jpeg\", \"originalName\": \"iPhone5 docking station.jpeg\", \"size\": 9584, \"type\": \"image/jpeg\", \"delete_type\": \"DELETE\", \"url\": \"http://localhost/uploads/iPhone5%20docking%20station.jpeg\", \"delete_url\": \"http://localhost/product/upload/iPhone5%20docking%20station.jpeg\", \"thumbnail_url\": \"http://localhost/uploads/thumbnail/iPhone5%20docking%20station.jpeg\" } ] }";
    }

}
