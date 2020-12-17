package com.simplesesotque.simplesestoque.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private long id;

    @Column(name = "pessoa_id", nullable = false)
    private Integer pessoa;

    @Column(name = "empresa_id", nullable = false)
    private Integer empresa;
    
    @Column(name = "numero_carteira_trabalho", nullable = false)
    private String carteriaTrabalho;
    
    @Column(name = "cargo", nullable = false)
    private String cargo;
    
    @Column(name = "data_admissao", nullable = false)
    private String dataAdmissao;
    
    @Column(name = "data_demissao", nullable = true)
    private String dataDemissao;
    
    @Column(name = "ativo", nullable = true)
    private Boolean situacao;
    
    @Column(name = "salario_base", nullable = false)
    private Double salarioBase;

    public long getId() {
        return id;
    }
    public Integer getPessoa() {
        return pessoa;
    }
    public void setPessoa(Integer pessoa) {
        this.pessoa = pessoa;
    }
    public Integer getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }
    public String getCarteriaTrabalho() {
        return carteriaTrabalho;
    }
    public void setCarteriaTrabalho(String carteriaTrabalho) {
        this.carteriaTrabalho = carteriaTrabalho;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getDataAdmissao() {
        return dataAdmissao;
    }
    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    public String getDataDemissao() {
        return dataDemissao;
    }
    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
    public Boolean getSituacao() {
        return situacao;
    }
    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }
    public Double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

}
