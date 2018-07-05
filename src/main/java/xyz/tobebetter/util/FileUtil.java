//package xyz.tobebetter.util;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Calendar;
//import java.util.UUID;
//import org.apache.ibatis.mapping.Environment;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author zhuqing
// */
//public class FileUtil {
//
//    public static final String APP_NAME = "leqienglish";
//    public static final String IMAGE = "image";
//    public static final String AUDIO = "audio";
//
//    public static String appRootPath() {
//
//        String userDir = System.getProperties().getProperty("user.home");
//        StringBuffer sb = new StringBuffer();
//        sb.append(userDir).append(File.separatorChar).append(APP_NAME);
//        String rootpath = sb.toString();
//        initDirectory(rootpath);
//        return rootpath;
//    }
//
//    public static void initDirectory(String rootpath) {
//        File file = new File(rootpath);
//        if (!file.exists()) {
//            synchronized ("initDir") {
//                if (!file.exists()) {
//                    file.mkdirs();
//                }
//            }
//        }
//    }
//
//    public static String fileName(String end) {
//        StringBuffer randomName = new StringBuffer();
//        synchronized ("fileName") {
//            randomName.append(UUID.randomUUID().toString()).append("_").append(System.currentTimeMillis()).append(".").append(end);
//        }
//
//        return randomName.toString();
//    }
//
//    public static String imageDirectory() {
//        return createDirectory(IMAGE);
//    }
//
//    public static String createDirectory(String dirName) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(dirName).append(File.separatorChar);
//        sb.append(date2DirName());
//        String imagePath = sb.toString();
//        return imagePath;
//    }
//
//    public static String audioDirectory() {
//
//        return createDirectory(AUDIO);
//    }
//
//    public static String date2DirName() {
//        Calendar calendar = Calendar.getInstance();
//        StringBuffer sb = new StringBuffer();
//        sb.append(calendar.get(Calendar.YEAR));
//        if (calendar.get(Calendar.MONTH) >= 10) {
//            sb.append(calendar.get(Calendar.MONTH) + 1);
//        } else {
//            sb.append(0).append(calendar.get(Calendar.MONTH));
//        }
//
//        if (calendar.get(Calendar.DAY_OF_MONTH) >= 10) {
//            sb.append(calendar.get(Calendar.DAY_OF_MONTH));
//        } else {
//            sb.append(0).append(calendar.get(Calendar.DAY_OF_MONTH));
//        }
//
//        return sb.toString();
//    }
//
//    /**
//     * 通过文件后缀获取文件的路径
//     *
//     * @param fileSuffix
//     * @return
//     */
//    public static String getPathByFileSuffix(String fileSuffix) {
//        switch (fileSuffix) {
//            case "mp3":
//                return FileUtil.audioDirectory();
//            case "jpg":
//                return FileUtil.imageDirectory();
//        }
//
//        return null;
//    }
//
//    /**
//     * 写入文件
//     * @param file
//     * @param fileSuffix
//     * @return
//     * @throws IOException
//     */
//    public static String writeFile(byte[] file, String fileSuffix) throws IOException {
//        String path = getPathByFileSuffix(fileSuffix);
//
//        if (path == null) {
//            return null;
//        }
//
//        String filePath = FileUtil.appRootPath() + File.separator + path + File.separator;
//        String imageFileName = FileUtil.fileName(fileSuffix);
//
//        wirteFile(file, filePath, imageFileName);
//        return path + File.separator + imageFileName;
//    }
//
//
//
//    private static void wirteFile(byte[] file, String fileDir, String fileName) throws IOException {
//        File uploadFile = new File(fileDir + File.separator + fileName);
//
//        File dir = new File(fileDir);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//        if (!uploadFile.exists()) {
//            uploadFile.createNewFile();
//        }
//        if (!uploadFile.exists()) {
//            uploadFile.createNewFile();
//        }
//        FileCopyUtils.copy(file, uploadFile);
//
//    }
//
//    private static void wirteFile(CommonsMultipartFile file, String fileDir, String fileName) throws IOException {
//        wirteFile(file.getBytes(), fileDir, fileName);
//
//    }
//}
