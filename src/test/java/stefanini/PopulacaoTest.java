package stefanini;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockedStatic.Verification;

public class PopulacaoTest {
	MockedStatic<Cidades>cidadesMock;
	Populacao populacaoGlobal;
	@Before
	public void setUp() throws Exception {
	populacaoGlobal = new Populacao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPopulacao() {
		
		assertTrue(populacaoGlobal!=null);
	}

	@Test
	public void testToString() {
		cidadesMock = Mockito.mockStatic(Cidades.class);
		cidadesMock.when(new Verification() {
				public void apply()  {
					Cidades.getPercursoAleatorio();
				}
			}).thenReturn("DFCEGAHB");
		Populacao populacao = new Populacao();

		assertTrue(populacao.toString().contains("DFCEGAHBD distancia: 0"));
		cidadesMock.close();
	}	

	@Test
	public void testGetMelhorCromossomo() {
		cidadesMock = Mockito.mockStatic(Cidades.class);
		cidadesMock.when(new Verification() {
				public void apply()  {
					Cidades.getPercursoAleatorio();
				}
			}).thenReturn("DFCEGAHB");
		Populacao populacao = new Populacao();		
		
		assertEquals("DFCEGAHBD distancia: 0", populacao.getMelhorCromossomo().toString());
		cidadesMock.close();
		
	}

	@Test
	public void testGeraNovaPopulacao() {
		Populacao oldPopulacao=populacaoGlobal;		
		populacaoGlobal.geraNovaPopulacao();
		
		assertTrue(oldPopulacao.toString()!=populacaoGlobal.toString());
	}

}
