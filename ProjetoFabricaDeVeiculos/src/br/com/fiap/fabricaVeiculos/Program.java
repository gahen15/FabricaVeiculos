package br.com.fiap.fabricaVeiculos;

import java.util.Scanner;

// Importa as classes de instância de cada tipo de veículo
import br.com.fiap.fabricaVeiculos.instancias.InstanciaCarro;
import br.com.fiap.fabricaVeiculos.instancias.InstanciaCaminhao;
import br.com.fiap.fabricaVeiculos.instancias.InstanciaMoto;

public class Program {
    public static void main(String[] args) {
        // Scanner para capturar a entrada do usuário
        Scanner sc = new Scanner(System.in);
        // Variável para controlar o loop principal do programa
        boolean loop = true;

        // Loop para exibir o menu até que o usuário decida sair
        while (loop) {
            // Exibe o menu de opções de veículos para o usuário
            System.out.println("Selecione o tipo de veículo:");
            System.out.println("1 - Carro");
            System.out.println("2 - Caminhão");
            System.out.println("3 - Moto");
            System.out.println("0 - Sair");
            
            // Captura a escolha do usuário
            int escolha = sc.nextInt();

            // Executa uma ação com base na escolha do usuário
            switch (escolha) {
                case 1:
                    // Chama o método principal da classe InstanciaCarro para inicializar um carro
                    InstanciaCarro.main(null);
                    break;
                case 2:
                    // Chama o método principal da classe InstanciaCaminhao para inicializar um caminhão
                    InstanciaCaminhao.main(null); 
                    break;
                case 3:
                    // Chama o método principal da classe InstanciaMoto para inicializar uma moto
                    InstanciaMoto.main(null); 
                    break;
                case 0:
                    // Altera o loop para false, encerrando o programa
                    loop = false;
                    break;
                default:
                    // Exibe uma mensagem caso o usuário insira uma opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        // Fecha o Scanner para liberar o recurso
        sc.close();
    }
}
