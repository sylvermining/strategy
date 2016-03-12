package com.silvermining.demo.business.strategy.impl.schema1;

import com.silvermining.demo.business.strategy.impl.UsuarioServiceImpl;
import com.silvermining.demo.dao.UsuarioDAO;
import com.silvermining.demo.entity.Usuario;
import com.silvermining.demo.wrapper.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dolorierp on 07/03/16.
 */
@Service
public class UsuarioSchema1ServiceImpl
    extends UsuarioServiceImpl{

    @Autowired
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

    @Override
    public UsuarioVO getUsuario(String nombre) {
        Usuario usuario = usuarioDAO.getUsuarioPorNombre(nombre);
        UsuarioVO usuarioVO = new UsuarioVO.UsuarioVOBuilder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .builder();
        return usuarioVO;
    }

    @Override
    public List<UsuarioVO> getAllUsers() {
        List<Usuario> usuarios =
                usuarioDAO.getAll();
        List<UsuarioVO> usuarioVOs =
                new ArrayList<UsuarioVO>();
        Iterator<Usuario> usuarioIterator =
                usuarios.iterator();
        while(usuarioIterator.hasNext()) {
            Usuario usuario = usuarioIterator.next();
            UsuarioVO usuarioVO = new UsuarioVO.UsuarioVOBuilder()
                    .nombre(usuario.getNombre())
                    .id(usuario.getId())
                    .builder();
            usuarioVOs.add(usuarioVO);
        }
        return usuarioVOs;
    }

}
