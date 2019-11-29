package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/demo", method = {RequestMethod.GET})
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add/{name}_{email}")
    public @ResponseBody
    String addNewUser(@PathVariable String name, @PathVariable String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved name= " + name + " email= " + email;
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    String deleted(@RequestParam Integer id) {
        userRepository.deleteById(id);
        return "deleted " + id + " numer";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/all/{id:\\d+}")
    @ResponseBody
    Optional<User> getUser(@PathVariable Integer id) {
        return userRepository.findById(id);

    }

    @GetMapping("/all/{name:[a-zA-Z]+}")
    @ResponseBody
    User getUser(@PathVariable String name) {
        Assert.hasText(name, "name can't be blank");
        for (User u : userRepository.findAll()) {
            if (name.equalsIgnoreCase(u.getName())) {
                return u;
            }
        }
        return null;
    }

}

