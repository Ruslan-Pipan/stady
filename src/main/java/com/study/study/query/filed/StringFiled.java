package com.study.study.query.filed;

import com.study.study.query.BollenExpresion;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class StringFiled extends QFiled<String>{
    public StringFiled(String name) {
        super(name);
    }

    @Override
    public BollenExpresion eq(String s) {
        return null;
    }

    @Override
    public BollenExpresion and(String s) {
        return null;
    }
}
