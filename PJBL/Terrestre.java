package PJBL;

public class Terrestre extends Veiculo {
    private String tipoCarroceria;
    private int potenciaMotor;

    public Terrestre(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem,
                     String cor, String placa, double preco, int quantidade, String tipoCarroceria, int potenciaMotor) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, placa, preco, quantidade);
        this.tipoCarroceria = tipoCarroceria;
        this.potenciaMotor = potenciaMotor;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public void exibirInformacoesTerrestre() {
        System.out.println("Tipo de Carroceria: " + tipoCarroceria);
        System.out.println("Potência do Motor: " + potenciaMotor);
    }

    public static void main(String[] args) {
        Terrestre meuTerrestre = new Terrestre(1, "Carro", "Toyota", "Corolla", 2022, 20000,
                "Prata", "ABC-1234", 50000, 1, "Sedan", 150);

        System.out.println("Informações do Veículo Terrestre:");
        System.out.println("Código do Veículo: " + meuTerrestre.getCodVeiculo());
        System.out.println("Tipo: " + meuTerrestre.getTipo());
        System.out.println("Marca: " + meuTerrestre.getMarca());
        System.out.println("Modelo: " + meuTerrestre.getModelo());
        System.out.println("Ano: " + meuTerrestre.getAno());
        System.out.println("Quilometragem: " + meuTerrestre.getQuilometragem());
        System.out.println("Cor: " + meuTerrestre.getCor());
        System.out.println("Placa: " + meuTerrestre.getPlaca());
        System.out.println("Preço: " + meuTerrestre.getPreco());
        System.out.println("Quantidade: " + meuTerrestre.getQuantidade());
        meuTerrestre.exibirInformacoesTerrestre();
    }
}