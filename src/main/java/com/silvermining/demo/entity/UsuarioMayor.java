package com.silvermining.demo.entity;


import sun.misc.Perf;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by dolorierp on 06/03/16.
 */
public class UsuarioMayor implements Serializable {

    private Long id;
    private String profesion;
    private Usuario usuario;
    private Set<Perfil> listaPerfiles;

    public UsuarioMayor(){}

    public UsuarioMayor(UsuarioMayorBuild build){
        this.id = build.id;
        this.profesion = build.profession;
        this.usuario = build.usuario;
        this.listaPerfiles = build.listaPerfiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(Set<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    @Override
    public String toString() {
        return "UsuarioMayor{" +
                "id=" + id +
                ", profesion='" + profesion + '\'' +
                ", usuario=" + usuario +
                ", listaPerfiles=" + listaPerfiles +
                '}';
    }

    public static class UsuarioMayorBuild {
        private Long id;
        private String profession;
        private Usuario usuario;
        private Set<Perfil> listaPerfiles;

        public UsuarioMayorBuild id(Long id) {
            this.id = id;
            return this;
        }
        public UsuarioMayorBuild profession(String profession) {
            this.profession = profession;
            return this;
        }
        public UsuarioMayorBuild usuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }
        public UsuarioMayorBuild listaPerfiles(Set<Perfil> listaPerfiles) {
            this.listaPerfiles = listaPerfiles;
            return this;
        }
        public UsuarioMayor build() {
            return new UsuarioMayor(this);
        }
    }

}
