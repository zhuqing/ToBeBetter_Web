/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.english;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leqienglish.util.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.service.english.ContentServiceI;

import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/english/content")
public class ContentController {

    @Autowired
    private ContentServiceI<Content> contentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Content propose) {
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
    
     @RequestMapping(value = "/findCotentByCatalogId", method = RequestMethod.GET)
    public @ResponseBody
    Message findCotentByCatalogId(@RequestParam("catalogId") String catalogId,@RequestParam("pageSize") int pageSize,@RequestParam("page") int page) {
        return contentService.findContentByCatalogId(catalogId,page, pageSize); 
    }

    @RequestMapping(value = "/findLastOne", method = RequestMethod.GET)
    public @ResponseBody
    Message findLastOne() {
        return contentService.findLastOne();
    }
    
     @RequestMapping(value = "/findContentByParentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findContentByParentId(@RequestParam("parentId") String parentId , @RequestParam("page") Integer page , @RequestParam("pageSize") Integer pageSize) {
        return contentService.findContentByParentId(parentId, page, pageSize);
    }

    @RequestMapping(value = "/findNew/{updateDate}", method = RequestMethod.GET)
    public @ResponseBody
    Message findNew(@PathVariable String updateDate) {
        return contentService.findNews(updateDate);
    }

    @RequestMapping(value = "/updateStatusById", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateStatusById(@RequestParam String id,@RequestParam int status) {
        return this.contentService.updateStatusById(id, status);
    }
    
    @RequestMapping(value = "/uploadAudio", method = RequestMethod.POST)
    public @ResponseBody
    Message uploadAudio(MultipartFile file) {
        try {
            String imagePath = FileUtil.writeFile(file.getBytes(), "map3");
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }
    
    

    @RequestMapping(value = "/download/image/{id}", method = RequestMethod.GET)
    public void downloadImage(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String filePath = this.contentService.findImagePath(id);
        if (filePath == null) {
            return;
        }
        download(filePath, request, response);
    }

    @RequestMapping(value = "/download/audio/{id}", method = RequestMethod.GET)
    public void downloadAudio(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String filePath = this.contentService.findAudioPath(id);
        if (filePath == null) {
            return;
        }
        download(filePath, request, response);
    }

    private void download(String filePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (filePath == null) {
            return;
        }
        //设置响应头和客户端保存文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + filePath);
        //用于记录以完成的下载的数据量，单位是byte
        long downloadedLength = 0l;

        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(filePath);
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
                downloadedLength += b.length;
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e) {

            throw e;
        }

        //存储记录
    }

 

}
