package xyz.tobebetter.controller;

import com.leqienglish.util.file.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.util.MessageUtil;

/**
 * 客户端检测服务端是否链接
 * Created by zhuleqi on 2018/10/25.
 */
@Controller
@RequestMapping("/check")
public class CheckController  {
      /*
     * 根据文件路径下载文件
     * @param path
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public Message connect() {
        return MessageUtil.createSuccessMessage("ok");
    }

}
