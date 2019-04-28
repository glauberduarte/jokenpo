package br.com.glauber.jokenpo.model;

import br.com.glauber.jokenpo.model.enumeration.PlayedEnum;

public class Gamer {

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

	@Override
	public String toString() {
		return "GamerDTO [name=" + name + ", played=" + played + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((played == null) ? 0 : played.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gamer other = (Gamer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (played != other.played)
			return false;
		return true;
	}
}
