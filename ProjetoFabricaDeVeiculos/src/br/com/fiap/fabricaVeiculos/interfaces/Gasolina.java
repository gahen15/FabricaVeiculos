package br.com.fiap.fabricaVeiculos.interfaces;

import br.com.fiap.fabricaVeiculos.componentes.Tanque;

public class Gasolina implements Combustivel {
    private static final double FATOR_RENDIMENTO = 10.0;

    @Override
    public double abastecimento(double litros, Tanque tanque) {
        if (tanque.abastecer(litros)) {
            return litros * FATOR_RENDIMENTO;
        }
        return 0;
    }

    @Override
    public double getFatorRendimento() {
        return FATOR_RENDIMENTO;
    }
}
