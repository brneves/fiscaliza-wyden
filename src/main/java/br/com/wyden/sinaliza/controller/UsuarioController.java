package br.com.wyden.sinaliza.controller;

import br.com.wyden.sinaliza.resources.Usuario;
import br.com.wyden.sinaliza.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = service.getAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> get(@PathVariable Long id){
        Usuario obj = service.get(id);
        return ResponseEntity.ok().body(obj);
    }

    /*
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Usuario obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
     */

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Usuario obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return true;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable Long id){
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
