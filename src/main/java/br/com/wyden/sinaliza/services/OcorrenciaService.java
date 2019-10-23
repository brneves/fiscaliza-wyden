package br.com.wyden.sinaliza.services;

import br.com.wyden.sinaliza.repository.OcorrenciaRepository;
import br.com.wyden.sinaliza.resources.Ocorrencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    public List<Ocorrencia> getAll(){
        List<Ocorrencia> ocorrencias = repository.findAll();
        return ocorrencias;
    }

    public Ocorrencia get(Long id){
        Optional<Ocorrencia> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Ocorrencia create(Ocorrencia obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Ocorrencia update(Ocorrencia obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
