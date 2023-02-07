package com.study.study.query.filed;

import com.study.study.query.BollenExpression;
import lombok.Getter;
import lombok.experimental.Accessors;


@Accessors(fluent = true)
@Getter
public class NumberFiled extends QFiled<Number>{
    public NumberFiled(String name, String tableName) {
        super(name, tableName);
    }

    @Override
    public BollenExpression eq(Number number) {
        return new BollenExpression(tableName + "." + name + "=" + number);
    }

    @Override
    public BollenExpression and(Number number) {
        return null;
    }
}
