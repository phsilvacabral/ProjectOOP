package PJBL;

public class Caminhao extends Veiculo{
    private String tipoCarroceria;
    private int capacidadeCarga;
    private int potenciaMotor;
    private int eixo;
    private double comprimento;
    private double largura;
    private double altura;

    public Caminhao(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem, String cor,
                    String placa, double preco, int quantidade, String tipoCarroceria, int capacidadeCarga,
                    int potenciaMotor, int eixo, double comprimento, double largura, double altura) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, placa, preco, quantidade);
        this.tipoCarroceria = tipoCarroceria;
        this.capacidadeCarga = capacidadeCarga;
        this.potenciaMotor = potenciaMotor;
        this.eixo = eixo;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public int getEixo() {
        return eixo;
    }

    public void setEixo(int eixo) {
        this.eixo = eixo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
