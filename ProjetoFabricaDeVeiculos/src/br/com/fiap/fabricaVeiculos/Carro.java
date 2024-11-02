package br.com.fiap.fabricaVeiculos;

import java.time.LocalDate;

import br.com.fiap.fabricaVeiculos.componentes.Freios;
import br.com.fiap.fabricaVeiculos.componentes.Motor; // Como coloquei em outro pacote se torna necessário importar.
import br.com.fiap.fabricaVeiculos.componentes.Multimidia;
import br.com.fiap.fabricaVeiculos.componentes.Rodas;

public class Carro {

	// Atributos
	public String marca, modelo, cor, renavam, tipoCambio, nomeCondutor;
	public LocalDate anoFabricacao, anoModelo;
	public double velocidade = 0;
	public boolean ligado = false;
	public double limiteVelocidade;
	public Motor motor;
	public Rodas rodas;
	public Multimidia multimidia;
	public Freios freios;

	// Constructor
	public Carro(String marca, String modelo, String cor, String renavam, Motor motor, String tipoCambio,
			String nomeCondutor, String anoFabricacao, String anoModelo, double limiteVelocidade, Rodas rodas,
			Multimidia multimidia, Freios freios) {
		super();
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
	}

	private LocalDate converter(String dataString) {
		// Remove espaços em branco
		dataString = dataString.trim();
		try {
			// Tenta converter a string para um inteiro
			int ano = Integer.parseInt(dataString);
			// Cria um LocalDate usando 1 de janeiro como data
			return LocalDate.of(ano, 1, 1); // 1 de janeiro do ano informado
		} catch (NumberFormatException erro) {
			System.out.println("Data inválida: " + dataString + "   - Utilize o formato 'YYYY'");
			return null; // Retorna null ou lance uma exceção, conforme sua necessidade
		}
	}

	// Métodos
	public void ligar() {
		if (!this.ligado) {
			ligado = true;
			motor.ligar();
			System.out.println("O carro ligou!");
		} else {
			System.out.println("O carro já está ligado.");
		}

	}

	public void desligar() {
		if (this.ligado && velocidade == 0) {
			ligado = false;
			motor.desligar();
			System.out.println("O carro desligou!");
		} else if (this.ligado && velocidade > 0) {
			System.out.println("Não é possível desligar o carro em movimento.");
		} else {
			System.out.println("O carro já está desligado");
		}
	}

	public void acelerar(double incremento) {
		if (ligado) {
			velocidade += incremento;
			if (velocidade >= limiteVelocidade) {
				velocidade = limiteVelocidade;
				System.out.println("Velocidade máxima atingida: " + velocidade + " Km/h.");
			} else {
				System.out.println("O carro acelerou para " + velocidade + " Km/h.");
			}
		} else {
			System.out.println("Não é possível acelerar com o carro desligado.");
		}

	}

	public void frear() {
		velocidade = 0;
		System.out.println("O carro parou!");
	}

	public void exibirDados() {
		System.out.println("=== Dados do Carro ===");
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Cor: " + cor);
		System.out.println("Ano de Fabricação: " + anoFabricacao.getYear());
		System.out.println("Ano Modelo: " + anoModelo.getYear());
		System.out.println("Renavam: " + renavam);
		System.out.println("Tipo de Câmbio: " + tipoCambio);
		System.out.println("Nome do Condutor: " + nomeCondutor);
		System.out.println("Velocidade Máxima: " + limiteVelocidade + " Km/h");

		// Exibindo informações do motor
		System.out.println("\n=== Informações do Motor ===");
		if (motor != null) {
			motor.exibirInformacoes();
		} else {
			System.out.println("Motor não disponível.");
		}

		// Exibindo informações das rodas
		System.out.println("\n=== Informações das Rodas ===");
		if (rodas != null) {
			rodas.exibirInformacoes();
		} else {
			System.out.println("Rodas não disponíveis.");
		}

		// Exibindo informações da multimídia
		System.out.println("\n=== Informações da Multimídia ===");
		if (multimidia != null) {
			multimidia.exibirInformacoes();
		} else {
			System.out.println("Sistema de multimídia não disponível.");
		}

		// Exibindo informações dos freios
		System.out.println("\n=== Informações dos Freios ===");
		if (freios != null) {
			freios.exibirInformacoes();
		} else {
			System.out.println("Freios não disponíveis.");
		}
	}

}