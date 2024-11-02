package br.com.fiap.fabricaVeiculos.interfaces;

import br.com.fiap.fabricaVeiculos.componentes.Tanque;


public interface Combustivel {

    double abastecimento(double litros, Tanque tanque);

    
    double getFatorRendimento();
}
