package com.accp.newmoon.controller;


import com.accp.newmoon.common.lang.Result;
import com.accp.newmoon.entity.User;
import com.accp.newmoon.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-11-02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userservice;

//    @RequestMapping("/user")
    @RequiresAuthentication
    @GetMapping("index")
    public Result index(){
        User user = userservice.getById(1L);
        return Result.success(user);
    }
    @PostMapping("save")
    public Result save(@Validated @RequestBody User user){
        return Result.success(user);
    }
}
