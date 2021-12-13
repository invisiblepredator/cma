package com.gpw.cma.api.mapper;

import com.gpw.cma.api.dto.ClientDTO;
import com.gpw.cma.domain.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClientMapper {

    public List<ClientDTO> makeClientsDTO(Collection<Client> clients) {
        return clients.stream()
                .map(this::makeClientDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO makeClientDTO(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .email(client.getEmail())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .date(client.getDate())
                .build();
    }

}
