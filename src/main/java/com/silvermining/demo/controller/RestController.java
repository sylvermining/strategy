package com.silvermining.demo.controller;

import com.silvermining.demo.business.MaestroService;
import com.silvermining.demo.entity.Menu;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by pooldolorier on 09/03/16.
 */
@Controller
@RequestMapping("rest")
public class RestController {

    private static final Logger LOGGER =
            Logger.getLogger(RestController.class);

    @Autowired
    private MaestroService maestroService;

    @RequestMapping(value = "/menulist", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Menu> getMenuLista() {
        return maestroService.getMenuLista();
    }


    /*@Autowired
    ModuloFactory moduloFactory;

    @RequestMapping(value = "/login", method = RequestMethod.GET,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean login(@PathVariable("usuario") String usuario,
                         @PathVariable("password") String password,
                         @PathVariable("perfil") String perfil) {
        boolean success = moduloFactory.getUsuarioService(ModuloEnum.USUARIO)
                .login(usuario, password, perfil);
        return success;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean login(@PathVariable("usuario") String usuario,
                         @PathVariable("password") String password,
                         @PathVariable("repeatPassword") String repeatPassword) {
        boolean success = moduloFactory.getUsuarioService(ModuloEnum.USUARIO)
                .singup(usuario, password, repeatPassword);
        return success;
    }

    @RequestMapping(value = "/getUsuarioPerfilPorUsuario", method = RequestMethod.GET,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PerfilVO> perfilList(@PathVariable("usuario") String usuario,
                                     @PathVariable("modulo") String modulo) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        List<PerfilVO> perfilLista = moduloFactory.getConfiguracionService(moduloEnum)
                .getPerfilList(usuario);
        return perfilLista;
    }

    @RequestMapping(value = "/getUsuarioRolesPorPerfil", method = RequestMethod.GET,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<RolVO> rolList(@PathVariable("usuario") String usuario,
                               @PathVariable("modulo") String modulo,
                               @PathVariable("perfil") String perfil) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        List<RolVO> rolLista = moduloFactory.getConfiguracionService(moduloEnum)
                .getRolList(perfil);
        return rolLista;
    }

    @RequestMapping(value = "/getUsuarioMenusPorRol", method = RequestMethod.GET,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MenuVO> menuList(@PathVariable("usuario") String usuario,
                                 @PathVariable("modulo") String modulo,
                                 @PathVariable("rol") String[] roles) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        List<MenuVO> menuLista = moduloFactory.getConfiguracionService(moduloEnum)
                .getMenuList(roles);
        return menuLista;
    }


    @RequestMapping(value = "/addPerfilAUsuario", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean addPerfilToUser(@PathVariable("usuario") String usuario,
                                   @PathVariable("modulo") String modulo,
                                   @PathVariable("perfil") String[] perfiles) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        boolean success = moduloFactory.getConfiguracionService(moduloEnum)
                .addPerfil(usuario, perfiles);
        return success;
    }

    @RequestMapping(value = "/addRolAPerfil", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean addRolToPerfil(@PathVariable("modulo") String modulo,
                                  @PathVariable("perfil") String perfil,
                                  @PathVariable("role") String[] roles) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        boolean success = moduloFactory.getConfiguracionService(moduloEnum)
                .addRol(perfil, roles);
        return success;
    }

    @RequestMapping(value = "/addMenuARol", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean addMenuToRol(@PathVariable("modulo") String modulo,
                                @PathVariable("rol") String rol,
                                @PathVariable("menu") String[] menus) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        boolean success = moduloFactory.getConfiguracionService(moduloEnum)
                .addMenu(rol, menus);
        return success;
    }

    @RequestMapping(value = "/getUsuarios", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UsuarioVO> addMenuToRol(@PathVariable("modulo") String modulo) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        List<UsuarioVO> lista = moduloFactory.getUsuarioService(moduloEnum)
                .usuariosList();
        return lista;
    }

    @RequestMapping(value = "/getPerfiles", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PerfilVO> addMenuToRol(@PathVariable("modulo") String modulo) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        List<PerfilVO> perfilLista = moduloFactory.getConfiguracionService(moduloEnum)
                .perfilLista();
        return perfilLista;
    }

    @RequestMapping(value = "/getRoles", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<RolVO> addMenuToRol(@PathVariable("modulo") String modulo) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        List<RolVO> rolLista = moduloFactory.getConfiguracionService(moduloEnum)
                .rolLista();
        return rolLista;
    }

    @RequestMapping(value = "/getMenu", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MenuVO> addMenuToRol(@PathVariable("modulo") String modulo) {
        ModuloEnum moduloEnum = ModuloEnum.getModuloPorCodigo(modulo);
        List<MenuVO> rolLista = moduloFactory.getConfiguracionService(moduloEnum)
                .rolLista();
        return rolLista;
    }
    */
}
