package com.crm.core.usecase;

import com.crm.core.vo.Client;
import com.crm.port.DeletePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteClientService {

    private final DeletePort<Client> deletePort;

    public boolean delete(long id) {
        if (id <= 0) {
            return false;
        }
        return deletePort.delete(id);
    }
}
