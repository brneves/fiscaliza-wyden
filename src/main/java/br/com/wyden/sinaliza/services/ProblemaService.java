package br.com.wyden.sinaliza.services;

import br.com.wyden.sinaliza.repository.ProblemaRepository;
import br.com.wyden.sinaliza.resources.Problema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemaService {

    @Autowired
    private ProblemaRepository repository;

    public List<Problema> getAll(){
        List<Problema> problemas = repository.findAll();
        return problemas;
    }

    public Problema get(Long id){
        Optional<Problema> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Problema create(Problema obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Problema update(Problema obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
