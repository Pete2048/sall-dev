package com.qin.lily.dto;

import com.qin.lily.validators.PasswordEqual;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

/**
 * Builder使用这个注解后不能new ;并且需要与@Getter一起使用才能得到对应的值
 * 非要使用就得加上@NoArgsConstructor
 * valid级联校验使用(开启校验使用validated)
 */
@Builder
@Getter
@PasswordEqual(min = 2)
public class UserDTO {

    private String name;
    private String age;
    @Length(min = 1,max = 4,message = "男或者女")
    private String sex;

    private String password1;
    private String password2;

    @Valid
    private DeptDto deptDto;

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
