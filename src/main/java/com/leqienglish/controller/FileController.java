//package com.leqienglish.controller;
//
//import xyz.tobebetter.util.json.JsonUtil;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import java.io.*;
//
///**
// * Created by zhuqing on 2017/7/26.
// */
//@Controller
//@RequestMapping("file")
//public class FileController {
//
//    @RequestMapping(value = "fileUpload")
//    public @ResponseBody String fileUpload(@RequestParam CommonsMultipartFile file){
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("E://"+file.getName()));
//            InputStream inputStream = file.getInputStream();
//            int temp = 0;
//            while ((temp = inputStream.read())!=-1){
//                fileOutputStream.write(temp);
//            }
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            inputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return JsonUtil.errorJSON();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return JsonUtil.successJSON();
//
//
//    }
//}
