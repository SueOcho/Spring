package com.inversiondecontrol.demo;

public class SecretarioEmpleado implements Empleado {

    private CreacionInformes informes;
    private String email;
    private String nombreEmpresa;





    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setInformes(CreacionInformes informes) {
        this.informes = informes;
    }

    @Override
    public String getTareas() {
        return "Gestionar la agenda de los jefes";
    }

    @Override
    public String getInforme() {
        return "Infrome generado por el secretario :"+informes.getInformes();
    }


}
