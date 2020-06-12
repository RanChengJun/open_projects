package com.robert.aop.controller;

import com.robert.aop.common.AjunLog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/t1/{name}/{id}")
    @AjunLog(f1 = "行走的Bug")
    public String apiTest(@PathVariable String name, @PathVariable String id) {
        System.out.println("姓名：" + name);
        System.out.println("ID：" + id);
        return "请求成功";
    }

    @RequestMapping("/t2")
    @AjunLog(f2 = "自己New个对象啊，费那心思")
    public String getGirlFriend(String girlName) {
        //这次终于可以光明正大写个Bug了
        System.out.println("你的对象（女盆友）名称：" + girlName);
        int i = 1 / 0;
        return "求爱成功";
    }

}
