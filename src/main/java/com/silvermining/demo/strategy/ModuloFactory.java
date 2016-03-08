package com.silvermining.demo.strategy;

import com.silvermining.demo.business.ConfiguracionService;
import com.silvermining.demo.business.UsuarioService;
import com.silvermining.demo.enums.ModuloEnum;

/**
 * Created by pooldolorier on 07/03/16.
 */
public interface ModuloFactory {

    UsuarioService getUsuarioService(ModuloEnum modulo);
    ConfiguracionService getConfiguracionService(ModuloEnum modulo);
}
