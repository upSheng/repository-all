package com.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/7 18:29
 */
@Component
public class UploadConfig {
    @Value("${uploadRootPath}")
    private String rootPath;

}
