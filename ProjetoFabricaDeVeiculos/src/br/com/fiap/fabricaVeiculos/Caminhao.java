package br.com.fiap.fabricaVeiculos;

// Importa os componentes necessários para o caminhão
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;
import br.com.fiap.fabricaVeiculos.componentes.Tanque;

public class Caminhao extends Veiculos {
    private double qntCargaSuportada;    // Quantidade máxima de carga que o caminhão pode suportar (em toneladas)
    private double qntCargaAbastecida = 0; // Quantidade de carga atualmente no caminhão (em toneladas)
    private int eixos;                    // Número de eixos do caminhão

    // Construtor para inicializar os atributos do caminhão
    public Caminhao(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
                    String nomeCondutor, String anoFabricacao, String anoModelo, int eixos,
                    double qntCargaSuportada, double limiteVelocidade, Rodas rodas, Multimidia multimidia, 
                    Freios freios, Tanque tanque) {
        // Chama o construtor da classe pai (Veiculos) para definir atributos gerais do veículo
        super(marca, modelo, cor, renavam, motor, tipoCambio, nomeCondutor, anoFabricacao, anoModelo, limiteVelocidade, rodas, multimidia, freios, tanque);
        this.eixos = eixos;
        this.qntCargaSuportada = qntCargaSuportada;
    }

    // Sobrescreve o método exibirDados para incluir informações específicas do caminhão
    @Override
    public void exibirDados() {
        super.exibirDados(); // Chama o método exibirDados da classe pai para exibir dados gerais
        System.out.println("\n=== Informações Adicionais ===");
        System.out.println("Eixos: " + eixos);
        System.out.println("Carga máxima: " + qntCargaSuportada + " Toneladas");
        System.out.println("Carga atual: " + qntCargaAbastecida + " Toneladas");
    }

    // Método para carregar o caminhão com uma determinada quantidade de carga
    public void carregar(double quantidade) {
        // Verifica se a quantidade informada é negativa
        if (quantidade < 0) {
            System.out.println("Impossível carregar quantidade negativa.");
            return;
        }

        // Verifica se a carga adicional não ultrapassa a capacidade máxima do caminhão
        if (this.qntCargaAbastecida + quantidade <= this.qntCargaSuportada) {
            this.qntCargaAbastecida += quantidade;
            System.out.println("Carregado com " + quantidade + " toneladas. Carga atual: " + this.qntCargaAbastecida + " toneladas.");
        } else {
            // Exibe mensagem de erro caso a carga exceda a capacidade máxima
            System.out.println("Não é possível carregar " + quantidade + ". Excede capacidade máxima de " + this.qntCargaSuportada + " toneladas.");
        }
    }

    // Método para descarregar uma determinada quantidade de carga do caminhão
    public void descarregar(double quantidade) {
        // Verifica se a quantidade informada é negativa
        if (quantidade < 0) {
            System.out.println("Impossível descarregar quantidade negativa.");
            return;
        }

        // Verifica se a quantidade a ser descarregada não é maior que a carga atual
        if (quantidade <= this.qntCargaAbastecida) {
            this.qntCargaAbastecida -= quantidade;
            System.out.println("Descarregado " + quantidade + " toneladas. Carga atual: " + qntCargaAbastecida + " toneladas.");
        } else {
            // Exibe mensagem de erro caso a quantidade exceda a carga atual
            System.out.println("Impossível descarregar " + quantidade + " toneladas. Carga atual: " + qntCargaAbastecida + " toneladas.");
        }
    }
}
