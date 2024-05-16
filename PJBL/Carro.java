package PJBL;

public abstract class Carro extends Terrestre {
    private int numAssento;
    private int numPorta;
    private int capacidadePortaMala;
    private String motor;
    private String combustivel;
    private String cambio;

    public Carro(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem,
                 String cor, String placa, double preco, int quantidade, String tipoCarroceria,
                 int potenciaMotor, String motor, String combustivel, String cambio,
                 int numAssento, int numPorta, int capacidadePortaMala) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, placa, preco, quantidade, tipoCarroceria, potenciaMotor);
        this.numAssento = numAssento;
        this.numPorta = numPorta;
        this.capacidadePortaMala = capacidadePortaMala;
        this.motor = motor;
        this.combustivel = combustivel;
        this.cambio = cambio;
    }

    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    public int getNumPorta() {
        return numPorta;
    }

    public void setNumPorta(int numPorta) {
        this.numPorta = numPorta;
    }

    public int getCapacidadePortaMala() {
        return capacidadePortaMala;
    }

    public void setCapacidadePortaMala(int capacidadePortaMala) {
        this.capacidadePortaMala = capacidadePortaMala;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public void exibirInformacoesCarro() {
        System.out.println("Tipo de Carroceria: " + getTipoCarroceria());
        System.out.println("Número de Assentos: " + numAssento);
        System.out.println("Número de Portas: " + numPorta);
        System.out.println("Capacidade do Porta-Malas: " + capacidadePortaMala);
        System.out.println("Motor: " + motor);
        System.out.println("Combustível: " + combustivel);
        System.out.println("Câmbio: " + cambio);
    }

    public abstract void exibirInformacoesEspecificas();

    public static void main(String[] args) {
        Carro meuCarro = new Carro(1, "Carro", "Marca", "Modelo", 2024, 0, "Cor", "Placa",
                0.0, 0, "Tipo Carroceria", 0, "Motor", "Combustível", "Câmbio",
                5, 4, 500) {
            @Override
            public void exibirInformacoesEspecificas() {
                System.out.println("Informações específicas do carro...");
            }
        };

        System.out.println("Informações do Carro:");
        meuCarro.exibirInformacoesCarro();
        meuCarro.exibirInformacoesEspecificas();
    }
}