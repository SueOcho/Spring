package com.annotation.annotation.Clases;

import org.springframework.stereotype.Component;

@Component
public class InformeFinacieroTrim4 implements CreacionInformeFinaciero{
    @Override
    public String getInformeFinaciero() {
        return "Presentación de informe financiero del trimestre 4";
    }
}
