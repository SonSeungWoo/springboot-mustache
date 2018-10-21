package com.github.ssw.springbootmustache;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class PersonController {

    @GetMapping("/person")
    public ModelAndView displayArticle(Map<String, Object> model) {
        List<Person> personList = IntStream.range(0, 10)
                .mapToObj(i -> generatePerson("Person " + i))
                .collect(Collectors.toList());

        model.put("person", personList);

        return new ModelAndView("index", model);
    }

    private Person generatePerson(String title) {
        Person person = new Person();
        person.setName(title);
        person.setEmail("test@gmail.co.kr");
        return person;
    }

}
