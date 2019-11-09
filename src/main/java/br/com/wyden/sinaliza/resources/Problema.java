package br.com.wyden.sinaliza.resources;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Problema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problema", nullable = false)
    private String problema;

    @Column(name = "icone")
    private String icone;

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    //ALTERAÇÕES A PARTIR DAQUI
    /*
    public Problema(){

    }

    public Problema(Long id, String problema, String icone){
        super();
        this.id = id;
        this.problema = problema;
        this.icone = icone;
    }

    @OneToMany(mappedBy = "problema", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
     */
}
