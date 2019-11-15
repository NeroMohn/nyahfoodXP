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
public class PedidoTest {
    
    public PedidoTest() {
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
    public void Frete500() {
        Cliente instance = new Cliente();
        instance.setDistancia((float) 499);
        Pedido instance2 = new Pedido();
        instance2.setCliente(instance);
        
        String resultadoEsperado = "0.0";
        float resultado =instance2.frete();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void Frete1000() {
        Cliente instance = new Cliente();
        instance.setDistancia((float) 999);
        Pedido instance2 = new Pedido();
        instance2.setCliente(instance);
        
        String resultadoEsperado = "10.0";
        float resultado =instance2.frete();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void FreteAcima1000() {
        Cliente instance = new Cliente();
        instance.setDistancia((float) 1000);
        Pedido instance2 = new Pedido();
        instance2.setCliente(instance);
        
        String resultadoEsperado = "20.0";
        float resultado =instance2.frete();
        String resultadoObtido = Float.toString(resultado);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    
}
