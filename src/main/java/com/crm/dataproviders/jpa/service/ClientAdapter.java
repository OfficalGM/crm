package com.crm.dataproviders.jpa.service;

import com.crm.core.vo.Client;
import com.crm.dataproviders.jpa.entity.ClientEntity;
import com.crm.dataproviders.jpa.repo.ClientRepo;
import com.crm.dataproviders.jpa.util.ClientMapper;
import com.crm.port.DeletePort;
import com.crm.port.GetPort;
import com.crm.port.ModifyPort;
import com.crm.port.StorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientAdapter implements GetPort<Client>, StorePort<Client>, ModifyPort<Client>, DeletePort<Client> {

    private final ClientRepo repo;

    @Override
    public boolean delete(long id) {
        log.debug("delete() id={}", id);
        repo.deleteById(id);
        return true;
    }

    @Override
    public List<Client> findAll() {
        log.debug("findAll()");
        return repo.findAll()
                .stream()
                .map(ClientMapper::mapToClient)
                .collect(Collectors.toList());
    }

    @Override
    public long update(Client client) {
        final Optional<ClientEntity> optional = repo.findById(client.getId())
                .map(e -> {
                    e.setName(client.getName());
                    e.setAddress(client.getAddress());
                    e.setUpdatedBy(client.getUpdatedBy());
                    e.setUpdatedAt(client.getUpdatedAt());
                    return e;
                }).map(repo::save);
        if (optional.isPresent()) {
            return optional.get().getId();
        }
        return 0L;
    }

    @Override
    public Client save(Client client) {
        return ClientMapper.mapToClient(repo.save(ClientMapper.mapToClientEntity(client)));
    }

    @Override
    public boolean save(List<Client> list) {
        final List<ClientEntity> saveList = list.stream()
                .map(ClientMapper::mapToClientEntity)
                .collect(Collectors.toList());
        repo.saveAll(saveList);
        return true;
    }
}
