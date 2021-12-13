package com.gpw.cma.api.mapper;

import com.gpw.cma.api.dto.ClientEditDTO;
import com.gpw.cma.domain.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class ClientEditMapper {

    public Client updateFromDTO(
            Client client,
            ClientEditDTO clientEditDTO
    ) {
        client.setFirstName(clientEditDTO.getFirstName());
        client.setLastName(clientEditDTO.getLastName());
        client.setDate(clientEditDTO.getDate());
        client.setEmail(clientEditDTO.getEmail());
        return client;
    }

}
