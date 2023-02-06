package com.study.study.query;


public class SelectQuery {
    private StringBuilder query;

    public SelectQuery(String query) {
        this.query = new StringBuilder(query);
    }

    public SelectQuery where(BollenExpresion bollenExpresion){
        query.append("WHERE ")
                .append(bollenExpresion.expresion());
        return this;
    }

    public SelectQuery from(QTable qTable){
        query.append(" FROM ")
                .append(qTable.tableName)
                .append(" ");
        return this;
    }

    public String fetch(){
        return query.toString();
    }
}
