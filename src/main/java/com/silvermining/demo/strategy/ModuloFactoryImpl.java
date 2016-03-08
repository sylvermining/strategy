package com.silvermining.demo.strategy;

import com.silvermining.demo.business.ConfiguracionService;
import com.silvermining.demo.business.UsuarioService;
import com.silvermining.demo.enums.ModuloEnum;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by pooldolorier on 07/03/16.
 */
@Service
public class ModuloFactoryImpl implements  ModuloFactory{

    private Map<ModuloEnum, ServiceManager> serviceManager;

    @Override
    public UsuarioService getUsuarioService(ModuloEnum modulo) {
        return getServiceManager(modulo).getUsuarioService();
    }

    @Override
    public ConfiguracionService getConfiguracionService(ModuloEnum modulo) {
        return getServiceManager(modulo).getConfiguracionService();
    }

    public ServiceManager getServiceManager(ModuloEnum modulo) {
        return serviceManager.get(modulo);
    }

    public void setServiceManager(Map<ModuloEnum, ServiceManager> serviceManager) {
        this.serviceManager = serviceManager;
    }
}
