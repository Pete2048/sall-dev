package com.qin.lily.service;

import com.qin.lily.model.Banner;
import com.qin.lily.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Pete
 * @date: Created in 2020/5/11 21:03
 * @modified By:
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public Banner getBannerByName(String name) {
        return bannerRepository.findOneByName(name);
    }
}
