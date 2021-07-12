package com.gerenciamentopessoas.personapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus
    public MessageResponsedto createPerson(@RequestBody @Valid PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDto> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) throws PersonNotFoundException {
        return personService.updateById(id, personDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
