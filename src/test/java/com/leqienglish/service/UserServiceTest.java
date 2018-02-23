//package com.leqienglish.service;
//
//import com.leqienglish.service.impl.UserService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * Created by zhuqing on 2017/7/22.
// */
//public class UserServiceTest {
//    private ApplicationContext applicationContext;
//    @Autowired
//    private  UserService userService;
//
//    @Before
//    public void setUp() throws Exception {
//        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");//加载spring配置文件
//        userService = (UserService) applicationContext.getBean("userService");//在这里导入要测试的
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//    @Test
//    public void insert() throws Exception {
////        User user = new User();
////        user.setName("vidky1");
////        user.setCreateDate(System.currentTimeMillis());
////        user.setUpdateDate(System.currentTimeMillis());
////        user.setPassword("1");
////        user.setEmail("123@163.com");
////        Long id = userService.addUser(user);
////        System.out.println(id);
////        assert (id == 3);
//
//    }
//}