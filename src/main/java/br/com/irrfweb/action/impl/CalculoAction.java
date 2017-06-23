/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrfweb.action.impl;

import br.com.irrfweb.action.ICommand;
import br.com.irrfweb.dao.CalculoDAO;
import br.com.irrfweb.model.Calculo;
import java.text.DecimalFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
public class CalculoAction implements ICommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        Calculo calc = new Calculo(null, request.getParameter("cpNome"),
                new Date(), df.parse(request.getParameter("cpRend")).doubleValue(),
                df.parse(request.getParameter("cpContri")).doubleValue(),
                Integer.parseInt(request.getParameter("cpDepend")),
                df.parse(request.getParameter("cpPensao")).doubleValue(),
                df.parse(request.getParameter("cpMedico")).doubleValue(),
                df.parse(request.getParameter("cpEducacao")).doubleValue(),
                df.parse(request.getParameter("cpOutras")).doubleValue());

        new CalculoDAO().gravar(calc);
        
        request.setAttribute("msg", "Salvo com Sucesso!!!");

        new HomeAction().execute(request, response);

    }

}
