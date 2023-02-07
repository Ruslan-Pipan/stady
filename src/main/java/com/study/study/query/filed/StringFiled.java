package com.study.study.query.filed;

import com.study.study.query.BollenExpression;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class StringFiled extends QFiled<String>{
    public StringFiled(String name, String tableName) {
        super(name, tableName);
    }

    @Override
    public BollenExpression eq(String s) {
        return null;
    }

    @Override
    public BollenExpression and(String s) {
        return null;
    }
}
