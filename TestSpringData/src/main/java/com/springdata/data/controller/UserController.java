package com.springdata.data.controller;

import com.springdata.data.exception.ModeloNotFoundException;
import com.springdata.data.model.User;
import com.springdata.data.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//@CrossOrigin(origins="localhost:4200")
@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){

        return userService.findAll().map(user->user.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(user,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        if(userService.findById(id).isEmpty()){
            throw new ModeloNotFoundException("ID  NO ENCONTRADO " +id);
        }

        return userService.findById(id).map(user -> new ResponseEntity(user,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND) );

    }
/*    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveOrUpdate(user), HttpStatus.CREATED);
    }*/

    //Nivel de madurez 2, no regresa el usuario intertado ,regreas la uri donde podemos ver el usuario insertadp
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody User user) {
        User obj=userService.saveOrUpdate(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<User>  update(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.saveOrUpdate(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return userService.findById(id).isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(userService.deleteById(id),HttpStatus.OK);

    }
}
