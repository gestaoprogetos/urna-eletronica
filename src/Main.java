import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Candidato> candidatos = new ArrayList<>();
    private static ArrayList<Eleitor> eleitores = new ArrayList<>();
    private static Map<Candidato, Integer> votacao = new HashMap<>();

    public static void main(String[] args) {
        menu();
        System.out.println("Urna eletronica");



        CadastraEleitor();
        CadastrarCandidato();
        ListaEleitores();
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

    public static void votacao()  {

    }

    public static void listaApuracao() {
        for (var apuracao : votacao.entrySet()) {
            System.out.println("Número: " + apuracao.getKey().getNumeroCandidato());
            System.out.println("Partido: " + apuracao.getKey().getPartido());
            System.out.println("Partido: " + apuracao.getKey().getFoto());
            System.out.println("Nome: " + apuracao.getKey().getNome());
            System.out.println("Votos: " + apuracao.getValue() + "\n");
        }
    }
}
