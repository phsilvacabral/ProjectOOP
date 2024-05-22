package PJBL;

public class Embarcacao extends Aquatico{
    private double alcanceNavegacao;

    public Embarcacao(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem, String cor,
                      int capacidadeDePassageiro, double preco, int quantidade, String tipoProplsao,
                      double alcanceNavegacao) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, capacidadeDePassageiro, preco, quantidade,
                tipoProplsao);
        this.alcanceNavegacao = alcanceNavegacao;
    }

    public double getAlcanceNavegacao() {
        return alcanceNavegacao;
    }

    public void setAlcanceNavegacao(double alcanceNavegacao) {
        this.alcanceNavegacao = alcanceNavegacao;
    }
}
