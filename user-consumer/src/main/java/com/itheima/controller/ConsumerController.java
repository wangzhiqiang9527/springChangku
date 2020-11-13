package com.itheima.controller;

import com.itheima.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "consumer")
@DefaultProperties(defaultFallback = "fallBack")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand
    @GetMapping
    public User findById(){
        /**
        //通过服务名字获取服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        //获取服务
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        URI uri = serviceInstance.getUri();
        String url = "http://"+host+":"+port+"/user/findById/2";
         */
        String url = "http://user-provider/user/findById/2";
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
    public User fallBack(){
        User user = new User();
        user.setUsername("系统繁忙");
        return user;
    }
}

