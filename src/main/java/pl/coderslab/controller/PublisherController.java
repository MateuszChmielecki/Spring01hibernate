package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String addPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Wydawca nr1");
        publisherDao.savePublisher(publisher);
        return "Id dodanego wydawcy to:"
                + publisher.getId();
    }
    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String name ) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

//    @RequestMapping("/publisher/delete/{id}")
//    @ResponseBody
//    public String deleteBook(@PathVariable long id) {
//        publisherDao.delete(id);
//        return "deleted";
//    }

    @RequestMapping("/publisher/findall")
    @ResponseBody
    public String findAll() {
        List<Publisher> all = publisherDao.findAll();
        all.forEach(publisher -> System.out.println(publisher.getName()));
        return "publisher list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> getAllAuthors(){
        return publisherDao.findAll();
    }

    @RequestMapping("/list-publisher")
    public String showAllPublishers(Model model) {
//        model.addAttribute("publishers", publisherDao.findAll());
        return "publisherlist";
    }

    @RequestMapping(value = "/add-publisher", method = RequestMethod.GET)
    public String showPublisherForm(Model model){
        model.addAttribute("publisher", new Publisher());
        return "addpublisherform";
    }

    @RequestMapping(value = "/add-publisher", method = RequestMethod.POST)
    public String saveAuthorForm(Publisher publisher, Model model){
        publisherDao.savePublisher(publisher);

        return "redirect:/list-publisher";
    }

    @RequestMapping(value = "/publisher/saftydelete/{id}")
    public String safetyPublisherDelete(@PathVariable Long id, Model model){
        model.addAttribute("publisherid", id);
        return "safetydeletepublisher";

    }

    @RequestMapping("/publisher/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherDao.delete(id);
        return "redirect:/list-publisher";
    }

    @RequestMapping(value = "/update-publisher/{id}", method = RequestMethod.GET)
    public String updatePublisher(@PathVariable Long id, Model model){
        model.addAttribute("publisher", publisherDao.findById(id));
        return "updatepublisher";
    }

    @RequestMapping(value = "/update-publisher/{id}", method = RequestMethod.POST)
    public String updatePublisherForm(@PathVariable Long id, Publisher publisher){
        publisherDao.update(publisher);
        return "redirect:/list-publisher";
    }




}
