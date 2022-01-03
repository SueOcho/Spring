package com.inversiondecontrol.demo;

public class JefeEmpleado implements Empleado{

    private CreacionInformes informes;

    public JefeEmpleado(CreacionInformes informes) {
        this.informes = informes;
    }

    public String getTareas(){
        return "Gestion las cuestiones relativas a mis empleados de sección";
    }

    @Override
    public String getInforme() {
        return "Informe presentado por el jefe con arreglos : "+ informes.getInformes();
    }
}
