
package com.grules.soap.services;

import com.grules.lib.Evento;
import com.grules.services.dao.EventoDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.inject.Inject;

/**
 *
 * @author Gustavo Santos
 */
@WebService(serviceName = "EventoWebService")
public class GrulesWebService {

    @Inject
    private EventoDAO eventoDAO;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    public void saveEvento(Evento evento){
        eventoDAO.save(evento);
    }
    
}
