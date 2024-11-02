package br.com.fiap.fabricaVeiculos.interfaces;

import br.com.fiap.fabricaVeiculos.componentes.Tanque;

public class Alcool implements Combustivel {
    private static final double FATOR_RENDIMENTO = 7.5; // km/litro

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
