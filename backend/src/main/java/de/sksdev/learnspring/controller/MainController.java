package de.sksdev.learnspring.controller;

import de.sksdev.learnspring.db.entities.User;
import de.sksdev.learnspring.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/data")
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        userRepository.save(u);

        return "Saved";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public @ResponseBody List<User> getUserByName(@RequestParam String name){
        return userRepository.findByName(name);
    }

    @RequestMapping(value = "/getUserByEmail", method = RequestMethod.GET)
    public @ResponseBody List<User> getUserByEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

}
