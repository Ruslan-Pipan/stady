package com.study.study.query;

import com.study.study.query.filed.QFiled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QueryFactory {

    public SelectQuery select(QTable qTable){
        return new SelectQuery("SELECT * FROM " + qTable.tableName + " ");
    }

    public SelectQuery select(QFiled... qFields){
        List<String> listFiled = Arrays.stream(qFields)
                .map(q -> q.name).toList();

        return new SelectQuery("SELECT " + String.join(", ", listFiled));
    }
}
