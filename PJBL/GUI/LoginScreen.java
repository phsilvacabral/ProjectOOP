package PJBL.GUI;

import PJBL.SistemaDeLogin;
import PJBL.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginScreen {
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private List<Usuario> usuarios;

    public LoginScreen(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        frame = new JFrame("Login");
        frame.setSize(1550, 1050);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel userLabel = new JLabel("Email:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 20, 165, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                Usuario usuarioLogado = SistemaDeLogin.autenticar(email, password, usuarios);

                if (usuarioLogado != null) {
                    JOptionPane.showMessageDialog(frame, "Login bem-sucedido! Bem-vindo, " + usuarioLogado.getNome() + ".");
                    frame.dispose();
                    new MenuInterface(usuarioLogado, usuarios);
                } else {
                    JOptionPane.showMessageDialog(frame, "Email ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}