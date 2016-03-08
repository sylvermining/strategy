package com.silvermining.demo.enums;

/**
 * Created by pooldolorier on 07/03/16.
 */
public enum ModuloEnum {

    USUARIO("U","usuario"),
    USUARIO_MAYOR("UM", "usuario mayor");

    private String codigo;
    private String nombre;

    ModuloEnum(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
