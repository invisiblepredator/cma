package com.gpw.cma.api.dto;

import com.gpw.cma.api.validator.Age;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("ClientEdit")
public class ClientEditDTO {

    @ApiModelProperty("UUID")
    private String id;

    @ApiModelProperty("Email")
    @NotBlank
    @Email
    private String email;

    @ApiModelProperty("First name")
    @NotBlank
    private String firstName;

    @ApiModelProperty("Last name")
    @NotBlank
    private String lastName;

    @ApiModelProperty("Date of birth")
    @Age
    private LocalDate date;

}