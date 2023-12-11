package dev.syedm.jpa.paging.data;

import com.github.javafaker.Faker;
import dev.syedm.jpa.paging.model.Address;
import dev.syedm.jpa.paging.model.Person;
import dev.syedm.jpa.paging.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;


// this class is used to initialize data so taht we dont have to write sql statements.
// @Component tells spring to go and manage this class for us
@Component
public class SampleDataLoader implements CommandLineRunner {
    private final PersonRepository personRepository;
    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final Faker faker;

    public SampleDataLoader(PersonRepository personRepository, Faker faker)  {
        this.personRepository = personRepository;
        this.faker = faker;
    }

    // Alt-Ins -> Implement will bring this up.
    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Sample Data ...");

        // create 100 rows for database
        List<Person> people = IntStream.rangeClosed(0, 100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().toString(),
                        faker.internet().emailAddress(),
                        new Address(faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode())
                )).toList();

        personRepository.saveAll(people);

        logger.info("Loaded Sample Data ...");
    }
}
