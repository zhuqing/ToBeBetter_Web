/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.util.FileUtil;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    Message upload(MultipartFile file, @RequestParam("type") String type) {
        try {
            String imagePath = FileUtil.writeFile(file.getBytes(),type);
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }

     @RequestMapping(value = "/uploadAudio", method = RequestMethod.POST)
    public @ResponseBody
    Message uploadAudio(MultipartFile file) {
        try {
            String imagePath = FileUtil.writeFile(file.getBytes(),"mp3");
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }

    
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public @ResponseBody
    Message uploadImage(MultipartFile file) {
        try {
            String imagePath = FileUtil.writeFile(file.getBytes(), "jpg");
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }

    /*
     * 根据文件路径下载文件
     * @param path
     * @param request
     * @param response
     * @throws Exception 
     */

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadImage(@RequestParam("path") String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String filePath = FileUtil.appRootPath() + File.separator + path;
        if (filePath == null) {
            return;
        }
        download(filePath, request, response);
    }

    /**
     * 文件下载
     *
     * @param filePath
     * @param request
     * @param response
     * @throws Exception
     */
    private void download(String filePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (filePath == null) {
            return;
        }
        //设置响应头和客户端保存文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + filePath);
        //用于记录以完成的下载的数据量，单位是byte
        long downloadedLength = 0l;

        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(filePath);
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
                downloadedLength += b.length;
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e) {

            throw e;
        }

        //存储记录
    }

}