package xyz.tobebetter.util;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by zhuleqi on 2018/11/8.
 */
public class WebFileUtil {

    /**
     * 文件下载
     *
     * @param filePath
     * @param request
     * @param response
     * @throws Exception
     */
    public static void download(String filePath, String fileFileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (filePath == null) {
            return;
        }

        //.
        //设置响应头和客户端保存文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
//        response.addHeader("file-content-length", downloadedLength+"");
//            response.addIntHeader("Content-Length", downloadedLength);
        //    headers.setContentDispositionFormData("attachment", fileName);
        response.addHeader("Content-Disposition", "attachment;fileName="+fileFileName );
        // headers = new Header
        //通知浏览器以attachment（下载方式）
        //  headers.setContentDispositionFormData("attachment", downlaodFilename);
        //二进制流数据
        //   headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //用于记录以完成的下载的数据量，单位是byte
        int downloadedLength = 0;

        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(filePath);
            response.setContentLength(inputStream.available());
            //激活下载操作
            OutputStream os = response.getOutputStream();
            // System.err.print(inputStream.available());
            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
                downloadedLength +=length;
            }



            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e) {

            throw e;
        }
    }

    /**
     * 文件下载
     *
     * @param filePath
     * @param request
     * @param response
     * @throws Exception
     */
    public static void download(String filePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (filePath == null) {
            return;
        }


        File file = new File(filePath);
        if(!file.exists()){
            throw new Exception("文件不存在");
        }

        download(filePath,file.getName(),request,response);
    }

    /**
     * 文件下载
     *
     * @param filePath
     * @param request
     * @param response
     * @throws Exception
     */
    public static ResponseEntity<byte[]> downloadFile(String filePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (filePath == null) {
            return null;
        }


        File file = new File(filePath);
        HttpHeaders headers = new HttpHeaders();

        try {
            //下载显示的文件名，解决文件乱码问题
            String downlaodFilename = URLEncoder.encode("leqi.apk"); //new String(filename.getBytes("UTF-8"), "iso-8859-1");

            //通知浏览器以attachment（下载方式）
            headers.setContentDispositionFormData("attachment", downlaodFilename);
            //二进制流数据
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            System.out.println("-11111");
            response.setHeader("Content-Disposition", "attachment;fileName="
                    + downlaodFilename);
            return new ResponseEntity<byte []>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
