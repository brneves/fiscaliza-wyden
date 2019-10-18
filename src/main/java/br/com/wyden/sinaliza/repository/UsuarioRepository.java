package br.com.wyden.sinaliza.repository;

import br.com.wyden.sinaliza.resources.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNome(String nome);
    Usuario findByEmail(String email);

}
