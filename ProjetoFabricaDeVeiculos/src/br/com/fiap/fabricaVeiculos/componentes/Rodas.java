package br.com.fiap.fabricaVeiculos.componentes;

public class Rodas {
    private int aro;
    private String material;
    private String tipo;
    private double largura;

    public Rodas(int aro, String material, String tipo, double largura) {
        this.aro = aro;
        this.material = material;
        this.tipo = tipo;
        this.largura = largura;
    }

    public void exibirInformacoes() {
        System.out.println("Aro: " + aro + " polegadas");
        System.out.println("Material: " + material);
        System.out.println("Tipo: " + tipo);
        System.out.println("Largura: " + largura + " mm");
    }

    public int getAro() {
        return aro;
    }

    public String getMaterial() {
        return material;
    }

    public String getTipo() {
        return tipo;
    }

    public double getLargura() {
        return largura;
    }
}
