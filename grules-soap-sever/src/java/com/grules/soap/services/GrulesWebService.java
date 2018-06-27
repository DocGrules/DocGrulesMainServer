package com.grules.soap.services;

import com.grules.lib.Aluno;
import com.grules.lib.Apresentacao;
import com.grules.lib.Evento;
import com.grules.services.dao.AlunoDAO;
import com.grules.services.dao.ApresentacaoDAO;
import com.grules.services.dao.EventoDAO;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.jws.WebService;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;

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
    
    @WebMethod(operationName = "saveEvento")
    public void saveEvento(@WebParam(name = "evento") Evento evento) {
        eventoDAO.save(evento);
    }
    
    @WebMethod(operationName = "updateEvento")
    public void updateEvento(@WebParam(name = "evento") Evento evento) {
        eventoDAO.update(evento);
    }
    
    @WebMethod(operationName = "deleteEvento")
    public void deleteEvento(@WebParam(name = "evento") Evento evento) {
        eventoDAO.delete(evento);
    }
    
    @WebMethod(operationName = "findEvento")
    public Evento findEvento(@WebParam(name = "id") Object id) {
        Evento find = eventoDAO.find(id);
        return find;
    }
    
    @WebMethod(operationName = "loadAllEvento")
    public List<Evento> loadAllEvento() {
        List<Evento> loadAll = eventoDAO.loadAll();
        return loadAll;
    } 
    
    @WebMethod(operationName = "loadAllSemestre")    
    public List<String> loadAllSemestre() {
        List<String> loadAll = eventoDAO.loadAllSemestre();
        return loadAll;
    }
    
    @WebMethod(operationName = "saveApresentacao")
    public void saveApresentacao(@WebParam(name = "apresentacao") Apresentacao apresentacao) {
        apresentacaoDAO.save(apresentacao);
    }
    
    @WebMethod(operationName = "updateApresentacao")
    public void updateApresentacao(@WebParam(name = "apresentacao") Apresentacao apresentacao) {
        apresentacaoDAO.update(apresentacao);
    }  
    
    @WebMethod(operationName = "deleteApresentacao")
    public void deleteApresentacao(@WebParam(name = "apresentacao") Apresentacao apresentacao) {
        apresentacaoDAO.delete(apresentacao);
    }
    
    @WebMethod(operationName = "findApresentacao")
    public Apresentacao findApresentacao(@WebParam(name = "id") Object id) {
        Apresentacao find = apresentacaoDAO.find(id);
        return find;
    }  
    
    @WebMethod(operationName = "loadAllApresentacao")
    public List<Apresentacao> loadAllApresentacao() {
        List<Apresentacao> loadAll = apresentacaoDAO.loadAll();
        return loadAll;
    }
    
    @WebMethod(operationName = "saveAluno")
    public void saveAluno(@WebParam(name = "aluno") Aluno aluno) {
        alunoDAO.save(aluno);
    }

    @WebMethod(operationName = "updateAluno")
    public void updateAluno(@WebParam(name = "aluno") Aluno aluno) {
        alunoDAO.update(aluno);
    }

    @WebMethod(operationName = "deleteAluno")
    public void deleteAluno(@WebParam(name = "aluno") Aluno aluno) {
        alunoDAO.delete(aluno);
    }
    
    @WebMethod(operationName = "findAluno")
    public Aluno findAluno(@WebParam(name = "id") Object id) {
        Aluno find = alunoDAO.find(id);
        return find;
    }

//    public HashMap<Date, List<Apresentacao>> loadApresentacaoPorDia() {
//        return apresentacaoDAO.apresentacaoPorDia();
//    }

    @WebMethod(operationName = "loadAllAluno")
    public List<Aluno> loadAllAluno() {
        List<Aluno> loadAll = alunoDAO.loadAll();
        return loadAll;
    }
    
    @WebMethod(operationName = "verificaMatricula")
    public boolean verificaMatricula(@WebParam(name = "matricula") String matricula){
        boolean verificar = alunoDAO.verificaMatricula(matricula);
        return verificar;
    }
}
