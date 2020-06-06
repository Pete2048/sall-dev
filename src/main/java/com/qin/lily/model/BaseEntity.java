package com.qin.lily.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * @description:实体共有基础属性
 * @author: Pete
 * @date: Created in 2020/5/12 21:25
 * @modified By:
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @JsonIgnore
    private Data creatDate;
    private Data updateDate;
    private Data deleteDate;
}
