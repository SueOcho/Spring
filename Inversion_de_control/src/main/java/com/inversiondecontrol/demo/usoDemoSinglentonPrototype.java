package com.inversiondecontrol.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class usoDemoSinglentonPrototype {


    public static void main(String[] args) {


        //Carga de xml de configuración
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        //Petición de beans al contenedor spring
        SecretarioEmpleado Josue = context.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
        SecretarioEmpleado Eliezer = context.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
        System.out.println(Josue);
        System.out.println(Eliezer);
    }

}
