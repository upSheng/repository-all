package com.chs.springSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Application {

    public static void main(String[] args) {
//        ClassPathResource resource  = new ClassPathResource("spring.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//
//        reader.loadBeanDefinitions(resource);
//
//        MyTestBean bean = factory.getBean(MyTestBean.class);
//        System.out.println(bean.toString());


        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        MyTestBean bean = ac.getBean(MyTestBean.class);
        System.out.println(bean.toString());


//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
//        MyTestBean bean = bf.getBean(MyTestBean.class);
//        System.out.println(bean.toString());

    }
}
