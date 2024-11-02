package br.com.fiap.fabricaVeiculos;

import java.time.LocalDate;
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;

public class Caminhao {
    public String marca, modelo, cor, renavam, tipoCambio, nomeCondutor, tipoCargaAbastecida;
    public LocalDate anoFabricacao, anoModelo;
    public double velocidade = 0, qntCargaSuportada, qntCargaAbastecida = 0;
    public boolean ligado = false;
    public double limiteVelocidade;
    
    public Motor motor;
    public Rodas rodas;
    public Multimidia multimidia;
    public Freios freios;
    public int aroRodas, eixos;

    public Caminhao(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
                    String nomeCondutor, String anoFabricacao, String anoModelo, int aroRodas, int eixos,
                    double qntCargaSuportada, double limiteVelocidade, Rodas rodas, Multimidia multimidia, Freios freios) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.renavam = renavam;
        this.motor = motor;
        this.tipoCambio = tipoCambio;
        this.nomeCondutor = nomeCondutor;
        this.anoFabricacao = converter(anoFabricacao);
        this.anoModelo = converter(anoModelo);
        this.aroRodas = aroRodas;
        this.eixos = eixos;
        this.qntCargaSuportada = qntCargaSuportada;
        this.limiteVelocidade = limiteVelocidade;
        this.rodas = rodas;
        this.multimidia = multimidia;
        this.freios = freios;
    }

    private LocalDate converter(String dataString) {
        dataString = dataString.trim();
        try {
            int ano = Integer.parseInt(dataString);
            return LocalDate.of(ano, 1, 1);
        } catch (NumberFormatException erro) {
            System.out.println("Data inválida: " + dataString + "   - Utilize o formato 'YYYY'");
            return null;
        }
    }

    public void ligar() {
        if (!this.ligado) {
            ligado = true;
            System.out.println("O caminhão ligou!");
        } else {
            System.out.println("O caminhão já está ligado.");
        }
    }

    public void desligar() {
        if (this.ligado && velocidade == 0) {
            ligado = false;
            System.out.println("O caminhão desligou!");
        } else if (this.ligado && velocidade > 0) {
            System.out.println("Não é possível desligar o caminhão em movimento.");
        } else {
            System.out.println("O caminhão já está desligado");
        }
    }

    public void acelerar(double incremento) {
        if (ligado) {
            velocidade += incremento;
            if (velocidade >= limiteVelocidade) {
                velocidade = limiteVelocidade;
                System.out.println("Velocidade máxima atingida: " + velocidade + " Km/h.");
            } else {
                System.out.println("O caminhão acelerou para " + velocidade + " Km/h.");
            }
        } else {
            System.out.println("Não é possível acelerar com o caminhão desligado.");
        }
    }

    public void frear() {
        velocidade = 0;
        System.out.println("O caminhão parou!");
    }

    public void exibirDados() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Ano de Fabricação: " + anoFabricacao.getYear());
        System.out.println("Ano Modelo: " + anoModelo.getYear());
        System.out.println("Renavam: " + renavam);
        System.out.println("Tipo de Câmbio: " + tipoCambio);
        System.out.println("Eixos: " + eixos);
        System.out.println("Aro das Rodas: " + aroRodas);
        System.out.println("Nome do Condutor: " + nomeCondutor);
        System.out.println("Carga máxima: " + qntCargaSuportada + " Toneladas");
        System.out.println("Velocidade Máxima: " + limiteVelocidade);

        System.out.println("\n=== Informações do Motor ===");
        if (motor != null) {
            motor.exibirInformacoes();
        } else {
            System.out.println("Motor não disponível.");
        }

        System.out.println("\n=== Informações das Rodas ===");
        if (rodas != null) {
            rodas.exibirInformacoes();
        } else {
            System.out.println("Rodas não disponíveis.");
        }

        System.out.println("\n=== Informações da Multimídia ===");
        if (multimidia != null) {
            multimidia.exibirInformacoes();
        } else {
            System.out.println("Sistema de multimídia não disponível.");
        }

        System.out.println("\n=== Informações dos Freios ===");
        if (freios != null) {
            freios.exibirInformacoes();
        } else {
            System.out.println("Freios não disponíveis.");
        }
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
