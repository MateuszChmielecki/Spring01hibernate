package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validate")
public class ValidationController {
    @Autowired
    private Validator validator;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private PublisherDao publisherDao;

    @RequestMapping("/book")

    public String validateBook(Model model){
        Book book = new Book();

        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        model.addAttribute("violation", violations);
        if (violations.isEmpty()){
            bookDao.saveBook(book);
        }else {

            for (ConstraintViolation<Book> violation : violations) {
                System.out.println(violation.getPropertyPath()+" ----> "+violation.getMessage());

            }
        }
        return "validation";
    }

    @RequestMapping("/author")

    public String validateAuthor(Model model){
        Author author = new Author();

        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        model.addAttribute("violation", violations);
        if (violations.isEmpty()){
            authorDao.saveAuthor(author);
        }else {

            for (ConstraintViolation<Author> violation : violations) {
                System.out.println(violation.getPropertyPath()+" ----> "+violation.getMessage());

            }
        }
        return "validation";
    }

    @RequestMapping("/publisher")

    public String validatePublisher(Model model){
        Publisher publisher = new Publisher();

        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        model.addAttribute("violation", violations);
        if (violations.isEmpty()){
            publisherDao.savePublisher(publisher);
        }else {

            for (ConstraintViolation<Publisher> violation : violations) {
                System.out.println(violation.getPropertyPath()+" ----> "+violation.getMessage());

            }
        }
        return "validation";
    }

}
