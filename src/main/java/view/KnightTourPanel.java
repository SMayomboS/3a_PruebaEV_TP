package view;

import javax.swing.*;
import java.awt.*;

public class KnightTourPanel extends GamePanel{
    private int n = 8;
    private int[][] board;
    private final int [] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int [] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    @Override
    public void iniciarJuego() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el tamaño del tablero (N):", "8");
        if (input != null) {
            try {
                n = Integer.parseInt(input);
                board = new int[n][n];
                for (int[] row : board)
                    java.util.Arrays.fill(row, -1);

                board[0][0] = 0;
                if (solveKnightTour(0, 0, 1)) {
                    repaint();
                    JOptionPane.showMessageDialog(this, "¡Recorrido completado!");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo completar el recorrido.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida.");
            }
        }
    }

    private boolean solveKnightTour(int x, int y, int moveCount){
        if (moveCount == n * n) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            if (isValid(nextX, nextY)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightTour(nextX, nextY, moveCount+1)) return true;
                board[nextX][nextY] = -1; // backtrack
            }
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == -1);
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
