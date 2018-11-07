package xyz.tobebetter.util;

import com.leqienglish.util.file.FileUtil;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by zhuleqi on 2018/11/2.
 */
public class LoadWordUtil {

    public static  String load(String urlPath, String word,String type) throws IOException, Exception {
           if(urlPath == null || urlPath.isEmpty()){
                return "";
            }
            String localPath = FileUtil.getInstence().wordFilelPath(word,type);
            if(!FileUtil.getInstence().fileExit(localPath)){
                downLoad(urlPath, localPath, MediaType.ALL);

            }

           String[] arr = localPath.split(FileUtil.APP_NAME);
            if(arr.length == 2){
                return arr[1].substring(1);
            }
            return "";

    }

    public static void downLoad( String url,String filePath, MediaType... mdiaTypes) throws FileNotFoundException, IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            headers.setAccept(Arrays.asList(mdiaTypes));
            headers.setContentType(MediaType.IMAGE_JPEG);

            ResponseEntity<byte[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<byte[]>(headers),
                    byte[].class);

            byte[] result = response.getBody();

            inputStream = new ByteArrayInputStream(result);

            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
