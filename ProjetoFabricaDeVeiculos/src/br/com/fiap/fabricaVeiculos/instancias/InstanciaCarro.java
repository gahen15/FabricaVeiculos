package br.com.fiap.fabricaVeiculos.instancias;

// Importa as classes de componentes e interfaces necessárias
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
        // Cria os componentes necessários para o carro
        Motor motor = new Motor("Gasolina", 120, 150, 4, 10.5, "2020");
        Rodas rodas = new Rodas(18, "Alumínio", "Esportiva", 8.5);
        Multimidia multimidia = new Multimidia("Modelo X", true, true, true);
        Freios freios = new Freios("Disco", "Cerâmico", true);
        Tanque tanque = new Tanque(50);

        // Inicializa o carro com todos os componentes e informações especificadas
        Carro carro = new Carro("Fiat", "Uno", "Vermelho", "123456789", motor, "Manual", "João da Silva", "2020",
                "2021", 180, rodas, multimidia, freios, tanque);

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        // Menu de opções para interagir com o carro
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

            // Switch para escolher a ação com base na entrada do usuário
            switch (opcao) {
                case 1:
                    // Liga o carro
                    carro.ligar();
                    break;
                case 2:
                    // Acelera o carro a uma velocidade especificada pelo usuário
                    System.out.print("Informe a velocidade para acelerar: ");
                    double incremento = sc.nextDouble();
                    carro.acelerar(incremento);
                    break;
                case 3:
                    // Freia o carro
                    carro.frear();
                    break;
                case 4:
                    // Desliga o carro
                    carro.desligar();
                    break;
                case 5:
                    // Exibe os dados do carro
                    carro.exibirDados();
                    break;
                case 6:
                    // Abastece o carro com um tipo de combustível e quantidade especificados
                    System.out.print("Informe a quantidade de combustível para abastecer (litros): ");
                    double qntCombustivel = sc.nextDouble();
                    System.out.println("Informe qual o tipo de combustível que deseja abastecer:\n|1|Gasolina\n|2|Alcool\n");

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
                    // Esvazia o tanque do carro
                    carro.esvaziarTanque();
                    break;
                case 8:
                    // Mostra a capacidade de rodagem do carro com o combustível atual
                    double capacidadeRodagem = carro.getCapacidadeRodagem();
                    System.out.println("Capacidade de Rodagem: " + capacidadeRodagem + " km");
                    break;
                case 0:
                    // Limpa a tela e sai do loop, voltando para o menu anterior
                    System.out.println("\n".repeat(45));
                    loop = false;
                    break;
                default:
                    // Mensagem de erro para uma opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
