package PJBL;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static PJBL.SistemaDeLogin.autenticar;
import static PJBL.SistemaDeLogin.carregarUsuarios;

public class Main {
    public static void main(String[] args) throws LoginException {
        List<Usuario> usuarios = carregarUsuarios();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("--- BEM-VINDO ---");
                    System.out.println("1. Login");
                    System.out.println("2. Sair");
                    System.out.print("Escolha uma opção: ");

                    int opcao = Integer.parseInt(scanner.nextLine());
                    if (opcao == 1) {
                        login(scanner, usuarios);
                        break;
                    } else if (opcao == 2) {
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Por favor, digite um número válido.");
                }
            }
        }

    }

    public static void login(Scanner scanner, List<Usuario> usuarios) throws LoginException {
        while (true) {
            try {
                System.out.println("--- FAÇA SEU LOGIN ---");
                System.out.print("Digite seu email: ");
                String email = scanner.nextLine();
                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();

                Usuario usuarioLogado = autenticar(email, senha, usuarios);

                if (usuarioLogado != null) {
                    System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado.getNome() + ".");
                    menu(scanner, usuarioLogado, usuarios);
                    break;
                } else {
                    System.out.println("Email ou senha incorretos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número válido.");
            }
        }

    }

    public static void menu(Scanner scanner, Usuario usuarioLogado, List<Usuario> usuarios) throws LoginException {
        List<Veiculo> carro = new ArrayList<>();
        List<Aviao> aviao = new ArrayList<>();
        List<Embarcacao> embarcacao = new ArrayList<>();
        while (true) {
            try {
                if (usuarioLogado instanceof Administrador admin) {
                    System.out.println("--- MENU ADMINISTRADOR ---");
                    System.out.println("1. Criar novo usuário");
                    System.out.println("2. Cadastrar Produto");
                    System.out.println("3. Sair");

                    int escolha = Integer.parseInt(scanner.nextLine());
                    if (escolha == 1) {
                        System.out.println("--Cadastro de Usuário--");
                        admin.criarNovoUsuario(scanner, usuarios);
                    } else if (escolha == 2){
                        System.out.println("--Cadastro de Produtos--");
                        admin.criarNovoProduto(scanner, carro, aviao, embarcacao);
                    } else if (escolha == 3) {
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                } else {
                    System.out.println("--- MENU FUNCIONARIO ---");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número válido.");
            }
        }
    }
}

