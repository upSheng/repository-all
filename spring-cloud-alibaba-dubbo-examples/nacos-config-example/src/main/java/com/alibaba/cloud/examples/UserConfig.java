package com.alibaba.cloud.examples;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/4 17:55
 */
@ConfigurationProperties(prefix = "user")
class UserConfig {

    private int age;

    private String name;

    private String hr;

    private Map<String, Object> map;

    private List<User> users;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    @Override
    public String toString() {
        return "UserConfig{" + "age=" + age + ", name='" + name + '\'' + ", map=" + map
                + ", hr='" + hr + '\'' + ", users=" + users + '}';
    }

    public static class User {

        private String name;

        private String hr;

        private String avg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHr() {
            return hr;
        }

        public void setHr(String hr) {
            this.hr = hr;
        }

        public String getAvg() {
            return avg;
        }

        public void setAvg(String avg) {
            this.avg = avg;
        }

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + ", hr=" + hr + ", avg=" + avg + '}';
        }

    }

}
