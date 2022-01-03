package com.annotation.annotation.Clases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//Este archivo nos sirve para ya no usar el XML
@Configuration
@ComponentScan("com.annotation.annotation.Clases")
@PropertySource("classpath:datosEmpresa.propiedades")
public class EmpleadosConfig {

    //definir el bean para InformeFinancieroDtoCompras
    @Bean
    public CreacionInformeFinaciero informeFinancieroDtoCompras(){ //Será el id del Bean inyectado
        return new InformeFinancieroDtoCompras();
    }

    //definir el bean para DirectorFinanciero e inyectar dependencias
    @Bean
    public Empleados directorFinanciero(){
        return new DirectorFinanciero(informeFinancieroDtoCompras());
    }
}
