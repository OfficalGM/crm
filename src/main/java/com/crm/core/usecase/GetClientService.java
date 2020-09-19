package com.crm.core.usecase;

import com.crm.core.vo.Client;
import com.crm.port.GetPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetClientService {

    private final GetPort<Client> getClientPort;

    public List<Client> obtainAll() {
        return getClientPort.findAll();
    }
}
