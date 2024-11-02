package br.com.fiap.fabricaVeiculos.instancias;

import br.com.fiap.fabricaVeiculos.Carro;
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;
import br.com.fiap.fabricaVeiculos.componentes.Tanque;
import br.com.fiap.fabricaVeiculos.interfaces.Alcool;
import br.com.fiap.fabricaVeiculos.interfaces.Combustivel;
import br.com.fiap.fabricaVeiculos.interfaces.Gasolina;

import java.util.Scanner;

public class InstanciaCarro {

    public static void main(String[] args) {
        Motor motor = new Motor("Gasolina", 120, 150, 4, 10.5, "2020");
        Rodas rodas = new Rodas(18, "Alumínio", "Esportiva", 8.5);
        Multimidia multimidia = new Multimidia("Modelo X", true, true, true);
        Freios freios = new Freios("Disco", "Cerâmico", true);
        Tanque tanque = new Tanque(50);

        Carro carro = new Carro("Fiat", "Uno", "Vermelho", "123456789", motor, "Manual", "João da Silva", "2020",
                "2021", 180, rodas, multimidia, freios, tanque);

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n=== Painel de Opções do Carro ===");
            System.out.println("1 - Ligar");
            System.out.println("2 - Acelerar");
            System.out.println("3 - Frear");
            System.out.println("4 - Desligar");
            System.out.println("5 - Exibir Dados");
            System.out.println("6 - Abastecer");
            System.out.println("7 - Esvaziar Tanque");
            System.out.println("8 - Capacidade de Rodagem");
            System.out.println("0 - Voltar");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    System.out.print("Informe a velocidade para acelerar: ");
                    double incremento = sc.nextDouble();
                    carro.acelerar(incremento);
                    break;
                case 3:
                    carro.frear();
                    break;
                case 4:
                    carro.desligar();
                    break;
                case 5:
                    carro.exibirDados();
                    break;
                case 6:
                    System.out.print("Informe a quantidade de combustível para abastecer (litros): ");
                    double qntCombustivel = sc.nextDouble();
                    System.out.println("Informe qual o tipo de combustivel que deseja abastecer:\n|1|Gasolina\n|2|Alcool\n");

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
                    carro.abastecer(combustivel, qntCombustivel);
                    break;
                case 7:
                    carro.esvaziarTanque();
                    break;
                case 8:
                    double capacidadeRodagem = carro.getCapacidadeRodagem();
                    System.out.println("Capacidade de Rodagem: " + capacidadeRodagem + " km");
                    break;
                case 0:
                	System.out.println("\n".repeat(45));
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

  
    }
}
