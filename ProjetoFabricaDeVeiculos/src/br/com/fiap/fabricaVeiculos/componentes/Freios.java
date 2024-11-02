package br.com.fiap.fabricaVeiculos.componentes;

public class Freios {
    private String tipo;
    private String material;
    private boolean abs;

    public Freios(String tipo, String material, boolean abs) {
        this.tipo = tipo;
        this.material = material;
        this.abs = abs;
    }

    public void exibirInformacoes() {
        System.out.println("Tipo de Freio: " + tipo);
        System.out.println("Material do Freio: " + material);
        System.out.println("Possui ABS: " + (abs ? "Sim" : "Não"));
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isAbs() {
        return abs;
    }
}
