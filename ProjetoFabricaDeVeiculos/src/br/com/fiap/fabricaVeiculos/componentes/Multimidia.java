package br.com.fiap.fabricaVeiculos.componentes;

// A classe Multimidia representa o sistema de multimídia de um veículo.
public class Multimidia {
    // Modelo do sistema de multimídia.
    private String modelo;
    // Indica se o sistema possui Bluetooth.
    private boolean bluetooth;
    // Indica se o sistema possui GPS.
    private boolean gps;
    // Indica se o sistema possui tela touch.
    private boolean telaTouch;
    // Volume atual do sistema de multimídia.
    private int volume = 0;

    // Construtor que inicializa os atributos do sistema de multimídia.
    public Multimidia(String modelo, boolean bluetooth, boolean gps, boolean telaTouch) {
        this.modelo = modelo; // Modelo do sistema de multimídia.
        this.bluetooth = bluetooth; // Atributo para Bluetooth.
        this.gps = gps; // Atributo para GPS.
        this.telaTouch = telaTouch; // Atributo para tela touch.
    }

    // Método que exibe as informações do sistema de multimídia no console.
    public void exibirInformacoes() {
        System.out.println("Modelo do Sistema de Multimídia: " + modelo); // Exibe o modelo.
        System.out.println("Bluetooth: " + (bluetooth ? "Sim" : "Não")); // Exibe se tem Bluetooth.
        System.out.println("GPS: " + (gps ? "Sim" : "Não")); // Exibe se tem GPS.
        System.out.println("Tela Touch: " + (telaTouch ? "Sim" : "Não")); // Exibe se tem tela touch.
    }

    // Método que aumenta o volume do sistema de multimídia.
    public void aumentarVolume() {
        if (volume < 100) { // Verifica se o volume está abaixo do máximo.
            volume += 10; // Aumenta o volume em 10.
            System.out.println("Volume aumentado para: " + volume); // Exibe o novo volume.
        } else {
            System.out.println("Volume já está no máximo."); // Informa que o volume já está no máximo.
        }
    }

    // Método que diminui o volume do sistema de multimídia.
    public void diminuirVolume() {
        if (volume > 0) { // Verifica se o volume está acima do mínimo.
            volume -= 10; // Diminui o volume em 10.
            System.out.println("Volume diminuído para: " + volume); // Exibe o novo volume.
        } else {
            System.out.println("Volume já está no mínimo."); // Informa que o volume já está no mínimo.
        }
    }

    // Método que retorna o modelo do sistema de multimídia.
    public String getModelo() {
        return modelo;
    }

    // Método que verifica se o sistema possui Bluetooth.
    public boolean hasBluetooth() {
        return bluetooth;
    }

    // Método que verifica se o sistema possui GPS.
    public boolean hasGPS() {
        return gps;
    }

    // Método que verifica se o sistema possui tela touch.
    public boolean hasTelaTouch() {
        return telaTouch;
    }

    // Método que retorna o volume atual do sistema de multimídia.
    public int getVolume() {
        return volume;
    }
}
