package com.study.study.query.filed;

import com.study.study.query.BollenExpresion;

public abstract class QFiled<E> {
    public final String name;

    protected QFiled(String name) {
        this.name = name;
    }

    public abstract BollenExpresion eq(E e);
    public abstract BollenExpresion and(E e);
}
