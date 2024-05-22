package PJBL;
import java.io.*;
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

        // Sistema de Login
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuarioLogado = autenticar(email, senha, usuarios);

        if (usuarioLogado != null) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado.getNome() + ".");
            System.out.println("Tipo de usuário: " + usuarioLogado.getTipo());

            if (usuarioLogado instanceof Administrador admin) {
                System.out.println("Você tem permissões de administrador.");
                System.out.println("1. Criar novo usuário");
                System.out.println("2. Sair");

                int escolha = Integer.parseInt(scanner.nextLine());
                if (escolha == 1) {
                    admin.criarNovoUsuario(scanner, usuarios);
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
