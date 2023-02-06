package com.study.study.query.filed;

import com.study.study.query.BollenExpresion;
import lombok.Getter;
import lombok.experimental.Accessors;


@Accessors(fluent = true)
@Getter
public class NumberFiled extends QFiled<Number>{
    public NumberFiled(String name) {
        super(name);
    }

    @Override
    public BollenExpresion eq(Number number) {
        return new BollenExpresion(name + "=" + number);
    }

    @Override
    public BollenExpresion and(Number number) {
        return null;
    }
}
