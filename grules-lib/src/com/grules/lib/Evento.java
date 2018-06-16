package com.grules.lib;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "evento_id", initialValue = 1, allocationSize = 1)
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "evento_id")
    @Column(name = "evento_id")
    private Integer id;

    @Column(length = 7, nullable = false)
    private String semestre;

    @Column(length = 50, nullable = false)
    private String tema;

    @OneToMany
    @JoinTable(name = "alunos_evento",
            joinColumns = {@JoinColumn(name = "evento_id", referencedColumnName = "evento_id")},
            inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "aluno_id"))
    private List<Aluno> alunos;

    public Evento() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
