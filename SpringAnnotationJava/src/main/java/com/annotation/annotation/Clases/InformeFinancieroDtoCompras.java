package com.annotation.annotation.Clases;

public class InformeFinancieroDtoCompras implements CreacionInformeFinaciero {
    @Override
    public String getInformeFinaciero() {
        return "Informe financiero del departamento de compras año 2018";
    }
}
