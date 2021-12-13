package com.gpw.cma.domain.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Client {
    /**
     * Identifier
     */
    @Id
    private String id;

    /**
     * First name
     */
    private @NotEmpty String firstName;

    /**
     * Last name
     */
    private @NotEmpty String lastName;

    /**
     * E-mail address
     */
    private @NotEmpty String email;

    /**
     * Date of birth
     */
    private @NotEmpty LocalDate date;
}
