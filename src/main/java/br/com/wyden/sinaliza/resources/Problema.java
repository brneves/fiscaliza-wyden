package br.com.wyden.sinaliza.resources;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Problema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problema", nullable = false)
    private String problema;

    public Long getId() {
        return id;
    }

    public String getProblema() {
        return problema;
    }
}
