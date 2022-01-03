package com.annotation.annotation;

import com.annotation.annotation.Clases.Empleados;
import com.annotation.annotation.Clases.EmpleadosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ProyectoParaConocerLasAnotacionesDeJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoParaConocerLasAnotacionesDeJavaApplication.class, args);

        //Leer el xml de configuración
        //Cuando creamos la clase de configuracion ya no necesitamos el xml
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        //En ves de leer el xml leeremos la clase de configuración
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(EmpleadosConfig.class);

        //Pedir un bean al contenedor
        Empleados Josue= context.getBean("directorFinanciero",Empleados.class);

        //Usar el Bean
        System.out.println(Josue.getInformes());
        System.out.println(Josue.getTareas());

        //Cerar el contexto
        context.close();
    }

}
