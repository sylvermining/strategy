package com.silvermining.demo.wrapper.vo;

/**
 * Created by dolorierp on 07/03/16.
 */
public class UsuarioVO {

    private Long id;
    private String nombre;
    private String password;
    private String profesion;

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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
