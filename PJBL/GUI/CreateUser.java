package PJBL.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class CreateUser extends JFrame {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField emailField;
    private JTextField senhaField;
    private JTextField telefoneField;
    private JTextField enderecoField;
    private JComboBox<String> tipoBox;
    private JButton submitButton;
    private List<Usuario> usuarios;

    public CreateUser(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        setTitle("Criar Novo Usuário");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        nomeField = new JTextField();
        cpfField = new JTextField();
        emailField = new JTextField();
        senhaField = new JTextField();
        telefoneField = new JTextField();
        enderecoField = new JTextField();
        tipoBox = new JComboBox<>(new String[]{"A", "F"});
        submitButton = new JButton("Submit");

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Endereço:"));
        panel.add(enderecoField);
        panel.add(new JLabel("Tipo:"));
        panel.add(tipoBox);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String email = emailField.getText();
                String senha = senhaField.getText();
                String telefone = telefoneField.getText();
                String endereco = enderecoField.getText();
                String tipo = (String) tipoBox.getSelectedItem();

                if (!Verificador.verificarCPF(usuarios, cpf)) {
                    JOptionPane.showMessageDialog(null, "CPF inválido!");
                    return;
                }

                if (!Verificador.verificarEmail(usuarios, email)) {
                    JOptionPane.showMessageDialog(null, "Email inválido ou em uso!");
                    return;
                }

                if (!Verificador.verificarTelefone(telefone)) {
                    JOptionPane.showMessageDialog(null, "Telefone inválido!");
                    return;
                }

                // Aqui você pode adicionar o código para criar um novo usuário e salvá-lo
                // Por exemplo:
                // Usuario novoUsuario = new Administrador(id, nome, cpf, email, senha, telefone, endereco);
                // usuarios.add(novoUsuario);
                // SistemaDeLogin.salvarUsuario(novoUsuario);
            }
        });

        add(panel);
        setVisible(true);
    }
}