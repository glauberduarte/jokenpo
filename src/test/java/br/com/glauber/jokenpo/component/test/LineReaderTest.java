package br.com.glauber.jokenpo.component.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.glauber.jokenpo.component.LineReader;

public class LineReaderTest {
	
	private static final String PHRASE = "teste";
	private static final String VALUE_TEST = "valor1";
	

	private LineReader lineReader = spy(new LineReader());
	
	private BufferedReader bufferedReader = mock(BufferedReader.class);

	@Before
	public void setUp() {
	    doReturn(bufferedReader).when(lineReader).getReader();
	    doCallRealMethod().when(lineReader).readLineReturnWrited(PHRASE);
	}
	
	@Test
	public void souldReadLineReturnWrited() {
	    try {
			when(bufferedReader.readLine()).thenReturn(VALUE_TEST);

		    assertEquals(VALUE_TEST, lineReader.readLineReturnWrited(PHRASE));   

	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

	@Test
	public void souldReadLineReturnWritedExit() {
		try {
			when(bufferedReader.readLine()).thenReturn("exit");
			
			assertEquals("exit", lineReader.readLineReturnWrited(PHRASE));   
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
