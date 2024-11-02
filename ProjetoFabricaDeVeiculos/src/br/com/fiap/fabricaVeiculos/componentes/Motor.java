package br.com.fiap.fabricaVeiculos.componentes;

import java.time.LocalDate;
import br.com.fiap.fabricaVeiculos.interfaces.Combustivel;

public class Motor {
    private String tipo;
    private int potencia;
    private int torque;
    private int quantidadeCilindros;
    private double consumo;
    private LocalDate anoFabricacao;
    private boolean ligado;
    private Combustivel combustivel;

    public Motor(String tipo, int potencia, int torque, int quantidadeCilindros, double consumo, String anoFabricacao) {
        this.tipo = tipo;
        this.potencia = potencia;
        this.torque = torque;
        this.quantidadeCilindros = quantidadeCilindros;
        this.consumo = consumo;
        this.anoFabricacao = converter(anoFabricacao);
        
    }

    private LocalDate converter(String dataString) {
        dataString = dataString.trim();
        try {
            int ano = Integer.parseInt(dataString);
            return LocalDate.of(ano, 1, 1);
        } catch (NumberFormatException erro) {
            System.out.println("Data inválida: " + dataString + " - Utilize o formato 'YYYY'");
            return null;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Potência: " + potencia + " cv");
        System.out.println("Torque: " + torque + " Nm");
        System.out.println("Quantidade de Cilindros: " + quantidadeCilindros);
        System.out.println("Consumo: " + consumo + " km/l");
        System.out.println("Ano de Fabricação: " + (anoFabricacao != null ? anoFabricacao.getYear() : "N/A"));
        System.out.println("Tipo de Combustível: " + combustivel.getClass().getSimpleName());
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("O motor está ligado.");
        } else {
            System.out.println("O motor já está ligado.");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("O motor está desligado.");
        } else {
            System.out.println("O motor já está desligado.");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getTorque() {
        return torque;
    }

    public int getQuantidadeCilindros() {
        return quantidadeCilindros;
    }

    public double getConsumo() {
        return consumo;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public boolean isLigado() {
        return ligado;
    }
}
