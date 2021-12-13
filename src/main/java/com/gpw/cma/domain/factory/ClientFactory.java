package com.gpw.cma.domain.factory;

import com.gpw.cma.api.dto.ClientEditDTO;
import com.gpw.cma.domain.entity.Client;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientFactory {

    private static String getId() {
        return UUID.randomUUID().toString();
    }

    public static Client of(ClientEditDTO clientEditDTO) {
        return Client.builder()
                .id(getId())
                .firstName(clientEditDTO.getFirstName())
                .lastName(clientEditDTO.getLastName())
                .date(clientEditDTO.getDate())
                .email(clientEditDTO.getEmail())
                .build();
    }

}
