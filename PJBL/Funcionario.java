package PJBL;

public class Funcionario extends Usuario{
    private String historicoAtividade; //Talvez tenha que ser ArrayList

    public Funcionario(int idUsuario, String nome, String tipo, String cpf, String email, String senha, String telefone,
                       String endereco, String historicoAtividade) {
        super(idUsuario, nome, tipo, cpf, email, senha, telefone, endereco);
        this.historicoAtividade = historicoAtividade;
    }

    public String getHistoricoAtividade() {
        return historicoAtividade;
    }

    public void setHistoricoAtividade(String historicoAtividade) {
        this.historicoAtividade = historicoAtividade;
    }
}
