package PJBL;

public class Funcionario extends Usuario {
    public Funcionario(int idUsuario, String nome, String cpf, String email, String senha, String telefone, String endereco) {
        super(idUsuario, nome, "Funcionario", cpf, email, senha, telefone, endereco);
    }
}
