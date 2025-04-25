package view;

import factory.GameFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalView  extends JFrame {
    public MenuPrincipalView() {
        setTitle("Maquina Arcade");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton nQueensButton = new JButton("N Reinas");
        JButton knightTourButton = new JButton("Tour del Caballo");
        JButton hanoiTowerButton = new JButton("Torre de Hanoi");

        nQueensButton.addActionListener(new GameButtonListener("N Reinas"));
        knightTourButton.addActionListener(new GameButtonListener("Tour del Caballo"));
        hanoiTowerButton.addActionListener(new GameButtonListener("Torre de Hanoi"));

        panel.add(new JLabel("Seleccione el juego que desea jugar:", SwingConstants.CENTER));
        panel.add(nQueensButton);
        panel.add(knightTourButton);
        panel.add(hanoiTowerButton);
        add(panel);
    }

    private class GameButtonListener implements ActionListener {
        private String gameType;

        public GameButtonListener(String gameType) {
            this.gameType = gameType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GamePanel gamePanel = GameFactory.createGame(gameType);
            JFrame gameFrame = new JFrame(gameType);
            gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            gameFrame.add(gamePanel);
            gameFrame.pack();
            gameFrame.setLocationRelativeTo(null);
            gameFrame.setVisible(true);
        }
    }
}