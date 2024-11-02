package br.com.fiap.fabricaVeiculos.componentes;

public class Tanque {
    private double capacidadeMaxima;
    private double qntAtual;

    public Tanque(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.qntAtual = 0;
    }

    public boolean abastecer(double litros) {
        if (litros + qntAtual > capacidadeMaxima) {
            System.out.println("Não é possível abastecer essa quantidade. O tanque suporta até " + capacidadeMaxima + " litros.");
            return false;
        } else {
            qntAtual += litros;
            System.out.println("Abastecimento realizado com sucesso: " + litros + " litros adicionados.");
            return true;
        }
    }

    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public double getQntAtual() {
        return qntAtual;
    }

    public void consumir(double litros) {
        if (litros <= qntAtual) {
            qntAtual -= litros;
            System.out.println(litros + " litros consumidos. Restante no tanque: " + qntAtual + " litros.");
        } else {
            System.out.println("Quantidade a consumir é maior que a disponível no tanque.");
        }
    }
}
