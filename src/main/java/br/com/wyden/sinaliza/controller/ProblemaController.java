package br.com.wyden.sinaliza.controller;

import br.com.wyden.sinaliza.resources.Problema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/problema")
public class ProblemaController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Problema> listar(){
        List<Problema> problemas = new ArrayList<Problema>();
        return problemas;
    }

}
