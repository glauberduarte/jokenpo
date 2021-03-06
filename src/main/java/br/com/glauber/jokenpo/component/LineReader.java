package br.com.glauber.jokenpo.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineReader {

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Imprimi uma frase e aguarda um retorno
	 * @param printThis
	 * @return
	 */
	public String readLineReturnWrited(String printThis) {
		String readKey = null;
		try {
			System.out.print(printThis);
			readKey = getReader().readLine();
			System.out.println("");
			System.out.print("\033[H\033[2J");
			System.out.flush(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readKey;
	}
	
	/**
	 * Imprimi uma frase e aguarda um retorno, com a possibilidade de encerrar a jogo com exit ou sair
	 * @param printThis
	 * @return
	 */
	public String readLineReturnWritedOrFinish(String printThis) {
		String readKey = readLineReturnWrited(printThis);
		if (readKey == null || readKey.equalsIgnoreCase("exit") || readKey.equalsIgnoreCase("sair")) {
			System.exit(0);
		}
		return readKey;
	}

	public BufferedReader getReader() {
		return reader;
	}
}
