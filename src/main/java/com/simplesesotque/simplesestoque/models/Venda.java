package com.simplesesotque.simplesestoque.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private long id;

    @Column(name = "funcionario_id", nullable = false)
    private Integer funcionario;

    @Column(name = "cliente_id", nullable = false)
    private Integer cliente;
    
    @Column(name = "entregador_id", nullable = true)
    private Integer entregador;
    
    @Column(name = "parcelas", nullable = true)
    private Integer numeroParcelas;
    
    @Column(name = "data_venda")
    private String dataVenda;
    
    @Column(name = "hora_venda")
    private String horaVenda;
    
    @Column(name = "numero_cartao", nullable = true)
    private String numeroCartao;
    
    @Column(name = "data_validade_cartao", nullable = true)
    private String dataValidadeCartao;
    
    @Column(name = "numero_boleto", nullable = true)
    private String numeroBoleto;
    
    @Column(name = "placa_veiculo", nullable = true)
    private String placaVeiculo;
    
    @Column(name = "status", nullable = true)
    private String vendaStatus;
    
    @Column(name = "forma_pagamento", nullable = true)
    private String formaPagemento;
    
    @Column(name = "origem", nullable = true)
    private String vendaOrigem;
    
    @Column(name = "valor_total", nullable = true)
    private Double valorTotal;
    
    @Column(name = "valor_frete", nullable = true)
    private Double valorFrete;
    
    @Column(name = "desconto", nullable = true)
    private Double desconto;
    
    @Column(name = "entrega", nullable = true)
    private Boolean entrega;

    public long getId() {
        return id;
    }
    public Integer getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }
    public Integer getCliente() {
        return cliente;
    }
    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }
    public Integer getEntregador() {
        return entregador;
    }
    public void setEntregador(Integer entregador) {
        this.entregador = entregador;
    }
    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }
    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
    public String getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    public String getHoraVenda() {
        return horaVenda;
    }
    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }
    public String getNumeroCartao() {
        return numeroCartao;
    }
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    public String getDataValidadeCartao() {
        return dataValidadeCartao;
    }
    public void setDataValidadeCartao(String dataValidadeCartao) {
        this.dataValidadeCartao = dataValidadeCartao;
    }
    public String getNumeroBoleto() {
        return numeroBoleto;
    }
    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    public String getVendaStatus() {
        return vendaStatus;
    }
    public void setVendaStatus(String vendaStatus) {
        this.vendaStatus = vendaStatus;
    }
    public String getFormaPagemento() {
        return formaPagemento;
    }
    public void setFormaPagemento(String formaPagemento) {
        this.formaPagemento = formaPagemento;
    }
    public String getVendaOrigem() {
        return vendaOrigem;
    }
    public void setVendaOrigem(String vendaOrigem) {
        this.vendaOrigem = vendaOrigem;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Double getValorFrete() {
        return valorFrete;
    }
    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }
    public Double getDesconto() {
        return desconto;
    }
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    public Boolean getEntrega() {
        return entrega;
    }
    public void setEntrega(Boolean entrega) {
        this.entrega = entrega;
    }
    
}
