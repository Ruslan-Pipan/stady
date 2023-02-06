package com.study.study.query;

public class BollenExpresion {
    private final StringBuilder expresion;

    public BollenExpresion(String expresion) {
        this.expresion = new StringBuilder(expresion);
    }

    public String expresion(){
        return expresion.toString();
    }
}
