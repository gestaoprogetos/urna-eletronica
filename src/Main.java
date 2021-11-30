import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Candidato> candidatos = new ArrayList<>();
    private static ArrayList<Eleitor> eleitores = new ArrayList<>();
    private static Map<Candidato, Integer> votacao = new HashMap<>();
    private static Set<Eleitor> eleitorSet = new HashSet<>();
    private static Set<Integer> eleitoresCadastrados = new HashSet<>();
    private static Set<Integer> candidatosCadastrados = new HashSet<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao;
            do {
                try {
                    System.out.println("Escolha uma das opções abaixo: ");
                    System.out.println("1 - Cadastro do candidato: ");
                    System.out.println("2 - Cadastro de eleitores: ");
                    System.out.println("3 - Votação: ");
                    System.out.println("4 - Apuração e exibição dos resultados: ");
                    System.out.println("5 - Sair: ");

                    opcao = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Opção não valida. Digite novamente: ");
                    opcao = 0;
                }

                switch (opcao) {
                    case 1:
                        CadastrarCandidato();
                        break;
                    case 2:
                        CadastraEleitor();
                        break;
                    case 3:
                        Votacao();
                        break;
                    case 4:
                        listaApuracao();
                        System.exit(0);
                        break;
                    default:
                        break;
                }

            } while (opcao < 1 || opcao > 5);
    }

    public static void CadastrarCandidato() {
        Candidato candidato = new Candidato();

        while (true) {
            System.out.println("Informe o numero do candidato:");
            candidato.setNumeroCandidato(scanner.nextInt());

            if (!candidatosCadastrados.add(candidato.getNumeroCandidato())) {
                System.out.println("Candidato já cadastrado");
                continue;
            }

            System.out.println("Informe o nome do candidato:");
            candidato.setNome(scanner.next());
            System.out.println("Informe o partido:");
            candidato.setPartido(scanner.next());
            System.out.println("Insira o caminho da foto:");
            candidato.setFoto(scanner.next());

            break;
        }

        candidatos.add(candidato);
        System.out.println(candidato);
        menu();
    }

    public static void CadastraEleitor() {
        Eleitor eleitor = new Eleitor();

        while (true) {
            System.out.println("Informe o número do eleitor: ");
            eleitor.setCodigo(scanner.nextInt());

            if (!eleitoresCadastrados.add(eleitor.getCodigo())) {
                System.out.println("Eleitor já cadastrado");
                continue;
            }

            System.out.println("Informe o nome: ");
            eleitor.setNome(scanner.next());

            break;
        }

        eleitores.add(eleitor);
        menu();
    }

    public static void ListaEleitores() {
        for (Eleitor eleitor : eleitores) {
            System.out.println("Código: " + eleitor.getCodigo());
            System.out.println("Nome: " + eleitor.getNome());
        }
    }

    public static void ListaCandidatos() {
        for (Candidato candidato : candidatos) {
            System.out.println("Número: " + candidato.getNumeroCandidato());
            System.out.println("Nome: " + candidato.getNome());
        }
    }

    public static void Votacao()  {
        if (eleitores.isEmpty() || eleitorSet.containsAll(eleitores)) {
            System.out.println("Nao existem eleitores disponiveis para votar");
            menu();
        }

        System.out.println("Escolha o eleitor:");
        Eleitor eleitor = null;
        while (eleitor == null) {
            eleitor = solicitaEleitor();
        }

        System.out.println("Escolha o candidato pelo código:");
        Candidato candidato = null;
        while (candidato == null) {
            candidato = escolheCandidato();
        }

        eleitorSet.add(eleitor);
        votacao.put(candidato, votacao.getOrDefault(candidato, 0) + 1);
        menu();
    }

    public static Candidato escolheCandidato() {
        ListaCandidatos();
        int codigoCandidato = scanner.nextInt();
        Optional<Candidato> optionalCandidato = candidatos.stream().filter(c -> c.getNumeroCandidato() == codigoCandidato).findFirst();
        if (optionalCandidato.isPresent()) {
            return optionalCandidato.get();
        } else {
            System.out.println("Candidato inválido, escolha outro:");
            return null;
        }
    }

    public static Eleitor solicitaEleitor() {
        ListaEleitores();
        int codigoEleitor = scanner.nextInt();
        Optional<Eleitor> optionalEleitor = eleitores.stream().filter(eleitor -> eleitor.getCodigo() == codigoEleitor).findFirst();
        if (optionalEleitor.isPresent()) {
            if (eleitorSet.contains(optionalEleitor.get())) {
                System.out.println("Eleitor inválido, escolha outro eleitor:");
                return null;
            } else {
                return optionalEleitor.get();
            }
        } else {
            System.out.println("Eleitor inválido, escolha outro eleitor:");
            return null;
        }
    }


    public static void listaApuracao() {
        for (var apuracao : votacao.entrySet()) {
            System.out.println("Número: " + apuracao.getKey().getNumeroCandidato());
            System.out.println("Partido: " + apuracao.getKey().getPartido());
            System.out.println("Nome: " + apuracao.getKey().getNome());
            System.out.println("Votos: " + apuracao.getValue() + "\n");
        }
    }
}
