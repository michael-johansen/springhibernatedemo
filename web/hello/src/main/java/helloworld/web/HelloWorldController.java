package helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody // Declares that the return value should be used as response
    public String hello() {
        return getGreeting("world");
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String withPathVariable(@PathVariable("name") String name) { // name in @PathVariable must match {name} in path
        return getGreeting(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = "name")
    @ResponseBody
    public String withRequestParameter(@RequestParam("name") String name) {
        return getGreeting(name);
    }

    @RequestMapping(value = "/object", method = RequestMethod.GET)
    @ResponseBody
    public String boundToObject(Person person){ // ?name= is bound to Person.name
        // @ModelAttribute is usually not required, as most parameters are interpreted as model attributes
        return getGreeting(person.name);
    }

    private String getGreeting(String name) {
        return String.format("Hello, %s!", name);
    }

    public static class Person{
        private String name;

        public void setName(String name) { // Setter is called by spring to bind request parameter to field
            this.name = name;
        }
    }
}
