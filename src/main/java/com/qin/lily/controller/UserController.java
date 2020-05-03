package com.qin.lily.controller;

import com.qin.lily.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * RestController 相当于当前类都是使用@ResponseBody返回的额
 *
 */
@RestController
public class UserController {
    @RequestMapping("/test")
    public  UserDTO test(HttpServletResponse response) {
        UserDTO userDTO = UserDTO.builder()
                .name("秦艽")
                .age("18")
                .sex("男")
                .build();
        return userDTO;
//        throw new Exception("哎呀，出错了！");
//        return "hello,秦艽123";

    }
}
