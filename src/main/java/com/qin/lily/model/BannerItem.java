package com.qin.lily.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description:
 * @author: Pete
 * @date: Created in 2020/5/8 22:02
 * @modified By:
 */
@Entity
@Data
public class BannerItem {
    @Id
    private long id;
    private String name;
    private String description;
    private String img;
    private String title;

    private long bannerId;

}
