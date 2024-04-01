import java.util.Scanner;

public class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;

    public Jogador(String nome, int pontuacaoInicial, int nivelInicial) {
        this.nome = nome;
        this.pontuacao = pontuacaoInicial;
        this.nivel = nivelInicial;
    }

    public void aumentarPontuacao(int quantidade) {
        pontuacao += quantidade;
    }

    public void subirNivel() {
        nivel++;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Nível: " + nivel);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quantos players vão jogar?");
        int players = scan.nextInt();

        // Limpar o buffer do Scanner
        scan.nextLine();

        Jogador[] jogadores = new Jogador[players];

        for (int i = 0; i < players; i++) {
            System.out.println("Digite o nome do jogador: ");
            String nome = scan.nextLine();

            System.out.println("Digite a pontuação do jogador: ");
            int pontuacao = scan.nextInt();

            System.out.println("Digite o nível do jogador: ");
            int nivel = scan.nextInt();

            // Limpar o buffer do Scanner
            scan.nextLine();

            jogadores[i] = new Jogador(nome, pontuacao, nivel);
        }

        for (int i = 0; i < players; i++) {
            System.out.println("\nInformações do Jogador " + (i + 1) + ":");
            jogadores[i].exibirInformacoes();

            System.out.println("\nQuantos pontos foram adquiridos pelo Jogador " + (i + 1) + "?");
            int pontos = scan.nextInt();
            jogadores[i].aumentarPontuacao(pontos);
            jogadores[i].subirNivel();

            System.out.println("\nInformações atualizadas do Jogador " + (i + 1) + ":");
            jogadores[i].exibirInformacoes();
        }

        // Fechar o Scanner
        scan.close();
    }
}
