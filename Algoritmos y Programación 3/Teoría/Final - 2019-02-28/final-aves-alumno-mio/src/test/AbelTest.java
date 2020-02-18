package test;
import org.junit.Assert;

import Superficies.PistaDeAtletismo;
import modelo.AbelPintos;

public class AbelTest {
	
	@org.junit.Test
	public void abelPintosCorreSobrePistaDeAtletismoTest() {
		
		AbelPintos abel = new AbelPintos();
		
		PistaDeAtletismo pistaDeAtletismo = new PistaDeAtletismo();
		
		Assert.assertEquals(abel.correr(pistaDeAtletismo),15);
		
	}
	
	
}
