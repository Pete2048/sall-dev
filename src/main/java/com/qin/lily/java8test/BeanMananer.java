package com.qin.lily.java8test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description:lamda表达式的使用,利用函数式接口处理对象
 * @author: Pete
 * @date: Created in 2020/6/1 15:43
 * @modified By:
 */
public class BeanMananer {
    /**
     *
     * @param list
     * @param p Predicate<T>函数式接口 T->Boolean
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }


}
