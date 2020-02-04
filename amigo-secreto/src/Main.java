import java.util.*;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Inicio da execucao");

		String[] data = { "Israel", "Gabrielle", "Derli", "Bernardo", "Jaci", "Andrieli", "Cláudia", "Pablo", "Sandro",
				"Tânia", "Eduarda" };

		ArrayList<Participante> listaInicial = new ArrayList<>();

		for (int i = 0; i < data.length; i++) {
			listaInicial.add(new Participante(data[i]));
		}

		String[] itensMenu = { "Sair da aplicação", "Realizar sorteio", "Adicionar novo participante", "Listar participantes" };
		HashMap<Integer, String> opcoes = new HashMap<>();
		for (int i = 0; i < itensMenu.length; i++) {
			opcoes.put(i, itensMenu[i]);
		}

		do {
			imprimeMenu(opcoes);
		} while (avaliaResposta(listaInicial) != 0);

	}

	private static int avaliaResposta(ArrayList<Participante> participantes) {

		int escolha = Integer.parseInt(scanner.nextLine());

		switch (escolha) {

		case 1:
			ArrayList<Participante> listaFinal = new ArrayList<>();
			ArrayList<Participante> disponiveis = copyFrom(participantes);

			for (int i = 0; i < participantes.size(); i++) {
				Participante davez = participantes.get(i);

				int num = 0;

				while (true) {
					num = generateRandomIntIntRange(0, disponiveis.size() - 1);
					String sorteado = disponiveis.get(num).getNome();

					if (!sorteado.equals(davez.getNome())) {
						disponiveis.remove(num);
						davez.setTirou(sorteado);
						break;
					}
				}

				listaFinal.add(davez);
			}

			imprimeResultado(listaFinal);
			break;

		case 2:
			participantes.add(new Participante(novoParticipante()));
			break;
			
		case 3:
			imprimeParticipantes(participantes);

		case 0:
			System.out.println("Fim da execucao.");
			break;

		default:
			break;
		}

		return escolha;
	}

	private static void imprimeResultado(ArrayList<Participante> prontos) {
		System.out.println("Resultado do sorteio");
		imprimeParticipantes(prontos);
	}

	private static void imprimeMenu(HashMap<Integer, String> map) {
		Set<Integer> chaves = map.keySet();
		for (Integer indice : chaves) {
			if (indice != null)
				System.out.println(indice + " - " + map.get(indice));
		}
	}

	public static int generateRandomIntIntRange(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}

	static void imprimeParticipantes(List<Participante> participantes) {
		for (Participante pessoa : participantes) {
			System.out.println("Participante: " + pessoa.getNome() + " -> Sorteado: " + pessoa.getTirou());
		}
	}

	static ArrayList<Participante> copyFrom(ArrayList<Participante> lista) {
		ArrayList<Participante> novaLista = new ArrayList<>();
		for (Participante participante : lista) {
			novaLista.add(participante);
		}

		return novaLista;
	}

	static String novoParticipante() {
		System.out.println("Digite o nome do novo participante: ");
		return scanner.nextLine();
	}

}
