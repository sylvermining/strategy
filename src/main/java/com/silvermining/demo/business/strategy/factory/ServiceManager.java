package com.silvermining.demo.business.strategy.factory;

import com.silvermining.demo.business.strategy.ConfiguracionService;
import com.silvermining.demo.business.strategy.UsuarioService;

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
