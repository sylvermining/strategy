package com.silvermining.demo.wrapper.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * Created by dolorierp on 07/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class UsuarioVO {

    private Long id;
    private String nombre;
    private String password;
    private String profesion;

    public UsuarioVO() {}
    public UsuarioVO(UsuarioVOBuilder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.password = builder.password;
        this.profesion = builder.profesion;
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

    public static class UsuarioVOBuilder {
        private Long id;
        private String nombre;
        private String password;
        private String profesion;

        public UsuarioVOBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public UsuarioVOBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public UsuarioVOBuilder password(String password) {
            this.password = password;
            return this;
        }
        public UsuarioVOBuilder profesion(String profesion) {
            this.profesion = profesion;
            return this;
        }
        public UsuarioVO builder() {
            return new UsuarioVO(this);
        }
    }
}
