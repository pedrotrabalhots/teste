/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrfweb.action.impl;

import br.com.irrfweb.action.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class ErroAction implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=erro");
        rd.forward(request, response);
    
    }
    
}
