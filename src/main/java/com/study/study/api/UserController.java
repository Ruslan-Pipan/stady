package com.study.study.api;

import com.study.study.bll.ICrudManager;
import com.study.study.mdl.hiber.TCompany;
import com.study.study.mdl.hiber.TUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{companyId}/user")
public class UserController extends CrudController<TUser, Integer>{
    private final ICrudManager<TUser> crudManager;

    public UserController(ICrudManager<TUser> crudManager) {
        super(crudManager, TUser.class);
        this.crudManager = crudManager;
    }

    @PostMapping
    ResponseEntity<TUser> add(@RequestBody TUser userDto, @PathVariable Integer companyId){
        userDto = userDto.company(new TCompany().id(companyId));
        return ResponseEntity.ok(crudManager.add(userDto, TCompany.class));
    }

    @PutMapping("/{id}")
    ResponseEntity<TUser> update(@PathVariable Integer id, @RequestBody TUser userDto, @PathVariable String companyId){
        return ResponseEntity.ok(crudManager.update(userDto.id(id)));
    }
}
