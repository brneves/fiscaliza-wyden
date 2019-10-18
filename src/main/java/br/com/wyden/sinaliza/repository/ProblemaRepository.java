package br.com.wyden.sinaliza.repository;

import br.com.wyden.sinaliza.resources.Problema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemaRepository extends JpaRepository<Problema, Long> {

    List<Problema> findByProblema(String problema);

}
