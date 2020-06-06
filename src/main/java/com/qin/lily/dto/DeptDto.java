package com.qin.lily.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * @description:
 * @author: Pete
 * @date: Created in 2020/5/7 21:06
 * @modified By:
 */
@Getter
@Setter
public class DeptDto {
    @Length(max = 4,message = "部门名字太长")
    private String deptName;
}
