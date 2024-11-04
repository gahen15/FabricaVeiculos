package br.com.fiap.fabricaVeiculos.interfaces;

// Importa a classe Tanque, que representa o tanque de combustível dos veículos.
import br.com.fiap.fabricaVeiculos.componentes.Tanque;

// A classe Alcool implementa a interface Combustivel, indicando que é um tipo de combustível.
public class Alcool implements Combustivel {
    // Fator de rendimento do álcool, definido como uma constante.
    // Indica quantos quilômetros podem ser percorridos por litro de álcool.
    private static final double FATOR_RENDIMENTO = 7.5; // km/litro

    // Método para abastecer o tanque com uma quantidade de litros de álcool.
    @Override
    public double abastecimento(double litros, Tanque tanque) {
        // Verifica se o abastecimento é possível usando o método do tanque.
        if (tanque.abastecer(litros)) {
            // Se o abastecimento for bem-sucedido, calcula e retorna o rendimento total.
            return litros * FATOR_RENDIMENTO; // Rendimento total em km.
        }
        // Retorna 0 se o abastecimento não for possível (por exemplo, se não houver espaço no tanque).
        return 0;
    }

    // Método para obter o fator de rendimento do álcool.
    @Override
    public double getFatorRendimento() {
        return FATOR_RENDIMENTO; // Retorna o valor da constante FATOR_RENDIMENTO.
    }
}
