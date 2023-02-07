package com.study.study.query.filed;

import com.study.study.query.BollenExpression;

public abstract class QFiled<E> {
    public final String name;
    public final String tableName;

    protected QFiled(String name, String tableName) {
        this.name = name;
        this.tableName = tableName;
    }

    public abstract BollenExpression eq(E e);
    public abstract BollenExpression and(E e);
}
