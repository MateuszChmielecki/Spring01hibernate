package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.sevices.PersonService;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping("/person/add")
    @ResponseBody
    public String addBook() {
        Person person = personService.addPersonByDetails("Imie", "Nazwisko", "Miasto", "Ulica", 12, "login", "hasło", "email");
        String result = "Id dodanej osoby to:"+person.getId();
        return result;
    }
}
