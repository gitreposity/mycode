package com.example.project.controller;

import com.example.project.dao.UserMapper;
import com.example.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guodq
 * @create 2018-11-02 下午5:55
 */
@RestController
public class LoginController {


    @Autowired
    UserMapper userMapper;

    @RequestMapping("/uuuu/{name}")
    public User login(@PathVariable String name){
        if (name == null){
            return null;
        }
        User user = userMapper.selectUserByName(name);
        if (null != user){
            System.out.println("nick login");
            return user;
        }else {
            System.out.println("login error");
            return new User();
        }
    }
}
