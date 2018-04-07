package xyz.tobebetter.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zhuqing
 */
public class FileUtil {

    public static final String APP_NAME = "leqienglish";
    public static final String IMAGE = "image";
    public static final String AUDIO = "audio";

    public static String appRootPath() {
        String userDir = System.getProperties().getProperty("user.home");
        StringBuffer sb = new StringBuffer();
        sb.append(userDir).append(File.separatorChar).append(APP_NAME);
        String rootpath = sb.toString();
        initDirectory(rootpath);
        return rootpath;
    }

    public static void initDirectory(String rootpath) {
        File file = new File(rootpath);
        if (!file.exists()) {
            synchronized ("initDir") {
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
        }
    }

    public static String fileName(String end) {
        StringBuffer randomName = new StringBuffer();
        synchronized ("fileName") {
            randomName.append(UUID.randomUUID().toString()).append("_").append(System.currentTimeMillis()).append(".").append(end);
        }

        return randomName.toString();
    }

    public static String imageDirectory() {
        return createDirectory(IMAGE);
    }

    public static String createDirectory(String dirName) {
        StringBuffer sb = new StringBuffer();
        sb.append(dirName).append(File.separatorChar);
        sb.append(date2DirName());
        String imagePath = sb.toString();
        return imagePath;
    }

    public static String audioDirectory() {

        return createDirectory(AUDIO);
    }

    public static String date2DirName() {
        Calendar calendar = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        sb.append(calendar.get(Calendar.YEAR));
        if (calendar.get(Calendar.MONTH) >= 10) {
            sb.append(calendar.get(Calendar.MONTH)+1);
        } else {
            sb.append(0).append(calendar.get(Calendar.MONTH));
        }

        if (calendar.get(Calendar.DAY_OF_MONTH) >= 10) {
            sb.append(calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            sb.append(0).append(calendar.get(Calendar.DAY_OF_MONTH));
        }

        return sb.toString();
    }
}
