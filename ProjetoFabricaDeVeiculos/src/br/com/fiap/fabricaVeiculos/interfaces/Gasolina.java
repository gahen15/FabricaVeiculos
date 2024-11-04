package br.com.fiap.fabricaVeiculos.interfaces;

// Importa a classe Tanque, que representa o tanque de combustível dos veículos.
import br.com.fiap.fabricaVeiculos.componentes.Tanque;

// A classe Gasolina implementa a interface Combustivel, representando um tipo específico de combustível.
public class Gasolina implements Combustivel {
    // Define o fator de rendimento da gasolina, que é 10 km/litro.
    private static final double FATOR_RENDIMENTO = 10.0;

    // Implementa o método abastecimento da interface Combustivel.
    @Override
    public double abastecimento(double litros, Tanque tanque) {
        // Tenta abastecer o tanque com a quantidade de litros especificada.
        if (tanque.abastecer(litros)) {
            // Se o abastecimento for bem-sucedido, calcula e retorna o rendimento total.
            return litros * FATOR_RENDIMENTO;
        }
        // Retorna 0 se o abastecimento falhar (por exemplo, se o tanque estiver cheio).
        return 0;
    }

    // Implementa o método getFatorRendimento da interface Combustivel.
    @Override
    public double getFatorRendimento() {
        // Retorna o fator de rendimento da gasolina.
        return FATOR_RENDIMENTO;
    }
}
