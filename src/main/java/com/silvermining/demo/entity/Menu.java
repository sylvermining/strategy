package com.silvermining.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dolorierp on 06/03/16.
 */
public class Menu implements Serializable {

    private Long id;
    private String nombre;
    private Set<Menu> listaMenuHijos =
            new HashSet<Menu>();
    private Set<Rol> listaRoles =
            new HashSet<Rol>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Menu> getListaMenuHijos() {
        return listaMenuHijos;
    }

    public void setListaMenuHijos(Set<Menu> listaMenuHijos) {
        this.listaMenuHijos = listaMenuHijos;
    }

    public Set<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(Set<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaMenuHijos=" + listaMenuHijos +
                ", listaRoles=" + listaRoles +
                '}';
    }
}
