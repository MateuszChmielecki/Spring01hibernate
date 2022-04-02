package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private AuthorDao authorDao;


    @RequestMapping("/book/add")
    @ResponseBody
    public String addBook() {
        Author author1 = authorDao.findById(2);
        Author author2 = authorDao.findById(4);

        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisher = publisherDao.savePublisher(publisher);

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("Opis");
        book.setRating(5);
        book.setPublisher(publisher);
        book.addAuthors(author1);
        book.addAuthors(author2);
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }
    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        bookDao.delete(id);
        return "deleted";
    }

}
