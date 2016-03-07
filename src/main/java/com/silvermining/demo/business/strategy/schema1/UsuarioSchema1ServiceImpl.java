package com.silvermining.demo.business.strategy.schema1;

import com.silvermining.demo.business.strategy.UsuarioServiceImpl;
import com.silvermining.demo.dao.UsuarioDAO;
import com.silvermining.demo.entity.Usuario;
import com.silvermining.demo.wrapper.vo.UsuarioVO;

/**
 * Created by dolorierp on 07/03/16.
 */
public class UsuarioSchema1ServiceImpl
    extends UsuarioServiceImpl{

    private UsuarioDAO usuarioDAO;

    @Override
    public boolean registrarUsuario(UsuarioVO usuario) {
        Usuario user = new Usuario.UsuarioBuild()
                        .nombre(usuario.getNombre())
                        .password(usuario.getPassword())
                        .build();
        usuarioDAO.save(user);
        return false;
    }
}
