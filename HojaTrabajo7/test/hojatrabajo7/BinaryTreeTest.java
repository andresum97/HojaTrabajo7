/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
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

    /**
     * Test of insertar method, of class BinaryTree.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Object id = null;
        BinaryTree instance = new BinaryTree();
        instance.insertar(new Asociacion("Woman", "Mujer"));
        Asociacion<String,String> result = (Asociacion<String,String>) instance.buscar(new Asociacion("Woman", ""));
        // TODO review the generated test code and remove the default call to fail.
        if (!"Mujer".equals(result.value)){
            fail("The test case is a prototype.");
        }
    }

  

    /**
     * Test of buscar method, of class BinaryTree.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object id = null;
        BinaryTree instance = new BinaryTree();
        instance.insertar(new Asociacion("Woman", "Mujer"));
        Asociacion<String,String> result = (Asociacion<String,String>) instance.buscar(new Asociacion("Mujer", ""));
//        Object result = instance.buscar(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=null){
            fail("The test case is a prototype.");
        }
    }

    
}
