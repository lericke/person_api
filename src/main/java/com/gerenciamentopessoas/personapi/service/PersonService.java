package com.gerenciamentopessoas.personapi.service;

import com.gerenciamentopessoas.personapi.dto.request.PersonDTO;
import com.gerenciamentopessoas.personapi.dto.response.MessageResponseDTO;
import com.gerenciamentopessoas.personapi.entity.Person;
import com.gerenciamentopessoas.personapi.mapper.PersonMapper;
import com.gerenciamentopessoas.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person persontoSave = personMapper.toModel(personDTO);

        Person savedPerson =  personRepository.save(persontoSave);
        return MessageResponseDTO
                .builder()
                .message("Created Person with ID" + savedPerson.getId())
                .build();
    }
}