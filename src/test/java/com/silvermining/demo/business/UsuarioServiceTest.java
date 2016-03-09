package com.silvermining.demo.business;

import com.silvermining.demo.enums.ModuloEnum;
import com.silvermining.demo.strategy.ModuloFactory;
import com.silvermining.demo.strategy.ServiceManager;
import com.silvermining.demo.wrapper.vo.UsuarioVO;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pooldolorier on 07/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:config/context.xml")
public class UsuarioServiceTest {

    @Autowired
    private ModuloFactory moduloFactory;

    @Test
    @Ignore
    public void getUsuarioTest() {
        try {
            UsuarioVO usuarioVO = moduloFactory.getUsuarioService(ModuloEnum.USUARIO).getUsuario("abregup");
            Assert.assertNotNull(usuarioVO);
        } catch (Exception Oo) {
            Oo.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    @Ignore
    public void getUsuarioMayorTest() {
        try {
            UsuarioVO usuarioVO = moduloFactory.getUsuarioService(ModuloEnum.USUARIO_MAYOR).getUsuario("dolorierp");
            Assert.assertNotNull(usuarioVO);
        } catch (Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }


}
