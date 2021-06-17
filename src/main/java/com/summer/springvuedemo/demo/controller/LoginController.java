package com.summer.springvuedemo.demo.controller;

import com.summer.springvuedemo.demo.dao.UserDao;
import com.summer.springvuedemo.demo.entity.User;
import com.summer.springvuedemo.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public R login(@RequestBody User user){//User类里面的属性名要和前端给的数据名一样，以自动匹配
        String flag="error";
        User us= userDao.getUserByMessage(user.getUserName(),user.getPassword());
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        System.out.println("user:" + us);
        if(us!=null){
            flag="ok";
        }
        return R.ok().put("user",user).put("flag",flag);
    }
}
