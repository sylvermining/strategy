package com.silvermining.demo.dao;

import com.silvermining.demo.entity.UsuarioMayor;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:config/context.xml")
public class UsuarioMayorDAOTest {

    @Autowired
    UsuarioMayorDAO usuarioMayorDAO;

    @Test
    public void getUsuarioMayorTest() {
        try {
            UsuarioMayor usuario = usuarioMayorDAO
                    .getUsuarioPorNombre("ingsistemas");
            Assert.assertNotNull(usuario);
        } catch (Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }
}
