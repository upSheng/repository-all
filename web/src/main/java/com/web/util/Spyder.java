package com.web.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.web.entity.Illustration;
import com.web.entity.Property;
import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/21 10:57
 */
public class Spyder {

    public static void main(String[] args) throws Exception {

        File file = ResourceUtils.getFile("classpath:data.json");
        String s = FileUtils.readFileToString(file, "utf-8");
        JSONObject data = JSONObject.parseObject(s);


        Map<String, String> wd = wd();


        List<Illustration> illustrationList = new ArrayList<>();

        for(String key :data.keySet()){
            JSONObject item = (JSONObject) data.get(key);

            Illustration illustration = new Illustration();
            illustration.setType(wd.get(item.getString("typeid")));
            illustration.setImage(item.getString("thumb").substring(2));
            illustration.setName(item.getString("title"));

            List<Property> properties = new ArrayList<>();
            JSONObject shuxing = item.getJSONObject("shuxing");
            for (String title : shuxing.keySet()){
                Property property = new Property();
                property.setTitle(wd.get(title));
                property.setDescription(shuxing.getString(title));
                properties.add(property);

            }
            illustration.setProperties(properties);
            illustrationList.add(illustration);
        }

        //System.out.println(illustrationList);
        //System.out.println(data);

        String a = JSONObject.toJSONString(illustrationList);
        System.out.println(a);

        File data1 = new File("d:/data1.json");
        FileUtils.writeStringToFile(data1,a, StandardCharsets.UTF_8,false);

    }


    /**
     * 获取维度
     * @return
     * @throws Exception
     */
    private static   Map<String,String> wd () throws Exception {
        File file = ResourceUtils.getFile("classpath:wd.json");
        String s = FileUtils.readFileToString(file, "utf-8");
        JSONObject data = JSONObject.parseObject(s);


        Map<String,String> result = new HashMap<>();
        for(String key :data.keySet()){
            JSONObject item = (JSONObject) data.get(key);
            for (String key1 :item.keySet()){
                result.put(key1,item.getString(key1));
            }
        }
        result.put("1","宠物");
        result.put("2","武器");
        result.put("3","防具");
        result.put("4","食物");
        result.put("5","材料");
        return result;
    }
}
