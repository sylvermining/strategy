package com.silvermining.demo.controller;

import com.silvermining.demo.business.UsuarioService;
import com.silvermining.demo.wrapper.vo.UsuarioVO;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dolorierp on 07/03/16.
 */
@Controller
@RequestMapping("/logueo")
public class RegistroController {

    private static final Logger LOGGER = Logger.getLogger(RegistroController.class);

    private UsuarioService usuarioService;

    @ResponseBody
    @RequestMapping(value = "/registrar",
    method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean registrarUsuario(@RequestBody UsuarioVO usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

}
