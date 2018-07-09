/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.english;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.service.english.SegmentServiceI;

/**
 * 文章中的段的接口
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/segment")
public class SegmentController {

    @Autowired
    private SegmentServiceI<Segment> segmentService;
    
      @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return segmentService.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Segment propose) {
        return segmentService.create(propose);
    }

    @RequestMapping(value = "/updateStatusById", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateStatusById(@RequestParam String id, @RequestParam int status) {
        return segmentService.updateStatusById(id, status);
    }

    @RequestMapping(value = "/findByContentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByContentId(@RequestParam String contentId) {
        return segmentService.findByContentId(contentId);
    }

    /**
     *
     * @param contentId
     * @param status
     * @return
     */
    @RequestMapping(value = "/findByContentIdAndStatus", method = RequestMethod.GET)
   // @Description(value = "获取已经发布的Segment")
    public @ResponseBody
    Message findByContentIdAndStatus(@RequestParam String contentId,@RequestParam int status) {
        return segmentService.findByContentId(contentId,status);
    }
}
