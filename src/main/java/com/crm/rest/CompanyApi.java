package com.crm.rest;

import com.crm.core.usecase.GetCompanyService;
import com.crm.core.vo.Company;
import io.swagger.annotations.ApiOperation;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CompanyApi {

    private final GetCompanyService getCompanyService;

    @GetMapping("/companys")
    public ResponseEntity<List<Company>> obtainAll() {
        log.debug("obtainAll()");
        List<Company> companyList = getCompanyService.obtainAll();
        return ResponseEntity.ok(companyList);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class CreateReq {

        private String name;

        private String address;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class ResInfo {
        boolean result;
    }

    @PostMapping("/company")
    public ResponseEntity<ResInfo> create(@RequestBody final CreateReq req) {
        log.debug("create() req={}", req);
        //TODO create one
        return null;
    }

    @ApiOperation(value = "insert Mutiple company", notes = "insert Mutiple company object")
    @PostMapping("/companys")
    public ResponseEntity<ResInfo> create(@RequestBody final List<CreateReq> reqList) {
        log.debug("create() reqList={}", reqList);
        //TODO create one
        return null;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class UpdateReq {

        private Long id;

        private String name;

        private String address;
    }

    @PutMapping(value = "company")
    public ResponseEntity<ResInfo> update(@RequestBody final UpdateReq req) {
        log.debug("update() req={}", req);
        //TODO update one
        return null;
    }

    @DeleteMapping(value = "company/{id}")
    public ResponseEntity<ResInfo> delete(@PathVariable Long id) {
        log.debug("delete() id={}", id);
        //TODO delete one
        return null;
    }

}
