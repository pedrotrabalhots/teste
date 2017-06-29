/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbunit.dao;

import br.com.irrfweb.dao.CalculoDAO;
import br.com.irrfweb.model.Calculo;
import dbunit.DbUnitHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.operation.DatabaseOperation;
import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author julio
 */
public class CalculoDAOTest {
    private static DbUnitHelper dbUnitHelper;
    private static EntityManagerFactory factory;
    
    private EntityManager manager;
    private CalculoDAO calculoDAO;
    
    @BeforeClass
    public static void initClass(){
        dbUnitHelper = new DbUnitHelper("DbUnitXml");
        factory = Persistence.createEntityManagerFactory("IRRFWebPU");
    }
    
    @Before
    public void init(){
        dbUnitHelper.execute(DatabaseOperation.DELETE_ALL,"Calculo.xml");
        dbUnitHelper.execute(DatabaseOperation.INSERT,"Calculo.xml");
        
        manager = factory.createEntityManager();
        this.calculoDAO = new CalculoDAO();
    }
    
    @After
    public void end(){
        this.manager.close();
    }
    
    @Test
    public void retornarTotalCalculo(){
        List<Calculo> resultado = calculoDAO.getAllCalculos();
       int  resultadoesperado = 2;
        Assert.assertEquals(resultadoesperado, resultado.size());
    }
    
    @Test
    public void retornarQuantidadeCalculo(){
        Long resultado = calculoDAO.getQTDECalculo();
        int resultadoesperado = 2;
        Assert.assertEquals(resultadoesperado,resultado.longValue());
    }
    
    @Test
    public void retornarCalculoDias() throws ParseException{
        
        SimpleDateFormat formata = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formata.parse("2017-06-28");
        List<Calculo> resultado = calculoDAO.getCalculosDia(data);
        int resultadoesperado = 1;
        Assert.assertEquals(resultadoesperado,resultado.size());
    }
}
