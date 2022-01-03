package com.inversiondecontrol.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoCicloVidaBean {
    public static void main(String[] args) {
        //cargar el xml de configuración

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        //Obtención del bea
        Empleado Josue=context.getBean("miEmpleado",Empleado.class);

        System.out.println(Josue.getInforme());
        //Cerrar el contexto

        context.close();
    }
}
