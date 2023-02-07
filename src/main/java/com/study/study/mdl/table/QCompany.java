package com.study.study.mdl.table;

import com.study.study.mdl.CompanyEntity;
import com.study.study.query.filed.BooleanField;
import com.study.study.query.filed.NumberFiled;
import com.study.study.query.QTable;
import com.study.study.query.filed.StringFiled;

public class QCompany extends QTable<CompanyEntity> {
    private static final String tableName = "TCompany";

    public QCompany(){
        super(tableName);
    }

    public static final NumberFiled id = new NumberFiled("id", tableName);
    public static final StringFiled name = new StringFiled("name", tableName);
    public static final BooleanField scheduled = new BooleanField("scheduled", tableName);
    public static final NumberFiled delay = new NumberFiled("delay", tableName);
    public static final StringFiled period = new StringFiled("period", tableName);
    public static final StringFiled status = new StringFiled("status", tableName);

}
