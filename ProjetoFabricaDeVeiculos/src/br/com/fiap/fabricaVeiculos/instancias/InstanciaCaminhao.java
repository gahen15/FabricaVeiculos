package br.com.fiap.fabricaVeiculos.instancias;

import br.com.fiap.fabricaVeiculos.Caminhao;
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;
import br.com.fiap.fabricaVeiculos.componentes.Tanque;
import br.com.fiap.fabricaVeiculos.interfaces.Alcool;
import br.com.fiap.fabricaVeiculos.interfaces.Combustivel;
import br.com.fiap.fabricaVeiculos.interfaces.Gasolina;

import java.util.Scanner;

public class InstanciaCaminhao {

    public static void main(String[] args) {
        Motor motor = new Motor("Gasolina", 300, 800, 6, 5.5, "2020");
        Rodas rodas = new Rodas(22, "Liga Leve", "Off-road", 295);
        Multimidia multimidia = new Multimidia("Pioneer", true, true, true);
        Freios freios = new Freios("Disco", "Cerâmico", true);
        Tanque tanque = new Tanque(200);

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
            5000,
            120,
            rodas,
            multimidia,
            freios,
            tanque
        );

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n=== Painel de Opções do Caminhão ===");
            System.out.println("1 - Ligar");
            System.out.println("2 - Acelerar");
            System.out.println("3 - Frear");
            System.out.println("4 - Desligar");
            System.out.println("5 - Exibir Dados");
            System.out.println("6 - Carregar");
            System.out.println("7 - Descarregar");
            System.out.println("8 - Abastecer");
            System.out.println("9 - Esvaziar Tanque");
            System.out.println("10 - Calcular Capacidade de Rodagem");
            System.out.println("0 - Voltar");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    caminhao.ligar();
                    break;
                case 2:
                    System.out.print("Informe a velocidade para acelerar: ");
                    double incremento = sc.nextDouble();
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
                    double cargaCarregar = sc.nextDouble();
                    caminhao.carregar(cargaCarregar);
                    break;
                case 7:
                    System.out.print("Informe a quantidade de carga para descarregar (toneladas): ");
                    double cargaDescarregar = sc.nextDouble();
                    caminhao.descarregar(cargaDescarregar);
                    break;
                case 8:
                    System.out.print("Informe a quantidade de combustível para abastecer (litros): ");
                    double qntCombustivel = sc.nextDouble();
                    System.out.println("Informe qual o tipo de combustivel que deseja abastecer:\n|1|Gasolina\n|2|Alcool\n|3|Gasolina e Alcool");

                    int tipoCombustivel = sc.nextInt();
                    Combustivel combustivel;

                    switch (tipoCombustivel) {
                        case 1:
                            combustivel = new Gasolina();
                            break;
                        case 2:
                            combustivel = new Alcool();
                            break;
                        default:
                            System.out.println("Tipo de combustível inválido.");
                            return;
                    }
                    caminhao.abastecer(combustivel, qntCombustivel);
                    break;
                case 9:
                    caminhao.esvaziarTanque();
                    break;
                case 10:
                    double capacidadeRodagem = caminhao.getCapacidadeRodagem();
                    System.out.println("Capacidade de Rodagem: " + capacidadeRodagem + " km");
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
