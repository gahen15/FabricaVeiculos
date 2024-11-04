package br.com.fiap.fabricaVeiculos.componentes;

// A classe Rodas representa as rodas de um veículo.
public class Rodas {
    // Aro da roda em polegadas.
    private int aro;
    // Material da roda (ex: aço, liga leve, etc.).
    private String material;
    // Tipo da roda (ex: esportiva, off-road, etc.).
    private String tipo;
    // Largura da roda em milímetros.
    private double largura;

    // Construtor que inicializa os atributos da roda.
    public Rodas(int aro, String material, String tipo, double largura) {
        this.aro = aro; // Aro da roda.
        this.material = material; // Material da roda.
        this.tipo = tipo; // Tipo da roda.
        this.largura = largura; // Largura da roda.
    }

    // Método que exibe as informações da roda no console.
    public void exibirInformacoes() {
        System.out.println("Aro: " + aro + " polegadas"); // Exibe o aro.
        System.out.println("Material: " + material); // Exibe o material.
        System.out.println("Tipo: " + tipo); // Exibe o tipo.
        System.out.println("Largura: " + largura + " mm"); // Exibe a largura.
    }

    // Método que retorna o aro da roda.
    public int getAro() {
        return aro;
    }

    // Método que retorna o material da roda.
    public String getMaterial() {
        return material;
    }

    // Método que retorna o tipo da roda.
    public String getTipo() {
        return tipo;
    }

    // Método que retorna a largura da roda.
    public double getLargura() {
        return largura;
    }
}
