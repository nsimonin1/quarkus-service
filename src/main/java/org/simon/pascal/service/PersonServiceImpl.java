package org.simon.pascal.service;

import org.simon.pascal.model.Person;
import org.simon.pascal.repository.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {
    @Inject
    private PersonRepository personRepository;
    @Transactional
    public void set(Person person) {
        personRepository.set(person);
    }
    public List<Person> list() {
        return personRepository.list();
    }
    public Person get(Long id) {
        return personRepository.get(id);
    }
    @Transactional
    public void delete(Long id) {
        personRepository.delete(id);
    }
}
