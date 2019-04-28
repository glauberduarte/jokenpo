package br.com.glauber.jokenpo.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.glauber.jokenpo.model.Gamer;
import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;

public class JudgeService {

	private Gamer gamer1;
	private Gamer gamer2;
	private static final List<PlayedEnum> DEFINER_ORDER = Arrays.asList(PlayedEnum.PEDRA, PlayedEnum.TESOURA,
			PlayedEnum.PAPEL);

	public JudgeService(Gamer gamer1, Gamer gamer2) {
		this.gamer1 = gamer1;
		this.gamer2 = gamer2;
	}

	public Gamer comparePlayeds() {
		Comparator<Gamer> playedCompare = Comparator.comparing(c -> DEFINER_ORDER.indexOf(c.getPlayed()));
		if (playedCompare.compare(gamer1, gamer2) == 0) {
			return null;
		} else if(PlayedEnum.PAPEL.equals(gamer1.getPlayed())
					&& PlayedEnum.PEDRA.equals(gamer2.getPlayed())) {
			return gamer1;
		} else if(PlayedEnum.PAPEL.equals(gamer2.getPlayed())
				&& PlayedEnum.PEDRA.equals(gamer1.getPlayed())) {
			return gamer2;
		} else if (playedCompare.compare(gamer1, gamer2) < 0) {
			return gamer1;
		} else {
			return gamer2;
		}
	}
}
