package com.gpw.cma.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;


@Data
@ApiModel
public class ClientSearch {

    @ApiParam("Search for name by %value% pattern")
    private String name;

    @ApiParam("Search for ID")
    private String id;

}
