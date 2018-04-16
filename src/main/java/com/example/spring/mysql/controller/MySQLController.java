package com.example.spring.mysql.controller;

import com.example.spring.mysql.model.*;
import com.example.spring.mysql.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping(path = "/mySQL")
//@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class MySQLController {

    /*
    @Autowired
    private MyModel model;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello() {
        model = new MyModel("Hello World!");
        return model.toString();
    }
    */
    /*
    readUser	-> GET		-> {idUser}			-> <User>
    createUser	-> POST	-> users/		-> <User>
    editUser	-> PUT		-> {id, <User>}	-> <User>
    listUsers	-> GET		-> users/		-> list(<User>)
    */

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private Users userRepository;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private Roles roleRepository;

    @GetMapping(path="/listRoles")
    public @ResponseBody Iterable<Role> listRoles() {
        // This returns a JSON or XML with the users
        return roleRepository.findAll();
    }

    @GetMapping(path="/readRole")
    public @ResponseBody
    Optional<Role> readRole(@RequestParam String id){
        Long roleId = Long.valueOf(id.toString());
        return roleRepository.findById(roleId);
    }
}