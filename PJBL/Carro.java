package PJBL;

public class Carro extends Veiculo{
    private String tipoCarroceria;
    private int numAssento;
    private int numPorta;
    private int capacidadePortaMala;
    private String motor;
    private int potenciaMotor;
    private String combustivel;
    private String cambio;

    public Carro(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem, String cor,
                 String placa, double preco, int quantidade, String tipoCarroceria, int numAssento, int numPorta,
                 int capacidadePortaMala, String motor, int potenciaMotor, String combustivel, String cambio) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, placa, preco, quantidade);
        this.tipoCarroceria = tipoCarroceria;
        this.numAssento = numAssento;
        this.numPorta = numPorta;
        this.capacidadePortaMala = capacidadePortaMala;
        this.motor = motor;
        this.potenciaMotor = potenciaMotor;
        this.combustivel = combustivel;
        this.cambio = cambio;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
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

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
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
}
