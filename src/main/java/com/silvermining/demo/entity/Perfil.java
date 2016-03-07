package com.silvermining.demo.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by dolorierp on 06/03/16.
 */
public class Perfil implements Serializable {

    private Long id;
    private String nombre;
    private Set<Rol> listaRoles;
    private Set<Usuario> listaUsuarios;
    private Set<UsuarioMayor> listaUsuarioMayores;

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

    public Set<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(Set<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Set<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Set<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Set<UsuarioMayor> getListaUsuarioMayores() {
        return listaUsuarioMayores;
    }

    public void setListaUsuarioMayores(Set<UsuarioMayor> listaUsuarioMayores) {
        this.listaUsuarioMayores = listaUsuarioMayores;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaRoles=" + listaRoles +
                ", listaUsuarios=" + listaUsuarios +
                ", listaUsuarioMayores=" + listaUsuarioMayores +
                '}';
    }
}
