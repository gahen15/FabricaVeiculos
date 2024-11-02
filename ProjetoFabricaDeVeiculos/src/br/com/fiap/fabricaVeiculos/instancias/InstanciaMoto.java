package br.com.fiap.fabricaVeiculos.instancias;

import br.com.fiap.fabricaVeiculos.Moto;
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;

import java.util.Scanner;

public class InstanciaMoto {

    public static void main(String[] args) {
        // Instanciando os componentes da Moto
        Motor motor = new Motor("Gasolina", 120, 150, 4, 10.5, "2020");
        Rodas rodas = new Rodas(18, "Alumínio", "Esportiva", 8.5);
        Multimidia multimidia = new Multimidia("Modelo X", true, true, true);
        Freios freios = new Freios("Disco", "Cerâmico", true);

        // Criando a instância de Moto com as mesmas especificações
        Moto moto = new Moto(
            "Honda",
            "CG 125",
            "Preta",
            "987654321",
            motor,
            "Manual",
            "Carlos Souza",
            "2022",
            "2023",
            120,
            rodas,
            multimidia,
            freios
        );

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n=== Painel de Opções da Moto ===");
            System.out.println("1 - Ligar");
            System.out.println("2 - Acelerar");
            System.out.println("3 - Frear");
            System.out.println("4 - Desligar");
            System.out.println("5 - Exibir Dados");
            System.out.println("0 - Voltar");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    moto.ligar();
                    break;
                case 2:
                    System.out.print("Informe a velocidade para acelerar: ");
                    double incremento = sc.nextDouble();
                    moto.acelerar(incremento);
                    break;
                case 3:
                    moto.frear();
                    break;
                case 4:
                    moto.desligar();
                    break;
                case 5:
                    moto.exibirDados();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
