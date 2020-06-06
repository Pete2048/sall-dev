package com.qin.lily.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @description:自定义注解校验两次输入的密码
 * @author: Pete
 * @date: Created in 2020/5/7 21:17
 * @modified By:
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)//注解关联的校验类(可以是多个)
public @interface PasswordEqual {
    int min() default 4;
    int max() default 8;
    String message() default "password are not equal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
