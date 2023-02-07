package com.study.study.mdl.table;

import com.study.study.mdl.ServiceEntity;
import com.study.study.query.QTable;
import com.study.study.query.filed.NumberFiled;
import com.study.study.query.filed.StringFiled;

public class QService extends QTable<ServiceEntity> {
    private final static String tableName = "TService";
    public QService() {
        super(tableName);
    }

    public static final NumberFiled companyId = new NumberFiled("companyId", tableName);
    public static final StringFiled serviceName = new StringFiled("serviceName", tableName);
}
