package com.study.study.api;

import com.study.study.bll.CrudManager;
import com.study.study.bll.ICrudManager;
import com.study.study.mdl.hiber.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController extends CrudController<TCompany, Integer>{
    private final ICrudManager<TCompany> crudManager;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public CompanyController(CrudManager<TCompany> crudManager) {
        super(crudManager, TCompany.class);
        this.crudManager = crudManager;
    }


    @PostMapping("/file")
    @Transactional
    public ResponseEntity<HttpStatus> test(){
        for (int i = 0; i < 10; i++) {
            TCompany company = TCompany.builder()
                    .companyName("Company 1")
                    .build();
            entityManager.persist(company);

            TPerson person = TPerson.builder()
                    .firstName("FirsName")
                    .lastName("LastName")
                    .build();
            entityManager.persist(person);

            TUser user = TUser.builder()
                    .company(company)
                    .email("email")
                    .password("password")
                    .person(person)
                    .build();
            entityManager.persist(user);

            TRole roleOne = TRole.builder()
                    .roleName("RoleOne")
                    .users(List.of(user))
                    .build();
            entityManager.persist(roleOne);

            TRole rolTwo = TRole.builder()
                    .roleName("rolTwo")
                    .users(List.of(user))
                    .build();
            entityManager.persist(rolTwo);

            TAddress addressOne = TAddress.builder()
                    .countryCode("UA")
                    .zipCode("zipCode")
                    .person(person)
                    .build();
            entityManager.persist(addressOne);

            TAddress addressTwo = TAddress.builder()
                    .countryCode("UA")
                    .zipCode("zipCode")
                    .person(person)
                    .build();
            entityManager.persist(addressTwo);

            TService service = TService.builder()
                    .serviceName("serviceName")
                    .company(company)
                    .users(List.of(user))
                    .build();
            entityManager.persist(service);

        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
