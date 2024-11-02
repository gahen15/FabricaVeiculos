package br.com.fiap.fabricaVeiculos;

import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;
import br.com.fiap.fabricaVeiculos.componentes.Tanque;

public class Caminhao extends Veiculos {
    private double qntCargaSuportada;    
    private double qntCargaAbastecida = 0; 
    private int eixos;                    

    public Caminhao(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
                    String nomeCondutor, String anoFabricacao, String anoModelo, int eixos,
                    double qntCargaSuportada, double limiteVelocidade, Rodas rodas, Multimidia multimidia, 
                    Freios freios, Tanque tanque) {
        super(marca, modelo, cor, renavam, motor, tipoCambio, nomeCondutor, anoFabricacao, anoModelo, limiteVelocidade, rodas, multimidia, freios, tanque);
        this.eixos = eixos;
        this.qntCargaSuportada = qntCargaSuportada;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("\n=== Informações Adicionais ===");
        System.out.println("Eixos: " + eixos);
        System.out.println("Carga máxima: " + qntCargaSuportada + " Toneladas");
        System.out.println("Carga atual: " + qntCargaAbastecida + " Toneladas");
    }

    public void carregar(double quantidade) {
        if (quantidade < 0) {
            System.out.println("Impossível carregar quantidade negativa.");
            return;
        }

        if (this.qntCargaAbastecida + quantidade <= this.qntCargaSuportada) {
            this.qntCargaAbastecida += quantidade;
            System.out.println("Carregado com " + quantidade + " toneladas. Carga atual: " + this.qntCargaAbastecida + " toneladas.");
        } else {
            System.out.println("Não é possível carregar " + quantidade + ". Excede capacidade máxima de " + this.qntCargaSuportada + " toneladas.");
        }
    }

    public void descarregar(double quantidade) {
        if (quantidade < 0) {
            System.out.println("Impossível descarregar quantidade negativa.");
            return;
        }

        if (quantidade <= this.qntCargaAbastecida) {
            this.qntCargaAbastecida -= quantidade;
            System.out.println("Descarregado " + quantidade + " toneladas. Carga atual: " + qntCargaAbastecida + " toneladas.");
        } else {
            System.out.println("Impossível descarregar " + quantidade + " toneladas. Carga atual: " + qntCargaAbastecida + " toneladas.");
        }
    }
}
