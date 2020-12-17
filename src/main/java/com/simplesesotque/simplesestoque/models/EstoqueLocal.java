package com.simplesesotque.simplesestoque.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "estoque_local")
public class EstoqueLocal implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "rua", nullable = false)
    private String rua;
    
    @Column(name = "numero", nullable = false)
    private String numero;
    
    @Column(name = "bairro", nullable = false)
    private String bairro;
    
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @Column(name = "estado", nullable = false)
    private String estado;
    
    @Column(name = "cep", nullable = false)
    private String cep;
    
    @Column(name = "complemento", nullable = true)
    private String complemento;
    
    @Column(name = "empresa_id", nullable = false)
    private Integer empresa;

    @Column(name = "estoque_maximo", nullable = false)
    private Integer capacidadeMaxima;

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public Integer getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }
    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
    
}
