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
import xyz.tobebetter.entity.english.Segment;
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

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody Content propose) {
        return contentService.update(propose);
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

}
