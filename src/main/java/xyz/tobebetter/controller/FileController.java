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

import com.leqienglish.util.file.FileUtil;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.tobebetter.entity.Message;

import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebFileUtil;

/**
 * @author zhuqing
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    Message upload(MultipartFile file, @RequestParam("type") String type) {
        try {
            String imagePath = FileUtil.getInstence().writeFile(file.getBytes(), type);
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }

    @RequestMapping(value = "/uploadAudio", method = RequestMethod.POST)
    public
    @ResponseBody
    Message uploadAudio(MultipartFile file) {
        try {
            String imagePath = FileUtil.getInstence().writeFile(file.getBytes(), "mp3");
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }

    @RequestMapping(value = "/uploadWordAudio", method = RequestMethod.POST)
    public
    @ResponseBody
    Message uploadWordAudio(MultipartFile file, @RequestParam("word") String word,  @RequestParam("type") String type) {
        try {
            String imagePath = FileUtil.getInstence().writeWordAudioFile(file.getBytes(), word, type,"mp3");
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }


    @RequestMapping(value = "/uploadVersionFile", method = RequestMethod.POST)
    public
    @ResponseBody
    Message uploadVersionFile(MultipartFile file,   @RequestParam("type") String type) {
        try {
            String path  = FileUtil.getInstence().versionRelationPath(type);
            String absulotelyPath = FileUtil.getInstence().appRootPath()+ File.separator+path;

            FileUtil.getInstence().writeFileDirectly(file.getBytes(),absulotelyPath);
            return MessageUtil.createSuccessMessage(path);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }



    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public
    @ResponseBody
    Message uploadImage(MultipartFile file) {
        try {
            String imagePath = FileUtil.getInstence().writeFile(file.getBytes(), "jpg");
            return MessageUtil.createSuccessMessage(imagePath);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
    Message uploadFile(MultipartFile file,@RequestParam String path) {
        try {
            String fullPath = FileUtil.getInstence().appRootPath()+ File.separator+path;
           File file1 = new File(fullPath);
           file1.getParentFile().mkdirs();
            FileUtil.getInstence().writeFileDirectly(file.getBytes(), fullPath);
            return MessageUtil.createSuccessMessage(path);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());

        }

    }


    @RequestMapping(value = "/uploadImagePng", method = RequestMethod.POST)
    public
    @ResponseBody
    Message uploadImagePng(MultipartFile file) {
        try {
            String imagePath = FileUtil.getInstence().writeFile(file.getBytes(), "png");
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

        String filePath = FileUtil.getInstence().appRootPath() + File.separator + path;
        if (filePath == null) {
            return;
        }
        WebFileUtil.download(filePath, request, response);
    }

      /*
     * 根据文件路径下载文件
     * @param path
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/hasFile", method = RequestMethod.GET)
    public Message hasFile(@RequestParam("path") String path) {

        String filePath = FileUtil.getInstence().appRootPath() + File.separator + path;
        File file = new File(filePath);
        return MessageUtil.createSuccessMessage(file.exists());

    }


}
