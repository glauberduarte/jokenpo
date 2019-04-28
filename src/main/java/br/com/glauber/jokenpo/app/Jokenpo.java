package br.com.glauber.jokenpo.app;

import br.com.glauber.jokenpo.service.PlayGameService;

public class Jokenpo {

	public static void main(String[] args) {
		PlayGameService playGame = new PlayGameService();
		playGame.init();
	}
}
