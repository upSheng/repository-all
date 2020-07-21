package com.web.util;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/7 17:58
 */
public class FileUploadUtil {


    public static String upload(MultipartFile file, String path) {


        InputStream inputStream = null;
        OutputStream outputStream = null;
        String realPath="";
        try {
            inputStream = file.getInputStream();

            String fileName = file.getOriginalFilename();

            realPath = path + File.separator + fileName;
            File targetFile = new File(realPath);

            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }

            outputStream = new FileOutputStream(targetFile);
            FileCopyUtils.copy(inputStream, outputStream);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return realPath;
    }

}
