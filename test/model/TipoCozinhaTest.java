/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yukas
 */
public class TipoCozinhaTest {
    
    public TipoCozinhaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void Sunday() {
        System.out.println("Sunday");
        TipoCozinha instance = new TipoCozinha();
        instance.setDayOfWeek("Sunday");
        String resultadoEsperado = "frios";
        String resultado = instance.promocaoSemana();
        String resultadoObtido = (String) resultado;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
     @Test
    public void Monday() {
        System.out.println("Monday");
        TipoCozinha instance = new TipoCozinha();
        instance.setDayOfWeek("Monday");
        String resultadoEsperado = "quentes";
        String resultado = instance.promocaoSemana();
        String resultadoObtido = (String) resultado;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void Tuesday() {
        System.out.println("Tuesday");
        TipoCozinha instance = new TipoCozinha();
        instance.setDayOfWeek("Tuesday");
        String resultadoEsperado = "churrasco";
        String resultado = instance.promocaoSemana();
        String resultadoObtido = (String) resultado;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void Wednesday() {
        System.out.println("Wednesday");
        TipoCozinha instance = new TipoCozinha();
        instance.setDayOfWeek("Wednesday");
        String resultadoEsperado = "bebidas";
        String resultado = instance.promocaoSemana();
        String resultadoObtido = (String) resultado;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void Thursday() {
        System.out.println("Thursday");
        TipoCozinha instance = new TipoCozinha();
        instance.setDayOfWeek("Thursday");
        String resultadoEsperado = "massa";
        String resultado = instance.promocaoSemana();
        String resultadoObtido = (String) resultado;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void Friday() {
        System.out.println("Friday");
        TipoCozinha instance = new TipoCozinha();
        instance.setDayOfWeek("Friday");
        String resultadoEsperado = "molho";
        String resultado = instance.promocaoSemana();
        String resultadoObtido = (String) resultado;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void Saturday() {
        System.out.println("Saturday");
        TipoCozinha instance = new TipoCozinha();
        instance.setDayOfWeek("Saturday");
        String resultadoEsperado = "chines";
        String resultado = instance.promocaoSemana();
        String resultadoObtido = (String) resultado;
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
   
   
}
