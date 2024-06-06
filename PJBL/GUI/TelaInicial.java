package PJBL.GUI;

import PJBL.GUI.LoginScreen;
import PJBL.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaInicial {
    private JFrame frame;

public TelaInicial(List<Usuario> usuarios) {
    frame = new JFrame("Tela Inicial");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel, usuarios);

    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    frame.setVisible(true);
}

    private void placeComponents(JPanel panel, List<Usuario> usuarios) {
        panel.setLayout(new GridLayout(2, 1));

        JButton loginButton = new JButton("Ir para tela de login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginScreen(usuarios);
                frame.dispose();
            }
        });
        panel.add(loginButton);

        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);
    }
}