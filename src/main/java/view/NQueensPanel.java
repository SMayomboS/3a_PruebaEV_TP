package view;

import controller.NQueensFacade;

import javax.swing.*;
import java.awt.*;

public class NQueensPanel extends GamePanel {

    private int n = 8;
    private int[][] board;
    private final NQueensFacade facade = new NQueensFacade();

    @Override
    public void iniciarJuego() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el tamaño del tablero (N):", "8");
        if (input != null) {
            try {
                n = Integer.parseInt(input);
                if (n < 1 || n > 20) {
                    JOptionPane.showMessageDialog(this, "Por favor ingrese un número entre 1 y 20.");
                    return;
                }
                board = new int[n][n];
                boolean solucion = facade.resolver(board, n);
                repaint();
                if (solucion) {
                    JOptionPane.showMessageDialog(this, "¡Solución encontrada!");
                } else {
                    JOptionPane.showMessageDialog(this, "No existe solución.");
                }
                facade.guardarResultado(n, solucion);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida.");
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (board != null) {
            int size = Math.min(getWidth(), getHeight()) / n;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g.setColor((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                    g.fillRect(j * size, i * size, size, size);
                    if (board[i][j] == 1) {
                        g.setColor(Color.RED);
                        g.fillOval(j * size + size / 4, i * size + size / 4, size / 2, size / 2);
                    }
                }
            }
        }
    }
}
