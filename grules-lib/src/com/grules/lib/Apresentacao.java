
package com.grules.lib;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@TableGenerator(name = "apresentacao_id", initialValue = 1, allocationSize = 1)
public class Apresentacao implements Serializable {
    
    @Id()
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "apresentacao_id")
    @Column(name = "apresentacao_id")
    private Integer id;
    
    @Column(length = 100)
    private String titulo;
    
    @Column(columnDefinition = "TEXT")
    private String resumo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    
    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "evento_id")
    private Evento evento;
    
    @OneToMany
    @JoinTable(name = "alunos_evento",
            joinColumns = {@JoinColumn(name = "apresentacao_id", referencedColumnName = "apresentacao_id")},
            inverseJoinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "aluno_id"))
    private List<Aluno> alunos;

    public Apresentacao() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Apresentacao other = (Apresentacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
