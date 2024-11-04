package br.com.fiap.fabricaVeiculos.componentes;

// A classe Tanque representa o tanque de combustível de um veículo.
public class Tanque {
    // Capacidade máxima do tanque em litros.
    private double capacidadeMaxima;
    // Quantidade atual de combustível no tanque em litros.
    private double qntAtual;

    // Construtor que inicializa o tanque com uma capacidade máxima.
    public Tanque(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.qntAtual = 0; // Inicializa a quantidade atual como zero.
    }

    // Método que tenta abastecer o tanque com uma quantidade de litros.
    public boolean abastecer(double litros) {
        // Verifica se a quantidade a ser adicionada excede a capacidade máxima do tanque.
        if (litros + qntAtual > capacidadeMaxima) {
            System.out.println("Não é possível abastecer essa quantidade. O tanque suporta até " + capacidadeMaxima + " litros.");
            return false; // Retorna falso se o abastecimento não for possível.
        } else {
            // Adiciona a quantidade de litros ao tanque.
            qntAtual += litros;
            System.out.println("Abastecimento realizado com sucesso: " + litros + " litros adicionados.");
            return true; // Retorna verdadeiro se o abastecimento for bem-sucedido.
        }
    }

    // Método que retorna a capacidade máxima do tanque.
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    // Método que retorna a quantidade atual de combustível no tanque.
    public double getQntAtual() {
        return qntAtual;
    }

    // Método que consome uma quantidade de combustível do tanque.
    public void consumir(double litros) {
        // Verifica se a quantidade a ser consumida é menor ou igual à quantidade atual.
        if (litros <= qntAtual) {
            // Se sim, subtrai a quantidade consumida do total atual.
            qntAtual -= litros;
            System.out.println(litros + " litros consumidos. Restante no tanque: " + qntAtual + " litros.");
        } else {
            // Caso contrário, informa que não há combustível suficiente.
            System.out.println("Quantidade a consumir é maior que a disponível no tanque.");
        }
    }
}
