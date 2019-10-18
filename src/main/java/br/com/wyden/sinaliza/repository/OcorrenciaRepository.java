package br.com.wyden.sinaliza.repository;

import br.com.wyden.sinaliza.resources.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

    List<Ocorrencia> findByCoordenada_x(String coordenada_x);
    List<Ocorrencia> findByCoordenada_y(String coordenada_y);

}
