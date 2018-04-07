package xyz.tobebetter.controller.propose;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.dao.ProposeDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Propose;
import xyz.tobebetter.service.ProposeServiceI;


/**
 * Created by zhuleqi on 2018/2/23.
 */
@Controller
@RequestMapping("/propose")
public class ProposeController {
    @Autowired
    private ProposeServiceI<Propose,ProposeDao<Propose>> proposeServiceI;

    @RequestMapping(value="/create",method= RequestMethod.POST)
    public @ResponseBody Message create(@RequestBody Propose propose){
        return  proposeServiceI.create(propose);
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam("id") String id ){
        return  proposeServiceI.delete(id);
    }

    @RequestMapping(value="/findAll",method= RequestMethod.GET)
    public @ResponseBody Message findAll(){
        return  proposeServiceI.findAll();
    }
}