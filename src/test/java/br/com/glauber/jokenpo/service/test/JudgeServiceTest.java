package br.com.glauber.jokenpo.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.glauber.jokenpo.model.Gamer;
import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;
import br.com.glauber.jokenpo.service.JudgeService;

public class JudgeServiceTest {

	private static final String GAMER_1 = "Gamer 1"; 
	private static final String GAMER_2 = "Gamer 2"; 
	private Gamer gamer1 = new Gamer();
	private Gamer gamer2 = new Gamer();
	private JudgeService judge;
	
//	 Init - Pedra empata com Pedra e ganha de Tesoura
	@Test
	public void souldComparePlayedsDrawStone(){
		build();
		gamer1.setPlayed(PlayedEnum.PEDRA);
		gamer2.setPlayed(PlayedEnum.PEDRA);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(null, judge.comparePlayeds());
	}
	
	@Test
	public void souldComparePlayedsGamer1StoneWinScissors(){
		build();
		gamer1.setPlayed(PlayedEnum.PEDRA);
		gamer2.setPlayed(PlayedEnum.TESOURA);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(gamer1, judge.comparePlayeds());
	}
	
	@Test
	public void souldComparePlayedsGamer2StoneWinScissors(){
		build();
		gamer1.setPlayed(PlayedEnum.TESOURA);
		gamer2.setPlayed(PlayedEnum.PEDRA);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(gamer2, judge.comparePlayeds());
	}
//	Finish - Pedra empata com Pedra e ganha de Tesoura
	
//	Init - Tesoura empata com Tesoura e ganha de Papel
	@Test
	public void souldComparePlayedsDrawScissors(){
		build();
		gamer1.setPlayed(PlayedEnum.TESOURA);
		gamer2.setPlayed(PlayedEnum.TESOURA);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(null, judge.comparePlayeds());
	}
	
	@Test
	public void souldComparePlayedsGamer1ScissorsWinPaper(){
		build();
		gamer1.setPlayed(PlayedEnum.TESOURA);
		gamer2.setPlayed(PlayedEnum.PAPEL);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(gamer1, judge.comparePlayeds());
	}
	
	@Test
	public void souldComparePlayedsGamer2ScissorsWinPaper(){
		build();
		gamer1.setPlayed(PlayedEnum.PAPEL);
		gamer2.setPlayed(PlayedEnum.TESOURA);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(gamer2, judge.comparePlayeds());
	}
//	Finish - Tesoura empata com Tesoura e ganha de Papel
	
	
//	 Init - Papel empata com Papel e ganha de Pedra
	@Test
	public void souldComparePlayedsDrawPaper(){
		build();
		gamer1.setPlayed(PlayedEnum.PAPEL);
		gamer2.setPlayed(PlayedEnum.PAPEL);
		judge = new JudgeService(gamer1, gamer2);

		assertEquals(null, judge.comparePlayeds());
	}
	
	@Test
	public void souldComparePlayedsGamer1PaperWinStonr(){
		build();
		gamer1.setPlayed(PlayedEnum.PAPEL);
		gamer2.setPlayed(PlayedEnum.PEDRA);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(gamer1, judge.comparePlayeds());
	}
	
	@Test
	public void souldComparePlayedsGamer2PaperWinStonr(){
		build();
		gamer1.setPlayed(PlayedEnum.PEDRA);
		gamer2.setPlayed(PlayedEnum.PAPEL);
		judge = new JudgeService(gamer1, gamer2);
		
		assertEquals(gamer2, judge.comparePlayeds());
	}
//	Finish - Papel empata com Papel e ganha de Pedra

	private void build() {
		gamer1.setName(GAMER_1);
		gamer2.setName(GAMER_2);
	}
	
}