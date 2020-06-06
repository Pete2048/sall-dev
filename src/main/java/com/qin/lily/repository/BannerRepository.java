package com.qin.lily.repository;

import com.qin.lily.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: Pete
 * @date: Created in 2020/5/11 21:05
 * @modified By:
 */
public interface BannerRepository extends JpaRepository<Banner,Long> {

    Banner findOneById(Long id);

    Banner findOneByName(String name);
}
