package com.silvermining.demo.dao.impl;

import com.silvermining.demo.dao.UsuarioDAO;
import com.silvermining.demo.dao.parent.impl.GenericDAOImpl;
import com.silvermining.demo.entity.Usuario;

/**
 * Created by dolorierp on 06/03/16.
 */
public class UsuarioDAOImpl  extends GenericDAOImpl<Usuario, Long>  implements UsuarioDAO {

    @Override
    public Usuario getUsuarioPorNombre(String nombre) {
        return null;
    }
}
