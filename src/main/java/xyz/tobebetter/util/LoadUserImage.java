package xyz.tobebetter.util;

import com.leqienglish.util.file.FileUtil;
import org.springframework.http.MediaType;
import xyz.tobebetter.entity.user.User;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by zhuleqi on 2018/11/7.
 */
public class LoadUserImage {
    public static void loadImage(User user){
        if(user.getImagePath() == null){
            return;
        }

        if(!user.getImagePath().startsWith("http")){
            return;
        }

        String imagePathF = createImagePath(user.getId()+".png");

        try {
            LoadWordUtil.downLoad(user.getImagePath(),imagePathF, MediaType.ALL);
            String path = imagePathF.substring(FileUtil.getInstence().appRootPath().length());
            user.setImagePath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static String createImagePath(String fileName){
        StringBuffer sb = new StringBuffer();
        sb.append(FileUtil.getInstence().appRootPath()).append(File.separatorChar).append(FileUtil.getInstence().imageDirectory()).append(File.separatorChar);
        FileUtil.getInstence().initDirectory(sb.toString());
        sb.append(fileName);
        return sb.toString();
    }
}
