/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.service.content.ContentServiceI;
import xyz.tobebetter.service.content.ReciteContentVOServiceI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/english/content")
public class ContentController {

    @Autowired
    private ContentServiceI<Content> contentServiceI;


    @Autowired
    private ReciteContentVOServiceI reciteContentVOServiceI;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Content propose) {
        return contentServiceI.create(propose);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody Content propose) {
        return contentServiceI.update(propose);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return contentServiceI.delete(id);
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody
    Message findById(@RequestParam String id) {
        return contentServiceI.findById(id);
    }


    @RequestMapping(value = "/shuldUpdate", method = RequestMethod.GET)
    public @ResponseBody
    Message shouldUpdate(@RequestParam String id,@RequestParam long updateTime) {
        return contentServiceI.shouldUpdate(id,updateTime);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Message findAll() {
        return contentServiceI.findAll();
    }
    
     @RequestMapping(value = "/findCotentByCatalogId", method = RequestMethod.GET)
    public @ResponseBody
    Message findCotentByCatalogId(@RequestParam("catalogId") String catalogId,@RequestParam("pageSize") int pageSize,@RequestParam("page") int page) {
        return contentServiceI.findContentByCatalogId(catalogId,page, pageSize);
    }

    @RequestMapping(value = "/findLastOne", method = RequestMethod.GET)
    public @ResponseBody
    Message findLastOne() {
        return contentServiceI.findLastOne();
    }
    
     @RequestMapping(value = "/findContentByParentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findContentByParentId(@RequestParam("parentId") String parentId , @RequestParam("page") Integer page , @RequestParam("pageSize") Integer pageSize) {
        return contentServiceI.findContentByParentId(parentId, page, pageSize);
    }

    @RequestMapping(value = "/findNew/{updateDate}", method = RequestMethod.GET)
    public @ResponseBody
    Message findNew(@PathVariable String updateDate) {
        return contentServiceI.findNews(updateDate);
    }

    @RequestMapping(value = "/updateStatusById", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateStatusById(@RequestParam String id,@RequestParam int status) {
        return this.contentServiceI.updateStatusById(id, status);
    }

    @RequestMapping(value = "/findUserReciting", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserReciting(@RequestParam String userId) {

        return this.reciteContentVOServiceI.findUserReciting(userId);
    }

    @RequestMapping(value = "/findUserRecitingByContentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserReciting(@RequestParam String userId, @RequestParam String contentId) {
        return this.reciteContentVOServiceI.findUserReciting(userId,contentId);
    }

    @RequestMapping(value = "/findUserRecited", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserRecited(@RequestParam String userId) {
        return this.reciteContentVOServiceI.findUserRecited(userId);
    }

    @RequestMapping(value = "/findContentsByCatalogIdAndTitle", method = RequestMethod.GET)
    public @ResponseBody
    Message findContentsByCatalogIdAndTitle(@RequestParam(required = false)   String catalogId,@RequestParam(required = false) String title,@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer pageSize) {


        return this.contentServiceI.findContentsByCatalogIdAndTitle(catalogId,title,page,pageSize);
    }


    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserId(@RequestParam()   String userId) {


        return this.contentServiceI.findByUserId(userId);
    }
}
