package com.study.study.mdl.table;

import com.study.study.mdl.ServiceEntity;
import com.study.study.query.QTable;

public class QService extends QTable<ServiceEntity> {
    public QService() {
        super("TService");
    }
}
