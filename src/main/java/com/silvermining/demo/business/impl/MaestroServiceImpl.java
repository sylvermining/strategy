package com.silvermining.demo.business.impl;

import com.silvermining.demo.business.MaestroService;
import com.silvermining.demo.dao.MenuDAO;
import com.silvermining.demo.entity.Menu;
import com.silvermining.demo.exception.BusinessException;
import com.silvermining.demo.exception.ExceptionMessageEnum;
import com.silvermining.demo.utils.ArrayListMenu;
import com.silvermining.demo.wrapper.vo.MenuVO;
import org.apache.log4j.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(MaestroServiceImpl.class);

    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<Menu> getMenuLista() {
        try {
            LOGGER.debug("getMenuList init");
            List<Menu> menus = menuDAO.getAll();
            Iterator<Menu> menuIterator =  menus.iterator();
            while (menuIterator.hasNext()) {
                Menu menu = menuIterator.next();
                if(menu.getMenuPadre() != null) {
                    menuIterator.remove();
                }
            }
            return menus;
        } catch(Exception oO) {
            LOGGER.error("Business Internal Error" + oO);
            throw new BusinessException(ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getCode(),
                    ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getMessage());
        }
    }
}
