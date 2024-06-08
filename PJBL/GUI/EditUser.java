package PJBL.GUI;

import PJBL.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

public class EditUser {
    private JFrame frame;
    private JTextField cpfSearchField;
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JTextField telefoneField;
    private JTextField enderecoField;
    private JRadioButton adminButton;
    private JRadioButton funcionarioButton;
    private JButton submitButton;
    private JButton cancelButton;
    private List<Usuario> usuarios;
    private Usuario usuarioToEdit;

    public EditUser(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        frame = new JFrame("Editar Usuário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, usuarios);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, List<Usuario> usuarios) {
        panel.setLayout(new GridLayout(10, 2));

        JLabel cpfSearchLabel = new JLabel("CPF do usuário a editar:");
        cpfSearchField = new JTextField(20);
        panel.add(cpfSearchLabel);
        panel.add(cpfSearchField);
        cpfSearchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String cpf = cpfSearchField.getText().replaceAll("\\D", "");
                if (cpf.length() == 11) {
                    String cpfFormatted = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                    cpfSearchField.setText(cpfFormatted);
                    usuarioToEdit = findUserByCpf(cpfFormatted);
                    if (usuarioToEdit != null) {
                        fillFormWithUserData(usuarioToEdit);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Usuário não encontrado. Por favor, insira um CPF válido.");
                        cpfSearchField.setText("");
                        cpfSearchField.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "CPF inválido. Por favor, insira um CPF com 11 dígitos.");
                    cpfSearchField.setText("");
                    cpfSearchField.requestFocus();
                }
            }
        });

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);
        panel.add(nomeLabel);
        panel.add(nomeField);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(20);
        cpfField.setEnabled(false);
        panel.add(cpfLabel);
        panel.add(cpfField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);
        panel.add(senhaLabel);
        panel.add(senhaField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField(20);
        panel.add(telefoneLabel);
        panel.add(telefoneField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoField = new JTextField(20);
        panel.add(enderecoLabel);
        panel.add(enderecoField);

        JLabel tipoLabel = new JLabel("Tipo:");
        panel.add(tipoLabel);

        JPanel radioPanel = new JPanel();
        adminButton = new JRadioButton("Administrador");
        funcionarioButton = new JRadioButton("Funcionario");
        ButtonGroup group = new ButtonGroup();
        group.add(adminButton);
        group.add(funcionarioButton);
        radioPanel.add(adminButton);
        radioPanel.add(funcionarioButton);
        panel.add(radioPanel);

        submitButton = new JButton("Atualizar");
        submitButton.setBackground(Color.GREEN);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                String telefone = telefoneField.getText();
                String endereco = enderecoField.getText();
                String tipo = adminButton.isSelected() ? "Administrador" : "Funcionario";

                // Validação dos campos
                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Atualização do usuário
                usuarioToEdit.setNome(nome);
                usuarioToEdit.setEmail(email);
                usuarioToEdit.setSenha(senha);
                usuarioToEdit.setTelefone(telefone);
                usuarioToEdit.setEndereco(endereco);
                usuarioToEdit.setTipo(tipo);

                try {
                    SistemaDeLogin.atualizarUsuario(usuarioToEdit, cpfField.getText());
                    JOptionPane.showMessageDialog(frame, "Usuário atualizado com sucesso.");
                    frame.dispose();
                } catch (LoginException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(submitButton);

        cancelButton = new JButton("Cancelar");
        cancelButton.setBackground(Color.RED);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(cancelButton);
    }

    private Usuario findUserByCpf(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    private void fillFormWithUserData(Usuario usuario) {
        nomeField.setText(usuario.getNome());
        cpfField.setText(usuario.getCpf());
        emailField.setText(usuario.getEmail());
        senhaField.setText(usuario.getSenha());
        telefoneField.setText(usuario.getTelefone());
        enderecoField.setText(usuario.getEndereco());
        if (usuario.getTipo().equals("Administrador")) {
            adminButton.setSelected(true);
        } else {
            funcionarioButton.setSelected(true);
        }
    }
}