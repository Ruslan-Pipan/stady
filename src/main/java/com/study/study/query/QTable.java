package com.study.study.query;

public abstract class QTable<E> {
    protected final String tableName;

    protected QTable(String tableName) {
        this.tableName = tableName;
    }
}
