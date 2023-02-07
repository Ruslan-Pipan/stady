package com.study.study.query;

import com.study.study.query.filed.QFiled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryFactory {

    public SelectQuery select(QTable qTable){
        return new SelectQuery("SELECT * FROM " + qTable.tableName + " ");
    }

    public SelectQuery select(QFiled... qFields){
        String conditional = Arrays.stream(qFields)
                .map(q -> q.tableName + "." + q.name)
                .collect(Collectors.joining(", "));

        return new SelectQuery("SELECT " + conditional + " ");
    }
}
