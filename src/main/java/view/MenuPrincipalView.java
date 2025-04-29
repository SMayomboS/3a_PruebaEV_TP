
package view;

import factory.GameFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalView extends JFrame {

    public MenuPrincipalView() {
        setTitle("Arcade Logic Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton nQueensButton = new JButton("N Reinas");
        JButton knightTourButton = new JButton("Tour del Caballo");
        JButton hanoiTowersButton = new JButton("Torres de Hanoi");

        nQueensButton.addActionListener(new GameButtonListener("N Reinas"));
        knightTourButton.addActionListener(new GameButtonListener("Tour del Caballo"));
        hanoiTowersButton.addActionListener(new GameButtonListener("Torres de Hanoi"));

        panel.add(new JLabel("Seleccione un juego:", SwingConstants.CENTER));
        panel.add(nQueensButton);
        panel.add(knightTourButton);
        panel.add(hanoiTowersButton);

        add(panel);
    }

    private class GameButtonListener implements ActionListener {
        private final String gameType;

        public GameButtonListener(String gameType) {
            this.gameType = gameType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GamePanel gamePanel = GameFactory.createGame(gameType);
            JFrame gameFrame = new JFrame(gameType);
            gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            gameFrame.setSize(600, 600);
            gameFrame.setLocationRelativeTo(null);
            gameFrame.add(gamePanel);
            gameFrame.setVisible(true);
            gamePanel.iniciarJuego();
            gamePanel.revalidate();
            gamePanel.repaint();
        }
    }
}