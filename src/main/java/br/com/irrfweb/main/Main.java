/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrfweb.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daves
 */
public class Main {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CalculadoraWebPU");
        EntityManager manager = emf.createEntityManager();
        
        System.out.println("==>"+manager.getMetamodel().toString());
       
    }
    
}
