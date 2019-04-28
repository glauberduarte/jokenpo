package br.com.glauber.jokenpo.service;

import java.io.IOException;

import br.com.glauber.jokenpo.component.LineReader;
import br.com.glauber.jokenpo.model.Gamer;
import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;

public class PlayGameService extends LineReader {

	private Gamer gamer1 = new Gamer();
	private Gamer gamer2 = new Gamer();

	/**
	 * Inicializador do Jogo;
	 */
	public void init() {
		System.out.println("Iniciando o Jogo");
		recursiveGame();
		System.out.println("Jogo Finalizado");
	}

	/**
	 * Recursividade para iniciar e finalizar o jogo
	 */
	private void recursiveGame() {
		while (true) {
			populateGamer();
			System.out.println(game());
			String exit = readLineReturnWrited("Deseja jogar novamente? ");
			if (!"sim".equalsIgnoreCase(exit)) {
				try {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} catch (InterruptedException | IOException e) {
					System.out.println("Não foi possível limpar a tela");
				}
				break;
			}
		}
	}

	/**
	 * Popular gamer1 e gamer2, apartir da leitura do teclado
	 */
	private void populateGamer() {
		gamer1.setName(readLineReturnWritedOrFinish("Nome do Jogador 1: "));
		gamer2.setName(readLineReturnWritedOrFinish("Nome do Jogador 2: "));
		retryReadPlayed(gamer1, gamer2);
	}

	/**
	 * Jogo propriamente dito.
	 */
	public String game() {
		Gamer winner = whoIsTheWinner(gamer1, gamer2);

		if (winner == null) {
			return "Jogo Empatado, parabéns " + gamer1.getName() + " e " + gamer2.getName();
		} else {
			return "Ganhador é " + winner.getName() + "!!!! Com a Jogada " + winner.getPlayed().getName();
		}
	}

	/**
	 * Permite que o jogador erre a jogada, dando a possibilidade do jogador
	 * informar nova jogada;
	 * 
	 * @param gamer1
	 * @param gamer2
	 */
	private void retryReadPlayed(Gamer gamer1, Gamer gamer2) {
		boolean retry = true;
		while (retry) {
			try {
				String readGamer1 = readLineReturnWritedOrFinish("Jogada de ".concat(gamer1.getName()).concat("  "))
						.toUpperCase();
				gamer1.setPlayed(PlayedEnum.valueOf(readGamer1));
				String readGamer2 = readLineReturnWritedOrFinish("Jogada de ".concat(gamer2.getName()).concat("  "))
						.toUpperCase();
				gamer2.setPlayed(PlayedEnum.valueOf(readGamer2));
				retry = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Jogada não reconhecida, tente usar: Pedra, Papel ou Tesoura.");
				System.out.println("Ou se desejar sair digite Exit ou Sair.");
			}
		}
	}

	/**
	 * Define jogador vencedor.
	 * 
	 * @param gamer1
	 * @param gamer2
	 * @return
	 */
	public Gamer whoIsTheWinner(Gamer gamer1, Gamer gamer2) {
		return new JudgeService(gamer1, gamer2).comparePlayeds();
	}

	public void setGamer1(Gamer gamer1) {
		this.gamer1 = gamer1;
	}

	public void setGamer2(Gamer gamer2) {
		this.gamer2 = gamer2;
	}

}