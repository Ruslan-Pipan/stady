package com.study.study.api.hiber;

import com.study.study.bll.hiber.ICrudManager;
import com.study.study.mdl.hiber.TUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<TUser, Integer>{
    private final ICrudManager<TUser> crudManager;

    public UserController(ICrudManager<TUser> crudManager) {
        super(crudManager, TUser.class);
        this.crudManager = crudManager;
    }

    @PostMapping
    ResponseEntity<TUser> add(@RequestBody TUser userDto){
        return ResponseEntity.ok(crudManager.add(userDto));
    }

    @PutMapping("/{id}")
    ResponseEntity<TUser> update(@PathVariable Integer id, @RequestBody TUser userDto){
        return ResponseEntity.ok(crudManager.update(userDto.id(id)));
    }
}
