package com.gpw.cma.api;

import com.gpw.cma.api.dto.ClientDTO;
import com.gpw.cma.api.dto.ClientEditDTO;
import com.gpw.cma.api.exception.EntityNotFoundException;
import com.gpw.cma.api.mapper.ClientEditMapper;
import com.gpw.cma.api.mapper.ClientMapper;
import com.gpw.cma.domain.factory.ClientFactory;
import com.gpw.cma.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "regulation-internal-flow-draft")
@RestController
@RequestMapping(
        value = "/api/cma/internal",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
@Validated
public class CMAController {

    private final ClientService clientService;            //TODO maybe rename it to client service

    private final ClientMapper clientMapper;

    private final ClientEditMapper clientEditMapper;

    @ApiOperation(
            value = "Gets client by ID"
    )
    @GetMapping("/{id}")
    public ClientDTO readClient(
            @ApiParam(value = "Client UUID", required = true) @PathVariable String id
    ) {
        return clientService.find(id)
                .map(clientMapper::makeClientDTO)
                .orElseThrow(EntityNotFoundException::new);
    }

    @ApiOperation(
            value = "Adds client"
    )
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)     //TODO what we have to with these depricated ???
    public ClientDTO addClient(@RequestBody @Valid ClientEditDTO clientEditDTO) {
        return clientMapper.makeClientDTO(clientService.create(ClientFactory.of(clientEditDTO)));
    }

    @ApiOperation(
            value = "Update client"
    )
    @PutMapping("/{id}")
    public ClientDTO updateClient(
            @ApiParam(value = "Client UUID", required = true) @PathVariable String id,
            @Validated @RequestBody ClientEditDTO clientEditDTO
    ) {
        return clientService.find(id)
                .map(client -> clientEditMapper.updateFromDTO(client, clientEditDTO))
                .map(clientService::update)
                .map(clientMapper::makeClientDTO)
                .orElseThrow(EntityNotFoundException::new);
    }

    @ApiOperation(
            value = "Delete client"
    )
    @DeleteMapping("/{id}")
    public void rejectRegulation(
            @ApiParam(value = "Client UUID", required = true) @PathVariable String id
    ) {
        clientService.delete(id);
    }
}
