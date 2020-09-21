package com.chs.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author : HongSheng.Chen
 * @date : 2020/9/21 16:22
 */
public class ImgTask implements Runnable {

    private String prefix;
    private String name;
    private String path;

    public ImgTask(String prefix, String name, String path) {
        this.prefix = prefix;
        this.name = name;
        this.path = path;
    }


    @Override
    public void run() {

        try {
            URL url = new URL(prefix + name);
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            String filename = path+name;
            File file = new File(filename);
            FileOutputStream os = new FileOutputStream(file, true);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

            // 完毕，关闭所有链接
            os.close();
            is.close();
            System.out.println(name + ":" + "已下载");
        } catch (Exception e) {
            //System.out.println(name + ":" + "无此图片");

        }
    }
}
