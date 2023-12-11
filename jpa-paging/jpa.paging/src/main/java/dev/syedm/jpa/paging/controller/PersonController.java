package dev.syedm.jpa.paging.controller;

import dev.syedm.jpa.paging.model.Person;
import dev.syedm.jpa.paging.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final PersonRepository personRepository;

    PersonController(PersonRepository personRepository)  {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Page<Person> findAll(@RequestParam int page, @RequestParam int size)  {
        PageRequest pr = PageRequest.of(page, size);
        return personRepository.findAll(pr);
    }
}
