package com.springdata.data.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="menu")
public class Menu {

    @Id
    private Integer idMenu;

    @Column(name="icon",length = 20)
    private String icon;

    @Column(name="name",length = 20)
    private String name;

    @Column(name="url",length = 50)
    private String url;


    //JOinCOlumns para el dato qeu esta aqui  que es idMenu
    //inversJoinColumn es para el dato inverso, Rol en este caso idRol (Lo tenemos como lista abajo)
    @ManyToMany(fetch = FetchType.EAGER )//Lazy, no va traer la list, eager si lo va traer (Condu se consulte por el objeto menu)
    @JoinTable(name="menu_rol",
                joinColumns = @JoinColumn(name="id_menu",referencedColumnName = "idMenu"),
                inverseJoinColumns = @JoinColumn(name="id_rol",referencedColumnName = "idRol"))
    private List<Rol> roles;

}
