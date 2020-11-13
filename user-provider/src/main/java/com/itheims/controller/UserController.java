package com.itheims.controller;

import com.itheims.pojo.User;
import com.itheims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping(value = "/findById/{id}")
    public User findById(@PathVariable(value = "id")Integer id){
            User userServiceById = userService.findById(id);
            return userServiceById;
    }
}
