package view;

import controller.KnightTourFacade;

import javax.swing.*;
import java.awt.*;

public class KnightTourPanel extends GamePanel {

    private int n = 8;
    private int[][] board;
    private final KnightTourFacade facade = new KnightTourFacade();

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

                for (int[] fila : board)
                    java.util.Arrays.fill(fila, -1);

                board[0][0] = 0;  // primer movimiento
                boolean completo = facade.resolver(board, n);
                repaint();

                if (completo) {
                    JOptionPane.showMessageDialog(this, "¡Recorrido completado!");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo completar el recorrido.");
                }

                facade.guardarResultado(n, completo);
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
                    if (board[i][j] != -1) {
                        g.setColor(Color.BLUE);
                        g.drawString(Integer.toString(board[i][j]), j * size + size / 3, i * size + size / 2);
                    }
                }
            }
        }
    }
}
