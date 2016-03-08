package com.silvermining.demo.strategy;

import com.silvermining.demo.business.ConfiguracionService;
import com.silvermining.demo.business.UsuarioService;
import com.silvermining.demo.enums.ModuloEnum;

import java.util.Map;

/**
 * Created by pooldolorier on 07/03/16.
 */
public class ServiceManager {

    private UsuarioService usuarioService;
    private ConfiguracionService configuracionService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ConfiguracionService getConfiguracionService() {
        return configuracionService;
    }

    public void setConfiguracionService(ConfiguracionService configuracionService) {
        this.configuracionService = configuracionService;
    }
}
