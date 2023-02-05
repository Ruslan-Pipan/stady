package com.study.study.api;

import com.study.study.bll.CompanyService;
import com.study.study.mdl.CompanyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<HttpStatus> createCompany(@RequestBody CompanyEntity companyEntity) {
        companyService.createCompany(companyEntity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
