package br.com.fiap.fabricaVeiculos.componentes;

import java.time.LocalDate; // Importa a classe LocalDate para trabalhar com datas.
import br.com.fiap.fabricaVeiculos.interfaces.Combustivel; // Importa a interface Combustivel.

public class Motor {
    // Atributos do motor
    private String tipo; // Tipo do motor (ex: elétrico, combustão interna).
    private int potencia; // Potência do motor em cavalos-vapor (cv).
    private int torque; // Torque do motor em Newton-metros (Nm).
    private int quantidadeCilindros; // Número de cilindros do motor.
    private double consumo; // Consumo do motor em km/l.
    private LocalDate anoFabricacao; // Ano de fabricação do motor.
    private boolean ligado; // Estado do motor (ligado ou desligado).
    private Combustivel combustivel; // Tipo de combustível utilizado pelo motor.

    // Construtor que inicializa os atributos do motor.
    public Motor(String tipo, int potencia, int torque, int quantidadeCilindros, double consumo, String anoFabricacao) {
        this.tipo = tipo; // Inicializa o tipo do motor.
        this.potencia = potencia; // Inicializa a potência do motor.
        this.torque = torque; // Inicializa o torque do motor.
        this.quantidadeCilindros = quantidadeCilindros; // Inicializa a quantidade de cilindros.
        this.consumo = consumo; // Inicializa o consumo do motor.
        this.anoFabricacao = converter(anoFabricacao); // Converte a string do ano de fabricação para LocalDate.
    }

    // Método privado que converte uma string para um objeto LocalDate representando o ano de fabricação.
    private LocalDate converter(String dataString) {
        dataString = dataString.trim(); // Remove espaços em branco da string.
        try {
            int ano = Integer.parseInt(dataString); // Tenta converter a string para um inteiro.
            return LocalDate.of(ano, 1, 1); // Retorna o LocalDate com o ano especificado.
        } catch (NumberFormatException erro) {
            System.out.println("Data inválida: " + dataString + " - Utilize o formato 'YYYY'"); // Trata exceção caso a conversão falhe.
            return null; // Retorna null se a data for inválida.
        }
    }

    // Método que exibe as informações do motor no console.
    public void exibirInformacoes() {
        System.out.println("Tipo: " + tipo); // Exibe o tipo do motor.
        System.out.println("Potência: " + potencia + " cv"); // Exibe a potência do motor.
        System.out.println("Torque: " + torque + " Nm"); // Exibe o torque do motor.
        System.out.println("Quantidade de Cilindros: " + quantidadeCilindros); // Exibe a quantidade de cilindros.
        System.out.println("Consumo: " + consumo + " km/l"); // Exibe o consumo do motor.
        System.out.println("Ano de Fabricação: " + (anoFabricacao != null ? anoFabricacao.getYear() : "N/A")); // Exibe o ano de fabricação, se disponível.
        System.out.println("Tipo de Combustível: " + (combustivel != null ? combustivel.getClass().getSimpleName() : "N/A")); // Exibe o tipo de combustível, se definido.
    }

    // Método que liga o motor.
    public void ligar() {
        if (!ligado) { // Verifica se o motor não está ligado.
            ligado = true; // Altera o estado para ligado.
            System.out.println("O motor está ligado."); // Exibe mensagem.
        } else {
            System.out.println("O motor já está ligado."); // Informa que já está ligado.
        }
    }

    // Método que desliga o motor.
    public void desligar() {
        if (ligado) { // Verifica se o motor está ligado.
            ligado = false; // Altera o estado para desligado.
            System.out.println("O motor está desligado."); // Exibe mensagem.
        } else {
            System.out.println("O motor já está desligado."); // Informa que já está desligado.
        }
    }

    // Métodos getters para acessar os atributos do motor.
    public String getTipo() {
        return tipo; // Retorna o tipo do motor.
    }

    public int getPotencia() {
        return potencia; // Retorna a potência do motor.
    }

    public int getTorque() {
        return torque; // Retorna o torque do motor.
    }

    public int getQuantidadeCilindros() {
        return quantidadeCilindros; // Retorna a quantidade de cilindros.
    }

    public double getConsumo() {
        return consumo; // Retorna o consumo do motor.
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao; // Retorna o ano de fabricação.
    }

    public boolean isLigado() {
        return ligado; // Retorna o estado do motor (ligado ou desligado).
    }
}
