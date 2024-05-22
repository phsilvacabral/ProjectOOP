package PJBL;

public class Aviao extends Aereo{
    private int numeroDeMotore;
    private String tipoDeAviao;
    private double alcanceDeVoo;

    public Aviao(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem, String cor,
                 int capacidadeDePassageiro, double preco, int quantidade, String tipoPropulsao, int numeroDeMotore,
                 String tipoDeAviao, double alcanceDeVoo) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, capacidadeDePassageiro, preco, quantidade,
                tipoPropulsao);
        this.numeroDeMotore = numeroDeMotore;
        this.tipoDeAviao = tipoDeAviao;
        this.alcanceDeVoo = alcanceDeVoo;
    }

    public int getNumeroDeMotore() {
        return numeroDeMotore;
    }

    public void setNumeroDeMotore(int numeroDeMotore) {
        this.numeroDeMotore = numeroDeMotore;
    }

    public String getTipoDeAviao() {
        return tipoDeAviao;
    }

    public void setTipoDeAviao(String tipoDeAviao) {
        this.tipoDeAviao = tipoDeAviao;
    }

    public double getAlcanceDeVoo() {
        return alcanceDeVoo;
    }

    public void setAlcanceDeVoo(double alcanceDeVoo) {
        this.alcanceDeVoo = alcanceDeVoo;
    }
}
