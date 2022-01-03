package com.inversiondecontrol.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class InversionDeControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(InversionDeControlApplication.class, args);

/*        //Creación de objetos de tipo Empleado

        Empleado Empleado1= new DirectorEmpleado();

        //Us ode los objetos creados

        System.out.println(Empleado1.getTareas());*/

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
/*        Empleado Josue= context.getBean("miEmpleado",Empleado.class);
        System.out.println(Josue.getTareas());
        System.out.println(Josue.getInforme());*/

        SecretarioEmpleado Eliezer= context.getBean("miSecretarioEmpleado",SecretarioEmpleado.class);
        System.out.println(Eliezer.getTareas());
        System.out.println(Eliezer.getInforme());
        System.out.println(Eliezer.getEmail());
        System.out.println(Eliezer.getNombreEmpresa());

        context.close();


    }

}
