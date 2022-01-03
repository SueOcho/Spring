package com.annotation.annotation.Clases;

import org.springframework.stereotype.Component;

@Component
public class InformeFinacieroTrim1 implements CreacionInformeFinaciero{
    @Override
    public String getInformeFinaciero() {
        return "Presentación de informe financiero del trimestre 1";
    }
}
