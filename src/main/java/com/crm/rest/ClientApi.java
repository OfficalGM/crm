package com.crm.rest;

import com.crm.core.usecase.DeleteClientService;
import com.crm.core.usecase.GetClientService;
import com.crm.core.usecase.ModifyClientService;
import com.crm.core.usecase.StoreClientService;
import com.crm.core.vo.Client;
import com.crm.core.vo.CreateClientParam;
import com.crm.core.vo.ModifyClientParam;
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
public class ClientApi {

    private final GetClientService getClientService;

    private final StoreClientService storeClientService;

    private final DeleteClientService deleteClientService;

    private final ModifyClientService modifyClientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> view() {
        log.debug("view()");
        List<Client> companyList = getClientService.obtainAll();
        return ResponseEntity.ok(companyList);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class CreateClientReq {

        private Long companyId;

        private String name;

        private String email;

        private String phone;

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

    @PostMapping("/client")
    public ResponseEntity<ResInfo> create(@RequestBody final CreateClientReq req) {
        log.debug("create() req={}", req);
        final boolean result = storeClientService.create(toCreateClientParam(req));
        log.debug("create() result={}", result);
        return ResponseEntity.ok(ResInfo.builder()
                .result(result)
                .build());
    }

    private CreateClientParam toCreateClientParam(CreateClientReq req) {
        return CreateClientParam.builder()
                .companyId(req.getCompanyId())
                .name(req.getName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .createdBy(req.getCreatedBy())
                .updatedBy(req.getUpdatedBy())
                .build();
    }

    @ApiOperation(value = "insert Mutiple client", notes = "insert Mutiple client object")
    @PostMapping("/clients")
    public ResponseEntity<ResInfo> create(@RequestBody final List<CreateClientReq> reqList) {
        log.debug("create() reqList={}", reqList);
        final List<CreateClientParam> paramList = reqList.stream().map(this::toCreateClientParam).collect(Collectors.toList());
        boolean result = storeClientService.create(paramList);
        log.debug("create() result={}", result);
        return ResponseEntity.ok(ResInfo.builder()
                .result(result)
                .build());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    static class ModifyClientReq {

        private Long id;

        private Long companyId;

        private String name;

        private String email;

        private String phone;

        private String updatedBy;
    }

    @PutMapping(value = "client")
    public ResponseEntity<ResInfo> modify(@RequestBody final ModifyClientReq req) {
        log.debug("modify() req={}", req);
        final ModifyClientParam param = ModifyClientParam.builder()
                .id(req.getId())
                .companyId(req.getCompanyId())
                .name(req.getName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .updatedBy(req.getUpdatedBy())
                .build();
        final boolean result = modifyClientService.modify(param);
        log.debug("modify() result={}", result);
        return ResponseEntity.ok(ResInfo.builder()
                .result(result)
                .build());
    }

    @DeleteMapping(value = "client/{id}")
    public ResponseEntity<ResInfo> delete(@PathVariable Long id) {
        log.debug("delete() id={}", id);
        final boolean result = deleteClientService.delete(id);
        log.debug("delete() result={}", result);
        return ResponseEntity.ok(ResInfo.builder()
                .result(result)
                .build());
    }

}
