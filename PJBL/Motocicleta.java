package PJBL;

public class Motocicleta extends Veiculo {
    private String tipoMoto;
    private int cilindrada;
    private String motor;
    private int peso;
    private String tipoPartida;
    private String cambio;

    public Motocicleta(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem, String cor,
                       String placa, double preco, int quantidade, String tipoMoto, int cilindrada, String motor, int peso,
                       String tipoPartida, String cambio) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, placa, preco, quantidade);
        this.tipoMoto = tipoMoto;
        this.cilindrada = cilindrada;
        this.motor = motor;
        this.peso = peso;
        this.tipoPartida = tipoPartida;
        this.cambio = cambio;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipoPartida() {
        return tipoPartida;
    }

    public void setTipoPartida(String tipoPartida) {
        this.tipoPartida = tipoPartida;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
}
