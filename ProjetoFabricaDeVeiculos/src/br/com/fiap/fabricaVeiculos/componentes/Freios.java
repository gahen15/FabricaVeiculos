package br.com.fiap.fabricaVeiculos.componentes;

public class Freios {
    // Atributos dos freios
    private String tipo; // Tipo do sistema de freios (ex: disco, tambor).
    private String material; // Material utilizado nos freios (ex: cerâmica, metal).
    private boolean abs; // Indica se o veículo possui sistema de frenagem antibloqueio (ABS).

    // Construtor que inicializa os atributos dos freios.
    public Freios(String tipo, String material, boolean abs) {
        this.tipo = tipo; // Inicializa o tipo de freio.
        this.material = material; // Inicializa o material do freio.
        this.abs = abs; // Inicializa se possui ABS.
    }

    // Método que exibe as informações dos freios no console.
    public void exibirInformacoes() {
        System.out.println("Tipo de Freio: " + tipo); // Exibe o tipo do freio.
        System.out.println("Material do Freio: " + material); // Exibe o material do freio.
        System.out.println("Possui ABS: " + (abs ? "Sim" : "Não")); // Exibe se possui ABS.
    }

    // Métodos getters para acessar os atributos dos freios.
    public String getTipo() {
        return tipo; // Retorna o tipo de freio.
    }

    public String getMaterial() {
        return material; // Retorna o material do freio.
    }

    public boolean isAbs() {
        return abs; // Retorna se possui ABS.
    }
}
