package com.qin.lily.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @description:
 * @author: Pete
 * @date: Created in 2020/5/8 22:02
 * @modified By:
 */
@Entity
@Data
public class Banner extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String img;
    private String title;

    //默认懒加载 EAGER:急加载
    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name="bannerId")
    private List<BannerItem> Items;
}
