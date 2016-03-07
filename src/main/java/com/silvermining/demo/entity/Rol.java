package com.silvermining.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dolorierp on 06/03/16.
 */
public class Rol implements Serializable {

    private Long id;
    private String nombre;
    private Set<Perfil> listaPerfil =
            new HashSet<Perfil>();
    private Set<Menu> listaMenu =
            new HashSet<Menu>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Perfil> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(Set<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    public Set<Menu> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(Set<Menu> listaMenu) {
        this.listaMenu = listaMenu;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaPerfil=" + listaPerfil +
                ", listaMenu=" + listaMenu +
                '}';
    }
}
