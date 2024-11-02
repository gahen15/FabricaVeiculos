package br.com.fiap.fabricaVeiculos;


import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;

public class Caminhao extends Veiculos {
    // Atributos adicionais
    private double qntCargaSuportada;
    private double qntCargaAbastecida = 0;
    private int eixos;

    // Construtor
    public Caminhao(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
                    String nomeCondutor, String anoFabricacao, String anoModelo,int eixos,
                    double qntCargaSuportada, double limiteVelocidade, Rodas rodas, Multimidia multimidia, Freios freios) {
        // Chama o construtor da superclasse (Veiculos)
        super(marca, modelo, cor, renavam, motor, tipoCambio, nomeCondutor, anoFabricacao, anoModelo, limiteVelocidade, rodas, multimidia, freios);
     
        this.eixos = eixos;
        this.qntCargaSuportada = qntCargaSuportada;
        this.limiteVelocidade = limiteVelocidade; // Opcional, pois já é definido na superclasse
    }

    // Métodos
    @Override
    public void exibirDados() {
        super.exibirDados(); // Exibe dados da superclasse
        // Exibe dados adicionais do caminhão
       
        System.out.println("\n=== Informações Adicionais ===\nEixos: " + eixos);
        System.out.println("Carga máxima: " + qntCargaSuportada + " Toneladas");
        // Exibe informações sobre a carga
        System.out.println("Carga atual: " + qntCargaAbastecida + " Toneladas");
    }

    public void carregar(double quantidade) {
        if (this.qntCargaAbastecida + quantidade <= this.qntCargaSuportada) {
            this.qntCargaAbastecida += quantidade;
            System.out.println("Carregado com " + quantidade + " toneladas. Carga atual: " + this.qntCargaAbastecida + " toneladas.");
        } else if (quantidade < 0) {
            System.out.println("Impossível carregar quantidade negativa.");
        } else {
            System.out.println("Não é possível carregar " + quantidade + ". Excede capacidade máxima de " + this.qntCargaSuportada + " toneladas.");
        }
    }

    public void descarregar(double quantidade) {
        if (quantidade <= this.qntCargaAbastecida) {
            this.qntCargaAbastecida -= quantidade;
            System.out.println("Descarregado " + quantidade + " toneladas. Carga atual: " + qntCargaAbastecida + " toneladas.");
        } else if (quantidade < 0) {
            System.out.println("Impossível descarregar quantidade negativa.");
        } else {
            System.out.println("Impossível descarregar " + quantidade + " toneladas. Carga atual: " + qntCargaAbastecida);
        }
    }
}
