package pl.coderslab.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Component
//@Service
public class PersonService {

    @Autowired
    PersonDao personDao;
    @Autowired
    PersonDetailsDao personDetailsDao;

    public Person addPersonByDetails(String firstName, String lastName, String city, String street, Integer streetNumber, String login,String password,String email){
        PersonDetails personDetails = new PersonDetails();
        Person person = new Person();

        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setCity(city);
        personDetails.setStreet(street);
        personDetails.setStreetNumber(streetNumber);
        personDetailsDao.savePersoneDetails(personDetails);

        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        person.setDetails(personDetails);
        personDao.savePerson(person);


        return person;
    }
}
