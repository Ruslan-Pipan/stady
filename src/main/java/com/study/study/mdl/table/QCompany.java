package com.study.study.mdl.table;

import com.study.study.mdl.CompanyEntity;
import com.study.study.query.filed.BooleanField;
import com.study.study.query.filed.NumberFiled;
import com.study.study.query.QTable;
import com.study.study.query.filed.StringFiled;

public class QCompany extends QTable<CompanyEntity> {

    public QCompany(){
        super("TCompany");
    }

    public static final NumberFiled id = new NumberFiled("id");
    public static final StringFiled name = new StringFiled("name");
    public static final BooleanField scheduled = new BooleanField("scheduled");
    public static final NumberFiled delay = new NumberFiled("delay");
    public static final StringFiled period = new StringFiled("period");
    public static final StringFiled status = new StringFiled("status");

}
