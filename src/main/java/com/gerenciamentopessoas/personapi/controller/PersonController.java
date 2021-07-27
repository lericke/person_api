package com.gerenciamentopessoas.personapi.controller;

import com.gerenciamentopessoas.personapi.dto.request.PersonDTO;
import com.gerenciamentopessoas.personapi.dto.response.MessageResponseDTO;
import com.gerenciamentopessoas.personapi.entity.Person;
import com.gerenciamentopessoas.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED  )
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
}