package br.com.fiap.fabricaVeiculos.instancias;

// Importa as classes de componentes e interfaces necessárias para a instância da moto
import br.com.fiap.fabricaVeiculos.Moto;
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;
import br.com.fiap.fabricaVeiculos.componentes.Tanque;
import br.com.fiap.fabricaVeiculos.interfaces.Alcool;
import br.com.fiap.fabricaVeiculos.interfaces.Combustivel;
import br.com.fiap.fabricaVeiculos.interfaces.Gasolina;

import java.util.Scanner;

public class InstanciaMoto {

	 public static void main(String[] args) {
        // Cria os componentes para a moto, como motor, rodas, multimídia, freios e tanque
        Motor motor = new Motor("Gasolina", 300, 800, 6, 5.5, "2020");
        Rodas rodas = new Rodas(18, "Alumínio", "Esportiva", 8.5);
        Multimidia multimidia = new Multimidia("Modelo X", true, true, true);
        Freios freios = new Freios("Disco", "Cerâmico", true);
        Tanque tanque = new Tanque(200);
        
        // Instancia uma moto com os componentes definidos e características específicas
        Moto moto = new Moto(
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
                rodas,
                multimidia,
                freios,
                tanque
        );

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        // Loop para exibir o menu de opções até que o usuário opte por sair
        while (loop) {
            System.out.println("\n=== Painel de Opções da Moto ===");
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

            // Switch para executar as ações de acordo com a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Liga a moto
                    moto.ligar();
                    break;
                case 2:
                    // Acelera a moto para uma velocidade especificada
                    System.out.print("Informe a velocidade para acelerar: ");
                    double incremento = sc.nextDouble();
                    moto.acelerar(incremento);
                    break;
                case 3:
                    // Freia a moto
                    moto.frear();
                    break;
                case 4:
                    // Desliga a moto
                    moto.desligar();
                    break;
                case 5:
                    // Exibe os dados da moto
                    moto.exibirDados();
                    break;
                case 6:
                    // Abastece a moto com a quantidade e tipo de combustível especificados
                    System.out.print("Informe a quantidade de combustível para abastecer (litros): ");
                    double qntCombustivel = sc.nextDouble();
                    System.out.println(
                            "Informe qual o tipo de combustível que deseja abastecer:\n|1|Gasolina\n|2|Alcool");

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
                    moto.abastecer(combustivel, qntCombustivel);
                    break;
                case 7:
                    // Esvazia o tanque da moto
                    moto.esvaziarTanque();
                    break;
                case 8:
                    // Calcula e exibe a capacidade de rodagem da moto
                    double capacidadeRodagem = moto.getCapacidadeRodagem();
                    System.out.println("Capacidade de Rodagem: " + capacidadeRodagem + " km");
                    break;
                case 0:
                    // Limpa a tela e finaliza o loop, saindo do menu
                    System.out.println("\n".repeat(45));
                    loop = false;
                    break;
                default:
                    // Exibe uma mensagem para uma opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
