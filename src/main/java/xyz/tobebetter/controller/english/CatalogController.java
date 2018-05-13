/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.english;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
    Message getCatalogByType(@RequestParam("type") String type,@RequestParam("pageSize") Integer pageSize,@RequestParam("page") Integer page) {
        return catalogService.getCatalogByType(type,pageSize,page);
    }
    
  @RequestMapping(value = "/getBookByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message getBookByUserId(@RequestParam("userId") String userId) {
        return catalogService.getBookByUserId(userId);
    }
    @RequestMapping(value = "/uploadCatalog", method = RequestMethod.POST)
    public @ResponseBody
    Message uploadCatalog(HttpServletRequest request, HttpServletResponse response) {
        try {

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            //解析文件信息和请求参数
            String userId = multipartRequest.getParameter("userId");
            String type = multipartRequest.getParameter("type");
            String title = multipartRequest.getParameter("title");
            String parentId = multipartRequest.getParameter("parentId");
            String imagePath = FileUtil.writeFile((CommonsMultipartFile) multipartRequest.getFile("imageFileName"), "jpg");
           
            Catalog catalog = new Catalog();
            catalog.setTitle(title);
            catalog.setType(Integer.valueOf(type));
            catalog.setImagePath(imagePath);
            catalog.setParentId(parentId);
            catalog.setUserId(userId);

            return this.catalogService.create(catalog);
        } catch (Exception ex) {
            Logger.getLogger(ContentController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }

    }
}
