package br.com.glauber.jokenpo.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.glauber.jokenpo.model.dto.GamerDTO;
import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;

public class JudgeService {

	private GamerDTO gamer1;
	private GamerDTO gamer2;
	private static final List<PlayedEnum> DEFINER_ORDER = Arrays.asList(PlayedEnum.PEDRA, PlayedEnum.TESOURA, PlayedEnum.PAPEL);
	
	
	public JudgeService(GamerDTO gamer1, GamerDTO gamer2) {
		this.gamer1 = gamer1;
		this.gamer2 = gamer2;
	}
	
	public GamerDTO comparePlayeds() {
		Comparator<GamerDTO> playedCompare = Comparator.comparing(
		        c -> DEFINER_ORDER.indexOf(c.getPlayed()));
		if (playedCompare.compare(gamer1, gamer2) == 0) {
			return null;
		} else if (playedCompare.compare(gamer1, gamer2) < 0) {
			return gamer1;
		} else {
			return gamer2;
		}
	}
}
