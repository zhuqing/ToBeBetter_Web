package xyz.tobebetter.util.json;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhuqing on 2017/7/25.
 */
public class JsonUtil {
    public static String successJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","ok");
        return jsonObject.toJSONString();
    }

    public static String errorJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","error");
        return jsonObject.toJSONString();
    }
}
