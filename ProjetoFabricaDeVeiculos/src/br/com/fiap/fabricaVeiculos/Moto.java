package br.com.fiap.fabricaVeiculos;

import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;
import br.com.fiap.fabricaVeiculos.componentes.Tanque;

public class Moto extends Veiculos {

    public Moto(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
                String nomeCondutor, String anoFabricacao, String anoModelo, double limiteVelocidade, 
                Rodas rodas, Multimidia multimidia, Freios freios, Tanque tanque) {
        super(marca, modelo, cor, renavam, motor, tipoCambio, nomeCondutor, anoFabricacao, anoModelo, limiteVelocidade,
                rodas, multimidia, freios, tanque);
    }

    public void empinar() {
        if (velocidade > 20) {
            System.out.println("A moto está empinando!");
        } else {
            System.out.println("A velocidade é muito baixa para empinar.");
        }
    }
    
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("\n=== Informações da Moto ===");
    }
}
