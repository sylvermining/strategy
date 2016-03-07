package com.silvermining.demo.business.strategy.schema2;

import com.silvermining.demo.business.strategy.UsuarioServiceImpl;
import com.silvermining.demo.dao.UsuarioMayorDAO;
import com.silvermining.demo.entity.Usuario;
import com.silvermining.demo.entity.UsuarioMayor;
import com.silvermining.demo.wrapper.vo.UsuarioVO;

/**
 * Created by dolorierp on 07/03/16.
 */
public class UsuarioSchema2ServiceImpl
        extends UsuarioServiceImpl {

    UsuarioMayorDAO usuarioMayorDAO;

    @Override
    public boolean registrarUsuario(UsuarioVO usuario) {
        Usuario user = new Usuario.UsuarioBuild()
                .nombre(usuario.getNombre())
                .password(usuario.getPassword())
                .build();
        UsuarioMayor usuarioMayor = new UsuarioMayor.UsuarioMayorBuild()
                    .usuario(user)
                    .profession(usuario.getProfesion())
                    .build();
        usuarioMayorDAO.save(usuarioMayor);
        return false;
    }
}
