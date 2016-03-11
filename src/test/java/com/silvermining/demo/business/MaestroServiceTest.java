package com.silvermining.demo.business;

import com.silvermining.demo.wrapper.vo.MenuVO;
import junit.framework.Assert;
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

    @Autowired
    private MaestroService maestroService;

    @Test
    public void menuListTest() {
        try {
            List<MenuVO> menuLista = maestroService.getMenuLista();
            Assert.assertTrue(!menuLista.isEmpty());
        } catch(Exception oO) {
            oO.printStackTrace();
            Assert.fail();
        }
    }
}
