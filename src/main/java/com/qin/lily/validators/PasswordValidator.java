package com.qin.lily.validators;

import com.qin.lily.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @author: Pete
 * @date: Created in 2020/5/7 21:23
 * @modified By:
 * 第二个参数 :自定义注解修饰的目标的类型(如果是在属性上也对应其类型(String))
 */
public class PasswordValidator implements ConstraintValidator<PasswordEqual, UserDTO> {
    private  int min;
    private  int max;
    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        String password1 = userDTO.getPassword1();
        String password2 = userDTO.getPassword2();
        //写自己的判断逻辑...
        boolean match = password1.equals(password2);
        if(password1.length()<min){
            match = false;
        }
        return match;
    }


}
