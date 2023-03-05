package com.study.study.api;

import com.study.study.bll.CrudManager;
import com.study.study.bll.ICrudManager;
import com.study.study.mdl.hiber.TCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController extends CrudController<TCompany, Integer>{
    private final ICrudManager<TCompany> crudManager;

    @Autowired
    public CompanyController(CrudManager<TCompany> crudManager) {
        super(crudManager, TCompany.class);
        this.crudManager = crudManager;
    }
}
