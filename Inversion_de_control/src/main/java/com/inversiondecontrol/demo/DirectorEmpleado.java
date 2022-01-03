package com.inversiondecontrol.demo;

public class DirectorEmpleado implements Empleado {

    //Creación de campo tipo creaciónInforme (interfaz)

    private final CreacionInformes informeNuevo;

    //creación de constructor que inyecta la dependencia
    public DirectorEmpleado(CreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }
    //metodo init. Ejecutar tareas antes de que el bean este disponible
    public void metodoInicial(){
        System.out.println("Dentro del método init . Aquí irían las tareas a ejecutar  antes de que el bean este listo");
    }

    //metodo init. Ejecutar tareas despues de que el bean este disponible
    public void metodoFinal(){
        System.out.println("Dentro del método init . Aquí irían las tareas a ejecutar  despues de que el bean muera");
    }

    @Override
    public String getTareas() {
        return "Gestionar a la empresa";
    }

    @Override
    public String getInforme() {

        return "Informe creado por el Director:" + informeNuevo.getInformes();
    }
}
