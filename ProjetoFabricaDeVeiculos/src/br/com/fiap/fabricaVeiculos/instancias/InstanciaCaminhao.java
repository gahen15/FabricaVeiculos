package br.com.fiap.fabricaVeiculos.instancias;

import br.com.fiap.fabricaVeiculos.Caminhao;
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;

import java.util.Scanner;

public class InstanciaCaminhao {

    public static void main(String[] args) {
        Motor motor = new Motor("Diesel", 300, 800, 6, 5.5, "2020");
        Rodas rodas = new Rodas(22, "Liga Leve", "Off-road", 295);
        Multimidia multimidia = new Multimidia("Pioneer", true, true, true);
        Freios freios = new Freios("Disco", "Cerâmico", true);

        Caminhao caminhao = new Caminhao(
            "Volvo",
            "FH16",
            "Branco",
            "1234567890",
            motor,
            "Automático",
            "João da Silva",
            "2018",
            "2019",
            22,
            3,
            15.0,
            120.0,
            rodas,
            multimidia,
            freios
        );

        Scanner scanner = new Scanner(System.in);
        boolean caminhaoRunning = true;

        while (caminhaoRunning) {
            System.out.println("\n=== Painel de Opções do Caminhão ===");
            System.out.println("1 - Ligar");
            System.out.println("2 - Acelerar");
            System.out.println("3 - Frear");
            System.out.println("4 - Desligar");
            System.out.println("5 - Exibir Dados");
            System.out.println("6 - Carregar");
            System.out.println("7 - Descarregar");
            System.out.println("0 - Voltar");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    caminhao.ligar();
                    break;
                case 2:
                    System.out.print("Informe a velocidade para acelerar: ");
                    double incremento = scanner.nextDouble();
                    caminhao.acelerar(incremento);
                    break;
                case 3:
                    caminhao.frear();
                    break;
                case 4:
                    caminhao.desligar();
                    break;
                case 5:
                    caminhao.exibirDados();
                    break;
                case 6:
                    System.out.print("Informe a quantidade de carga para carregar (toneladas): ");
                    double cargaCarregar = scanner.nextDouble();
                    caminhao.carregar(cargaCarregar);
                    break;
                case 7:
                    System.out.print("Informe a quantidade de carga para descarregar (toneladas): ");
                    double cargaDescarregar = scanner.nextDouble();
                    caminhao.descarregar(cargaDescarregar);
                    break;
                case 0:
                    caminhaoRunning = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
