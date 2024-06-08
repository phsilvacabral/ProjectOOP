package PJBL.GUI;

import PJBL.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuInterface {
    private JFrame frame;
    private Usuario usuarioLogado;
    private List<Usuario> usuarios;

    public MenuInterface(Usuario usuarioLogado, List<Usuario> usuarios) {
        this.usuarioLogado = usuarioLogado;
        this.usuarios = usuarios;

        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(6, 1));

        JButton createUserButton = new JButton("Criar novo usuário");
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateUser(usuarios);
            }
        });
        panel.add(createUserButton);

        JButton editUserButton = new JButton("Editar usuário");
        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditUser(usuarios);
            }
        });
        panel.add(editUserButton);

        JButton deleteUserButton = new JButton("Deletar usuário");
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteUser(usuarios);
            }
        });
        panel.add(deleteUserButton);

        JButton listUserButton = new JButton("Listar todos os usuários");
        listUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListUser(usuarios);
            }
        });
        panel.add(listUserButton);

        JButton registerProductButton = new JButton("Cadastrar Produto");
        registerProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação para cadastrar produto
            }
        });
        panel.add(registerProductButton);

        JButton loadProductsButton = new JButton("Carregar Produtos");
        loadProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação para carregar produtos
            }
        });
        panel.add(loadProductsButton);

        JButton editProductsButton = new JButton("Editar Produtos");
        editProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação para editar produtos
            }
        });
        panel.add(editProductsButton);

        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(exitButton);
    }
}