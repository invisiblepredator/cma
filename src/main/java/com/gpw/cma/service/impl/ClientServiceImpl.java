package com.gpw.cma.service.impl;

import com.gpw.cma.api.exception.EntityNotFoundException;
import com.gpw.cma.domain.entity.Client;
import com.gpw.cma.domain.repository.CMARepository;
import com.gpw.cma.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final CMARepository cmaRepository;

    @Override
    public Optional<Client> find(String id) {
        return cmaRepository.findById(id);
    }

    @Override
    public Client update(Client client) {
        return cmaRepository.save(client);
    }

    @Override
    public void delete(String clientId) {
        cmaRepository.delete(find(clientId).orElseThrow(EntityNotFoundException::new));
    }
    @Override
    public Client create(Client client) {
        return cmaRepository.save(client);
    }
}