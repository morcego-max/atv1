import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pizza {
    private String nome;
    private double valor;
    private String[] ingredientes;

    public Pizza(String nome, double valor, String[] ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }
}

class Pedido {
    private List<Pizza> pizzas;
    private String enderecoEntrega;
    private double valorTotal;

    public Pedido() {
        this.pizzas = new ArrayList<>();
        this.enderecoEntrega = "";
        this.valorTotal = 0.0;
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
        valorTotal += pizza.getValor();
    }

    public void removerPizza(int indice) {
        if (indice >= 0 && indice < pizzas.size()) {
            Pizza pizzaRemovida = pizzas.remove(indice);
            valorTotal -= pizzaRemovida.getValor();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void cancelarPedido() {
        pizzas.clear();
        valorTotal = 0.0;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void exibirDetalhesPedido() {
        System.out.println("Detalhes do Pedido:");
        System.out.println("Endereço de Entrega: " + enderecoEntrega);
        System.out.println("Pizzas:");

        for (int i = 0; i < pizzas.size(); i++) {
            Pizza pizza = pizzas.get(i);
            System.out.println((i + 1) + ". " + pizza.getNome() + " - R$" + pizza.getValor());
            System.out.println("   Ingredientes: ");
            for (String ingrediente : pizza.getIngredientes()) {
                System.out.println("      - " + ingrediente);
            }
        }

        System.out.println("Valor Total: R$" + valorTotal);
    }
}

public class Pizzaria {
    public static void main(String[] args) {
        List<Pizza> cardapio = new ArrayList<>();
        cardapio.add(new Pizza("Calabresa", 30.0, new String[]{"Molho de tomate", "Calabresa", "Cebola", "Queijo"}));
        cardapio.add(new Pizza("Margherita", 35.0, new String[]{"Molho de tomate", "Mussarela", "Manjericão", "Tomate"}));
        cardapio.add(new Pizza("Quatro Queijos", 40.0, new String[]{"Molho de tomate", "Mussarela", "Gorgonzola", "Parmesão", "Provolone"}));

        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar Pizza ao Pedido");
            System.out.println("2. Remover Pizza do Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Finalizar Pedido");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarPizzaAoPedido(scanner, cardapio, pedido);
                    break;
                case 2:
                    removerPizzaDoPedido(scanner, pedido);
                    break;
                case 3:
                    pedido.cancelarPedido();
                    System.out.println("Pedido cancelado com sucesso.");
                    break;
                case 4:
                    finalizarPedido(pedido);
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void adicionarPizzaAoPedido(Scanner scanner, List<Pizza> cardapio, Pedido pedido) {
        System.out.println("\n=== Cardápio ===");
        for (int i = 0; i < cardapio.size(); i++) {
            Pizza pizza = cardapio.get(i);
            System.out.println((i + 1) + ". " + pizza.getNome() + " - R$" + pizza.getValor());
        }

        System.out.print("Escolha o número da pizza desejada: ");
        int numeroPizza = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroPizza >= 1 && numeroPizza <= cardapio.size()) {
            Pizza pizzaEscolhida = cardapio.get(numeroPizza - 1);
            pedido.adicionarPizza(pizzaEscolhida);
            System.out.println("Pizza adicionada ao pedido: " + pizzaEscolhida.getNome());
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void removerPizzaDoPedido(Scanner scanner, Pedido pedido) {
        System.out.println("\n=== Pizzas no Pedido ===");
        for (int i = 0; i < pedido.getPizzas().size(); i++) {
            Pizza pizza = pedido.getPizzas().get(i);
            System.out.println((i + 1) + ". " + pizza.getNome() + " - R$" + pizza.getValor());
        }

        System.out.print("Escolha o número da pizza a ser removida: ");
        int numeroPizza = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        pedido.removerPizza(numeroPizza - 1);
        System.out.println("Pizza removida do pedido.");
    }

    private static void finalizarPedido(Pedido pedido) {
        System.out.println("\n=== Pedido Finalizado ===");
        pedido.exibirDetalhesPedido();
    }
}
