import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Urna eletronica");

        Candidato candidato = new Candidato();

        ArrayList<Candidato> candidatos = new ArrayList<>();
        ArrayList<Eleitor> eleitores = new ArrayList<>();

        System.out.println("Informe o numero do candidato:");
        candidato.setNumeroCandidato(scanner.nextInt());
        System.out.println("Informe o nome do candidato:");
        candidato.setNome(scanner.next());
        System.out.println("Informe o partido:");
        candidato.setPartido(scanner.next());
        System.out.println("Insira o caminho da foto:");
        candidato.setFoto(scanner.next());


        candidatos.add(candidato);
        System.out.println(candidato.toString());

        CadastraEleitor(eleitores);
        ListaEleitores(eleitores);
    }

     public static void CadastraEleitor(ArrayList<Eleitor> eleitores) {
        Eleitor eleitor = new Eleitor();

        System.out.println("Informe o código: ");
        eleitor.setCodigo(scanner.nextInt());

        System.out.println("Informe o nome: ");
        eleitor.setNome(scanner.next());

        eleitores.add(eleitor);
    }

    public static void ListaEleitores(ArrayList<Eleitor> eleitores) {
        for (Eleitor eleitor : eleitores) {
            System.out.println("Código: " + eleitor.getCodigo());
            System.out.println("Nome: " + eleitor.getNome());
        }
    }
}
