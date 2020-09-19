package com.crm.core.usecase;

import com.crm.core.vo.Client;
import com.crm.core.vo.ModifyClientParam;
import com.crm.port.ModifyPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ModifyClientServiceTest {

    ModifyClientService modifyClientService;

    public void initFakeService() {
        modifyClientService = new ModifyClientService(new ModifyPort<Client>() {
            @Override
            public long update(Client c) {
                return 0;
            }
        });
    }

    public void initService() {
        modifyClientService = new ModifyClientService(new ModifyPort<Client>() {
            @Override
            public long update(Client c) {
                return 1;
            }
        });
    }

    @Test
    public void modify_failed() {
        initFakeService();

        final boolean result = modifyClientService.modify(ModifyClientParam.builder().build());

        assertThat(result).isFalse();
    }

    @Test
    public void modify() {
        initService();

        final boolean result = modifyClientService.modify(ModifyClientParam.builder().build());

        assertThat(result).isTrue();
    }
}