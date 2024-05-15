package PJBL;

public class Administrador extends Usuario{
    private String historicoAcoesAdministrativa; //Talvez tenha que ser ArrayList

    public Administrador(int idUsuario, String nome, String tipo, String cpf, String email, String senha,
                         String telefone, String endereco, String historicoAcoesAdministrativa) {
        super(idUsuario, nome, tipo, cpf, email, senha, telefone, endereco);
        this.historicoAcoesAdministrativa = historicoAcoesAdministrativa;
    }

    public String getHistoricoAcoesAdministrativa() {
        return historicoAcoesAdministrativa;
    }

    public void setHistoricoAcoesAdministrativa(String historicoAcoesAdministrativa) {
        this.historicoAcoesAdministrativa = historicoAcoesAdministrativa;
    }
}
