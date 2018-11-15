package xyz.tobebetter.controller.segment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.entity.english.shortword.SegmentAndShortWord;
import xyz.tobebetter.service.segment.SegmentAndShortWordServiceI;

/**
 * Created by zhuleqi on 2018/11/14.
 */
@Controller //    segmentAndShortWord
@RequestMapping("/segmentAndShortWord")
public class SegmentAndShortWordController {
    @Autowired
    private SegmentAndShortWordServiceI segmentAndShortWordServiceI;



    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return this.segmentAndShortWordServiceI.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody SegmentAndShortWord propose) {
        return segmentAndShortWordServiceI.update(propose);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody SegmentAndShortWord propose) {
        return segmentAndShortWordServiceI.create(propose);
    }
//segmentAndShortWord/        findBySegmentId?segmentId=1fb71c22-31cc-4b5e-97a9-98ef61820a48-1540706694006
    @RequestMapping(value = "/findBySegmentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findBySegmentId(@RequestParam String segmentId) {
        return this.segmentAndShortWordServiceI.findBySegmentId(segmentId);
    }
}
