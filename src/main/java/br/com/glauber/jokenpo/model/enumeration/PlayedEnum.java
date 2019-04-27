package br.com.glauber.jokenpo.model.enumeration;

public enum PlayedEnum {

	PEDRA("Pedra"),
	PAPEL("Papel"),
	TESOURA("Tesoura");
	
	private final String name;
	
	private PlayedEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
    @Override
    public String toString() {
        return name;
    }
}
