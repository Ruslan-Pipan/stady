package com.study.study.api;

import com.study.study.bll.ICrudManager;
import com.study.study.bll.ServiceManager;
import com.study.study.mdl.hiber.TCompany;
import com.study.study.mdl.hiber.TService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company/{companyId}/service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceManager serviceManager;

    @GetMapping("/{serviceId}")
    public ResponseEntity<TService> get(@PathVariable Integer companyId, @PathVariable Integer serviceId) {
        TService serviceDto = TService.builder().id(serviceId)
                .company(TCompany.builder().id(companyId).build())
                .build();
        return ResponseEntity.ok(serviceManager.get(serviceDto));
    }
}
