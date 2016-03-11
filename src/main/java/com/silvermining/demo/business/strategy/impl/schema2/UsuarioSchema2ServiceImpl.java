package com.silvermining.demo.business.strategy.impl.schema2;

import com.silvermining.demo.business.strategy.impl.UsuarioServiceImpl;
import com.silvermining.demo.dao.UsuarioMayorDAO;
import com.silvermining.demo.entity.Usuario;
import com.silvermining.demo.entity.UsuarioMayor;
import com.silvermining.demo.wrapper.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dolorierp on 07/03/16.
 */
@Service
public class UsuarioSchema2ServiceImpl
        extends UsuarioServiceImpl {

    @Autowired
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

    @Override
    public UsuarioVO getUsuario(String nombre) {
        UsuarioMayor usuario = usuarioMayorDAO.getUsuarioPorNombre(nombre);
        UsuarioVO usuarioVO = new UsuarioVO.UsuarioVOBuilder()
                .id(usuario.getId())
                .nombre(usuario.getUsuario().getNombre())
                .profesion(usuario.getProfesion())
                .builder();
        return usuarioVO;
    }

}
