package com.study.study.query.filed;

import com.study.study.query.BollenExpression;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class BooleanField extends QFiled<Boolean>{

    public BooleanField(String name, String tableName) {
        super(name, tableName);
    }

    @Override
    public BollenExpression eq(Boolean o) {
        return null;
    }

    @Override
    public BollenExpression and(Boolean aBoolean) {
        return null;
    }
}
