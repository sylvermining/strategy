package com.silvermining.demo.enums;

/**
 * Created by pooldolorier on 07/03/16.
 */
public enum ModuloEnum {

    USUARIO("UU","usuario"),
    USUARIOs("Uc","usuario"),
    USUARIO_MAYOR("UM", "usuario mayor");

    private String codigo;
    private String nombre;

    ModuloEnum(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public static ModuloEnum getModuloPorCodigo(String moduloCode) {
        for(ModuloEnum modulo : ModuloEnum.values()) {
            if(modulo.getCodigo().equalsIgnoreCase(moduloCode)) {
                return modulo;
            }
        }
        return ModuloEnum.USUARIO;
    }
}
