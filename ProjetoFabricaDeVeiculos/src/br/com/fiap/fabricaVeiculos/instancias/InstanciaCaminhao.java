package br.com.fiap.fabricaVeiculos.instancias;

// Importa as classes de componentes e interfaces necessárias para a instância do caminhão
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
        // Cria componentes para o caminhão, como motor, rodas, multimídia, freios e tanque
        Motor motor = new Motor("Gasolina", 300, 800, 6, 5.5, "2020");
        Rodas rodas = new Rodas(22, "Liga Leve", "Off-road", 295);
        Multimidia multimidia = new Multimidia("Pioneer", true, true, true);
        Freios freios = new Freios("Disco", "Cerâmico", true);
        Tanque tanque = new Tanque(200);

        // Instancia um caminhão com os componentes definidos e características específicas
        Caminhao caminhao = new Caminhao(
            "Volvo",
            "FH16",
            "Branco",
            "1234567845",
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

        // Menu de opções para interação com o caminhão
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

            // Switch para executar ações de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    // Liga o caminhão
                    caminhao.ligar();
                    break;
                case 2:
                    // Acelera o caminhão a uma velocidade especificada
                    System.out.print("Informe a velocidade para acelerar: ");
                    double incremento = sc.nextDouble();
                    caminhao.acelerar(incremento);
                    break;
                case 3:
                    // Freia o caminhão
                    caminhao.frear();
                    break;
                case 4:
                    // Desliga o caminhão
                    caminhao.desligar();
                    break;
                case 5:
                    // Exibe os dados do caminhão
                    caminhao.exibirDados();
                    break;
                case 6:
                    // Carrega o caminhão com uma quantidade de carga especificada
                    System.out.print("Informe a quantidade de carga para carregar (toneladas): ");
                    double cargaCarregar = sc.nextDouble();
                    caminhao.carregar(cargaCarregar);
                    break;
                case 7:
                    // Descarrega uma quantidade de carga do caminhão
                    System.out.print("Informe a quantidade de carga para descarregar (toneladas): ");
                    double cargaDescarregar = sc.nextDouble();
                    caminhao.descarregar(cargaDescarregar);
                    break;
                case 8:
                    // Abastece o caminhão com um tipo e quantidade de combustível especificados
                    System.out.print("Informe a quantidade de combustível para abastecer (litros): ");
                    double qntCombustivel = sc.nextDouble();
                    System.out.println("Informe qual o tipo de combustível que deseja abastecer:\n|1|Gasolina\n|2|Alcool");

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
                    // Esvazia o tanque do caminhão
                    caminhao.esvaziarTanque();
                    break;
                case 10:
                    // Calcula e exibe a capacidade de rodagem do caminhão
                    double capacidadeRodagem = caminhao.getCapacidadeRodagem();
                    System.out.println("Capacidade de Rodagem: " + capacidadeRodagem + " km");
                    break;
                case 0:
                    // Limpa a tela e sai do menu, retornando ao menu anterior
                    System.out.println("\n".repeat(45));
                    loop = false;
                    break;
                default:
                    // Mensagem para uma opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
