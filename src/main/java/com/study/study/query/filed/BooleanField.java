package com.study.study.query.filed;

import com.study.study.query.BollenExpresion;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class BooleanField extends QFiled<Boolean>{

    public BooleanField(String name) {
        super(name);
    }

    @Override
    public BollenExpresion eq(Boolean o) {
        return null;
    }

    @Override
    public BollenExpresion and(Boolean aBoolean) {
        return null;
    }
}
