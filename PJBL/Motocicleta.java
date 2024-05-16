package PJBL;

public abstract class Motocicleta extends Terrestre {
    private String tipoMoto;
    private int cilindrada;
    private String motor;
    private int peso;
    private String tipoPartida;
    private String cambio;

    public Motocicleta(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem,
                       String cor, String placa, double preco, int quantidade, String tipoCarroceria,
                       int potenciaMotor, String motor, String cambio, String tipoMoto, int cilindrada,
                       int peso, String tipoPartida) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, placa, preco, quantidade, tipoCarroceria, potenciaMotor);
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

    public void exibirInformacoesMotocicleta() {
        System.out.println("Tipo de Moto: " + tipoMoto);
        System.out.println("Cilindrada: " + cilindrada + " cc");
        System.out.println("Motor: " + motor);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Tipo de Partida: " + tipoPartida);
        System.out.println("Câmbio: " + cambio);
    }

    public abstract void exibirInformacoesEspecificas();

    public static void main(String[] args) {
        Motocicleta minhaMoto = new Motocicleta(1, "Motocicleta", "Marca", "Modelo", 2024, 0, "Cor", "Placa",
                0.0, 0, "Tipo Carroceria", 0, "Motor", "Câmbio", "Tipo Moto", 500, 150, "Partida Elétrica") {
            @Override
            public void exibirInformacoesEspecificas() {
                System.out.println("Informações específicas da motocicleta...");
            }
        };

        System.out.println("Informações da Motocicleta:");
        minhaMoto.exibirInformacoesMotocicleta();
        minhaMoto.exibirInformacoesEspecificas();
    }
}