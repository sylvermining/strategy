package com.silvermining.demo.wrapper.vo;

import com.silvermining.demo.entity.Menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pooldolorier on 09/03/16.
 */
public class MenuVO {

    private Long id;
    private String nombre;
    private Set<MenuVO> listaMenuHijos =
            new HashSet<MenuVO>();

    public MenuVO() {}
    public MenuVO(MenuVOBuilder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
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

    public Set<MenuVO> getListaMenuHijos() {
        return listaMenuHijos;
    }

    public void setListaMenuHijos(Set<MenuVO> listaMenuHijos) {
        this.listaMenuHijos = listaMenuHijos;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaMenuHijos=" + listaMenuHijos +
                '}';
    }


    public static class MenuVOBuilder {
        private Long id;
        private String nombre;

        public MenuVOBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public MenuVOBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public MenuVO build() {
            return new MenuVO(this);
        }
    }

}
