/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.english;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Callback;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Propose;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.service.english.ContentServiceI;
import xyz.tobebetter.service.english.WordServiceI;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.FileUtil;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/english/content")
public class ContentController {

    @Autowired
    private ContentServiceI contentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Propose propose) {
        return contentService.create(propose);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return contentService.delete(id);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Message findAll() {
        return contentService.findAll();
    }

    @RequestMapping(value = "/findLastOne", method = RequestMethod.GET)
    public @ResponseBody
    Message findLastOne() {
        return contentService.findLastOne();
    }
    
    @RequestMapping(value = "/uploadContent", method = RequestMethod.POST)
    public @ResponseBody
    Message uploadContent(HttpServletRequest request, HttpServletResponse response) {
        try {

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            //解析文件信息和请求参数

            String userId = multipartRequest.getParameter("userId");
            String contentStr = multipartRequest.getParameter("content");
            String imagePath = writeImageFile((CommonsMultipartFile) multipartRequest.getFile("imageFileName"));
            String audioPath = writeAudioFile((CommonsMultipartFile) multipartRequest.getFile("audioFileName"));

            Content content = new Content();

            content.setContent(contentStr);
            content.setAudioPath(audioPath);
            content.setImagePath(imagePath);
            content.setTimePoint(imagePath);
            content.setUserId("1");
            EntityUtil.initEnity(content);

            return this.contentService.create(content);
        } catch (IOException ex) {
            Logger.getLogger(ContentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return MessageUtil.createErrorMessage(null);

    }

    private String writeImageFile(CommonsMultipartFile file) throws IOException {
        String imageDir = FileUtil.imageDirectory();

        String filePath = FileUtil.appRootPath() + File.separator + imageDir + File.separator;
        String imageFileName = FileUtil.fileName("jpg");

        wirteFile(file, filePath, imageFileName);
        return imageDir + File.separator + imageFileName;
    }

    private String writeAudioFile(CommonsMultipartFile file) throws IOException {

        String audioPath = FileUtil.audioDirectory();

        String filePath = FileUtil.appRootPath() + File.separator + audioPath + File.separator;
        String imageFileName = FileUtil.fileName("mp3");

        wirteFile(file, filePath, imageFileName);
        return audioPath + File.separator + imageFileName;
    }

    private void wirteFile(CommonsMultipartFile file, String fileDir, String fileName) throws IOException {
        File uploadFile = new File(fileDir + File.separator + fileName);

        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!uploadFile.exists()) {
            uploadFile.createNewFile();
        }
        if (!uploadFile.exists()) {
            uploadFile.createNewFile();
        }
        FileCopyUtils.copy(file.getBytes(), uploadFile);

    }
}
