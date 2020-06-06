package com.qin.lily.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qin.lily.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:序列化与反序列化
 * @author: Pete
 * @date: Created in 2020/5/25 20:54
 * @modified By:
 */
public class GenericAndJson {
    public static ObjectMapper mapper;
    @Autowired
    public static void setMapper(ObjectMapper mapper) {
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o){
        try {
            return GenericAndJson.mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new HttpException();
        }

    }
    public static <T> T jsonToObject(String s,TypeReference<T> tr){
        if (s == null ){
            return null;
        }
        T t = null;
        try {
            t = GenericAndJson.mapper.readValue(s, tr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     *
     * @param s
     * @param <T>
     * @return 返回中list对象不能映射到对象只是hashmap类型
     */
    public static <T> List<T> jsonToList(String s){
        if (s == null ){
            return null;
        }
        List<T> list = null;
        try {
            list = GenericAndJson.mapper.readValue(s, new TypeReference<List<T>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;

    }
}
