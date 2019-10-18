package br.com.wyden.sinaliza.resources;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Ocorrencia implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ocorrencia(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coordenada_x", nullable = false)
    private String coordenada_x;

    @Column(name = "coordenada_y", nullable = false)
    private String coordenada_y;

    @Column(name = "foto", nullable = true)
    private String foto;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public Long getId() {
        return id;
    }

    public String getCoordenada_x() {
        return coordenada_x;
    }

    public String getCoordenada_y() {
        return coordenada_y;
    }

    public String getFoto() {
        return foto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Boolean getStatus() {
        return status;
    }
}
