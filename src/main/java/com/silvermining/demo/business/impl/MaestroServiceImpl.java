package com.silvermining.demo.business.impl;

import com.silvermining.demo.business.MaestroService;
import com.silvermining.demo.dao.MenuDAO;
import com.silvermining.demo.dao.UsuarioDAO;
import com.silvermining.demo.dao.UsuarioMayorDAO;
import com.silvermining.demo.entity.Menu;
import com.silvermining.demo.entity.Usuario;
import com.silvermining.demo.entity.UsuarioMayor;
import com.silvermining.demo.exception.BusinessException;
import com.silvermining.demo.exception.ExceptionMessageEnum;
import com.silvermining.demo.utils.ArrayListMenu;
import com.silvermining.demo.wrapper.vo.MenuVO;
import com.silvermining.demo.wrapper.vo.UsuarioVO;
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

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private UsuarioMayorDAO usuarioMayorDAO;

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

    @Override
    public UsuarioVO insertUsuario(UsuarioVO usuarioVO) {
        try {
            Usuario usuario = new Usuario.UsuarioBuild()
                    .nombre(usuarioVO.getNombre())
                    .password(usuarioVO.getPassword())
                    .build();
            Usuario user = usuarioDAO.save(usuario);
            usuarioVO.setId(user.getId());
            usuarioVO.setUsuario(usuario);
            return usuarioVO;
        } catch(Exception oO) {
            LOGGER.error("Business Internal Error" + oO);
            throw new BusinessException(ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getCode(),
                    ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getMessage());
        }

    }

    @Override
    public UsuarioVO insertUsuarioAndUsuarioMayor(UsuarioVO usuarioVO) {
        try {
            Usuario usuario = new Usuario.UsuarioBuild()
                    .nombre(usuarioVO.getNombre())
                    .password(usuarioVO.getPassword())
                    .build();
            Usuario user = usuarioDAO.save(usuario);
            usuarioVO.setId(user.getId());
            usuarioVO.setUsuario(usuario);

            UsuarioMayor usuarioMayor
                    = new UsuarioMayor.UsuarioMayorBuild()
                    .usuario(usuarioVO.getUsuario())
                    .profession(usuarioVO.getProfesion())
                    .build();

            usuarioMayorDAO.save(null);
            return usuarioVO;
        } catch(Exception oO) {
            LOGGER.error("Business Internal Error" + oO);
            throw new BusinessException(ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getCode(),
                    ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getMessage());
        }
    }

    @Override
    public void insertUsuarioMayor(UsuarioVO usuarioVO) {
        try {
            UsuarioMayor usuarioMayor
                    = new UsuarioMayor.UsuarioMayorBuild()
                    .usuario(usuarioVO.getUsuario())
                    .profession(usuarioVO.getProfesion())
                    .build();
            usuarioMayorDAO.save(usuarioMayor);
        } catch(Exception oO) {
            LOGGER.error("Business Internal Error" + oO);
            throw new BusinessException(ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getCode(),
                    ExceptionMessageEnum.MENU_BUSINESS_EXCPTION.getMessage());
        }
    }

}
