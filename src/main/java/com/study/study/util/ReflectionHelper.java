package com.study.study.util;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Service
public class ReflectionHelper {

    public static Field getIdField(Class<?> classes){
        return Arrays.stream(classes.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The persistent entity has to be annotated with @Id."));
    }

    public static Constructor<?> getNoArgumentConstrictor(Class<?> classes){
        return Arrays.stream(classes.getConstructors()).filter(c -> c.getParameterCount() == 0)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public static Method getMethod(Class<?> type, String filedName){
        try {
            return type.getDeclaredMethod("get" + filedName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static Method setMethod(Class<?> type, String filedName, Class<?> typeParam){
        try {
            return type.getDeclaredMethod("set" + filedName, typeParam);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static Method getMethod(Class<?> classes, Field field){
        try {
            return classes.getDeclaredMethod("get" + StringUtils.capitalize(field.getName()));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static Method setMethod(Class<?> classes, Field field){
        try {
            return classes.getDeclaredMethod("set" + StringUtils.capitalize(field.getName()), field.getType());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static String formatTableClassName(Class<?> type){
        String refClassName = type.getSimpleName();
        return refClassName.substring(1);
    }

}
