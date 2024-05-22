package PJBL;
import java.util.List;
import java.util.Scanner;
public class Administrador extends Usuario {
    public Administrador(int idUsuario, String nome, String cpf, String email, String senha, String telefone,
                         String endereco) {
        super(idUsuario, nome, "Administrador", cpf, email, senha, telefone, endereco);
    }

    //Método do Administrador para criar Usuario
    public void criarNovoUsuario(Scanner scanner, List<Usuario> usuarios) throws LoginException {
        System.out.print("Digite o id do novo usuário: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o nome do novo usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do novo usuário: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o email do novo usuário: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha do novo usuário: ");
        String senha = scanner.nextLine();
        System.out.print("Digite o telefone do novo usuário: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o endereço do novo usuário: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o tipo do novo usuário (Administrador/Funcionario): ");
        String tipo = scanner.nextLine();

        Usuario novoUsuario;
        if (tipo.equalsIgnoreCase("Administrador")) {
            novoUsuario = new Administrador(id, nome, cpf, email, senha, telefone, endereco);
        } else {
            novoUsuario = new Funcionario(id, nome, cpf, email, senha, telefone, endereco);
        }

        usuarios.add(novoUsuario);
        SistemaDeLogin.salvarUsuario(novoUsuario);
        System.out.println("Novo usuário criado com sucesso.");
    }
}
