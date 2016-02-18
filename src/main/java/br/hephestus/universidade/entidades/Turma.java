package br.hephestus.universidade.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by igor on 18/02/16.
 */
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;

    @Column
    @NotNull(message = "Informe o nome da turma")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    @NotNull(message = "Informe o curso")
    private Curso curso;

    @ManyToMany(mappedBy = "turmas")
    private List<Aluno> alunos;

    @ManyToMany
    @JoinTable(name = "TurmaHorario",
                joinColumns = @JoinColumn(name = "idTurma"),
                inverseJoinColumns = @JoinColumn(name = "idHorario"))
    private List<Horario> horarios;

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
