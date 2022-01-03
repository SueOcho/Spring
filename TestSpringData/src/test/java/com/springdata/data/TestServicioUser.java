package com.springdata.data;

import com.springdata.data.model.User;
import com.springdata.data.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServicioUser {
    @Autowired
    UserService userService;

    @Test
    public void PruebaListadoUsuarios(){
        //Dado que - Entradas
        userService.findAll();

        //Cuando
        Optional<List<User>> hola=userService.findAll();

        //entonces ..verificamos

      //  assertEquals("Josue",hola.get().get(0).getUserName());
    }
}
