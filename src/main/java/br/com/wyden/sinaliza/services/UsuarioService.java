package br.com.wyden.sinaliza.services;

import br.com.wyden.sinaliza.repository.UsuarioRepository;
import br.com.wyden.sinaliza.resources.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll(){
        List<Usuario> usuarios = repository.findAll();
        return usuarios;
    }

    public Usuario get(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Usuario create(Usuario obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Usuario update(Usuario obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
