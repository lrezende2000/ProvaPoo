package com.simplesesotque.simplesestoque.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venda_item")
public class VendaItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private long id;

    @Column(name = "venda_id", nullable = false)
    private Integer venda;

    @Column(name = "estoque_local_id", nullable = false)
    private Integer local;
    
    @Column(name = "estoque_produto_id", nullable = false)
    private Integer produto; 
    
    @Column(name = "quantidade", nullable = false)
    private Double quantidade;
    
    @Column(name = "desconto", nullable = false)
    private Double desconto;
    
    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;
    
    @Column(name = "cancelado", nullable = false)
    private Boolean cancelado;

    public long getId() {
        return id;
    }
    public Integer getVenda() {
        return venda;
    }
    public void setVenda(Integer venda) {
        this.venda = venda;
    }
    public Integer getLocal() {
        return local;
    }
    public void setLocal(Integer local) {
        this.local = local;
    }
    public Integer getProduto() {
        return produto;
    }
    public void setProduto(Integer produto) {
        this.produto = produto;
    }
    public Double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    public Double getDesconto() {
        return desconto;
    }
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    public Double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public Boolean getCancelado() {
        return cancelado;
    }
    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }
    
}
