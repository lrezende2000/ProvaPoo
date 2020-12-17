package com.simplesesotque.simplesestoque.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "marca", nullable = false)
	private String marca;
	
    public long getId() {
        return id;
    }
	public String getNome() {
		return nome;
    }
	public void setNome(String nome) {
		this.nome = nome;
    }
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

}