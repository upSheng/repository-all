package com.chs.activity.element;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.Date;

@Component
public class OssElement {


    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    public String upload(MultipartFile file) {

        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String bucketName = "steamhy";
        String objectName = "abc/"+file.getOriginalFilename();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String url = "";
        try {
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(file.getBytes()));
            ossClient.shutdown();
            url = ossClient.generatePresignedUrl(bucketName, objectName, new Date(System.currentTimeMillis()+1000L*60*60)).toString();
            System.out.println(url);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return url;
    }

    public String fileUrl(String name) {

        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String bucketName = "steamhy";
        String objectName = "abc/"+name+".exe";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String url = "";
        try {
            url = ossClient.generatePresignedUrl(bucketName, objectName, new Date(System.currentTimeMillis()+1000L*60*60)).toString();
            System.out.println(url);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return url;
    }
}
