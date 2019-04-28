package br.com.glauber.jokenpo.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import br.com.glauber.jokenpo.model.Gamer;
import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;
import br.com.glauber.jokenpo.service.JudgeService;
import br.com.glauber.jokenpo.service.PlayGameService;

public class PlayGameServiceTest {
	
	private static final String GAMER_1 = "Gamer 1"; 
	private static final String GAMER_2 = "Gamer 2"; 
	
	private Gamer gamer1 = new Gamer();
	private Gamer gamer2 = new Gamer();
	
	private PlayGameService playGame = new PlayGameService();

	private JudgeService judge = mock(JudgeService.class);
	

	@Test
	public void souldGamePlayedsDraw(){
		//Build
		gamer1.setName(GAMER_1);
		gamer1.setPlayed(PlayedEnum.PAPEL);
		gamer2.setName(GAMER_2);
		gamer2.setPlayed(PlayedEnum.PAPEL);
		playGame.setGamer1(gamer1);
		playGame.setGamer2(gamer2);
		
		when(judge.comparePlayeds()).thenReturn(null);
		
		assertEquals("Jogo Empatado, parabéns " + gamer1.getName() + " e " + gamer2.getName(), playGame.game());
	}

	@Test
	public void souldGamePlayedsGamer1Win(){
		//Build
		gamer1.setName(GAMER_1);
		gamer1.setPlayed(PlayedEnum.TESOURA);
		gamer2.setName(GAMER_2);
		gamer2.setPlayed(PlayedEnum.PAPEL);
		playGame.setGamer1(gamer1);
		playGame.setGamer2(gamer2);
		
		when(judge.comparePlayeds()).thenReturn(null);
		
		assertEquals("Ganhador é " + gamer1.getName() + "!!!! Com a Jogada " + gamer1.getPlayed().getName(), playGame.game());
	}
	
	@Test
	public void souldGamePlayedsGamer2Win(){
		//Build
		gamer1.setName(GAMER_1);
		gamer1.setPlayed(PlayedEnum.TESOURA);
		gamer2.setName(GAMER_2);
		gamer2.setPlayed(PlayedEnum.PEDRA);
		playGame.setGamer1(gamer1);
		playGame.setGamer2(gamer2);
		
		when(judge.comparePlayeds()).thenReturn(null);
		
		assertEquals("Ganhador é " + gamer2.getName() + "!!!! Com a Jogada " + gamer2.getPlayed().getName(), playGame.game());
	}
	

}
