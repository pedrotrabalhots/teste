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
public class DeducoesAction implements ICommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//contribuicao: $("#cpContri").val(), dependentes: $("#cpDepend").val(),
//                    pensao: $("#cpPensao").val(), medico: $("#cpMedico").val(), 
//                    educacao: $("#cpEducacao").val(), outros: $("#cpOutras").val()
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");

        final double cont = convertValues(df, request.getParameter("contribuicao"));        
        final double pensao = convertValues(df, request.getParameter("pensao"));
        final double medico = convertValues(df, request.getParameter("medico"));
        final double educacao = convertValues(df, request.getParameter("educacao"));
        final double outros = convertValues(df, request.getParameter("outros"));

        Calculo c = new Calculo(null, "", null, 0, cont,
                Integer.parseInt(request.getParameter("dependentes")), pensao, medico, educacao, outros);
        response.getWriter().print(df.format(c.deducoes()));
        response.getWriter().close();

    }

    private double convertValues(DecimalFormat df, String param) {
        double cont;
        try {
            cont = df.parse(param).doubleValue();
        } catch (Exception e) {
            cont = 0;
        }
        return cont;
    }

}
