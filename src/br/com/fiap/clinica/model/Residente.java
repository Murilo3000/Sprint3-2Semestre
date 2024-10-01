package br.com.fiap.clinica.model;

public class Residente {

    private int id;
    private String nome;
    private String email;
    private String dataNascimento;
    private int anoResidencia;
    private String senha;
    private boolean ativo;

    public Residente(int id, String nome, String email, String dataNascimento, int anoResidencia, String senha, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.anoResidencia = anoResidencia;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Residente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getAnoResidencia() {
        return anoResidencia;
    }

    public void setAnoResidencia(int anoResidencia) {
        this.anoResidencia = anoResidencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
