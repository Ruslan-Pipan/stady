package com.study.study.query;


import com.study.study.query.filed.QFiled;

public class SelectQuery {
    private StringBuilder query;

    public SelectQuery(String query) {
        this.query = new StringBuilder(query);
    }

    public SelectQuery where(BollenExpression bollenExpression){
        query.append("WHERE ")
                .append(bollenExpression.expression())
                .append(" ");
        return this;
    }

    public SelectQuery from(QTable qTable){
        query.append("FROM ")
                .append(qTable.tableName)
                .append(" ");
        return this;
    }

    public SelectQuery innerJoin(QTable qTable){
        query.append("INNER JOIN ")
                .append(qTable.tableName)
                .append(" ");
        return this;
    }

    public SelectQuery on(QFiled from, QFiled to){
        query.append("ON ")
                .append(from.tableName).append(".").append(from.name)
                .append(" = ")
                .append(to.tableName).append(".").append(to.name)
                .append(" ");
        return this;
    }

    public String fetch(){
        return query.toString();
    }
}
