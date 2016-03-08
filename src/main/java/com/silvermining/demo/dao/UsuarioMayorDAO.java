package com.silvermining.demo.dao;

import com.silvermining.demo.dao.parent.GenericDAO;
import com.silvermining.demo.entity.UsuarioMayor;

/**
 * Created by dolorierp on 06/03/16.
 */
public interface UsuarioMayorDAO extends GenericDAO<UsuarioMayor, Long> {
    UsuarioMayor getUsuarioPorNombre(String nombre);
}
