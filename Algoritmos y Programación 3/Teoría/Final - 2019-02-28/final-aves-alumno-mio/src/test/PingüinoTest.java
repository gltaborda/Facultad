package test;
import org.junit.Assert;

import Superficies.Agua;
import modelo.Ping�ino;



public class Ping�inoTest {
	
	@org.junit.Test
	public void ping�inoNadaEnElAguaTest() {
		
		Ping�ino ping = new Ping�ino();
		
		Agua agua = new Agua();
		
		Assert.assertEquals(ping.nadar(agua),5);
		
	}
	
	
}
