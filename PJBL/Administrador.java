package PJBL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador extends Usuario {
    public Administrador(int idUsuario, String nome, String cpf, String email, String senha, String telefone,
                         String endereco) {
        super(idUsuario, nome, "Administrador", cpf, email, senha, telefone, endereco);
    }

    @Override
    public void listarUsuarios(List<Usuario> usuarios) {
        boolean temFuncionarios = false;
        System.out.println("Administradores:");
        for (Usuario usuario : usuarios) {
            if (usuario.getTipo().equals("Administrador")) {
                exibirInfo(usuario);
                System.out.println();
            }
        }

        System.out.println("Funcionários:");
        for (Usuario usuario : usuarios) {
            if (usuario.getTipo().equals("Funcionario")) {
                exibirInfo(usuario);
                System.out.println();
                temFuncionarios = true;
            }
        }
        if (!temFuncionarios) {
            System.out.println("Nenhum funcionário cadastrado.");
        }
    }

    public void exibirInfo(Usuario usuario) {
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Telefone: " + usuario.getTelefone());
        System.out.println("Endereço: " + usuario.getEndereco());
    }

    //Método do Administrador para criar Usuario
    public void criarNovoUsuario(Scanner scanner, List<Usuario> usuarios) throws LoginException {
        // Encontrar o menor ID livre
        int id = 1;
        List<Integer> idsExistentes = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            idsExistentes.add(usuario.getIdUsuario());
        }
        while (idsExistentes.contains(id)) {
            id++;
        }
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

    public void editarUsuario(Scanner scanner, List<Usuario> usuarios) throws LoginException {
        System.out.print("Infome o CPF do Usuário: ");
        String cpf = scanner.nextLine();
        while(!Verificador.verificaCPF(cpf)) {
            System.out.print("CPF inválido! Por favor, digite novamente: ");
            cpf = scanner.nextLine();
        }
        //Remove caracteres não numericos e formata
        cpf = cpf.replaceAll("\\D", "");
        String cpfFormatted = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            String cpfUsuario = usuario.getCpf();
            if (cpfUsuario.equals(cpfFormatted)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            String nomeAtual = usuarioEncontrado.getNome();
            System.out.println("Nome atual do usuário (" + nomeAtual + ") ");
            System.out.print("Digite o novo nome do usuário ou pressione ENTER para continuar: ");
            String nome = scanner.nextLine();
            if (nome.isBlank()) {
                nome = nomeAtual;
            }
            usuarioEncontrado.setNome(nome);

            String cpfAtual = usuarioEncontrado.getCpf();
            System.out.println("CPF atual do usuário (" + cpfAtual + ") ");
            System.out.print("Digite o novo CPF do usuário ou pressione ENTER para continuar: ");
            String cpf_ = scanner.nextLine();
            if (cpf_.isBlank()) {
                cpf_ = cpfAtual;
                usuarioEncontrado.setCpf(cpf_);
            } else {
                while(!Verificador.verificarCPF(usuarios, cpf_)) {
                    System.out.print("CPF inválido! Por favor, digite novamente: ");
                    cpf_ = scanner.nextLine();
                }
                //Remove caracteres não numericos e formata
                cpf_ = cpf_.replaceAll("\\D", "");
                String cpfFormatted_ = cpf_.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
                        "$1.$2.$3-$4");
                usuarioEncontrado.setCpf(cpfFormatted_);
            }

            String emailAtual = usuarioEncontrado.getEmail();
            System.out.println("Email atual do usuário (" + emailAtual + ") ");
            System.out.print("Digite o novo email do usuário ou pressione ENTER para continuar: ");
            String email = scanner.nextLine();
            if (email.isBlank()) {
                email = emailAtual;
                usuarioEncontrado.setEmail(email);
            } else {
                while(!Verificador.verificarEmail(usuarios, email)) {
                    System.out.print("Email inválido ou em uso! Por favor, digite novamente: ");
                    email = scanner.nextLine();
                }
                usuarioEncontrado.setEmail(email);
            }

            String senhaAtual = usuarioEncontrado.getSenha();
            System.out.println("Senha atual do usuário (" + senhaAtual + ") ");
            System.out.print("Digite a nova senha do usuário ou pressione ENTER para continuar: ");
            String senha = scanner.nextLine();
            if (senha.isBlank()) {
                senha = senhaAtual;
            }
            usuarioEncontrado.setSenha(senha);

            String telefoneAtual = usuarioEncontrado.getTelefone();
            System.out.println("Telefone atual do usuário (" + telefoneAtual + ") ");
            System.out.print("Digite o novo telefone do usuário ou pressione ENTER para continuar: ");
            String telefone = scanner.nextLine();
            if (telefone.isBlank()){
                telefone = telefoneAtual;
                usuarioEncontrado.setTelefone(telefone);
            } else {
                while(!Verificador.verificarTelefone(telefone)) {
                    System.out.print("Telefone inválido! Por favor, digite novamente: ");
                    telefone = scanner.nextLine();
                }
                //Remove caracteres não numericos e formata
                telefone = telefone.replaceAll("\\D", "");
                String telefoneFormatted = telefone.replaceAll("(\\d{2})(\\d{4,5})(\\d{4})",
                        "($1) $2-$3");
                usuarioEncontrado.setTelefone(telefoneFormatted);
            }

            String enderecoAtual = usuarioEncontrado.getEndereco();
            System.out.println("Endereco atual do usuário (" + enderecoAtual + ") ");
            System.out.print("Digite o novo endereço do usuário ou pressione ENTER para continuar: ");
            String endereco = scanner.nextLine();
            if (endereco.isBlank()) {
                endereco = enderecoAtual;
            }
            usuarioEncontrado.setEndereco(endereco);

            SistemaDeLogin.atualizarUsuario(usuarioEncontrado, cpfFormatted);
            System.out.println("Usuário editado com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void deletarUsuario (Scanner scanner, List<Usuario> usuarios, Usuario usuarioLogado) throws LoginException {
        System.out.print("Infome o CPF do Usuário: ");
        String cpf = scanner.nextLine();
        while(!Verificador.verificaCPF(cpf)) {
            System.out.print("CPF inválido! Por favor, digite novamente: ");
            cpf = scanner.nextLine();
        }
        //Remove caracteres não numericos e formata
        cpf = cpf.replaceAll("\\D", "");
        String cpfFormatted = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

        if (cpfFormatted.equals(usuarioLogado.getCpf())) {
            System.out.println("Não é possível apagar a conta em utilização.");
            return;
        }

        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpfFormatted)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            System.out.println("O usuário a ser deletado é (" + usuarioEncontrado.getNome() + ") ");
            System.out.print("Digite a sua senha para confirmar a exclusão ou ENTER para cancelar: ");
            String senha = scanner.nextLine();
            if (senha.isBlank()){
                return;
            }
            while (!senha.equals(usuarioLogado.getSenha())) {
                System.out.print("Senha inválida! Por favor, digite novamente: ");
                senha = scanner.nextLine();
            }

            SistemaDeLogin.removerUsuario(cpfFormatted);
            usuarios.remove(usuarioEncontrado);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
