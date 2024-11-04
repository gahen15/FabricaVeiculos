package br.com.fiap.fabricaVeiculos.interfaces;

// Importa a classe Tanque, que representa o tanque de combustível dos veículos.
import br.com.fiap.fabricaVeiculos.componentes.Tanque;

// A interface Combustivel define o contrato que todas as classes de combustível devem seguir.
public interface Combustivel {

    // Método que deve ser implementado para realizar o abastecimento do tanque.
    // Recebe a quantidade de litros a serem abastecidos e o objeto Tanque onde o combustível será adicionado.
    double abastecimento(double litros, Tanque tanque);

    // Método que deve ser implementado para retornar o fator de rendimento do combustível.
    // O fator de rendimento indica quantos quilômetros podem ser percorridos por litro do combustível.
    double getFatorRendimento();
}
