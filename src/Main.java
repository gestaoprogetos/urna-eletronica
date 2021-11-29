import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Urna eletronica");
        Scanner scanner = new Scanner(System.in);
        Candidato candidato = new Candidato();

        ArrayList<Candidato> candidatos = new ArrayList<>();

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
    }
}
