package br.com.wyden.sinaliza.controller;

import br.com.wyden.sinaliza.resources.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> listar(){
        List<Usuario> usuarios  = new ArrayList<Usuario>();
        return usuarios;
    }

}
