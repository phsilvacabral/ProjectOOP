package PJBL;

public abstract class Caminhao extends Terrestre {
    private int eixo;
    private double comprimento;
    private double largura;
    private double altura;

    public Caminhao(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem,
                    String cor, String placa, double preco, int quantidade, String tipoCarroceria,
                    int potenciaMotor, int eixo, double comprimento, double largura, double altura) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, placa, preco, quantidade, tipoCarroceria, potenciaMotor);
        this.eixo = eixo;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
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

    public void exibirInformacoes() {
        System.out.println("Tipo de Carroceria: " + getTipoCarroceria());
        System.out.println("Potência do Motor: " + getPotenciaMotor());
        System.out.println("Número de Eixos: " + eixo);
        System.out.println("Comprimento: " + comprimento + " metros");
        System.out.println("Largura: " + largura + " metros");
        System.out.println("Altura: " + altura + " metros");
    }

    public abstract void exibirInformacoesEspecificas();

    public static void main(String[] args) {
        Caminhao meuCaminhao = new Caminhao(1, "Caminhão", "Marca", "Modelo", 2024, 0, "Cor", "Placa",
                0.0, 0, "Tipo Carroceria", 0, 0, 0.0, 0.0, 0.0) {
            @Override
            public void exibirInformacoesEspecificas() {
                System.out.println("Informações específicas do caminhão...");
            }
        };

        System.out.println("Informações do Caminhão:");
        meuCaminhao.exibirInformacoes();
        meuCaminhao.exibirInformacoesEspecificas();
    }
}
