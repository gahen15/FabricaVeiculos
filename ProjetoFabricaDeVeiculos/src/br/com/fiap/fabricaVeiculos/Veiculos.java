package br.com.fiap.fabricaVeiculos;

import java.time.LocalDate;

// Importa os componentes e a interface Combustivel necessários para a classe Veiculos
import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor;
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;
import br.com.fiap.fabricaVeiculos.componentes.Tanque;
import br.com.fiap.fabricaVeiculos.interfaces.Combustivel;

public abstract class Veiculos {

    // Declaração dos atributos protegidos para acesso nas subclasses
    protected String marca, modelo, cor, renavam, tipoCambio, nomeCondutor;
    protected LocalDate anoFabricacao, anoModelo;
    protected double velocidade = 0;
    private boolean ligado = false;
    protected double limiteVelocidade;
    protected Motor motor;
    protected Rodas rodas;
    protected Multimidia multimidia;
    protected Freios freios;
    protected Tanque tanque;
    protected double capacidadeRodagem;

    // Construtor para inicializar os atributos do veículo
    public Veiculos(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
            String nomeCondutor, String anoFabricacao, String anoModelo, double limiteVelocidade, Rodas rodas,
            Multimidia multimidia, Freios freios, Tanque tanque) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.renavam = renavam;
        this.motor = motor;
        this.tipoCambio = tipoCambio;
        this.nomeCondutor = nomeCondutor;
        this.anoFabricacao = converter(anoFabricacao);
        this.anoModelo = converter(anoModelo);
        this.limiteVelocidade = limiteVelocidade;
        this.rodas = rodas;
        this.multimidia = multimidia;
        this.freios = freios;
        this.tanque = tanque;
    }

    // Método auxiliar para converter ano (em String) para LocalDate
    private LocalDate converter(String dataString) {
        dataString = dataString.trim();
        try {
            int ano = Integer.parseInt(dataString);
            return LocalDate.of(ano, 1, 1); // Cria a data usando apenas o ano
        } catch (NumberFormatException erro) {
            System.out.println("Data inválida: " + dataString + " - Utilize o formato 'YYYY'");
            return null;
        }
    }

    // Método para abastecer o veículo
    public void abastecer(Combustivel combustivel, double qntCombustivel) {
        if (tanque != null) {
            double rendimento = combustivel.abastecimento(qntCombustivel, tanque);
            if (rendimento > 0) {
                capacidadeRodagem = rendimento;
                System.out.println("Abastecimento realizado com sucesso! Rendimento total: " + rendimento + " km.");
            } else {
                System.out.println("Falha no abastecimento. Verifique a quantidade de combustível.");
            }
        } else {
            System.out.println("Tanque não disponível.");
        }
    }

    // Método para esvaziar o tanque
    public void esvaziarTanque() {
        if (tanque != null) {
            tanque.consumir(tanque.getQntAtual());
            System.out.println("Tanque esvaziado.");
        } else {
            System.out.println("Tanque não disponível.");
        }
    }

    // Método para ligar o veículo
    public void ligar() {
        if (!this.ligado) {
            ligado = true;
            motor.ligar();
            System.out.println("O veículo ligou!");
        } else {
            System.out.println("O veículo já está ligado.");
        }
    }

    // Método para desligar o veículo
    public void desligar() {
        if (this.ligado && velocidade == 0) {
            ligado = false;
            motor.desligar();
            System.out.println("O veículo desligou!");
        } else if (this.ligado && velocidade > 0) {
            System.out.println("Não é possível desligar o veículo em movimento.");
        } else {
            System.out.println("O veículo já está desligado.");
        }
    }

    // Método para acelerar o veículo
    public void acelerar(double incremento) {
        if (ligado) {
            velocidade += incremento;
            if (velocidade >= limiteVelocidade) {
                velocidade = limiteVelocidade;
                System.out.println("Velocidade máxima atingida: " + velocidade + " Km/h.");
            } else {
                System.out.println("O veículo acelerou para " + velocidade + " Km/h.");
            }
        } else {
            System.out.println("Não é possível acelerar com o veículo desligado.");
        }
    }

    // Método para frear o veículo
    public void frear() {
        velocidade = 0;
        System.out.println("O veículo parou!");
    }

    // Exibe informações detalhadas do veículo
    public void exibirDados() {
        System.out.println("=== Dados do Veículo ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Ano de Fabricação: " + (anoFabricacao != null ? anoFabricacao.getYear() : "N/A"));
        System.out.println("Ano Modelo: " + (anoModelo != null ? anoModelo.getYear() : "N/A"));
        System.out.println("Renavam: " + renavam);
        System.out.println("Tipo de Câmbio: " + tipoCambio);
        System.out.println("Nome do Condutor: " + nomeCondutor);
        System.out.println("Velocidade Máxima: " + limiteVelocidade + " Km/h");

        // Exibe informações do tanque, motor, rodas, multimídia e freios
        System.out.println("=== Informações do Tanque ===");
        if (tanque != null) {
            System.out.println("Quantidade Atual de Combustível: " + tanque.getQntAtual() + " litros");
            System.out.println("Capacidade Máxima do Tanque: " + tanque.getCapacidadeMaxima() + " litros");
        } else {
            System.out.println("Tanque não disponível.");
        }

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

        System.out.println("\n=== Capacidade de Rodagem ===");
        System.out.println("Capacidade de Rodagem: " + capacidadeRodagem + " km");
    }

    // Retorna a capacidade de rodagem do veículo
    public double getCapacidadeRodagem() {
        return capacidadeRodagem;
    }
}
