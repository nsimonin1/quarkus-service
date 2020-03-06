package org.simon.pascal.service;

import org.simon.pascal.model.Person;

import java.util.List;

public interface PersonService {
    void set(Person person);
    Person get(Long id);
    List list();
    void delete(Long id);
}
