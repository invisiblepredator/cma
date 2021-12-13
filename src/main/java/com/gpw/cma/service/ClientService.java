package com.gpw.cma.service;

import com.gpw.cma.domain.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {
    Optional<Client> find(String id);

    Client update(Client client);

    void delete(String clientId);

    Client create(Client client);
}
