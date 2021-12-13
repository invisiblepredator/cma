package com.gpw.cma.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@ApiModel("Client")
@Builder
public class ClientDTO {

    @ApiModelProperty("UUID")
    private String id;

    @ApiModelProperty("Email")
    private String email;

    @ApiModelProperty("First name")
    private String firstName;

    @ApiModelProperty("Last name")
    private String lastName;

    @ApiModelProperty("Date of birth")
    private LocalDate date;

}