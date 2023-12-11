package dev.syedm.jpa.paging.repository;

import dev.syedm.jpa.paging.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// PagingAndSortingRepository is derived from CrudRepository so has all its methods!
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
