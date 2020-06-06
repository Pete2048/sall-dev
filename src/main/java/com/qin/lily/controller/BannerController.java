package com.qin.lily.controller;

import com.qin.lily.model.Banner;
import com.qin.lily.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * RestController 相当于当前类都是使用@ResponseBody返回的额
 *
 */
@RestController
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/name/{name}")
    public Banner getByName(@PathVariable @NotBlank String name) {

        return bannerService.getBannerByName(name);

    }
}
