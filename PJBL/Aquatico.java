package PJBL;

public class Aquatico extends Veiculo{
    private String tipoProplsao;

    public Aquatico(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem, String cor,
                    int capacidadeDePassageiro, double preco, int quantidade, String tipoProplsao) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, capacidadeDePassageiro, preco, quantidade);
        this.tipoProplsao = tipoProplsao;
    }

    public String getTipoProplsao() {
        return tipoProplsao;
    }

    public void setTipoProplsao(String tipoProplsao) {
        this.tipoProplsao = tipoProplsao;
    }
}
