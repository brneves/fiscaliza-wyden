package br.com.wyden.sinaliza.repository;

import br.com.wyden.sinaliza.resources.Problema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemaRepository extends JpaRepository<Problema, Long> {

}
