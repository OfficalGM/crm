package com.crm.rest;

import com.crm.core.usecase.GetCompanyService;
import com.crm.core.usecase.StoreCompanyService;
import com.crm.core.vo.Company;
import com.crm.core.vo.CreateCompanyParam;
import io.swagger.annotations.ApiOperation;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CompanyApi {

    private final GetCompanyService getCompanyService;

    private final StoreCompanyService storeCompanyService;

    @GetMapping("/companys")
    public ResponseEntity<List<Company>> view() {
        log.debug("view()");
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

        private String createdBy;

        private String updatedBy;
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
        final boolean result = storeCompanyService.create(CreateCompanyParam.builder()
                .address(req.getAddress())
                .name(req.getName())
                .createdBy(req.getCreatedBy())
                .updatedBy(req.getUpdatedBy())
                .build());
        log.debug("create() result={}", result);
        return ResponseEntity.ok(ResInfo.builder()
                .result(result)
                .build());
    }

    @ApiOperation(value = "insert Mutiple company", notes = "insert Mutiple company object")
    @PostMapping("/companys")
    public ResponseEntity<ResInfo> create(@RequestBody final List<CreateReq> reqList) {
        log.debug("create() reqList={}", reqList);
        final List<CreateCompanyParam> paramList = reqList.stream().map(req -> {
            return CreateCompanyParam
                    .builder()
                    .address(req.getAddress())
                    .name(req.getName())
                    .createdBy(req.getCreatedBy())
                    .build();
        }).collect(Collectors.toList());
        boolean result = storeCompanyService.create(paramList);
        log.debug("create() result={}", result);
        return ResponseEntity.ok(ResInfo.builder()
                .result(result)
                .build());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class UpdateReq {

        private Long id;

        private String name;

        private String address;

        private String updatedBy;
    }

    @PutMapping(value = "company")
    public ResponseEntity<ResInfo> modify(@RequestBody final UpdateReq req) {
        log.debug("modify() req={}", req);
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
