package com.study.study.api;

import com.study.study.bll.AbstractCrudService;
import com.study.study.mdl.ServiceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController extends AbstractCrudController<ServiceEntity> implements CrudController<ServiceEntity>{
    private final AbstractCrudService<ServiceEntity> crudService;

    @Override
    public AbstractCrudService<ServiceEntity> crudService() {
        return crudService;
    }

    @Override
    @PostMapping
    public ResponseEntity<ServiceEntity> create(@RequestBody ServiceEntity obj) {
        return super.create(obj);
    }

    @Override
    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceEntity> update(@PathVariable Integer serviceId,
                                                @RequestBody ServiceEntity serviceEntity) {
        return super.update(serviceEntity.id(serviceId));
    }

    @Override
    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceEntity> get(@PathVariable Integer serviceId) {
        return super.get(new ServiceEntity().id(serviceId));
    }

    @Override
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<HttpStatus> deactivate(@PathVariable Integer serviceId) {
        return super.deactivate(new ServiceEntity().id(serviceId));
    }
}
