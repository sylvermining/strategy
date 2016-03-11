package com.silvermining.demo.business.strategy.factory;

import com.silvermining.demo.business.strategy.ConfiguracionService;
import com.silvermining.demo.business.strategy.UsuarioService;
import com.silvermining.demo.enums.ModuloEnum;

/**
 * Created by pooldolorier on 07/03/16.
 */
public interface ModuloFactory {

    UsuarioService getUsuarioService(ModuloEnum modulo);
    ConfiguracionService getConfiguracionService(ModuloEnum modulo);
}
