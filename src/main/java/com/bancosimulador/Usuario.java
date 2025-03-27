package com.bancosimulador;

public class Usuario {
    private Long id;
    private String cpf;
    private String nascimento;
    private String agencia;
    private String conta;
    private String senha;

    // Constructor, getters, and setters
    public Usuario() {}

    public Usuario(String cpf, String nascimento, String agencia, String conta, String senha) {
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.agencia = agencia;
        this.conta = conta;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
