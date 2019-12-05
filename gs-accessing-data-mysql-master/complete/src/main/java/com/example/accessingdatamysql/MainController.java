package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
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
      //  n.setData(data);
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
//
    @GetMapping("/all/{name:[a-zA-Z]+}")
    @ResponseBody
    List<User> getUser(@PathVariable("name") String name) {
        Assert.hasText(name, "name can't be blank");
//        for (User u : userRepository.findAll()) {
//            if (name.equalsIgnoreCase(u.getName())) {
//                return u;
//            }
        return userRepository.findByName(name);

//        return userRepository.znajdzPoImieniu(name);

    }
//
    @GetMapping("/all/{email:.+@.+}")
    @ResponseBody
    User getUserByEmail(@PathVariable("email") String email) {
        Assert.hasText(email, "email can't be blank");

        return userRepository.findByEmail(email);
    }
    @GetMapping("{name}")
    @ResponseBody
    List<User> sortedNamed(@PathVariable String name) {
       return userRepository.findByNameOrderById(name);
    }
}

