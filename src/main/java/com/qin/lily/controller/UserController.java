package com.qin.lily.controller;

import com.qin.lily.dto.UserDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * RestController 相当于当前类都是使用@ResponseBody返回的额
 *
 */
@RestController
@Validated
public class UserController {
    @RequestMapping("/test/{age}")
    public  UserDTO test(@PathVariable @Range(min = 1,max = 10,message ="不可以超过10岁" ) int age,
                         @RequestParam @Length(min = 4,max = 6,message = "不能超过3个汉子") String name,
                         @RequestBody @Validated UserDTO user) {
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
