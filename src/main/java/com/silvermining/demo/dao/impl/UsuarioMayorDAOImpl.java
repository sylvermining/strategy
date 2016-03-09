package com.silvermining.demo.dao.impl;

import com.silvermining.demo.dao.UsuarioMayorDAO;
import com.silvermining.demo.dao.parent.impl.GenericDAOImpl;
import com.silvermining.demo.entity.Usuario;
import com.silvermining.demo.entity.UsuarioMayor;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by dolorierp on 06/03/16.
 */
public class UsuarioMayorDAOImpl extends GenericDAOImpl<UsuarioMayor, Long> implements UsuarioMayorDAO {

    @Override
    public UsuarioMayor getUsuarioPorNombre(String nombre) {
        Query query = getSession().getNamedQuery("getUsuarioMayorPorNombre")
                .setString("nombre", nombre);
        List<Object[]> list = query.list();
        return (UsuarioMayor)list.get(0)[0];
    }
}
