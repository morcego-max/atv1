import java.util.Scanner;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa, int velocidadeAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = velocidadeAtual;
    }
    
    public void acelerar(int incremento) {
        velocidadeAtual += incremento;
    }
    
    public void frear(int decremento) {
        velocidadeAtual -= decremento;
        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
    }
    
    public void exibirInformacoes() {
        System.out.println("\nInformações do Carro:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Velocidade Atual: " + velocidadeAtual + " km/h");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos carros serão adicionados?");
        int total = scanner.nextInt();
        
        scanner.nextLine();
        
        Carro[] carros = new Carro[total];
        
        for (int i = 0; i < total; i++) {
            System.out.println("Informe a marca do carro:");
            String marca = scanner.nextLine();

            System.out.println("Informe o modelo do carro:");
            String modelo = scanner.nextLine();

            System.out.println("Informe o ano do carro:");
            int ano = scanner.nextInt();

            scanner.nextLine(); 

            System.out.println("Informe a placa do carro:");
            String placa = scanner.nextLine();

            System.out.println("Informe a velocidade atual do carro:");
            int velocidadeAtual = scanner.nextInt();

            scanner.nextLine();

            carros[i] = new Carro(marca, modelo, ano, placa, velocidadeAtual);
            System.out.println("\nCarro criado com sucesso!");
        }
        
        for (int i = 0; i < total; i++) {
            carros[i].exibirInformacoes();
            
            System.out.println("\nSimulação de aceleração e frenagem:");
            System.out.println("Acelerando o carro em 20 km/h...");
            carros[i].acelerar(20);
            carros[i].exibirInformacoes();
            
            System.out.println("\nFreando o carro em 10 km/h...");
            carros[i].frear(10);
            carros[i].exibirInformacoes();
        }
        
        scanner.close();
    }
}
