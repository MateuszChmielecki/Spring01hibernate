package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookFormController {
    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @ModelAttribute("publisher")
    public List<Publisher> getAllPublisher(){
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return authorDao.findAll();
    }

    @RequestMapping("/add-book")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "addbookform";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String saveBookForm(@Valid Book book, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "addbookform";
        }

        bookDao.saveBook(book);
        model.addAttribute("books", bookDao.findAll());

        return "booklist";
    }

    @RequestMapping(value = "/list-book")
    public String listBooks(Model model){
        model.addAttribute("books", bookDao.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/update-book/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable Long id, Model model){
        model.addAttribute("book", bookDao.findById(id));
        return "updatebook";
    }

    @RequestMapping(value = "/update-book/{id}", method = RequestMethod.POST)
    public String updateBookForm(@PathVariable Long id, Book book){
        bookDao.update(book);
        return "redirect:/list-book";
    }

    @RequestMapping(value = "/book/saftydelete/{id}")
    public String safetyDelete(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        return "safetydeletebook";

    }

    @RequestMapping("/book/saftydelete/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookDao.delete(id);
        return "redirect:/list-book";
    }








}
