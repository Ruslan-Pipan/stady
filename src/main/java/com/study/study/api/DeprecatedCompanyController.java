package com.study.study.api;

import com.study.study.bll.AbstractCrudService;
import com.study.study.mdl.CompanyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class DeprecatedCompanyController extends AbstractCrudController<CompanyEntity> implements CrudController<CompanyEntity>{
    private final AbstractCrudService<CompanyEntity> companyService;

    @Override
    @PostMapping
    public ResponseEntity<CompanyEntity> create(@RequestBody CompanyEntity companyEntity) {
        return super.create(companyEntity);
    }

    @Override
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyEntity> get(@PathVariable Integer companyId){
        return super.get(new CompanyEntity().id(companyId));
    }

    @Override
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyEntity> update(@PathVariable Integer companyId,
                                                @RequestBody CompanyEntity companyEntity){
        return super.update(companyEntity.id(companyId));
    }

    @Override
    @DeleteMapping("/{companyId}")
    public ResponseEntity<HttpStatus> deactivate(@PathVariable Integer companyId){
        return super.deactivate(new CompanyEntity().id(companyId));
    }

    @Override
    public AbstractCrudService<CompanyEntity> crudService() {
        return companyService;
    }
}
