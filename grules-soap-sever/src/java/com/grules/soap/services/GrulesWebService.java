package com.grules.soap.services;

import com.grules.lib.Aluno;
import com.grules.lib.Apresentacao;
import com.grules.lib.Evento;
import com.grules.services.dao.AlunoDAO;
import com.grules.services.dao.ApresentacaoDAO;
import com.grules.services.dao.EventoDAO;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.inject.Inject;

/**
 *
 * @author Gustavo Santos
 */
@WebService(serviceName = "EventoWebService")
public class GrulesWebService {

    @Inject
    private EventoDAO eventoDAO;
    
    @Inject
    private ApresentacaoDAO apresentacaoDAO;
    
    @Inject
    private AlunoDAO alunoDAO;

    public void saveEvento(Evento evento) {
        eventoDAO.save(evento);
    }

    public void saveApresentacao(Apresentacao apresentacao) {
        apresentacaoDAO.save(apresentacao);
    }

    public void saveAluno(Aluno aluno) {
        alunoDAO.save(aluno);
    }

    public void updateEvento(Evento evento) {
        eventoDAO.update(evento);
    }

    public void updateApresentacao(Apresentacao apresentacao) {
        apresentacaoDAO.update(apresentacao);
    }

    public void updateAluno(Aluno aluno) {
        alunoDAO.update(aluno);
    }

    public void deleteEvento(Evento evento) {
        eventoDAO.delete(evento);
    }

    public void deleteApresentacao(Apresentacao apresentacao) {
        apresentacaoDAO.delete(apresentacao);
    }

    public void deleteAluno(Aluno aluno) {
        alunoDAO.delete(aluno);
    }

    public Evento findEvento(Object id) {
        Evento find = eventoDAO.find(id);
        return find;
    }

    public Apresentacao findApresentacao(Object id) {
        Apresentacao find = apresentacaoDAO.find(id);
        return find;
    }

    public Aluno findAluno(Object id) {
        Aluno find = alunoDAO.find(id);
        return find;
    }

    public List<Evento> loadAllEvento() {
        List<Evento> loadAll = eventoDAO.loadAll();
        return loadAll;
    }

    public List<Apresentacao> loadAllApresentacao() {
        List<Apresentacao> loadAll = apresentacaoDAO.loadAll();
        return loadAll;
    }

    public List<Apresentacao> loadApresentacaoPorDia(String data, Integer eventoId) {
        List<Apresentacao> result = apresentacaoDAO.loadByData(data, eventoId);
        return result;
    }
    
    public List<String> loadDistinctDatasPorApresentacao(Integer id) {
        List<String> result = apresentacaoDAO.loadDistinctDatasPorApresentacao(id);
        return result;
    }

    public List<Aluno> loadAllAluno() {
        List<Aluno> loadAll = alunoDAO.loadAll();
        return loadAll;
    }

}
