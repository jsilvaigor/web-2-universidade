package br.hephestus.universidade.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by igor on 18/02/16.
 */
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;

    @Column
    @NotNull(message = "Informe o nome")
    private String nome;

    @Column
    @NotNull(message = "Informe o CPF")
    private String cpf;

    private String email;

    @OneToMany(mappedBy = "aluno")
    private List<Boleto> boletos;

    @ManyToMany
    @JoinTable(name = "AlunoTurma",
                joinColumns = @JoinColumn(name = "matricula"),
                inverseJoinColumns = @JoinColumn(name = "idTurma"))
    private List<Turma> turmas;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }


}
