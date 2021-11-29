import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Candidato> candidatos = new ArrayList<>();
    private static ArrayList<Eleitor> eleitores = new ArrayList<>();
    private static Map<Candidato, Integer> votacao = new HashMap<>();
    private static Set<Eleitor> eleitorSet = new HashSet<>();

    public static void main(String[] args) {
//        menu();
        System.out.println("Urna eletronica");

        Eleitor e = new Eleitor();
        e.setCodigo(1);
        e.setNome("Eduardo");
        eleitores.add(e);

        Candidato candidato = new Candidato();
        candidato.setNumeroCandidato(12);
        candidato.setNome("Candidato");
        candidato.setPartido("Partido");
        candidatos.add(candidato);

        Votacao();

        listaApuracao();


//        CadastraEleitor();
//        CadastrarCandidato();
//        ListaEleitores();
    }

    public static void menu(){
        int opcao;
        Scanner ads = new Scanner(System.in);

        do{
            try{
                System.out.println("Escolha uma das opções abaixo: ");
                System.out.println("1 - Cadastro do candidato: ");
                System.out.println("2 - Cadastro de eleitores: ");
                System.out.println("3 - Votação: ");
                System.out.println("4 - Apuração: ");
                System.out.println("5 - Exibição dos Resultados: ");
                System.out.println("6 - Sair: ");

                opcao = ads.nextInt();
            }catch (Exception e){
                System.out.println("Digite novamente");
                opcao = 0;
            }

        } while (opcao <= 6 && opcao >= 1 );

    }

    public static void CadastrarCandidato() {
        Candidato candidato = new Candidato();

        System.out.println("Informe o numero do candidato:");
        candidato.setNumeroCandidato(scanner.nextInt());
        System.out.println("Informe o nome do candidato:");
        candidato.setNome(scanner.next());
        System.out.println("Informe o partido:");
        candidato.setPartido(scanner.next());
        System.out.println("Insira o caminho da foto:");
        candidato.setFoto(scanner.next());


        candidatos.add(candidato);
        System.out.println(candidato);
    }

     public static void CadastraEleitor() {
        Eleitor eleitor = new Eleitor();

        System.out.println("Informe o código: ");
        eleitor.setCodigo(scanner.nextInt());

        System.out.println("Informe o nome: ");
        eleitor.setNome(scanner.next());

        eleitores.add(eleitor);
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

        eleitores.add(eleitor);
        votacao.put(candidato, votacao.getOrDefault(candidato, 0) + 1);
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
            System.out.println("Foto: " + apuracao.getKey().getFoto());
            System.out.println("Nome: " + apuracao.getKey().getNome());
            System.out.println("Votos: " + apuracao.getValue() + "\n");
        }
    }
}
