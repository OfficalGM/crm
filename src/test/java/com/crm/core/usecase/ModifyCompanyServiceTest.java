package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.core.vo.ModifyParam;
import com.crm.port.ModifyPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ModifyCompanyServiceTest {

    ModifyCompanyService modifyCompanyService;

    public void initFakeService() {
        modifyCompanyService = new ModifyCompanyService(new ModifyPort<Company>() {
            @Override
            public long update(Company company) {
                return 0;
            }
        });
    }

    public void initService() {
        modifyCompanyService = new ModifyCompanyService(new ModifyPort<Company>() {
            @Override
            public long update(Company company) {
                return 1;
            }
        });
    }

    @Test
    public void modify_failed() {
        initFakeService();

        final boolean result = modifyCompanyService.modify(ModifyParam.builder().build());

        assertThat(result).isFalse();
    }

    @Test
    public void modify() {
        initService();

        final boolean result = modifyCompanyService.modify(ModifyParam.builder().build());

        assertThat(result).isTrue();
    }
}