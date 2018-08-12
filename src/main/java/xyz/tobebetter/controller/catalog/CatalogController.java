/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.catalog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.leqienglish.util.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Catalog;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.service.english.book.CatalogServiceI;

import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/english/catalog")
public class CatalogController {

    @Autowired
    private CatalogServiceI catalogService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return catalogService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody Catalog propose) {
        return catalogService.update(propose);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Catalog catalog) {
        return catalogService.create(catalog);
    }

    @RequestMapping(value = "/getCatalogByParentId", method = RequestMethod.GET)
    public @ResponseBody
    Message getCatalogByParentId(@RequestParam("parentId") String parentId) {
        return catalogService.getCatalogByParentId(parentId);
    }
    
    @RequestMapping(value = "/updateStatusById", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateStatusById(@RequestParam("id") String id,@RequestParam("status") int status) {
        return catalogService.updateStatusById(id, status);
    }

    @RequestMapping(value = "/getCatalogByType", method = RequestMethod.GET)
    public @ResponseBody
    Message getCatalogByType(@RequestParam("type") Integer type, @RequestParam("pageSize") Integer pageSize, @RequestParam("page") Integer page, @RequestParam(name = "parentId", required = false) String parentId) {
        if (parentId == null || parentId.isEmpty()) {
            return catalogService.getCatalogByType(type, pageSize, page);
        } else {
            return catalogService.getCatalogByParentId(parentId);
        }

    }

    @RequestMapping(value = "/getAllCatalogsByType", method = RequestMethod.GET)
    public @ResponseBody
    Message getAllCatalogsByType(@RequestParam("type") Integer type) {
        return catalogService.getAllCatalogsByType(type);
    }


    @RequestMapping(value = "/getBookByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message getBookByUserId(@RequestParam("userId") String userId) {
        return catalogService.getBookByUserId(userId);
    }



}
