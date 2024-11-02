package br.com.fiap.fabricaVeiculos;

import java.util.Scanner;

import br.com.fiap.fabricaVeiculos.instancias.InstanciaCarro;
import br.com.fiap.fabricaVeiculos.instancias.InstanciaCaminhao;
import br.com.fiap.fabricaVeiculos.instancias.InstanciaMoto;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Selecione o tipo de veículo:");
            System.out.println("1 - Carro");
            System.out.println("2 - Caminhão");
            System.out.println("3 - Moto");
            System.out.println("0 - Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    InstanciaCarro.main(null);
                    break;
                case 2:
                    InstanciaCaminhao.main(null);
                    break;
                case 3:
                    InstanciaMoto.main(null);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
