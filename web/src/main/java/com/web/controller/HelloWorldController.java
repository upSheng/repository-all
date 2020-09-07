package com.web.controller;

import com.web.element.Car;
import com.web.entity.Dog;
import com.web.modal.Response;
import com.web.service.impl.UserServiceImpl;
import com.web.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 */

@Slf4j
@RestController
public class HelloWorldController {
    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String home() {

        return "hello World!";
    }

    @RequestMapping("/data")
    public Dog dog() {

        Dog dog = new Dog();

        dog.setDate(new Date());
        return dog;
    }


    @GetMapping(value = "/test")
    public Response<Map<String, Object>> test() {

        Car car = ApplicationContextUtil.getBean(Car.class);
        car.sing();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "test");
        return new Response<>(map);
    }

//    @RequestMapping("/info")
//    public Map<String, Object> info() {
//
//
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Set<GrantedAuthority> authoritiesSet = (Set<GrantedAuthority>) userDetails.getAuthorities();
//        Set<String> roles = new HashSet<>();
//        authoritiesSet.forEach((x) -> roles.add(x.getAuthority()));
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("roles", roles);
//        map1.put("name", userDetails.getUsername());
//        map1.put("avatar", "avatar");
//        map1.put("introduction", "introduction");
//        map.put("data", map1);
//        return map;
//    }
//
//    @RequestMapping("/ignore/upload")
//    public Response upload(@RequestParam("file") MultipartFile file) {
//
//        String path = "d:/upload/" + "test";
//        String realPath = FileUploadUtil.upload(file, path);
//
//        return new Response(realPath);
//    }


}
