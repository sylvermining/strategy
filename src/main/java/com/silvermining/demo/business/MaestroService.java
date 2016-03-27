package com.silvermining.demo.business;

import com.silvermining.demo.entity.Menu;
import com.silvermining.demo.wrapper.vo.MenuVO;
import com.silvermining.demo.wrapper.vo.UsuarioVO;

import java.util.List;

/**
 * Created by pooldolorier on 10/03/16.
 */
public interface MaestroService {

    List<Menu> getMenuLista();

    void insertUsuarioMayor(UsuarioVO usuarioVO);

    UsuarioVO insertUsuario(UsuarioVO usuarioVO);

    UsuarioVO insertUsuarioAndUsuarioMayor(UsuarioVO usuarioVO);
}
