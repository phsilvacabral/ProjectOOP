package PJBL.GUI;

import PJBL.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListUser {
    private JFrame frame;
    private JTable table;
    private List<Usuario> usuarios;

    public ListUser(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        frame = new JFrame("Listar Usuários");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        String[] columnNames = {"Nome", "CPF", "Email", "Telefone", "Endereço", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Usuario usuario : usuarios) {
            Object[] o = new Object[6];
            o[0] = usuario.getNome();
            o[1] = usuario.getCpf();
            o[2] = usuario.getEmail();
            o[3] = usuario.getTelefone();
            o[4] = usuario.getEndereco();
            o[5] = usuario.getTipo();
            model.addRow(o);
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        frame.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> frame.dispose());
        frame.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}