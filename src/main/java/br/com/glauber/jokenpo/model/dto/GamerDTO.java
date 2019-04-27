package br.com.glauber.jokenpo.model.dto;

import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;

public class GamerDTO {

	private String name;
	private PlayedEnum played;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayedEnum getPlayed() {
		return played;
	}

	public void setPlayed(PlayedEnum played) {
		this.played = played;
	}
}
