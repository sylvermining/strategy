package com.silvermining.demo.utils;

import com.silvermining.demo.entity.Menu;
import com.silvermining.demo.wrapper.vo.MenuVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pooldolorier on 10/03/16.
 */
public class ArrayListMenu extends ArrayList {

    List<MenuVO> menuList;

    @Override
    public boolean addAll(Collection c) {

        Iterator iterator = c.iterator();
        while(iterator.hasNext()) {
            Menu menu = (Menu)iterator.next();
            MenuVO menuVO = new MenuVO.MenuVOBuilder()
                    .id(menu.getId())
                    .nombre(menu.getNombre())
                    .build();
            menuList.add(menuVO);
        }
        return super.addAll(menuList);
    }
}
