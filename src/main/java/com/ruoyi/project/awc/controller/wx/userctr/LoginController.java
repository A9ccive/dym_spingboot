package com.ruoyi.project.awc.controller.wx.userctr;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app/login")
@Api(value = "用户登陆模块")
@Slf4j
public class LoginController {

    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/name")
    public Map showName() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("user_name", name);
        return map;
    }



}
