package org.simon.pascal.repository;

import org.simon.pascal.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PersonRepository {
    @Inject
    private EntityManager em;
    public void set(Person person){
        em.persist(person);
    }
    public Person get(Long id){
        return em.find(Person.class, id);
    }
    public List<Person> list(){
        return em.createQuery("from Person").getResultList();
    }
    public void delete(Long id){
        em.remove(em.find(Person.class, id));
    }
}
