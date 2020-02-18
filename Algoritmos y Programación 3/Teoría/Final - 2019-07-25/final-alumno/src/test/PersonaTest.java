package test;
import org.junit.Assert;

import Comidas.Comida;
import Comidas.EmpanadaSinSal;
import Exceptions.NoPuedoComerEsoError;
import Exceptions.PersonaHipertensaNoPuedeComerConSalException;
import comensales.Persona;
import comensales.PersonaCeliaca;
import comensales.PersonaHipertensa;
import comensales.PersonaNormal;
import especialistas.Empanadero;
import especialistas.EmpanaderoCeliaco;
import especialistas.MasterChef;
import especialistas.Panadero;
import especialistas.PanaderoCeliaco;

public class PersonaTest {

	@org.junit.Test
	public void personaNoCeliacaComeCosasParaNoCeliacosEstaTodoBien() {
		
		Persona personaNoCeliaca = new PersonaNormal();
		Assert.assertEquals(personaNoCeliaca.calorias,0);
		
		Panadero panadero = new Panadero();
		Comida pan = panadero.hacerPan();
		personaNoCeliaca.comer(pan);
		Assert.assertEquals(personaNoCeliaca.calorias,10);
		
		Empanadero empandero = new Empanadero();
		Comida empanada = empandero.hacerEmpanada();
		personaNoCeliaca.comer(empanada);
		Assert.assertEquals(personaNoCeliaca.calorias,25);
	}

	@org.junit.Test
	public void personaCeliacaComeCosasParaCeliacosEstaTodoBien() {
		
		Persona celiaco = new PersonaCeliaca();
		Assert.assertEquals(celiaco.calorias,0);
		
		PanaderoCeliaco panaderoCeliaco = new PanaderoCeliaco();
		Comida pan = panaderoCeliaco.hacerPan();
		celiaco.comer(pan);
		Assert.assertEquals(celiaco.calorias,10);
		
		EmpanaderoCeliaco empanderoCeliaco = new EmpanaderoCeliaco();
		Comida empanada = empanderoCeliaco.hacerEmpanada();
		celiaco.comer(empanada);
		Assert.assertEquals(celiaco.calorias,25);
	}

	@org.junit.Test
	public void testCreoMasterChefYSeCreaBien() {
		
		MasterChef masterChef = new MasterChef();
		
		Assert.assertTrue(masterChef instanceof MasterChef);
		
	}
	
	@org.junit.Test
	public void testMasterChefHaceEmpanadaSinSal() {
		
		MasterChef masterChef = new MasterChef();
		
		Comida empanadaSinSal = masterChef.hacerEmpanadaSinSal();
		
		Assert.assertTrue(empanadaSinSal instanceof EmpanadaSinSal);
		
	}
	
	@org.junit.Test
	public void testMasterChefHaceEmpanadaSinSalYPersonaNormalLaCome() {
		
		MasterChef masterChef = new MasterChef();
		
		Comida empanadaSinSal = masterChef.hacerEmpanadaSinSal();
		
		Persona personaNormal = new PersonaNormal();
		
		personaNormal.comer(empanadaSinSal);
		
		Assert.assertEquals(personaNormal.calorias, 15%10);
	}
	
	@org.junit.Test (expected = NoPuedoComerEsoError.class)
	public void testPersonaHipertensaComeConSalLanzaError() {
		
		MasterChef masterChef = new MasterChef();
		
		Comida empanadaSinGluten = masterChef.hacerEmpanadaSinGluten();
		
		Persona personaHipertensa = new PersonaHipertensa();
		
		personaHipertensa.comer(empanadaSinGluten);
	}
}
