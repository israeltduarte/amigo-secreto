public class Participante {

	private String nome;

	private String tirou;

	public Participante(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTirou() {
		return tirou;
	}

	public void setTirou(String tirou) {
		this.tirou = tirou;
	}

	@Override
	public String toString() {
		return "Participante [nome=" + nome + ", tirou=" + tirou + "]";
	}

}
