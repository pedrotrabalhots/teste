/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrfweb.model;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aluno
 */
public class CalculoTest {

     @Test
    public void testeCalculoDependentes() {
        double resultadoEsperado = 4550.16;
        Calculo calc = new Calculo(1, "Gustin", null, 9000, 900, 2, 250, 300, 150, 200);
        double resultadoObtido = calc.calculoDependentes();

        assertEquals(resultadoEsperado, resultadoObtido, 0.0);
    }
    
    @Test
    public void testeDeducoes() {
        double resultadoEsperado = 6350.16;
        Calculo calc = new Calculo(1, "Gustin", null, 9000, 900, 2, 250, 300, 150, 200);
        double resultadoObtido = calc.deducoes();

        assertEquals(resultadoEsperado, resultadoObtido, 0.0);
    }

    @Test
    public void testeBaseCalculo() {
        double resultadoEsperado = 2649.84;
        Calculo calc = new Calculo(1, "Gustin", null, 9000, 900, 2, 250, 300, 150, 200);
        double resultadoObtido = calc.baseCalculo();

        assertEquals(resultadoEsperado, resultadoObtido, 0.0);
    }

    @Test
    public void testeAliquotaEfetiva() {
        double resultadoEsperado = 2.1110519880445615;
        Calculo calc = new Calculo(1, "Gustin", null, 9000, 900, 2, 250, 300, 150, 200);
        double resultadoObtido = calc.aliquotaEfetiva();

        assertEquals(resultadoEsperado, resultadoObtido, 0.0);
    }
    
    

}
