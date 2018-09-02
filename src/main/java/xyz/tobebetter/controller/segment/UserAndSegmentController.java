package xyz.tobebetter.controller.segment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.dao.segment.UserAndSegmentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.entity.english.word.user.UserAndSegment;
import xyz.tobebetter.service.segment.UserAndSegmentServiceI;

/**
 * Created by zhuleqi on 2018/8/31.
 */

@Controller
@RequestMapping("/userAndSegment")
public class UserAndSegmentController {
    @Autowired
    private UserAndSegmentServiceI<UserAndSegment,UserAndSegmentDao<UserAndSegment>> userAndSegmentServiceI;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserAndSegment propose) {
        return userAndSegmentServiceI.create(propose);
    }


    @RequestMapping(value = "/findByContentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByContentId(@RequestParam String contentId) {
        return userAndSegmentServiceI.findByContentId(contentId);
    }

}
