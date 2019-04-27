package br.com.glauber.jokenpo.service;

import java.io.IOException;

import br.com.glauber.jokenpo.component.LineReader;
import br.com.glauber.jokenpo.model.dto.GamerDTO;
import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;

public class PlayGameService extends LineReader {

	public PlayGameService() {
		System.out.println("Iniciando o Jogo");
		game();
		System.out.println("Jogo Finalizado");

	}

	/**
	 * Jogo propriamente dito.
	 */
	private void game() {
		GamerDTO gamer1 = new GamerDTO();
		GamerDTO gamer2 = new GamerDTO();
		try {
			while (true) {
				gamer1.setName(readLineReturnWritedOrFinish("Nome do Jogador 1: "));
				gamer2.setName(readLineReturnWritedOrFinish("Nome do Jogador 2: "));
				retryReadPlayed(gamer1, gamer2);
	
				GamerDTO winner = whoIsTheWinner(gamer1, gamer2);
	
				if(winner == null) {
					System.out.println("Jogo Empatado, parabéns " + gamer1.getName() + " e " + gamer2.getName());
				}else {
					System.out.println("Ganhador é " + winner.getName() + "!!!! Com a Jogada " + winner.getPlayed().getName());
				}
	
				String exit = readLineReturnWrited("Deseja jogar novamente? ");
				if (!"sim".equalsIgnoreCase(exit)) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					break;
				}
			}
		} catch (InterruptedException | IOException e) {
			System.out.println("Não foi possível limpar a tela");
		}
	}

	/**
	 * Permite que o jogador erre a jogada, dando a possibilidade do jogador informar nova jogada;
	 * @param gamer1
	 * @param gamer2
	 */
	private void retryReadPlayed(GamerDTO gamer1, GamerDTO gamer2) {
		boolean retry = true;
		while(retry) {
			try {
				gamer1.setPlayed(PlayedEnum.valueOf(readLineReturnWritedOrFinish("Jogada de ".concat(gamer1.getName()).concat("  ")).toUpperCase()));
				gamer2.setPlayed(PlayedEnum.valueOf(readLineReturnWritedOrFinish("Jogada de ".concat(gamer2.getName()).concat("  ")).toUpperCase()));
				retry = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Jogada não reconhecida, tente usar: Pedra, Papel ou Tesoura.");
				System.out.println("Ou se desejar sair digite Exit ou Sair.");
			}
		}
	}

	/**
	 * Define jogador vencedor.
	 * @param gamer1
	 * @param gamer2
	 * @return
	 */
	private GamerDTO whoIsTheWinner(GamerDTO gamer1, GamerDTO gamer2) {
		return new JudgeService(gamer1, gamer2).comparePlayeds();
	}
}