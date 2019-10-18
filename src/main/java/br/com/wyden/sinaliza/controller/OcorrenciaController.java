package br.com.wyden.sinaliza.controller;


import br.com.wyden.sinaliza.resources.Ocorrencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ocorrencias")
public class OcorrenciaController  {

    @RequestMapping(method = RequestMethod.GET)
    public List<Ocorrencia> listar(){
        List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
        return ocorrencias;
    }

}
