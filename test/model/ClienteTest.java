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
public class ClienteTest {
    
    public ClienteTest() {
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
    public void PromocaoHomem9() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 9);
        instance.setSexo("H");
        
        String resultadoEsperado = "0.3";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoHomem14() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 14);
        instance.setSexo("H");
        
        String resultadoEsperado = "0.2";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoHomem19() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 19);
        instance.setSexo("H");
        
        String resultadoEsperado = "0.1";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoHomem29() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 29);
        instance.setSexo("H");
        
        String resultadoEsperado = "0.05";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoHomem30() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 30);
        instance.setSexo("H");
        
        String resultadoEsperado = "0.5";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoMulher9() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 9);
        instance.setSexo("M");
        
        String resultadoEsperado = "0.4";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoMulher14() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 14);
        instance.setSexo("M");
        
        String resultadoEsperado = "0.3";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoMulher19() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 19);
        instance.setSexo("M");
        
        String resultadoEsperado = "0.2";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoMulher29() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 29);
        instance.setSexo("M");
        
        String resultadoEsperado = "0.1";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void PromocaoMulher30() {
        Cliente instance = new Cliente();
        instance.setIdade((int) 30);
        instance.setSexo("M");
        
        String resultadoEsperado = "0.6";
        float resultado = instance.promocao();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
}
