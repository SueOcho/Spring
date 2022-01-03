package com.annotation.annotation.Clases;

import org.springframework.beans.factory.annotation.Value;

public class DirectorFinanciero implements Empleados{

    @Value("${email}")
    private String email;

    @Value("${nombreEmpresa}")
    private String nombreEmpresa;

    private CreacionInformeFinaciero creacionInformeFinaciero;

    public DirectorFinanciero(CreacionInformeFinaciero creacionInformeFinaciero) {
        this.creacionInformeFinaciero = creacionInformeFinaciero;
    }

    @Override
    public String getTareas() {
        return "Gestión y dirección de las operaciones financieras de la empresa";
    }

    @Override
    public String getInformes() {
        return creacionInformeFinaciero.getInformeFinaciero();
    }

    public String getEmail() {
        return email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
}
