/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.english;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import xyz.tobebetter.service.english.book.CatalogServiceI;
import xyz.tobebetter.util.FileUtil;
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

    @RequestMapping(value = "/getCatalogByType", method = RequestMethod.GET)
    public @ResponseBody
    Message getCatalogByType(@RequestParam("type") Integer type, @RequestParam("pageSize") Integer pageSize, @RequestParam("page") Integer page, @RequestParam(name = "parentId", required = false) String parentId) {
        if (parentId == null || parentId.isEmpty()) {
            return catalogService.getCatalogByType(type, pageSize, page);
        } else {
            return catalogService.getCatalogByParentId(parentId);
        }

    }

    @RequestMapping(value = "/getBookByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message getBookByUserId(@RequestParam("userId") String userId) {
        return catalogService.getBookByUserId(userId);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    Message upload(Catalog catalog, MultipartFile file) {
        try {
            String imagePath = FileUtil.writeFile(file.getBytes(), "jpg");
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }

}
