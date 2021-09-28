package stefanini;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.MockedStatic.Verification;
import org.mockito.Mockito;

public class CromossomoTest {
	Cromossomo cromossomoGlobal;
	MockedStatic<Cidades>cidadesMock;
	@Before
	public void setUp()  {
		cromossomoGlobal=new Cromossomo("DFCEGAHB");
	}

	@After
	public void tearDown() {
		
	}

	@Test
	public void testCromossomo() {
		cidadesMock = Mockito.mockStatic(Cidades.class);
		cidadesMock.when(new Verification() {
				public void apply()  {
					Cidades.getPercursoAleatorio();
				}
			}).thenReturn("DFCEGAHB");
		Cromossomo cromossomo= new Cromossomo();
		assertEquals("DFCEGAHB", cromossomo.getGenes());
		cidadesMock.close();
	}

	@Test
	public void testCromossomoString() {
		Cromossomo cromossomo= new Cromossomo("DFCEGAHB");
		assertEquals("DFCEGAHB", cromossomo.getGenes());
	}

	@Test
	public void testToString() {
		
		assertEquals("DFCEGAHBD distancia: 711", cromossomoGlobal.toString());
	}

	@Test
	public void testGetAptidao() {
		//System.out.print(cromossomoGlobal.getAptidao());
		assertEquals(711, cromossomoGlobal.getAptidao());
	}

	@Test
	public void testGetGenes() {
		assertEquals("DFCEGAHB", cromossomoGlobal.getGenes());
	}

	@Test
	public void testCompareTo() {
		Cromossomo cromossomoA= new Cromossomo("AB");
		Cromossomo cromossomoB= new Cromossomo("ABGAFC");
		assertEquals(0, cromossomoGlobal.compareTo(cromossomoGlobal));
		assertEquals(1, cromossomoGlobal.compareTo(cromossomoA));
		assertEquals(-1, cromossomoGlobal.compareTo(cromossomoB));
	}

}
