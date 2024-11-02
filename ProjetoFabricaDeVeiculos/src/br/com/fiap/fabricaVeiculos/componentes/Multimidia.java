package br.com.fiap.fabricaVeiculos.componentes;

public class Multimidia {
    private String modelo;
    private boolean bluetooth;
    private boolean gps;
    private boolean telaTouch;
    private int volume = 0;

    public Multimidia(String modelo, boolean bluetooth, boolean gps, boolean telaTouch) {
        this.modelo = modelo;
        this.bluetooth = bluetooth;
        this.gps = gps;
        this.telaTouch = telaTouch;
    }

    public void exibirInformacoes() {
        System.out.println("Modelo do Sistema de Multimídia: " + modelo);
        System.out.println("Bluetooth: " + (bluetooth ? "Sim" : "Não"));
        System.out.println("GPS: " + (gps ? "Sim" : "Não"));
        System.out.println("Tela Touch: " + (telaTouch ? "Sim" : "Não"));
    }

    public void aumentarVolume() {
        if (volume < 100) {
            volume += 10;
            System.out.println("Volume aumentado para: " + volume);
        } else {
            System.out.println("Volume já está no máximo.");
        }
    }

    public void diminuirVolume() {
        if (volume > 0) {
            volume -= 10;
            System.out.println("Volume diminuído para: " + volume);
        } else {
            System.out.println("Volume já está no mínimo.");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public boolean hasBluetooth() {
        return bluetooth;
    }

    public boolean hasGPS() {
        return gps;
    }

    public boolean hasTelaTouch() {
        return telaTouch;
    }

    public int getVolume() {
        return volume;
    }
}
