package com.study.study.api;

import com.study.study.bll.ICrudManager;
import com.study.study.mdl.hiber.TPerson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends CrudController<TPerson, Integer> {
    public PersonController(ICrudManager<TPerson> crudManager) {
        super(crudManager, TPerson.class);
    }
}
