package com.web.controller;

import com.web.modal.Response;
import com.web.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

//    @RequestMapping("/")
//    public String home() {
//
//        return "hello World!";
//    }


    @RequestMapping(value = "/test11", method = RequestMethod.GET)
    public Response<Map<String, Object>> testaa() throws Exception {

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
