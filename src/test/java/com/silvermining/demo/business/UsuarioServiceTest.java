package com.silvermining.demo.business;

import com.silvermining.demo.enums.ModuloEnum;
import com.silvermining.demo.strategy.ModuloFactory;
import com.silvermining.demo.strategy.ServiceManager;
import com.silvermining.demo.wrapper.vo.UsuarioVO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pooldolorier on 07/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:config/context.xml")
public class UsuarioServiceTest {

    private UsuarioService usuarioService;
    private ModuloFactory moduloFactory;

    @Test
    @Ignore
    public void getUsuarioTest() {
        UsuarioVO usuarioVO = moduloFactory.getUsuarioService(ModuloEnum.USUARIO).getUsuario("");
    }

    @Test
    @Ignore
    public void getUsuarioMayorTest() {

    }

}
