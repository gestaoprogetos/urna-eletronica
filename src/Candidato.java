public class Candidato {

    private int numeroCandidato;

    private String nome;

    private String partido;

    private String foto;

    public Candidato(int numeroCandidato, String nome, String partido, String foto) {
        this.numeroCandidato = numeroCandidato;
        this.nome = nome;
        this.partido = partido;
        this.foto = foto;
    }

    public Candidato() {
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "numeroCandidato=" + numeroCandidato +
                ", nome='" + nome + '\'' +
                ", partido='" + partido + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
