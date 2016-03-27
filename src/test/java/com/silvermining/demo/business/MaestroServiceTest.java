package com.silvermining.demo.business;

import com.silvermining.demo.entity.Menu;
import com.silvermining.demo.wrapper.vo.UsuarioVO;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by pooldolorier on 10/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:config/context.xml")
public class MaestroServiceTest {

    private static final Logger LOGGER = Logger.getLogger(MaestroServiceTest.class);

    @Autowired
    private MaestroService maestroService;

    @Test
    @Ignore
    public void menuListTest() {
        try {
            List<Menu> menuLista = maestroService.getMenuLista();
            Assert.assertTrue(!menuLista.isEmpty());
            LOGGER.info("menu lista size :: " + menuLista.size());
        } catch(Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    @Ignore
    public void insertUsuarioMayorTest() {
        try {
            UsuarioVO usuarioVO =
                    new UsuarioVO.UsuarioVOBuilder()
                    .nombre("Lincon")
                    .password("1a2b3c4d")
                    .profesion("president")
                    .builder();
            UsuarioVO userVO = maestroService.insertUsuario(usuarioVO);
            maestroService.insertUsuarioMayor(userVO);
            Assert.assertNotNull(userVO.getId());
        } catch(Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }

    @Test
		@Ignore
    public void insertUsuarioAndUsuarioMayor() {
        try {
            UsuarioVO usuarioVO =
                    new UsuarioVO.UsuarioVOBuilder()
                            .nombre("Lincon")
                            .password("1a2b3c4d")
                            .profesion("president")
                            .builder();
            UsuarioVO userVO = maestroService.insertUsuarioAndUsuarioMayor(usuarioVO);
            Assert.assertNotNull(userVO.getId());
        } catch(Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }
}
