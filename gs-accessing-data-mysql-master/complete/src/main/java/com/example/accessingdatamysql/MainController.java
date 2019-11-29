package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<User> list = new ArrayList();

        do {
            User user = new User(userRepository.findAll().iterator().next());
            list.add( user);
        }
        while (userRepository.findAll().iterator().hasNext());

        return list.stream()
                .filter(User -> Objects.equals(User.getName(), name))
                .findFirst().orElseGet(() -> null);
    }

}

