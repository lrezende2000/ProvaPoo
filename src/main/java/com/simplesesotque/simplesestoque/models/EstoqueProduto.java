package com.simplesesotque.simplesestoque.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estoque_produto")
public class EstoqueProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = true)
    private String descricao;
    
    @Column(name = "preco", nullable = false)
    private Double preco;
    
    @Column(name = "qtd_minima", nullable = false)
    private Double quantidadeMinima;
    
    @Column(name = "qtd_maxima", nullable = false)
    private Double quantidadeMaxima;
    
    @Column(name = "qtd_ideal", nullable = false)
    private Double quantidadeIdeal;
    
    @Column(name = "qtd_atual", nullable = false)
    private Double quantidadeAtual;
    
    @Column(name = "estoque_local_id", nullable = false)
    private Integer estoqueLocal;
    
    @Column(name = "categoria_id", nullable = false)
    private Integer categoria;
    
    @Column(name = "fornecedor_id", nullable = false)
    private Integer fornecedor;

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Double getQuantidadeMinima() {
        return quantidadeMinima;
    }
    public void setQuantidadeMinima(Double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }
    public Double getQuantidadeMaxima() {
        return quantidadeMaxima;
    }
    public void setQuantidadeMaxima(Double quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }
    public Double getQuantidadeIdeal() {
        return quantidadeIdeal;
    }
    public void setQuantidadeIdeal(Double quantidadeIdeal) {
        this.quantidadeIdeal = quantidadeIdeal;
    }
    public Double getQuantidadeAtual() {
        return quantidadeAtual;
    }
    public void setQuantidadeAtual(Double quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }
    public Integer getEstoqueLocal() {
        return estoqueLocal;
    }
    public void setEstoqueLocal(Integer estoqueLocal) {
        this.estoqueLocal = estoqueLocal;
    }
    public Integer getCategoria() {
        return categoria;
    }
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    public Integer getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Integer fornecedor) {
        this.fornecedor = fornecedor;
    }
  
}
