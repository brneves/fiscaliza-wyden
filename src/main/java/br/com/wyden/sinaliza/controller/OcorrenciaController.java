package br.com.wyden.sinaliza.controller;

import br.com.wyden.sinaliza.repository.ProblemaRepository;
import br.com.wyden.sinaliza.repository.UsuarioRepository;
import br.com.wyden.sinaliza.resources.Ocorrencia;
import br.com.wyden.sinaliza.services.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @Autowired
    private UsuarioRepository ur;

    @Autowired
    private ProblemaRepository pr;

    @RequestMapping(value = "/")
    public String index(Model model){
        List<Ocorrencia> ocorrencias = service.getAll();
        model.addAttribute("ocorrencias", ocorrencias);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Ocorrencia>> getAll(){
        List<Ocorrencia> ocorrencias = service.getAll();
        return ResponseEntity.ok().body(ocorrencias);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ocorrencia> get(@PathVariable Long id){
        Ocorrencia obj = service.get(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Void> create(@RequestBody Ocorrencia obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Ocorrencia obj, @PathVariable Long id){
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
