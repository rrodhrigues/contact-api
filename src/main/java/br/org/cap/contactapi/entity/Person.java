package br.org.cap.contactapi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Person implements Serializable {

    private Long id;

    private String nome;

    private String codigo;

    private String pathOfFoto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPathOfFoto() {
        return pathOfFoto;
    }

    public void setPathOfFoto(String pathOfFoto) {
        this.pathOfFoto = pathOfFoto;
    }
}
