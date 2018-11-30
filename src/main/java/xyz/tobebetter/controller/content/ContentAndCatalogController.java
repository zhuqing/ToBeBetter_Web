package xyz.tobebetter.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.dao.english.ContentAndCatalogDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Catalog;
import xyz.tobebetter.entity.english.content.ContentAndCatalog;
import xyz.tobebetter.service.content.ContentAndCatalogServiceI;

/**
 * Created by zhuleqi on 2018/8/14.
 */

@Controller
@RequestMapping("/contentAndCatalog")
public class ContentAndCatalogController {
    @Autowired
    private ContentAndCatalogServiceI<ContentAndCatalog,ContentAndCatalogDao<ContentAndCatalog>> contentAndCatalogServiceI;
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return contentAndCatalogServiceI.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody ContentAndCatalog contentAndCatalog) {
        return contentAndCatalogServiceI.create(contentAndCatalog);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Message findAll() {
        return contentAndCatalogServiceI.findAll();
    }

    @RequestMapping(value = "/findByContentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByContentId(@RequestParam String contentId) {
        return contentAndCatalogServiceI.findByContentId(contentId);
    }

}
