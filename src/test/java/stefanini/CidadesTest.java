package stefanini;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CidadesTest {
	
Random randomMock;
	@Before
	public void setUp() throws Exception {
		randomMock = Mockito.mock(Random.class);
		
	
		

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIndexByChar() {
		assertEquals(2, Cidades.indexByChar('C'));
	}

	@Test
	public void testCharByIndex() {
		assertEquals('C', Cidades.charByIndex(2));
	}

	@Test
	public void testGetDistancia() {
		assertEquals(10, Cidades.getDistancia('A', 'B'));
		
	}

	@Test
	public void testGetDistanciaTotal() {
		assertEquals(20, Cidades.getDistanciaTotal("AB"));
		
	}

	@Test
	public void testGetPercursoAleatorio() {
	//	Mockito.when(new Random()).thenReturn( randomMock);
		Mockito.when(randomMock.nextInt(Mockito.anyInt())).thenReturn( 2);
		System.out.println(Cidades.getPercursoAleatorio());
		
		
		
	}

}
