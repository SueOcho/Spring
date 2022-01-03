package com.annotation.annotation.Clases;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotation2 {
    public static void main(String[] args) {
        //Leer el xml de configuración
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        //Pedir un bean al contenedor
        Empleados Josue= context.getBean("comercialExperimentado",Empleados.class);
        Empleados Eliezer= context.getBean("comercialExperimentado",Empleados.class);


        //Usar el Bean
        System.out.println(Josue);
        System.out.println(Eliezer);

        DirectorFinanciero empleado=context.getBean("directorFinanciero",DirectorFinanciero.class);
        System.out.println("Email del director: "+empleado.getEmail());


        //Cerar el contexto
        context.close();
    }
}
