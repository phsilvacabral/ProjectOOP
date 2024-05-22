package PJBL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static PJBL.SistemaDeLogin.autenticar;
import static PJBL.SistemaDeLogin.carregarUsuarios;

public class Main {
    public static void main(String[] args) throws LoginException {
        Scanner scanner = new Scanner(System.in);

        // Carregar usuários do arquivo
        List<Usuario> usuarios = carregarUsuarios();
        List<Veiculo> carro = new ArrayList<>();
        List<Aviao> aviao = new ArrayList<>();
        List<Embarcacao> embarcacao = new ArrayList<>();

        // Sistema de Login
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = autenticar(email, senha, usuarios);

        if (usuarioLogado != null) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado.getNome() + ".");
            System.out.println("Tipo de usuário: " + usuarioLogado.getTipo());

            if (usuarioLogado instanceof Administrador) {
                Administrador admin = (Administrador) usuarioLogado; // Cast para Administrador

                System.out.println("O que quer fazer como Administrador:");
                System.out.println("1-> Cadastrar Usuário");
                System.out.println("2-> Cadastrar Produto");
                System.out.println("3-> Sair");
                int escolha = Integer.parseInt(scanner.nextLine());
                if (escolha == 1) {
                    System.out.println("--Cadastro de Usuário--");
                    admin.criarNovoUsuario(scanner, usuarios);
                } else if (escolha == 2) {
                    System.out.println("--Cadastro de Produtos--");
                    admin.criarNovoProduto(scanner, carro, aviao, embarcacao);
                } else if (escolha == 3) {
                    System.out.println("Sair");
                } else {
                    System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Você é um funcionário.");
            }
        } else {
            System.out.println("Email ou senha incorretos.");
        }

        scanner.close();
    }
}
