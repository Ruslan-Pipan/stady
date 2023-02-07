package com.study.study.query;

public class BollenExpression {
    private final StringBuilder expression;

    public BollenExpression(String expression) {
        this.expression = new StringBuilder(expression);
    }

    public String expression(){
        return expression.toString();
    }
}
