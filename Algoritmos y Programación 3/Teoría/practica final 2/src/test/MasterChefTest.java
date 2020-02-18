package test;

import comensales.PersonaNormal;
import especialistas.*;
import org.junit.Assert;

import comensales.Persona;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class MasterChefTest {

    @Test
    public void testCreoMasterChef(){

        MasterChef masterChef = new MasterChef();
        assertNotNull(masterChef);

    }

    @Test
    public void testCreoMasterChefYHacePan(){

        MasterChef masterChef = new MasterChef();
        assertEquals(masterChef.hacerPan(),"Hice pan.");
    }

    @Test
    public void testCreoMasterChefYHacePanParaCeliacos(){

        MasterChef masterChef = new MasterChef();
        assertEquals(masterChef.hacerPanParaCeliacos(),"Hice pan para celiacos.");
    }

    @Test
    public void testCreoMasterChefYHacePanParaHipertensos(){

        MasterChef masterChef = new MasterChef();
        assertEquals(masterChef.hacerPanParaHipertensos(),"Hice pan para hipertensos.");
    }

    /*@Test
    public void testCreoMasterChefYHaceEmpanada(){

        MasterChef masterChef = new MasterChef();
        assertEquals(masterChef.hacerEmpanada(),"Hice empanada.");
    }*/

    @Test
    public void testCreoMasterChefYHaceEmpanadaParaCeliacos(){

        MasterChef masterChef = new MasterChef();
        assertEquals(masterChef.hacerEmpanadaParaCeliacos(),"Hice empanada para celiacos.");
    }

    @Test
    public void testCreoMasterChefYHaceEmpanadaParaHipertensos(){

        MasterChef masterChef = new MasterChef();
        assertEquals(masterChef.hacerEmpanadaParaHipertensos(),"Hice empanada para hipertensos.");
    }

    @Test
    public void testMasterChefHaceEmpanadaSinSalYUnaPersonaNormalLaCome(){

        MasterChef masterChef = new MasterChef();
        PersonaNormal persona = new PersonaNormal();
        assertTrue(persona.comer(masterChef.hacerEmpanada()));


    }

}
