package br.com.fiap.fabricaVeiculos;

import java.util.Scanner;

import br.com.fiap.fabricaVeiculos.instancias.InstanciaCarro;
import br.com.fiap.fabricaVeiculos.instancias.InstanciaCaminhao;
import br.com.fiap.fabricaVeiculos.instancias.InstanciaMoto;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("Selecione o tipo de veículo:");
            System.out.println("1 - Carro");
            System.out.println("2 - Caminhão");
            System.out.println("3 - Moto");
            System.out.println("0 - Sair");
            int escolha = sc.nextInt();

            switch (escolha) {
            case 1:
                InstanciaCarro.main(null); // Passa o sc como argumento
                break;
            case 2:
                InstanciaCaminhao.main(null); // Certifique-se de que InstanciaCaminhao suporta sc
                break;
            case 3:
                InstanciaMoto.main(null); // Certifique-se de que InstanciaMoto suporta sc
                break;
            case 0:
                loop = false;
                break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}
