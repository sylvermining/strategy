package com.silvermining.demo.dao;

import com.silvermining.demo.entity.UsuarioMayor;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:config/context.xml")
public class UsuarioMayorDAOTest {

    @Autowired
    UsuarioMayorDAO usuarioMayorDAO;

    @Test
    @Ignore
    public void getUsuarioMayorTest() {
        try {
            UsuarioMayor usuario = usuarioMayorDAO
                    .getUsuarioPorNombre("dolorierp");
            Assert.assertNotNull(usuario);
        } catch (Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    @Ignore
    public void getAllUsers() {
        try {
            List<UsuarioMayor> usuarios =
                    usuarioMayorDAO.getAll();
            Assert.assertTrue(!usuarios.isEmpty());
            for(UsuarioMayor usuario : usuarios) {
                System.out.println("usuario mayor :: " + usuario.getUsuario().getNombre());
            }
        } catch (Exception Oo) {
            Oo.printStackTrace();
            Assert.fail();
        }
    }
}
