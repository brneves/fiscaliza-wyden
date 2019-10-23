package br.com.wyden.sinaliza.resources;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ocorrencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coordenada_x", nullable = false)
    private String coordenada_x;

    @Column(name = "coordenada_y", nullable = false)
    private String coordenada_y;

    @Column(name = "foto")
    private String foto;

    @Column(name = "data_cadastro", nullable = false)
    private String dataCadastro;

    @Column(name = "status", nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(String coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public String getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(String coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
