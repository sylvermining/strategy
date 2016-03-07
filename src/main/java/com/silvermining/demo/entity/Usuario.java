package com.silvermining.demo.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by dolorierp on 06/03/16.
 */
public class Usuario implements Serializable {

    private Long id;
    private String nombre;
    private String password;
    private Set<Perfil> listaPerfiles;

    public Usuario() {}

    public Usuario(UsuarioBuild build) {
        this.id = build.id;
        this.nombre = build.nombre;
        this.password = build.password;
        this.listaPerfiles = build.listaPerfiles;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(Set<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", listaPerfiles=" + listaPerfiles +
                '}';
    }

    public static class UsuarioBuild {

        private Long id;
        private String nombre;
        private String password;
        private Set<Perfil> listaPerfiles;

        public UsuarioBuild id(Long id) {
            this.id = id;
            return this;
        }

        public UsuarioBuild nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public UsuarioBuild password(String password) {
            this.password = password;
            return this;
        }

        public UsuarioBuild listaPerfiles(Set<Perfil> listaPerfiles) {
            this.listaPerfiles = listaPerfiles;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }

    }
}
