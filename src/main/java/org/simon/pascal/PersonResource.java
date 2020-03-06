package org.simon.pascal;

import org.simon.pascal.model.Person;
import org.simon.pascal.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    private PersonService personService;
    @GET
    public List<Person> list() {
        return personService.list();
    }
    @GET
    @Path("/{id}")
    public Person get(@PathParam("id") Long id) {
        return personService.get(id);
    }
    @POST
    public void create(Person person) {
        personService.set(person);
    }
    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Person person) {
        if(! id.equals(person.getId())){
            throw new BadRequestException("id in path and in body must be the same");
        }
        personService.set(person);
    }
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        personService.delete(id);
    }
}