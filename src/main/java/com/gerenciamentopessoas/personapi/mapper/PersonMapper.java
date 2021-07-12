package com.gerenciamentopessoas.personapi.mapper;

import com.gerenciamentopessoas.personapi.dto.request.PersonDTO;
import com.gerenciamentopessoas.personapi.entity.Person;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthdate", source = "birthdate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO);

    PersonDTO toDTO(Person person);
}
