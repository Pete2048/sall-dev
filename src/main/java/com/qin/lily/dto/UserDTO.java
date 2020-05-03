package com.qin.lily.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Builder使用这个注解后不能new ;并且需要与@Getter一起使用才能得到对应的值
 * 非要使用就得加上@NoArgsConstructor
 */
@Builder
@Getter
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String age;
    private String sex;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
