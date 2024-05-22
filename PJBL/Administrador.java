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
        int id = usuarios.size() + 1;
        System.out.println("Usuário com ID " + id + " está sendo criado.");

        System.out.print("Digite o nome do novo usuário: ");
        String nome = scanner.nextLine();
        while (nome.isBlank()) {
            System.out.print("Nome de usuário inválido! Por favor, digite novamente: ");
            nome = scanner.nextLine();
        }
        System.out.print("Digite o CPF do novo usuário: ");
        String cpf = scanner.nextLine();
        while(!Verificador.verificarCPF(usuarios, cpf)) {
            System.out.print("CPF inválido! Por favor, digite novamente: ");
            cpf = scanner.nextLine();
        }
        //Remove caracteres não numericos e formata
        cpf = cpf.replaceAll("\\D", "");
        String cpfFormatted = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

        System.out.print("Digite o email do novo usuário: ");
        String email = scanner.nextLine();
        while(!Verificador.verificarEmail(usuarios, email)) {
            System.out.print("Email inválido ou em uso! Por favor, digite novamente: ");
            email = scanner.nextLine();
        }

        System.out.print("Digite a senha do novo usuário: ");
        String senha = scanner.nextLine();
        while (senha.isBlank()) {
            System.out.print("Senha inválida! Por favor, digite novamente: ");
            senha = scanner.nextLine();
        }

        System.out.print("Digite o telefone do novo usuário com DDD sem o zero: ");
        String telefone = scanner.nextLine();
        while(!Verificador.verificarTelefone(telefone)) {
            System.out.print("Telefone inválido! Por favor, digite novamente: ");
            telefone = scanner.nextLine();
        }
        //Remove caracteres não numericos e formata
        telefone = telefone.replaceAll("\\D", "");
        String telefoneFormatted = telefone.replaceAll("(\\d{2})(\\d{4,5})(\\d{4})", "($1) $2-$3");

        System.out.print("Digite o endereço do novo usuário: ");
        String endereco = scanner.nextLine();
        while (endereco.isBlank()) {
            System.out.print("Endereço inválido! Por favor, digite novamente: ");
            endereco = scanner.nextLine();
        }

        System.out.print("Digite o tipo do novo usuário (A: Administrador/F: Funcionario): ");
        String tipo = scanner.nextLine().toUpperCase();
        while (!tipo.equals("A") && !tipo.equals("F")) {
            System.out.print("Tipo de usuário inválido! Por favor, digite novamente: ");
            tipo = scanner.nextLine().toUpperCase();
        }

        Usuario novoUsuario;
        if (tipo.equalsIgnoreCase("A")) {
            novoUsuario = new Administrador(id, nome, cpfFormatted, email, senha, telefoneFormatted, endereco);
        } else {
            novoUsuario = new Funcionario(id, nome, cpfFormatted, email, senha, telefoneFormatted, endereco);
        }

        usuarios.add(novoUsuario);
        SistemaDeLogin.salvarUsuario(novoUsuario);
        System.out.println("Novo usuário criado com sucesso.");
    }
}
