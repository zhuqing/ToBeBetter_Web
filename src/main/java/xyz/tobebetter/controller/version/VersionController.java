package xyz.tobebetter.controller.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.entity.user.User;
import xyz.tobebetter.service.version.VersionServiceI;
import xyz.tobebetter.version.Version;

/**
 * Created by zhuleqi on 2018/8/28.
 */
@Controller
@RequestMapping("/version")
public class VersionController {

    @Autowired
    private VersionServiceI<Version> versionServiceI;



    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return versionServiceI.delete(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Version version) {
        return this.versionServiceI.create(version);
    }

    @RequestMapping(value = "/updateStatusById", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateStatusById(@RequestParam String id, @RequestParam int status) {
        return this.versionServiceI.updateStatusById(id, status);
    }


    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Message findAll() {

        return this.versionServiceI.findAll();
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody Version propose) {
        return versionServiceI.update(propose);
    }

    @RequestMapping(value = "/findByType", method = RequestMethod.GET)
    public @ResponseBody
    Message findByType(@RequestParam Integer type) {

        return this.versionServiceI.findByType(type);
    }

    @RequestMapping(value = "/findNewestByType", method = RequestMethod.GET)
    public @ResponseBody
    Message findNewestByType(@RequestParam Integer type) {

        return this.versionServiceI.findNewestByType(type);
    }
}
