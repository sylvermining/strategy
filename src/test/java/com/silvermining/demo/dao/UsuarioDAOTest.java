package com.silvermining.demo.dao;

import com.silvermining.demo.entity.Usuario;
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
public class UsuarioDAOTest {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Test
    @Ignore
    public void getUsuarioTest() {
        try {
            Usuario usuario = usuarioDAO
                    .getUsuarioPorNombre("abregup");
            Assert.assertNotNull(usuario);
        } catch(Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    @Ignore
    public void getAllUsers() {
        try {
            List<Usuario> usuarios =
                    usuarioDAO.getAll();
            Assert.assertTrue(!usuarios.isEmpty());
            for (Usuario usuario : usuarios) {
                System.out.println("usuario :: " + usuario.getNombre());
            }
        } catch (Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }
}
