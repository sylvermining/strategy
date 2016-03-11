package com.silvermining.demo.business.strategy;

import com.silvermining.demo.wrapper.vo.UsuarioVO;

/**
 * Created by dolorierp on 07/03/16.
 */
public interface UsuarioService {
    boolean registrarUsuario(UsuarioVO usuario);
    UsuarioVO getUsuario(String nombre);
}
