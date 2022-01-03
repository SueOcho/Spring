package com.annotation.annotation.Clases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("ComercialExperimentado") //Con esto lo va detectar como un bean de xml
// Podemos simplemente utilizar @Compenet y spring tomará el nombre de la clase (la primera letra en minuscula)
@Component //Para que lo detecte como un bean
//  @Scope("prototype") //Con esto cambio el patron de Singleton a prototype
public class ComercialExperimentado implements Empleados {

    //Tabien se puede hacer la inyeccion de dependencia con el atributo
    //Por defecto toma la clase que implementa la interfaz, en caso existan varias clases que lo implementen
    //Usas el @Qualifier para mencionar cual quiere llamar, la primera letra en minuscula por el @Component
    @Autowired
    @Qualifier("informeFinacieroTrim2")
    private CreacionInformeFinaciero creacionInformeFinaciero;

    //Ejemplo de inyeccion con setter y autowired
/*    @Autowired
    public void setCreacionInformeFinaciero(CreacionInformeFinaciero creacionInformeFinaciero) {
        this.creacionInformeFinaciero = creacionInformeFinaciero;
    }*/

    //Ya no tenemos que configurar en xml, con esto solo lo va buscar a CreacionInformeFinaciero
    // y hará la inyeccion de dependencias
/*    @Autowired //se debe especificar el @Autowired cuando vas a tener mas de un constructor
    public ComercialExperimentado(CreacionInformeFinaciero creacionInformeFinaciero) {
        this.creacionInformeFinaciero = creacionInformeFinaciero;
    }*/


    @Override
    public String getTareas() {
        return "Soy un tareita";
    }

    @Override
    public String getInformes() {
        return creacionInformeFinaciero.getInformeFinaciero();
    }




    //PARA QUE ESTOE FUNCIONE TIENE QUE ESTAR EN SINGLENTON, YA QUE EL CICLO DEL VIDA DEL BEAN NO FUNCINOA
    //SI SE TRABAJA CON PROTOTYPE
    //Ejecucion de código después de creación del Bean


    @PreDestroy
    public void ejecutaDespuesCreación(){
        System.out.println("Ejecutando tras creación de Bean");
    }

    @PostConstruct
    //Ejecucion de código después de apagado del Bean
    public void ejecutaAntesCreación(){
        System.out.println("Ejecutando antes de la creación de Bean");
    }
}
