package test;
import org.junit.Assert;

import Superficies.Agua;
import modelo.Pingüino;



public class PingüinoTest {
	
	@org.junit.Test
	public void pingüinoNadaEnElAguaTest() {
		
		Pingüino ping = new Pingüino();
		
		Agua agua = new Agua();
		
		Assert.assertEquals(ping.nadar(agua),5);
		
	}
	
	
}
