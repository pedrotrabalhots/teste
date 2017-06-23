/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrfweb.controller;

import br.com.irrfweb.action.ICommand;
import br.com.irrfweb.action.impl.BaseCalculoAction;
import br.com.irrfweb.action.impl.CalculoAction;
import br.com.irrfweb.action.impl.DeducoesAction;
import br.com.irrfweb.action.impl.ErroAction;
import br.com.irrfweb.action.impl.HomeAction;
import br.com.irrfweb.action.impl.ImpostoAction;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daves
 */
@WebServlet(name = "CommandController", urlPatterns = {"/irrf"})
public class IRRFController extends HttpServlet {

    private static final Map<String,ICommand> COMANDOS = new HashMap<String, ICommand>();
    
    static {
        COMANDOS.put("", new HomeAction());
        COMANDOS.put("erro", new ErroAction());
        COMANDOS.put("calculo", new CalculoAction());
        COMANDOS.put("ajaxDeducoes", new DeducoesAction());
        COMANDOS.put("ajaxBaseCalculo", new BaseCalculoAction());
        COMANDOS.put("ajaxImposto", new ImpostoAction());
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao = request.getParameter("op")==null?"":request.getParameter("op");
        try {            
            COMANDOS.get(acao).execute(request, response);
        } catch (Exception e) {
            try {
                request.setAttribute("erro", e.getMessage());
                COMANDOS.get("erro").execute(request, response);
            } catch (Exception ex) {
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
