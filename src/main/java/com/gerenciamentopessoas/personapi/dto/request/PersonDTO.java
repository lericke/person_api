package com.gerenciamentopessoas.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.NotEmptyExpression;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastname;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthdate;

    @Valid
    @NotEmpty
    private List <PhontDTO> phones;


}
