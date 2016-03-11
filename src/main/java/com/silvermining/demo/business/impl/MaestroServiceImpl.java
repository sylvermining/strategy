package com.silvermining.demo.business.impl;

import com.silvermining.demo.business.MaestroService;
import com.silvermining.demo.dao.MenuDAO;
import com.silvermining.demo.entity.Menu;
import com.silvermining.demo.utils.ArrayListMenu;
import com.silvermining.demo.wrapper.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by pooldolorier on 10/03/16.
 */
@Service
@Transactional
public class MaestroServiceImpl implements MaestroService {

    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<MenuVO> getMenuLista() {
        List<Menu> menuLista = menuDAO.getAll();
        List<MenuVO> menuVOs = new ArrayList<MenuVO>();
        Iterator<Menu> iterator = menuLista.iterator();
        while(iterator.hasNext()) {
            Menu menu = iterator.next();
            MenuVO menuVO = new MenuVO.MenuVOBuilder()
                    .id(menu.getId())
                    .nombre(menu.getNombre())
                    .build();
            menuVOs.add(menuVO);
        }
        return menuVOs;
    }
}
