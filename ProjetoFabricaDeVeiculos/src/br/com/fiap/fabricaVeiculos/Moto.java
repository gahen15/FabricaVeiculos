package br.com.fiap.fabricaVeiculos;

import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;

public class Moto extends Veiculos {

    public Moto(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
                String nomeCondutor, String anoFabricacao, String anoModelo, double limiteVelocidade, Rodas rodas,
                Multimidia multimidia, Freios freios) {
        super(marca, modelo, cor, renavam, motor, tipoCambio, nomeCondutor, anoFabricacao, anoModelo, limiteVelocidade,
                rodas, multimidia, freios);
    }
    
    // Você pode adicionar métodos específicos para a Moto aqui
    // Exemplo: public void empinar() { ... }
}
