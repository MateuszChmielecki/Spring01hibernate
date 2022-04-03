package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("gender")
    public List<String> gender() {
        return Arrays.asList("Male", "Female");
    }

    @ModelAttribute("skills")
    public Collection<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("php");
        skills.add("python");
        skills.add("ruby");
        return skills;
    }
    @ModelAttribute("hobbiesList")
    public Collection<String> hobbiesList() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("sport");
        hobbies.add("muzyka");
        hobbies.add("programowanie");
        hobbies.add("gra na frotepianie");
        return hobbies;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPersonForm(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "studentForm";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String showStudent(Student student) { //tu dostajemy obiekt zbindowany (wypelniony danymi)


        return student.toString();
    }

}
