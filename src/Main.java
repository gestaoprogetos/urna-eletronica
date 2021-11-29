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
    
     public static void CadastraEleitor(Object eleitor) {
        System.out.println("Informe o código: ");
        String codigo = scanner.nextLine();

        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
    }

    public static void ListaEleitores(ArrayList<Object> eleitores) {
        for (Object eleitor : eleitores) {
            System.out.println("Código: " + eleitor.GetCodigo());
            System.out.println("Nome: " + eleitor.GetNome());git
        }
    }
}
