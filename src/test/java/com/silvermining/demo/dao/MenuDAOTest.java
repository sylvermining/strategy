package com.silvermining.demo.dao;

import com.silvermining.demo.entity.Menu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Created by dolorierp on 06/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:config/context.xml")
public class MenuDAOTest {

    @Autowired
    private MenuDAO menuDAO;

    @Before
    public void Setup(){

    }

    @Test
    @Ignore
    public void getListaMenus() {
        try {
            List list = menuDAO.getAll();
            Assert.assertTrue(list.size() > 0);
        } catch(Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    @Ignore
    public void getListaMenuRoles() {
        try {
            List<Menu> list = menuDAO.getAll();
            Assert.assertTrue(list.size() > 0);
            for(Menu menu : list) {
                Set roles = menu.getListaRoles();
                System.out.println(" menu :: " + menu.getNombre() + ", role :: " + roles.size());
            }
        } catch(Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }

}
