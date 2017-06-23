/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrfweb.action.impl;

import br.com.irrfweb.action.ICommand;
import br.com.irrfweb.dao.CalculoDAO;
import br.com.irrfweb.model.Calculo;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class HomeAction implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        List<Calculo> lista = new CalculoDAO().getAllCalculos();
        
        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
        rd.forward(request, response);
    
    }
    
}
